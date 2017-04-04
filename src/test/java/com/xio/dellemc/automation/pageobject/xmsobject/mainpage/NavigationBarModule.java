package com.xio.dellemc.automation.pageobject.xmsobject.mainpage;

import com.xio.dellemc.automation.pageobject.BasePageObject;
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

    public boolean isNavigationBarPresent(){
        wait.forElementVisible(navigationToolBar_Locator, 10, 250);
        return driver.findElement(navigationToolBar_Locator).isDisplayed();
    }

    public boolean isSystemSettingsContextIsDisplayed() {
        return isElementDisplayed(systemSettingsContext_Locator);
    }

    public NavigationBarModule callSystemSettingsContext() {
        driver.findElement(systemSettingsMenuItem_Locator).click();
        return this;
    }

    public NavigationBarModule goToNasSettings() {
        if(isSystemSettingsContextIsDisplayed()) {
            driver.findElement(nasSettingsBttn_Locator).click();
            return this;
        } else {
            callSystemSettingsContext();
            waitForSystemSettingsContext(2);
            driver.findElement(nasSettingsBttn_Locator).click();
            return this;
        }
    }

    public NavigationBarModule goToNasMaintenance() {
        if(isSystemSettingsContextIsDisplayed()) {
            driver.findElement(nasMaintenanceBttn_Locator).click();
            return this;
        } else {
            callSystemSettingsContext();
            waitForSystemSettingsContext(2);
            driver.findElement(nasMaintenanceBttn_Locator).click();
            return this;
        }
    }





}
