package de.theinternet.pages;

import de.theinternet.core.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HorizontalSliderPage extends BasePage {

    @FindBy(css = "input[type='range']")
    private WebElement slider;

    @FindBy(id = "range")
    private WebElement sliderValue;

    public HorizontalSliderPage(WebDriver driver) {
        super(driver);
    }

    public HorizontalSliderPage openPage() {
        driver.get("https://the-internet.herokuapp.com/horizontal_slider");
        return this;
    }

    public HorizontalSliderPage moveSliderTo(double value) {
        slider.sendKeys(Keys.HOME);

        int steps = (int) Math.round(value / 0.5);
        for (int i = 0; i < steps; i++) {
            slider.sendKeys(Keys.ARROW_RIGHT);
        }
        return this;
    }

    public String getSliderValue() {
        return getText(sliderValue);
    }
}
