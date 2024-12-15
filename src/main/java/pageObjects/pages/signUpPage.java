package pageObjects.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pageObjects.base.BaseActions;
import org.openqa.selenium.By;

public class signUpPage extends BaseActions {
    By tfName = By.id(":R1ipuusva:");
    By tfEmail = By.id(":R2ipuusva:");
    By tfPassword = By.id(":R3ipuusva:");
    By btnSignup = By.xpath("//button[text()='Sign Up']");
    By btnSignupWithGoogle = By.xpath("//button[text()='Sign Up with Google']");
    By btnHaveAccountSignIn = By.xpath("//a[@class='SignupForm_linkPrimary__nX_ei']");
    By tfCompanyName = By.id(":r0:");
    By tfWorkspaceName = By.id(":r1:");
    By drpCompanySize = By.xpath("//div[@aria-controls=':r2:']");
    By drpLocation = By.xpath("//div[@aria-controls=':r3:']");
    By btnAllGood = By.xpath("//button[contains(@class, 'submitButton')]");
    By fieNameWarning = By.id(":R1ipuusva:-helper-text");
    By fieEmailWarning = By.id(":R2ipuusva:-helper-text");
    By fiePasswordWarning = By.id(":R3ipuusva:-helper-text");
    By fieCompanyNameWarning = By.id(":r0:-helper-text");
    By fieWorkspaceNameWarning = By.id(":r1:-helper-text");
    By fieCompanySizeWarning = By.xpath("//p[text()='Company size is required.']");
    By fieLocationWarning =By.xpath("//p[text()='Location is required.']");
    By warCompanyDomainExists = By.xpath("//div[text()='Company with domain fixed.com already exists.']");


    public void clickHaveAccountSignInButton(){
        click(btnHaveAccountSignIn);
    }

    public void checkBrowserUrlSignUpPage(String expectedBrowserUrl){
        String actualBrowserTitle = getBrowserUrl();
        Assert.assertEquals(actualBrowserTitle,expectedBrowserUrl);
    }

    public void fillNameField(String name) { sendKey(tfName, name); }

    public void fillEmailField(String email) { sendKey(tfEmail, email); }

    public void fillPasswordField(String password){
        sendKey(tfPassword, password);
    }

    public void clickSignUpButton(){click(btnSignup);}

    public void clickSignUpGoogleButton(){click(btnSignupWithGoogle);}

    public void fillCompanyField(String company){sendKey(tfCompanyName, company);}

    public String getCompanyName(){return getText(tfCompanyName);}

    public void fillWorkspaceField(String workspaceName){sendKey(tfWorkspaceName, workspaceName);}

    public void clickCompanySizeDropdown(){click(drpCompanySize);}

    public void clickLocationDropdown(){click(drpLocation);}

    public void clickAllGoodButton(){click(btnAllGood);}

    public void selectFromDropdown(String option){
        By selection = By.xpath("//li[@data-value='"+ option +"']");
        click(selection);
    }

    public void checkEmptyEmailWarning(){checkElementWithText(fieEmailWarning, "Please enter your email.");}

    public void checkInvalidEmailFormatWarning(){checkElementWithText(fieEmailWarning, "Invalid email format.");}

    public void checkEmptyNameWarning(){checkElementWithText(fieNameWarning, "Please enter your name.");}

    public void checkEmptyPasswordWarning(){checkElementWithText(fiePasswordWarning, "Please enter your password.");}

    public void checkSixDigitsWarning(){checkElementWithText(fiePasswordWarning, "Password must be at least 6 characters long.");}

    public void checkEmptyCompanyNameWarning(){checkElementPresence(fieCompanyNameWarning);}

    public void checkEmptyWorkspaceNameWarning(){checkElementPresence(fieWorkspaceNameWarning);}

    public void checkEmptyCompanySizeWarning(){checkElementPresence(fieCompanySizeWarning);}

    public void checkEmptyLocationWarning(){checkElementPresence(fieLocationWarning);}

    public void clearTextOfCompanyName(){
        wait.until(ExpectedConditions.elementToBeClickable(tfCompanyName));
        WebElement element = driver.findElement(By.xpath("//input[@id=':r0:']"));
        element.click();
        while (!element.getAttribute("value").isEmpty()) {
            element.sendKeys(Keys.BACK_SPACE);
        }
    }

    public void checkCompanyDomainExistWarning(){checkElementPresence(warCompanyDomainExists);}

    public void checkCompanyDomainExistWarningNotAppear(){checkElementInvisible(warCompanyDomainExists);}

    public String getTheCompanyNameFromEmailDomain(String email){
        String[] splittedText = email.split("@");
        return splittedText[1].split("\\.")[0];
    }

    public void checkCompanyNameEqualstoEmailDomain(String email){
        String expectedText = getTheCompanyNameFromEmailDomain(email);
        wait.until(ExpectedConditions.elementToBeClickable(tfCompanyName));
        WebElement element = driver.findElement(By.xpath("//input[@id=':r0:']"));
        String actualText = element.getAttribute("value");
        Assert.assertEquals(actualText, expectedText);
    }

}
