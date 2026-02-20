package utils;

import io.appium.java_client.android.AndroidDriver;

public class TestSetup {

    public AndroidDriver driver;

    public AndroidDriver getDriver() {
        return driver;
    }

    public void setDriver(AndroidDriver driver) {
        this.driver = driver;
    }
}
