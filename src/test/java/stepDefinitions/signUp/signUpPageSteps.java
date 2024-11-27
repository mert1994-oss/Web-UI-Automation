package stepDefinitions.signUp;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.loginPage.signUpPage;

public class signUpPageSteps {
    private signUpPage  signUpPage;

    public signUpPageSteps(signUpPage signUpPage){
        this.signUpPage = signUpPage;
    }

    @When("click Have an Account Sign In button")
    public void click_have_an_account_sign_in_button(){
        signUpPage.clickHaveAccountSignInButton();
    }

    @Then("verify browser URL is {string} on signup page")
    public void verify_browser_title_is_on_signup_page(String expectedBrowserUrl){
        signUpPage.checkBrowserUrlSignUpPage(expectedBrowserUrl);
    }
}
