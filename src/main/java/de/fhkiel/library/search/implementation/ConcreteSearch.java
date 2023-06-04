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
    public ConcreteSearch() {
        // TODO document why this constructor is empty
    }

    /**
     * Add {@link Book}s that should be searched.
     * Can be called numerous times, adding the given {@link Book}s.
     *
     * @param books the {@link Book}s to add
     */
    @Override
    public void addBooks(List<Book> books) {
        this.books.addAll(books); // 2.d)
    }

    /**
     * Gets a book.
     *
     * @param id the {@link Book} id
     * @return the {@link Book} or null if no such {@link Book} exists
     */
    @Override
    public Book getBook(int id) { // 2.e)
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