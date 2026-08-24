package de.theinternet.pages;

import de.theinternet.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NestedFramesPage extends BasePage {

    private final By frameBody = By.tagName("body");

    public NestedFramesPage(WebDriver driver) {
        super(driver);
    }

    public NestedFramesPage openPage() {
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        return this;
    }

    public String getLeftFrameText() {
        return getTopFrameText("frame-left");
    }

    public String getMiddleFrameText() {
        return getTopFrameText("frame-middle");
    }

    public String getRightFrameText() {
        return getTopFrameText("frame-right");
    }

    public String getBottomFrameText() {
        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-bottom");

        String text = getText(driver.findElement(frameBody)).trim();
        driver.switchTo().defaultContent();
        return text;
    }

    private String getTopFrameText(String frameName) {
        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame(frameName);

        String text = getText(driver.findElement(frameBody)).trim();
        driver.switchTo().defaultContent();
        return text;
    }
}
