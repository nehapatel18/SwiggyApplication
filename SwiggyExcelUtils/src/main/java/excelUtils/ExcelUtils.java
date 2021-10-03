package excelUtils;


import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

public class ExcelUtils {
    public static  XSSFWorkbook  openWorkbook(String excelFilePath) throws  Throwable{
        File excelfile = new File(excelFilePath);
        FileInputStream excelFileStream = new FileInputStream(excelfile);
        return new XSSFWorkbook(excelFileStream);

    }




    public static void main (String[] args) throws  Throwable {
    String excelFilePath = "F:/selenium/testdata1.xlsx";

        XSSFWorkbook workbook = openWorkbook(excelFilePath);
     int numberOfSheets = workbook.getNumberOfSheets();
        System.out.println("Total sheets"+numberOfSheets);

        XSSFSheet sheet = workbook.getSheetAt(0);

        int lastRowNum = sheet.getLastRowNum();
        System.out.println("Total rows in sheet 2="+lastRowNum);



        XSSFRow row = sheet.getRow(lastRowNum);
        int lastCellNum= row.getLastCellNum();
        System.out.println("last cell num="+lastCellNum);


        XSSFCell cell =row.getCell(1);
        String value =cell.getStringCellValue();
        System.out.println("cell value at index 1="+value);


    }





    }

