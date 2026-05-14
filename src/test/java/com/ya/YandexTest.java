package com.ya;

import com.codeborne.selenide.CollectionCondition;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.attribute;
import static com.ya.YandexTestSteps.openYandexAndSearch;

@Epic("Yandex")
@Feature("Поиск Яндекса")
public class YandexTest extends BaseUiTest {

    private static final String SEARCH_QUERY = "Погода";
    private static final String NO_RESULTS_QUERY = "zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz";

    @Story("Позитивный сценарий поиска")
    @Test
    public void testYandexSearchPositive() {
        YandexSearchPage page = openYandexAndSearch(SEARCH_QUERY);

        page.getSearchInput().shouldHave(attribute("value", SEARCH_QUERY));
        page.getSearchResults().shouldHave(CollectionCondition.sizeGreaterThan(0));
    }

    @Story("Поиск по запросу без ожидаемых результатов")
    @Test
    public void testYandexSearchWithoutResults() {
        YandexSearchPage page = openYandexAndSearch(NO_RESULTS_QUERY);

        page.getSearchInput().shouldHave(attribute("value", NO_RESULTS_QUERY));
        page.getSearchResults().shouldHave(CollectionCondition.size(0));
    }
}
