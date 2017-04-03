package com.xio.dellemc.automation.common.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;


/**
 * Created by OPudlo on 28.03.2017.
 */
public class CommonExpectedConditions {

    private CommonExpectedConditions() {}

    // An expectation for checking if the given text is NOT present in the specified element
    public static ExpectedCondition<Boolean> textToBeNotPresentInElement(final By selectorBy, final String text) {

        return new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                String elementText = driver.findElement(selectorBy).getText();
                return !elementText.contains(text);
            }

            @Override
            public String toString() {
                return String
                        .format("text ('%s') to be not present in element %s", text, selectorBy.toString());
            }
        };
    }

    public static ExpectedCondition<Boolean> textToBeNotPresentInElement(final WebElement givenElement, final String text) {

        return new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                String elementText = givenElement.getText();
                return !elementText.contains(text);
            }

            @Override
            public String toString() {
                return String.format("text ('%s') to be not present in element %s", text, givenElement.getTagName());
            }
        };
    }

    // An expectation for checking if the given text is present in the specified element
    public static ExpectedCondition<Boolean> textToBePresentInElement(final By selectorBy, final String text) {
        return new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                String elementText = driver.findElement(selectorBy).getText();
                return elementText.contains(text);
            }

            @Override
            public String toString() {
                return String.format("text ('%s') to be present in element %s", text, selectorBy.toString());
            }
        };
    }

    public static ExpectedCondition<Boolean> textToBePresentInElement(final WebElement givenElement, final String text) {
        return new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                String elementText = givenElement.getText();
                return elementText.contains(text);
            }

            @Override
            public String toString() {
                return String.format("text ('%s') to be present in element %s", text, givenElement.getTagName());
            }
        };
    }
}
