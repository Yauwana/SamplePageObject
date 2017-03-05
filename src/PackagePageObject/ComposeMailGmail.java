package PackagePageObject;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class ComposeMailGmail {
	
	private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true; 
	  private StringBuffer verificationErrors = new StringBuffer();

	  @BeforeClass(alwaysRun = true)
	  public void setUp() throws Exception {
	    driver = new FirefoxDriver();
	    baseUrl = "https://www.google.lk/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.manage().window().maximize();
	  }

	  @Test
	  public void testComposeMail() throws Exception {
		  driver.get(baseUrl + "/?gfe_rd=cr&ei=jHuUV4GmDorj8wfEnpH4BQ&gws_rd=ssl");
		  
		  LoadingGooglepage googlepage = PageFactory.initElements(driver, LoadingGooglepage.class);
		  LoginToGmail logintogmail = googlepage.loadingGooglePage (driver,"gmail");
		  
		  
		  /*driver.findElement(By.id("lst-ib")).clear();
		  driver.findElement(By.id("lst-ib")).sendKeys("gmail");
		  driver.findElement(By.name("btnG")).click();
		  driver.findElement(By.linkText("Gmail - Google")).click();*/
		  
		  
		  //driver.findElement(By.id("gmail-sign-in")).click(); Unable to perform this code
		  //this was coverd in the class LoginToGmail
		  /*driver.findElement(By.id("Email")).clear();
		  driver.findElement(By.id("Email")).sendKeys("ravindray2r@gmail.com");
		  driver.findElement(By.id("next")).click();
		  driver.findElement(By.id("Passwd")).clear();
		  driver.findElement(By.id("Passwd")).sendKeys("2pactill&die");
		  driver.findElement(By.id("signIn")).click();*/

		 // LoginToGmail loginPage  = PageFactory.initElements(driver, LoginToGmail.class);
		  logintogmail.logintoGmailApplication(driver, "ravindray2r@gmail.com", "2pactill&die");
		  
		  driver.get(baseUrl + "mail/u/0/#inbox");
		  driver.findElement(By.xpath("//div[@id=':j4']/div/div")).click();
		  driver.findElement(By.id(":ou")).click();
		  driver.findElement(By.id(":ou")).clear();
		  driver.findElement(By.id(":ou")).sendKeys("testing roshani");
		  driver.findElement(By.id(":ok")).click();

	   
	    driver.findElement(By.id(":od")).click();
	    driver.findElement(By.linkText("Sent Mail")).click();
	  }

	  @AfterClass(alwaysRun = true)
	  public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }

	  private boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }

	  private boolean isAlertPresent() {
	    try {
	      driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }

	  private String closeAlertAndGetItsText() {
	    try {
	      Alert alert = driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	      acceptNextAlert = true;
	    }
	  }

}
