import baseClasses.BaseTest;
import org.junit.jupiter.api.Test;
import site.MainPage;

import static org.junit.jupiter.api.Assertions.*;

public class TestOne extends BaseTest {

    @Test
    public void firstTest() {
        int firstChipsSecondPlayer;
        MainPage mainPage = new MainPage(driverManager);
        mainPage.acceptPrivacy();
        firstChipsSecondPlayer = mainPage.countChipsFirstPlayer();
        mainPage.firstMove();
        assertNotEquals(firstChipsSecondPlayer, mainPage.countChipsFirstPlayer(), "The game doesn't works correctly");
    }
}



