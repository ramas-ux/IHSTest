package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.dotnetFiddlePageObjects;

public class dotnetFiddleTest {

	WebDriver driver = null;
	dotnetFiddlePageObjects dotnetFiddlePage;

	@BeforeTest
	public void setUpTest() {
		String projectPath = System.getProperty("user.dir");
		System.out.println(projectPath);
		System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://dotnetfiddle.net/");
	}

	@Test
	public void testHelloWorldText() {
		dotnetFiddlePage = new dotnetFiddlePageObjects(driver);
		dotnetFiddlePage.run.click();
		Assert.assertEquals(dotnetFiddlePage.hwOutputText.getText(), "Hello World");
	}
	
	@Test
	public void testDiffButtonsBasedOnFirstName() {
		dotnetFiddlePage = new dotnetFiddlePageObjects(driver);
		dotnetFiddlePage.checksBasedOnFirstName("Fiddle");
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
