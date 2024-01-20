package com.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Library {
	
	public static WebDriver driver;
	public static Properties objProperties;
	
	public static void ReadPropertiesFile() throws IOException {
		
		try
		{
			File fs = new File("D:\\JavaWorkSpace\\Selenium_Projects\\src\\test\\resources\\Config.properties");
			FileInputStream objInputStream;
			objInputStream = new FileInputStream(fs);
			objProperties = new Properties();
			objProperties.load(objInputStream);
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void LaunchBrowser() {
		System.out.println("LauchBrowser");
		String browserFromPropertiesFile = objProperties.getProperty("browser");
		System.out.println(browserFromPropertiesFile);
		
		switch (browserFromPropertiesFile) {
		case "firefox":
			System.setProperty("webdriver.gecko.driver","D:\\JavaWorkSpace\\Selenium_Projects\\src\\test\\resources\\firefoxdriver-v33\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		case "IE":
			System.setProperty("webdriver.ie.driver","D:\\JavaWorkSpace\\Selenium_Projects\\src\\test\\resources\\IEDriver-4.14.0\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			break;
			
		case "chrome":	
		    System.out.println("Inside case chrome");
			System.setProperty("webdriver.chrome.driver","D:\\JavaWorkSpace\\Selenium_Projects\\src\\test\\resources\\chromedriver-v120\\chromedriver.exe");	    
//			ChromeOptions objChromeOptions = new ChromeOptions();
//			Map<String, Object> chromePreferences = new HashMap<String, Object>();
//			chromePreferences.put("download.default_directory", System.getProperty("user.dir"));
//			objChromeOptions.setExperimentalOption("prefs", chromePreferences);
//			driver = new ChromeDriver(objChromeOptions);
			driver = new ChromeDriver();
			
			break;
		}

//		driver.manage().window().maximize();
//		// Implicit Wait : Global waiting mechanism applicable for all webElements in a
//		// web page //All Pages
//		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
}
