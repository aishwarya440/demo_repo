package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	public static void main(String[] args) throws Exception {

		File file = new File("C:\\Users\\Aishwarya\\eclipse-workspace\\TestNG_Maven_basics\\TestData\\workbook1.xlsx");

		FileInputStream inputFile = new FileInputStream(file);

		XSSFWorkbook wb = new XSSFWorkbook(inputFile);

		XSSFSheet sheet = wb.getSheet("Sheet1");

		int row_count = sheet.getPhysicalNumberOfRows();

		System.out.println("Row Count " + row_count);

		String cell_1_0 = sheet.getRow(1).getCell(0).getStringCellValue();
		
		System.out.println("value of cell_1_0 " + cell_1_0);
		
		System.out.println(sheet.getFirstRowNum());
		System.out.println(sheet.getLastRowNum());
		
		System.out.println(sheet.isDisplayRowColHeadings());

		wb.close();
		
		System.out.println("Values fetched from excelsheet!");
		
	}
}
