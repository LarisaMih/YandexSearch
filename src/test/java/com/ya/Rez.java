package com.ya;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Rez {



    public ElementsCollection getResults() {
        return $$("#search-result li.serp-item");
    }
    public SelenideElement getResult(int index) {
        return $("#search-result li.serp-item", index);
    }
}
