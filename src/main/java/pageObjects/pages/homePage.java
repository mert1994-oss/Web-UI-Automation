package pageObjects.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageObjects.base.BaseActions;


    public class homePage extends BaseActions {
        By selectTimeRange = By.xpath("//div[contains(@class, 'mantine-Select-input')]");
        By statsSection = By.xpath("//div[contains(@class, 'mantine-SimpleGrid-root')]");
        By btnCreateJob = By.xpath("//button[text()='Create Job']");
        By btnViewInterviews = By.xpath("//button[text()='View Interviews']");
        By btnStartSimulation = By.xpath("//button[text()='Start Simulation']");
        By modalCloseButton = By.xpath("//button[contains(@class, 'mantine-Modal-close')]");
        By modalVideoIframe = By.xpath("//iframe[contains(@src, 'youtube')]");

        public void selectTimeRange(String timeRange) {
            click(selectTimeRange);
            By option = By.xpath("//div[contains(@class, 'mantine-Select-item') and text()='" + timeRange + "']");
            click(option);
        }

        public void verifyStatValue(String statName, String expectedValue) {
            By statLocator = By.xpath("//div[text()='" + statName + "']/following-sibling::div[contains(@class, 'mantine-Text-root')]");
            String actualValue = getText(statLocator);
            Assert.assertEquals(actualValue, expectedValue);
        }

        public void clickCreateJobButton() {
            click(btnCreateJob);
        }

        public void clickViewInterviewsButton() {
            click(btnViewInterviews);
        }

        public void clickStartSimulationButton() {
            click(btnStartSimulation);
        }

        public void openTutorialModal() {
            By tutorialLink = By.xpath("//span[text()='Learn more with the tutorial!']");
            click(tutorialLink);
        }

        public void verifyModalIsOpen() {
            WebElement iframeElement = driver.findElement(modalVideoIframe);
            Assert.assertTrue(iframeElement.isDisplayed());
        }

        public void closeModal() {
            click(modalCloseButton);
        }
    }


