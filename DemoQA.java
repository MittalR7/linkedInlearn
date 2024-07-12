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




public class DemoQA {
	

	  WebDriver driver;
	  
	
  @Test
  public void FormLogin() throws InterruptedException {
	  
	  //1. Go to the url
	  driver.get("https://demoqa.com/automation-practice-form");
	  
	  //Username
	  WebElement fnm = driver.findElement(By.xpath("//*[@placeholder='First Name']"));
	  fnm.sendKeys("Mittal");
	  System.out.println("First name is : " + fnm.getAttribute("value"));

	  WebElement lnm = driver.findElement(By.xpath("//*[@placeholder='Last Name']"));
	  lnm.sendKeys("Rathod");
	  
	  System.out.println("Last name is :" + lnm.getAttribute("value"));


	  //email
	  driver.findElement(By.id("userEmail")).sendKeys("abc@gmail.com");
	  //Thread.sleep(2000);
	  
	  //gender
	 // Thread.sleep(2000);
	  //driver.findElement(By.id("gender-radio-2")).click();

	  //mobile no
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//input[@placeholder='Mobile Number']")).sendKeys("9856321320");

	  //dob
	  Thread.sleep(2000);
	//  driver.findElement(By.xpath("//input[@id='dateOfBirthInput']")).sendKeys("02 June 2024");

	  //hobbies

	  WebElement hobby  = driver.findElement(By.xpath("//input[@id='hobbies-checkbox-3']"));
	  hobby.click();
	  System.out.println("The hobby : " +hobby.isEnabled());
	  

	
	 WebElement cityDropdown =  driver.findElement(By.className(" css-14jk2my-container"));
	 
	 String expectedSring = "dropdown disaabled";
	 boolean actualString = cityDropdown.isEnabled();
	 
	 if(expectedSring.equals(actualString))
		 
			 {
		 System.out.println("Test passed");
			 }
	  
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

//  @BeforeClass
//  public void beforeClass() {
//  }
//
//  @AfterClass
//  public void afterClass() {
//  }

}
