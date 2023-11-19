package pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SearchPage {

    private final String SEARCH_PAGE_TITLE = "Поиск на сайте";

    private SelenideElement
            searchField = $(".ui-input-root_a0jXy"),
            searchPageBody = $(".page__content"),
            pagesSection = $(".list_O8N5j");

    public SearchPage openSearchPage() {
        open("/search-content?search-text");
        WebDriverRunner.getWebDriver().manage().window().maximize();
        searchPageBody.shouldHave(text(SEARCH_PAGE_TITLE));

        return this;
    }

    public SearchPage inputToSearchField(String text) {
        searchField.setValue(text).pressEnter();

        return this;
    }

    public SearchPage checkSearchResult(String text) {
        pagesSection.shouldHave(text(text));

        return this;
    }
}
