package de.theinternet.tests;

import de.theinternet.core.TestBase;
import de.theinternet.pages.NestedFramesPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NestedFramesTests extends TestBase {

    private NestedFramesPage nestedFramesPage;

    @BeforeEach
    public void openNestedFramesPage() {
        nestedFramesPage = new NestedFramesPage(driver).openPage();
    }

    @Test
    public void nestedFramesTextTest() {
        Assertions.assertEquals(
                "LEFT",
                nestedFramesPage.getLeftFrameText()
        );

        Assertions.assertEquals(
                "MIDDLE",
                nestedFramesPage.getMiddleFrameText()
        );

        Assertions.assertEquals(
                "RIGHT",
                nestedFramesPage.getRightFrameText()
        );

        Assertions.assertEquals(
                "BOTTOM",
                nestedFramesPage.getBottomFrameText()
        );
    }
}
