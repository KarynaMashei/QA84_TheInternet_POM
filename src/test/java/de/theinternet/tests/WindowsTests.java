package de.theinternet.tests;

import de.theinternet.core.TestBase;
import de.theinternet.pages.WindowsPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WindowsTests extends TestBase {

    private WindowsPage windowsPage;

    @BeforeEach
    public void openWindowsPage() {
        windowsPage = new WindowsPage(driver).openPage();
    }

    @Test
    public void newWindowTitleTest() {
        windowsPage.clickHere()
                .switchToNewWindow();

        Assertions.assertEquals(
                "New Window",
                windowsPage.getHeadingText()
        );

        Assertions.assertEquals(
                "New Window",
                windowsPage.getBrowserTitle()
        );
    }
}
