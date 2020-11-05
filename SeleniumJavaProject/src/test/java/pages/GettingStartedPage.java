package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GettingStartedPage {
	
   public GettingStartedPage(WebDriver driver) {
	   PageFactory.initElements(driver, this);
   }
   
   @FindBy(css = "span.glyphicon.glyphicon-chevron-left")
   public WebElement backToEditorBtn;
}
