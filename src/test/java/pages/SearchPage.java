/**
 * Наследует класс BasePage. На странице сайта google.com выполняется поиск по локаторам.
 *
 * Установка курсора в поле поиска и передача текста. Нажатие Enter на кнопку поиска.
 *
 * Метод наведения курсора на кнопку голосового поиска. Ассерт, что всплывающая подсказка голосового поиска содержит текст
 */

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchPage extends BasePage {

    @FindBy(name = "q")               // выполняем поиск по локатору (поисковое поле)
    private WebElement searchField;  // объявляем веб-элемент

    //private By searchField = By.name("q");
    //WebElement searchField = driver.findElement(By.name("q"));

    @FindBy(name = "btnK")            //выполняем поиск по локатору (кнопка "Поиск в Google")
    private WebElement searchButton;

    @FindBy(xpath = "//body")         //выполняем поиск по локатору (родительский элемент тултипа Голосовой поиск)
    private WebElement pageBody;

    @FindBy(css = "div.XDyW0e")     //выполняем поиск по локатору (кнопка микрофон-голосовой поиск)
    private WebElement searchByVoiceButton;

    public SearchPage() {
        super();
    }

    public void fillSearchField(String text) {
        //WebElement searchFieldElement = driver.findElement(searchField);
        searchField.click();
        searchField.sendKeys(text);
    }

    //public void pasteToSearchField(String text) {
    //    pasteTextToElementFromClipboard(searchField, text);
    //}

    public void pressEnter() {
        //WebElement searchFieldElement = driver.findElement(searchField);
        searchField.sendKeys(Keys.RETURN);
    }

    public void clickSearchButtonOrPressEnter() throws InterruptedException {
        if (isElementFound(By.name("btnK"), 3)) {
            wait.until(ExpectedConditions.elementToBeClickable(searchButton));
            searchButton.click();
            //clickWithJavascript(searchButton);
        } else {
            pressEnter();
        }
    }

    //метод наведения курсора на кнопку голосового поиска
    public void moveToVoiceSearchButton() {
        builder.moveToElement(searchByVoiceButton).build().perform(); //класс Actions объект builder
    }

    public void assertThatVoiceSearchTooltipContainsText(String text) {  //ассерт, что всплывающая подсказка голосового поиска содержит текст
        //+text+ -текст из параметров (String text) данного метода
        //метод .size() показывает список с найденными элементами, если элемент не найден, то размер списка=0
        //метод .as описывает содержание ошибки, если тултип не будет найден
        //метод .isNotZero() проверка размера списка, если он пустой, то нужный текст не был найден на странице
        assertThat(pageBody.findElements(By.xpath("//*[contains(text(), '" + text + "')]")).size())
                .as("Expected tooltip [" + text + " was not found]").isNotZero();
    }
}



/*
/html/body/div[5]        /html/body/div[5]/text()
/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input
 */