package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import suite.SuiteManager;
import util.DriverManager;

public class BasePage extends SuiteManager {

    @FindBy(xpath ="//a[@class=\"nav-link text-white\"]")
    private WebElement loginButton;

    public BasePage()
    {
        PageFactory.initElements(DriverManager.driver,this);
    }

    public LoginPage clickLoginButton()
    {
        //driver.wait for that element --- explicitwait (another wait, fluent wait.. check if the element has appeared or not etc.
        loginButton.click();
        return new LoginPage();
    }


}
