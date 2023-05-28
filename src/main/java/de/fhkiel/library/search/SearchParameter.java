package de.fhkiel.library.search;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * The interface  for search parameters.
 */
public interface SearchParameter {

  /**
   * A list of names to search for.
   *
   * @return the list of names
   */
  List<String> names();

  /**
   * A list of authors to search for.
   *
   * @return the list of authors
   */
  List<String> authors();

  /**
   * A list of keywords to search for.
   *
   * @return the list of keywords
   */
  List<String> keywords();

  /**
   * If a book is borrowed.
   *
   * @return the borrowed-state or an empty Optional to discard this option
   */
  Optional<Boolean> borrowed();

  /**
   * If a book is borrowed after this date.
   *
   * @return the date
   */
  LocalDate borrowedAfter();

  /**
   * Bought after this date.
   *
   * @return the date
   */
  LocalDate boughtAfter();

  /**
   * Bought before this date.
   *
   * @return the date
   */
  LocalDate boughtBefore();

  /**
   * Min times borrowed.
   *
   * @return the min number of times
   */
  int minTimesBorrowed();

  /**
   * Max times borrowed.
   *
   * @return the max number of times
   */
  int maxTimesBorrowed();

  /**
   * A list of acceptable conditions.
   *
   * @return the acceptable conditions
   */
  List<Condition> acceptableConditions();

  /**
   * The de.fhkiel.library.search.Builder interface to create a search parameter.
   * <a href="https://refactoring.guru/design-patterns/builder">Pattern</a>
   */
  interface Builder {
    /**
     * Add names to search for.
     *
     * @param name the names as a vararg
     * @return the builder
     */
    Builder addNamesToSearch(String... name);

    /**
     * Add authors to search for.
     *
     * @param author the authors as a vararg
     * @return the builder
     */
    Builder addAuthorsToSearch(String... author);

    /**
     * Add keywords to search for.
     *
     * @param keyword the keywords as a vararg
     * @return the builder
     */
    Builder addKeywordsToSearch(String... keyword);

    /**
     * Is the book borrowed now.
     *
     * @param borrowed the borrowed state
     * @return the builder
     */
    Builder bookIsBorrowedNow(boolean borrowed);

    /**
     * Book is borrowed after.
     *
     * @param date the date
     * @return the builder
     */
    Builder bookIsBorrowedAfter(LocalDate date);

    /**
     * Book was bought after.
     *
     * @param date the date
     * @return the builder
     */
    Builder bookWasBoughtAfter(LocalDate date);

    /**
     * Book was bought before.
     *
     * @param date the date
     * @return the builder
     */
    Builder bookWasBoughtBefore(LocalDate date);

    /**
     * Book was borrowed at least this many times.
     *
     * @param min the min times borrowed
     * @return the builder
     */
    Builder bookWasBorrowedAtLeastTimes(int min);

    /**
     * Book was borrowed at most this many times.
     *
     * @param max the max times borrowed
     * @return the builder
     */
    Builder bookWasBorrowedAtMostTimes(int max);

    /**
     * Acceptable conditions the books can be in.
     *
     * @param condition the conditions as a vararg
     * @return the builder
     */
    Builder acceptableConditions(Condition... condition);

    /**
     * Create the {@link SearchParameter} for the search.
     *
     * @return the search parameter
     */
    SearchParameter createParameterForSearch();
  }
}
