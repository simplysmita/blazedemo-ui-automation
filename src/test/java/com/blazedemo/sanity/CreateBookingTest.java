package com.blazedemo.sanity;

import com.blazedemo.model.BlazeUIDataModel;
import com.blazedemo.page.ChooseFlightPage;
import com.blazedemo.page.ConfirmationPage;
import com.blazedemo.page.FindFlightsPage;
import com.blazedemo.page.PurchaseFlight;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.File;

import static org.testng.Assert.assertEquals;

public class CreateBookingTest extends BaseTest {
    FindFlightsPage findFlightsPage;
    ChooseFlightPage chooseFlightPage;
    PurchaseFlight purchaseFlightPage;
    ConfirmationPage confirmationPage;

    @BeforeSuite(alwaysRun = true)
    public void setUp() {
        log.info("Before Suite entered");
        initConfiguration();
        webDriver = initDriver();
    }

    @AfterSuite
    public void tearDown() {
        quitDriver();
    }

    public CreateBookingTest() {
        excelFilePath = System.getProperty("user.dir") + File.separator + "test_data" + File.separator + "BlazeUiData.xlsx";
        excelSheetName = "data";
    }


    @Test(dataProvider = "getTestData", priority = 2)
    public void testEndToEndESuccess(String scenarioName, int rowIndex) {
        log.info("Scenario Name: " + scenarioName);
        BlazeUIDataModel blazeUIData = BlazeUIDataModel.loadDataFromSheet(rowIndex);
        webDriver.get("https://blazedemo.com/");
        findFlightsPage.waitInDebug();
        if (blazeUIData.getImageLink() == true) {
            findFlightsPage.clickImageLink();
            findFlightsPage.waitInDebug();
        } else {
            findFlightsPage.selectOriginAndDestination(blazeUIData.getOrigin(), blazeUIData.getDestination());
            findFlightsPage.waitInDebug();
            findFlightsPage.clickFindFlights();
            findFlightsPage.waitInDebug();
            chooseFlightPage = new ChooseFlightPage(webDriver);
            chooseFlightPage.validateArrivalAndDeparture(blazeUIData.getOrigin(), blazeUIData.getDestination());
            chooseFlightPage.clickChooseFlight(blazeUIData.getChooseFlightIndex());
            chooseFlightPage.waitInDebug();
            purchaseFlightPage = new PurchaseFlight(webDriver);
            purchaseFlightPage.fillForm(blazeUIData.getName(), blazeUIData.getAddress(), blazeUIData.getCity(),
                    blazeUIData.getState(), blazeUIData.getZipCode(), blazeUIData.getCardType(), blazeUIData.getCreditCardNumber(),
                    blazeUIData.getCreditCardMonth(), blazeUIData.getCreditCardYear(), blazeUIData.getNameOnCard());
            purchaseFlightPage.updateRememberMe(blazeUIData.getRememberMe());
            purchaseFlightPage.waitInDebug();
            purchaseFlightPage.clickPurchaseFlight();
            purchaseFlightPage.waitInDebug();
            confirmationPage = new ConfirmationPage(webDriver);
            confirmationPage.printConfirmationId();
        }
    }

    @Test(priority = 3)
    public void backAndForth() throws InterruptedException {
        webDriver.get("https://blazedemo.com/");
        findFlightsPage = new FindFlightsPage(webDriver);
        findFlightsPage.waitInDebug();
        findFlightsPage.selectOriginAndDestination("Paris", "London");
        findFlightsPage.waitInDebug();
        findFlightsPage.clickFindFlights();
        findFlightsPage.waitInDebug();
        webDriver.navigate().back();
        findFlightsPage.waitInDebug();
        webDriver.navigate().forward();
        chooseFlightPage = new ChooseFlightPage(webDriver);
        chooseFlightPage.clickChooseFlight(2L);
    }

    @Test(priority = 1)
    public void pageTitleVerify() {
        webDriver.get("https://blazedemo.com/");
        findFlightsPage = new FindFlightsPage(webDriver);
        String title = findFlightsPage.getTitleHeader();
        log.info("Blazedemo title is: " + title);
        assertEquals(title, config.getProperty("blazedemo_title"));

    }
}
