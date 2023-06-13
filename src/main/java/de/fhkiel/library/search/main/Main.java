package de.fhkiel.library.search.main;

import de.fhkiel.library.search.Book;
import de.fhkiel.library.search.Condition;
import de.fhkiel.library.search.SearchParameter;
import de.fhkiel.library.search.implementation.ConcreteBook;
import de.fhkiel.library.search.implementation.ConcreteSearch;
import javax.naming.TimeLimitExceededException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) throws TimeLimitExceededException {

    // Random Daten zum Testen
    List<Book> books = new ArrayList<>();
    List<String> authors = new ArrayList<>();
    List<String> keywords = new ArrayList<>();
    authors.add("author");
    authors.add("author");
    keywords.add("keyword 1");
    keywords.add("keyword 2");
    LocalDate boughtDate = LocalDate.of(2020, 5, 4);
    LocalDate borrowedTill = LocalDate.of(2024, 1, 2);
    Condition condition = Condition.NEW;

    // Bücher anlegen
    for (int i = 0; i < 10; i++) {
      books.add(
          new ConcreteBook(
              i,
              String.format("book %d", i),
              authors,
              keywords,
              boughtDate,
              borrowedTill,
              condition,
              i));
    }

    // Suche anlegen und suchen
    ConcreteSearch search = new ConcreteSearch();
    search.addBooks(books);

    // Suchparameter definieren
    SearchParameter searchParameter =
        search
            .createSearchParameter()
            .addNamesToSearch("book 1")
            .addAuthorsToSearch("author")
            .createParameterForSearch();

    // Suche durchführen
    List<Book> foundBooks = search.getBooks(searchParameter);

    // gefundene Bücher ausgeben
    System.out.println("Gefundene Buecher: " + foundBooks.size());
    foundBooks.forEach(b -> System.out.println(b.id()));
  }
}
