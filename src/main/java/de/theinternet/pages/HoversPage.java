package de.theinternet.pages;

import de.theinternet.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HoversPage extends BasePage {

    @FindBy(css = ".figure")
    private List<WebElement> users;

    public HoversPage(WebDriver driver) {
        super(driver);
    }

    public HoversPage openPage() {
        driver.get("https://the-internet.herokuapp.com/hovers");
        return this;
    }

    public HoversPage hoverOverUser(int userNumber) {
        actions.moveToElement(getUser(userNumber)).perform();
        return this;
    }

    public boolean isUserCaptionVisible(int userNumber) {
        return isElementVisible(getCaption(userNumber));
    }

    public String getUserName(int userNumber) {
        return getText(getCaption(userNumber).findElement(By.tagName("h5")));
    }

    public String getProfileLink(int userNumber) {
        return getCaption(userNumber)
                .findElement(By.tagName("a"))
                .getDomAttribute("href");
    }

    private WebElement getUser(int userNumber) {
        return users.get(userNumber - 1);
    }

    private WebElement getCaption(int userNumber) {
        return getUser(userNumber).findElement(By.className("figcaption"));
    }
}
