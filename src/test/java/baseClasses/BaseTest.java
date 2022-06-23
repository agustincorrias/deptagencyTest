package baseClasses;


import driver.DriverManager;
import enums.Browsers;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static org.apache.logging.log4j.LogManager.getLogger;

public class BaseTest {

    private final static Logger logger = getLogger(BaseTest.class);

    private final static String webSite = "https://www.gamesforthebrain.com/game/checkers/";

    protected static DriverManager driverManager;

    @BeforeAll
    public static void setUpSuite() throws Exception {
        logger.info("BaseTest :: setUpSuite() :: Getting driver and open Chrome webpage");
        driverManager = new DriverManager(webSite, Browsers.CHROME);
    }


    @AfterAll
    public static void tearDownSuite(){
        logger.info("BaseTest :: tearDownSuite() :: tearDownSuite with driver");
        if(driverManager.getDriver()!=null){
            driverManager.getDriver().quit();
        }
    }


}
