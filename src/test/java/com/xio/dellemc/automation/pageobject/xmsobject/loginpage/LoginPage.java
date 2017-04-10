package com.xio.dellemc.automation.pageobject.xmsobject.loginpage;

import com.xio.dellemc.automation.common.core.Credentials;
import com.xio.dellemc.automation.pageobject.BasePageObject;
import com.xio.dellemc.automation.pageobject.xmsobject.mainpage.NavigationBarModule;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePageObject {

    private By loginBox_Locator = By.xpath("//div[contains(text(),  'XtremIO Management')]");
    private By usernameField_Locator = By.xpath("//input[contains(@placeholder, 'Username')]");
    private By passwordField_Locator = By.xpath("//input[contains(@placeholder, 'Password')]");
    private By loginButton_Locator = By.xpath("//button[contains(text(), 'Login')]");
    private By loginFailedMessage_Locator = By.xpath("//div[contains(text(), 'User authentication failed')]");
    private By specifyCredentialsMessage_Locator = By.xpath("//div[contains(text(), 'Specify username and password')]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public NavigationBarModule getToMainPage() {
        if(checkIfLoginBoxIsPresented()) {
            typeUserName(Credentials.USERNAME);
            typePassword(Credentials.PASSWORD);
            waitForLoginButtonEnabled(2);
            clickOnLoginButton();
        }
        return new NavigationBarModule(driver);
    }

	public LoginPage typeUserName(String username) {
	    driver.findElement(usernameField_Locator).sendKeys(username);
	    return this;
    }

    public LoginPage typePassword(String password) {
	    driver.findElement(passwordField_Locator).sendKeys(password);
	    return this;
    }

    public LoginPage waitForLoginButtonEnabled(int timeout) {
        wait.forElementClickable(loginButton_Locator, timeout);
        return this;
    }

    public LoginPage clickOnLoginButton() {
        clickOnElement(loginButton_Locator);
        return this;
    }

    public LoginPage cleanUserNameField() {
        clearFieldFromText(usernameField_Locator);
        return this;
    }

    public LoginPage cleanPasswordField() {
        clearFieldFromText(passwordField_Locator);
        return this;
    }

    public String getErrorMessageTest() {
        try {
            return driver.findElement(loginFailedMessage_Locator).getText();
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("There is no \"Error message\" element on the page.");
        }
    }

    public boolean checkIfLoginBoxIsPresented() {
        return isElementOnPage(loginBox_Locator);
    }

    public boolean checkIfUserNameFieldIsPresented() {
        return isElementOnPage(usernameField_Locator);
    }

    public boolean checkIfPasswordFieldIsPresented() {
        return isElementOnPage(passwordField_Locator);
    }

    public boolean checkIfLogInButtonEnabled() {
        return isElementEnabled(loginButton_Locator);
    }

    public boolean checkIfLogInButtonIsDisabled() {
        return !isElementEnabled(loginButton_Locator);
    }

    public boolean checkIfLoginButtonIsPresented() {
        return isElementOnPage(loginButton_Locator);
    }

    public boolean checkIfSpecifyCredentialsMessageIsPresent() {
        return isElementOnPage(specifyCredentialsMessage_Locator);
    }
}
