import io.cucumber.java.de.Angenommen;
import io.cucumber.java.de.Dann;
import io.cucumber.java.de.Und;
import io.cucumber.java.de.Wenn;

import static org.assertj.core.api.Assertions.assertThat;

public class MyStepdefsBook {
    private String title;
    private String

    @Angenommen("wir haben den Titel {string}")
    public void wirHabenDenTitel(String arg0) {
        this.title = arg0;
    }
}
