package driver;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.apache.logging.log4j.LogManager.getLogger;

public class DriverOperations {

    private final static Logger logger = getLogger(DriverOperations.class);
    protected static final long EXPLICIT_WAIT = 5;
    protected static final long LOADWEBSITE_TIME = 5;

    protected static WebDriverWait wait;
    protected static WebDriver driver;


    protected void setLoadTime() {
        if (driver != null) {
            logger.info(String.format("DriverOperations :: getDriver() :: Set page load timeout to %o", LOADWEBSITE_TIME));

            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(LOADWEBSITE_TIME));
        }
    }

    protected void maximizeNavigate() {
        if (driver != null) {
            driver.manage().window().maximize();
        }
    }

    protected void navigateToUrl(String url) {
        if (driver != null) {
            driver.get(url);
        }
    }

    protected void deleteAllCookies() {
        if (driver != null) {
            driver.manage().deleteAllCookies();
        }
    }


}
