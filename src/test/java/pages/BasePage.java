/**
 * Объявление вебдрайвера, слипа и билдера. Ожидание появление строки поиска (вебэлемента). Если элемент не появился, тест не падает, а выдает false (не найден).
 *
 * Вставка текста из буфера обмена с помощью javascript (Ctrl+V)
 */

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static tests.BaseTest.getDriver;

public abstract class BasePage {

    WebDriver driver;
    WebDriverWait wait;
    Actions builder;
    //JavascriptExecutor executor;

    public BasePage() {
        this.driver = getDriver();
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        builder = new Actions(driver);
        //executor = (JavascriptExecutor) driver; //executor инициализирован
    }

    boolean isElementFound(By by, int timeout) throws InterruptedException {
        List<WebElement> elements = driver.findElements(by);
        for (int i = 0; (i < timeout) && (elements.size() == 0); i++) {
            Thread.sleep(1000);
            elements = driver.findElements(by);
        }
        return elements.size() > 0;
    }
/*
    //метод отвечает за помещение текста в буфер обмена, после того как текст получен, вставляет его в поле поиска
    void pasteTextToElementFromClipboard(WebElement element, String text) {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Clipboard clipboard = toolkit.getSystemClipboard();
        StringSelection stringSelection = new StringSelection(text);
        clipboard.setContents(stringSelection, null);
        //метод делает вставку текста, полученного из буфера обмена
        element.sendKeys(Keys.CONTROL, "v");                                в Jenkins тест падает, в поле поиска вставляет V. Ctrl+V не срабатывает
    }

    void clickWithJavascript(WebElement element) {
        executor.executeScript("arguments[0].click()", element); //передаем 2 параметра, подставляем в качестве аргумента элемент, на который хотим кликнуть с помощью джаваскрипта
    }

 */
}
