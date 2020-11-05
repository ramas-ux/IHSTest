package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.DotnetFiddlePage;
import pages.GettingStartedPage;

public class DotnetFiddleTest {

	WebDriver driver = null;
	DotnetFiddlePage dotnetFiddlePage;
	GettingStartedPage gettingStartedPage;

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
		dotnetFiddlePage = new DotnetFiddlePage(driver);
		dotnetFiddlePage.run.click();
		Assert.assertEquals(dotnetFiddlePage.hwOutputText.getText(), "Hello World");
	}
	
	@Test
	public void testDiffButtonsBasedOnFirstName() {
		gettingStartedPage = new GettingStartedPage(driver);
		dotnetFiddlePage.checksBasedOnFirstName("Fiddle", gettingStartedPage);
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
