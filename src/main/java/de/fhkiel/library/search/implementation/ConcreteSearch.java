package de.fhkiel.library.search.implementation;

import de.fhkiel.library.search.Book;
import de.fhkiel.library.search.SearchParameter;

import javax.naming.TimeLimitExceededException;
import java.util.*;

public class ConcreteSearch implements  de.fhkiel.library.search.Search {


    List<Book> search;

    long maxSearchTime = 2000; // 2000ms = 2s
    SearchParameter searchParameter;

    Map<SearchParameter, List<Book>> searchHistory;

    public ConcreteSearch(List<Book> books) {
        if (books == null) throw new IllegalArgumentException();
        if (books.isEmpty()) throw new IllegalArgumentException();
        this.search = books;
        this.searchHistory = new HashMap<>();

    }


    /**
     * Add {@link Book}s that should be searched.
     * Can be called numerous times, adding the given {@link Book}s.
     *
     * @param books the {@link Book}s to add
     */
    @Override
    public void addBooks(List<Book> books) {
        search.addAll(books); // 2.d)
    }

    /**
     * Gets a book.
     *
     * @param id the {@link Book} id
     * @return the {@link Book} or null if no such {@link Book} exists
     */
    @Override
    public Book getBook(int id) { // 2.e)
        for (Book b : search) {
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
        // 2.f) und 2.i)
        this.searchParameter = search;
        long startTime = System.currentTimeMillis();
        long elapsedTime = System.currentTimeMillis() - startTime;
        for (Book book : this.search) {
            // TODO Suchlogik impelementieren
        }
        if (elapsedTime >= maxSearchTime) {
            throw new TimeLimitExceededException("Suche hat länger als 2 Sekunden gedauert");
        }
        return null;
    }

    /**
     * Gets a {@link SearchParameter.Builder} for the {@link SearchParameter}.
     *
     * @return the {@link SearchParameter.Builder}
     */
    @Override
    public SearchParameter.Builder createSearchParameter() {

        return null;
    }

    /**
     * Returns the unordered history of this search object.
     *
     * @return the {@link Map} of {@link SearchParameter}s to Results
     */
    @Override
    public Map<SearchParameter, List<Book>> history() {
        return null;
    }
}