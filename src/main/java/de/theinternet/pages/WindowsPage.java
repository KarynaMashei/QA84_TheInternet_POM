package de.theinternet.pages;

import de.theinternet.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WindowsPage extends BasePage {

    private final By clickHereLink = By.linkText("Click Here");
    private final By heading = By.tagName("h3");

    public WindowsPage(WebDriver driver) {
        super(driver);
    }

    public WindowsPage openPage() {
        driver.get("https://the-internet.herokuapp.com/windows");
        return this;
    }

    public WindowsPage clickHere() {
        click(driver.findElement(clickHereLink));
        return this;
    }

    public WindowsPage switchToNewWindow() {
        String originalWindow = driver.getWindowHandle();

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.numberOfWindowsToBe(2));

        String newWindow = driver.getWindowHandles()
                .stream()
                .filter(handle -> !handle.equals(originalWindow))
                .findFirst()
                .orElseThrow(() ->
                        new IllegalStateException("New window was not opened")
                );

        driver.switchTo().window(newWindow);
        return this;
    }

    public String getHeadingText() {
        return getText(driver.findElement(heading));
    }

    public String getBrowserTitle() {
        return driver.getTitle();
    }
}
