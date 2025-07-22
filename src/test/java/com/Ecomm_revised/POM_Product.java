package com.Ecomm_revised;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.generic.Utility;

public class POM_Product {

	WebDriver driver;

	public POM_Product(WebDriver driver) {
		this.driver = driver;
	}

	public void vendor(String name) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='filters']//label")));

		// Locate the vendor filter checkbox using vendor name
		String xpath = "//div[@class='filters']//label[contains(.,'" + name + "')]";

		WebElement vendorselect = driver.findElement(By.xpath(xpath));

		// Click if not already selected
		// if (!vendorCheckbox.isSelected()) {
		vendorselect.click();

		Thread.sleep(3000);

		Utility.Screenshot(driver, "vendor");

		// WebElement product =
		// driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/main/div[2]/div[1]/small/span"));
		WebElement product = driver.findElement(By.xpath("//small[@class='products-found']/span"));

		System.out.println("The total number of items found for the product" + name + "is: " + product.getText());
	}

	public void Apple(String Variant) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"__next\"]/div/div/main/div[2]")));

		List<WebElement> items = driver.findElements(By.xpath("//div[@class='shelf-item']"));

		for (WebElement i : items) {

			String productName = i.findElement(By.cssSelector("p[class*='title']")).getText();

			if (productName.equalsIgnoreCase(Variant)) {
				System.out.println("Found variant: " + productName);

				Thread.sleep(3000);

				WebElement addToCart = i.findElement(By.xpath(".//div[text()='Add to cart']"));

				addToCart.click();

				Thread.sleep(2000);

				Utility.Screenshot(driver, "add item 1");

				driver.findElement(By.cssSelector("div[class=\"float-cart__close-btn\"]")).click();

				driver.navigate().refresh();

				System.out.println("The Selected product " + productName + " has been added to the cart");
				break;
			}

		}

	}

	public void Samsung(String Variant) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		// Wait until products load
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.shelf-item")));

		List<WebElement> items = driver.findElements(By.cssSelector("div.shelf-item"));
		boolean found = false;

		for (WebElement item : items) {
			String name = item.findElement(By.cssSelector("p.shelf-item__title")).getText();
			System.out.println("Checking product: " + name);

			if (name.equalsIgnoreCase(Variant)) {
				System.out.println("Product matched: " + name);

				// XPath to match the real visible Add to cart button
				WebElement addToCartBtn = item.findElement(By.xpath(".//div[text()='Add to cart']"));

				addToCartBtn.click();

				Thread.sleep(2000);

				Utility.Screenshot(driver, "add item 2");

				driver.findElement(By.cssSelector("div[class=\"float-cart__close-btn\"]")).click();

				driver.navigate().refresh();

				System.out.println("Clicked 'Add to cart' for: " + name);

				found = true;
				break;
			}
		}

		if (!found) {
			System.out.println("Variant not found: " + Variant);
		}
	}

	public void Google(String Variant) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"__next\"]/div/div/main/div[2]")));

		List<WebElement> items = driver.findElements(By.xpath("//div[@class='shelf-item']"));

		for (WebElement i : items) {

			String productName = i.findElement(By.cssSelector("p[class*='title']")).getText();

			if (productName.equalsIgnoreCase(Variant)) {
				System.out.println("Found variant: " + productName);

				Thread.sleep(3000);

				WebElement addToCart = i.findElement(By.xpath(".//div[text()='Add to cart']"));

				addToCart.click();

				Thread.sleep(2000);
				driver.findElement(By.cssSelector("div[class=\"float-cart__close-btn\"]")).click();

				driver.navigate().refresh();

				System.out.println("The Selected product " + productName + " has been added to the cart");
				break;
			}

		}

	}

	public void OnePlus(String Variant) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"__next\"]/div/div/main/div[2]")));

		List<WebElement> items = driver.findElements(By.xpath("//div[@class='shelf-item']"));

		for (WebElement i : items) {

			String productName = i.findElement(By.cssSelector("p[class*='title']")).getText();

			if (productName.equalsIgnoreCase(Variant)) {
				System.out.println("Found variant: " + productName);

				Thread.sleep(3000);

				WebElement addToCart = i.findElement(By.xpath(".//div[text()='Add to cart']"));

				addToCart.click();

				Thread.sleep(2000);
				driver.findElement(By.cssSelector("div[class=\"float-cart__close-btn\"]")).click();

				driver.navigate().refresh();

				System.out.println("The Selected product " + productName + " has been added to the cart");
				break;
			}

		}

	}

}
