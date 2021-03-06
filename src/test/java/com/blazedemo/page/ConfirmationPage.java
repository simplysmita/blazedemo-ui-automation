package com.blazedemo.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.testng.Assert.assertNotNull;

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
        assertNotNull("Missing confirmationId", confirmationId.getText());
        log.info("Confirmation ID: "+confirmationId.getText());
    }
}
