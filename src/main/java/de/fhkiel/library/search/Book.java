package de.fhkiel.library.search;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * The interface Book.
 */
public interface Book {
  /**
   * The book id.
   * Must be Unique.
   *
   * @return the id
   */
  int id();

  /**
   * The name of the book.
   *
   * @return the name
   */
  String name();

  /**
   * The {@link List} of authors.
   *
   * @return the authers
   */
  List<String> authors();

  /**
   * A list of keywords.
   *
   * @return the keywords
   */
  List<String> keywords();

  /**
   * An {@link Optional} containing the date a book is due to be returned.
   * Can be empty if a book is not borrowed.
   *
   * @return the optional date
   */
  Optional<LocalDate> borrowedTill();

  /**
   * The {@link LocalDate} a book was bought.
   *
   * @return the date
   */
  LocalDate bought();

  /**
   * A counter how many times a book has been borrowed.
   *
   * @return the counter
   */
  int timesBorrowed();

  /**
   * The {@link Condition} of the book.
   *
   * @return the {@link Condition}
   */
  Condition condition();
}
