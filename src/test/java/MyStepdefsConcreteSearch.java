import de.fhkiel.library.search.Book;
import de.fhkiel.library.search.Condition;
import de.fhkiel.library.search.SearchParameter;
import de.fhkiel.library.search.implementation.ConcreteBook;
import de.fhkiel.library.search.implementation.ConcreteSearch;
import de.fhkiel.library.search.implementation.ConcreteSearchParameter;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.de.Angenommen;
import io.cucumber.java.de.Dann;
import io.cucumber.java.de.Und;
import io.cucumber.java.de.Wenn;
import io.cucumber.java.Before;
import javax.naming.TimeLimitExceededException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import static java.lang.Boolean.parseBoolean;
import static java.lang.Integer.parseInt;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

public class MyStepdefsConcreteSearch {

  private ConcreteSearch search;
  private List<Book> books;
  private Book requestedBook;
  private List<Book> foundBooks;
  private Exception caughtException;
  private SearchParameter searchParameter;
  private SearchParameter.Builder builder;
  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

  @Before
  public void before() {
    search = new ConcreteSearch();
    books = new ArrayList<>();
    foundBooks = new ArrayList<>();
    requestedBook = null;
    caughtException = null;
    searchParameter = null;
    builder = null;
  }

  @Angenommen("folgende Bücher existieren")
  public void folgendeBucherExistieren(DataTable arg0) {

    List<Map<String, String>> rows = arg0.asMaps(String.class, String.class);

    for (Map<String, String> columns : rows) {

      String authorString = columns.get("authors");
      List<String> authors = Arrays.asList(authorString.split(",\\s*"));

      String keywordsString = columns.get("keywords");
      List<String> keywords = Arrays.asList(keywordsString.split(",\\s*"));

      Condition condition = Condition.valueOf(columns.get("condition"));

      LocalDate borrowedTill = null;
      if (!Objects.equals(columns.get("borrowedTill"), null)) {
        borrowedTill = LocalDate.parse(columns.get("borrowedTill"), formatter);
      }

      books.add(
          new ConcreteBook(
              Integer.parseInt(columns.get("id")),
              columns.get("name"),
              authors,
              keywords,
              LocalDate.parse(columns.get("boughtDate"), formatter),
              borrowedTill,
              condition,
              Integer.parseInt(columns.get("timesBorrowed"))));
    }
  }

    @Wenn("alle vorhandenen Bücher zur Suche hinzugefügt werden")
    public void alleBucherZurSucheHinzugefugtWerden() {
        try {
            search.addBooks(books);
            this.books = new ArrayList<>();
        } catch (Exception e) {
            caughtException = e;
        }
    }

  @Dann("sollen die folgenden Bücher für die Suche verfügbar sein")
  public void sollenDieFolgendenBucherFurDieSucheVerfugbarSein(DataTable arg0) {
    List<Map<String, String>> rows = arg0.asMaps(String.class, String.class);

    int i = 1;

    for (Map<String, String> columns : rows) {

      String authorString = columns.get("authors");
      List<String> authors = Arrays.asList(authorString.split(",\\s"));

      String keywordsString = columns.get("keywords");
      List<String> keywords = Arrays.asList(keywordsString.split(",\\s"));

      Condition condition = Condition.valueOf(columns.get("condition"));

      assertEquals(search.getBook(i).id(), Integer.parseInt(columns.get("id")));
      assertEquals(search.getBook(i).name(), columns.get("name"));
      assertEquals(search.getBook(i).authors(), authors);
      assertEquals(search.getBook(i).keywords(), keywords);
      assertEquals(
          search.getBook(i).bought(), LocalDate.parse(columns.get("boughtDate"), formatter));
      assertEquals(
          search.getBook(i).borrowedTill(),
          Optional.ofNullable(LocalDate.parse(columns.get("borrowedTill"), formatter)));
      assertEquals(search.getBook(i).condition(), condition);
      assertEquals(
          search.getBook(i).timesBorrowed(), Integer.parseInt(columns.get("timesBorrowed")));

      i++;
    }
  }

  @Und("ein Buch mit der ID {int} angefordert wird")
  public void einBuchMitDerIDAngefordertWird(int arg0) {
    requestedBook = search.getBook(arg0);
  }

  @Dann("sollte das Buch mit der ID {int} zurückgegeben werden")
  public void sollteDasBuchMitDerIDZuruckgegebenWerden(int arg0) {
    assertEquals(requestedBook.id(), arg0);
  }

