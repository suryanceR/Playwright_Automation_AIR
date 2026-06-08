package hooks;

import io.cucumber.java.*;

import com.aventstack.extentreports.*;
import utils.ReportManager;

public class Hooks {

    public static ExtentReports extent =
            ReportManager.getInstance();

    public static ExtentTest test;

    @Before
    public void beforeScenario(Scenario scenario) {

        test =
                extent.createTest(
                        scenario.getName());
    }

    @After
    public void afterScenario(Scenario scenario) {

        if(scenario.isFailed()) {

            test.fail("Scenario Failed");
        }

        else {

            test.pass("Scenario Passed");
        }

        extent.flush();
    }
}