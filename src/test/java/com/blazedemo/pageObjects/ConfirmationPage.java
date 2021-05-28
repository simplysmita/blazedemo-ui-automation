package com.blazedemo.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author Smita Sahu
 * ConfirmationPage
 */
public class ConfirmationPage extends BasePage {

    @FindBy(xpath = "//table/tbody/tr[1]/td[2]")
    WebElement confirmationId;

    public ConfirmationPage(WebDriver driver) {
        super(driver);
    }

    public void printConfirmationId(){
        log.info("Confirmation ID: "+confirmationId.getText());
    }
}
