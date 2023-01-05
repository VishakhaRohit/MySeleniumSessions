package AppTest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OrangeHrmTest extends BaseTest{

	@Test(priority=1)
	public void contactLinkTest() {
//		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/?");
		boolean flag = driver.findElement(By.linkText("Contact Sales")).isDisplayed();
		Assert.assertTrue(flag);
	}

	@Test(priority=2)
	public void urlTest() {
		String url = driver.getCurrentUrl();
		Assert.assertTrue(url.contains("trial"));

	}

}
