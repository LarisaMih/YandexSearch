package com.ya;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.hasWebDriverStarted;

public abstract class BaseUiTest {

    protected static final String BASE_URL = System.getProperty("baseUrl", "https://yandex.ru");

    @BeforeAll
    static void setUpBrowser() {
        Configuration.baseUrl = BASE_URL;
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.browserSize = System.getProperty("browserSize", "1920x1080");
        Configuration.headless = Boolean.parseBoolean(System.getProperty("headless", "true"));
        Configuration.timeout = Long.parseLong(System.getProperty("timeout", "10000"));
        Configuration.screenshots = true;
        Configuration.savePageSource = true;
    }

    @AfterEach
    public void tearDown() {
        attachPageSource();
        closeWebDriver();
    }

    private void attachPageSource() {
        if (!hasWebDriverStarted()) {
            return;
        }

        String pageSource = getWebDriver().getPageSource();
        if (pageSource == null || pageSource.isBlank()) {
            return;
        }

        Allure.addAttachment(
                "Page source",
                "text/html",
                new ByteArrayInputStream(pageSource.getBytes(StandardCharsets.UTF_8)),
                ".html"
        );
    }
}
