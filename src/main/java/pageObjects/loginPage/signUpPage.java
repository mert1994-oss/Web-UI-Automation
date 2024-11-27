package pageObjects.loginPage;

import org.testng.Assert;
import pageObjects.base.BaseActions;
import org.openqa.selenium.By;

public class signUpPage extends BaseActions {
    By tfName = By.id(":Rcmfnkva:");
    By tfEmail = By.id(":Rkmfnkva:");
    By tfPassword = By.id(":Rsmfnkva:");
    By btnSignup = By.xpath("//button[text()='Sign Up']");
    By btnSignupWithGoogle = By.xpath("//button[text()='Sign Up with Google']");
    By btnHaveAccountSignIn = By.xpath("//a[@class='SignupForm_linkPrimary__nX_ei']");

    public void clickHaveAccountSignInButton(){
        click(btnHaveAccountSignIn);
    }

    public void checkBrowserUrlSignUpPage(String expectedBrowserUrl){
        String actualBrowserTitle = getBrowserUrl();
        Assert.assertEquals(actualBrowserTitle,expectedBrowserUrl);
    }
}
