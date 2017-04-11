package com.xio.dellemc.automation.pageobject.xmsobject.nassettingspage;

import com.xio.dellemc.automation.pageobject.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by OPudlo on 05.04.2017.
 */
public class NasSettingsModule extends BasePageObject {

    //  Not the best but temporary solution, should be replaced to a config file
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

    //  Returns Nas Settings Header's text
    public String getNasSettingsModuleHeader() {
        return driver.findElement(nasSettingsHeader_Locator).getText();
    }

    //  Returns Client Network header's text
    public String getClientNetworkHeaderText() {
        return driver.findElement(clientNetworkSubnetsHeader_Locator).getText();
    }

    // Returns Default Gateway header's text
    public String getDefaultGatewayHeaderText() {
        return driver.findElement(defaultGatewayHeader_Locator).getText();
    }

    //  Returns Static Routes Header's text
    public String getStaticRoutesHeaderText() {
        return driver.findElement(staticRoutesHeader_Locator).getText();
    }

    //  returns Interfaces Header's text
    public String getInterfacesHeaderText() {
        return driver.findElement(interfacesHeader_Locator).getText();
    }

    //  Return true if ScrollSpy menu is displayed on a page
    public boolean isScrollSpyMenuDisplayed() {
        return isElementDisplayed(scrollSpyMenu_Locator);
    }

    //  Cecks if Client Network bttn is displayed
    public boolean isClientNetworkSubNetsBttnDisplayed() {
        return isElementDisplayed(clientNetworkSubnetsBttn_Locator);
    }

    //  Cecks if Default Gateway bttn is displayed
    public boolean isDefaultGatewayBttnDisplayed() {
        return isElementDisplayed(defaultGatewayBttn_Locator);
    }

    //  Cecks if Static Routes bttn is displayed
    public boolean isStaticRoutesBttnDisplayed() {
        return isElementDisplayed(staticRoutesBttn_Locator);
    }

    //  Cecks if Interfaces bttn is displayed
    public boolean isInterfacesBttnDisplayed() {
        return isElementDisplayed(interfacesBttn_Locator);
    }

    // Clicks on the Client network bttn
    public NasSettingsModule clickClientNetworkBttn() {
        clickOnElement(clientNetworkSubnetsBttn_Locator);
        return this;
    }

    // Clicks on the Default gateway bttn
    public NasSettingsModule clickDefaultGatewayBttn() {
        clickOnElement(defaultGatewayBttn_Locator);
        return this;
    }

    // Clicks on the Static Routes bttn
    public NasSettingsModule clickStaticRoutesBttn() {
        clickOnElement(staticRoutesBttn_Locator);
        return this;
    }

    // Clicks on the Interfaces bttn
    public NasSettingsModule clickInterfacesBttn() {
        clickOnElement(interfacesBttn_Locator);
        return this;
    }

}
