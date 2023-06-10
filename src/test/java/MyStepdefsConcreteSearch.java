import de.fhkiel.library.search.Book;
import de.fhkiel.library.search.Condition;
import de.fhkiel.library.search.implementation.ConcreteBook;
import de.fhkiel.library.search.implementation.ConcreteSearch;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.de.Angenommen;
import io.cucumber.java.de.Dann;
import io.cucumber.java.de.Und;
import io.cucumber.java.de.Wenn;
import org.junit.Before;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class MyStepdefsConcreteSearch {

    private ConcreteSearch search;
    private List<Book> books;

    private Book requestedBook;

    @Before
    public void doSomethingBefore() {
        search = new ConcreteSearch();
    }

    @Angenommen("folgende Bücher existieren")
    public void folgendeBucherExistieren(DataTable dataTable) {

        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);

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
    public void solltenDieFolgendenBucherFurDieSucheVerfugbarSein(DataTable dataTable) {

        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);

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
}
