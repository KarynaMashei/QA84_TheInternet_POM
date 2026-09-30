# The Internet UI Test Automation

Training project developed during the QA Automation Engineer program at AIT Technology School. It demonstrates UI test automation for [The Internet](https://the-internet.herokuapp.com/) with Java, Selenium WebDriver, JUnit 5 and the Page Object Model.

## Covered scenarios

- drag and drop
- mouse hover interactions
- dropdown selection
- horizontal slider controls
- JavaScript alerts
- nested frames
- browser windows
- broken-image checks

## Technology stack

- Java 21
- Selenium WebDriver 4
- JUnit 5
- Maven
- WebDriverManager
- Page Object Model

## Project structure

- `src/main/java/de/theinternet/pages` — page objects for each test area
- `src/main/java/de/theinternet/core` — shared page actions
- `src/test/java/de/theinternet/tests` — JUnit test classes
- `src/test/java/de/theinternet/core` — browser setup and teardown

## Run the tests

Prerequisites: JDK 21, Maven and Chrome installed locally.

```bash
mvn test
```

## Notes

This is a training project, not a production or client application. The automated tests depend on the availability and current markup of the public The Internet website.
