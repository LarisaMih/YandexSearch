package com.ya;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.page;

public class YandexTestSteps {

    @Step("Открыть Яндекс и выполнить поиск: {query}")
    public static YandexSearchPage openYandexAndSearch(String query) {
        YandexSearchPage page = page(YandexSearchPage.class)
                .openPage()
                .search(query);

        Allure.addAttachment("Поисковый запрос", "Выполнен поиск: " + query);

        return page;
    }
}
