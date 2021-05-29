package com.blazedemo.util;

import org.apache.poi.ss.usermodel.*;

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

    public static String getStringValue(Row row, int index) {
        Cell cell = row.getCell(index);
        if (cell != null) {
            if (CellType.STRING.equals(cell.getCellType())) {
                return cell.getStringCellValue();
            }
        }
        return null;
    }

    public static Long getLongValue(Row row, int index) {
        Cell cell = row.getCell(index);
        if (cell != null) {
            if (CellType.NUMERIC.equals(cell.getCellType())) {
                return Math.round(cell.getNumericCellValue());
            }
        }
        return null;
    }

    public static Boolean getBooleanValue(Row row, int index) {
        Cell cell = row.getCell(index);
        if (cell != null) {
            if (CellType.BOOLEAN.equals(cell.getCellType())) {
                return cell.getBooleanCellValue();
            }
        }
        return null;
    }
}
