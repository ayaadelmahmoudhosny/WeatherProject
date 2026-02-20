package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import utils.AndroidActions;


//Main Objects on screen elements and functions
public class SettingPage extends AndroidActions {
    // get locators
    //a[text()="Today's Deals"] tag[attribute=value]
    By tempToggle = AppiumBy.xpath("//*[@resource-id='com.graph.weather.forecast.channel:id/tgTemperature_setting']");
    By timeFormatToggle = AppiumBy.xpath("//*[@resource-id='com.graph.weather.forecast.channel:id/tg_format_time_setting']");
    By doneButton = AppiumBy.xpath("//*[@resource-id='com.graph.weather.forecast.channel:id/tvDone']");

    //click on temperature toggle
    public void tapTemperatureToggle() {
        ClickElement(tempToggle);
    }

    // temperature is clicked
      /*  public boolean isTemperatureC() {

           // return Boolean.parseBoolean(driver.findElement(tempToggle).getAttribute("Checked"));
        }*/

    // click on time format
    public void tapTimeFormatToggle() {
        ClickElement(timeFormatToggle);
    }

    //is time format clicked
      /*  public boolean isTimeFormatTwelve() {
           // return Boolean.parseBoolean(driver.findElement(timeFormatToggle).getAttribute("Checked"));
        }*/

    // click done
    public void clickDone() {
        ClickElement(doneButton);
    }

    // get row of hourly weather


}
