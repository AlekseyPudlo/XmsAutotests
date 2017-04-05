package com.xio.dellemc.automation.testcases.settingstests;

import com.xio.dellemc.automation.pageobject.xmsobject.loginpage.LoginPage;
import com.xio.dellemc.automation.pageobject.xmsobject.mainpage.NasSettingsModule;
import com.xio.dellemc.automation.pageobject.xmsobject.mainpage.NavigationBarModule;
import com.xio.dellemc.automation.testcases.BaseTestTemplate;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

/**
 * Created by OPudlo on 05.04.2017.
 */

public class NasSettingsTests extends BaseTestTemplate {

    @Test(groups = "NAS Settings Tests Group")
    public void testOpenNasSettingsModule() {
        LoginPage loginPage = new LoginPage(driver);
        NavigationBarModule navigationBarModule = loginPage.getToMainPage();
        NasSettingsModule nasSettingsModule = navigationBarModule.goToNasSettings();

        assertEquals(nasSettingsModule.getNasSettingsModuleHeader(), "NAS settings");
    }
}
