package com.Ecomm_revised;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.generic.Utility;

public class POM_checkout {

	WebDriver driver;

	public POM_checkout(WebDriver driver) {
		this.driver = driver;
	}

	public void checkout_page(String fname, String lname, String addr, String state, String pcode)
			throws InterruptedException {

		Thread.sleep(2000);
		Utility.Screenshot(driver, "Checkout");

		List<WebElement> summary = driver.findElements(By.tagName("h3"));

		for (WebElement s : summary) {
			System.out.println(s.getText());
		}

		driver.findElement(By.cssSelector("input[id=\"firstNameInput\"]")).sendKeys(fname);

		driver.findElement(By.cssSelector("input[id=\"lastNameInput\"]")).sendKeys(lname);

		driver.findElement(By.cssSelector("input[id=\"addressLine1Input\"]")).sendKeys(addr);

		driver.findElement(By.cssSelector("input[id=\"provinceInput\"]")).sendKeys(state);

		driver.findElement(By.cssSelector("input[id=\"postCodeInput\"]")).sendKeys(pcode);

		Thread.sleep(2000);

		Utility.Screenshot(driver, "updated page");

		driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();

		Thread.sleep(2000);

		Utility.Screenshot(driver, "submit");
	}

	public void checkout_summary() throws InterruptedException {
		Thread.sleep(2000);

		WebElement summary = driver.findElement(By.xpath("//*[@id=\"confirmation-message\"]"));

		WebElement detail = driver.findElement(By.xpath("//*[@id=\"checkout-app\"]/div/div/div/ol/li/div/div/div[2]"));

		System.out.println(summary.getText() + detail.getText());

		driver.findElement(By.cssSelector("button[class^=\"button button\"]")).click();

	}

}
