package Pages;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.List;



public class WeatherViewObjects {
    private AndroidDriver driver;
    private String weatherScrollPage = "new UiSelector().resourceId(\"com.graph.weather.forecast.channel:id/scroll_page_ads\")";
    private String hourRecyclerId = "com.graph.weather.forecast.channel:id/rvHour";

    public WeatherViewObjects(AndroidDriver driver) {
        this.driver = driver;
    }

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
