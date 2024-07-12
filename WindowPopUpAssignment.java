package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;


public class WindowPopUpAssignment {
	

	  WebDriver driver;
	  
	 
	  
	
  @Test
  public void Assignment1() throws InterruptedException {
	  
	  String parentWindow ;
	  //1. Go to the url
	  driver.get("https://nichethyself.com/tourism/customised.html");
	//  driver.get("https://nichethyself.com/tourism/home.html");
	  
	// Go to "Customized tours" ( opens in different tab, so please switch)
	
	 
	  
	 
	 
	
	 //3. Select "Home Stay" in preferred stay dropwdown/combo.
	  	
	  WebElement dropdown = driver.findElement(By.xpath("//select[@id='days']"));
	  
	  Select options = new Select(dropdown);
	  options.selectByVisibleText("Home Stay");
	
	// 4. Click on England checkbox
	  	driver.findElement(By.xpath("//div[@class='checkbox-inline'][2]")).click();
	  
	 //5. From above now click on "Contact Us" menu on top right corner (switch)
	  	
	  	driver.findElement(By.xpath("//button[text()='Contact us!']")).click(); 	
	  	driver.switchTo().window("Contact");
	  	
	 //6. On "Contact Us" window, click on Search icon.
	  	driver.findElement(By.xpath("//a[@onclick='prompty()']")).click();
	  	
	  	
	// 7. Enter "London" on the pop window and click on OK. (switch)
	  Alert	myAlert = driver.switchTo().alert();
	  	myAlert.sendKeys("London");
	  	Thread.sleep(2000);
	  	driver.switchTo().alert().accept();
	  	
	// 8. Close "Contact Us" window and click on "Submit" button on customized tour (switch)
	  	driver.close();
	  	parentWindow = driver.getWindowHandle();
	  
	  	driver.switchTo().window(parentWindow);
	  	
	  	driver.findElement(By.xpath("//form[@name='internationalf']/button[@class='btn btn-primary']]")).click();
	  	
	// 9. Handle the alert you get after clicking on submit.

	
	 
	 
	  
	  
//	
//	  
//	  String expectedTitle ="My account";
//	  String actualTitle = driver.getTitle();
//	  
//	  System.out.println("Expected title : "+expectedTitle);
//	  System.out.println("Expected title : "+actualTitle);
//	  

	  
	 // assertEquals(actualTitle,expectedTitle);
  }
  
  
 
  
  @BeforeMethod
  public void beforeMethod() {
	  
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
  }

  @AfterMethod
  public void afterMethod() {
	  
	 // driver.close();
  }

}
