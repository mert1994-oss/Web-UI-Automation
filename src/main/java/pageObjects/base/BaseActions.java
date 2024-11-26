package pageObjects.base;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.collections.Lists;
import util.ConfigReader;
import util.DriverFactory;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import static util.DriverFactory.getDriver;

public class BaseActions{

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions action;

    public BaseActions() {
        PageFactory.initElements(getDriver(), this);

        this.driver = getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        this.action = new Actions(driver);
    }

    public void navigateToPath(String path) {
        StringBuilder builder = new StringBuilder(ConfigReader.getProperties().get(path).toString());
        driver.get(builder.toString());
    }


    protected WebElement findElement(By key) {
        WebElement element = presenceElement(key);
        scrollToElement(element);
        return element;
    }


    protected List<WebElement> findElements(By key) {
        List<WebElement> elements = presenceElements(key);
        scrollToElement(elements.get(0));
        return elements;
    }


    protected void click(By key) {
        wait.until(ExpectedConditions.elementToBeClickable(key));
        findElement(key).click();
    }


    public void actionsClick(By key) {
        Actions act = new Actions(driver);
        act.moveToElement(findElement(key)).click().build().perform();
    }


    public void actionsClick(WebElement webElement) {
        Actions act = new Actions(driver);
        act.moveToElement(webElement).click().build().perform();
    }


    protected void click(WebElement webElement) {
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();
    }


    protected void clickCheckbox(WebElement webElement) {
        click(webElement);
        sleep(500);
    }


    protected void sendKey(By key, String text) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(key));
        element.clear();
        element.sendKeys(text);
    }


    protected String getText(By key) {
        return findElement(key).getText();
    }


    protected boolean checkElementText(By key, String text) {
        return wait.until(ExpectedConditions.textToBe(key, text));
    }


    protected void checkElementVisible(By key) {
        wait.until(ExpectedConditions.visibilityOf(findElement(key)));
    }


    protected void checkElementPresence(By key) {
        wait.until(ExpectedConditions.presenceOfElementLocated(key));
    }

    protected void checkElementInvisible(By key) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(key));
    }

    protected void checkElementInvisible(WebElement element){
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    protected boolean checkElementNotPresent(By key) {
        return driver.findElements(key).size() == 0;
    }


    protected boolean checkTitle(String text) {
        return wait.until(ExpectedConditions.titleIs(text));
    }


    protected String getAttribute(By key, String attr) {
        return findElement(key).getAttribute(attr);
    }


    protected void checkAttribute(By key, String attr, String text) {
        Assert.assertEquals(getAttribute(key, attr), text);
    }


    protected void checkAttributeWithText(By key, String attr, String text){
        wait.until(ExpectedConditions.attributeContains(key,attr,text));
    }


    protected void checkAttributeWithText(WebElement element, String attr, String text){
        wait.until(ExpectedConditions.attributeContains(element,attr,text));
    }


    protected void clickElementWithText(By key, String text) {
        boolean find = false;
        List<WebElement> elements = findElements(key);
        for (WebElement element : elements) {
            if (element.getText().contains(text)) {
                element.click();
                find = true;
                break;
            }
        }
        Assert.assertEquals(true, find);
    }


    protected void checkElementWithText(By key, String text) {
        boolean find = false;
        List<WebElement> elements = findElements(key);
        for (WebElement element : elements) {
            if (element.getText().contains(text)) {
                find = true;
                break;
            }
        }
        Assert.assertEquals(true, find);
    }


    protected void sendKeyElementWithText(By key, String text, String text2) {
        boolean find = false;
        List<WebElement> elements = findElements(key);
        for (WebElement element : elements) {
            if (element.getText().equals(text)) {
                element.sendKeys(text2);
                find = true;
                break;
            }
        }
        Assert.assertEquals(true, find);
    }

    protected int getWebElementsCount(By key) {
        List<WebElement> elements = findElements(key);
        return elements.size();
    }


    protected WebElement presenceElement(By key) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(key));
    }


    protected List<WebElement> presenceElements(By key) {
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(key));
    }


    protected void scrollToElement(WebElement element) {
        String scrollElementIntoMiddle = "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);"
                + "var elementTop = arguments[0].getBoundingClientRect().top;"
                + "window.scrollBy(0, elementTop-(viewPortHeight/2));";
        ((JavascriptExecutor) driver).executeScript(scrollElementIntoMiddle, element);

    }


    public boolean checkCloudToken() {
        return driver.manage().getCookies().stream().filter(cookie -> cookie.getName().equals("ps_cloud_token")).count() == 1;

    }


    protected void hoverOver(By key) {
        action.moveToElement(presenceElement(key)).perform();
    }


    public void overwriteText(By key, String text) {
        doubleClick(key);
        findElement(key).sendKeys(text);
    }


    public void doubleClick(By key) {
        action.doubleClick(findElement(key)).build().perform();
    }


    protected boolean checkSelected(By key) {
        wait.until(ExpectedConditions.presenceOfElementLocated(key));
        return driver.findElement(key).isSelected();
    }


    protected void sleep(long millisec) {
        try {
            Thread.sleep(millisec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void checkSuccessPopUpDisappears() {
        By successPopUpNotification = By.cssSelector(".notification-success[role=alert]");
        By psPulseTheme = By.className("pspulsetheme");
        click(psPulseTheme);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(successPopUpNotification));
    }


    public void switchToTab(int tabNumber) {
        List<String> browserTabs = Lists.newArrayList(driver.getWindowHandles());
        driver.switchTo().window(browserTabs.get(tabNumber - 1));
    }


    public String getBrowserTitle() {
        return driver.getTitle();
    }

    public String getScreenShot(String testCaseName, WebDriver driver) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File file = new File(System.getProperty("user.dir")+"//reports//"+testCaseName+".png");
        FileUtils.copyFile(source, file);
        return System.getProperty("user.dir")+"reports"+testCaseName+".png";
    }
}