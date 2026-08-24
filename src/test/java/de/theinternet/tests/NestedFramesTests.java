package de.theinternet.tests;

import de.theinternet.core.TestBase;
import de.theinternet.pages.NestedFramesPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NestedFramesTests extends TestBase {

    private NestedFramesPage nestedFramesPage;

    @BeforeMethod
    public void openNestedFramesPage() {
        nestedFramesPage = new NestedFramesPage(driver).openPage();
    }

    @Test
    public void nestedFramesTextTest() {
        Assert.assertEquals(
                nestedFramesPage.getLeftFrameText(),
                "LEFT"
        );

        Assert.assertEquals(
                nestedFramesPage.getMiddleFrameText(),
                "MIDDLE"
        );

        Assert.assertEquals(
                nestedFramesPage.getRightFrameText(),
                "RIGHT"
        );

        Assert.assertEquals(
                nestedFramesPage.getBottomFrameText(),
                "BOTTOM"
        );
    }
}
