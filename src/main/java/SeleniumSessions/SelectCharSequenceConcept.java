package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectCharSequenceConcept {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/login&language=en-gb");
		
		WebElement ele = driver.findElement(By.id("input-email"));
		
		StringBuilder username = new StringBuilder()
				.append("vishu")
				.append(" ")
				.append("bhayani")
				.append(" ");
		
		String space = " ";
		
		StringBuilder userInfo = new StringBuilder()
				.append("naveen")
				.append(" ")
				.append("automation")
				.append(" ");
		
		String author = "Naveen Khuntela";
		
		ele.sendKeys(username,space,userInfo,space,author);
		
	}

}
