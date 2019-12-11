package tests;

import org.testng.annotations.Test;
import pages.BasePage;
import pages.LoginPage;
import pages.PasswordReset;
import suite.SuiteManager;
import testdata.loginCredentials;
import util.ConfigFileReader;

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
       System.out.println("User navigated to Password recovery page");
       ConfigFileReader con = new ConfigFileReader();
       String resetEmail = con.getProperty("username");
       passwordReset.resetPassword(resetEmail);
       System.out.println("From the Password recovery page the user has navigated back to the Login Page");

    }

}
