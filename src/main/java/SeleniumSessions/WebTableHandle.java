package SeleniumSessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableHandle {

static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		driver.get("https://classic.freecrm.com/index.html");
		driver.findElement(By.name("username")).sendKeys("newautomation");
		driver.findElement(By.name("password")).sendKeys("Selenium@12345");
		driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/div/input")).click();
		
		Thread.sleep(5000);
		
		driver.switchTo().frame("mainpanel");
		
		driver.findElement(By.linkText("CONTACTS")).click();
		
//		selectCheckbox("Romi singh");
//		getCompanyName("Romi singh");
		List<String> contactList = getNumberList("Romi singh");
		System.out.println(contactList);
		
	}

	public static void selectCheckbox(String contactName)
	{
		String xpath = "//a[text()='"+ contactName +"']/parent::td/preceding-sibling::td/input[@type='checkbox']";
		driver.findElement(By.xpath(xpath)).click();
	}
	public static void getCompanyName(String contactName)
	{
		String xpath = "//a[text()='"+ contactName +"']/parent::td/following-sibling::td/a[@context='company']";
		String companyName = driver.findElement(By.xpath(xpath)).getText();
		System.out.println(companyName);
	}
	
	public static List<String> getNumberList(String contactName)
	{
		String xpath = "//a[text()='" + contactName+ "']/parent::td/following-sibling::td/span[@context='phone']";
		List<WebElement> phoneList = driver.findElements(By.xpath(xpath));
		List<String> contactList = new ArrayList<String>();
		for(WebElement e : phoneList)
		{
			String text = e.getText();
			contactList.add(text);
		}
		return contactList;
	}
}
