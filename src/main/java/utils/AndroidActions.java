package utils;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.List;

public class AndroidActions {

    public void ClickElement(By Element) {
        DriverManager.driver.findElement(Element).click();
    }

    public List<WebElement> GetElement(By Element) {
        return DriverManager.driver.findElement(Element).findElements(AppiumBy.xpath("./*"));
    }


    public void SwipeAction(By Element, String dir) {
        WebElement layout = DriverManager.driver.findElement(Element);
        ((JavascriptExecutor) DriverManager.driver).executeScript("mobile: swipeGesture", ImmutableMap.of("elementId", ((RemoteWebElement) layout).getId(), "direction", dir, "percent", 0.75));
    }
}
