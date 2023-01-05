package SeleniumSessions;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitForJsAlert {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");

		driver.findElement(By.xpath("//input[@type='submit']")).click();

		doAlertAccept(10);
		
	}

	public static Alert waitForAlert(int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.alertIsPresent());
	}
	
	public static void doAlertAccept(int timeOut)
	{
		waitForAlert(timeOut).accept();
	}
	public static void doAlertDismiss(int timeOut)
	{
		waitForAlert(timeOut).dismiss();
	}
	public static String doAlertGetText(int timeOut)
	{
		return waitForAlert(timeOut).getText();
	}
	public static void alertSendKey(String value,int timeOut)
	{
		waitForAlert(timeOut).sendKeys(value);;
	}
}
