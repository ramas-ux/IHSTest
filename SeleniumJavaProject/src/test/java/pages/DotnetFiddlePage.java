package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class DotnetFiddlePage {
	WebDriver driver;

	public DotnetFiddlePage(WebDriver driver) {
      PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#run-button")
	public WebElement run;

	@FindBy(css = "#output")
	public WebElement hwOutputText;

	@FindBy(css = "input[type=search]")
	public WebElement nuGetPackages;

	@FindBy(css = "button#Share")
	public WebElement shareBtn;

	@FindBy(css = "input#ShareLink")
	public WebElement shareLink;

	@FindBy(css = "span.glyphicon.glyphicon-chevron-left:last-of-type")
	public WebElement optionsHideBtn;

	@FindBy(css = "span.glyphicon.glyphicon-chevron-right")
	public WebElement optionsShowBtn;

	@FindBy(css = "button#save-button")
	public WebElement saveBtn;

	@FindBy(css = "h4#login-modal-label")
	public WebElement logInModal;

	@FindBy(linkText = "GettingStarted")
	public WebElement gettingStartedBtn;
	
	
	public void checkOutput(String text) throws Exception {
		Thread.sleep(1000);
		run.click();
		Assert.assertEquals(hwOutputText.getText(), "Hello World");
	}

	public void checksBasedOnFirstName(String firstName, GettingStartedPage gettingStartedPage) throws Exception {
		char ch = (firstName.toUpperCase()).charAt(0);
		
		if( ch == 'A' || ch == 'B' || ch == 'C' || ch == 'D' || ch == 'E') {
			nuGetPackages.sendKeys("nUnit");
			Thread.sleep(1000);
			driver.findElement(By.cssSelector("a#ui-id-1")).click();
			driver.findElement(By.cssSelector("a[package-id=NUnit][version-name = 3.12.0.0]")).click();
			Assert.assertTrue(driver.findElement(By.cssSelector("div[package-id=NUnit]")).isDisplayed());
			Assert.assertTrue(driver.findElement(By.cssSelector("a.delete-package")).isDisplayed());
		}

		else if (ch == 'F' || ch == 'G' || ch == 'H' || ch == 'I' || ch == 'J' || ch == 'K') {
			shareBtn.click();
			String shareLinkText = shareLink.getText();
			Assert.assertTrue(shareLinkText.startsWith("https://dotnetfiddle.net/"));
		}
		
		else if(ch == 'L' || ch == 'M' || ch == 'N' || ch == 'O' || ch == 'P') {
			optionsHideBtn.click();
			Assert.assertTrue(optionsShowBtn.isDisplayed());
		}
		
		else if(ch == 'Q' || ch == 'R' || ch == 'S' || ch == 'T' || ch == 'U') {
			saveBtn.click();
			Assert.assertTrue(logInModal.isDisplayed());
		}
		
		else if(ch == 'V' || ch == 'W' || ch == 'X' || ch == 'Y' || ch == 'Z') {
			gettingStartedBtn.click();
			Assert.assertTrue(gettingStartedPage.backToEditorBtn.isDisplayed());
		}

	}
}
