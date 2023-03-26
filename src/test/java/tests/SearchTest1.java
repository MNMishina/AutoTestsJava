/**
 * Наследование класса BaseTest. Аннотация @Test запускает тест по проверке содержания топа результатов поиска верного текста/атрибута
 *
 * Второй тест проверяет, что при наведении на кнопку голосового поиска, текст на тултипе соответствует тексту "Голосовой поиск".
 */

package tests;

import org.testng.annotations.Test;

// использование наследования (extends) Должны унаследовать SearchTest1 от BaseTest
public class SearchTest1 extends BaseTest {

    @Test(dataProvider = "dataProvider")
    public void openGoogleComTest(String text) throws InterruptedException {
        steps.executeSearchByKeyword(text)
                .verifyThatTopResultContainsCorrectText("Amelia Island - Wikipedia")
                .verifyThatTopResultContainsProperAttributeText("LC20lb");
    }

    @Test
    public void verifySearchByVoiceTooltipOnGoogle() throws InterruptedException {
        Thread.sleep(2000);
        steps.openTooltip()
                .verifyThatTooltipContainsProperText("Голосовой поиск");
    }
}

//("//*[@id="search"]")  Пишем автотест с использованием Selenium Webdriver ...