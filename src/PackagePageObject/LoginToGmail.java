package PackagePageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginToGmail {

	@FindBy(how = How.ID, using = "Email")
	public WebElement Email;
	
	@FindBy(how = How.ID, using = "next")
	public WebElement Next;

	@FindBy(how = How.ID, using = "Passwd")
	public WebElement password;
	
	@FindBy(how = How.ID, using = "signIn")
	public WebElement SigningButton;
	


public void logintoGmailApplication(WebDriver driver, String Email, String Password)
{
	
	this.Email.clear();
	this.Email.sendKeys(Email);
	this.Next.click();
	this.password.clear();
	this.password.sendKeys(Password);
	this.SigningButton.click();
	
	
	}
}
