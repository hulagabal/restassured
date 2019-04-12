package test;

import org.testng.annotations.Test;

public class Test1 {
	
	@Test(dataProvider = "users",dataProviderClass=Utility2.class)
	public void displayeusers(String username, String password) {
		System.out.println(username + " " + password);
	}
}
