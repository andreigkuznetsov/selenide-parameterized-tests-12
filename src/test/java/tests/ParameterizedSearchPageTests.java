package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import pages.SearchPage;

@DisplayName("Веб-тесты на страницу поиска сайта dpd.ru")
public class ParameterizedSearchPageTests extends TestBase {

    SearchPage searchPage = new SearchPage();


    @CsvFileSource(resources = "/theSearchResultsShouldContainLinksToRelevantPages.csv")
    @DisplayName("Результат поиска должен содержать ссылки на страницы релевантные запросу")
    @ParameterizedTest(name = "Для поискового запроса {0} в разделе Страницы должна быть ссылка {1}")
    void theSearchResultsShouldContainLinksToRelevantPages(String searchQuery, String expectedLink) {
          searchPage.openSearchPage()
                    .inputToSearchField(searchQuery)
                    .checkSearchResult(expectedLink);
    }
}
