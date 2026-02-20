package utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.time.Duration;


public class DriverManager {


    public static AndroidDriver driver;
    public static AppiumDriverLocalService service;

    // intialize driver

    public static void configureDriver() throws IOException {

        ConfigurationReader reader = new ConfigurationReader();

        service = new AppiumServiceBuilder().withIPAddress(reader.readConfigValue("IPAddress"))
                .usingPort(Integer.parseInt(reader.readConfigValue("Port"))).build();

        UiAutomator2Options options = new UiAutomator2Options();

        options.setDeviceName(reader.readConfigValue("DeviceName"));

        // read from file
        options.setUdid(reader.readConfigValue("Udid")); // <-- The real device ID from `adb devices`
        options.setPlatformName(reader.readConfigValue("PlatformName"));
        options.setAutomationName(reader.readConfigValue("AutomationName"));
        options.setApp(reader.readConfigValue("AppPath"));

        options.setCapability("noReset", false);
        options.setCapability("fullReset", true);


        options.setCapability("autoGrantPermissions", true);
        options.setCapability("adbExecTimeout", 60000);
        driver = new AndroidDriver(service.getUrl(), options);//new URI("http://127.0.0.1:4723").toURL()
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

}
