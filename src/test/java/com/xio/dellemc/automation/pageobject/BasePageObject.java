package com.xio.dellemc.automation.pageobject;

import com.xio.dellemc.automation.common.core.Wait;
import org.openqa.selenium.*;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * Created by aleks on 26.03.17.
 */
public class BasePageObject {

    protected final WebDriver driver;
    private WebElement webElement;
    private int timeOut = 15;
    protected Wait wait;
    protected final Logger LOGGER = Logger.getLogger(BasePageObject.class.getName());

    public BasePageObject(WebDriver driver) {
        this.driver = driver;
        this.wait = new Wait(driver);
    }

    // Method returns a current timestamp
    public static String getTimeStamp() {
        Date time = new Date();
        long timeCurrent = time.getTime();
        return String.valueOf(timeCurrent);
    }

    // Returns current driver object
    protected WebDriver getDriverObject() {
        return this.driver;
    }

    // Method returns String value from an inner field element using JavaScript
    protected String getInnerFieldText(By by) {
        webElement = driver.findElement(by);
        return (String) ((JavascriptExecutor)driver).executeScript("return arguments[0].value",webElement);
    }

    // Simple method for checking if element is on page or not. Changing the implicitWait value allows
    protected boolean isElementOnPage(By by) {
        changeImplicitWait(500, TimeUnit.MILLISECONDS);
        try {
            return driver.findElements(by).size() > 0;
        } finally {
            restoreDefaultImplicitWait();
        }
    }

    // Simple method for checking if element is on page or not. Changing the implicitWait value allows
    protected boolean isElementOnPage(WebElement element) {
        changeImplicitWait(500, TimeUnit.MILLISECONDS);
        boolean isElementOnPage = true;
        try {
            // Get location on WebElement is rising exception when element is not present
            element.getLocation();
        } catch (WebDriverException ex) {
            isElementOnPage = false;
        } finally {
            restoreDefaultImplicitWait();
        }
        return isElementOnPage;
    }

    // Method to check if WebElement is displayed on the page
    protected boolean isElementDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    // Method to check if WebElement is displayed on the page
    protected boolean isElementDisplayed(By by) {
        try {
            return driver.findElement(by).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    // Checks whether an element Enabled or Disabled
    protected boolean isElementEnabled(By by){
        try {
            return driver.findElement(by).isEnabled();
        } catch (WebDriverException e) {
            return false;
        }
    }

    // Checks whether an element Enabled or Disabled
    protected boolean isElementEnabled(WebElement element){
        try {
            return element.isEnabled();
        } catch (WebDriverException e) {
            return false;
        }
    }

    // Checks that a field does not contain any test in itself
    protected boolean isFieldEmpty(By by) {
        return getInnerFieldText(by).equals("");
    }

    // Method to make clean up a field
    protected void clearFieldFromText(By by) {
        webElement = driver.findElement(by);
        if(!(isFieldEmpty(by))) {
//            ((JavascriptExecutor)driver).executeScript("arguments[0].value == '';",webElement);
            webElement.sendKeys(Keys.CONTROL + "a");
            webElement.sendKeys(Keys.DELETE);
        } else {
            System.out.println("Field is empty. There is nothing to clear.");
        }
    }

    //  Method wrapper for webelement.click option adapted for By.locator objects
    protected void clickOnElement(By by) {
        driver.findElement(by).click();
    }

    // Method's name speaks for itself
    public void refreshPage() {
        try {
            driver.navigate().refresh();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }

    // Just method to wait for a X milliseconds (wrapper for Thread.sleep() method)
    public void waitForXmiliseconds(int timeout) {
        wait.forXmilliseconds(timeout);
    }

    //  Utility method to customise Drivers implicit wait
    private void changeImplicitWait(int value, TimeUnit timeUnit) {
        driver.manage().timeouts().implicitlyWait(value, timeUnit);
    }

    //  Utility method to return implicit wait to his default state
    private void restoreDefaultImplicitWait() {
        changeImplicitWait(timeOut, TimeUnit.SECONDS);
    }


}
