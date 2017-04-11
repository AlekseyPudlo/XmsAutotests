package com.xio.dellemc.automation.common.utyility;

/**
 * Created by OPudlo on 28.03.2017.
 */
public class OsValidator {

    private static String os = getOsName();
    // Returns OS name in lower case where tests are launched
    private static String getOsName() {
        return System.getProperty("os.name").toLowerCase();
    }

    private static void getOsPropertiesToConsole() {
        System.getProperties().list(System.out);
    }

    //    Boolean methods to check if the OS is Win, Linux, or Mac
    public boolean isWindows() {
        return os.indexOf("win") >= 0;
    }

    public boolean isLinux() {
        return os.indexOf("nix") >= 0 || os.indexOf("nux") >= 0 || os.indexOf("aix") >= 0;
    }

    public boolean isMac() {
        return os.indexOf("mac") >= 0;
    }
}
