package stepDefinitions.base;

import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.sql.Timestamp;
import static util.DriverFactory.cleanUpDriver;
import static util.DriverFactory.getDriver;

public class Hooks {

    @Before
    public void before() {
        getDriver();
    }

    @AfterStep
    public void captureException(Scenario scenario) {
        if (scenario.isFailed()) {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            String timeMiliseconds = String.valueOf(timestamp.getTime());
            byte[] screenshoot = ((TakesScreenshot) getDriver()).getScreenshotAs((OutputType.BYTES));
            scenario.attach(screenshoot, "image/png", timeMiliseconds);
        }
    }

    @After
    public void after() {
        cleanUpDriver();
    }
}