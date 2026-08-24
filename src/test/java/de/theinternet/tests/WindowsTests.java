package de.theinternet.tests;

import de.theinternet.core.TestBase;
import de.theinternet.pages.WindowsPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WindowsTests extends TestBase {

    private WindowsPage windowsPage;

    @BeforeMethod
    public void openWindowsPage() {
        windowsPage = new WindowsPage(driver).openPage();
    }

    @Test
    public void newWindowTitleTest() {
        windowsPage.clickHere()
                .switchToNewWindow();

        Assert.assertEquals(
                windowsPage.getHeadingText(),
                "New Window"
        );

        Assert.assertEquals(
                windowsPage.getBrowserTitle(),
                "New Window"
        );
    }
}
