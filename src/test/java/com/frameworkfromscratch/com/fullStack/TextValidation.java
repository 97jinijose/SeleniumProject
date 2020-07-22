package com.frameworkfromscratch.com.fullStack;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class TextValidation extends Login {
	public static Logger log = LogManager.getLogger(TextValidation.class.getName());

	@Test
	public void textValidation() throws IOException {
		driver = broswerDetails();
		driver.get(prop.getProperty("url"));
		Text text = new Text(driver);

		Assert.assertEquals(text.getText().getText(), "FEATURED123 COURSES");
		log.info("Text matched");

	}
	@AfterClass
	public void shutdown()
	{
		driver.close();
		driver = null;
	}

}
