package com.frameworkfromscratch.com.fullStack;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Login {

	public static WebDriver driver;
	public Properties prop;

	public WebDriver broswerDetails() throws IOException {
		 prop = new Properties();
		 String systemPath = System.getProperty("user.dir");
		FileInputStream file = new FileInputStream(systemPath +"\\src\\main\\java\\com\\frameworkfromscratch\\com\\fullStack\\Application.properties");
		prop.load(file);
		String browserName = prop.getProperty("browser");
		if (browserName.contains("chrome")) {
			System.setProperty("webdriver.chrome.driver", systemPath +"\\src\\main\\resources\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			if(browserName.contains("headless")) 
			{
              options.addArguments("headless"); 
            }
			driver = new ChromeDriver(options);
		} else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", " systemPath +\"\\src\\main\\resources\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	public void getScreenShot(String result) throws IOException
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,new File("D:\\TestResults\\"+result+"screenshots.png"));
	}

}
