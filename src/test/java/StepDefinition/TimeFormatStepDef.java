package StepDefinition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SettingPage;
import utils.DriverConfiguration;
import utils.TestSetup;

import java.io.IOException;

public class TimeFormatStepDef extends DriverConfiguration {

    private final SettingPage settingObject;

    public TimeFormatStepDef(TestSetup setup) {
        this.settingObject = new SettingPage(setup); // page object with driver
    }

    @When("User taps on time format button")
    public void userTapsOnTimeFormatButton() throws IOException {
        // Write code here that turns the phrase above into concrete actions
        settingObject.tapTimeFormatToggle();
    }

    @Then("Time Format changes")
    public void timeFormatChanges() {
        // Write code here that turns the phrase above into concrete actions

        //Assert.assertTrue(settingObject.isTimeFormatTwelve(), "Time is 12");
    }
}
