package de.fhkiel.library.search.implementation;

import de.fhkiel.library.search.Book;
import de.fhkiel.library.search.SearchParameter;

import javax.naming.TimeLimitExceededException;
import java.util.*;
import java.util.stream.Collectors;

public class ConcreteSearch implements de.fhkiel.library.search.Search {

  List<Book> books = new ArrayList<>();
  Map<SearchParameter, List<Book>> searchHistory = new HashMap<>();

  /** Constructor of {@link ConcreteSearch} */
  public ConcreteSearch() {
    // TODO SONARLINT: explain why this is empty
  }

  /**
   * Add {@link Book}s that should be searched. Can be called numerous times, adding the given
   * {@link Book}s.
   *
   * @param books the {@link Book}s to add
   */
  @Override
  public void addBooks(List<Book> books) {
    if (checkIfBookIdAlreadyExists(books) != -1) {
      throw new IllegalArgumentException(
          "Mehrere Bücher mit ID " + checkIfBookIdAlreadyExists(books));
    }
    if (checkForEqualIds(books) != -1) {
      throw new IllegalArgumentException("Mehrere Bücher mit ID " + checkForEqualIds(books));
    }
    this.books.addAll(books);
  }

  /**
   * Checks if some of the given {@link Book}s have the same id.
   *
   * @param books the {@link Book}s to check
   * @return true if the {@link Book}s have the same id
   */
  public int checkForEqualIds(List<Book> books) {
    for (Book book : books) {
      for (Book book1 : books) {
        if (book.id() == book1.id() && book != book1) {
          return book.id();
        }
      }
    }
    return -1;
  }

  /**
   * Checks if some of the given {@link Book}s already exist. compares every Book of the given list
   * to every element of the existing book list.
   *
   * @param books the {@link Book}s to check
   * @return true if the {@link Book}s already exist
   */
  public int checkIfBookIdAlreadyExists(List<Book> books) {
    for (Book book : books) {
      for (Book book1 : this.books) {
        if (book.id() == book1.id()) {
          return book.id();
        }
      }
    }
    return -1;
  }

  /**
   * Gets a book.
   *
   * @param id the {@link Book} id
   * @return the {@link Book} or null if no such {@link Book} exists
   */
  @Override
  public Book getBook(int id) {
    for (Book b : books) {
      if (b.id() == id) {
        return b;
      }
    }
    return null;
  }

  /**
   * Search for books.
   *
   * @param search the parameters for the search
   * @return the found {@link Book}s
   * @throws TimeLimitExceededException when search takes to long
   */
  @Override
  public List<Book> getBooks(SearchParameter search) throws TimeLimitExceededException {
    long startTime = System.currentTimeMillis();
    long maxSearchTime = 4;
    List<Book> foundBooks = new ArrayList<>();

    for (Book book : this.books) {
      //System.out.println("Searchtime: " + (System.currentTimeMillis() - startTime) + "ms");
      if (maxSearchTime > (System.currentTimeMillis() - startTime)) {
        if (matchesSearchCriteria(book, search)) {
          foundBooks.add(book);
        }
      } else throw new TimeLimitExceededException("Search took longer than 2 seconds");
    }
    searchHistory.put(search, foundBooks);
    return foundBooks;
  }

  private boolean matchesSearchCriteria(Book book, SearchParameter search) {
    // Check if book name matches search name or search doesn't have names
    boolean nameMatch = search.names() == null
            || search.names().isEmpty()
            || search.names().stream().anyMatch(name -> book.name().toLowerCase().contains(name.toLowerCase()));

    // Check if book author matches search author or search doesn't have authors
    boolean authorMatch = search.authors() == null
            || search.authors().isEmpty()
            || search.authors().stream().anyMatch(author -> book.authors().stream().anyMatch(a -> a.toLowerCase().contains(author.toLowerCase())));

    // Check if book keywords matches search keywords or search keywords is empty
    boolean keywordMatch = search.keywords() == null || search.keywords().isEmpty()
            || search.keywords().stream().anyMatch(keyword -> book.keywords().stream().anyMatch(k -> k.toLowerCase().contains(keyword.toLowerCase())));

    // check if book is borrowed status matches isBorrowed status of search
    boolean isBorrowedMatch;
    if (search.borrowed().isPresent()) {
      if (book.borrowedTill().isPresent() && search.borrowed().isPresent() && search.borrowed().get()) {
        isBorrowedMatch = true;
      } else isBorrowedMatch = book.borrowedTill().isEmpty() && !search.borrowed().get();
    } else {
      isBorrowedMatch = true;
    }

    // check if borrowed till is before borrowed after
    boolean borrowedTillIsAfterBorrowedAfter = search.borrowedAfter() == null
            || book.borrowedTill().map(till -> till.isAfter(search.borrowedAfter())).orElse(false);

    // check if search boughtBefore is before book was bought
    boolean bookIsBoughtBeforeSearchBought = search.boughtBefore() == null
            || book.bought().isBefore(search.boughtBefore());

    // check if search boughtAfter is before book was bought
    boolean bookIsBoughtAfterSearchBought = search.boughtAfter() == null
            || book.bought().isAfter(search.boughtAfter());

    boolean searchMinBorrowedTimesIsEqualOrLessThanBookTimesBorrowed = search.minTimesBorrowed() == 0
            || search.minTimesBorrowed() <= book.timesBorrowed();

    boolean searchMaxBorrowedTimesIsEqualOrHigherThanBookTimesBorrowed = search.maxTimesBorrowed() == 0
            || search.maxTimesBorrowed() >= book.timesBorrowed();

    boolean checkIfConditionsMatches = search.acceptableConditions() == null
            || search.acceptableConditions().isEmpty()
            || search.acceptableConditions().contains(book.condition());

    return authorMatch
        && keywordMatch
        && nameMatch
        && isBorrowedMatch
        && borrowedTillIsAfterBorrowedAfter
        && bookIsBoughtBeforeSearchBought
        && bookIsBoughtAfterSearchBought
        && searchMaxBorrowedTimesIsEqualOrHigherThanBookTimesBorrowed
        && searchMinBorrowedTimesIsEqualOrLessThanBookTimesBorrowed
        && checkIfConditionsMatches;
  }

  /**
   * Gets a {@link SearchParameter.Builder} for the {@link SearchParameter}.
   *
   * @return the {@link SearchParameter.Builder}
   */
  @Override
  public SearchParameter.Builder createSearchParameter() {
    return new ConcreteSearchParameter.Builder();
  }

  /**
   * Returns the unordered history of this search object.
   *
   * @return the {@link Map} of {@link SearchParameter}s to Results
   */
  @Override
  public Map<SearchParameter, List<Book>> history() {
    return searchHistory;
  }

  /**
   * returns the books without searchParameter
   * @return the books
   */
  public List<Book> getBooks() {
    return books;
  }
}
