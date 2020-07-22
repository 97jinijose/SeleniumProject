package com.frameworkfromscratch.com.fullStack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Text {
	
	public WebDriver driver;

	public Text(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	private By Text = By.cssSelector("div[class='text-center']");
	
	public WebElement getText()
	{
		return driver.findElement(Text);
	}

}
