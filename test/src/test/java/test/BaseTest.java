package test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
	@BeforeTest
	public void launchBrowser(){
		System.out.println("Browser launched");
	}
	
	@AfterTest
	public void browserClosed(){
		System.out.println("browser closed");
	}

}
