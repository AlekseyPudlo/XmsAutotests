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

    // Throws to a method that returns a new instance of Chrome / FireFox Driver
    public WebDriver initDriverForBrowser(String browser) {
        if(browser.equalsIgnoreCase("firefox")) {
            return initFireFoxBrowser();
        } else if (browser.equalsIgnoreCase("chrome")) {
            return initChromeBrowser();
        }
        return null;
    }

    //  Returns a new instance of FireFox Driver
    private WebDriver initFireFoxBrowser() {
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability(CapabilityType.LOGGING_PREFS, new LoggingConfiguration());
        System.setProperty("webdriver.gecko.driver", new CommonBrowserPath().getFirefoxDriverPath().getAbsolutePath());
        return driver = ThreadGuard.protect(new FirefoxDriver(capabilities));
    }

    //  Returns a new instance of chrome Driver
    private WebDriver initChromeBrowser() {
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(CapabilityType.LOGGING_PREFS, new LoggingConfiguration());
        System.setProperty("webdriver.chrome.driver", new CommonBrowserPath().getChromeDriverPath().getAbsolutePath());
        return driver = ThreadGuard.protect(new ChromeDriver(capabilities));
    }
}
