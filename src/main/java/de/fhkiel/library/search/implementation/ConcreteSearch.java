package de.fhkiel.library.search.implementation;

import de.fhkiel.library.search.Book;
import de.fhkiel.library.search.Condition;
import de.fhkiel.library.search.SearchParameter;

import javax.naming.TimeLimitExceededException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ConcreteSearch implements  de.fhkiel.library.search.Search {


    List<Book> search = new ArrayList<>();

    List<Book> searchHistory = new ArrayList<>();


    /**
     * Add {@link Book}s that should be searched.
     * Can be called numerous times, adding the given {@link Book}s.
     *
     * @param books the {@link Book}s to add
     */
    @Override
    public void addBooks(List<Book> books) {
        search.addAll(books);
    }

    /**
     * Gets a book.
     *
     * @param id the {@link Book} id
     * @return the {@link Book} or null if no such {@link Book} exists
     */
    @Override
    public Book getBook(int id) {
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

        long startTime = System.currentTimeMillis();
        long elapsedTime = System.currentTimeMillis() - startTime;
        for (Book book : this.search) {
            //
        }
        if (elapsedTime > 2000) {
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
        //return new ConcreteSearchParameter.Builder();
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
