package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class staticWebTableHandle {

	static WebDriver driver;
	
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		
//		String xpath = "//table[@id='customers']//tr[2]//td[1]";
		
		String beforeXpath = "//table[@id='customers']//tr[";
		String afterXpath = "]//td[";
	
		int rowCount = driver.findElements(By.xpath("//table[@id='customers']//tr")).size();
		int columnCount = driver.findElements(By.xpath("//table[@id='customers']//tr//th")).size();
		
//		getCompanyName();
		printTable(rowCount, columnCount, beforeXpath, afterXpath);
		
	}

	public static void getCompanyName()
	{
		for(int i = 2; i<=7 ; i++)
		{
			String text = "//table[@id='customers']//tr[" + i + "]//td[1]";
			String comName = driver.findElement(By.xpath(text)).getText();
			System.out.println(comName);
		}
	}
	
	public static void printTable(int rowCount,int columnCount,String beforeXpath,String afterXpath)
	{
		for(int i = 2 ; i<=rowCount ; i++)
		{
			for(int j = 1;j<=columnCount ; j++)
			{
				String xpath = beforeXpath + i + afterXpath + j + "]";
				String text = driver.findElement(By.xpath(xpath)).getText();
				System.out.print(text + " - ");
			}
			System.out.println();
		}
	}
}
