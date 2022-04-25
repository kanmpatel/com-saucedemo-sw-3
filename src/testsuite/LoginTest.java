package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class LoginTest extends Utility {
    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp(){

        openBrowser(baseUrl);
    }
    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials(){
        //find the element of username and send the username key
        sendTextToElement(By.name("user-name"),"standard_user");
        //find the element of password and send the password key
        sendTextToElement(By.name("password"),"secret_sauce");
        //click on loging button using elements
        clickOnElement(By.cssSelector(".submit-button"));
        //this os form requirement
        String expectedLogInText = "PRODUCTS";
        //find the welcome text element and get the text
        String actualLogInText = getTextFromElement(By.xpath("//span[@class='title']"));
        //Verify the text error message with assert
        verifyTextMessage(expectedLogInText,actualLogInText);
    }
    @Test
    public void verifyThatSixProductsAreDisplayedOnPage(){
        userSholdLoginSuccessfullyWithValidCredentials();
        //this os form requirement
        int expectedProductList = 6;
        // Class name locator ---To find multiple elements
        List<WebElement> actualProductsListElements = getTheListOfElement(By.className("inventory_item_name"));
        int actualProductList = actualProductsListElements.size();
        //Verify the text error message with assert
        Assert.assertEquals(expectedProductList,actualProductList);
    }
    @After
    public void tearDown(){
        //close the browser
        closeBrowser();
    }

}
