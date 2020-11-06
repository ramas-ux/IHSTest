package test;

import org.testng.annotations.Test;
import pages.DotnetFiddlePage;
import pages.GettingStartedPage;

public class DotnetFiddleTest extends BaseTest {

	DotnetFiddlePage dotnetFiddlePage;
	GettingStartedPage gettingStartedPage;

	@Test
	public void testHelloWorldText() throws Exception {
		dotnetFiddlePage = new DotnetFiddlePage(driver);
		dotnetFiddlePage.checkOutput("Hello World");
	}

	@Test
	public void testDiffButtonsBasedOnFirstName() throws Exception {
		gettingStartedPage = new GettingStartedPage(driver);
		dotnetFiddlePage.checksBasedOnFirstName("Fiddle", gettingStartedPage);
	}
}
