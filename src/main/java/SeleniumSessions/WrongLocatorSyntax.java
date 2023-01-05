package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WrongLocatorSyntax {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/?");
		
		//*[@id=\"Form_getForm_Name\"] -- right
		//*[id=\"Form_getForm_Name\"] -- wrong
		
		By firstName = By.xpath("//*[id=\"Form_getForm_Name\"]");
		By lastName = By.cssSelector("#Form_getForm_Contact");
		driver.findElement(firstName).sendKeys("Test");
	}

}
