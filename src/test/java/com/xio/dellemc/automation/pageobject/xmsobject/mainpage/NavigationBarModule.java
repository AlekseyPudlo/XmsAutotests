package com.xio.dellemc.automation.pageobject.xmsobject.mainpage;

import com.xio.dellemc.automation.pageobject.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.logging.Level;

/**
 * Created by OPudlo on 30.03.2017.
 */
public class NavigationBarModule extends BasePageObject {

    private By navigationToolBar_Locator = By.xpath("html/body/nav-toolbar");
    private By sysLogo_Locator = By.xpath("html/body/nav-toolbar/div/a");
    private By searchItem_Locator = By.xpath("html/body/nav-toolbar/div/div/navtoolbar-search");
    private By systemStateItem_Locator = By.xpath("html/body/nav-toolbar/div/div/nav-toolbar-system-state");
    private By alertsMenuItem_Locator = By.xpath("html/body/nav-toolbar/div/div/navtoolbar-alerts-menu");
    private By settingsMenuItem_Locator = By.xpath("html/body/nav-toolbar/div/div/navtoolbar-settings-menu");
    private By userMenuItem_Locator = By.xpath("html/body/nav-toolbar/div/div/navtoolbar-user-menu");

    public NavigationBarModule(WebDriver driver) {
        super(driver);
    }

    public boolean isNavigationBarPresent(){
        wait.forElementVisible(navigationToolBar_Locator, 10, 250);
        return driver.findElement(navigationToolBar_Locator).isDisplayed();
    }

    public NavigationBarModule getLogo() {
        LOGGER.log(Level.INFO, "" + driver.getTitle());
        LOGGER.log(Level.INFO, "syslogo tagName = " + driver.findElement(sysLogo_Locator).getTagName());
        LOGGER.log(Level.INFO, "syslogo text = " + driver.findElement(sysLogo_Locator).getText());
        return this;
    }




}
