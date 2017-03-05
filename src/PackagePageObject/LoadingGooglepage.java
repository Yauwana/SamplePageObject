package PackagePageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;




public class LoadingGooglepage {

	
		// TODO Auto-generated method stub
		
		@FindBy(how= How.ID, using = "lst-ib")
		public WebElement listIb;
		
		@FindBy(how = How.NAME, using  = "btnG")
		public WebElement btnG;
		

		@FindBy(how = How.LINK_TEXT, using  = "Gmail - Google")
		public WebElement google;
	


public LoginToGmail loadingGooglePage (WebDriver driver,String Listib )
{
	this.listIb.clear();
	this.listIb.sendKeys(Listib);
	this.btnG.click();
	this.google.click();
	
	return PageFactory.initElements(driver, LoginToGmail.class);
			
}

}