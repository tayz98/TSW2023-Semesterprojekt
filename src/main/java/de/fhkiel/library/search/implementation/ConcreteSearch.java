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
    public List<Book> getBooks(SearchParameter search) {
        return this.books;
        /*
        List<Book> foundBooks = new ArrayList<>();
        // TODO: jedes Buch überprüfen mit Suchparameter
        while (2000 > System.currentTimeMillis()) {
            for (Book book : this.books) {
                for (String name : search.names()) {
                    if (Objects.equals(book.name(), name)) {
                        foundBooks.add(book);
                        break;
                    }
                }
            }
            searchHistory.put(search, foundBooks);
            return foundBooks;
        } throw new TimeLimitExceededException("Search took longer than 2 seconds");

         */
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