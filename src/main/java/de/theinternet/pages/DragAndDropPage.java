package de.theinternet.pages;

import de.theinternet.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DragAndDropPage extends BasePage {

    @FindBy(id = "column-a")
    private WebElement columnA;

    @FindBy(id = "column-b")
    private WebElement columnB;

    public DragAndDropPage(WebDriver driver) {
        super(driver);
    }

    public DragAndDropPage openPage() {
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");
        return this;
    }

    public DragAndDropPage dragColumnAToB() {
        actions.dragAndDrop(columnA, columnB).perform();
        return this;
    }

    public String getLeftColumnText() {
        return getText(columnA.findElement(By.tagName("header")));
    }

    public String getRightColumnText() {
        return getText(columnB.findElement(By.tagName("header")));
    }
}
