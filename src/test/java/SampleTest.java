import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SampleTest
{

    public static void main(String[] args) {
//To create selenium Webdriver instance
        System.setProperty("webdriver.chrome.driver", "/Users/techops/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://spree-vapasi-prod.herokuapp.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

//To create a new account
       /* driver.findElement(By.id("link-to-login")).click();
        driver.findElement(By.linkText("Create a new account")).click();
        driver.findElement(By.id("spree_user_email")).sendKeys("beenabioinfo@gmail.com");
        driver.findElement(By.id("spree_user_password")).sendKeys("abc123");
        driver.findElement(By.id("spree_user_password_confirmation")).sendKeys("abc123");
        driver.findElement(By.name("commit")).click();*/

        //driver.findElement(By.xpath("//a[@class=\"list-group-item list-group-item-action\"]")).click();
//Login Scenario 1 - Happy Path (Valid credentials)

        driver.findElement(By.id("link-to-login")).click();
        driver.findElement(By.id("spree_user_email")).sendKeys("beenabioinfo@gmail.com");
        driver.findElement(By.id("spree_user_password")).sendKeys("abc123");

//Login Scenario 2 -  (Without entering UN and Pswd, click on Login)
        //driver.findElement(By.xpath("//a[@class=\"nav-link text-white\"]")).click();
        driver.findElement(By.xpath("//input[@class=\"btn btn-lg btn-success btn-block\"]")).click();
        //Alert alert = driver.switchTo().alert();
       // String actualText = alert.getText();

        //WebElement actualMsg = driver.findElement(By.xpath("//div[@class=\"alert alert-error\"]"));
        //String expectedMsg = "Invalid email or password.";
        //System.out.println(expectedMsg);
        //boolean condition = actualMsg.isDisplayed();
        //System.out.println("The alert with the text 'Invalid email or password.' appears when user clicks on 'Login' without entering details"+expectedMsg);
        //condition=true;
        //if(condition=false)
        //{

            /*System.out.println("The alert with the text 'Invalid email or password.' appears when user clicks on 'Login' without entering details"+expectedMsg);
            return true;*/
            //System.out.println("Login scenario 2 failed");
        //}
        /*System.out.println("Login scenario 2 failed");
        return false;*/

//Login Scenario 3 - Invalid Email and valid password
        /*driver.findElement(By.id("spree_user_email")).sendKeys("abc@xyz");
        driver.findElement(By.id("spree_user_password")).sendKeys("abc123");
        driver.findElement(By.xpath("//input[@class=\"btn btn-lg btn-success btn-block\"]")).click();

        String acMsg2 = driver.findElement(By.xpath("//div[@class=\"alert alert-error\"]")).getText();
        String exMsg2 = "Invalid email or password.";
        boolean alert;
        if(acMsg2.contentEquals(exMsg2))
        {
            System.out.println("Login scenario 3 passed");
            alert = true;
        }
        else {
            System.out.println("Login scenario 3 failed");
            alert = false;
        }*/
//Login scenario 4 - Valid email and invalid password
        /*driver.findElement(By.id("spree_user_email")).sendKeys("beenabioinfo@gmail.com");
        driver.findElement(By.id("spree_user_password")).sendKeys("abc123456789");
        driver.findElement(By.xpath("//input[@class=\"btn btn-lg btn-success btn-block\"]")).click();

        String acMsg3 = driver.findElement(By.xpath("//div[@class=\"alert alert-error\"]")).getText();
        String exMsg3 = "Invalid email or password.";
        boolean alert2;
        if(acMsg3.contentEquals(exMsg3))
        {
            System.out.println("Login scenario 4 passed");
            alert2 = true;
        }
        else {
            System.out.println("Login scenario 4 failed");
            alert2 = false;
        }*/
// Click on Bags after a successful Login and select the 2nd item from the list
        driver.findElement(By.xpath("//a[@class=\"list-group-item list-group-item-action\"]")).click();
        //Get the list of items------check
        /*WebElement list = (WebElement) driver.findElements(By.className(".card"));
        Dimension i = list.getSize();
        System.out.println("No of products listed in the page is "+i);*/
        driver.findElement(By.xpath("//span[@class=\"info mt-3 d-block\"and text()=\"Ruby on Rails Bag\"]")).click();
        String proTitle = driver.findElement(By.xpath("//h1[@class=\"product-title mt-2\"]")).getText();
        String actTitle = "Ruby on Rails Bag";
        boolean title;
        if(actTitle.contentEquals(proTitle))
        {
            System.out.println("Second item selected");
            title=true;
        }
        else
        {
            System.out.println("Wrong product selected");
            title=false;
        }
        //driver.close();
//Add to cart if the button is enabled

        WebElement cart = driver.findElement(By.id("add-to-cart-button"));
        if(cart.isEnabled())
        {
            cart.click();
            System.out.println("Product added to the cart");
            
        }
        else
        {
            System.out.println("The 'Add to Cart' button is disabled");
        }
        //driver.close();
//Invalid coupon code entry
        driver.findElement(By.id("order_coupon_code")).sendKeys("abcd");
        driver.findElement(By.xpath("//button[@class=\"btn btn-outline-secondary\"]")).click();

        String coupon = driver.findElement(By.xpath("//div[@id=\"coupon_status\"]")).getText();
        String couponErr = "The coupon code you entered doesn't exist. Please try again.";
        if(coupon.contentEquals(couponErr))
        {
            System.out.println("Coupon code validation successful");
        }
        else
        {
            System.out.println("Coupon validation unsuccessful");
        }

//Verify if the Total amount is displayed in the cart
        String total = driver.findElement(By.xpath("//h5[@class=\"mb-0\"]")).getText();
        String actualTotal = "Total";
        if(total.equals(actualTotal))
        {
            System.out.println("Total price displayed for the items in the cart");
        }
        else
        {
            System.out.println("Total price is not shown for the cart items");
        }

//Item quantity Update increment or decrement
        //driver.findElement(By.xpath("order_line_items_attributes_0_quantity")).click();
        driver.findElement(By.xpath("//input[@id=\"order_line_items_attributes_0_quantity\"]")).clear();
        driver.findElement(By.xpath("//input[@id=\"order_line_items_attributes_0_quantity\"]")).sendKeys("5");
        driver.findElement(By.id("update-button")).click();

//Item Delete ---unable to locate (//span[@class="glyphicon glyphicon-minus-sign"])
        //use CSS----.glyphicon-minus-sign
        driver.findElement(By.cssSelector(".glyphicon-minus-sign")).click();
        //driver.findElement(By.xpath("//a[@id=\"delete_line_item_249\"]")).click();
//Empty Cart
       /* driver.findElement(By.xpath("//input[@class=\"btn btn-outline-secondary\"]")).click();
        String cartEmptyMsg = driver.findElement(By.xpath("//div[@class=\"alert alert-info\"]")).getText();
        String cartEmptyMsgAct = "Your cart is empty";
        if(cartEmptyMsg.contentEquals(cartEmptyMsgAct))
        {
            System.out.println("Message validation successful when the shopping cart is empty");
        }
        else
        {
            System.out.println("Message validation Unsuccessful when the shopping cart is empty");
        }

//Continue shopping
        driver.findElement(By.xpath("//a[@class=\"btn btn-outline-secondary\"]")).click();
        System.out.println("Continue shopping");*/




    }

}


