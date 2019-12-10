package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.DriverManager;

public class PasswordReset {

    public PasswordReset()
    {
        PageFactory.initElements(DriverManager.driver, this);
    }

    @FindBy(xpath = "//input[@id = \"spree_user_email\"]")
    private WebElement emailRecover;
    @FindBy(xpath = "//input[@class = \"btn btn-lg btn-success btn-block\"]")
    private WebElement resetBtn;

    public void enterValue(WebElement field, String value)
    {
        field.click();
        field.sendKeys(value);
    }
    public void resetPassword(String username)
    {
        enterValue(emailRecover, username);
        WebDriverWait wait=new WebDriverWait(DriverManager.driver,30);
        wait.until(ExpectedConditions.elementToBeClickable(resetBtn));
        resetBtn.click();
    }

}
