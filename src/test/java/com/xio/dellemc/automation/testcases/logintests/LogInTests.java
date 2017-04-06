package com.xio.dellemc.automation.testcases.logintests;

import com.xio.dellemc.automation.common.core.Credentials;
import com.xio.dellemc.automation.pageobject.xmsobject.loginpage.LoginPage;
import com.xio.dellemc.automation.pageobject.xmsobject.mainpage.NavigationBarModule;
import com.xio.dellemc.automation.testcases.BaseTestTemplate;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

/**
 * Created by OPudlo on 29.03.2017.
 */

public class LogInTests extends BaseTestTemplate {

    @Test(groups = { "Login Tests Group" })
    public void testLoginPageElementsVerification() {
        LoginPage loginPage = new LoginPage(driver);
        assertTrue(loginPage.checkIfLoginBoxIsPresented());
        assertTrue(loginPage.checkIfUserNameFieldIsPresented());
        assertTrue(loginPage.checkIfPasswordFieldIsPresented());
        assertTrue(loginPage.checkIfSpecifyCredentialsMessageIsPresented());
        assertTrue(loginPage.checkIfLoginButtonIsPresented());
        assertTrue(loginPage.checkIfLogInButtonIsDisabled());
    }

    @Test(groups = { "Login Tests Group" }, dependsOnMethods = "testLoginPageElementsVerification")
    public void testSignInNegativePassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage
                .typeUserName(Credentials.USERNAME)
                .typePassword(Credentials.PASSWORD_WRONG)
                .waitForLoginButtonEnabled(2);

        assertTrue(loginPage.checkIfLogInButtonEnabled());
        loginPage.clickOnLoginButton();
        assertEquals(loginPage.getErrorMessageTest(), "User authentication failed");
    }

    @Test(groups = { "Login Tests Group" }, dependsOnMethods = "testSignInNegativePassword")
    public void testSignInNegativeUserName() {
        LoginPage loginPage = new LoginPage(driver);

        // This assertion checks that user name field value still present in field after previous test execution
        assertEquals(loginPage.getUserNameFieldText(), Credentials.USERNAME);

        loginPage
                .cleanUserNameField()
                .cleanPasswordField()
                .typeUserName(Credentials.USERNAME_WRONG)
                .typePassword(Credentials.PASSWORD)
                .waitForLoginButtonEnabled(2);

        assertTrue(loginPage.checkIfLogInButtonEnabled());
        loginPage.clickOnLoginButton();
        assertEquals(loginPage.getErrorMessageTest(), "User authentication failed");
    }

    @Test(groups = { "Login Tests Group" }, dependsOnMethods = "testSignInNegativeUserName")
    public void testDisableLogInButtonOption() {
        LoginPage loginPage = new LoginPage(driver);

        // This assertion checks that user name field value still present in field after previous test execution
        assertEquals(loginPage.getUserNameFieldText(), Credentials.USERNAME_WRONG);

        loginPage
                .cleanUserNameField()
                .cleanPasswordField();

        assertTrue(loginPage.checkIfSpecifyCredentialsMessageIsPresented());
        assertTrue(loginPage.checkIfLogInButtonIsDisabled());
    }

    @Test(groups = { "Login Tests Group" }, dependsOnMethods = "testDisableLogInButtonOption")
    public void testSignInPositiveAction() {
        LoginPage loginPage = new LoginPage(driver);
        NavigationBarModule navigationBar = new NavigationBarModule(driver);

        assertEquals(loginPage.getUserNameFieldText(), "");

        loginPage
                .cleanUserNameField()
                .cleanPasswordField()
                .typeUserName(Credentials.USERNAME)
                .typePassword(Credentials.PASSWORD)
                .waitForLoginButtonEnabled(2);

        assertTrue(loginPage.checkIfLogInButtonEnabled());
        loginPage.clickOnLoginButton();
        Assert.assertTrue(navigationBar.isNavigationBarPresent());
    }
}
