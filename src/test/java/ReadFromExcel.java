import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadFromExcel {

    public static void main(String args[]) throws IOException{

        //Create an object of File class to open xlsx file
        File file =    new File("D:\\TestData.xlsx");

        //Create an object of FileInputStream class to read excel file
        FileInputStream inputStream = new FileInputStream(file);

        //Creating workbook instance that refers to .xls file
        XSSFWorkbook wb=new XSSFWorkbook(inputStream);

        //Creating a Sheet object using the sheet Name
        XSSFSheet sheet=wb.getSheetAt(0);

        //Create a row object to retrieve row at index 1
        XSSFRow row2=sheet.getRow(0);

        //Create a cell object to retrieve cell at index 5
        XSSFCell cell=row2.getCell(0);

        //Get the address in a variable
        String address= cell.getStringCellValue();

        //Printing the address
        System.out.println("Address is :"+ address);
    }
}
