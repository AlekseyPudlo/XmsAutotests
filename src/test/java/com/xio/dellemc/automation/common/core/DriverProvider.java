package com.xio.dellemc.automation.common.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ThreadGuard;

/**
 * Created by aleks on 10.04.17.
 */

public class DriverProvider {
    public WebDriver driver;

    public DriverProvider() {}

    public WebDriver setDriverForBrowser(String browser) {
        // Create a new instance of Chrome / FireFox Driver
        if(browser.equalsIgnoreCase("firefox")) {
            return setFireFoxBrowser();
        } else if (browser.equalsIgnoreCase("chrome")) {
            return setChromeBrowser();
        }
        return null;
    }

    private WebDriver setFireFoxBrowser() {
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability(CapabilityType.LOGGING_PREFS, new LoggingConfiguration());
        System.setProperty("webdriver.gecko.driver", new CommonBrowserPath().getFirefoxDriverPath().getAbsolutePath());
        return driver = ThreadGuard.protect(new FirefoxDriver(capabilities));
    }

    private WebDriver setChromeBrowser() {
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(CapabilityType.LOGGING_PREFS, new LoggingConfiguration());
        System.setProperty("webdriver.chrome.driver", new CommonBrowserPath().getChromeDriverPath().getAbsolutePath());
        return driver = ThreadGuard.protect(new ChromeDriver(capabilities));
    }
}
