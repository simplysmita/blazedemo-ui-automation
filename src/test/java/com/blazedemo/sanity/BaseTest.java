package com.blazedemo.sanity;

import com.blazedemo.util.ExcelHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * @author Smita Sahu
 * Parent Class for all Test Classes
 */
public class BaseTest {

    public static Logger log = Logger.getLogger(BaseTest.class.getSimpleName());

    public Properties config = null;
    public WebDriver webDriver = null;
    protected String excelFilePath;
    protected String excelSheetName;

    public void initConfiguration() {
        if (config == null) {
            try {
                config = new Properties();
                String configFileName = "config.properties";
                String configPath = System.getProperty("user.dir") + File.separator + "/src/test/resources" + File.separator + configFileName;
                FileInputStream fileInputStream = new FileInputStream(configPath);
                config.load(fileInputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public WebDriver initDriver() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-extensions");
        options.addArguments("--start-maximized");
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return driver;
    }

    @DataProvider
    public Object[][] getTestData() {
        return ExcelHelper.getScenarioList(ExcelHelper.loadSheet(excelFilePath, excelSheetName));
    }

    public void quitDriver() {
        webDriver.quit();
        webDriver = null;
    }

}
