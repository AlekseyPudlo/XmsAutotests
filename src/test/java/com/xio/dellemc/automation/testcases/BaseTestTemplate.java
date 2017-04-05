package com.xio.dellemc.automation.testcases;

import com.xio.dellemc.automation.common.core.CommonBrowserPath;
import com.xio.dellemc.automation.common.core.Credentials;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ThreadGuard;
import org.testng.annotations.*;

/**
 * Created by aleks on 26.03.17.
 */
public class BaseTestTemplate {

    protected WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    private void setDriverForBrowser(String browser) {
        // Create a new instance of Chrome / FireFox Driver
        if(browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", new CommonBrowserPath().getFirefoxDriverPath().getAbsolutePath());
            driver = ThreadGuard.protect(new FirefoxDriver());
        } else if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", new CommonBrowserPath().getChromeDriverPath().getAbsolutePath());
            driver = ThreadGuard.protect(new ChromeDriver());
        }
    }

    @Parameters({ "browser" })
    @BeforeSuite(alwaysRun = true)
    public void beforeSuite(@Optional String browser) {
        System.out.println("Browser = " + browser);

        setDriverForBrowser(browser);
        driver.manage().window().maximize();
        driver.get(Credentials.BASE_URL);
}

//    @BeforeTest(alwaysRun = true)
//    public void beforeTest(){
//
//    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        driver.quit();
    }
}

