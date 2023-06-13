import de.fhkiel.library.search.Book;
import de.fhkiel.library.search.Condition;
import de.fhkiel.library.search.implementation.ConcreteBook;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.ParameterType;
import io.cucumber.java.de.Angenommen;
import io.cucumber.java.de.Dann;
import io.cucumber.java.de.Und;
import io.cucumber.java.de.Wenn;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.assertj.core.api.Assertions.assertThat;

public class MyStepdefsConcreteBook {

  private String name;
  private int id = -1;
  private List<String> authors = new ArrayList<>();
  private List<String> keywords = new ArrayList<>();
  private LocalDate boughtDate;
  // TODO: ändern!!!
  private LocalDate borrowedTill;
  private Condition condition;
  private int timesBorrowed;
  private Book book = null;
  private Exception caughtException = null;

  // Datatype for flexible list of strings
  @ParameterType("(?:[^,]*)(?:,\\s?[^,]*)*")
  public List<String> listeVonStrings(String arg0) {
    return Arrays.asList(arg0.split(",\\s?"));
  }

  // Datatype for dates
  @ParameterType("\\d{2}\\.\\d{2}\\.\\d{4}")
  public LocalDate datum(String dateString) {
    return LocalDate.parse(dateString, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
  }

  // datatype for condition enum
  @ParameterType("BROKEN|BAD|GOOD|NEW")
  public Condition zustand(String condition) {
    return Condition.valueOf(condition);
  }

  @Angenommen("wir haben den Titel {string}")
  public void wirHabenDenTitel(String arg0) {
    name = arg0;
  }

  @Und("die Identifikationsnummer {int}")
  public void dieIdentifikationsnummer(int arg0) {
    id = arg0;
  }

  @Und("den Autor {string}")
  public void denAutor(String arg0) {
    authors.add(arg0);
  }

  @Und("die Autorin {string}")
  public void dieAutorin(String arg0) {
    authors.add(arg0);
  }

  @Und("die Autor*innen \"{listeVonStrings}\"")
  public void dieAutorInnen(List<String> arg0) {
    authors.addAll(arg0);
  }

  @Und("das Schlagwort {string}")
  public void dasSchlagwort(String arg0) {
    keywords.add(arg0);
  }

  @Und("die Schlagwörter \"{listeVonStrings}\"")
  public void dieSchlagworter(List<String> arg0) {
    keywords.addAll(arg0);
  }

  @Und("die Liste von Schlagwörtern")
  public void dieListeVonSchlagwortern(DataTable arg0) {
    List<String> keywordsList = arg0.asList();
    keywords.addAll(keywordsList);
  }

  @Und("das Kaufdatum \"{datum}\"")
  public void dasKaufdatum(LocalDate arg0) {
    boughtDate = arg0;
  }

  @Und("das Ausleihdatum \"{datum}\"")
  public void dasAusleihdatum(LocalDate arg0) {
    borrowedTill = arg0;
  }

  @Und("den Zustand {zustand}")
  public void denZustand(Condition arg0) {
    condition = arg0;
  }

  @Und("{int} Ausleihen")
  public void ausleihen(int arg0) {
    timesBorrowed = arg0;
  }

  @Wenn("damit ein Buch erstellt wird")
  public void damitEinBuchErstelltWird() {
    try {
      book =
          new ConcreteBook(
              id, name, authors, keywords, boughtDate, borrowedTill, condition, timesBorrowed);
    } catch (Exception e) {
      caughtException = e;
    }
  }

  @Dann("soll das Buch existieren")
  public void sollDasBuchExistieren() {
    assertThat(book).isNotNull();
  }

  @Dann("soll das Buch nicht existieren")
  public void sollDasBuchNichtExistieren() {
    assertThat(book).isNull();
  }

  @Und("es wird eine Fehlermeldung ausgegeben")
  public void esWirdEineFehlermeldungAusgegeben() {
    assertThat(caughtException).isNotNull();
  }

  @Und("der Titel {string} angelegt sein")
  public void derTitelAngelegtSein(String arg0) {
    assertEquals(arg0, book.name());
  }

  @Und("die Identifikationsnummer {int} angelegt sein")
  public void dieIdentifikationsnummerAngelegtSein(int arg0) {
    assertEquals(arg0, book.id());
  }

  @Und("der Autor {string} angelegt sein")
  public void derAutorAngelegtSein(String arg0) {
    assertTrue(book.authors().contains(arg0));
  }

  @Und("die Autorin {string} angelegt sein")
  public void dieAutorinAngelegtSein(String arg0) {
    assertTrue(book.authors().contains(arg0));
  }

  @Und("die Autor*innen \"{listeVonStrings}\" angelegt sein")
  public void dieAutorInnenAngelegtSein(List<String> arg0) {
    for (String author : arg0) {
      assertTrue(book.authors().contains(author));
    }
  }

  @Und("die Schlagwörter \"{listeVonStrings}\" angelegt sein")
  public void dieSchlagworterAngelegtSein(List<String> arg0) {
    for (String keyword : arg0) {
      assertTrue(book.keywords().contains(keyword));
    }
  }

  @Und("das Kaufdatum \"{datum}\" angelegt sein")
  public void dasKaufdatumAngelegtSein(LocalDate arg0) {
    assertEquals(arg0, book.bought());
  }

  @Und("das Ausleihdatum \"{datum}\" angelegt sein")
  public void dasAusleihdatumAngelegtSein(LocalDate arg0) {
    assertEquals(arg0, book.borrowedTill().get());
  }

  @Und("der Zustand {zustand} angelegt sein")
  public void derZustandAngelegtSein(Condition arg0) {
    assertEquals(arg0, book.condition());
  }

  @Und("{int} Ausleihen angelegt sein")
  public void ausleihenAngelegtSein(int arg0) {
    assertEquals(arg0, book.timesBorrowed());
  }

  @Und("{double} Ausleihen pro Tag")
  public void ausleihenProTag(double arg0) {
    long daysBetween = ChronoUnit.DAYS.between(this.boughtDate, LocalDate.now());
    this.timesBorrowed = (int) (arg0 * daysBetween);
  }

  @Und("es gibt den Fehler, dass ein ungültiger Wert übergeben wurde")
  public void esGibtDenFehlerDassEinUngultigerWertUbergebenWurde() {
    assertThat(caughtException).isInstanceOf(IllegalArgumentException.class);
  }

  @Und("es gibt den Fehler, dass ein Wert nicht gesetzt wurde")
  public void esGibtDenFehlerDassEinWertNichtGesetztWurde() {
    assertThat(caughtException).isInstanceOf(NullPointerException.class);
  }

  @Und("es gibt den Fehler, dass ein ungültiges Datum übergeben wurde")
  public void esGibtDenFehlerDassEinUngultigesDatumUbergebenWurde() {
    assertThat(caughtException).isInstanceOf(DateTimeException.class);
  }
}
