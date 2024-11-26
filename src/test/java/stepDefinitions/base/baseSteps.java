package stepDefinitions.base;

import io.cucumber.java.en.When;
import pageObjects.base.BaseActions;

public class baseSteps extends BaseActions {

    @When("Navigate to login page")
    public void navigate_to_login_page(){
        navigateToPath("loginUrl");
    }

    @When("Navigate to signup page")
    public void navigate_to_signup_page(){
        navigateToPath("signUpUrl");
    }
}
