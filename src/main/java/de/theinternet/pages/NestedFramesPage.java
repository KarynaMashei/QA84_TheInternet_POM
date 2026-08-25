package de.theinternet.pages;

import de.theinternet.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NestedFramesPage extends BasePage {

    @FindBy(name = "frame-top")
    private WebElement topFrame;

    @FindBy(name = "frame-left")
    private WebElement leftFrame;

    @FindBy(name = "frame-middle")
    private WebElement middleFrame;

    @FindBy(name = "frame-right")
    private WebElement rightFrame;

    @FindBy(name = "frame-bottom")
    private WebElement bottomFrame;

    @FindBy(tagName = "body")
    private WebElement frameBody;

    public NestedFramesPage(WebDriver driver) {
        super(driver);
    }

    public NestedFramesPage openPage() {
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        return this;
    }

    public String getLeftFrameText() {
        return getTopFrameText(leftFrame);
    }

    public String getMiddleFrameText() {
        return getTopFrameText(middleFrame);
    }

    public String getRightFrameText() {
        return getTopFrameText(rightFrame);
    }

    public String getBottomFrameText() {
        driver.switchTo().defaultContent();
        driver.switchTo().frame(bottomFrame);

        String text = getText(frameBody).trim();
        driver.switchTo().defaultContent();
        return text;
    }

    private String getTopFrameText(WebElement innerFrame) {
        driver.switchTo().defaultContent();
        driver.switchTo().frame(topFrame);
        driver.switchTo().frame(innerFrame);

        String text = getText(frameBody).trim();
        driver.switchTo().defaultContent();
        return text;
    }
}
