package com.humanresourcedomain;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class POM_OHRM_Login {

	WebDriver driver;

	public POM_OHRM_Login(WebDriver driver) {
		this.driver = driver;

	}

	public void loginid(String id) {

		driver.findElement(By.name("username")).sendKeys(id);
	}

	public void loginpwd(String pwd) {

		driver.findElement(By.name("password")).sendKeys(pwd);
	}

	public void submit() {

		driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
	}
	
	//get total pages in dashboard
	private List<WebElement> totaloptions() {
		return driver.findElements(By.xpath("//span[contains(@class,'oxd-main-menu-item--name')]"));
	}
	public List<WebElement> dashboardoptions() {
	    return totaloptions();
	}
	
	// Go to Admin page
	public void adminpage() {
		
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	    WebElement adminMenu = wait.until(ExpectedConditions.presenceOfElementLocated(
	        By.xpath("//span[text()='Admin' and contains(@class,'oxd-main-menu-item--name')]")));

	    // Scroll and click using JS
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", adminMenu);
	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", adminMenu);

	}
	
	//Thread.sleep(3000);

	// Filter options by Username as "Admin"

	public void usernamesearch(String name) {
		
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input"))
				.sendKeys(name);
		
		}
	public void namesubmit() {
		
		driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
	}
	
	//get total number of records filtered
	
	public void getrecords() {

		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[2]/div/span"));
		
	}

	//String displayrecords = records.getText();
	//System.out.println("The filtered options are: " + displayrecords);
	//driver.navigate().refresh();
	
	//click role drop down option
	public void roledropdown() {
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/div/div/div[2]/i")).click();
	}
	
	//select role
	public void selectrole() {
		driver.findElement(By.xpath("//div[@role=\"listbox\"]//div[@role=\"option\"]")).click();
	}
	
	public void rolesubmit() {
		driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();

	}
	
	public void getrolerecord() {
		
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[2]/div/span"));
	}

//	String displayoptions = option.getText();
//	System.out.println("The filtered options are: "+displayoptions);
//	driver.navigate().refresh();

	//click status drop down option

	public void statusdropdown() {
driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[4]/div/div[2]/div/div[1]/div[2]/i")).click();
	}
	
	//select status
		public void selectstatus() {
			driver.findElement(By.xpath("//div[@role=\"listbox\"]//div[@role=\"option\"]")).click();
		}
		
		public void statussubmit() {
			driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();

		}
		
//		Thread.sleep(1000);
		
		public void getstatusrecord() {
			
			driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[2]/div/span"));
		}
		
		
		
//		String enabled = status.getText();

//		System.out.println("The total enabled records are: "+enabled);

		//driver.navigate().refresh();
		
	public static void main(String[] args) throws InterruptedException {



	}
}