package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import suite.SuiteManager;
import util.DriverManager;

public class HomePage extends SuiteManager {

    public HomePage()
    {
        PageFactory.initElements(DriverManager.driver,this);
    }
    @FindBy(xpath = "//div[@class=\"alert alert-success\"]")
    private WebElement loginMsg;

    @FindBy(xpath = "//input[@id=\"keywords\"]")
    private WebElement searchField;

    @FindBy(xpath = "//input[@class=\"btn btn-success\"]")
    private WebElement searchButton;

    @FindBy(xpath = "//a[text()=\"Clothing\"]")
    private WebElement clothing;

    /*public void setLoginMsg(WebElement loginMsg) {
        this.loginMsg = loginMsg;
    }*/

    public void waitMsg()
    {
        WebDriverWait wait = new WebDriverWait(DriverManager.driver, 30);
        wait.until(ExpectedConditions.visibilityOf(loginMsg));
        System.out.println("User has successfully logged in to Spree");

    }
    public void action(WebElement field, String value)
    {
        field.click();
        field.sendKeys(value);

    }
     public void searchPro(String item)
     {
         action(searchField, item);
         searchButton.click();

     }
     public void clickClothing()
     {
         //WebDriverWait wait = new WebDriverWait(DriverManager.driver,50);
         //wait.until(ExpectedConditions.elementToBeClickable(clothing));
         clothing.click();
         //return new ClothingPage();
     }

}
