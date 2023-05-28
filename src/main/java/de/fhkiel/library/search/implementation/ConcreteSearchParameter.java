package de.fhkiel.library.search.implementation;

import de.fhkiel.library.search.Condition;
import de.fhkiel.library.search.SearchParameter;

import java.time.LocalDate;
import java.util.*;

public class ConcreteSearchParameter implements SearchParameter, SearchParameter.Builder{

    private List<String> names = new ArrayList<>();
    private List<String> authors = new ArrayList<>();
    private List<String> keywords = new ArrayList<>();
    Optional<Boolean> isBorrowed = Optional.empty();

    private LocalDate borrowedAfterDate;
    private LocalDate boughtAfterDate;
    private LocalDate boughtBeforeDate;

    private int minBorrowCount;
    private int maxBorrowCount;

    private final List<Condition> conditionList = List.of();

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
     * Add names to search for.
     *
     * @param name the names as a vararg
     * @return the builder
     */


    @Override
    public Builder addNamesToSearch(String... name) {
        this.names.addAll(Arrays.asList(name));
        return this;
    }

    /**
     * Add authors to search for.
     *
     * @param author the authors as a vararg
     * @return the builder
     */
    @Override
    public Builder addAuthorsToSearch(String... author) {
        this.authors.addAll(Arrays.asList(author));
        return this;
    }

    /**
     * Add keywords to search for.
     *
     * @param keyword the keywords as a vararg
     * @return the builder
     */
    @Override
    public Builder addKeywordsToSearch(String... keyword) {
        this.keywords.addAll(Arrays.asList(keyword));
        return this;
    }

    /**
     * Is the book borrowed now.
     *
     * @param borrowed the borrowed state
     * @return the builder
     */
    @Override
    public Builder bookIsBorrowedNow(boolean borrowed) {
        this.isBorrowed = Optional.of(borrowed);
        return this;
    }

    /**
     * Book is borrowed after.
     *
     * @param date the date
     * @return the builder
     */
    @Override
    public Builder bookIsBorrowedAfter(LocalDate date) {
        this.borrowedAfterDate = date;
        return this;
    }

    /**
     * Book was bought after.
     *
     * @param date the date
     * @return the builder
     */
    @Override
    public Builder bookWasBoughtAfter(LocalDate date) {
        this.boughtAfterDate = date;
        return this;
    }

    /**
     * Book was bought before.
     *
     * @param date the date
     * @return the builder
     */
    @Override
    public Builder bookWasBoughtBefore(LocalDate date) {
        this.boughtBeforeDate = date;
        return this;
    }

    /**
     * Book was borrowed at least this many times.
     *
     * @param min the min times borrowed
     * @return the builder
     */
    @Override
    public Builder bookWasBorrowedAtLeastTimes(int min) {
       this.minBorrowCount = min;
       return  this;
    }

    /**
     * Book was borrowed at most this many times.
     *
     * @param max the max times borrowed
     * @return the builder
     */
    @Override
    public Builder bookWasBorrowedAtMostTimes(int max) {
        this.maxBorrowCount = max;
        return this;
    }

    /**
     * Acceptable conditions the books can be in.
     *
     * @param condition the conditions as a vararg
     * @return the builder
     */
    @Override
    public Builder acceptableConditions(Condition... condition) {
        conditionList.addAll(Arrays.asList(condition));
        return this;
    }

    /**
     * Create the {@link SearchParameter} for the search.
     *
     * @return the search parameter
     */
    @Override
    public SearchParameter createParameterForSearch() {
        return this;
    }
}
