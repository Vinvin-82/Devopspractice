package com.Ecomm_revised;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.AfterTest;
@Listeners(com.listenerclass.ExtentReportListener.class)

public class TC_Login_Shopping_Checkout {
	
	WebDriver driver;
	POM_NewLogin LG;
	POM_Product PRD;
	POM_Cart CRT;
	POM_checkout CHK;
	
  @Test (priority = 1)
	public void login() throws InterruptedException {
	 LG.Invalid_Cred();
	 LG.Empty_Cred();
	  LG.signin();
  
  }
  
	
  @Test (priority = 2)
  public void productpage() throws InterruptedException {
	  PRD.vendor("Apple");
	  PRD.Apple("iphone 11");
	  PRD.Samsung("Galaxy S20");
	 
	  
  }
  
  @Test (priority = 3)
  public void cart() throws InterruptedException {
	  CRT.cart();
	  CRT.remove2();
	  CRT.cart();
	 
	  
  }
  
  @Test (priority = 4)
  public void checkout() throws InterruptedException {
	  CHK.checkout_page("Test", "User", "Chennai", "Bharath", "60004");
	  CHK.checkout_summary();
	  
  }
  
  @Test (priority = 5)
  public void emptycheckout() throws InterruptedException {
	  CRT.cart();
	  PRD.Apple("iphone 11 pro");
	  CRT.remove1();
  
	  
  }
  
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
  }

  @BeforeTest
  public void beforeTest() {
	  
        driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://bstackdemo.com/");
		LG = new POM_NewLogin(driver);
		PRD = new POM_Product(driver);
		CRT = new POM_Cart(driver);
		CHK= new POM_checkout(driver);
  }

  @AfterTest
  public void afterTest() {
	  
	  driver.close();
  }

}
