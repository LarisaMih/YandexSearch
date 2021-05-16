package com.ya;

import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class YandexTestStep {
    @Description("Открыть браузер по url, найти поле поска, ввести в поиск 'java' нажать Enter")
    @Step
    public static void OpenBrouser(String url, String howSearch){
        open(url);
        $(By.cssSelector("#text")).val(howSearch).pressEnter();

        Allure.addAttachment("Открываем Yandex", "Вводим поиск");
    }
    /*public static void OpenBrouser1(String url, String howSearch){
        open(url);
        $(By.cssSelector("#text")).val(howSearch).pressEnter();

        Allure.addAttachment("Открываем Yandex", "123");
    }*/

}
