package de.theinternet.tests;

import de.theinternet.core.TestBase;
import de.theinternet.pages.JavaScriptAlertsPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavaScriptAlertsTests extends TestBase {

    private JavaScriptAlertsPage alertsPage;

    @BeforeMethod
    public void openAlertsPage() {
        alertsPage = new JavaScriptAlertsPage(driver).openPage();
    }

    @Test
    public void jsAlertTest() {
        alertsPage.clickJsAlertButton();

        Assert.assertEquals(
                alertsPage.getAlertText(),
                "I am a JS Alert"
        );

        alertsPage.acceptAlert();

        Assert.assertEquals(
                alertsPage.getResultText(),
                "You successfully clicked an alert"
        );
    }

    @Test
    public void jsConfirmAcceptTest() {
        alertsPage.clickJsConfirmButton();

        Assert.assertEquals(
                alertsPage.getAlertText(),
                "I am a JS Confirm"
        );

        alertsPage.acceptAlert();

        Assert.assertEquals(
                alertsPage.getResultText(),
                "You clicked: Ok"
        );
    }

    @Test
    public void jsConfirmDismissTest() {
        alertsPage.clickJsConfirmButton();
        alertsPage.dismissAlert();

        Assert.assertEquals(
                alertsPage.getResultText(),
                "You clicked: Cancel"
        );
    }

    @Test
    public void jsPromptTest() {
        String text = "Hello";

        alertsPage.clickJsPromptButton();
        alertsPage.typeInAlert(text);
        alertsPage.acceptAlert();

        Assert.assertEquals(
                alertsPage.getResultText(),
                "You entered: " + text
        );
    }
}