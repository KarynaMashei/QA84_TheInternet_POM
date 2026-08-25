package de.theinternet.pages;

import de.theinternet.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JavaScriptAlertsPage extends BasePage {

    @FindBy(xpath = "//button[text()='Click for JS Alert']")
    private WebElement jsAlertButton;

    @FindBy(xpath = "//button[text()='Click for JS Confirm']")
    private WebElement jsConfirmButton;

    @FindBy(xpath = "//button[text()='Click for JS Prompt']")
    private WebElement jsPromptButton;

    @FindBy(id = "result")
    private WebElement result;

    public JavaScriptAlertsPage(WebDriver driver) {
        super(driver);
    }

    public JavaScriptAlertsPage openPage() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        return this;
    }

    public JavaScriptAlertsPage clickJsAlertButton() {
        click(jsAlertButton);
        return this;
    }

    public JavaScriptAlertsPage clickJsConfirmButton() {
        click(jsConfirmButton);
        return this;
    }

    public JavaScriptAlertsPage clickJsPromptButton() {
        click(jsPromptButton);
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
        return getText(result);
    }
}
