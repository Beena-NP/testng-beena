package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;
import suite.SuiteManager;
import testdata.loginCredentials;
import util.ConfigFileReader;
import util.DriverManager;

import java.util.ArrayList;
import java.util.List;

public class SearchAssignment extends SuiteManager {


    public BasePage basePage;
    public LoginPage loginPage;
    public HomePage homePage;

    ConfigFileReader readItem = new ConfigFileReader();
    public String keyword = readItem.getProperty("searchItem");

    @Test(priority = 0, dataProvider = "loginCredentials", dataProviderClass = loginCredentials.class)

    public void loginMsg(String loginId, String password) throws InterruptedException {
        Thread.sleep(1000);
        basePage = new BasePage();
        loginPage = basePage.clickLoginButton();
        homePage = loginPage.login(loginId, password);
        homePage.waitMsg();

    }

    @Test(priority = 1)
    public void search()
    {

        homePage.searchPro(keyword);
        System.out.println("The search keyword is " +keyword);

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
        String actName = null;
        for(WebElement prod : products)
        {
            System.out.println(prod.getText());
            actName = prod.getText();

            //Assert.assertTrue(actName.contains(keyword));
            //Assert.assertEquals(actName.contains(keyword), "Name has keyword");
            //System.out.println("The product name contain the search keyword "+keyword);

            if(actName.contains(keyword))
            {
                System.out.println("The product name contains the search keyword "+keyword);

            }
            else
            {
                System.out.println("The product name does not contain the search keyword "+keyword);

            }
        }
        /*for(int j=0;j<list.size();j++)
        {
          //  Assert.assertTrue(actName.equalsIgnoreCase((keyword)), "The product names do not contain the search keyword");
            if(actName.contains(keyword))
            {
                System.out.println("The product names contain the search keyword "+keyword);
            }
            else
            {
                System.out.println("The product names do not contain the search keyword "+keyword);
            }
        }*/

        //Assert.assertTrue(actName.contains(keyword));
        //System.out.println("The product names contain the search keyword "+keyword);

        /*products.get(0);
        products.get(1);
        System.out.println(products.get(0));
        System.out.println(products.get(1));*/

        //return products; ArrayList<WebElement>


    }


}

/*
public BasePage basePage;
    public LoginPage loginPage;
    public static HomePage homePage;

    public List<WebElement> list;
    ConfigFileReader readItem = new ConfigFileReader();
    String keyword = readItem.getProperty("searchItem");


    @Test(priority = 0, dataProvider = "loginCredentials", dataProviderClass = loginCredentials.class)

    public void loginMsg(String loginId, String password) throws InterruptedException {
        Thread.sleep(1000);
        basePage = new BasePage();
        loginPage = basePage.clickLoginButton();
        homePage = loginPage.login(loginId, password);
        homePage.waitMsg();

    }

    @Test(priority = 1)
    public void search()
    {

        homePage.searchPro(keyword);
        System.out.println("The search keyword is " +keyword);

    }

    @Test(priority = 2)
    public void searchResult()  {

        String prodList = "div[id^='product_']";
        list = DriverManager.driver.findElements(By.cssSelector(prodList));
        int listSize = list.size();

        ArrayList<String> products = new ArrayList<String>();

        if(listSize>0) {
            System.out.println("No of products listed in the page is " + listSize);

            for (int i = 0; i < list.size(); i++) {

                String actName = list.get(i).getText();
                System.out.println(actName);

                //Assert.assertTrue(actName.contains(keyword));
                //Assert.assertEquals(actName.contains(keyword), "Name has keyword");
                //System.out.println("The product name contain the search keyword "+keyword);

                if (actName.contains(keyword)) {
                    products.add(actName);
                    System.out.println("The product name contain the search keyword " +keyword);

                } else {
                    System.out.println("The product name does not contain the search keyword " +keyword);

                }

            }
        }
        else
        {
            System.out.println("No products found!");
        }
        /*for(int j=0;j<list.size();j++)
        {
          //  Assert.assertTrue(actName.equalsIgnoreCase((keyword)), "The product names do not contain the search keyword");
            if(actName.contains(keyword))
            {
                System.out.println("The product names contain the search keyword "+keyword);

            }
            else
            {
                System.out.println("The product names do not contain the search keyword "+keyword);

            }
        }*/

//Assert.assertTrue(actName.contains(keyword));
//System.out.println("The product names contain the search keyword "+keyword);

        /*products.get(0);
        products.get(1);
        System.out.println(products.get(0));
        System.out.println(products.get(1));*/

//return products;


   // }


//} */
