package PackagePageObject;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateLoyaltyProgram {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://uat.riverviewms.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.manage().window().maximize();
  }

  @Test
  public void testCreateLoyaltyProgram() throws Exception {
      // login function
    driver.get(baseUrl + "/user/login");
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("admin");
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("admin");
    driver.findElement(By.xpath("//input[@value='Login']")).click();
    //click Loyalty
    driver.findElement(By.xpath("//div[@id='sidebar']/div[3]/div/div[4]/ul/li/a/span")).click();
    //click program type
    driver.findElement(By.linkText("Program Types")).click();
    //click create button
    driver.findElement(By.id("btn-create")).click();
    //select appllication
    driver.findElement(By.xpath("//*[@id='applications_chosen']/ul")).click();
    WebElement application = driver.findElement(By.xpath("//*[@id='applications_chosen']/div/ul/li[4]"));
    application.click();
    //select loyalty type
    driver.findElement(By.xpath("//*[@id='default_type_chosen']/a/span")).click();
    WebElement type =  driver.findElement(By.xpath("//*[@id='default_type_chosen']/div/ul/li[3]"));
    type.click();
    //set points expiry
    driver.findElement(By.id("expired_in_months")).clear();
    driver.findElement(By.id("expired_in_months")).sendKeys("10");
    //give a title
    driver.findElement(By.id("title")).clear();
    driver.findElement(By.id("title")).sendKeys("Test Loyality Program");
    //give a description
    driver.findElement(By.id("description")).clear();
    driver.findElement(By.id("description")).sendKeys("This is a test loyalty description");
    //select start date
    driver.findElement(By.id("start_date")).click();
    driver.findElement(By.cssSelector("td.active.day")).click();
    //select an end date
    driver.findElement(By.id("end_date")).click();
    driver.findElement(By.cssSelector("th.next")).click();
    driver.findElement(By.cssSelector("th.next")).click();
    driver.findElement(By.cssSelector("th.next")).click();
    driver.findElement(By.cssSelector("th.next")).click();
    driver.findElement(By.cssSelector("th.next")).click();
    driver.findElement(By.cssSelector("th.next")).click();
    driver.findElement(By.cssSelector("th.next")).click();
    driver.findElement(By.xpath("//*[@id='ui-id-1']/div[9]/div[1]/table/tbody/tr[5]/td[6]")).click();
    //select rolling expiry
    driver.findElement(By.xpath("//*[@id='create_loyalty_programs']/div[1]/div[3]/div[2]/div/div/ins")).click();
    boolean v = driver.findElement(By.xpath("//*[@id='create_loyalty_programs']/div[1]/div[3]/div[2]/div/div/ins")).isSelected();
    System.out.println(v);
    //if rolling expiry select only
    if(driver.findElement(By.xpath("//*[contains(concat(' ', normalize-space(@class), ' '), 'icheckbox_square-blue')]")).getAttribute("class").contains("checked")){
    	 driver.findElement(By.xpath("//*[@id='rolling_expiry_cycle']")).clear();
    	 driver.findElement(By.xpath("//*[@id='rolling_expiry_cycle']")).sendKeys("200");
    }
  /*  if(driver.findElement(By.xpath("//*[@id='create_loyalty_programs']/div[1]/div[3]/div[2]/div/div/ins")).isSelected()){
    // set rolling expiry after selecting "Rolling expiry"
    driver.findElement(By.xpath("//*[@id='rolling_expiry_cycle']")).clear();
    driver.findElement(By.xpath("//*[@id='rolling_expiry_cycle']")).sendKeys("200");
    }*/
    
    //click submit button
    driver.findElement(By.cssSelector("button.button.button-success")).click();
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