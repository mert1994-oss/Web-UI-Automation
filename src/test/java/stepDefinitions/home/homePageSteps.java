package stepDefinitions.home;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObjects.pages.homePage;

public class homePageSteps {
    private final homePage homePage;

    public homePageSteps(homePage homePage) {
        this.homePage = homePage;
    }

    @When("user selects {string} as the time range")
    public void user_selects_time_range(String timeRange) {
        homePage.selectTimeRange(timeRange);
    }

    @Then("verify {string} stat value is {string}")
    public void verify_stat_value(String statName, String expectedValue) {
        homePage.verifyStatValue(statName, expectedValue);
    }

    @When("user clicks on Create Job button")
    public void user_clicks_create_job_button() {
        homePage.clickCreateJobButton();
    }

    @When("user clicks on View Interviews button")
    public void user_clicks_view_interviews_button() {
        homePage.clickViewInterviewsButton();
    }

    @When("user clicks on Start Simulation button")
    public void user_clicks_start_simulation_button() {
        homePage.clickStartSimulationButton();
    }

    @When("user opens the tutorial modal")
    public void user_opens_tutorial_modal() {
        homePage.openTutorialModal();
    }

    @Then("verify tutorial modal is open")
    public void verify_tutorial_modal_is_open() {
        homePage.verifyModalIsOpen();
    }

    @When("user closes the tutorial modal")
    public void user_closes_tutorial_modal() {
        homePage.closeModal();
    }
}
