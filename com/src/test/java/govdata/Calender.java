package govdata;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Calender {
	
	/*
	 * @DataProvider(name = "excelData") //public Object[][] readExcelData() throws
	 * IOException { String excelFilePath = "E:\\Data project\\bank.xlsx";
	 * FileInputStream inputStream = new FileInputStream(excelFilePath); // Workbook
	 * workbook = new XSSFWorkbook(inputStream); // For .xlsx files XSSFWorkbook
	 * workbook = new XSSFWorkbook(inputStream); Sheet sheet =
	 * workbook.getSheet("Sheet1"); // Replace "Sheet1" with the actual sheet name
	 * int rowCount = sheet.getLastRowNum(); int colCount =
	 * sheet.getRow(0).getLastCellNum(); Object[][] data = new
	 * Object[rowCount][colCount];
	 * 
	 * for (int i = 1; i <= rowCount; i++) { Row row = sheet.getRow(i); for (int j =
	 * 0; j < colCount; j++) { Cell cell = row.getCell(j); data[i - 1][j] =
	 * cell.toString(); } } workbook.close(); inputStream.close(); return data; }
	 */
	
	/*
	 * @DataProvider(name = "excelData") public Object[][] readExcelData() throws
	 * IOException { String excelFilePath = "E:\\Data project\\bank.xlsx";
	 * FileInputStream inputStream = new FileInputStream(excelFilePath); // Workbook
	 * workbook = new XSSFWorkbook(inputStream); // For .xlsx files XSSFWorkbook
	 * workbook = new XSSFWorkbook(inputStream); Sheet sheet =
	 * workbook.getSheet("Sheet1"); // Replace "Sheet1" with the actual sheet name
	 * int rowCount = sheet.getLastRowNum(); int colCount =
	 * sheet.getRow(0).getLastCellNum(); Object[][] data = new
	 * Object[rowCount][colCount];
	 * 
	 * for (int i = 1; i <= rowCount; i++) { Row row = sheet.getRow(i); for (int j =
	 * 0; j < colCount; j++) { Cell cell = row.getCell(j); data[i - 1][j] =
	 * cell.toString(); } } workbook.close(); inputStream.close(); return data; }
	 */
	@Test(dataProvider = "excelData")
	public void selectCalenders(String date) throws Exception {
		Map<String, String> hm = new HashMap<String, String>();
		hm.put("Jan", "0");
		hm.put("Feb", "1");
		hm.put("Mar", "2");
		hm.put("Apr", "3");
		hm.put("May", "4");
		hm.put("Jun", "5");
		hm.put("Jul", "6");
		hm.put("Aug", "7");
		hm.put("Sep", "8");
		hm.put("Oct", "9");
		hm.put("Nov", "10");
		hm.put("Dec", "11");
		String[] dateArray = date.split("-");
		// Year
		String year=dateArray[2];
		System.out.println(year);
		// Month
		String month=dateArray[1];
		System.out.println(month);
		// day
		
		int day=Integer.parseInt(dateArray[0]);  
		System.out.println(day);
		}
	@DataProvider(name = "excelData")
	public Object[][] readExcelData() throws IOException {
		//String excelFilePath = "E:\\Data project\\bank.xlsx";
		String excelFilePath ="E:\\Data project\\demo.xlsx";
		FileInputStream inputStream = new FileInputStream(excelFilePath);
		// Workbook workbook = new XSSFWorkbook(inputStream); // For .xlsx files
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		Sheet sheet = workbook.getSheet("Sheet1"); // Replace "Sheet1" with the actual sheet name
		int rowCount = sheet.getLastRowNum();
		int colCount = sheet.getRow(0).getLastCellNum();
		Object[][] data = new Object[rowCount][colCount];

		for (int i = 1; i <= rowCount; i++) {
			Row row = sheet.getRow(i);
			for (int j = 0; j < colCount; j++) {
				Cell cell = row.getCell(j);
				data[i - 1][j] = cell.toString();
			}
		}
		workbook.close();
		inputStream.close();
		return data;
	}
	
	
	
		/*
		 * @Test(dataProvider = "excelData") public void calenderTest(String dataA,
		 * String dataB, String dataC, String dataD, String dataE, String dataF, String
		 * dataG, String dataH, String dataI, String dataJ, String dataK, String dataL,
		 * String dataM, String dataN, String dataO, String dataP) throws Exception { }
		 */}
