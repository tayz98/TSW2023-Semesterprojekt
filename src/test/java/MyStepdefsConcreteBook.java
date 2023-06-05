import de.fhkiel.library.search.Condition;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.ParameterType;
import io.cucumber.java.de.Angenommen;
import io.cucumber.java.de.Und;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class MyStepdefsConcreteBook {

    private String name;
    private int id;
    private List<String> authors = new ArrayList<>();
    private List<String> keywords = new ArrayList<>();
    LocalDate boughtDate;
    Optional<LocalDate> borrowedTill = Optional.empty();
    Condition condition;
    int timesBorrowed;

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

    @Angenommen("wir haben den Titel {string}")
    public void wirHabenDenTitel(String arg0) {
        name = arg0;
    }

    @Und("die ISBN {int}")
    public void dieISBN(int arg0) {
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

    @Und("die Liste von Autor*innen")
    public void dieListeVonAutorInnen(DataTable arg0) {
        List<String> authorsList = arg0.asList();
        authors.addAll(authorsList);
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
        System.out.println(boughtDate);
    }

    @Und("das Ausleihdatum \"{datum}\"")
    public void dasAusleihdatum(LocalDate arg0) {
        borrowedTill = Optional.ofNullable(arg0);
        System.out.println(borrowedTill);
    }

    @Und("den Zustand {String}")
    public void denZustand(Condition arg0) {
        condition = arg0;
        System.out.println(condition);
    }

    @Und("{int} Ausleihen")
    public void ausleihen(int arg0) {
        timesBorrowed = arg0;
    }
}
