package com.xio.dellemc.automation.common.core;

import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;

import java.util.logging.Level;

/**
 * Created by aleks on 10.04.17.
 */

class LoggingConfiguration extends LoggingPreferences {

    private LoggingPreferences loggingPreferences = new LoggingPreferences();

    // The class is intended to configure levels of different log types     
    LoggingConfiguration() {
        loggingPreferences.enable(LogType.BROWSER, Level.OFF);
        loggingPreferences.enable(LogType.CLIENT, Level.SEVERE);
        loggingPreferences.enable(LogType.DRIVER, Level.WARNING);
        loggingPreferences.enable(LogType.PERFORMANCE, Level.INFO);
        loggingPreferences.enable(LogType.SERVER, Level.ALL);
    }
}
