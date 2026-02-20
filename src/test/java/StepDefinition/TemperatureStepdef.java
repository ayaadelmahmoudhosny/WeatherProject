package StepDefinition;

import io.appium.java_client.AppiumBy;
import org.testng.Assert;
import pages.SettingPage;
import pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import io.appium.java_client.service.local.AppiumDriverLocalService;

public class TemperatureStepdef{

    public AppiumDriverLocalService service;
    private SettingPage settingObject = new SettingPage();
    private HomePage weatherobject = new HomePage();


    @Given("User in main page")
    public void userInMainPage() throws URISyntaxException, IOException {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("im here");
        System.out.println("im there");
    }

    @When("User tap on temperature button")
    public void userTapOnTemperatureButton() {
        // Write code here that turns the phrase above into concrete actions
        settingObject.tapTemperatureToggle();
    }

    @Then("Temperature change from C to F")
    public void temperatureChangeFromCToF() {
        // Write code here that turns the phrase above into concrete actions
        // Assert.assertTrue(settingObject.isTemperatureC(), "Temperature toggle should be in Celsius (C)");

         //throw new PendingException();
    }



    @When("User Clicks Done")
    public void userClicksDone() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions

        settingObject.clickDone();

        // wait until data is loaded to swipe
        System.out.println("before sleep");
        Thread.sleep(6000);//wait until load
       // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
       // wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.graph.weather.forecast.channel:id/indicatorHome")));
        System.out.println("after sleep");
        weatherobject.SwipeLayout();
        System.out.println("after swipe");
    }



    @Then("Rain and Humidity is shown")
    public void rainAndHumidityIsShown() throws InterruptedException {
        // read hourly weather info row
        List<WebElement> list= weatherobject.getHourRows();
        weatherobject.SwipeHoursRow();
        Thread.sleep(2000);

       list.addAll(weatherobject.getHourRows());
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


}
