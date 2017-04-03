package com.xio.dellemc.automation.common.core;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by OPudlo on 27.03.2017.
 */
public class Wait {

    private static final int DEFAULT_TIMEOUT = 15;

    private WebDriverWait wait;
    private WebDriver driver;
    private final static Logger LOGGER = Logger.getLogger(Wait.class.getName());

    public Wait(WebDriver webDriver) {
        this.driver = webDriver;
        this.wait = new WebDriverWait(webDriver, DEFAULT_TIMEOUT);
    }

    // Checks if the element is present in DOM
    public WebElement forElementPresentInDOM(By by) {
        return forElementPresentInDOM(by, true);
    }

    public WebElement forElementPresentInDOM(By by, boolean failOnTimeOut) {
        changeImplicitWait(250, TimeUnit.MILLISECONDS);
        try {
            return wait.until(ExpectedConditions.presenceOfElementLocated(by));
        } catch (TimeoutException e) {
            throw e;
        } finally {
            restoreDefaultImplicitWait();
        }
    }

    public WebElement forElementPresentInDOM(By by, int timeout) {
        changeImplicitWait(250, TimeUnit.MILLISECONDS);
        try {
            return new WebDriverWait(driver, timeout).until(ExpectedConditions.presenceOfElementLocated(by));
        } catch (TimeoutException e) {
            throw e;
        } finally {
            restoreDefaultImplicitWait();
        }
    }

    // Checks if the element is clickable in browser
    public WebElement forElementClickable(WebElement element) {
        changeImplicitWait(0, TimeUnit.MILLISECONDS);
        try {
            return wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (WebDriverException e) {
            throw e;
        } finally {
            restoreDefaultImplicitWait();
        }
    }

    public WebElement forElementClickable(WebElement element, int timeout) {
        changeImplicitWait(0, TimeUnit.MILLISECONDS);
        try{
            return new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(element));
        } catch (WebDriverException e) {
            throw e;
        } finally {
            restoreDefaultImplicitWait();
        }
    }

    public WebElement forElementClickable(By by) {
        changeImplicitWait(250, TimeUnit.MILLISECONDS);
        try {
            return wait.until(ExpectedConditions.elementToBeClickable(by));
        } finally {
            restoreDefaultImplicitWait();
        }
    }

    public WebElement forElementClickable(By by, int timeout) {
        changeImplicitWait(250, TimeUnit.MILLISECONDS);
        try {
            return new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(by));
        } finally {
            restoreDefaultImplicitWait();
        }
    }

    // Checks if the element is visible in browser
    public WebElement forElementVisible(WebElement element) {
        changeImplicitWait(250, TimeUnit.MILLISECONDS);
        try {
            return wait.until(ExpectedConditions.visibilityOf(element));
        } finally {
            restoreDefaultImplicitWait();
        }
    }

    public  WebElement forElementVisible(WebElement element, int timeout, int polling) {
        changeImplicitWait(250, TimeUnit.MILLISECONDS);
        try {
            return new WebDriverWait(driver, timeout, polling).until(ExpectedConditions.visibilityOf(element));
        } finally {
            restoreDefaultImplicitWait();
        }
    }

    public WebElement forElementVisible(By by) {
        changeImplicitWait(250, TimeUnit.MILLISECONDS);
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } finally {
            restoreDefaultImplicitWait();
        }
    }

    public WebElement forElementVisible(By by, int timeout, int polling) {
        changeImplicitWait(250, TimeUnit.MILLISECONDS);
        try {
            return new WebDriverWait(driver, timeout, polling).until(ExpectedConditions.visibilityOfElementLocated(by));
        } finally {
            restoreDefaultImplicitWait();
        }
    }

    // Checks if the text is not in element
    public boolean forTextNotInElement(By by, String text) {
        changeImplicitWait(0, TimeUnit.MILLISECONDS);
        try {
            return wait.until(CommonExpectedConditions.textToBeNotPresentInElement(by, text));
        } finally {
            restoreDefaultImplicitWait();
        }
    }

    public boolean forTextNotInElement(WebElement element, String text) {
        changeImplicitWait(0, TimeUnit.MILLISECONDS);
        try {
            return wait.until(CommonExpectedConditions.textToBeNotPresentInElement(element, text));
        } finally {
            restoreDefaultImplicitWait();
        }
    }

    // Checks if the test is in element
    public boolean forTextInElement(By by, String text) {
        changeImplicitWait(0, TimeUnit.MILLISECONDS);
        try {
            return wait.until(CommonExpectedConditions.textToBePresentInElement(by, text));
        } finally {
            restoreDefaultImplicitWait();
        }
    }

    public boolean forTextInElement(WebElement element, String text) {
        changeImplicitWait(0, TimeUnit.MILLISECONDS);
        try {
            return  wait.until(CommonExpectedConditions.textToBePresentInElement(element, text));
        } finally {
            restoreDefaultImplicitWait();
        }
    }

    // Utility methods to help with handle of set new and restore default implicit wait and wrapper for Thread.sleep method
    public void forXmilliseconds(int time) {
        LOGGER.log(Level.INFO,"Wait for " + time + " ms.");
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            LOGGER.log(Level.WARNING, "Wait.forXmilliseconds", e);
        }
    }

    private void changeImplicitWait(int value, TimeUnit timeUnit){
        driver.manage().timeouts().implicitlyWait(value, timeUnit);
    }

    private void restoreDefaultImplicitWait() {
        changeImplicitWait(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
    }

}
