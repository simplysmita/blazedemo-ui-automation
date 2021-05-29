package com.blazedemo.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

/**
 * @author Smita Sahu
 * FindFlightsPage
 */
public class FindFlightsPage extends BasePage {

    @FindBy(name = "fromPort")
    WebElement fromPort;

    @FindBy(name = "toPort")
    WebElement toPort;

    @FindBy(xpath = "//input[contains(@class,'btn btn-primary')]")
    WebElement findFlights;
    @FindBy(xpath = "//a[@href='vacation.html']")
    WebElement imgLink;
    @FindBy(xpath = "//h1")
    WebElement blazeDemoHeading;
    @FindBy(xpath = "//h2")
    WebElement fromPortHeading;
    @FindBy(xpath = "//h2")
    WebElement toPortHeading;

    public FindFlightsPage(WebDriver driver) {
        super(driver);
    }

    public void selectOriginAndDestination(String origin, String destination) {
        Select originDropDown = new Select(fromPort);
        originDropDown.selectByValue(origin);
        Select destinationDropDown = new Select(toPort);
        destinationDropDown.selectByValue(destination);
    }

    public void clickFindFlights() {
        findFlights.click();
    }

    public void clickImageLink() {
        imgLink.click();
    }

    public String getTitleHeader() {
        return blazeDemoHeading.getText();
    }
}
