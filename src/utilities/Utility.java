package utilities;


import browserfactory.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Utility extends BaseTest {
    public static Actions actions;
    /**
     * this method will find the element in browser
     */
    public WebElement findElementsOnBrowser(By by){
        WebElement element = driver.findElement(by);
        return element;
    }
    /**
     * this method will click on elements
     */
    public void clickOnElement(By by){
       WebElement element = driver.findElement(by);
       element.click();
    }

    /**
     * this method will get the text form the elements
     */
    public String getTextFromElement(By by){
        WebElement element = driver.findElement(by);
        return element.getText();
    }
    /**
     * this method will get list of elements
     */
    public List<WebElement> getTheListOfElement(By by){
        return driver.findElements(by);
    }
    /**
     * this method will send the text in the elements
     */

    public void sendTextToElement(By by,String key){
        WebElement element = driver.findElement(by);
        element.sendKeys(key);
    }
  //  ********************************** Alert methods  ******************************
    /**
     * switch to alert
     */
    public void switchToAlert(){

        driver.switchTo().alert();
    }
    public void acceptToAlert(){

        driver.switchTo().alert().accept();
    }
    public void dismissToAlert(){

        driver.switchTo().alert().dismiss();
    }

    public String getAlertMessage(){
        return driver.switchTo().alert().getText();
    }

    //*******************************Select All methods for dropdown ************
    /**
     * This method will select the option by visible text
     */
    public void selectByVisibleTextFromDropDown(By by, String text){
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByVisibleText(text);
    }
    public void selectByValueFromDropDown(By by, String text){
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByValue(text);
    }
    public void selectByIndexFromDropDown(By by, int index){
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByIndex(index);
    }
    //***********************************Assert verification***************************
    /**
     * This method will verify the text using Asserts
     */
    public void verifyTextMessage(String expectedData,String actualData){
        Assert.assertEquals(expectedData,actualData);
    }
    //*****************************Mouse hover on element************************************
    /**
     * This method will mouse hover on element
     */
    public void mouseHoverOnElement(By by){
        actions = new Actions(driver);
        WebElement element = findElementsOnBrowser(by);
        actions.moveToElement(element).build().perform();
    }
    /**
     * This method will click on mouse hover elements
     */
    public void clickOnMouseHoverOnElement(By by){
        actions = new Actions(driver);
        WebElement element = findElementsOnBrowser(by);
        actions.moveToElement(element).click().build().perform();
    }


}
