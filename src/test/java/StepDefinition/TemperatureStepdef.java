package StepDefinition;

import CucumberObject.MainObjects;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.cucumber.java.After;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.List;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class TemperatureStepdef {

    public AndroidDriver driver;
    public AppiumDriverLocalService service;
    private MainObjects mainObject;

    @BeforeClass(alwaysRun=true)
    @Given("User in main page")
    public void userInMainPage() throws URISyntaxException, MalformedURLException {
        // Write code here that turns the phrase above into concrete actions

        //configure driver
        service = new AppiumServiceBuilder().withIPAddress("127.0.0.1").usingPort(4723).build();
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("MyAndroidPhone"); // read from file
        options.setUdid("23ee5cf7"); // <-- The real device ID from `adb devices`
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setApp("//Users//ayaadel//Desktop//Weather Forecast//Weather forecast_82.01_APKPure.apk");
        options.setCapability("noReset", false);
        options.setCapability("fullReset", true);
        options.setCapability("autoGrantPermissions", true);
        options.setCapability("adbExecTimeout", 60000);
        driver = new AndroidDriver(service.getUrl(), options);//new URI("http://127.0.0.1:4723").toURL()
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        mainObject=new MainObjects(driver);

        // throw new PendingException();
    }

    @When("User tap on temperature button")
    public void userTapOnTemperatureButton() {
        // Write code here that turns the phrase above into concrete actions
        mainObject.tapTemperatureToggle();
    }

    @Then("Temperature change from C to F")
    public void temperatureChangeFromCToF() {
        // Write code here that turns the phrase above into concrete actions
         Assert.assertTrue(mainObject.isTemperatureC(), "Temperature toggle should be in Celsius (C)");

         //throw new PendingException();
    }

    @Then("TimeFormat to twelve")
    public void timeformatToTwelve() {
        // Write code here that turns the phrase above into concrete actions
       mainObject.tapTimeFormatToggle();
       Assert.assertTrue(mainObject.isTimeFormatTwelve(), "Time is 12");

    }

    @When("User Clicks Done")
    public void userClicksDone() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions

        mainObject.clickDone();

        // wait until data is loaded to swipe
        System.out.println("before sleep");
        Thread.sleep(6000);//wait until load
       // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
       // wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.graph.weather.forecast.channel:id/indicatorHome")));
        System.out.println("after sleep");
        WebElement layout = mainObject.scrollWeatherPage();
        mainObject.SwipeAction(layout,"left");
        System.out.println("after swipe");
    }



    @Then("Rain and Humidity is shown")
    public void rainAndHumidityIsShown() throws InterruptedException {
        // read hourly weather info row
        List<WebElement> list= mainObject.getHourRows();
        WebElement layout = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.graph.weather.forecast.channel:id/rvHour\")"));

        //swipe to next hours
        mainObject.SwipeAction(layout,"left");
        Thread.sleep(2000);

        list.addAll(mainObject.getHourRows());
        System.out.println("Total visible rows: " + list.size());
    // check visibility of rain and humidity icons
        for (WebElement row : list) {
            // Get all text views inside each row
            List<WebElement> images = row.findElements(AppiumBy.className("android.widget.ImageView"));
            Assert.assertFalse(images.isEmpty(), "No images found in this row");

            for (int i = 0; i < images.size(); i++) {

                WebElement image = images.get(i);
                Assert.assertTrue(image.isDisplayed(), "Image at index " + i + " is NOT displayed");
                System.out.println("Image at index " + i + " is displayed");
            }


        }



    }
    //close driver
    @After
    public void TearDown(){
        driver.quit();
    }
}
