package utils;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.List;

public class AndroidActions {

    TestSetup setup;

    public AndroidActions(TestSetup setup) {
        this.setup = setup;
    }

    public void ClickElement(By Element) {
        setup.getDriver().findElement(Element).click();
    }

    public List<WebElement> GetElement(By Element) {
        return setup.getDriver().findElement(Element).findElements(AppiumBy.xpath("./*"));
    }

    public void SwipeAction(By Element, String dir) {
        WebElement layout = setup.getDriver().findElement(Element);
        ((JavascriptExecutor) setup.getDriver()).executeScript("mobile: swipeGesture", ImmutableMap.of("elementId", ((RemoteWebElement) layout).getId(), "direction", dir, "percent", 0.75));
    }
}
