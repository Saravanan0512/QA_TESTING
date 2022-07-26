package com.utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CommonFunctions {

	public static WebDriver driver;

	public void chromebrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	public void edgebrowser() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().window().maximize();
	}

	public void firefoxbrowser() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}

	public void sendkeysbyanylocator(By locator , String testdata) {
		WebElement element = driver.findElement(locator);
		if (element.isDisplayed()) {
			if (element.isEnabled()) {
				element.clear();
				element.sendKeys(testdata);
			}
		}
		}
	
	public String timestamp() {
		
		Date d = new Date();
		DateFormat df = new SimpleDateFormat("ddMMMyyyy_HHmmss");
		String timeStamp = df.format(d);
		return timeStamp;
		}
	
	   public void takescreenshotfortestcase() throws IOException {
		   
		   File abc =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		   FileHandler.copy(abc, new File("C:\\Users\\Admin\\Desktop\\Eclipse WorkSpace\\Justrechargeit_Automation\\Screenshots\\Login" + timestamp() + ".PNG"));
	   }
	   
	
	
	
	
}

