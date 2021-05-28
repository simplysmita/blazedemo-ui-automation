package com.blazedemo.pageObjects;

import com.blazedemo.sanitySuite.BaseTest;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Smita Sahu
 * Parent Class for all Page Objects
 */
public class BasePage {
    protected WebDriver driver = null;
    protected Logger log = BaseTest.log;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public static void wait(int timeInSeconds) {
        try {
            Thread.sleep(timeInSeconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
