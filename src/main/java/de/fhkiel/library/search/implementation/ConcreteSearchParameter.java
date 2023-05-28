package de.fhkiel.library.search.implementation;

import de.fhkiel.library.search.Condition;
import de.fhkiel.library.search.SearchParameter;

import java.time.LocalDate;
import java.util.*;

public class ConcreteSearchParameter implements SearchParameter {

    private final List<String> names;
    private final List<String> authors;
    private final List<String> keywords;
    Optional<Boolean> isBorrowed;


    private final LocalDate borrowedAfterDate;
    private final LocalDate boughtAfterDate;
    private final LocalDate boughtBeforeDate;

    private final int minBorrowCount;
    private final int maxBorrowCount;

    private final List<Condition> conditionList;


    private ConcreteSearchParameter(List<String> names, List<String> authors, List<String> keywords, Optional<Boolean> borrowed,
                                   LocalDate borrowedAfter, LocalDate boughtAfter, LocalDate boughtBefore,
                                   int minTimesBorrowed, int maxTimesBorrowed, List<Condition> acceptableConditions) {
        this.names = names;
        this.authors = authors;
        this.keywords = keywords;
        this.isBorrowed = borrowed;
        this.borrowedAfterDate = borrowedAfter;
        this.boughtAfterDate = boughtAfter;
        this.boughtBeforeDate = boughtBefore;
        this.minBorrowCount = minTimesBorrowed;
        this.maxBorrowCount = maxTimesBorrowed;
        this.conditionList = acceptableConditions;
    }

    /**
     * A list of names to search for.
     *
     * @return the list of names
     */
    @Override
    public List<String> names() {
        return this.names;
    }

    /**
     * A list of authors to search for.
     *
     * @return the list of authors
     */
    @Override
    public List<String> authors() {
        return this.authors;
    }

    /**
     * A list of keywords to search for.
     *
     * @return the list of keywords
     */
    @Override
    public List<String> keywords() {
        return this.keywords;
    }

    /**
     * If a book is borrowed.
     *
     * @return the borrowed-state or an empty Optional to discard this option
     */
    @Override
    public Optional<Boolean> borrowed() {
        return this.isBorrowed;
    }

    /**
     * If a book is borrowed after this date.
     *
     * @return the date
     */
    @Override
    public LocalDate borrowedAfter() {
        return this.borrowedAfterDate;
    }

    /**
     * Bought after this date.
     *
     * @return the date
     */
    @Override
    public LocalDate boughtAfter() {
        return this.boughtAfterDate;
    }

    /**
     * Bought before this date.
     *
     * @return the date
     */
    @Override
    public LocalDate boughtBefore() {
        return this.boughtBeforeDate;
    }

    /**
     * Min times borrowed.
     *
     * @return the min number of times
     */
    @Override
    public int minTimesBorrowed() {
        return this.minBorrowCount;
    }

    /**
     * Max times borrowed.
     *
     * @return the max number of times
     */
    @Override
    public int maxTimesBorrowed() {
        return this.maxBorrowCount;
    }

    /**
     * A list of acceptable conditions.
     *
     * @return the acceptable conditions
     */
    @Override
    public List<Condition> acceptableConditions() {
        return this.conditionList;
    }

    /**
     * Create the {@link SearchParameter} for the search.
     *
     * @return the search parameter
     */
    SearchParameter createParameterForSearch() {
        return this; // hier werden die SearchParameter erstellt, wird dann wahrscheinlich an ConcreteSearchBuilder übergeben
    }

}
