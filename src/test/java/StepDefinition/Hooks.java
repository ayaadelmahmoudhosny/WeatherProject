package StepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.DriverConfiguration;
import utils.TestSetup;

import java.io.File;
import java.io.IOException;

public class Hooks {

    private final DriverConfiguration driverManager;
    private final TestSetup setup;

    public Hooks(TestSetup setup) {  // DI via constructor
        this.setup = setup;
        driverManager = new DriverConfiguration();
    }

    @Before
    public void driverInit() throws IOException {
        System.out.println("🔥 Before Hook is running");

        setup.setDriver(driverManager.configureDriver());

        System.out.println("🔥 After Hook is running");
    }

    @After
    public void afterTest() {
        setup.getDriver().quit();
    }

    @AfterStep
    public void AddScreenshot(Scenario scenario) throws IOException {

        //screenshot
        File sourcePath = ((TakesScreenshot) setup.getDriver()).getScreenshotAs(OutputType.FILE);
        byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
        scenario.attach(fileContent, "image/png", "image");


    }
}
