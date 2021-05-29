package com.blazedemo.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.testng.Assert.assertNotNull;

/**
 * @author Smita Sahu
 * ChooseFlightPage
 */
public class ChooseFlightPage extends BasePage {
    WebElement chooseFlight;
    WebElement departHeader;
    WebElement arrivesHeader;

    public ChooseFlightPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Dynamically select one of the flight by passing the index
     * @param index of flight
     */
    public void clickChooseFlight(Long index){
        chooseFlight = driver.findElement(By.xpath("(//input[contains(@type,'submit')])["+index+"]"));
        chooseFlight.click();
    }
    public void validateArrivalAndDeparture(String origin, String destination){
        departHeader=driver.findElement(By.xpath("//th[contains(.,'Departs: "+origin+"')]"));
        arrivesHeader=driver.findElement(By.xpath("//th[contains(.,'Arrives: "+destination+"')]"));
        assertNotNull(departHeader.getText(),"Departure City not matching");
        assertNotNull(arrivesHeader.getText(),"Arrival City not matching");
        log.info("Assertion of Departure and Arrival City is successful");
    }


}
