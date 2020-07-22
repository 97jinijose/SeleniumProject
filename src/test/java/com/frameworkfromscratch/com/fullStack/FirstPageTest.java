package com.frameworkfromscratch.com.fullStack;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FirstPageTest extends Login {
	
	public static Logger log = LogManager.getLogger(FirstPageTest.class.getName());
	
	public void initialize() throws IOException
	{
		driver = broswerDetails();
	}

	@Test(dataProvider = "getData")
	public void firstPageTest(String username, String password) throws IOException {
		//driver = broswerDetails();
		driver.get(prop.getProperty("url"));
		log.info("URL Invoke");
		FirstPage first = new FirstPage(driver);
		LoginPage login = new LoginPage(driver);
		first.getLink().click();
		//LoginPage login = new LoginPage(driver);
		login.getEmail().sendKeys(username);
		log.info("username successfully entered");
		login.getPassword().sendKeys(password);
		log.info("password successfully entered");
		login.clickLogInButton().click();
		log.info("clicked on Login");
		

	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[2][2];
		data[0][0] = "jinijose1997@gmail.com";
		data[0][1] = "dummy";

		data[1][0] = "jinijose@gmail.com";
		data[1][1] = "dummy2";

		/*data[2][0] = "jini1997@gmail.com";
		data[2][1] = "dummy3";*/
		
		return data;
	}
	
	@AfterClass
	public void shutdown()
	{
		driver.close();
		driver=null;
	}

}
