package de.theinternet.pages;

import de.theinternet.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JavaScriptAlertsPage extends BasePage {

    private final By jsAlertButton =
            By.xpath("//button[text()='Click for JS Alert']");

    private final By jsConfirmButton =
            By.xpath("//button[text()='Click for JS Confirm']");

    private final By jsPromptButton =
            By.xpath("//button[text()='Click for JS Prompt']");

    private final By result = By.id("result");

    public JavaScriptAlertsPage(WebDriver driver) {
        super(driver);
    }

    public JavaScriptAlertsPage openPage() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        return this;
    }

    public JavaScriptAlertsPage clickJsAlertButton() {
        click(driver.findElement(jsAlertButton));
        return this;
    }

    public JavaScriptAlertsPage clickJsConfirmButton() {
        click(driver.findElement(jsConfirmButton));
        return this;
    }

    public JavaScriptAlertsPage clickJsPromptButton() {
        click(driver.findElement(jsPromptButton));
        return this;
    }

    public String getAlertText() {
        return driver.switchTo().alert().getText();
    }

    public JavaScriptAlertsPage acceptAlert() {
        driver.switchTo().alert().accept();
        return this;
    }

    public JavaScriptAlertsPage dismissAlert() {
        driver.switchTo().alert().dismiss();
        return this;
    }

    public JavaScriptAlertsPage typeInAlert(String text) {
        driver.switchTo().alert().sendKeys(text);
        return this;
    }

    public String getResultText() {
        return getText(driver.findElement(result));
    }
}