  @Dann("sollte null zurückgegeben werden für eine nicht vorhandene Buch-ID")
  public void sollteNullZuruckgegebenWerdenFurEineNichtVorhandeneBuchID() {
    assertNull(requestedBook);
  }

  @Wenn("eine Suche mit dem folgenden Parametern durchgeführt wird")
  public void eineSucheMitDemFolgendenParameternDurchgefuhrtWird(DataTable arg0)
      throws TimeLimitExceededException {

    List<Map<String, String>> rows = arg0.asMaps(String.class, String.class);
    List<String> names = new ArrayList<>();
    List<String> authors = new ArrayList<>();
    List<String> keywords = new ArrayList<>();
    LocalDate boughtAfter = null;
    LocalDate boughtBefore = null;
    LocalDate borrowedAfterDate = null;
    int minBorrowCount = 0;
    int maxBorrowCount = 0;
    String[] conditionStrings = null;
    List<Condition> conditions = new ArrayList<>();

    for (Map<String, String> columns : rows) {

      // Auslesen der Parameter aus der Map und Konvertierung in die richtigen Datentypen
      if (columns.get("name") != null) {
        names = Arrays.asList(columns.get("name").split(","));
      }
      if (columns.get("authors") != null) {
        authors = Arrays.asList(columns.get("authors").split(","));
      }
      if (columns.get("keywords") != null) {
        keywords = Arrays.asList(columns.get("keywords").split(","));
      }

      Optional<Boolean> isBorrowed = Optional.of(Boolean.parseBoolean(columns.get("isBorrowed")));

      if(columns.get("boughtAfterDate") != null) {
        boughtAfter = LocalDate.parse(columns.get("boughtAfterDate"), formatter);
      }

      if(columns.get("boughtBeforeDate") != null) {
        boughtBefore = LocalDate.parse(columns.get("boughtBeforeDate"), formatter);
      }

      if(columns.get("borrowedAfterDate") != null) {
        borrowedAfterDate = LocalDate.parse(columns.get("borrowedAfterDate"), formatter);
      }
      if(columns.get("minBorrowCount") != null) {
        minBorrowCount = Integer.parseInt(columns.get("minBorrowCount"));
      }

      if(columns.get("maxBorrowCount") != null) {
        maxBorrowCount = Integer.parseInt(columns.get("maxBorrowCount"));
      }

      // Konvertierung der Conditions in eine Liste von Conditions (Enum)
      if(columns.get("conditionList") != null) {
        conditionStrings = columns.get("conditionList").split(",");
        for (String conditionString : conditionStrings) {
          Condition condition = Condition.valueOf(conditionString.trim());
          conditions.add(condition);
        }
      }


      // Anlegen des ConcreteSearchParameters
      SearchParameter searchParameter =
          new ConcreteSearchParameter(
              names,
              authors,
              keywords,
              isBorrowed,
              boughtAfter,
              boughtBefore,
              borrowedAfterDate,
              minBorrowCount,
              maxBorrowCount,
              conditions);

      // Durchführen der Suche
      foundBooks = search.getBooks(searchParameter);
    }
  }

  @Dann("sollen folgende Bücher gefunden werden")
  public void sollenDieFolgendenBucherGefundenWerden(DataTable arg0) {

    List<Book> expectedBooks = new ArrayList<>();

    List<Map<String, String>> rows = arg0.asMaps(String.class, String.class);
    int id = -1;
    String name = null;
    List<String> authors = null;
    List<String> keywords = null;
    LocalDate borrowedTill = null;
    LocalDate boughtDate = null;
    int timesBorrowed = 0;
    Condition condition = null;

    for (Map<String, String> columns : rows) {
      id = Integer.parseInt(columns.get("id"));
      name = columns.get("name");
      String authorString = columns.get("authors");
      authors = Arrays.asList(authorString.split(",\\s*"));
      String keywordsString = columns.get("keywords");
      keywords = Arrays.asList(keywordsString.split(",\\s*"));
      boughtDate = LocalDate.parse(columns.get("boughtDate"), formatter);
      if (!Objects.equals(columns.get("borrowedTill"), null)) {
        borrowedTill = LocalDate.parse(columns.get("borrowedTill"), formatter);
      }
      timesBorrowed = Integer.parseInt(columns.get("timesBorrowed"));
      condition = Condition.valueOf(columns.get("condition"));
      expectedBooks.add(
          new ConcreteBook(
              id, name, authors, keywords, boughtDate, borrowedTill, condition, timesBorrowed));
      // TODO: Suchparameter so ändern, dass alle Bücher ausgegeben werden
      // TODO: Länge der Listen vergleichen
      // TODO: Inhalt der Listen vergleichen
    }
  }

