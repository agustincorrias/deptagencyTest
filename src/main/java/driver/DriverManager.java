package driver;

import enums.Browsers;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.apache.logging.log4j.LogManager.getLogger;

public class DriverManager extends DriverOperations {

    private final static Logger logger = getLogger(DriverManager.class);

    public DriverManager(String url, Browsers browser) throws Exception {
        if (url == null && browser == null) {
            throw new Exception("URL or Browser must not be NULL");
        }
        try {
            switch (browser) {
                case CHROME:
                    ChromeOptions chromeOptions = new ChromeOptions();
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    logger.info(String.format("DriverManager :: DriverManager() ::  new driver Chrome created"));
                    break;
                default:
                    logger.error(String.format("DriverManager :: DriverManager() ::  invalid selection of navigate : %s " + browser));
                    throw new Exception("Must be complete the correct navigate.");
            }
            if (driver != null) {
                wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
                setLoadTime();
                maximizeNavigate();
                deleteAllCookies();
                navigateToUrl(url);
            }
        } catch (Exception e) {
            logger.error(String.format("DriverManager :: DriverManager() :: %s", e.getCause()));
            e.printStackTrace();
        }
    }

    public WebDriverWait getWait() {
        if (wait == null) {
            logger.error("DriverOperations :: getWait() :: wait is NULL");
            return null;
        }
        return wait;
    }

    public WebDriver getDriver() {
        if (driver == null) {
            logger.error("DriverOperations :: getDriver() :: driver is NULL");
            return null;
        }
        return driver;
    }

}
