package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;


public class CookBookAlert {
	

	  WebDriver driver;
	
  @Test
  public void Alert() throws InterruptedException {
	  
	
	  
	  
	 // Click on show alert button.
	 WebElement alert1 =  driver.findElement(By.xpath("//input[@id='simple']"));
			 alert1.click();
	 
	  
	 // Verify the message on the alert is "Hello! I am an alert box!"
			 
			String actualText = driver.switchTo().alert().getText();
			 String expectedText = "Hello! I am an alert box!";
			 System.out.println(actualText);
			 assertEquals(actualText, expectedText);
			 
			// 3. Click on Ok
			 
			driver.switchTo().alert().accept();
			
			 
  }
  
  @Test
  public void Alertass2() throws InterruptedException {
	  
	  driver.get("http://www.cookbook.seleniumacademy.com/Alerts.html");
	  
	  //2.Click on the "Try it" button.This button is next to "Show alert box"
	  	driver.findElement(By.xpath("//button[@id='confirm']")).click();
	  	
	  
	 // 3. Verify the message on the alert is "Press a button!"
	  String actualText2 = driver.switchTo().alert().getText();
		 String expectedText2 = "Press a button!";
		 System.out.println(actualText2);
		 assertEquals(actualText2, expectedText2);
		 
	 // 4. Click on "Cancel" button on the alert.
		 driver.switchTo().alert().dismiss();
	  
	//  5. Verify the text "You Dismissed Alert!" is displayed on the page.
		String dismissactual = driver.findElement(By.xpath("//p[text()='You Dismissed Alert!']")).getText();
		String expecteddismiss = "You Dismissed Alert!";
		System.out.println(dismissactual);
		 assertEquals(dismissactual, expecteddismiss);
		
	 // 6. Click on the same button "Try it" again.
			driver.findElement(By.xpath("//button[@id='confirm']")).click();
		 
	  //7. This time click on "Ok" button on the alert.
			driver.switchTo().alert().accept();
	  
	//  8. Verify the text "You Accepted Alert!" is displayed on the page.
			String acceptactual = driver.findElement(By.xpath("//p[text()='You Accepted Alert!']")).getText();
			String expectedaccept = "You Accepted Alert!";
			System.out.println(acceptactual);
			 assertEquals(acceptactual, expectedaccept);
	  
  }
  

  @Test
  public void Alertass3() throws InterruptedException {
  
 // 1. Go to - http://www.cookbook.seleniumacademy.com/Alerts.html

	  driver.get("http://www.cookbook.seleniumacademy.com/Alerts.html");
	  
 // 2. Click on the "Try it" button.This button is last button on the page.
	  driver.findElement(By.xpath("//button[@id='prompt']")).click();
	  
 // 3. Verify the message on the alert is "Please enter your name"
	  	String alert3 = driver.switchTo().alert().getText();  
	  
	  
	  // 4. Type "Selenium" in the text box on the alert.
	  	
	  	driver.switchTo().alert().sendKeys("Selenium");
	  		//String entertext =driver.switchTo().alert().getText() ; System.out.println(entertext);
	  	driver.switchTo().alert().accept();
  
	  //5. Verify the text "Hello Selenium! How are you today?" is displayed on the page.
		String actualalert = driver.findElement(By.xpath("//p[text()='Hello Selenium! How are you today?']")).getText();
		String expectedalert = "Hello Selenium! How are you today?";
		System.out.println(actualalert);
		 assertEquals(actualalert, expectedalert);
  
  }
  
  
  @BeforeMethod
  public void beforeMethod() {
	  
	  driver = new ChromeDriver();
	  
	  driver.get("http://www.cookbook.seleniumacademy.com/Alerts.html");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
  }

  @AfterMethod
  public void afterMethod() {
	  
	driver.close();
  }

}