  @Dann("sollte eine TimeLimitExceededException geworfen werden")
  public void sollteEineTimeLimitExceededExceptionGeworfenWerden() {
    assertThrows(
        TimeLimitExceededException.class,
        () -> {
          // TODO: Hier müsste das ausgeführt werden, was die TimeLimitExceededException wirft, was
          // aber in einem anderen Step ausgelöst wird -> Wie lösen?
        });
  }

  @Wenn("ein Suchparameter erstellt wird")
  public void einSuchparameterErstelltWird() {
    search.createSearchParameter();
  }

  @Dann("sollte eine Instanz von SearchParameter.Builder zurückgegeben werden")
  public void sollteEineInstanzVonSearchParameterBuilderZuruckgegebenWerden() {
    // TODO: Wie testen?
  }

  @Dann("soll eine Fehlermeldung ausgegeben werden")
  public void sollEineFehlermeldungAusgegebenWerden() {}

  @Und("es gibt den Fehler, dass ein Buch mit der ID {int} bereits existiert")
  public void esGibtDenFehlerDassEinBuchMitDerIDBereitsExistiert(int arg0) {
    assertThat(caughtException).isInstanceOf(IllegalArgumentException.class);
    assertEquals("Mehrere Bücher mit ID " + arg0, caughtException.getMessage());
  }

  @Angenommen("es gibt keine Bücher")
  public void esGibtKeineBucher() {
    books = new ArrayList<>();
  }

    @Dann("sollen in der Suche keine Bücher vorhanden sein")
    public void sollenInDerSucheKeineBucherVorhandenSein()  {
        assertEquals(books, search.getBooks());
    }

  @Dann("soll folgendes Buch zurückgegeben werden")
  public void sollFolgendesBuchZuruckgegebenWerden(DataTable arg0) {
    int id = -1;
    String name = null;
    List<String> authors = null;
    List<String> keywords = null;
    LocalDate borrowedTill = null;
    LocalDate boughtDate = null;
    int timesBorrowed = 0;
    Condition condition = null;
    for (Map<String, String> row : arg0.asMaps(String.class, String.class)) {
      id = Integer.parseInt(row.get("id"));
      name = row.get("name");
      authors = Arrays.asList(row.get("authors").split(",\\s*"));
      keywords = Arrays.asList(row.get("keywords").split(",\\s*"));
      boughtDate = LocalDate.parse(row.get("boughtDate"), formatter);
      if (!Objects.equals(row.get("borrowedTill"), null)) {
        System.out.println("parse borrowedTill");
        borrowedTill = LocalDate.parse(row.get("borrowedTill"), formatter);
      }
      timesBorrowed = Integer.parseInt(row.get("timesBorrowed"));
      condition = Condition.valueOf(row.get("condition"));
    }
    assertEquals(requestedBook.id(), id);
    assertEquals(requestedBook.name(), name);
    assertEquals(requestedBook.authors(), authors);
    assertEquals(requestedBook.keywords(), keywords);
    assertEquals(requestedBook.bought(), boughtDate);
    assertEquals(requestedBook.borrowedTill(), Optional.ofNullable(borrowedTill));
    assertEquals(requestedBook.timesBorrowed(), timesBorrowed);
    assertEquals(requestedBook.condition(), condition);
  }

  @Dann("soll kein Buch zurückgegeben werden")
  public void sollKeinBuchZuruckgegebenWerden() {
    assertNull(requestedBook);
  }

    @Angenommen("wir haben folgende Werte für den Suchparameter")
    public void wirHabenFolgendeWerteFurDenSuchparameter(DataTable arg0) {
        builder = search.createSearchParameter();
        for (Map<String, String> row : arg0.asMaps(String.class, String.class)) {
            if (row.get("name") != null) {
                builder.addNamesToSearch(row.get("name"));
            }
            if (row.get("authors") != null) {
                builder.addAuthorsToSearch(row.get("authors"));
            }
            if (row.get("keywords") != null) {
                builder.addKeywordsToSearch(row.get("keywords"));
            }
            if (row.get("borrowed") != null) {
                builder.bookIsBorrowedNow(parseBoolean(row.get("borrowed")));
            }
            if (row.get("borrowedAfter") != null) {
                builder.bookIsBorrowedAfter(LocalDate.parse(row.get("borrowedAfter"), formatter));
            }
            if (row.get("boughtBefore") != null) {
                builder.bookWasBoughtBefore(LocalDate.parse(row.get("boughtBefore"), formatter));
            }
            if (row.get("boughtAfter") != null) {
                builder.bookWasBoughtAfter(LocalDate.parse(row.get("boughtAfter"), formatter));
            }
            if (row.get("minTimesBorrowed") != null) {
                builder.bookWasBorrowedAtLeastTimes(Integer.parseInt(row.get("minTimesBorrowed")));
            }
            if (row.get("maxTimesBorrowed") != null) {
                builder.bookWasBorrowedAtMostTimes(Integer.parseInt(row.get("maxTimesBorrowed")));
            }
            if (row.get("acceptableConditions") != null) {
                builder.acceptableConditions(Condition.valueOf(row.get("acceptableConditions")));
            }
        }
    }

