package com.Ecommercedomain;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.generic.Utility;

public class POM_Login {

	WebDriver driver;

	public POM_Login(WebDriver driver) {

		this.driver = driver;

	}

	public void openLoginModal() {
		driver.findElement(By.id("login2")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logInModal")));
	}

	public void signup() {
		driver.findElement(By.id("signin2")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("signInModal")));
	}

	public void login_page(String un) {

		driver.findElement(By.cssSelector("input[id=\"loginusername\"]")).sendKeys(un);
	}

	public void pwd(String pd) {
		driver.findElement(By.cssSelector("input[id=\"loginpassword\"]")).sendKeys(pd);
	}

	public void login_submit() {
		driver.findElement(By.cssSelector("button[onclick=\"logIn()\"]")).click();
	}

	public void register_user(String R_un) {
		driver.findElement(By.cssSelector("input[id=\"sign-username\"]")).sendKeys(R_un);
	}

	public void register_pwd(String R_pd) {
		driver.findElement(By.cssSelector("input[id=\"sign-password\"]")).sendKeys(R_pd);
	}

	public void signup_submit() {
		driver.findElement(By.cssSelector("button[onclick=\"register()\"]")).click();
	}

	public void signup_validate() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		// Try checking for alert (invalid login case)
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();

		String status = alert.getText();

		if (status.contains("successful")) {
			System.out.println("User credentials created with the output message:" + status);
		} else {
			System.out.println("User id already exists: " + alert.getText());

			// Utility.Screenshot(driver, status);
		}
		alert.accept();
		driver.navigate().refresh();

	}

	public void login_validate() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		try {
			// Try checking for alert (invalid login case)
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert = driver.switchTo().alert();
			System.out.println("Login failed: " + alert.getText());
			alert.accept();
		} catch (TimeoutException e) {
			// If alert is not present, assume login might be successful
			try {
				WebElement confirm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nameofuser")));
				String logged = confirm.getText();

				Utility.Screenshot(driver, logged);

				if (logged.contains("Welcome")) {
					System.out.println("Logged in successfully");
					Utility.Screenshot(driver, logged);
				} else {
					System.out.println("Invalid Credentials, please try again");
					Utility.Screenshot(driver, logged);
					driver.navigate().refresh();
				}
			} catch (Exception ex) {
				System.out.println("Unexpected error after login: " + ex.getMessage());
			}
		}
	}
}
