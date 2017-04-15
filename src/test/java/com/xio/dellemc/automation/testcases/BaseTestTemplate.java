package com.xio.dellemc.automation.testcases;

import com.xio.dellemc.automation.common.core.Credentials;
import com.xio.dellemc.automation.common.core.DriverProvider;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

/**
 * Created by aleks on 26.03.17.
 */
public class BaseTestTemplate {

    protected static WebDriver driver;

/*    @Parameters({ "browser" })
    @BeforeSuite(alwaysRun = true)
    public void beforeSuite(@Optional String browser) {
        System.out.println("Browser = " + browser);

        driverProvider = new DriverProvider();
        driver = driverProvider.initDriverForBrowser(browser);

        driver.manage().window().maximize();
        driver.get(Credentials.BASE_URL);
    }*/

    @Parameters({ "browser" })
    @BeforeClass(alwaysRun = true)
    public void beforeClass(@Optional String browser) {
        System.out.println("Browser = " + browser);

        driver = new DriverProvider().initDriverForBrowser(browser);

        driver.manage().window().maximize();
        driver.get(Credentials.BASE_URL);
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        driver.quit();
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        if (!(driver == null)) {
            driver.quit();
        }
    }
}