  @Wenn("der Suchparameter erstellt wird")
  public void derSuchparameterErstelltWird() {
    searchParameter = builder.createParameterForSearch();
  }

  @Dann("soll der Suchparameter für die Suche folgende Werte enthalten")
  public void sollDerSuchparameterFurDieSucheFolgendeWerteEnthalten(DataTable arg0) {
    List<String> names = null;
    List<String> authors = null;
    List<String> keywords = null;
    Optional<Boolean> borrowed = Optional.empty();
    LocalDate borrowedAfter = null;
    LocalDate boughtBefore = null;
    LocalDate boughtAfter = null;
    int minTimesBorrowed = 0;
    int maxTimesBorrowed = 0;
    List<Condition> acceptableConditions = null;
    for (Map<String, String> row : arg0.asMaps(String.class, String.class)) {
      if (row.get("name") != null) {
        if (names == null) names = new ArrayList<>();
        names.add(row.get("name"));
      }
      if (row.get("authors") != null) {
        if (authors == null) authors = new ArrayList<>();
        authors.add(row.get("authors"));
      }
      if (row.get("keywords") != null) {
        if (keywords == null) keywords = new ArrayList<>();
        keywords.add(row.get("keywords"));
      }
      if (row.get("borrowed") != null) borrowed = Optional.of(parseBoolean(row.get("borrowed")));
      if (row.get("borrowedAfter") != null)
        borrowedAfter = LocalDate.parse(row.get("borrowedAfter"), formatter);
      if (row.get("boughtBefore") != null)
        boughtBefore = LocalDate.parse(row.get("boughtBefore"), formatter);
      if (row.get("boughtAfter") != null)
        boughtAfter = LocalDate.parse(row.get("boughtAfter"), formatter);
      if (row.get("minTimesBorrowed") != null)
        minTimesBorrowed = parseInt(row.get("minTimesBorrowed"));
      if (row.get("maxTimesBorrowed") != null)
        maxTimesBorrowed = parseInt(row.get("maxTimesBorrowed"));
      if (row.get("acceptableConditions") != null) {
        if (acceptableConditions == null) acceptableConditions = new ArrayList<>();
        acceptableConditions.add(Condition.valueOf(row.get("acceptableConditions")));
      }
    }
    assertEquals(names, searchParameter.names());
    assertEquals(authors, searchParameter.authors());
    assertEquals(keywords, searchParameter.keywords());
    assertEquals(borrowed, searchParameter.borrowed());
    assertEquals(borrowedAfter, searchParameter.borrowedAfter());
    assertEquals(boughtBefore, searchParameter.boughtBefore());
    assertEquals(boughtAfter, searchParameter.boughtAfter());
    assertEquals(minTimesBorrowed, searchParameter.minTimesBorrowed());
    assertEquals(maxTimesBorrowed, searchParameter.maxTimesBorrowed());
    assertEquals(acceptableConditions, searchParameter.acceptableConditions());
  }

  @Wenn("eine Suche mit den gegebenen Parametern durchgeführt wird")
  public void eineSucheMitDenGegebenenParameternDurchgefuhrtWird()
      throws TimeLimitExceededException {
    this.foundBooks = search.getBooks(searchParameter);
  }

