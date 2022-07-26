package com.testscenarios;

import org.testng.annotations.Test;

import com.objectrepository.Locators;
import com.utilities.CommonFunctions;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;

import static com.objectrepository.Locators.JRI_EMAIL_EDITBOX;
import static com.objectrepository.Locators.JRI_MOB_EDITBOX;
import static com.objectrepository.Locators.JRI_NAME_EDITBOX;
import static com.objectrepository.Locators.JRI_PASSWRD_EDITBOX;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;

public class TC_001AccountCreation extends CommonFunctions {
	String browserName;
	Locators ls = new Locators();

	@BeforeClass

	public void browserLaunch(@Optional("chrome") String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			chromebrowser();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			chromebrowser();
		} else if (browserName.equalsIgnoreCase("edge")) {
			chromebrowser();
		}

	}

	@Test
	public void TC_001AccounTCreation() throws IOException, Exception {

		Properties prop = new Properties();
		FileInputStream fi = new FileInputStream("./src/test/resources/TestData/QA_environment_testdata.properties");
		prop.load(fi);

		driver.get(prop.getProperty("BASE_URL"));
		Thread.sleep(2000);
		driver.findElement(By.id("signup-link9")).click();
		Thread.sleep(2000);
		sendkeysbyanylocator(JRI_NAME_EDITBOX, prop.getProperty("NAME"));
		Thread.sleep(2000);
		sendkeysbyanylocator(JRI_MOB_EDITBOX, prop.getProperty("MOBNUMBER"));
		Thread.sleep(2000);
		sendkeysbyanylocator(JRI_EMAIL_EDITBOX, prop.getProperty("EMAIL"));
		Thread.sleep(2000);
		sendkeysbyanylocator(JRI_PASSWRD_EDITBOX, prop.getProperty("PASSWRD"));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name=\"checkbox\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name=\"imgbtnSubmit\"]")).click();

	}

	@AfterMethod
	public void afterMethod() throws IOException {
		takescreenshotfortestcase();
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
