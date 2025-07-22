package com.Ecomm_revised;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.generic.Utility;

public class POM_NewLogin {

	WebDriver driver;

	public POM_NewLogin(WebDriver driver) {
		this.driver = driver;
	}

	public void signin() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		Actions actions = new Actions(driver);

		try {
			// ✅ Click Sign In on homepage
			WebElement signIn = wait.until(ExpectedConditions.elementToBeClickable(By.id("signin")));
			signIn.click();

			// ✅ Wait for username dropdown to appear
			WebElement usernameDropdown = wait.until(
					ExpectedConditions.elementToBeClickable(By.cssSelector("div#username div[class*='css-1hwfws3']")));
			usernameDropdown.click();
			WebElement demouserOption = wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='username']//div[text()='demouser']")));
			demouserOption.click();

			// ✅ Wait for password dropdown to appear
			WebElement passwordDropdown = wait.until(
					ExpectedConditions.elementToBeClickable(By.cssSelector("div#password div[class*='css-1hwfws3']")));
			passwordDropdown.click();
			Thread.sleep(500);
			actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();

			// ✅ Click Login button
			WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("login-btn")));
			loginBtn.click();
			
			Thread.sleep(2000);
			Utility.Screenshot(driver, "signin");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		Thread.sleep(2000);

		String URL = driver.getCurrentUrl();

		if (URL.contains("true")) {
			System.out.println("Logged in Successfully");
		
			Utility.Screenshot(driver, "success");

			
		
		} else {
			System.out.println("Invalid Credentials, please enter valid details");
		}
		driver.navigate().refresh();
	}

	public void Invalid_Cred() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		Actions actions = new Actions(driver);

		try {
			// ✅ Click Sign In on homepage
			WebElement signIn = wait.until(ExpectedConditions.elementToBeClickable(By.id("signin")));
			signIn.click();

			// ✅ Wait for username dropdown to appear
			WebElement usernameDropdown = wait.until(
					ExpectedConditions.elementToBeClickable(By.cssSelector("div#username div[class*='css-1hwfws3']")));
//
//	            // ✅ Wait for password dropdown to appear
			WebElement passwordDropdown = wait.until(
					ExpectedConditions.elementToBeClickable(By.cssSelector("div#password div[class*='css-1hwfws3']")));

			// Username dropdown
			usernameDropdown.click();
			WebElement invalidUser = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//div[@id='username']//div[text()='image_not_loading_user']")));
			invalidUser.click();

			// Password dropdown
			passwordDropdown.click();
			WebElement anyPwd = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='password']//div[1]"))); // Select
																												// first
																												// password
			anyPwd.click();

			// ✅ Click Login button
			WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("login-btn")));
			loginBtn.click();
			
			Thread.sleep(2000);
			
			Utility.Screenshot(driver, "invalid");


		} catch (Exception e) {
			e.printStackTrace();
		}

		Thread.sleep(2000);

		String URL = driver.getCurrentUrl();

		if (URL.contains("true")) {
			System.out.println("Logged in Successfully");
		} else {
			System.out.println("Invalid Credentials, please enter valid details");
			driver.get("https://bstackdemo.com/");
		}
	}

	public void Empty_Cred() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		Actions actions = new Actions(driver);

		try {
			// ✅ Click Sign In on homepage
			WebElement signIn = wait.until(ExpectedConditions.elementToBeClickable(By.id("signin")));
			signIn.click();

			// ✅ Wait for username dropdown to appear
			WebElement usernameDropdown = wait.until(
					ExpectedConditions.elementToBeClickable(By.cssSelector("div#username div[class*='css-1hwfws3']")));
			usernameDropdown.click();
			WebElement demouserOption = wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='username']//div[text()='demouser']")));
			demouserOption.click();

			// ✅ Click Login button
			WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("login-btn")));
			loginBtn.click();
			
			Thread.sleep(2000);
			
			Utility.Screenshot(driver, "Empty login");


		} catch (Exception e) {
			e.printStackTrace();
		}

		Thread.sleep(2000);

		String URL = driver.getCurrentUrl();

		if (URL.contains("true")) {
			System.out.println("Logged in Successfully");
		} else {
			System.out.println("Invalid / Empty Credentials, please enter valid details");
			driver.get("https://bstackdemo.com/");
		}
	}

}
