package de.fhkiel.library.search.implementation;

import de.fhkiel.library.search.Book;
import de.fhkiel.library.search.SearchParameter;
import javax.naming.TimeLimitExceededException;
import java.util.*;

public class ConcreteSearch implements de.fhkiel.library.search.Search {

  List<Book> books = new ArrayList<>();
  Map<SearchParameter, List<Book>> searchHistory = new HashMap<>();

  /** Constructor of {@link ConcreteSearch} */
  public ConcreteSearch() {
    // empty constructor because books are added via addBooks etc.
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
      if (maxSearchTime > (System.currentTimeMillis() - startTime)) {
        if (matchesSearchCriteria(book, search)) {
          foundBooks.add(book);
        }
      } else throw new TimeLimitExceededException("Search took longer than 2 seconds");
    }
    searchHistory.put(search, foundBooks);
    return foundBooks;
  }

  /**
   * checks if the {@link Book} matches with the {@link SearchParameter}.
   * @param book the {@link Book} to check
   * @param search the {@link SearchParameter} to check
   * @return true if the {@link Book} matches
   */
  private boolean matchesSearchCriteria(Book book, SearchParameter search) {
    return nameMatch(book, search)
        && authorMatch(book, search)
        && keywordMatch(book, search)
        && borrowedMatch(book, search)
        && borrowedTillIsAfterMatch(book, search)
        && boughtBeforeMatch(book, search)
        && boughtAfterMatch(book, search)
        && minBorrowedMatch(book, search)
        && maxBorrowedMatch(book, search)
        && conditionsMatch(book, search);
  }

  /**
   * Checks if the name of the {@link Book} matches one of the names in the {@link SearchParameter}.
   * @param book the {@link Book} to check
   * @param search the {@link SearchParameter} to check
   * @return true if the name matches
   */
  private boolean nameMatch(Book book, SearchParameter search) {
    return search.names() == null
            || search.names().isEmpty()
            || search.names().stream().anyMatch(name -> book.name().toLowerCase().contains(name.toLowerCase()));
  }

  /**
   * Checks if the author of the {@link Book} matches one of the authors in the {@link SearchParameter}.
   * @param book the {@link Book} to check
   * @param search the {@link SearchParameter} to check
   * @return true if the author matches
   */
  private boolean authorMatch(Book book, SearchParameter search) {
    return search.authors() == null
            || search.authors().isEmpty()
            || search.authors().stream().anyMatch(author -> book.authors().stream().anyMatch(a -> a.toLowerCase().contains(author.toLowerCase())));
  }

  /**
   * Checks if the keywords of the {@link Book} matches one of the keywords in the {@link SearchParameter}.
   * @param book the {@link Book} to check
   * @param search the {@link SearchParameter} to check
   * @return true if the keywords matches
   */
  private boolean keywordMatch(Book book, SearchParameter search) {
    return search.keywords() == null || search.keywords().isEmpty()
            || search.keywords().stream().anyMatch(keyword -> book.keywords().stream().anyMatch(k -> k.toLowerCase().contains(keyword.toLowerCase())));
  }

  /**
   * Checks if the borrowed status of the {@link Book} matches the borrowed status in the {@link SearchParameter}.
   * @param book the {@link Book} to check
   * @param search the {@link SearchParameter} to check
   * @return true if the borrowed status matches
   */
  private boolean borrowedMatch(Book book, SearchParameter search) {
    boolean isBorrowedMatch;
    if (search.borrowed().isPresent()) {
      if (book.borrowedTill().isPresent() && search.borrowed().isPresent() && search.borrowed().orElse(false)) {
        isBorrowedMatch = true;
      } else isBorrowedMatch = book.borrowedTill().isEmpty() && !search.borrowed().orElse(false);
    } else {
      isBorrowedMatch = true;
    }
    return isBorrowedMatch;
  }

  /**
   * Checks if the borrowed till of the {@link Book} is after the borrowed after in the {@link SearchParameter}.
   * @param book the {@link Book} to check
   * @param search the {@link SearchParameter} to check
   * @return true if the borrowed till is after the borrowed after
   */
  private boolean borrowedTillIsAfterMatch(Book book, SearchParameter search) {
    return search.borrowedAfter() == null
            || book.borrowedTill().map(till -> till.isAfter(search.borrowedAfter())).orElse(false);
  }

  /**
   * Checks if the bought date of the {@link Book} is before the bought before in the {@link SearchParameter}.
   * @param book the {@link Book} to check
   * @param search the {@link SearchParameter} to check
   * @return true if the bought date is before the bought before
   */
  private boolean boughtBeforeMatch(Book book, SearchParameter search) {
    return search.boughtBefore() == null
            || book.bought().isBefore(search.boughtBefore());
  }

  /**
   * Checks if the bought date of the {@link Book} is after the bought after in the {@link SearchParameter}.
   * @param book the {@link Book} to check
   * @param search the {@link SearchParameter} to check
   * @return true if the bought date is after the bought after
   */
  private boolean boughtAfterMatch(Book book, SearchParameter search) {
    return search.boughtAfter() == null
            || book.bought().isAfter(search.boughtAfter());
  }

  /**
   * Checks if the times borrowed of the {@link Book} is higher than the min times borrowed in the {@link SearchParameter}.
   * @param book the {@link Book} to check
   * @param search the {@link SearchParameter} to check
   * @return true if the times borrowed is higher than the min times borrowed
   */
  private boolean minBorrowedMatch(Book book, SearchParameter search) {
    return search.minTimesBorrowed() == 0
            || search.minTimesBorrowed() <= book.timesBorrowed();
  }

  /**
   * Checks if the times borrowed of the {@link Book} is lower than the max times borrowed in the {@link SearchParameter}.
   * @param book the {@link Book} to check
   * @param search the {@link SearchParameter} to check
   * @return true if the times borrowed is lower than the max times borrowed
   */
  private boolean maxBorrowedMatch(Book book, SearchParameter search) {
    return search.maxTimesBorrowed() == 0
            || search.maxTimesBorrowed() >= book.timesBorrowed();
  }

  /**
   * Checks if the condition of the {@link Book} is in the acceptable conditions in the {@link SearchParameter}.
   * @param book the {@link Book} to check
   * @param search the {@link SearchParameter} to check
   * @return true if the condition is in the acceptable conditions
   */
  private boolean conditionsMatch(Book book, SearchParameter search) {
    return search.acceptableConditions() == null
            || search.acceptableConditions().isEmpty()
            || search.acceptableConditions().contains(book.condition());
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
