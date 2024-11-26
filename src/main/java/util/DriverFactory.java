package util;

import helper.DownloadHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.HashMap;
import java.util.Locale;
import java.util.Properties;

public class DriverFactory {

    public static final String BROWSER_TYPE = "chrome";
    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();
    private static Properties properties = ConfigReader.getProperties();

    public static String DOWNLOAD_PATH = System.getProperty("user.dir") + "\\download\\";

    public static WebDriver getDriver() {
        if (webDriver.get() == null) {
            webDriver.set(createDriver());
        }
        return webDriver.get();
    }

    private static WebDriver createDriver() {
        WebDriver driver = null;

        switch (BROWSER_TYPE) {
            case "chrome" -> {

                HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
                chromePrefs.put("profile.default_content_settings.popups", 0);
                chromePrefs.put("download.default_directory", DOWNLOAD_PATH);
                DownloadHelper.initializeDownloadPath();

                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setExperimentalOption("prefs", chromePrefs);

                if (properties.getProperty("os").equals("mac-arm")) {
                    //chromeOptions.setBinary("./src/test/resources/drivers/mac/arm/Chrome.app/Contents/MacOS/Google Chrome for Testing");
                    WebDriverManager.chromedriver().driverVersion(properties.getProperty("chrome.version")).mac().arm64().setup();
                } else if (properties.getProperty("os").equals("mac-x64")) {
                    WebDriverManager.chromedriver().driverVersion(properties.getProperty("chrome.version")).mac().arch64().setup();
                } else {
                    WebDriverManager.chromedriver().driverVersion(properties.getProperty("chrome.version")).setup();
                }

                if (properties.getProperty("headless").equals("true")) {
                    chromeOptions.addArguments("--headless");
                    Locale.setDefault(Locale.US);
                    chromeOptions.addArguments("--window-size=1920,1080", "--disable-gpu", "--no-sandbox", "--disable-dev-shm-usage");
                }

                if(properties.getProperty("os").equals("linux")) {
                    System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
                }

                driver = new ChromeDriver(chromeOptions);
            }

            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
        }

        driver.manage().window().maximize();

        return driver;
    }

    public static void cleanUpDriver() {
        webDriver.get().quit();
        webDriver.remove();
    }
}
