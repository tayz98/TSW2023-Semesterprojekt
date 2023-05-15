package de.fhkiel.library.search;

import java.util.List;
import java.util.Map;
import javax.naming.TimeLimitExceededException;

/**
 * The interface Search.
 * Acts as the primary point of use.
 */
public interface Search {
  /**
   * Add {@link Book}s that should be searched.
   * Can be called numerous times, adding the given {@link Book}s.
   *
   * @param books the {@link Book}s to add
   */
  void addBooks(List<Book> books);

  /**
   * Gets a book.
   *
   * @param id the {@link Book} id
   * @return the {@link Book} or null if no such {@link Book} exists
   */
  Book getBook(int id);

  /**
   * Search for books.
   *
   * @param search the parameters for the search
   * @return the found {@link Book}s
   * @throws TimeLimitExceededException when search takes to long
   */
  List<Book> getBooks(SearchParameter search) throws TimeLimitExceededException;

  /**
   * Gets a {@link SearchParameter.Builder} for the {@link SearchParameter}.
   *
   * @return the {@link SearchParameter.Builder}
   */
  SearchParameter.Builder createSearchParameter();

  /**
   * Returns the unordered history of this search object.
   *
   * @return the {@link Map} of {@link SearchParameter}s to Results
   */
  Map<SearchParameter, List<Book>> history();
}
