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
import org.junit.Before;

import javax.naming.TimeLimitExceededException;
import java.time.LocalDate;
import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class MyStepdefsConcreteSearch {

    private ConcreteSearch search;
    private List<Book> books;
    private Book requestedBook;
    private List<Book> foundBooks;

    public MyStepdefsConcreteSearch() {
    }

    @Before
    public void doSomethingBefore() {
        search = new ConcreteSearch();
    }

    @Angenommen("folgende Bücher existieren")
    public void folgendeBucherExistieren(DataTable givenBooks) {

        List<Map<String, String>> rows = givenBooks.asMaps(String.class, String.class);

        for (Map<String, String> columns : rows) {

            String authorString = columns.get("authors");
            List<String> authors = Arrays.asList(authorString.split(","));

            String keywordsString = columns.get("keywords");
            List<String> keywords = Arrays.asList(keywordsString.split(","));

            Condition condition = Condition.valueOf(columns.get("condition"));

            books.add(new ConcreteBook(
                    Integer.parseInt(columns.get("id")),
                    columns.get("name"),
                    authors,
                    keywords,
                    LocalDate.parse(columns.get("boughtDate")),
                    Optional.ofNullable(columns.get("borrowedTill")).map(LocalDate::parse),
                    condition,
                    // TODO: Sorgt für fehlschlagenden Test -> Implementierung fehlerhaft?
                    Integer.parseInt(columns.get("timesBorrowed"))

            ));

        }
    }

    @Wenn("alle vorhandenen Bücher zur Suche hinzugefügt werden")
    public void alleBucherZurSucheHinzugefugtWerden() {
        search.addBooks(books);
    }

    @Dann("sollten die folgenden Bücher für die Suche verfügbar sein")
    public void solltenDieFolgendenBucherFurDieSucheVerfugbarSein(DataTable givenBooks) {

        List<Map<String, String>> rows = givenBooks.asMaps(String.class, String.class);

        int i = 1;

        for (Map<String, String> columns : rows) {

            String authorString = columns.get("authors");
            List<String> authors = Arrays.asList(authorString.split(","));

            String keywordsString = columns.get("keywords");
            List<String> keywords = Arrays.asList(keywordsString.split(","));

            Condition condition = Condition.valueOf(columns.get("condition"));

            assertEquals(search.getBook(i).id(), Integer.parseInt(columns.get("id")));
            assertEquals(search.getBook(i).name(), columns.get("name"));
            assertEquals(search.getBook(i).authors(), authors);
            assertEquals(search.getBook(i).keywords(), keywords);
            assertEquals(search.getBook(i).bought(), LocalDate.parse(columns.get("boughtDate")));
            assertEquals(search.getBook(i).borrowedTill(), Optional.ofNullable(LocalDate.parse(columns.get("borrowedTill"))));
            assertEquals(search.getBook(i).condition(), condition);
            assertEquals(search.getBook(i).timesBorrowed(), Integer.parseInt(columns.get("timesBorrowed")));

            i++;
        }

    }

    @Und("ein Buch mit der ID {int} angefordert wird")
    public void einBuchMitDerIDAngefordertWird(int id) {
        requestedBook = search.getBook(id);
    }

    @Dann("sollte das Buch mit der ID {int} zurückgegeben werden")
    public void sollteDasBuchMitDerIDZuruckgegebenWerden(int id) {
        assertEquals(requestedBook.id(), id);
    }

    @Dann("sollte null zurückgegeben werden für eine nicht vorhandene Buch-ID")
    public void sollteNullZuruckgegebenWerdenFurEineNichtVorhandeneBuchID() {
        assertEquals(requestedBook.id(), null);
    }

    @Wenn("eine Suche mit dem folgenden Parametern durchgeführt wird")
    public void eineSucheMitDemFolgendenParameternDurchgefuhrtWird(DataTable givenSearchParameters) throws TimeLimitExceededException {

        // Schreiben der Parameter in eine Map
        List<Map<String, String>> row = givenSearchParameters.asMaps(String.class, String.class);

        // Auslesen der Parameter aus der Map und Konvertierung in die richtigen Datentypen
        List<String> names = Arrays.asList(row.get(0).get("names").split(","));
        List<String> authors = Arrays.asList(row.get(0).get("authors").split(","));
        List<String> keywords = Arrays.asList(row.get(0).get("keywords").split(","));
        Optional<Boolean> isBorrowed = Optional.of(Boolean.parseBoolean(row.get(0).get("isBorrowed")));
        LocalDate boughtAfter = LocalDate.parse(row.get(0).get("boughtAfter"));
        LocalDate boughtBefore = LocalDate.parse(row.get(0).get("boughtBefore"));
        LocalDate borrowedBeforeDate = LocalDate.parse(row.get(0).get("borrowedBeforeDate"));
        int minBorrowCount = Integer.parseInt(row.get(0).get("minBorrowCount"));
        int maxBorrowCount = Integer.parseInt(row.get(0).get("maxBorrowCount"));

        // Konvertierung der Conditions in eine Liste von Conditions (Enum)
        String[] conditionStrings = row.get(0).get("conditions").split(",");
        List<Condition> conditions = new ArrayList<>();
        for (String conditionString : conditionStrings) {
            Condition condition = Condition.valueOf(conditionString.trim());
            conditions.add(condition);
        }

        // Anlegen des ConcreteSearchParameters
        SearchParameter searchParameter = new ConcreteSearchParameter(names, authors, keywords, isBorrowed, boughtAfter, boughtBefore, borrowedBeforeDate, minBorrowCount, maxBorrowCount, conditions);

        // Durchführen der Suche
        foundBooks = search.getBooks(searchParameter);

    }

    @Dann("sollten die folgenden Bücher gefunden werden")
    public void solltenDieFolgendenBucherGefundenWerden(DataTable givenBooks) {

            List<Map<String, String>> rows = givenBooks.asMaps(String.class, String.class);

            int i = 1;

            for (Map<String, String> columns : rows) {

                String authorString = columns.get("authors");
                List<String> authors = Arrays.asList(authorString.split(","));

                String keywordsString = columns.get("keywords");
                List<String> keywords = Arrays.asList(keywordsString.split(","));

                Condition condition = Condition.valueOf(columns.get("condition"));

                assertEquals(foundBooks.get(i).id(), Integer.parseInt(columns.get("id")));
                assertEquals(foundBooks.get(i).name(), columns.get("name"));
                assertEquals(foundBooks.get(i).authors(), authors);
                assertEquals(foundBooks.get(i).keywords(), keywords);
                assertEquals(foundBooks.get(i).bought(), LocalDate.parse(columns.get("boughtDate")));
                assertEquals(foundBooks.get(i).borrowedTill(), Optional.ofNullable(LocalDate.parse(columns.get("borrowedTill"))));
                assertEquals(foundBooks.get(i).condition(), condition);
                assertEquals(foundBooks.get(i).timesBorrowed(), Integer.parseInt(columns.get("timesBorrowed")));

                i++;
            }
    }

    @Dann("sollte eine TimeLimitExceededException geworfen werden")
    public void sollteEineTimeLimitExceededExceptionGeworfenWerden() {
        assertThrows(TimeLimitExceededException.class, () -> {
            // TODO: Hier müsste das ausgeführt werden, was die TimeLimitExceededException wirft, was aber in einem anderen Step ausgelöst wird -> Wie lösen?
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
}
