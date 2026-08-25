package de.theinternet.pages;

import de.theinternet.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage extends BasePage {

    @FindBy(id = "dropdown")
    private WebElement dropdown;

    public DropdownPage(WebDriver driver) {
        super(driver);
    }

    public DropdownPage openPage() {
        driver.get("https://the-internet.herokuapp.com/dropdown");
        return this;
    }

    public DropdownPage selectOption(String option) {
        new Select(dropdown).selectByVisibleText(option);
        return this;
    }

    public String getSelectedOption() {
        return new Select(dropdown).getFirstSelectedOption().getText();
    }
}
