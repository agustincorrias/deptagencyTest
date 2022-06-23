package selenium;

import driver.DriverManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static org.apache.logging.log4j.LogManager.getLogger;

public class ElementOperations {

    private final static Logger logger = getLogger(ElementOperations.class);

    private final DriverManager driverManager;

    public ElementOperations(DriverManager driverManager) {
        this.driverManager = driverManager;
    }


    protected void clickElement(By element) {
        logger.info(String.format("ElementOperations :: clickElement()  :: Trying to click element %s", element));
        WebElement e = driverManager
                .getWait()
                .until(ExpectedConditions.elementToBeClickable(
                        driverManager
                                .getDriver()
                                .findElement(element)
                ));
        e.click();
    }

    protected void waitFor(double seconds) {
        try {
            Thread.sleep((long) (seconds * 1000));
        } catch (InterruptedException e) {
            logger.error(String.format("ElementOperations :: waitFor() :: InterruptedException %s", e.getLocalizedMessage()));
            throw new RuntimeException(e);
        }
    }

    protected void moveChip(By chip, By space) {
        clickElement(chip);
        clickElement(space);
    }

    protected int countChips(By chips) {
        List<WebElement> number = driverManager.getDriver().findElements(chips);
        return number.size();
    }


}
