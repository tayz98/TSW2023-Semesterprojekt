import de.fhkiel.library.search.Condition;
import de.fhkiel.library.search.SearchParameter;
import de.fhkiel.library.search.implementation.ConcreteSearchParameter;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.DataTableType;
import io.cucumber.java.ParameterType;
import io.cucumber.java.de.Angenommen;
import io.cucumber.java.de.Dann;
import io.cucumber.java.de.Und;
import io.cucumber.java.de.Wenn;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static java.lang.Boolean.parseBoolean;
import static java.lang.Integer.parseInt;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

public class MyStepdefsConcreteSearchParameter {

    private ConcreteSearchParameter.Builder builder;
    private ConcreteSearchParameter searchParameter;

    @Before
    public void before() {
        builder = new ConcreteSearchParameter.Builder();
    }

    // datatype for condition enum
    @DataTableType
    public Condition setzeZustand(String condition) {
        return Condition.valueOf(condition);
    }

    @Wenn("damit einen Suchparameter erstellt wird")
    public void damitEinenSuchparameterErstelltWird() {
        searchParameter = builder.createParameterForSearch();
    }

    @Angenommen("wir haben die Namen")
    public void wirHabenDieNamen(DataTable arg0) {
        arg0.asList().forEach(arg -> builder.addNamesToSearch(arg));
    }

    @Dann("soll der Suchparameter die folgenden Namen enthalten")
    public void sollDerSuchparameterDieFolgendenNamenEnthalten(DataTable arg0) {
        assertEquals(arg0.asList(), searchParameter.names());
    }

    @Angenommen("wir haben die Autor*innen")
    public void wirHabenDieAutorInnen(DataTable arg0) {
        arg0.asList().forEach(arg -> builder.addAuthorsToSearch(arg));
    }

    @Dann("soll der Suchparameter folgende Autor*innen enthalten")
    public void sollDerSuchparameterFolgendeAutorInnenEnthalten(DataTable arg0) {
        assertEquals(arg0.asList(), searchParameter.authors());
    }

    @Angenommen("wir haben die Schlüsselwörter")
    public void wirHabenDieSchlusselworter(DataTable arg0) {
        arg0.asList().forEach(arg -> builder.addKeywordsToSearch(arg));
    }

    @Dann("soll der Suchparameter folgende Schlüsselwörter enthalten")
    public void sollDerSuchparameterFolgendeSchlusselworterEnthalten(DataTable arg0) {
        assertEquals(arg0.asList(), searchParameter.keywords());
    }

    /*
    @Angenommen("wir haben den Ausleihstatus {boolean}")
    public void wirHabenDenAusleihstatusTrue(boolean arg0) {
        builder.bookIsBorrowedNow(arg0);
    }

     */

    @Angenommen("wir fragen ab, ob ein Buch nach dem \"{datum}\" ausgeliehen wurde")
    public void wirFragenAbObEinBuchNachDemAusgeliehenWurde(LocalDate arg0) {
        builder.bookIsBorrowedAfter(arg0);
    }

    @Dann("soll der Suchparameter die Abfrage, ob ein Buch nach dem \"{datum}\" ausgeliehen wurde, enthalten")
    public void sollDerSuchparameterDieAbfrageObEinBuchNachDemAusgeliehenWurdeEnthalten(LocalDate arg0) {
        assertEquals(arg0, searchParameter.borrowedAfter());
    }

    @Angenommen("wir fragen ab, ob ein Buch vor dem \"{datum}\" gekauft wurde")
    public void wirFragenAbObEinBuchVorDemGekauftWurde(LocalDate arg0) {
        builder.bookWasBoughtBefore(arg0);
    }

    @Dann("soll der Suchparameter das Datum \"{datum}\", vor dem das Buch gekauft wurde, enthalten")
    public void sollDerSuchparameterDasDatumVorDemDasBuchGekauftWurdeEnthalten(LocalDate arg0) {
        assertEquals(arg0, searchParameter.boughtBefore());
    }

    @Angenommen("wir fragen ab, ob ein Buch nach dem \"{datum}\" gekauft wurde")
    public void wirFragenAbObEinBuchNachDemGekauftWurde(LocalDate arg0) {
        builder.bookWasBoughtAfter(arg0);
    }

    @Dann("soll der Suchparameter das Datum \"{datum}\", nach dem das Buch gekauft wurde, enthalten")
    public void sollDerSuchparameterDasDatumNachDemDasBuchGekauftWurdeEnthalten(LocalDate arg0) {
        assertEquals(arg0, searchParameter.boughtAfter());
    }

    @Angenommen("wir haben die Zahl {int} als Menge wie oft ein Buch mindestens ausgeliehen wurde")
    public void wirHabenDieZahlAlsMengeWieOftEinBuchMindestensAusgeliehenWurde(int arg0) {
        builder.bookWasBorrowedAtLeastTimes(arg0);
    }

    @Dann("soll der Suchparameter die Zahl {int} als Menge wie oft ein Buch mindestens ausgeliehen wurde enthalten")
    public void sollDerSuchparameterDieZahlAlsMengeWieOftEinBuchMindestensAusgeliehenWurdeEnthalten(int arg0) {
        assertEquals(arg0, searchParameter.minTimesBorrowed());
    }

