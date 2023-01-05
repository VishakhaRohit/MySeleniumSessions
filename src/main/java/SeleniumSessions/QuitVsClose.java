package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class QuitVsClose {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\rohit\\Downloads\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.google.com");
		String title = driver.getTitle();
		System.out.println(title);

		if (title.equals("Google")) {
			System.out.println("Pass-Correct title");
		} else {
			System.out.println("Fail-Incorrect Title");
		}

		System.out.println(driver.getCurrentUrl());

//		driver.close();
//		System.out.println(driver.getTitle());//NoSuchSessionException: invalid session id
		
		driver.quit();
		System.out.println(driver.getTitle());//NoSuchSessionException: Session ID is null

		
		driver = new ChromeDriver();

		driver.get("https://www.google.com");
		System.out.println(driver.getTitle());
	}

}
