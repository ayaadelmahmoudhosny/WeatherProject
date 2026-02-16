package CucumberObject;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.List;


//Main Objects on screen elements and functions
public class MainObjects {


        private AndroidDriver driver;
// intialize driver
        public MainObjects(AndroidDriver driver) {
            this.driver = driver;
        }

        // get locators
        private String tempToggleId = "com.graph.weather.forecast.channel:id/tgTemperature_setting";
        private String timeFormatToggleId = "com.graph.weather.forecast.channel:id/tg_format_time_setting";
        private String doneButtonId = "com.graph.weather.forecast.channel:id/tvDone";
        private String weatherScrollPage = "new UiSelector().resourceId(\"com.graph.weather.forecast.channel:id/scroll_page_ads\")";
        private String hourRecyclerId = "com.graph.weather.forecast.channel:id/rvHour";

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
        public List<WebElement> getHourRows() {
            return driver.findElement(AppiumBy.id(hourRecyclerId))
                    .findElements(AppiumBy.xpath("./*"));
        }


    // scroll to weather screen
    public WebElement scrollWeatherPage() {
        return driver.findElement(AppiumBy.androidUIAutomator(weatherScrollPage));
    }

    // swipe gesture
    public void SwipeAction(WebElement layout, String dir) {
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) layout).getId(),
                "direction", dir,
                "percent", 0.75
        ));
    }




}
