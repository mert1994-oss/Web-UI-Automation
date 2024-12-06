package pageObjects.loginPage;

import org.openqa.selenium.By;
import org.testng.Assert;
import pageObjects.base.BaseActions;

public class loginPage extends BaseActions {
    By tfEmail = By.id(":R1ipuusva:");
    By tfPassword = By.id(":R2ipuusva:");
    By btnSignIn = By.xpath("//button[contains(@class,'LoginForm_buttonPrimary')]");
    By warInvalidCredentials = By.xpath("//div[text()='Invalid credentials. Please check your email or password.']");
    By fieEmailWarning = By.id(":R1ipuusva:-helper-text");
    By fiePasswordWarning = By.id(":R2ipuusva:-helper-text");
    By btnSignInGoogle = By.xpath("//button[text()='Login with Google']");
    By tfEmailGoogle = By.id("identifierId");
    By tfPasswordGoogle = By.xpath("//div[text()='Enter your password']");
    By btnNextGoogle = By.xpath("//span[text()='Sonraki']");
    By btnDontHaveAccountSignUp = By.xpath("//*[contains(text(),'Sign')]");

    public void fillEmailField(String email) { sendKey(tfEmail, email); }

    public void fillPasswordField(String password){
        sendKey(tfPassword, password);
    }

    public void clickSignInButton(){
        click(btnSignIn);
    }

    public void checkInvalidCredentialsWarningExist(){
        checkElementPresence(warInvalidCredentials);
    }

    public void checkInvalidCredentialsWarningNotExist(){
        checkElementInvisible(warInvalidCredentials);
    }

    public void checkEmptyEmailWarning(){checkElementWithText(fieEmailWarning, "Please enter your email.");}

    public void checkEmptyPasswordWarning(){checkElementWithText(fiePasswordWarning, "Please enter your password.");}

    public void checkInvalidEmailFormatWarning(){checkElementWithText(fieEmailWarning, "Invalid email format.");}

    public void checkSixDigitsWarning(){checkElementWithText(fiePasswordWarning, "Password must be at least 6 characters long.");}

    public void clickSignInGoogleButton(){click(btnSignInGoogle);}

    public void fillEmailFieldGoogleLogin(String email){
        sendKey(tfEmailGoogle, email);
        click(btnNextGoogle);
    }

    public void fillPasswordFieldGoogle(String password){
        sendKey(tfPasswordGoogle, password);
        click(btnNextGoogle);
    }

    public void clickDontHaveAccountSignUpButton(){
        click(btnDontHaveAccountSignUp);
    }

    public void checkBrowserTitleLoginPage(String expectedBrowserUrl){
        String actualBrowserTitle = getBrowserUrl();
        Assert.assertEquals(actualBrowserTitle,expectedBrowserUrl);
    }
}
