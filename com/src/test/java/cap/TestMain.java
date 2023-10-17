package cap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestMethods testMethods = new TestMethods();
		// browser setting to launch browser in incognito mode
		testMethods.incognitoMode();
		testMethods.driverCreation("options");
		testMethods.goToWebPage("https://chercher.tech/practice/practice-dropdowns-selenium-webdriver");
		// Dropdown
		testMethods.dropDown("Google");
		testMethods.navigateTo();
		// Page Navigation Operations
		testMethods.navigatebackward();
		testMethods.navigateForward();
		testMethods.refreshPage();
		// testMethods.closeBrowser();
		// browser setting to handle SSL certifcates
		testMethods.handlingSSLCer();
		testMethods.driverCreation("handlingSSL");
		testMethods.goToWebPage("https://expired.badssl.com");
		// testMethods.closeBrowser();

		// Implicit wait
		testMethods.driverCreation("handlingSSL");
		testMethods.goToWebPage("https://www.hyrtutorials.com/p/waits-demo.html");
		testMethods.button1();
		testMethods.button1Text();
	}

}
