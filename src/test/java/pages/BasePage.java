package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import suite.SuiteManager;
import util.DriverManager;

public class BasePage extends SuiteManager {

    @FindBy(xpath ="//a[@class=\"nav-link text-white\"]")
    private WebElement loginButton;

    //@FindBy(linkText = "Create a new account")
    //private WebElement createAccnt;

    public BasePage()
    {
        PageFactory.initElements(DriverManager.driver,this);
    }

    public LoginPage clickLoginButton()
    {
        WebDriverWait wait=new WebDriverWait(DriverManager.driver,70);
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();
        return new LoginPage();

    }

    /*public void createNewAccnt()
    {
        WebDriverWait wait=new WebDriverWait(DriverManager.driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(createAccnt));
        createAccnt.click();
    }*/

}
