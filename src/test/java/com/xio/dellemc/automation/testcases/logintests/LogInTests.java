package com.xio.dellemc.automation.testcases.logintests;

import com.xio.dellemc.automation.common.core.Credentials;
import com.xio.dellemc.automation.pageobject.xmsobject.loginpage.LoginPage;
import com.xio.dellemc.automation.pageobject.xmsobject.mainpage.NavigationBarModule;
import com.xio.dellemc.automation.testcases.BaseTestTemplate;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

/**
 * Created by OPudlo on 29.03.2017.
 */

public class LogInTests extends BaseTestTemplate {

    @Test(groups = { "Login Positive Tests Group" }, priority = 1)
    public void testLoginPageElementsVerification() {
        LoginPage loginPage = new LoginPage(driver);
        assertTrue(loginPage.checkIfLoginBoxIsPresented());
        assertTrue(loginPage.checkIfUserNameFieldIsPresented());
        assertTrue(loginPage.checkIfPasswordFieldIsPresented());
        assertTrue(loginPage.checkIfSpecifyCredentialsMessageIsPresent());
        assertTrue(loginPage.checkIfLoginButtonIsPresented());
        assertTrue(loginPage.checkIfLogInButtonIsDisabled());
    }

    @Test(groups = { "Login Negative Tests Group" }, priority = 2)
    public void testSignInNegativePassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage
                .cleanUserNameField()
                .cleanPasswordField()
                .typeUserName(Credentials.USERNAME)
                .typePassword(Credentials.PASSWORD_WRONG)
                .waitForLoginButtonEnabled(2);

        assertTrue(loginPage.checkIfLogInButtonEnabled());
        loginPage.clickOnLoginButton();
        assertEquals("User authentication failed", loginPage.getErrorMessageTest());
    }

    @Test(groups = { "Login Negative Tests Group" }, priority = 3)
    public void testSignInNegativeUserName() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage
                .cleanUserNameField()
                .cleanPasswordField()
                .typeUserName(Credentials.USERNAME_WRONG)
                .typePassword(Credentials.PASSWORD)
                .waitForLoginButtonEnabled(2);

        assertTrue(loginPage.checkIfLogInButtonEnabled());
        loginPage.clickOnLoginButton();
        assertEquals("User authentication failed", loginPage.getErrorMessageTest());
    }

    @Test(groups = { "Login Positive Tests Group" }, priority = 4)
    public void testDisableLogInButtonOption() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage
                .cleanUserNameField()
                .cleanPasswordField();

        assertTrue(loginPage.checkIfSpecifyCredentialsMessageIsPresent());
        assertTrue(loginPage.checkIfLogInButtonIsDisabled());
    }

    @Test(groups = { "Login Positive Tests Group" }, priority = 5)
    public void testSignInPositiveAction() {
        LoginPage loginPage = new LoginPage(driver);
        NavigationBarModule navigationBar = new NavigationBarModule(driver);

        loginPage
                .cleanUserNameField()
                .cleanPasswordField()
                .typeUserName(Credentials.USERNAME)
                .typePassword(Credentials.PASSWORD)
                .waitForLoginButtonEnabled(2);

        assertTrue(loginPage.checkIfLogInButtonEnabled());
        loginPage.clickOnLoginButton();
        navigationBar.waitForNavigationBarPresence(15, 250);
        assertTrue(navigationBar.isNavigationBarPresent());
    }
}
