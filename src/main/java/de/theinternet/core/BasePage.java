package de.theinternet.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected Actions actions;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        actions = new Actions(driver);
    }

    protected void click(WebElement element) {
        getWait(5).until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    protected String getText(WebElement element) {
        return element.getText();
    }

    protected WebDriverWait getWait(int time) {
        return new WebDriverWait(driver, Duration.ofSeconds(time));
    }

    protected boolean isElementVisible(WebElement element) {
        return getWait(5).until(ExpectedConditions.visibilityOf(element)).isDisplayed();
    }
}
