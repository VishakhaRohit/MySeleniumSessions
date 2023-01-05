package SeleniumSessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CricketWebTable {

	static WebDriver driver;
	
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		driver.get("https://www.espncricinfo.com/series/new-zealand-in-australia-2022-1317459/australia-vs-new-zealand-2nd-odi-1317480/full-scorecard");
		
		String playerName = "Steven Smith";
		System.out.println(getWicketTakerName(playerName));
		
		List<String> scoreList = getScoreList(playerName);
		System.out.println(scoreList);
	}

	
	public static String getWicketTakerName(String playerName)
	{
		String wicketTakerName = driver.findElement(By.xpath("//span[text()='"+ playerName +"']/parent::span/../../following-sibling::td//span//span")).getText();
		return wicketTakerName;
	}
	
	public static List<String> getScoreList(String playerName)
	{
		List<WebElement> score = driver.findElements(By.xpath("//span[text()='"+ playerName +"']/parent::span/../../following-sibling::td"));
		List<String> scoreList = new ArrayList<String>();
		for(int i = 1 ; i<score.size() ; i++)
		{
			String text = score.get(i).getText();
			scoreList.add(text);
		}
		return scoreList;
	}
}
