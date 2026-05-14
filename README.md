# YandexSearch

UI-тесты поиска Яндекса на Java, JUnit 5, Selenide и Allure.

## Требования

- JDK 17 или 21.
- Доступный браузер Chrome/Chromium для локального запуска.

> Важно: Gradle Wrapper в проекте использует Gradle 8.5. Если запускать его на более новой Java и получить ошибку `Unsupported class file major version`, переключитесь на JDK 17/21 или обновите Gradle Wrapper.

## Запуск тестов

```bash
./gradlew test
```

Полезные параметры запуска:

```bash
./gradlew test -Dheadless=true
./gradlew test -Dbrowser=chrome
./gradlew test -DbaseUrl=https://yandex.ru
./gradlew test -Dtimeout=15000
```

## Allure-отчет

Результаты тестов сохраняются в `build/allure-results`.

```bash
./gradlew allureReport
./gradlew allureServe
```

## Что проверяют тесты

- Позитивный сценарий: после поиска по запросу отображается выдача и поисковая строка сохраняет введенный запрос.
- Сценарий без ожидаемых результатов: поисковая строка сохраняет редкий запрос, а коллекция обычных результатов остается пустой.

Тесты намеренно не проверяют текст каждого результата, потому что реальная поисковая выдача динамична и зависит от региона, рекламы, экспериментов и персонализации.
