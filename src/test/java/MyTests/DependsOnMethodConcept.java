package MyTests;

import org.testng.annotations.Test;

public class DependsOnMethodConcept {

	@Test
	public void loginTest()
	{
		System.out.println("login to app");
	}
	
	@Test (dependsOnMethods = "loginTest",priority=1)
	public void homePageTest()
	{
		System.out.println("homePageTest");
	}
	
	@Test(dependsOnMethods = "loginTest",priority=2)
	public void searchTest()
	{
		System.out.println("SearchTest");
	}
}
