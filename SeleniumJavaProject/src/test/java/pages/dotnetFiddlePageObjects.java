package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class dotnetFiddlePageObjects {

	public dotnetFiddlePageObjects(WebDriver driver) {
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
	// a#ui-id-161

	public void checksBasedOnFirstName(String firstName) {
		char ch = (firstName.toUpperCase()).charAt(0);

		if (ch == 'F' || ch == 'G' || ch == 'H' || ch == 'I' || ch == 'J' || ch == 'K') {
			shareBtn.click();
			String shareLinkText = shareLink.getText();
			Assert.assertTrue(shareLinkText.startsWith("https://dotnetfiddle.net/"));
		}
		
		if( ch == 'L' || ch == 'M' || ch == 'N' || ch == 'O' || ch == 'P') {
			optionsHideBtn.click();
			Assert.assertTrue(optionsShowBtn.isDisplayed());
		}
		
		if( ch == 'Q' || ch == 'R' || ch == 'S' || ch == 'T' || ch == 'U') {
			saveBtn.click();
			Assert.assertTrue(logInModal.isDisplayed());
		}
		
		if( ch == 'V' || ch == 'W' || ch == 'X' || ch == 'Y' || ch == 'Z') {
			gettingStartedBtn.click();
			//Assert.assertTrue(logInModal.isDisplayed());
		}

	}
}
