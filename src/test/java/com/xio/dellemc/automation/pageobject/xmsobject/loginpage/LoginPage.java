package com.xio.dellemc.automation.pageobject.xmsobject.loginpage;

import com.xio.dellemc.automation.common.core.Credentials;
import com.xio.dellemc.automation.pageobject.BasePageObject;
import com.xio.dellemc.automation.pageobject.xmsobject.mainpage.NavigationBarModule;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePageObject {

    private By loginBox_Locator = By.xpath("/html/body/div[3]/login-box[1]/div[1]/div[1]");
    private By usernameField_Locator = By.xpath("//form[@name=\"$ctrl.loginForm\"]/fieldset[1]/div[1]/input[1]");
    private By passwordTextBox_Locator = By.xpath("//form[@name=\"$ctrl.loginForm\"]/fieldset[1]/div[2]/input[1]");
    private By loginButton_Locator = By.xpath("//form[@name=\"$ctrl.loginForm\"]/fieldset[1]/button[1]");
    private By loginErrorMessage_Locator = By.xpath("//form[@name=\"$ctrl.loginForm\"]/fieldset[1]/div[3]/div[1]");
    private By specifyCredentialsMessage_Locator = By.xpath("//form[@name=\"$ctrl.loginForm\"]/fieldset[1]/div[3]/div[1]");

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
	    driver.findElement(passwordTextBox_Locator).sendKeys(password);
	    return this;
    }

    public LoginPage waitForLoginButtonEnabled(int timeout) {
        wait.forElementClickable(loginButton_Locator, timeout);
        return this;
    }

    public LoginPage clickOnLoginButton() {
        driver.findElement(loginButton_Locator).click();
        return this;
    }

    public LoginPage cleanUserNameField() {
        clearFieldFromText(usernameField_Locator);
        return this;
    }

    public LoginPage cleanPasswordField() {
        clearFieldFromText(passwordTextBox_Locator);
        return this;
    }

    public String getErrorMessageTest() {
        try {
            return driver.findElement(loginErrorMessage_Locator).getText();
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("There is no \"Error message\" element on the page.");
        }
    }

    public String getUserNameFieldText() {
        return getInnerFieldText(usernameField_Locator);
    }

    public boolean checkIfLoginBoxIsPresented() {
        return isElementOnPage(loginBox_Locator);
    }

    public boolean checkIfUserNameFieldIsPresented() {
        return isElementOnPage(usernameField_Locator);
    }

    public boolean checkIfPasswordFieldIsPresented() {
        return isElementOnPage(passwordTextBox_Locator);
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

    public boolean checkIfSpecifyCredentialsMessageIsPresented() {
        return isElementOnPage(specifyCredentialsMessage_Locator);
    }
}
