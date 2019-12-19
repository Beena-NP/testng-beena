package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.ClothingPage;
import pages.HomePage;
import pages.LoginPage;
import suite.SuiteManager;
import testdata.loginCredentials;
import util.ConfigFileReader;
import util.DriverManager;

import java.util.ArrayList;
import java.util.List;

public class AssignmentScenarios extends SuiteManager {

    public BasePage base;
    public LoginPage login;
    public HomePage home;
    public ClothingPage cloth;

    public String item = "//span[@class=\"info mt-3 d-block\" and text()=\"Spree Jr. Spaghetti\"]";
    public String itemName = "//h1[@class=\"product-title mt-2\"]";
    public String cartButon = "add-to-cart-button";
    public String coupon = "order_coupon_code";
    public String applyCoupon = "//button[@class=\"btn btn-outline-secondary\"]";
    public String couponMsg = "//div[@id=\"coupon_status\"]";


   @Test(priority = 0)

    public void login() throws InterruptedException
    {
        Thread.sleep(1000);

        base = new BasePage();
        login = base.clickLoginButton();

    //Read the credentials from config file
        ConfigFileReader con = new ConfigFileReader();
        String uname = con.getProperty("username");
        String pwd = con.getProperty("password");

        home = login.login(uname,pwd);
        System.out.println("User logged in to Spree");

    }


    @Test(priority = 1)

    public void checkSearchUrl()
    {
        home.clickClothing();
        cloth = new ClothingPage();
        cloth.headingChk();

        ConfigFileReader con = new ConfigFileReader();
        String linkClothing = con.getProperty("searchLink1");
        String urlText = DriverManager.driver.getCurrentUrl();
        Assert.assertTrue(urlText.contains(linkClothing));
        System.out.println("URL contains the search category "+linkClothing);

    }
    @Test(priority = 2)
    public void searchResult()
    {

        String prodList = "div[id^='product_']";
        List<WebElement> list = DriverManager.driver.findElements(By.cssSelector(prodList));
        Integer listSize = list.size();
        System.out.println("No of products listed in the page is "+listSize);


        ArrayList<WebElement> products = new ArrayList<>();

        for (int i = 0; i < list.size(); i++)
        {
            products.add(list.get(i));

        }
        DriverManager.driver.findElement(By.xpath(item)).click();
        String expProName = DriverManager.driver.findElement(By.xpath(itemName)).getText();
        String actProName = "Spree Jr. Spaghetti";
        Assert.assertEquals(actProName,expProName);
        System.out.println("Product details page is displayed");

     //Add to cart if the button is enabled
        WebElement cart = DriverManager.driver.findElement(By.id(cartButon));
        Assert.assertTrue(cart.isEnabled());
        cart.click();
        System.out.println("Product added to the cart");

     //Invalid Coupon code entry
        DriverManager.driver.findElement(By.id(coupon)).sendKeys("abcd");
        DriverManager.driver.findElement(By.xpath(applyCoupon)).click();
        String couponValidationActualMsg = DriverManager.driver.findElement(By.xpath(couponMsg)).getText();
        String couponValidationExpMsg = "The coupon code you entered doesn't exist. Please try again.";
        Assert.assertEquals(couponValidationActualMsg,couponValidationExpMsg);
        System.out.println("Coupon validation successful");
        DriverManager.driver.findElement(By.id(coupon)).clear();





    }



}
