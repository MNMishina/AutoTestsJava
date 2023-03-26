/**
 * Импорт класса SearchResultsPage. Ассерт, что текст и атрибут топа выдачи результатов на странице поиска содержат верный текст/атрибут.
 */

package steps;

import pages.SearchResultsPage;

public class SearchResultsSteps {

    private SearchResultsPage searchResultsPage = new SearchResultsPage();

    public SearchResultsSteps verifyThatTopResultContainsCorrectText(String text) {
        searchResultsPage.assertThatTopResultContainsCorrectText(text);
        return this;
    }

    public SearchResultsSteps verifyThatTopResultContainsProperAttributeText(String text) {
        searchResultsPage.assertThatTopResultContainsProperAttributeText(text);
        return this;
    }
}
