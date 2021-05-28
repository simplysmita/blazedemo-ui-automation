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
    private Integer chooseFlightIndex;
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

    public static BlazeUIDataModel loadDataFromSheet(int rowIndex) {
        Sheet sheet = ExcelHelper.getSheet();
        Row row = sheet.getRow(rowIndex);
        return BlazeUIDataModel.builder()
                .origin(getValue(row, 1))
                .destination(getValue(row, 2))
                .chooseFlightIndex(getIntValue(row, 3))
                .name(getValue(row, 4))
                .address(getValue(row, 5))
                .city(getValue(row, 6))
                .state(getValue(row, 7))
                .zipCode(String.valueOf(getLongValue(row, 8)))
                .cardType(getValue(row, 9))
                .creditCardNumber(getValue(row, 10))
                .creditCardMonth(String.valueOf(getIntValue(row, 11)))
                .creditCardYear(String.valueOf(getIntValue(row, 12)))
                .nameOnCard(getValue(row, 13))
                .rememberMe(getBooleanValue(row, 14))
                .build();
    }
}
