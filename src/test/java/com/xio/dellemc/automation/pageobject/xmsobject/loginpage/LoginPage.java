package com.xio.dellemc.automation.pageobject.xmsobject.loginpage;

import com.xio.dellemc.automation.pageobject.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePageObject {

    private By loginBox_Locator = By.xpath("html/body/div[3]/login-box/div/div");
    private By usernameField_Locator = By.xpath("html/body/div[3]/login-box/div/div/div[2]/div[1]/form/fieldset/div[1]/input");
    private By passwordTextBox_Locator = By.xpath("html/body/div[3]/login-box/div/div/div[2]/div[1]/form/fieldset/div[2]/input");
    private By loginButton_Locator = By.xpath("html/body/div[3]/login-box/div/div/div[2]/div[1]/form/fieldset/button");
    private By loginErrorMessage_Locator = By.xpath("/html/body/div[3]/login-box/div/div/div[2]/div[1]/form/fieldset/div[3]/div");

    public LoginPage(WebDriver driver) {
	    super(driver);

	    if(!"XtremIO Web Dashboard".equals(driver.getTitle())) {
            throw new IllegalStateException("[ERROR] - This is not the login page.");
        }
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
//        return driver.findElement(usernameField_Locator).getText();
        return getInnerFieldText(usernameField_Locator);
    }

    public boolean checkIfLoginBoxPresented() {
        return isElementOnPage(loginBox_Locator);
    }

    public boolean checkIfUserNameTestBoxPresented() {
        return isElementOnPage(usernameField_Locator);
    }

    public boolean checkIfPasswordTextBoxPresented() {
        return isElementOnPage(passwordTextBox_Locator);
    }

    public boolean checkIfLogInButtonEnabled() {
        return isElementEnabled(loginButton_Locator);
    }

    public boolean checkIfLoginButtonPresented() {
        return isElementOnPage(loginButton_Locator);
    }


}
