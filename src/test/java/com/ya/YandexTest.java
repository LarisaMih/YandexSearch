package com.ya;


import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.ya.YandexTestStep.OpenBrouser;

public class YandexTest {

    static private String world = "Погода";
    static private String url = "http://yandex.ru";

    @Epic(value = "Yandex")
    @Feature(value = "Открытие страницы в браузере позитивные сценарии")
    @Story(value = "Проверка поиска")
    @Test
    public void testYandexSearch() {
        OpenBrouser(url, world);
        Rez rez = new Rez();
        rez.getResults().shouldHave(CollectionCondition.sizeGreaterThan(1));
        rez.getResult(0).shouldHave(text(world));
        System.out.println(rez.getResult(0));
        System.out.println(rez.getResult(1));
        for (SelenideElement r : rez.getResults()) {
            // r.shouldHave(text(world ))  ;
            if (r.toString().contains("реклама"))
                continue;
            else r.shouldHave(text(world));
            System.out.println("----" + r);
        }

    }

    @Epic(value = "Yandex")
    @Feature(value = "Открытие страницы в браузере негативные сценарии")
    @Story(value = "Некорректный запрос")
    @Test
    public void testYandexSearchBad() {

        OpenBrouser(url, "!@#$ ");
        Rez rez = new Rez();
        rez.getResults().shouldHave(size(0));
    }
}
