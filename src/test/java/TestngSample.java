import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestngSample {
    @Test
    public void VerifyLoginLogout()
    {
        /*String baseUrl = "https://spree-vapasi-prod.herokuapp.com/";
        String chromeDriverPath = "/Users/techops/Downloads/chromedriver";
        String loginId = "beenabioinfo@gmail.com";
        String password = "abc123";
        String loginLinkSelector =*/

        System.setProperty("webdriver.chrome.driver", "/Users/techops/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://spree-vapasi-prod.herokuapp.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.id("link-to-login")).click();
        driver.findElement(By.id("spree_user_email")).sendKeys("beenabioinfo@gmail.com");
        driver.findElement(By.id("spree_user_password")).sendKeys("abc123");
        driver.findElement(By.xpath("//input[@class=\"btn btn-lg btn-success btn-block\"]")).click();
        driver.quit();
    }

}