    @Angenommen("wir haben die Zahl {int} als Menge wie oft ein Buch maximal ausgeliehen wurde")
    public void wirHabenDieZahlAlsMengeWieOftEinBuchMaximalAusgeliehenWurde(int arg0) {
        builder.bookWasBorrowedAtMostTimes(arg0);
    }

    @Dann("soll der Suchparameter die Zahl {int} als Menge wie oft ein Buch maximal ausgeliehen wurde enthalten")
    public void sollDerSuchparameterDieZahlAlsMengeWieOftEinBuchMaximalAusgeliehenWurdeEnthalten(int arg0) {
        assertEquals(arg0, searchParameter.maxTimesBorrowed());
    }

    @Angenommen("wir haben die Zustände")
    public void wirHabenDieZustande(DataTable arg0) {
        List<Condition> conditions = arg0.asList(Condition.class);
        conditions.forEach(condition -> builder.acceptableConditions(condition));
    }

    @Dann("soll der Suchparameter die folgenden akzeptierten Zustände enthalten")
    public void sollDerSuchparameterDieFolgendenAkzeptiertenZustandeEnthalten(DataTable arg0) {
        List<Condition> expectedConditions = arg0.asList(Condition.class);
        assertEquals(expectedConditions, searchParameter.acceptableConditions());
    }

    @Angenommen("wir haben keine Werte")
    public void wirHabenKeineWerte() {
    }

    @Dann("soll der Suchparameter keine Werte enthalten")
    public void sollDerSuchparameterKeineWerteEnthalten() {
        assertNull(searchParameter.names());
        assertNull(searchParameter.authors());
        assertNull(searchParameter.keywords());
        assertNull(searchParameter.borrowedAfter());
        assertNull(searchParameter.boughtBefore());
        assertNull(searchParameter.boughtAfter());
        assertEquals(0, searchParameter.minTimesBorrowed());
        assertEquals(0, searchParameter.maxTimesBorrowed());
        assertNull(searchParameter.acceptableConditions());
    }

    @Angenommen("das Buch soll ausgeliehen sein")
    public void dasBuchSollAusgeliehenSein() {
        builder.bookIsBorrowedNow(true);
    }

    @Dann("soll der Suchparameter den Ausleihstatus ausgeliehen enthalten")
    public void sollDerSuchparameterDenAusleihstatusAusgeliehenEnthalten() {
        assertTrue(searchParameter.borrowed().isPresent() && searchParameter.borrowed().get());
    }

    @Angenommen("das Buch soll nicht ausgeliehen sein")
    public void dasBuchSollNichtAusgeliehenSein() {
        builder.bookIsBorrowedNow(false);
    }

    @Dann("soll der Suchparameter den Ausleihstatus nicht ausgeliehen enthalten")
    public void sollDerSuchparameterDenAusleihstatusNichtAusgeliehenEnthalten() {
        assertTrue(searchParameter.borrowed().isPresent() && !searchParameter.borrowed().get());
    }

    @Dann("soll der Suchparameter folgende Werte enthalten")
    public void sollDerSuchparameterFolgendeWerteEnthalten(DataTable arg0) {
        List<String> names = new ArrayList<>();
        List<String> authors = new ArrayList<>();
        List<String> keywords = new ArrayList<>();
        Optional<Boolean> borrowed = Optional.empty();
        LocalDate borrowedAfter = null;
        LocalDate boughtBefore = null;
        LocalDate boughtAfter = null;
        int minTimesBorrowed = 0;
        int maxTimesBorrowed = 0;
        List<Condition> acceptableConditions = new ArrayList<>();
        for (Map<String, String> row : arg0.asMaps(String.class, String.class)) {
            if (row.get("names") != null) names.add(row.get("names"));
            if (row.get("authors") != null) authors.add(row.get("authors"));
            if (row.get("keywords") != null) keywords.add(row.get("keywords"));
            if (row.get("borrowed") != null) borrowed = Optional.of(parseBoolean(row.get("borrowed")));
            if (row.get("borrowedAfter") != null) borrowedAfter = LocalDate.parse(row.get("borrowedAfter"), DateTimeFormatter.ofPattern("dd.MM.yyyy"));
            if (row.get("boughtBefore") != null) boughtBefore = LocalDate.parse(row.get("boughtBefore"), DateTimeFormatter.ofPattern("dd.MM.yyyy"));
            if (row.get("boughtAfter") != null) boughtAfter = LocalDate.parse(row.get("boughtAfter"), DateTimeFormatter.ofPattern("dd.MM.yyyy"));
            if (row.get("minTimesBorrowed") != null) minTimesBorrowed = parseInt(row.get("minTimesBorrowed"));
            if (row.get("maxTimesBorrowed") != null) maxTimesBorrowed = parseInt(row.get("maxTimesBorrowed"));
            if (row.get("acceptableConditions") != null) acceptableConditions.add(Condition.valueOf(row.get("acceptableConditions")));
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
}

