package test;

import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

	@Test(dataProvider="users", dataProviderClass=Utility2.class)
	public void loginTest(String user,String pass){
		System.out.println(user+" "+pass);
			
	}
}
