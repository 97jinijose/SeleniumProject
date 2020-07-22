package com.frameworkfromscratch.com.fullStack;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FirstPage {
	public WebDriver driver;

	public FirstPage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	private By LoginLink = By.xpath("//div[@class='container-fluid']/nav/ul/li[4]/a/span");
	private By popUp = By.xpath("//button[text()='NO THANKS']");
	
	public WebElement getLink()
	{
		return driver.findElement(LoginLink);
	}
	
	public WebElement getPopUp() {
		return driver.findElement(popUp);
	}
	public List<WebElement> getPopUpSize() {
		return driver.findElements(popUp);
	}

	
	

}
