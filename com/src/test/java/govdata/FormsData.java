package govdata;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.apache.poi.xssf.usermodel.*;

public class FormsData {
	static WebDriver driver;

	// = new ChromeDriver();
	@BeforeTest
	public void login() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();
		driver.get("http://164.100.75.110/ysrsvpr/");
		driver.findElement(By.name("userName")).sendKeys("APBL0001020");
		;
		driver.findElement(By.name("password")).sendKeys("Dccbsklm@120");
		;
		driver.findElement(By.xpath("//button[normalize-space()='SIGN IN']")).click();
	}

	public void IndividualForms() {
		driver.findElement(By.xpath("//a[normalize-space()='Claim Upload']")).click();
		try {
			Thread.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//a[normalize-space()='Data Entry »']")).click();
		try {
			Thread.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//a[normalize-space()='Individual']")).click();
	}

	public void selectCalender(String date) throws Exception {
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
		Select year = new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-year']")));
		year.selectByValue(dateArray[2]);
		// Month
		Select Month = new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-month']")));
		hm.get(dateArray[1]);
		Thread.sleep(1);
		Month.selectByValue(hm.get(dateArray[1]));
		// day
		// System.out.println(monthValue);
		List<WebElement> ar = driver.findElements(By.xpath("//td[@data-handler='selectDay']"));
		System.out.println(ar.size());
		for (int i = 0; i < ar.size(); i++) {
			String UIDate=driver.findElements(By.xpath("//td[@data-handler='selectDay']")).get(i).getText();
			
			if (Integer.parseInt(UIDate)==Integer.parseInt(dateArray[0])) {
				System.out.println("inside if block");
				driver.findElements(By.xpath("//td[@data-handler='selectDay']")).get(i).click();
				break;
			}
		}
	}

	
	@DataProvider(name = "excelData")
	public Object[][] readExcelData() throws IOException {
		//String excelFilePath = "E:\\Data project\\bank.xlsx";
		String excelFilePath ="E:\\Data project\\BANK\\total list.xlsx";
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
	
	@Test(dataProvider = "excelData")
	public void testDataFromExcel(String dataA, String dataB, String dataC, String dataD, String dataE, String dataF,
			String dataG, String dataH, String dataI, String dataJ, String dataK, String dataL, String dataM,
			String dataN, String dataO, String dataP) throws Exception {
		IndividualForms();
		// 1.Crop Year
		Select cropYear = new Select(driver.findElement(By.xpath("//select[@id='inputCrpYr']")));
		cropYear.selectByValue("2022-2023");
		Thread.sleep(1);
		// 2.crop season
		Select cropSeason = new Select(driver.findElement(By.xpath("//select[@id='inputCrpCsn']")));
		cropSeason.selectByValue("K");
		Thread.sleep(1);
		// 3.Farmer Name
		driver.findElement(By.xpath("//input[@id='inputFrmrNam']")).sendKeys(dataA);
		// 4.Gender
		Select gender = new Select(driver.findElement(By.xpath("//select[@id='inputGndr']")));
		gender.selectByValue(dataB);
		Thread.sleep(1);
		// 5.caste
		Select caste = new Select(driver.findElement(By.xpath("//select[@id='inputSosalCat']")));
		caste.selectByValue(dataC);
		Thread.sleep(1);
		// 6.Farmer Aadhar
		driver.findElement(By.xpath("//input[@id='inputFrmrAadh']")).sendKeys(dataD);
		// 7. Farmer Mobile
		driver.findElement(By.xpath("//input[@id='inputFrmrMob']")).sendKeys(dataE);
		// 8.Father/Husband Name
		driver.findElement(By.xpath("//input[@id='inputFthrHsb']")).sendKeys(dataF);
		// 9.Farmer Type
		Select farmerType = new Select(driver.findElement(By.xpath("//select[@id='inputFrmrLnd']")));
		farmerType.selectByValue("O");
		Thread.sleep(1);
		// 10.Residential Village
		driver.findElement(By.xpath("//input[@id='inputRsdntlVlg']")).sendKeys(dataG);
		// 11.Farmer Bank Saving Account
		driver.findElement(By.xpath("//input[@id='inputFrmrSvngBnkAcnt']")).sendKeys(dataH);
		// 12.crop
		Select crop = new Select(driver.findElement(By.xpath("//select[@id='inputCrp']")));
		crop.selectByValue("10701");
		Thread.sleep(1);
		// 13.Land Survey Number
		driver.findElement(By.xpath("//input[@id='inputLndSrvNum']")).sendKeys(dataI);
		// 14.Cultivated Land Extent (In Acres)
		driver.findElement(By.xpath("//input[@id='inputCltvtdLndXtnt']")).sendKeys(dataJ);
		 // 15.district 
		Select district = new Select(driver.findElement(By.xpath("//select[@id='distId']")));
		district.selectByValue("1"); 
		// 16.mandal 		
		Select mandal = new Select(driver.findElement(By.xpath("//select[@id='mndlId']")));
		mandal.selectByValue("16"); 
		// 17.village 
		Select village = new Select(driver.findElement(By.xpath("//select[@id='vlgId']")));
		village.selectByValue(dataK);//dataK 
		// 18.Loan account number
		  driver.findElement(By.xpath("//input[@id='inputLonAcntNum']")).sendKeys(dataL);
		// 19.Loan Amount Disbursed (In Rupees)
		driver.findElement(By.xpath("//input[@id='inputLonAmnt']")).sendKeys(dataM);
		// 20.Interest Amount
		driver.findElement(By.xpath("//input[@id='inputIntrst']")).sendKeys(dataN);
		// 21.Disbursement Date
		driver.findElement(By.xpath("//input[@id='dis_date_picker']")).click();
		Thread.sleep(1);
		selectCalender(dataO);
		/*
		 * // Alert Ok Alert alert = driver.switchTo().alert(); alert.accept();
		 * driver.switchTo().defaultContent();
		 */
		// 22.Final Re-payment Date
		driver.findElement(By.xpath("//input[@id='fnlRpay_date_picker']")).click();
		Thread.sleep(1);
		selectCalender(dataP);	
		driver.findElement(By.xpath("//input[@id='nwBnfcrSubmitId']")).click();
		//driver.findElement(By.xpath("//input[@id='nwBnfcrSubmitId']"));
		Thread.sleep(5);
	}
}
