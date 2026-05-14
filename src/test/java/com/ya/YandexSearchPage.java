package com.ya;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class YandexSearchPage {

    private final SelenideElement searchInput = $("#text");
    private final ElementsCollection searchResults = $$("#search-result li.serp-item, li.serp-item");
    private final SelenideElement noResultsMessage = $(".EmptySearchResults, .misspell__message, .serp-empty");

    @Step("Открыть страницу поиска")
    public YandexSearchPage openPage() {
        open("/");
        searchInput.shouldBe(visible);
        return this;
    }

    @Step("Выполнить поиск по запросу: {query}")
    public YandexSearchPage search(String query) {
        searchInput.shouldBe(visible).setValue(query).pressEnter();
        searchInput.shouldBe(visible);
        return this;
    }

    public SelenideElement getSearchInput() {
        return searchInput;
    }

    public ElementsCollection getSearchResults() {
        return searchResults;
    }

    public SelenideElement getNoResultsMessage() {
        return noResultsMessage;
    }
}
