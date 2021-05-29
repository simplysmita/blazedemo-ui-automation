package com.blazedemo.model;

import com.blazedemo.util.ExcelHelper;
import lombok.Builder;
import lombok.Data;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import static com.blazedemo.util.ExcelHelper.*;

@Data
@Builder
public class BlazeUIDataModel {
    private String origin;
    private String destination;
    private Long chooseFlightIndex;
    private String name;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private String cardType;
    private String creditCardNumber;
    private String creditCardMonth;
    private String creditCardYear;
    private String nameOnCard;
    private Boolean rememberMe;
    private Boolean imageLink;

    public static BlazeUIDataModel loadDataFromSheet(int rowIndex) {
        Sheet sheet = ExcelHelper.getSheet();
        Row row = sheet.getRow(rowIndex);
        return BlazeUIDataModel.builder()
                .origin(getStringValue(row, 1))
                .destination(getStringValue(row, 2))
                .chooseFlightIndex(getLongValue(row, 3))
                .name(getStringValue(row, 4))
                .address(getStringValue(row, 5))
                .city(getStringValue(row, 6))
                .state(getStringValue(row, 7))
                .zipCode(String.valueOf(getLongValue(row, 8)))
                .cardType(getStringValue(row, 9))
                .creditCardNumber(getStringValue(row, 10))
                .creditCardMonth(String.valueOf(getLongValue(row, 11)))
                .creditCardYear(String.valueOf(getLongValue(row, 12)))
                .nameOnCard(getStringValue(row, 13))
                .rememberMe(getBooleanValue(row, 14))
                .imageLink(getBooleanValue(row,15))
                .build();
    }
}
