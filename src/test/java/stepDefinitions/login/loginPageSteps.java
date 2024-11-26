package stepDefinitions.login;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageObjects.base.BaseActions;
import pageObjects.loginPage.loginPage;
import util.DriverFactory;

import java.util.Set;

public class loginPageSteps {
    private loginPage loginPage;

    public loginPageSteps(loginPage loginPage){
        this.loginPage = loginPage;
    }

    @When("fill email field with {string}")
    public void fill_email_field_with(String email){
        loginPage.fillEmailField(email);
    }

    @When("fill password field with {string}")
    public void fill_password_field_with(String password){
        loginPage.fillPasswordField(password);
    }

    @When("click sign in button")
    public void click_Sign_In_button(){
        loginPage.clickSignInButton();
    }

    @Then("verify invalid credentials warning appears")
    public void verify_invalid_credentials_warning_appears(){
        loginPage.checkInvalidCredentialsWarningExist();
    }

    @Then("verify invalid credentials warning not appears")
    public void verify_invalid_credentials_warning_not_appears(){
        loginPage.checkInvalidCredentialsWarningNotExist();
    }

    @When("verify empty email warning appears")
    public void verify_empty_email_warning_appears(){
        loginPage.checkEmptyEmailWarning();
    }

    @When("verify empty password warning appears")
    public void verify_empty_password_warning_appears(){
        loginPage.checkEmptyPasswordWarning();
    }

    @When("verify invalid email format warning appears")
    public void verify_invalid_email_format_warning_appears(){
        loginPage.checkInvalidEmailFormatWarning();
    }

    @Then("verify 6 digits password warning appears")
    public void verify_six_digits_password_warning_appears(){
        loginPage.checkSixDigitsWarning();
    }

    @When("fill {string} email and {string} password fields on Google Login")
    public void fill_email_and_password_fields_on_google_login(String email, String password) throws InterruptedException {
        loginPage.clickSignInGoogleButton();
        Thread.sleep(9000);
        WebDriver driver = DriverFactory.getDriver();
        String originalWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();
        for (String windowHandle : allWindows) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        loginPage.fillEmailFieldGoogleLogin(email);
        loginPage.fillPasswordFieldGoogle(password);
        driver.switchTo().window(originalWindow);
    }

}
