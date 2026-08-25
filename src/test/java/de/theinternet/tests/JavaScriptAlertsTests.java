package de.theinternet.tests;

import de.theinternet.core.TestBase;
import de.theinternet.pages.JavaScriptAlertsPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class JavaScriptAlertsTests extends TestBase {

    private JavaScriptAlertsPage alertsPage;

    @BeforeEach
    public void openAlertsPage() {
        alertsPage = new JavaScriptAlertsPage(driver).openPage();
    }

    @Test
    public void jsAlertTest() {
        alertsPage.clickJsAlertButton();

        Assertions.assertEquals(
                "I am a JS Alert",
                alertsPage.getAlertText()
        );

        alertsPage.acceptAlert();

        Assertions.assertEquals(
                "You successfully clicked an alert",
                alertsPage.getResultText()
        );
    }

    @Test
    public void jsConfirmAcceptTest() {
        alertsPage.clickJsConfirmButton();

        Assertions.assertEquals(
                "I am a JS Confirm",
                alertsPage.getAlertText()
        );

        alertsPage.acceptAlert();

        Assertions.assertEquals(
                "You clicked: Ok",
                alertsPage.getResultText()
        );
    }

    @Test
    public void jsConfirmDismissTest() {
        alertsPage.clickJsConfirmButton();
        alertsPage.dismissAlert();

        Assertions.assertEquals(
                "You clicked: Cancel",
                alertsPage.getResultText()
        );
    }

    @Test
    public void jsPromptTest() {
        String text = "Hello";

        alertsPage.clickJsPromptButton();
        alertsPage.typeInAlert(text);
        alertsPage.acceptAlert();

        Assertions.assertEquals(
                "You entered: " + text,
                alertsPage.getResultText()
        );
    }
}
