import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SelenideRepositorySearch {
    @BeforeAll
    static void beforeAll() {
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void shouldFindSelenideRepositoryAtTheTop (){
        //открыть главную страницу
open("https://github.com/");
$("[placeholder='Search or jump to...'").click();
$("#query-builder-test").setValue("selenide").pressEnter();
$$("[data-testid=results-list]").first().$("a").click();
$("#repository-container-header").shouldHave(text("selenide / selenide"));
    }

}
