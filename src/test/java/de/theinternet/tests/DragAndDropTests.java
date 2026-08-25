package de.theinternet.tests;

import de.theinternet.core.TestBase;
import de.theinternet.pages.DragAndDropPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DragAndDropTests extends TestBase {

    private DragAndDropPage dragAndDropPage;

    @BeforeEach
    public void openDragAndDropPage() {
        dragAndDropPage = new DragAndDropPage(driver).openPage();
    }

    @Test
    public void dragColumnAToBTest() {
        Assertions.assertEquals("A", dragAndDropPage.getLeftColumnText());
        Assertions.assertEquals("B", dragAndDropPage.getRightColumnText());

        dragAndDropPage.dragColumnAToB();

        Assertions.assertEquals("B", dragAndDropPage.getLeftColumnText());
        Assertions.assertEquals("A", dragAndDropPage.getRightColumnText());
    }
}
