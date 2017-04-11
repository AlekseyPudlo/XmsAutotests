package com.xio.dellemc.automation.common.core;

import com.xio.dellemc.automation.common.utyility.OsValidator;

import java.io.File;


/**
 * Created by OPudlo on 28.03.2017.
 */

public class CommonBrowserPath {


    private OsValidator osValidator = new OsValidator();

/*
    There are 3 chromedriver launchers for 3 OS Windows, Linux, and MAC to make test Framework Cross-platform
    Once the method run it calls bool methods in if / else statements and picks up the correct one
*/

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

/*
    There are 3 firefox launchers for 3 OS Windows, Linux, and MAC to make test Framework Cross-platform
    Once the method run it calls bool methods in if / else statements and picks up the correct one
*/
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
