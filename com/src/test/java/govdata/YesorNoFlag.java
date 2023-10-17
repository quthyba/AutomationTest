package govdata;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class YesorNoFlag {
	
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
	 @DataProvider(name = "excelData")
	    public Object[][] provideTestData() throws Exception {
		 String excelFilePath = "E:\\Data project\\bank.xlsx";
			FileInputStream inputStream = new FileInputStream(excelFilePath);
			// Workbook workbook = new XSSFWorkbook(inputStream); // For .xlsx files
			XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
	        Sheet sheet = workbook.getSheet("Sheet1"); // Change to the actual sheet name
	        int rowCount = sheet.getPhysicalNumberOfRows();
	        int columnCount = 17; // Assuming 17 columns
	        Object[][] data = new Object[rowCount - 1][columnCount]; // Assuming the first row contains headers

	        for (int i = 1; i < rowCount; i++) {
	            Row row = sheet.getRow(i);
	            Cell flagCell = row.getCell(16); // Assuming the flag is in the 17th column (0-indexed)

	            if (flagCell != null) {
	                String flagValue = flagCell.getStringCellValue(); // Assuming it's a string

	                if ("yes".equalsIgnoreCase(flagValue)) {
	                    // Populate the data array with row values, handling numeric cells
	                    for (int j = 0; j < columnCount; j++) {
	                        Cell cell = row.getCell(j);
	                        String cellValue = "";

	                        if (cell != null) {
	                            if (cell.getCellTypeEnum() == CellType.STRING) {
	                                cellValue = cell.getStringCellValue();
	                            } else if (cell.getCellTypeEnum() == CellType.NUMERIC) {
	                                cellValue = String.valueOf(cell.getNumericCellValue());
	                            }
	                        }
	                        data[i - 1][j] = cellValue;
	                    }
	                }
	            }
	        }

	        return data;
	    }
	 
	 
	 @Test(dataProvider = "excelData")
	    public void testWithFlagYes(String[] rowData) {
	        // Process the data for rows where the flag is "yes"
	        if ("yes".equalsIgnoreCase(rowData[16])) { // Assuming the flag is in the 16th column (0-indexed)
	            // Example: Access data from the rowData array
	            String column1Value = rowData[0]; // Access data from the first column
	            String column2Value = rowData[1]; // Access data from the second column
	            // ... and so on
	            System.out.println("Processing data for 'yes': " + column1Value + ", " + column2Value);
	        }
	    }
	 
	 
		/*
		 * @Test(dataProvider = "excelData") public void calenderTest(String dataA,
		 * String dataB, String dataC, String dataD, String dataE, String dataF, String
		 * dataG, String dataH, String dataI, String dataJ, String dataK, String dataL,
		 * String dataM, String dataN, String dataO, String dataP,String dataQ) throws
		 * Exception { }
		 */
}
