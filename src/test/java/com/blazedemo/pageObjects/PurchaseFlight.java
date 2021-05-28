package com.blazedemo.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

/**
 * @author Smita Sahu
 * PurchaseFlight
 */
public class PurchaseFlight extends BasePage {

    @FindBy(id = "inputName")
    WebElement nameWebElement;

    @FindBy(id = "address")
    WebElement addressWebElement;

    @FindBy(id = "city")
    WebElement cityWebElement;

    @FindBy(id = "state")
    WebElement stateWebElement;

    @FindBy(id = "zipCode")
    WebElement zipCodeWebElement;

    @FindBy(name = "cardType")
    WebElement cardTypeWebElement;

    @FindBy(name = "creditCardNumber")
    WebElement creditCardNumberWebElement;

    @FindBy(id = "creditCardMonth")
    WebElement creditCardMonthWebElement;

    @FindBy(id = "creditCardYear")
    WebElement creditCardYearWebElement;

    @FindBy(name = "nameOnCard")
    WebElement nameOnCardWebElement;

    @FindBy(id = "rememberMe")
    WebElement rememberMeWebElement;

    @FindBy(xpath = "//input[contains(@class,'btn btn-primary')]")
    WebElement purchaseFlightWebElement;

    public PurchaseFlight(WebDriver driver) {
        super(driver);
    }

    /**
     * Fill the form data
     * @param name
     * @param address
     * @param city
     * @param state
     * @param zipCode
     * @param cardType
     * @param ccNumber
     * @param ccMonth
     * @param ccYear
     * @param cardName
     */
    public void fillForm(String name, String address, String city, String state, String zipCode, String cardType, String ccNumber, String ccMonth, String ccYear, String cardName) {
        nameWebElement.sendKeys(name);
        addressWebElement.sendKeys(address);
        cityWebElement.sendKeys(city);
        stateWebElement.sendKeys(state);
        zipCodeWebElement.sendKeys(zipCode);
        Select cardSelect=new Select(cardTypeWebElement);
        cardSelect.selectByValue(cardType);
        creditCardNumberWebElement.sendKeys(ccNumber);
        creditCardMonthWebElement.sendKeys(ccMonth);
        creditCardYearWebElement.sendKeys(ccYear);
        nameOnCardWebElement.sendKeys(cardName);
    }

    public void updateRememberMe(){
        rememberMeWebElement.click();
    }

    public void clickPurchaseFlight(){
        purchaseFlightWebElement.click();
    }
}
