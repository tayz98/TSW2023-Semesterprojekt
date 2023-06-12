package de.fhkiel.library.search.implementation;

import de.fhkiel.library.search.Book;
import de.fhkiel.library.search.SearchParameter;

import javax.naming.TimeLimitExceededException;
import java.util.*;

public class ConcreteSearch implements  de.fhkiel.library.search.Search {

    List<Book> books = new ArrayList<>();
    Map<SearchParameter, List<Book>> searchHistory = new HashMap<>();


    /**
     * Constructor of {@link ConcreteSearch}
     */
    public ConcreteSearch() {}

    /**
     * Add {@link Book}s that should be searched.
     * Can be called numerous times, adding the given {@link Book}s.
     *
     * @param books the {@link Book}s to add
     */
    @Override
    public void addBooks(List<Book> books) {
        if (checkIfBookIdAlreadyExists(books) != -1) {
            throw new IllegalArgumentException("Mehrere Bücher mit ID " + checkIfBookIdAlreadyExists(books));
        }
        if (checkForEqualsIds(books) != -1) {
            throw new IllegalArgumentException("Mehrere Bücher mit ID " + checkForEqualsIds(books));
        }
        this.books.addAll(books);
    }

    /**
     * Checks if some of the given {@link Book}s have the same id.
     *
     * @param books the {@link Book}s to check
     * @return true if the {@link Book}s have the same id
     */
    public int checkForEqualsIds(List<Book> books) {
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
     * Checks if some of the given {@link Book}s already exist.
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
        List<Book> foundBooks = new ArrayList<>();

        for (Book book : this.books) {
            if (matchesSearchCriteria(book, search)) {
                foundBooks.add(book);
            }

            if (System.currentTimeMillis() - startTime > 2000) {
                throw new TimeLimitExceededException("Search took longer than 2 seconds");
            }
        }

        searchHistory.put(search, foundBooks);
        return foundBooks;
    }

    private boolean matchesSearchCriteria(Book book, SearchParameter search) {
        // Check if book name matches search name
        if (search.names() != null && !search.names().isEmpty()) {
            if (!search.names().contains(book.name())) {
                return false;
            }
        }

        // Check if book author matches search author
        if (search.authors() != null && !search.authors().isEmpty()) {
            boolean authorMatch = false;
            for (String author : search.authors()) {
                if (book.authors().contains(author)) {
                    authorMatch = true;
                    break;
                }
            }
            if (!authorMatch) {
                return false;
            }
        }

        // Check if book keywords matches search keywords
        if (search.keywords() != null && !search.keywords().isEmpty()) {
            boolean keywordMatch = false;
            for (String keyword : search.keywords()) {
                if (book.keywords().contains(keyword)) {
                    keywordMatch = true;
                    break;
                }
            }
            if (!keywordMatch) {
                return false;
            }
        }

        // Check if book is borrowed
        if (search.borrowed().isPresent()) {
            // TODO
        }

        if (search.borrowedAfter() != null && book.borrowedTill().isPresent()) {
            if (book.borrowedTill().get().isBefore(search.borrowedAfter())) {
                return false;
            }
        }

        // Checks if book is bought after search boughtAfter
        if (search.borrowedAfter() != null && book.bought().isBefore(search.boughtAfter())) {
            return false;
        }

        // Checks if book is bought before search boughtBefore
        if (search.boughtBefore() != null && book.bought().isAfter(search.boughtBefore())) {
            return false;
        }

        // Check of book got borrowed more than minTimesBorrowed
        if (search.minTimesBorrowed() > book.timesBorrowed()) {
            return false;
        }

        // Check of book got borrowed less than maxTimesBorrowed
        if (search.maxTimesBorrowed() > 0 && search.maxTimesBorrowed() < book.timesBorrowed()) {
            return false;
        }

        // Check if book matches condition
        if (search.acceptableConditions() != null && !search.acceptableConditions().isEmpty()) {
            if (!search.acceptableConditions().contains(book.condition())) {
                return false;
            }
        }

        return true;
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
}