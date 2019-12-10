package suite;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import util.ConfigFileReader;
import util.DriverManager;

public class SuiteManager {
    DriverManager driverManager;
    private static ConfigFileReader config = new ConfigFileReader();

    @BeforeSuite(alwaysRun = true)
    public void startDriver()
    {
        driverManager = new DriverManager();

    }
   @AfterSuite(alwaysRun = true)
    public void quitDriver()
    {
        DriverManager.driver.quit();
    }

    //kiosk mode run of a browser is also possible -- example is ATM machine
    @BeforeClass
    public void launchUrl()
    {
        DriverManager.driver.manage().window().maximize();
        String baseUrl = config.getProperty("base_url");
        DriverManager.driver.get(baseUrl);

    }
    /*@BeforeTest
    public void credentials()
    {
        String username = config.getProperty("username");
        String passowrd = config.getProperty("password");

    }*/



}
