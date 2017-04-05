package com.xio.dellemc.automation.pageobject.xmsobject.mainpage;

import com.xio.dellemc.automation.pageobject.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by OPudlo on 05.04.2017.
 */
public class NasSettingsModule extends BasePageObject {
    private By nasSettingsHeader_Locator = By.xpath("/html/body/div[3]/div[2]/div[1]/nas-integration-point[1]/div[1]/fluidfswuiv60356-nas-settings[1]/div[1]/div[1]/div[2]/header[1]/h2[1]");

    public NasSettingsModule(WebDriver driver) {
        super(driver);
    }

    public String getNasSettingsModuleHeader() {
        return driver.findElement(nasSettingsHeader_Locator).getText();
    }

}
