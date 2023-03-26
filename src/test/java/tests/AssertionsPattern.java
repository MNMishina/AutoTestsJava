/**
 * Паттерн проверки: проверяет, что отображены валидные результаты поиска, содержат ключевые слова "selenium", "webdriver", "java", "automation"
 *
 * и не содержат "restAssured", "protractor".
 */

/* import net.bytebuddy.implementation.InvokeDynamic;

import org.openqa.selenium.WebElement;

public class AssertionsPattern {

    public static void
    assertThatValidSearchResultIsDisplayed(WebElement result) {
        assertThat(result.isDisplayed())
                .as("Search result area is missing!").isTrue();

        assertThat(result.getText())
                .as("No expected content or unexpected content has been found!")
                .contains("selenium", "webdriver", "java", "automation")
                .doesNotContain("restAssured", "protractor");
    }
}
*/