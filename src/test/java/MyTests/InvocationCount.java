package MyTests;

import org.testng.annotations.Test;

public class InvocationCount {

	@Test(invocationCount=10)
	public void getUser()
	{
		System.out.println("Get user");
	}
	
}
