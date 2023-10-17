package govdata;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class SunnaVaddi {

	public static void main(String[] args) throws InterruptedException {
		
		// TODO Auto-generated method stub
	
		WebDriver driver  = new ChromeDriver();
		
		
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("http://164.100.75.110/ysrsvpr/");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@name=\"userName\"]")).sendKeys("APBL0001020");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("Dccbsklm@120");
		driver.findElement(By.xpath("//button[@class='btn btn-lg btn-primary btn-block']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@class='nav-link dropdown-toggle'])[2]")));
		driver.findElement(By.xpath("(//a[@class='nav-link dropdown-toggle'])[2]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='Clients Data']")));
		driver.findElement(By.xpath("//a[normalize-space()='Clients Data']")).click();
		driver.switchTo().alert().accept();
		
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody/tr/td[7]")));
		List <WebElement>list	= driver.findElements(By.xpath("//tbody/tr/td[7]"));
		System.out.println(list.size());
		for(WebElement webElement: list) {
			String totalNames = webElement.getText();
			System.out.println(totalNames);
		}
		
		

	}

}

