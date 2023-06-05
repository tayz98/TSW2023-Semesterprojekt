import de.fhkiel.library.search.Book;
import de.fhkiel.library.search.implementation.ConcreteBook;
import io.cucumber.java.de.*;

import java.util.List;

public class MyBookStepDefs {
    private int id;
    private String title;
    private List<String> author;

    // Alex: überlegen/besprechen, ob es sinnvoll ist, mit einem "Angenommen" oder mehreren "Angenommen" zu arbeiten

    /*
    @Angenommen("wir haben den Titel {string}")
    public void wirHabenDenTitel(String arg0) {
        title = arg0;
    }

    @Und("wir haben die Autoren {strings}")
    public void wirHabenDieAutoren(String... arg0) {
        author.addAll(List.of(arg0));
    }



    @Und("wir haben die Identifikationsnummer {int}")
    public void wirHabenDieIdentifikationsnummer(int arg0) {
        id = arg0;
    }
    */
}
