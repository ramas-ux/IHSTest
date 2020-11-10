package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DotnetFiddlePage;
import pages.GettingStartedPage;

public class DotnetFiddleTest extends BaseTest {

	DotnetFiddlePage dotnetFiddlePage;
	GettingStartedPage gettingStartedPage;

	@Test(priority = 0)
	public void testHelloWorldText() {
		dotnetFiddlePage = new DotnetFiddlePage(driver);
		dotnetFiddlePage.clickOnRunBtn();
		Assert.assertEquals(dotnetFiddlePage.hwOutputText.getText(), "Hello World");
	}

	@Test(priority = 1)
	public void testDiffButtonsBasedOnFirstName() throws Exception {
	    dotnetFiddlePage = new DotnetFiddlePage(driver);
		gettingStartedPage = new GettingStartedPage(driver);
		dotnetFiddlePage.checksBasedOnFirstName("LFiddle", gettingStartedPage);
	}
}
