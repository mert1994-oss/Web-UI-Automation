package pageObjects.loginPage;

import org.openqa.selenium.By;
import pageObjects.base.BaseActions;

public class interviewListPage extends BaseActions {
    By btnAddInterview = By.xpath("//button[text()='Add Interview']");
    By tabActive = By.xpath("//button[text()='Active']");
    By tabDraft = By.xpath("//button[text()='Draft']");
    By tabPassive = By.xpath("//button[text()='Passive']");
}
