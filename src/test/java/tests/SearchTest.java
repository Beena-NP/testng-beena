package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import suite.SuiteManager;
import testdata.loginCredentials;
import util.ConfigFileReader;
import util.DriverManager;

public class SearchTest extends SuiteManager {

    @Test

    public void search()
    {
        ConfigFileReader con = new ConfigFileReader();
        String item = con.getProperty("searchItem");
        DriverManager.driver.findElement(By.xpath("//input[@id=\"keywords\"]")).sendKeys(item);
        DriverManager.driver.findElement(By.xpath("//input[@class=\"btn btn-success\"]")).click();

    }


}
