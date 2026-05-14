package com.ya;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.ya.YandexTestSteps.openYandexAndSearch;

@Epic("Yandex")
@Feature("Поиск Яндекса")
public class YandexTest {

    private static final String SEARCH_QUERY = "Погода";
    private static final String BAD_SEARCH_QUERY = "!@#$ ";
    private static final String BASE_URL = "https://yandex.ru";

    @AfterEach
    public void tearDown() {
        closeWebDriver();
    }

    @Story("Позитивный сценарий поиска")
    @Test
    public void testYandexSearchPositive() {
        YandexSearchPage page = openYandexAndSearch(BASE_URL, SEARCH_QUERY);
        
        page.getSearchResults().shouldHave(CollectionCondition.sizeGreaterThan(1));
        
        SelenideElement firstResult = page.getSearchResult(0);
        firstResult.shouldHave(text(SEARCH_QUERY));
        
        for (SelenideElement result : page.getSearchResults()) {
            if (!result.getText().toLowerCase().contains("реклама")) {
                result.shouldHave(text(SEARCH_QUERY));
            }
        }
    }

    @Story("Негативный сценарий поиска")
    @Test
    public void testYandexSearchNegative() {
        YandexSearchPage page = openYandexAndSearch(BASE_URL, BAD_SEARCH_QUERY);
        
        page.getSearchResults().shouldHave(CollectionCondition.size(0));
    }
}
