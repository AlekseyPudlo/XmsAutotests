package com.xio.dellemc.automation.common.core;

import com.xio.dellemc.automation.common.utyility.OsValidator;

import java.io.File;


/**
 * Created by OPudlo on 28.03.2017.
 */

public class CommonBrowserPath {

    private OsValidator osValidator = new OsValidator();

    public File getChromeDriverPath() {
        if(osValidator.isWindows()) {
            return new File(".\\src\\test\\resources\\BrowserDrivers\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
        } else if (osValidator.isLinux()) {
            return new File("./src/test/resources/BrowserDrivers/ChromeDriver/chromedriver_linux64/chromedriver");
        } else if (osValidator.isMac()) {
            return new File(".\\src\\test\\resources\\BrowserDrivers\\ChromeDriver\\chromedriver_mac64\\chromedriver");
        } else {
            return new File(".");
        }
    }

    public File getFirefoxDriverPath() {
        if(osValidator.isWindows()) {
            return new File(".\\src\\test\\resources\\BrowserDrivers\\FireFoxDriver\\geecodriver_win\\geckodriver_win64.exe");
        } else if (osValidator.isLinux()) {
            return new File("./src/test/resources/BrowserDrivers/FireFoxDriver/geecodriver_linux64/geckodriver");
        } else if (osValidator.isMac()) {
            return new File(".\\src\\test\\resources\\BrowserDrivers\\FireFoxDriver\\geecodriver_mac64\\geckodriver");
        } else {
            return new File(".");
        }
    }
}
