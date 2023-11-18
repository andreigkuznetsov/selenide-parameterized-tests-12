package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    private final String CONTACTS_SEСTION_TITLE = "СВЯЗЬ С КОМПАНИЕЙ";

    private SelenideElement
                footerSection = $(".contacts__section-title"),
                headerRow = $(".header__row"),
                popularProductsTab = $(".main-popular__products"),
                interestingForYouSection = $(".interesting__grid");

    private ElementsCollection
                popularProductsCardsTitles = $$(".popular-products-item__title"),
                popularProductsCardsTexts = $$(".popular-products-item__text");

    public MainPage openMainPage() {
        open("/");
        footerSection.shouldHave(text(CONTACTS_SEСTION_TITLE));

        return this;
    }

    public MainPage checkMainMenu(String text) {
        headerRow.shouldHave(text(text));

        return this;
    }

    public MainPage selectPopularProduct(String text) {
        popularProductsTab.find(byText(text)).click();

        return this;
    }

    public MainPage checkPopularProductsCardsTitles(List<String> text) {
        popularProductsCardsTitles.shouldHave(texts(text));

        return this;
    }

    public MainPage checkPopularProductsCardsTexts(List<String> text) {
        popularProductsCardsTexts.shouldHave(texts(text));

        return this;
    }

    public MainPage checkInterestingForYouCardsTitles(String text) {
        interestingForYouSection.shouldHave(text(text));

        return this;
    }
}


