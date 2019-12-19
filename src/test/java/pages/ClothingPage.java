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
    //@FindBy(xpath = "//*[@id=\"content\"]/h1")
    //private WebElement headingClothing;

    public void headingChk()
    {
        //String actHead = String.valueOf(headingClothing);
        //System.out.println(actHead);
        //String expHead = "Clothing";
        //Assert.assertEquals(actHead,expHead);
        //System.out.println("The heading 'Clothing' is displayed");*/

        //System.out.println(text);
        String actHeading = DriverManager.driver.getTitle();
        Assert.assertTrue(actHeading.contains("Clothing"));
        System.out.println("The Clothing page title is " + actHeading);

    }



}
