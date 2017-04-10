package com.xio.dellemc.automation.pageobject.xmsobject.mainpage;

import com.xio.dellemc.automation.pageobject.BasePageObject;
import com.xio.dellemc.automation.pageobject.xmsobject.nassettingspage.NasSettingsModule;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by OPudlo on 30.03.2017.
 */
public class NavigationBarModule extends BasePageObject {

    private By navigationToolBar_Locator = By.xpath("/html/body/nav-toolbar[1]/div[1]");
    private By sysLogo_Locator = By.xpath("html/body/nav-toolbar/div/a");
    private By searchItem_Locator = By.xpath("html/body/nav-toolbar/div/div/navtoolbar-search");
    private By systemStateItem_Locator = By.xpath("html/body/nav-toolbar/div/div/nav-toolbar-system-state");
    private By alertsMenuItem_Locator = By.xpath("html/body/nav-toolbar/div/div/navtoolbar-alerts-menu");
    private By systemSettingsMenuItem_Locator = By.xpath("html/body/nav-toolbar/div/div/navtoolbar-settings-menu");
    private By userMenuItem_Locator = By.xpath("html/body/nav-toolbar/div/div/navtoolbar-user-menu");

    private By systemSettingsContext_Locator = By.xpath("/html/body/ul[2]");
    private By nasSettingsBttn_Locator = By.xpath("/html/body/ul[2]/li[3]/a[1]");
    private By nasMaintenanceBttn_Locator = By.xpath("/html/body/ul[2]/li[4]/a[1]");

    public NavigationBarModule(WebDriver driver) {
        super(driver);
    }

    public NavigationBarModule waitForSystemSettingsContext(int timeout) {
        wait.forElementClickable(systemSettingsContext_Locator, timeout);
        return this;
    }

    public NavigationBarModule callingSystemSettingsContext() {
        clickOnElement(systemSettingsMenuItem_Locator);
        return this;
    }

    public NasSettingsModule goToNasSettings() {
        waitForNavigationBarPresence(10, 250);
        if(!isSystemSettingsContextDisplayed()) {
            callingSystemSettingsContext();
            waitForSystemSettingsContext(2);
        }
        clickOnElement(nasSettingsBttn_Locator);
        return new NasSettingsModule(driver);
    }

    public  NasMaintenanceModule goToNasMaintenance() {
        if(!isSystemSettingsContextDisplayed()) {
            callingSystemSettingsContext();
            waitForSystemSettingsContext(2);
        }
        clickOnElement(nasMaintenanceBttn_Locator);
        return new NasMaintenanceModule(driver);
    }

    public void waitForNavigationBarPresence(int timeout, int pooling) {
        wait.forElementVisible(navigationToolBar_Locator, timeout, pooling);
    }

    public boolean isNavigationBarPresent(){
        waitForNavigationBarPresence(10, 250);
        return driver.findElement(navigationToolBar_Locator).isDisplayed();
    }

    public boolean isSystemSettingsContextDisplayed() {
        return isElementDisplayed(systemSettingsContext_Locator);
    }

}
