package com.xio.dellemc.automation.pageobject.xmsobject.loginpage;

import com.xio.dellemc.automation.common.core.Credentials;
import com.xio.dellemc.automation.pageobject.BasePageObject;
import com.xio.dellemc.automation.pageobject.xmsobject.mainpage.NavigationBarModule;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePageObject {

    //  Not the best but temporary solution, should be replaced to a config file
    private By loginBox_Locator = By.xpath("//div[contains(text(),  'XtremIO Management')]");
    private By usernameField_Locator = By.xpath("//input[contains(@placeholder, 'Username')]");
    private By passwordField_Locator = By.xpath("//input[contains(@placeholder, 'Password')]");
    private By loginButton_Locator = By.xpath("//button[contains(text(), 'Login')]");
    private By loginFailedMessage_Locator = By.xpath("//div[contains(text(), 'User authentication failed')]");
    private By specifyCredentialsMessage_Locator = By.xpath("//div[contains(text(), 'Specify username and password')]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //  Allows to go from Login Page to a Main page. Currently just SignIn option
    public NavigationBarModule getToMainPage() {
        if(checkIfLoginBoxIsPresented()) {
            typeUserName(Credentials.USERNAME);
            typePassword(Credentials.PASSWORD);
            waitForLoginButtonEnabled(2);
            clickOnLoginButton();
        }
        return new NavigationBarModule(driver);
    }

    //  Types a UserName into the UserName field: String UserName
	public LoginPage typeUserName(String username) {
	    driver.findElement(usernameField_Locator).sendKeys(username);
	    return this;
    }

    //  Types a PassWord into the PassWord field: String PassWord
    public LoginPage typePassword(String password) {
	    driver.findElement(passwordField_Locator).sendKeys(password);
	    return this;
    }

    // Is intended for a waiting till the Login bttn became Enabled. Usually after UserName and Password typed.
    public LoginPage waitForLoginButtonEnabled(int timeout) {
        wait.forElementClickable(loginButton_Locator, timeout);
        return this;
    }

    //  Clicks on Login bttn
    public LoginPage clickOnLoginButton() {
        clickOnElement(loginButton_Locator);
        return this;
    }

    //  Cleans The UserName field
    public LoginPage cleanUserNameField() {
        clearFieldFromText(usernameField_Locator);
        return this;
    }

    //  clean the password field
    public LoginPage cleanPasswordField() {
        clearFieldFromText(passwordField_Locator);
        return this;
    }

    //  Returns Error message appearing after failed Login
    public String getErrorMessageTest() {
        try {
            return driver.findElement(loginFailedMessage_Locator).getText();
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("There is no \"Error message\" element on the page.");
        }
    }

    //  Verifies that LoginBox frame present on a page
    public boolean checkIfLoginBoxIsPresented() {
        return isElementOnPage(loginBox_Locator);
    }

    //  verifies that Username field present on a page
    public boolean checkIfUserNameFieldIsPresented() {
        return isElementOnPage(usernameField_Locator);
    }

    //  verifies that PassWord field present on a page
    public boolean checkIfPasswordFieldIsPresented() {
        return isElementOnPage(passwordField_Locator);
    }

    //  verifies that Login bttn Enabled
    public boolean checkIfLogInButtonEnabled() {
        return isElementEnabled(loginButton_Locator);
    }

    //  verifies that Login bttn Disabled
    public boolean checkIfLogInButtonIsDisabled() {
        return !isElementEnabled(loginButton_Locator);
    }

    //  verifies that Login bttn present on a Page
    public boolean checkIfLoginButtonIsPresented() {
        return isElementOnPage(loginButton_Locator);
    }

    //  verifies that Confirmation Message present on a page
    public boolean checkIfSpecifyCredentialsMessageIsPresent() {
        return isElementOnPage(specifyCredentialsMessage_Locator);
    }
}
