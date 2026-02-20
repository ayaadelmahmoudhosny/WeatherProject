package pages;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import utils.AndroidActions;

import java.util.List;


public class HomePage extends AndroidActions {

    By weatherScrollPage = AppiumBy.xpath("//*[@resource-id='com.graph.weather.forecast.channel:id/scroll_page_ads']");
    By hourRecycler = AppiumBy.xpath("//*[@resource-id='com.graph.weather.forecast.channel:id/rvHour']");

    public List<WebElement> getHourRows() {
        return GetElement(hourRecycler);
    }

    public void SwipeLayout() {
        SwipeAction(weatherScrollPage, "left");
    }

    public void SwipeHoursRow() {
        SwipeAction(hourRecycler, "left");
    }
}
