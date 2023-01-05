package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PaginationConcept {

	static WebDriver driver;
	
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://babynames.merschat.com/popular.cgi");
		
		List<WebElement> namesList = driver.findElements(By.xpath("//a[contains(text(),'Nima')]"));
		
		while(true)
		{
			if(!(namesList.size() == 1))
			{
				driver.findElement(By.linkText("Next")).click();
				namesList = driver.findElements(By.xpath("//a[contains(text(),'Nima')]"));
			}
			else
			{
				String title = driver.findElement(By.xpath("(//a[contains(text(),'Nima')]/../../following-sibling::td)[3]//a")).getAttribute("title");
				System.out.println(title);
				break;
			}
		}
	}

}