    @Dann("sollten die folgenden Bücher für die Suche verfügbar sein")
    public void solltenDieFolgendenBucherFurDieSucheVerfugbarSein(DataTable arg0) {
        // easy solution:
        // assertEquals(this.books, search.getBooks());
        // complex solution:
        List<Map<String, String>> books = arg0.asMaps(String.class, String.class);
        for (Map<String, String> book : books) {
            String id = book.get("id");
            String name = book.get("name");
            String authors = book.get("authors");
            String keywords = book.get("keywords");
            String boughtDate = book.get("boughtDate");
            String borrowedTill = book.get("borrowedTill");
            int timesBorrowed = Integer.parseInt(book.get("timesBorrowed"));
            String condition = book.get("condition");
            assertEquals(name, search.getBook(Integer.parseInt(id)).name());
            assertEquals(authors, String.join(", ",search.getBook(Integer.parseInt(id)).authors()));
            assertEquals(keywords, String.join(", ",search.getBook(Integer.parseInt(id)).keywords()));
            assertEquals(boughtDate, search.getBook(Integer.parseInt(id)).bought().format(formatter));
            assertEquals(borrowedTill, Optional.of(LocalDate.parse(borrowedTill, formatter)).map(date -> date.format(formatter)).orElse(null));
            assertEquals(timesBorrowed, search.getBook(Integer.parseInt(id)).timesBorrowed());
            assertEquals(condition, search.getBook(Integer.parseInt(id)).condition().toString());
        }
    }

  @Und("in der Suchhistorie soll folgender Suchparameter gespeichert sein")
  public void inDerSuchhistorieSollFolgenderSuchparameterGespeichertSein(DataTable givenSearchParameter) {

    List<Map<String, String>> rows = givenSearchParameter.asMaps(String.class, String.class);
    List<String> names = new ArrayList<>();
    List<String> authors = new ArrayList<>();
    List<String> keywords = new ArrayList<>();
    LocalDate boughtAfter = null;
    LocalDate boughtBefore = null;
    LocalDate borrowedAfterDate = null;
    int minBorrowCount = 0;
    int maxBorrowCount = 0;
    String[] conditionStrings = null;
    List<Condition> conditions = new ArrayList<>();

    for (Map<String, String> columns : rows) {

      // Auslesen der Parameter aus der Map und Konvertierung in die richtigen Datentypen
      if (columns.get("name") != null) {
        names = Arrays.asList(columns.get("name").split(","));
      }
      if (columns.get("authors") != null) {
        authors = Arrays.asList(columns.get("authors").split(","));
      }
      if (columns.get("keywords") != null) {
        keywords = Arrays.asList(columns.get("keywords").split(","));
      }

      Optional<Boolean> isBorrowed = Optional.of(Boolean.parseBoolean(columns.get("isBorrowed")));

      if (columns.get("boughtAfterDate") != null) {
        boughtAfter = LocalDate.parse(columns.get("boughtAfterDate"), formatter);
      }

      if (columns.get("boughtBeforeDate") != null) {
        boughtBefore = LocalDate.parse(columns.get("boughtBeforeDate"), formatter);
      }

      if (columns.get("borrowedAfterDate") != null) {
        borrowedAfterDate = LocalDate.parse(columns.get("borrowedAfterDate"), formatter);
      }
      if (columns.get("minBorrowCount") != null) {
        minBorrowCount = Integer.parseInt(columns.get("minBorrowCount"));
      }

      if (columns.get("maxBorrowCount") != null) {
        maxBorrowCount = Integer.parseInt(columns.get("maxBorrowCount"));
      }

      // Konvertierung der Conditions in eine Liste von Conditions (Enum)
      if (columns.get("conditionList") != null) {
        conditionStrings = columns.get("conditionList").split(",");
        for (String conditionString : conditionStrings) {
          Condition condition = Condition.valueOf(conditionString.trim());
          conditions.add(condition);
        }
      }

      // Den ersten SearchParameter-Eintrag abrufen
      if (!search.history().isEmpty()) {
        Iterator<Map.Entry<SearchParameter, List<Book>>> iterator = search.history().entrySet().iterator();
        Map.Entry<SearchParameter, List<Book>> firstEntry = iterator.next();

        SearchParameter firstSearchParameter = firstEntry.getKey();

        // Überprüfen, ob die Parameter mit den erwarteten Parametern übereinstimmen
        assertEquals(names, firstSearchParameter.names());
        assertEquals(authors, firstSearchParameter.authors());
        assertEquals(keywords, firstSearchParameter.keywords());
        assertEquals(isBorrowed, firstSearchParameter.borrowed());
        assertEquals(boughtAfter, firstSearchParameter.boughtAfter());
        assertEquals(boughtBefore, firstSearchParameter.boughtBefore());
        assertEquals(borrowedAfterDate, firstSearchParameter.borrowedAfter());
        assertEquals(minBorrowCount, firstSearchParameter.minTimesBorrowed());
        assertEquals(maxBorrowCount, firstSearchParameter.maxTimesBorrowed());
        assertEquals(conditions, firstSearchParameter.acceptableConditions());

      }

    }
  }
}
