package tests;

import org.testng.annotations.Test;
import pages.BasePage;
import pages.LoginPage;
import pages.PasswordReset;
import suite.SuiteManager;
import testdata.loginCredentials;

public class ExpConditions extends SuiteManager {
    public BasePage basePage;
    public LoginPage loginPage;
    public PasswordReset passwordReset;
    @Test
    public void passwordReset()
    {
       basePage = new BasePage();
       loginPage = basePage.clickLoginButton();
       passwordReset = loginPage.recoverPassword();

    }

}
