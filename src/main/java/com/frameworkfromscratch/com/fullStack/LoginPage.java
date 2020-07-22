package com.frameworkfromscratch.com.fullStack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	private By emailAddress = By.cssSelector("input[id='user_email']");
	private By password = By.id("user_password");
	private By LogInButton = By.xpath("//input[@value='Log In']");
	//private By popUp = By.xpath("//button[text()='NO THANKS']");

	public WebElement getEmail() {
		return driver.findElement(emailAddress);
	}

	public WebElement getPassword() {
		return driver.findElement(password);
	}

	public WebElement clickLogInButton() {
		return driver.findElement(LogInButton);
	}

	/*public WebElement getPopUp() {
		return driver.findElement(popUp);
	}
	public WebElement getPopUpSize() {
		return driver.findElement(popUp);
	}*/

}
