package com.humanresourcedomain;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class OHRM_Login_Admin {
	
	WebDriver driver;
	
	POM_OHRM_Login OHRM;
	POM_OHRM_Admin OHRM1;
	
  @Test
  public void login_OHRM() throws InterruptedException {
	  
	  OHRM.loginid("Admin");
	  OHRM.loginpwd("admin123");
	  OHRM.submit();
	  Thread.sleep(2000);
  }

	
  @Test
  
  public void Admin_OHRM() {
  OHRM1.menu_options();
  OHRM1.searchByUserName("Admin");
  OHRM1.searchByUserRole();
  OHRM1.searchByUserStatus();
  }


  @BeforeTest
  public void beforeTest() {
	  
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		OHRM = new POM_OHRM_Login (driver);
		OHRM1 = new POM_OHRM_Admin (driver);

		
  }

  @AfterTest
  public void afterTest() {
  }

}
