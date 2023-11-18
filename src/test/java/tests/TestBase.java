package tests;

import org.junit.jupiter.api.BeforeAll;
import com.codeborne.selenide.Configuration;

public class TestBase {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://dpd.ru";
        Configuration.pageLoadStrategy = "eager";
    }
}
