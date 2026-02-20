package StepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.DriverManager;

import java.io.File;
import java.io.IOException;

public class Hooks {

    private DriverManager driverManager;

    @Before
    public void driverInit() throws IOException {
        System.out.println("🔥 Before Hook is running");
        DriverManager.configureDriver();
        System.out.println("🔥 After Hook is running");
    }

    @After
    public void afterTest() {
        DriverManager.driver.quit();
    }

    @AfterStep
    public void AddScreenshot(Scenario scenario) throws IOException {

        //screenshot
        File sourcePath= 	((TakesScreenshot)DriverManager.driver).getScreenshotAs(OutputType.FILE);
        byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
        scenario.attach(fileContent, "image/png", "image");
    }
}