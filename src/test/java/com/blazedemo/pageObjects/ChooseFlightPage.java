package com.blazedemo.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author Smita Sahu
 * ChooseFlightPage
 */
public class ChooseFlightPage extends BasePage {
    WebElement chooseFlight;

    public ChooseFlightPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Dynamically select one of the flight by passing the index
     * @param index of flight
     */
    public void clickChooseFlight(Integer index){
        chooseFlight = driver.findElement(By.xpath("(//input[contains(@type,'submit')])["+index+"]"));
        chooseFlight.click();
    }
}
