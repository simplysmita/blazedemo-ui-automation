package com.blazedemo.util;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelHelper {
    public static Sheet sheet;

    private ExcelHelper() {
        //No implementation
    }

    public static Sheet loadSheet(String filePath, String sheetName) {
        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            Workbook workbook = WorkbookFactory.create(fileInputStream);
            sheet = workbook.getSheet(sheetName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sheet;
    }

    public static Sheet getSheet() {
        return sheet;
    }

    public static Object[][] getScenarioList(Sheet sheet) {
        int lastRowNum = sheet.getLastRowNum() ;
        Object[][] scenarioArray = new Object[lastRowNum][2];
        for (int i = 1; i <= lastRowNum; i++) {
            scenarioArray[i - 1][0] = sheet.getRow(i).getCell(0).getStringCellValue();
            scenarioArray[i - 1][1] = i;
        }
        return scenarioArray;
    }

    public static String getValue(Row row, int index) {
        return row.getCell(index).getStringCellValue();
    }

    public static Integer getIntValue(Row row, int index) {
        return (int) row.getCell(index).getNumericCellValue();
    }

    public static Long getLongValue(Row row, int i) {
        return Math.round(row.getCell(i).getNumericCellValue());
    }

    public static Boolean getBooleanValue(Row row, int i) {
        return row.getCell(i).getBooleanCellValue();
    }
}
