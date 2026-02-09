package utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.net.URL;
import java.time.Duration;

public final class Driver {

    private Driver() {}

    private static final ThreadLocal<AndroidDriver> driverTL = new ThreadLocal<>();

    public static AndroidDriver getDriver() {
        if (driverTL.get() == null) {
            driverTL.set(createAndroidDriver());
        }
        return driverTL.get();
    }

    private static AndroidDriver createAndroidDriver() {
        UiAutomator2Options options = new UiAutomator2Options()
                .setAutomationName(ConfigReader.getProperty("automationName"))
                .setPlatformName(ConfigReader.getProperty("platformName"))
                .setPlatformVersion(ConfigReader.getProperty("platformVersion"))
                .setDeviceName(ConfigReader.getProperty("deviceName"))
                .setAppPackage(ConfigReader.getProperty("appPackage"))
                .setAppActivity(ConfigReader.getProperty("appActivity"))
                .setNoReset(true)
                .setNewCommandTimeout(Duration.ofSeconds(120));

        try {
            URL serverUrl = new URL(ConfigReader.getProperty("appiumServerUrl"));
            AndroidDriver driver = new AndroidDriver(serverUrl, options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            return driver;
        } catch (Exception e) {
            throw new RuntimeException("Failed to start AndroidDriver. Check appiumServerUrl and config values.", e);
        }
    }

    public static void quitDriver() {
        AndroidDriver driver = driverTL.get();
        if (driver != null) {
            driver.quit();
            driverTL.remove();
        }
    }
}
