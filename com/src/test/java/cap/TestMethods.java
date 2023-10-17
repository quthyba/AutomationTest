package cap;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

public class TestMethods extends TestLocators {
	public WebDriver driver;
	ChromeOptions options;
	ChromeOptions handlingSSL;

	public void driverCreation(String setting) {
		if(setting=="options") {
			driver = new ChromeDriver(options);
		}
		else if(setting=="handlingSSL") {
			driver = new ChromeDriver(handlingSSL);
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public void goToWebPage(String URL) {
		driver.get(URL);
	}

	public void dropDown(String value) {
		Select select = new Select(driver.findElement(By.xpath(prodcutDropdown)));
		select.selectByVisibleText(value);
	}

	// Go back to Home Page
	public void navigatebackward() {
		driver.navigate().back();
	}

	public void navigateForward() {

		driver.navigate().forward();
	}

	public void refreshPage() {
		// Refresh browser
		driver.navigate().refresh();
	}

	public void navigateTo() {
		driver.navigate().to("https:www.google.com");
	}

	public void closeBrowser() {
		driver.close();
	}

	public void incognitoMode() {
		options = new ChromeOptions();
		options.addArguments("--incognito");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		options.merge(capabilities);
	}

	public void handlingSSLCer() {
		handlingSSL = new ChromeOptions();

		// Using the accept insecure cert method with true as parameter to accept the
		// untrusted certificate
		handlingSSL.setAcceptInsecureCerts(true);
	}
	public void button1() {
		driver.findElement(By.id(button1)).click();
	}
	public void button1Text() {
		driver.findElement(By.id(textBt1)).sendKeys("Hello");
	}

}
