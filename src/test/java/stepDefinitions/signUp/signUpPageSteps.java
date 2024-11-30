package stepDefinitions.signUp;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
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

    @When("fill name field with {string} on signup page")
    public void fill_name_field_with_on_signup_page(String name){
        signUpPage.fillNameField(name);
    }

    @When("fill email field with {string} on signup page")
    public void fill_email_field_with_on_signup_page(String email){
        signUpPage.fillEmailField(email);
    }

    @When("fill password field with {string} on signup page")
    public void fill_password_field_with(String password){
        signUpPage.fillPasswordField(password);
    }

    @When("click sign up button")
    public void click_Sign_up_button(){ signUpPage.clickSignUpButton();}

    @When("fill company name field with {string}")
    public void fill_company_name_field_with(String companyName){signUpPage.fillCompanyField(companyName);}

    @When("fill workspace name field with {string}")
    public void fill_workspace_name_field_with(String workspaceName){signUpPage.fillWorkspaceField(workspaceName);}

    @When("select {string} option from company size dropdown")
    public void select_option_from_company_size_dropdown(String optionName){
        signUpPage.clickCompanySizeDropdown();
        signUpPage.selectFromDropdown(optionName);
    }

    @When("select {string} option from location dropdown")
    public void select_option_from_location_dropdown(String optionName){
        signUpPage.clickCompanySizeDropdown();
        signUpPage.selectFromDropdown(optionName);
    }

    @When("click All Good button")
    public void click_All_Good_button(){signUpPage.clickAllGoodButton();}

    @Then("verify company name created is {string}")
    public void verify_company_name_created_is(String expectedCompanyName) {
        String actualCompanyName = signUpPage.getCompanyName();
        Assert.assertEquals(actualCompanyName, expectedCompanyName);
    }

    @Then("verify empty email warning appears on signup page")
    public void verify_empty_email_warning_appears_on_signup_page(){signUpPage.checkEmptyEmailWarning();}

    @Then("verify invalid email format warning appears on signup page")
    public void verify_invalid_email_warning_appears_on_signup_page(){signUpPage.checkInvalidEmailFormatWarning();}

    @Then("verify empty name warning appears on signup page")
    public void verify_empty_name_warning_appears_on_signup_page(){signUpPage.checkEmptyNameWarning();}

    @Then("verify empty password warning appears on signup page")
    public void verify_empty_password_warning_appears_on_signup_page(){signUpPage.checkEmptyPasswordWarning();}

    @Then("verify 6 digits password warning appears on signup page")
    public void verify_six_digits_password_warning_appears_on_singup_page(){signUpPage.checkSixDigitsWarning();}

    @Then("verify empty company name warning appears on signup page")
    public void verify_empty_company_name_warning_appears_on_signup_page(){signUpPage.checkEmptyCompanyNameWarning();}

    @Then("verify empty workspace name warning appears on signup page")
    public void verify_empty_worskpace_name_warnign_appears_on_signup_page(){signUpPage.checkEmptyWorkspaceNameWarning();}

    @Then("verify empty company size warning appears on signup page")
    public void verify_empty_company_size_warning_appears_on_signup_page(){signUpPage.checkEmptyCompanySizeWarning();}

    @Then("verify empty location warning appears on signup page")
    public void verify_empty_location_warning_appears_on_signup_page(){signUpPage.checkEmptyLocationWarning();}

    @When("clear the text of company name field")
    public void clear_the_text_of_company_name_field(){signUpPage.clearTextOfCompanyName();}

    @Then("verify company domain exist warning appears")
    public void verify_company_domain_exist_warning_appears(){signUpPage.checkCompanyDomainExistWarning();}

    @Then("verify company domain exist warning not appear")
    public void verify_company_domain_exist_warning_not_appear(){signUpPage.checkCompanyDomainExistWarningNotAppear();}

    @Then("verify company name is extracted from {string} email")
    public void verify_company_name_is_extracted_from_email(String email){
        signUpPage.getTheCompanyNameFromEmailDomain(email);
        signUpPage.checkCompanyNameEqualstoEmailDomain(email);
    }
}
