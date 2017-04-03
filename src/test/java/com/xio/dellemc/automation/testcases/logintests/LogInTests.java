package com.xio.dellemc.automation.testcases.logintests;

import com.xio.dellemc.automation.common.core.Credentials;
import com.xio.dellemc.automation.pageobject.xmsobject.loginpage.LoginPage;
import com.xio.dellemc.automation.pageobject.xmsobject.mainpage.NavigationBarModule;
import com.xio.dellemc.automation.testcases.BaseTestTemplate;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by OPudlo on 29.03.2017.
 */
@Test
public class LogInTests extends BaseTestTemplate {


    @Test(groups = "Login Tests Group")
    public void testLoginPageElementsVerification() {
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.checkIfLoginBoxPresented());
        Assert.assertTrue(loginPage.checkIfUserNameTestBoxPresented());
        Assert.assertTrue(loginPage.checkIfPasswordTextBoxPresented());
        Assert.assertTrue(loginPage.checkIfLoginButtonPresented());
    }

    @Test(groups = "Login Tests Group", dependsOnMethods = "testLoginPageElementsVerification")
    public void testSignInNegativePassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage
                .typeUserName(Credentials.USERNAME)
                .typePassword("Wrong Password")
                .waitForLoginButtonEnabled(2);

        Assert.assertTrue(loginPage.checkIfLogInButtonEnabled());
        loginPage.clickOnLoginButton();
        Assert.assertEquals(loginPage.getErrorMessageTest(), "User authentication failed");
    }

    @Test(groups = "Login Tests Group", dependsOnMethods = "testSignInNegativePassword")
    public void testSignInNegativeUserName() {
        LoginPage loginPage = new LoginPage(driver);

        // Debug part of code
        System.out.println("Login Page get User Name field text value = " + loginPage.getUserNameFieldText());
        // This assertion checks that user name field value still present in field after previous test execution
        Assert.assertEquals(loginPage.getUserNameFieldText(), "admin");

        loginPage
                .cleanUserNameField()
                .cleanPasswordField()
                .typeUserName("WrongUserName")
                .typePassword(Credentials.PASSWORD)
                .waitForLoginButtonEnabled(2);

        Assert.assertTrue(loginPage.checkIfLogInButtonEnabled());
        loginPage.clickOnLoginButton();
        Assert.assertEquals(loginPage.getErrorMessageTest(), "User authentication failed");
    }

    @Test(groups = "Login Tests Group", dependsOnMethods = "testSignInNegativeUserName")
    public void testSignInPositiveAction() {
        LoginPage loginPage = new LoginPage(driver);
        NavigationBarModule navigationBar = new NavigationBarModule(driver);

        // This assertion checks that user name field value still present in field after previous test execution
        Assert.assertEquals(loginPage.getUserNameFieldText(), "WrongUserName");

        loginPage
                .cleanUserNameField()
                .cleanPasswordField()
                .typeUserName(Credentials.USERNAME)
                .typePassword(Credentials.PASSWORD)
                .waitForLoginButtonEnabled(2);

        Assert.assertTrue(loginPage.checkIfLogInButtonEnabled());
        loginPage.clickOnLoginButton();
        Assert.assertTrue(navigationBar.isNavigationBarPresent());
    }
}
