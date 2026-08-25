package de.theinternet.tests;

import de.theinternet.core.TestBase;
import de.theinternet.pages.DropdownPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DropdownTests extends TestBase {

    private DropdownPage dropdownPage;

    @BeforeEach
    public void openDropdownPage() {
        dropdownPage = new DropdownPage(driver).openPage();
    }

    @Test
    public void selectOptionOneTest() {
        dropdownPage.selectOption("Option 1");

        Assertions.assertEquals(
                "Option 1",
                dropdownPage.getSelectedOption()
        );
    }

    @Test
    public void selectOptionTwoTest() {
        dropdownPage.selectOption("Option 2");

        Assertions.assertEquals(
                "Option 2",
                dropdownPage.getSelectedOption()
        );
    }
}
