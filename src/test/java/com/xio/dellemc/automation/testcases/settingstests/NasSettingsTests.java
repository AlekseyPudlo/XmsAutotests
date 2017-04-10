package com.xio.dellemc.automation.testcases.settingstests;

import com.xio.dellemc.automation.pageobject.xmsobject.loginpage.LoginPage;
import com.xio.dellemc.automation.pageobject.xmsobject.nassettingspage.NasSettingsModule;
import com.xio.dellemc.automation.pageobject.xmsobject.mainpage.NavigationBarModule;
import com.xio.dellemc.automation.testcases.BaseTestTemplate;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

/**
 * Created by OPudlo on 05.04.2017.
 */

public class NasSettingsTests extends BaseTestTemplate {

    @Test(groups = "NAS Settings Tests Group", priority = 1)
    public void testOpenNasSettingsModule() {
        LoginPage loginPage = new LoginPage(driver);
        NavigationBarModule navigationBarModule = loginPage.getToMainPage();
        NasSettingsModule nasSettingsModule = navigationBarModule.goToNasSettings();

        assertEquals(nasSettingsModule.getNasSettingsModuleHeader(), "NAS settings");
    }

    @Test(groups = "NAS Settings Tests Group", dependsOnMethods = "testOpenNasSettingsModule", priority = 2)
    public void testVerifyElementsOfScrollSpyMenu() {
        NasSettingsModule settingsModule = new NasSettingsModule(driver);

        assertTrue(settingsModule.isScrollSpyMenuDisplayed());
        assertTrue(settingsModule.isClientNetworkSubNetsBttnDisplayed());
        assertTrue(settingsModule.isDefaultGatewayBttnDisplayed());
        assertTrue(settingsModule.isStaticRoutesBttnDisplayed());
        assertTrue(settingsModule.isInterfacesBttnDisplayed());
    }

    @Test(groups = "NAS Settings Tests Group", dependsOnMethods = "testOpenNasSettingsModule", priority = 3)
    public void testVerifyScrollSpyMenuButtonsScrollingOption() {
        NasSettingsModule settingsModule = new NasSettingsModule(driver);

        settingsModule.clickClientNetworkBttn();
        assertEquals("CLIENT NETWORK SUBNETS", settingsModule.getClientNetworkHeaderText());

        settingsModule.clickDefaultGatewayBttn();
        assertEquals("DEFAULT GATEWAY", settingsModule.getDefaultGatewayHeaderText());

        settingsModule.clickStaticRoutesBttn();
        assertEquals("STATIC ROUTES", settingsModule.getStaticRoutesHeaderText());

        settingsModule.clickInterfacesBttn();
        assertEquals("INTERFACES", settingsModule.getInterfacesHeaderText());
    }

}
