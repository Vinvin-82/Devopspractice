package com.Ecommercedomain;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
@Listeners(com.listenerclass.ExtentReportListener.class)

public class Ecom_Login {
	
	WebDriver driver;
	POM_Login LG;
	POM_shopping SP;
  @Test (priority =1)
  public void login() throws InterruptedException {
	  
	  Thread.sleep(1000);
	  LG.signup();
	  LG.register_user("project_user3");
	  LG.register_pwd("Myproject");
	  LG.signup_submit();
	  LG.signup_validate();
	  LG.openLoginModal();
	  LG.login_page("project_user3");
	  LG.pwd("Myproject");
	  LG.login_submit();
	  LG.login_validate();
	  
	  
  }
  
  @Test (priority =2)
  public void Navigation() throws InterruptedException {
	  Thread.sleep(2000);
	  SP.navigate("Phones");
	  SP.Phones();
	  SP.select_phones("Nexus"); 
	  SP.add_cart();
	  SP.signout();
	  SP.check_out("Test User", "Bharath", "Chennai", "vinvin1010", "Oct", "2030");
	  SP.order_confirmed();
	  SP.logout();
  }
  
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterTest
  public void close() {
	//  driver.close();
  }
  @BeforeTest
  public void Visitpage() {
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.demoblaze.com/");
	LG = new POM_Login(driver);
	SP = new POM_shopping(driver);
	

  }

}
