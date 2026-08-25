package de.theinternet.pages;

import de.theinternet.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WindowsPage extends BasePage {

    @FindBy(linkText = "Click Here")
    private WebElement clickHereLink;

    @FindBy(tagName = "h3")
    private WebElement heading;

    public WindowsPage(WebDriver driver) {
        super(driver);
    }

    public WindowsPage openPage() {
        driver.get("https://the-internet.herokuapp.com/windows");
        return this;
    }

    public WindowsPage clickHere() {
        click(clickHereLink);
        return this;
    }

    public WindowsPage switchToNewWindow() {
        String originalWindow = driver.getWindowHandle();

        getWait(10)
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
        return getText(heading);
    }

    public String getBrowserTitle() {
        return driver.getTitle();
    }
}
