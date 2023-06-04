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

    public ConcreteSearchParameter(List<String> names, List<String> authors, List<String> keywords, Optional<Boolean> borrowed,
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

    @Override
    public String toString() {
        return "ConcreteSearchParameter{" +
                "names=" + names +
                ", authors=" + authors +
                ", keywords=" + keywords +
                ", isBorrowed=" + isBorrowed +
                ", borrowedAfterDate=" + borrowedAfterDate +
                ", boughtAfterDate=" + boughtAfterDate +
                ", boughtBeforeDate=" + boughtBeforeDate +
                ", minBorrowCount=" + minBorrowCount +
                ", maxBorrowCount=" + maxBorrowCount +
                ", conditionList=" + conditionList +
                '}';
    }

    /**
     * Create the {@link SearchParameter} for the search.
     *
     * @return the search parameter
     */

    public static class Builder implements SearchParameter.Builder {

        private List<String> names;
        private List<String> authors;
        private List<String> keywords;
        Optional<Boolean> isBorrowed = Optional.empty();
        private LocalDate borrowedAfterDate;
        private LocalDate boughtAfterDate;
        private LocalDate boughtBeforeDate;
        private int minBorrowCount;
        private int maxBorrowCount;
        private List<Condition> conditionList;

        public Builder() { /* TODO document why this constructor is empty */ }

        /**
         * Add names to search for.
         *
         * @param name the names as a vararg
         * @return the builder
         */
        @Override
        public ConcreteSearchParameter.Builder addNamesToSearch(String... name) {
            if (this.names == null) {
                this.names = new ArrayList<>();
            }
            this.names.addAll(List.of(name));
            return this;
        }

        /**
         * Add authors to search for.
         *
         * @param author the authors as a vararg
         * @return the builder
         */
        @Override
        public ConcreteSearchParameter.Builder addAuthorsToSearch(String... author) {
            if (this.authors == null) {
                this.authors = new ArrayList<>();
            }
            this.authors.addAll(List.of(author));
            return this;
        }

        /**
         * Add keywords to search for.
         *
         * @param keyword the keywords as a vararg
         * @return the builder
         */
        @Override
        public ConcreteSearchParameter.Builder addKeywordsToSearch(String... keyword) {
            if (this.keywords == null) {
                this.keywords = new ArrayList<>();
            }
            this.keywords.addAll(List.of(keyword));
            return this;
        }

        /**
         * Is the book borrowed now.
         *
         * @param borrowed the borrowed state
         * @return the builder
         */
        @Override
        public ConcreteSearchParameter.Builder bookIsBorrowedNow(boolean borrowed) {
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
        public ConcreteSearchParameter.Builder bookIsBorrowedAfter(LocalDate date) {
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
        public ConcreteSearchParameter.Builder bookWasBoughtAfter(LocalDate date) {
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
        public ConcreteSearchParameter.Builder bookWasBoughtBefore(LocalDate date) {
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
        public ConcreteSearchParameter.Builder bookWasBorrowedAtLeastTimes(int min) {
            this.minBorrowCount = min;
            return this;
        }

        /**
         * Book was borrowed at most this many times.
         *
         * @param max the max times borrowed
         * @return the builder
         */
        @Override
        public ConcreteSearchParameter.Builder bookWasBorrowedAtMostTimes(int max) {
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
        public ConcreteSearchParameter.Builder acceptableConditions(Condition... condition) {
            if (this.conditionList == null) {
                this.conditionList = new ArrayList<>();
            }
            this.conditionList.addAll(List.of(condition));
            return this;
        }

        /**
         * Create the {@link ConcreteSearchParameter} for the search.
         *
         * @return the search parameter
         */
        @Override
        public ConcreteSearchParameter createParameterForSearch() {
            return new ConcreteSearchParameter(
                names,
                authors,
                keywords,
                isBorrowed,
                borrowedAfterDate,
                boughtAfterDate,
                boughtBeforeDate,
                minBorrowCount,
                maxBorrowCount,
                conditionList);
        }
    }

}
