package utility;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel2 {

	public static String projectPah = System.getProperty("user.dir");
	static XSSFWorkbook wb;
	static XSSFSheet sheet;

	public static void main(String[] args) {

		rowCount();
		collCount(0);
		getCelldata(4, 0);
		getCelldata(5,3);
	}

	public static void rowCount() {
		try {

			wb = new XSSFWorkbook(projectPah + "\\TestData\\workbook1.xlsx");

			sheet = wb.getSheet("Sheet1");

			int row_count = sheet.getPhysicalNumberOfRows();

			System.out.println("Row Count " + row_count);

			wb.close();
		} catch (IOException e) {

			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}

		System.out.println("Values fetched from excelsheet!");

	}

	public static void collCount(int rowNum) {
		try {

			wb = new XSSFWorkbook(projectPah + "\\TestData\\workbook1.xlsx");

			sheet = wb.getSheet("Sheet1");

			XSSFRow row = sheet.getRow(rowNum);

			int col_count = row.getLastCellNum();

			System.out.println("Column Count " + col_count);

			wb.close();
		} catch (IOException e) {

			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
	}

	public static void getCelldata(int rowNum, int colNum) {
		try {

			wb = new XSSFWorkbook(projectPah +"\\TestData\\workbook1.xlsx");

			sheet = wb.getSheet("Sheet1");

			String cell_3_0 = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();

			System.out.println("Cell value " + cell_3_0);

			wb.close();
		} catch (IOException e) {

			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
	}
}
