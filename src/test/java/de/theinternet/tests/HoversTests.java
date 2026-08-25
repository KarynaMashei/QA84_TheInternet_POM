package de.theinternet.tests;

import de.theinternet.core.TestBase;
import de.theinternet.pages.HoversPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HoversTests extends TestBase {

    private HoversPage hoversPage;

    @BeforeEach
    public void openHoversPage() {
        hoversPage = new HoversPage(driver).openPage();
    }

    @Test
    public void hoverOverAllUsersTest() {
        for (int userNumber = 1; userNumber <= 3; userNumber++) {
            hoversPage.hoverOverUser(userNumber);

            Assertions.assertTrue(hoversPage.isUserCaptionVisible(userNumber));
            Assertions.assertEquals(
                    "name: user" + userNumber,
                    hoversPage.getUserName(userNumber)
            );
            Assertions.assertTrue(
                    hoversPage.getProfileLink(userNumber)
                            .endsWith("/users/" + userNumber)
            );
        }
    }
}
