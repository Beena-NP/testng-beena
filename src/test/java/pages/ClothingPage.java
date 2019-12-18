package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import util.DriverManager;

public class ClothingPage {

    public ClothingPage()
    {
        PageFactory.initElements(DriverManager.driver, this);
    }
    /*@FindBy(xpath = "//ol[@class=\"breadcrumb\"]")
    private String headingClothing;*/

    public void headingChk()
    {
        String actHeading = DriverManager.driver.getTitle();
        Assert.assertTrue(actHeading.contains("Clothing"));
        System.out.println("The Clothing page title is " + actHeading);

    }



}
