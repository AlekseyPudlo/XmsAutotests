package com.xio.dellemc.automation.pageobject.xmsobject.nassettingspage;

import com.xio.dellemc.automation.pageobject.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by OPudlo on 05.04.2017.
 */
public class NasSettingsModule extends BasePageObject {
    private By nasSettingsHeader_Locator = By.xpath("//h2[contains(text(), 'NAS settings')]");
    private By scrollSpyMenu_Locator = By.xpath("//div[contains(@class, 'xio-layout-page-master-column scrollspy-menu')]");
    private By clientNetworkSubnetsBttn_Locator = By.xpath("//a[contains(text(), 'Client Network Subnets')]");
    private By defaultGatewayBttn_Locator = By.xpath("//a[contains(text(), 'Default Gateway')]");
    private By staticRoutesBttn_Locator = By.xpath("//a[contains(text(), 'Static Routes')]");
    private By interfacesBttn_Locator = By.xpath("//a[contains(text(), 'Interfaces')]");

    private By clientNetworkSubnetsHeader_Locator = By.xpath("//div[contains(text(), 'Client Network Subnets')]");
    private By defaultGatewayHeader_Locator = By.xpath("//div[contains(text(), 'Default Gateway')]");
    private By staticRoutesHeader_Locator = By.xpath("//div[contains(text(), 'Static Routes')]");
    private By interfacesHeader_Locator = By.xpath("//div[contains(text(), 'Interfaces')]");


    public NasSettingsModule(WebDriver driver) {
        super(driver);
    }

    public String getNasSettingsModuleHeader() {
        return driver.findElement(nasSettingsHeader_Locator).getText();
    }

    public String getClientNetworkHeaderText() {
        return driver.findElement(clientNetworkSubnetsHeader_Locator).getText();
    }

    public String getDefaultGatewayHeaderText() {
        return driver.findElement(defaultGatewayHeader_Locator).getText();
    }

    public String getStaticRoutesHeaderText() {
        return driver.findElement(staticRoutesHeader_Locator).getText();
    }

    public String getInterfacesHeaderText() {
        return driver.findElement(interfacesHeader_Locator).getText();
    }

    public boolean isScrollSpyMenuDisplayed() {
        return isElementDisplayed(scrollSpyMenu_Locator);
    }

    public boolean isClientNetworkSubNetsBttnDisplayed() {
        return isElementDisplayed(clientNetworkSubnetsBttn_Locator);
    }

    public boolean isDefaultGatewayBttnDisplayed() {
        return isElementDisplayed(defaultGatewayBttn_Locator);
    }

    public boolean isStaticRoutesBttnDisplayed() {
        return isElementDisplayed(staticRoutesBttn_Locator);
    }

    public boolean isInterfacesBttnDisplayed() {
        return isElementDisplayed(interfacesBttn_Locator);
    }

    public void clickClientNetworkBttn() {
        clickOnElement(clientNetworkSubnetsBttn_Locator);
    }

    public void clickDefaultGatewayBttn() {
        clickOnElement(defaultGatewayBttn_Locator);
    }

    public void clickStaticRoutesBttn() {
        clickOnElement(staticRoutesBttn_Locator);
    }

    public void clickInterfacesBttn() {
        clickOnElement(interfacesBttn_Locator);
    }

}
