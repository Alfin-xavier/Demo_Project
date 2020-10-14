package com.atmecs.demo_project.basetest;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import com.atmecs.demo_project.constants.Constants;
import com.atmecs.demo_project.utilities.PropertyReader;
import com.atmecs.demo_project.utilities.TestNGListeners;

public class BaseTest 
{
	public WebDriver driver;
	Properties properties;
	String baseUrl;
	String browserUrl;

	@BeforeMethod
	@Parameters("browser")
	
	public void beforeTest(String browser) throws InterruptedException, IOException 
	{
		properties = PropertyReader.readProperties(Constants.CONFIG);
		baseUrl = properties.getProperty("url");
		browserUrl = properties.getProperty("browser");

		System.setProperty(Constants.CHROME_DIR, Constants.CHROME_PATH);
		driver = new ChromeDriver();
		driver.get(baseUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(150, TimeUnit.SECONDS);

		TestNGListeners.driver = driver;
	 // Logging.driver = driver;
	  }
	 

	@AfterMethod
	public void afterTest()
	{
		driver.close();

	}
}