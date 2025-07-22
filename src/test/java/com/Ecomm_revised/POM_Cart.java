package com.Ecomm_revised;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.generic.Utility;

public class POM_Cart {

	WebDriver driver;

	public POM_Cart(WebDriver driver) {
		this.driver = driver;
	}

	public void cart() throws InterruptedException {

		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement count = driver.findElement(By.cssSelector("span[class=\"bag__quantity\"]"));
		System.out.println("Total number of products in your cart is: " + count.getText());

		Utility.Screenshot(driver, "cart");

		JavascriptExecutor js = (JavascriptExecutor) driver;

		String value = (String) js.executeScript("let el = document.querySelector('p.sub-price__val');"
				+ "let style = window.getComputedStyle(el, '::before');"
				+ "let beforeText = style.getPropertyValue('content');"
				+ "return beforeText.replace(/['\"]+/g, '') + el.textContent.trim();");

		System.out.println("And total amount to be paid is: " + value);
	}

	public void remove1() throws InterruptedException {

		Thread.sleep(3000);
		driver.findElement(By.cssSelector("span[class=\"bag bag--float-cart-closed\"]")).click();

		Thread.sleep(4000);

		WebElement remove1 = driver.findElement(By.xpath("(//div[@class=\"shelf-item__del\"])[1]"));
		remove1.click();

		Thread.sleep(2000);
		Utility.Screenshot(driver, "removed 1");

		System.out.println("This item has been removed successfully");

		try {
			WebElement count = driver.findElement(By.cssSelector("span[class='bag__quantity']"));

			Thread.sleep(2000);

			Utility.Screenshot(driver, "empty");

			String totalitems = count.getText();
			System.out.println("Total number of products in your cart is: " + totalitems);

			if (totalitems.equals("0")) {
				System.out
						.println("OOPS, the cart is empty, please add items in the cart to proceed with the checkout");

			} else {
				driver.findElement(By.cssSelector("div[class='buy-btn']")).click();
			}

		} catch (Exception e) {
			System.out.println("Something went wrong after item removal: " + e.getMessage());
		}
	}

	public void remove2() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("span[class=\"bag bag--float-cart-closed\"]")).click();
		Thread.sleep(4000);

		WebElement remove2 = driver
				.findElement(By.xpath("//*[@id=\"__next\"]/div/div/div[2]/div[2]/div[2]/div[2]/div[1]"));
		remove2.click();

		Thread.sleep(2000);
		Utility.Screenshot(driver, "removed 2");

		System.out.println("This item has been removed successfully");

		WebElement count = driver.findElement(By.cssSelector("span[class=\"bag__quantity\"]"));

		Thread.sleep(2000);

		Utility.Screenshot(driver, "empty");

		String totalitems = count.getText();

		System.out.println("Total number of products in your cart is: " + totalitems);

		if (totalitems.equals("0")) {

			System.out.println("OOPS, the cart is empty, please add items in the cart to proceed with the checkout");
		} else {

			driver.findElement(By.cssSelector("div[class=\"buy-btn\"]")).click();
		}

	}

	public void checkout_page(String fname, String lname, String addr, String state, String pcode)
			throws InterruptedException {

		Thread.sleep(2000);

		List<WebElement> summary = driver.findElements(By.tagName("h3"));

		Thread.sleep(2000);

		Utility.Screenshot(driver, "Checkout");

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

}
