package com.ya;

import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Step;

public class YandexTestSteps {

    @Description("Открыть браузер по URL и ввести поисковый запрос")
    @Step("Открыть Яндекс и выполнить поиск: {query}")
    public static YandexSearchPage openYandexAndSearch(String url, String query) {
        YandexSearchPage page = new YandexSearchPage();
        page.open(url);
        page.enterSearchQuery(query);
        
        Allure.addAttachment("Поисковый запрос", "Выполнен поиск: " + query);
        
        return page;
    }
}
