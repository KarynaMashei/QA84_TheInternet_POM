package de.theinternet.tests;

import de.theinternet.core.TestBase;
import de.theinternet.pages.HorizontalSliderPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HorizontalSliderTests extends TestBase {

    private HorizontalSliderPage horizontalSliderPage;

    @BeforeEach
    public void openHorizontalSliderPage() {
        horizontalSliderPage = new HorizontalSliderPage(driver).openPage();
    }

    @Test
    public void moveSliderTest() {
        horizontalSliderPage.moveSliderTo(3.5);

        Assertions.assertEquals(
                "3.5",
                horizontalSliderPage.getSliderValue()
        );
    }
}
