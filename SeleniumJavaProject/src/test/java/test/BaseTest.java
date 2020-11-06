package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import utility.ConfigReader;

public class BaseTest {
	WebDriver driver;
	
	@BeforeTest
	public void setUpTest() {
		ConfigReader cfg = new ConfigReader();
		System.setProperty("webdriver.chrome.driver", cfg.getChromePath());
		driver = new ChromeDriver();
		driver.get(cfg.getUrl());
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
