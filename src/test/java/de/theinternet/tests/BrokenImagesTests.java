package de.theinternet.tests;

import de.theinternet.core.TestBase;
import de.theinternet.pages.BrokenImagesPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BrokenImagesTests extends TestBase {

    private BrokenImagesPage brokenImagesPage;

    @BeforeEach
    public void openBrokenImagesPage() {
        brokenImagesPage = new BrokenImagesPage(driver).openPage();
    }

    @Test
    public void brokenImagesTest() {
        Assertions.assertEquals(3, brokenImagesPage.getImagesCount());
        Assertions.assertEquals(2, brokenImagesPage.getBrokenImagesCount());
    }
}
