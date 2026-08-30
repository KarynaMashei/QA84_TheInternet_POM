package de.theinternet.pages;

import de.theinternet.core.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BrokenImagesPage extends BasePage {

    @FindBy(css = ".example img")
    private List<WebElement> images;

    public BrokenImagesPage(WebDriver driver) {
        super(driver);
    }

    public BrokenImagesPage openPage() {
        driver.get("https://the-internet.herokuapp.com/broken_images");
        return this;
    }

    public int getImagesCount() {
        return images.size();
    }

    public long getBrokenImagesCount() {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        return images.stream()
                .filter(image -> (Long) js.executeScript(
                        "return arguments[0].naturalWidth;",
                        image
                ) == 0)
                .count();
    }
}
