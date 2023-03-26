/**
 * Импорт класса SearchPage. Написание ключевого слова в поле поиска и нажатие кнопки поиска.
 *
 * Наведение курсора мыши на кнопку голосового поиска. Ассерт, что кнопка голосового поиска содержит верный текст
 */

package steps;

import pages.SearchPage;

public class SearchSteps {

    private SearchPage searchPage = new SearchPage();

    public SearchResultsSteps executeSearchByKeyword(String keyword) throws InterruptedException {
        searchPage.fillSearchField(keyword);
        searchPage.clickSearchButtonOrPressEnter();
        return new SearchResultsSteps();
    }

    public SearchSteps openTooltip() {
        searchPage.moveToVoiceSearchButton(); //наведение курсора мыши на кнопку голосового поиска
        return this;  //возвращаем SearchPage страницу поиска, остаемся на той же странице
    }

    public SearchSteps verifyThatTooltipContainsProperText(String text) {
        searchPage.assertThatVoiceSearchTooltipContainsText(text);
        return this;
    }
}


//Thread.sleep(2000);