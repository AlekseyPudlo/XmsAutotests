package com.xio.dellemc.automation.pageobject.xmsobject.mainpage;

import com.xio.dellemc.automation.pageobject.BasePageObject;
import com.xio.dellemc.automation.pageobject.xmsobject.nassettingspage.NasSettingsModule;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by OPudlo on 30.03.2017.
 */
public class NavigationBarModule extends BasePageObject {

    //  Not the best but temporary solution, should be replaced to a config file
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

    //  Waits while System Settings Context window apears
    public NavigationBarModule waitForSystemSettingsContext(int timeout) {
        wait.forElementClickable(systemSettingsContext_Locator, timeout);
        return this;
    }

    //  Click on System Settings Bttn to open System Settings Context window
    public NavigationBarModule callingSystemSettingsContext() {
        clickOnElement(systemSettingsMenuItem_Locator);
        return this;
    }

    //  Click on Nas Settings bttn if Context window appeared and open context window first if not
    public NasSettingsModule goToNasSettings() {
        waitForNavigationBarPresence(10, 250);
        if(!isSystemSettingsContextDisplayed()) {
            callingSystemSettingsContext();
            waitForSystemSettingsContext(2);
        }
        clickOnElement(nasSettingsBttn_Locator);
        return new NasSettingsModule(driver);
    }

    // Click on Nas Maintenance bttn if Context window appeared and open context window first if not
    public  NasMaintenanceModule goToNasMaintenance() {
        if(!isSystemSettingsContextDisplayed()) {
            callingSystemSettingsContext();
            waitForSystemSettingsContext(2);
        }
        clickOnElement(nasMaintenanceBttn_Locator);
        return new NasMaintenanceModule(driver);
    }

    //  Waits for Navigation Bar presence on a page
    public void waitForNavigationBarPresence(int timeout, int pooling) {
        wait.forElementVisible(navigationToolBar_Locator, timeout, pooling);
    }

    //  Returns true if Navigation Bar present on a page
    public boolean isNavigationBarPresent(){
        waitForNavigationBarPresence(10, 250);
        return driver.findElement(navigationToolBar_Locator).isDisplayed();
    }

    //  Checks if SystemSettings Context Window Displays
    public boolean isSystemSettingsContextDisplayed() {
        return isElementDisplayed(systemSettingsContext_Locator);
    }

}
