package Pages;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.List;


//Main Objects on screen elements and functions
public class SettingViewObjects {


        private AndroidDriver driver;
// intialize driver
        public SettingViewObjects(AndroidDriver driver) {
            this.driver = driver;
        }

        // get locators
        private String tempToggleId = "com.graph.weather.forecast.channel:id/tgTemperature_setting";
        private String timeFormatToggleId = "com.graph.weather.forecast.channel:id/tg_format_time_setting";
        private String doneButtonId = "com.graph.weather.forecast.channel:id/tvDone";


        //click on temperature toggle
        public void tapTemperatureToggle() {
            driver.findElement(AppiumBy.id(tempToggleId)).click();


        }

        // temperature is clicked
        public boolean isTemperatureC() {

            return Boolean.parseBoolean(driver.findElement(AppiumBy.id(tempToggleId)).getAttribute("Checked"));
        }

        // click on time format
        public void tapTimeFormatToggle() {
            driver.findElement(AppiumBy.id(timeFormatToggleId)).click();
        }

        //is time format clicked
        public boolean isTimeFormatTwelve() {
            return Boolean.parseBoolean(driver.findElement(AppiumBy.id(timeFormatToggleId)).getAttribute("Checked"));
        }

        // click done
        public void clickDone() {
            driver.findElement(AppiumBy.id(doneButtonId)).click();
        }

        // get row of hourly weather






}
