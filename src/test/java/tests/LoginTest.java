package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import suite.SuiteManager;
import testdata.loginCredentials;
import util.DriverManager;

public class LoginTest extends SuiteManager {

    /*String LoginBtn="//a[contains(text(),'Login')";
    String username="spree_user[email]";
    String pwds="spree_user[password]";
    String LoginBtn1="//input[@class='btn btn-lg btn-success btn-block']";
    String actmsg="//div[.='Logged in successfully']";*/

    @Test(dataProvider = "loginCredentials", dataProviderClass = loginCredentials.class)

      public void login(String loginId, String password) throws InterruptedException {

        Thread.sleep(5000);
        DriverManager.driver.findElement(By.id("link-to-login")).click();
        DriverManager.driver.findElement(By.id("spree_user_email")).sendKeys(loginId);
        DriverManager.driver.findElement(By.id("spree_user_password")).sendKeys(password);
        DriverManager.driver.findElement(By.xpath("//input[@class=\"btn btn-lg btn-success btn-block\"]")).click();
        System.out.println("Logged in");
        /*DriverManager.driver.findElement(By.id(LoginBtn)).click();
        DriverManager.driver.findElement(By.id(username).sendKeys("beenabioinfo@gmail.com");
        DriverManager.driver.findElement(By.id("spree_user_password")).sendKeys("abc123");
        DriverManager.driver.findElement(By.xpath(LoginBtn1)).click();
        System.out.println(actmsg);*/

        /* From config file, read username n password

         public void login()
         {
            ConfigFileReader con = new ConfigFileReader();
            String uname = con.getProperty("username");
            String paswd = con.getProperty("password");
            DriverManager.driver.findElement(By.id("link-to-login")).click();
            DriverManager.driver.findElement(By.id("spree_user_email")).sendKeys(uname);
            DriverManager.driver.findElement(By.id("spree_user_password")).sendKeys(paswd);
            DriverManager.driver.findElement(By.xpath("//input[@class=\"btn btn-lg btn-success btn-block\"]")).click();

         }

         */


    }




}
