package tests;

import data.MainMenu;
import data.PopularProducts;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import pages.MainPage;

import java.util.List;
import java.util.stream.Stream;

@DisplayName("Веб-тесты на главную страницу сайта dpd.ru")
public class ParameterizedMainPageTests extends TestBase {

    MainPage mainPage = new MainPage();

    @EnumSource(MainMenu.class)
    @DisplayName("Основное меню сайта должно содержать корректные названия разделов")
    @ParameterizedTest(name = "{0}")
    void theMainMenuShouldContainsCorrectTitles(MainMenu mainMenu) {
        mainPage.openMainPage()
                .checkMainMenu(mainMenu.description);
    }

    static Stream<Arguments> thePopularProductsSectionShouldHaveCorrectCards() {
        return Stream.of(
                Arguments.of(
                        PopularProducts.FOR_BUSINESS,
                        List.of("Доставка для интернет-магазинов", "Доставка для маркетплейсов",
                                "Доставка для малого бизнеса", "Доставка для среднего бизнеса"),
                        List.of("Самая выгодная доставка для ваших заказов среди услуг DPD",
                                "Продавайте на Wildberries, Ozon, Yandex Market уже сегодня",
                                "Надежная и выгодная доставка любых грузов",
                                "Надежная доставка для Вашего бизнеса")
                ),
                Arguments.of(
                        PopularProducts.FOR_PERSONS,
                        List.of("Доставка для самозанятых", "Отправка заказа физлицом"),
                        List.of("Выгодное решение для небольших посылок",
                                "Отправляйте посылки своим родственникам, друзьям, покупателям")
                ),
                Arguments.of(
                        PopularProducts.TO_ANOTHER_COUNTRY,
                        List.of("Доставка в страны ЕАЭС", "Международная доставка"),
                        List.of("Отправляйте заказы в Казахстан, Кыргызстан, Беларусь или Армению",
                                "Отправляйте посылки по всему миру")
                )
        );
    }

    @MethodSource
    @DisplayName("Разделы секции Популярные продукты должны иметь карточки " +
            "с правильным текстом и описанием")
    @ParameterizedTest
    void thePopularProductsSectionShouldHaveCorrectCards(PopularProducts popularProducts,
                                                         List<String> expectedCards, List<String> expectedText) {
        mainPage.openMainPage()
                .scrollInToPopularProductsSection()
                .selectPopularProduct(popularProducts.description)
                .checkPopularProductsCardsTitles(expectedCards)
                .checkPopularProductsCardsTexts(expectedText);
    }

    @ValueSource(strings = {
            "Оформить заказ", "Интеграция", "Терминалы/ПВЗ", "Частые вопросы", "Обратная связь"
    })
    @DisplayName("Карточки раздела Интересное для Вас должны иметь правильные названия")
    @ParameterizedTest
    void theInterestingItemsSectionShouldHaveCardsWithCorrectTitles(String cardTitle) {
        mainPage.openMainPage()
                .checkInterestingForYouCardsTitles(cardTitle);
    }
}

