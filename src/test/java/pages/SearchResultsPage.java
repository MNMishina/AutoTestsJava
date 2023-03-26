/**
 * Наследует класс BasePage. Поиск по локатору результата поиска.
 *
 * Ассерты, что текст и атрибут топа результатов на странице с результатами поиска соответствует ожидаемому тексту/атрибуту
 *
 */

package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchResultsPage extends BasePage {

    @FindBy(xpath = "//div[@class='yuRUbf']//h3")  //локатор результата поиска
    private WebElement resultRow;

    @FindBy(xpath = "//div[@class='yuRUbf']//h3")
    private List<WebElement> resultRows;

    public SearchResultsPage() {
        super();
    }

    public void assertThatTopResultContainsCorrectText(String expected) {
        //WebElement resultRowElement = driver.findElement(resultRow);

        wait.until(ExpectedConditions.visibilityOfAllElements(resultRow));

        //assertThat(resultRow.isDisplayed()).as("Element has not been displayed!").isTrue();

        assertThat(resultRows.stream().map(e -> e.getText()).collect(Collectors.toList()).toString())
                .as("Wrong text has been displayed!").contains(expected);
    }

    public void assertThatTopResultContainsProperAttributeText(String expected) {
        //WebElement resultRowElement = driver.findElement(resultRow);
        assertThat(resultRow.getAttribute("class")).as("Wrong attribute text!").contains(expected);

    }
}


