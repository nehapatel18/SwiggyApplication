package excelUtils;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ExcelUtils1 {

    public static XSSFWorkbook openWorkbook(String excelFilePath) throws Throwable {
        File excelFile = new File(excelFilePath);
        FileInputStream excelFileStream = new FileInputStream(excelFile);
        return new XSSFWorkbook(excelFileStream);
    }

    public static XSSFSheet getSheet(String excelFilePath, int sheetIndex) throws Throwable {
        XSSFWorkbook workbook = openWorkbook(excelFilePath);
        return workbook.getSheetAt(sheetIndex);
    }

    private static void printExcelCellValue(XSSFCell cell) {
        switch (cell.getCellType()) {
            case STRING:
                System.out.print(cell.getStringCellValue());
                break;
            case NUMERIC:
                System.out.print(cell.getNumericCellValue());
                break;
            default:
                System.out.println(cell.getStringCellValue());
        }
    }

    public static void printExcelSheet(XSSFSheet sheet) throws Throwable{

        int lastRowIndex= sheet.getLastRowNum();
        for (int cuurRowIndex=0;cuurRowIndex<=lastRowIndex;cuurRowIndex++){
            XSSFRow row =sheet.getRow(cuurRowIndex);
            int lastCellNum= row.getLastCellNum();

            for( int currCellIndex=0;currCellIndex<lastCellNum;currCellIndex++){
                XSSFCell cell =row.getCell(currCellIndex);
                printExcelCellValue(cell);
                System.out.print("\t");
            }

            System.out.println("");

        }
    }

    public static void main(String[] args) throws Throwable {

        String excelInputFilePath = "F:/selenium/testdata1.xlsx";
        String excelResultFilePath = "F:/selenium/testdata1_results.xlsx";

        XSSFWorkbook workbook =openWorkbook(excelInputFilePath);
        XSSFSheet sheet = workbook.getSheetAt(0);
        System.out.println(getIndex(sheet,"TestResult"));

        printExcelSheet(sheet);

        int startRowIndex = 1;
        int lastRowIndex = sheet.getLastRowNum();  //2,5

        for (int rowIndex = startRowIndex; rowIndex <= lastRowIndex; rowIndex++) {
            XSSFRow currRow = sheet.getRow(rowIndex);
            XSSFCell cell=currRow.getCell(3);
            cell.setCellValue("PASS");
        }
        System.out.println("AFTER UPDATE-----------------");
        printExcelSheet(sheet);

//        saveWorkbookInFileSystem(workbook,excelResultFilePath);
        saveWorkbookInFileSystem(workbook,excelInputFilePath);
    }

    public static synchronized void saveWorkbookInFileSystem(XSSFWorkbook workbook,String outputFile) throws Throwable{
        FileOutputStream fos = new FileOutputStream(outputFile);
        workbook.write(fos);
        workbook.close();
    }

    public static int getIndex(XSSFSheet sheet,String colName ) {


        XSSFRow row = sheet.getRow(0);
        int lastCellNum = row.getLastCellNum();

        //looping into all cell values
        for (int currCellIndex = 0; currCellIndex < lastCellNum; currCellIndex++) {
            XSSFCell cell = row.getCell(currCellIndex);
            if (cell.getStringCellValue().equalsIgnoreCase(colName)) {
                return currCellIndex;
            }
        }

        return -1;
    }






}




