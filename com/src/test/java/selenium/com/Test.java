package selenium.com;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hello world");

//https://nxtgenaiacademy.com/demo-site/
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/flight/search?itinerary=DEL-BLR-21/08/2023&tripType=O&paxType=A-1_C-0_I-0&intl=false&cabinClass=E&ccde=IN&lang=eng");
		
		driver.findElement(By.cssSelector(".bgProperties.icon20.overlayCrossIcon")).click();
	}
}
