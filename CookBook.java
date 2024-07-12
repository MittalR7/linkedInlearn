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


public class CookBook {
	

	  WebDriver driver;
	
  @Test
  public void CheckBoxAssignment() throws InterruptedException {
	  
	  //1. Go to the url
	  driver.get("http://www.cookbook.seleniumacademy.com/Config.html");
	  
	 // Click on Diesel radio button.
	 WebElement radio1 =  driver.findElement(By.xpath("//input[@value='Diesel']"));
			 radio1.click();
	 
	  
	 // Click on ABS checkbox
			 WebElement check1 =  driver.findElement(By.xpath("//input[@value='ABS']"));
			 check1.click();
			 
	  //Verify the LED Headlamp checkbox is disabled
			 
			
			 WebElement checkbox1 = driver.findElement(By.xpath("//input[@value='LEDHeadLamp']"));
			 boolean checkoptselected = checkbox1.isSelected();
			 Assert.assertFalse(checkoptselected, "LED Headlamp checkbox is disabled");
			 
			 //checked for enable
			 Assert.assertTrue(checkoptselected,"LED Headlamp checkbox is enabled");
			 
  }
  
  
  
  @BeforeMethod
  public void beforeMethod() {
	  
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
  }

  @AfterMethod
  public void afterMethod() {
	  
	//  driver.close();
  }


}
