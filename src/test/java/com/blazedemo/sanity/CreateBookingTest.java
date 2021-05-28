package com.blazedemo.sanity;

import com.blazedemo.model.BlazeUIDataModel;
import com.blazedemo.page.ChooseFlightPage;
import com.blazedemo.page.ConfirmationPage;
import com.blazedemo.page.FindFlightsPage;
import com.blazedemo.page.PurchaseFlight;
import org.testng.annotations.Test;

import java.io.File;

public class CreateBookingTest extends BaseTest {
    FindFlightsPage findFlightsPage;
    ChooseFlightPage chooseFlightPage;
    PurchaseFlight purchaseFlightPage;
    ConfirmationPage confirmationPage;

    public CreateBookingTest() {
        excelFilePath = System.getProperty("user.dir") + File.separator + "test_data" + File.separator + "BlazeUiData.xlsx";
        excelSheetName = "data";
    }


    @Test(dataProvider = "getTestData")
    public void testEndToEndESuccess(String scenarioName, int rowIndex) throws InterruptedException {
        log.info("Scenario Name: " + scenarioName);
        BlazeUIDataModel blazeUIData = BlazeUIDataModel.loadDataFromSheet(rowIndex);
        webDriver.get("https://blazedemo.com/");
        findFlightsPage = new FindFlightsPage(webDriver);
        findFlightsPage.waitInDebug();
        findFlightsPage.selectOriginAndDestination(blazeUIData.getOrigin(), blazeUIData.getDestination());
        findFlightsPage.waitInDebug();
        findFlightsPage.clickFindFlights();
        findFlightsPage.waitInDebug();
        chooseFlightPage = new ChooseFlightPage(webDriver);
        chooseFlightPage.clickChooseFlight(blazeUIData.getChooseFlightIndex());
        findFlightsPage.waitInDebug();
        purchaseFlightPage = new PurchaseFlight(webDriver);
        purchaseFlightPage.fillForm(blazeUIData.getName(), blazeUIData.getAddress(),blazeUIData.getCity(),
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
