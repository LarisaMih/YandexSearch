package com.ya;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class YandexSearchPage {

    @FindBy(css = "#text")
    private SelenideElement searchInput;

    @FindBy(css = "#search-result li.serp-item")
    private ElementsCollection searchResults;

    public void open(String url) {
        com.codeborne.selenide.Selenide.open(url);
    }

    public void enterSearchQuery(String query) {
        searchInput.setValue(query).pressEnter();
    }

    public ElementsCollection getSearchResults() {
        return searchResults;
    }

    public SelenideElement getSearchResult(int index) {
        return searchResults.get(index);
    }

    public int getResultsCount() {
        return searchResults.size();
    }
}
