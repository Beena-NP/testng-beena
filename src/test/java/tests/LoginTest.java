package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;
import suite.SuiteManager;
import testdata.loginCredentials;
import util.DriverManager;

import javax.swing.text.Document;

public class LoginTest extends SuiteManager {

    public BasePage basePage;
    public LoginPage loginPage;
    public HomePage homePage;

    /*@Test(priority = 0)
    public void clickLogin()
    {
        basePage = new BasePage();
        basePage.clickLoginButton();
    }*/

    /*@Test(priority = 1)
    public void login()
    {
       //loginPage = new LoginPage();
       loginPage = basePage.clickLoginButton();
       homePage = loginPage.login(loginId,password);

    }*/

    @Test(dataProvider = "loginCredentials", dataProviderClass = loginCredentials.class)
    public void login(String loginId, String password) throws InterruptedException {

        Thread.sleep(1000);
        basePage = new BasePage();
        loginPage = basePage.clickLoginButton();
        homePage = loginPage.login(loginId,password);

        //DriverManager.driver.findElement(By.id("link-to-login")).click();
        //DriverManager.driver.findElement(By.id("spree_user_email")).sendKeys(loginId);
        //DriverManager.driver.findElement(By.id("spree_user_password")).sendKeys(password);
        //DriverManager.driver.findElement(By.xpath("//input[@class=\"btn btn-lg btn-success btn-block\"]")).click();
        System.out.println("Logged in");

        /*-------Actions builder = new Actions(DriverManager.driver); then
                 builder.*/
        /*JavascriptExecutor js = (JavascriptExecutor) DriverManager.driver;
        js.executeScript("Document.getText()");
        ((JavascriptExecutor) DriverManager.driver).executeScript("");*/


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
