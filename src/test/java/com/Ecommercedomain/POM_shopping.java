package com.Ecommercedomain;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.generic.Utility;

public class POM_shopping {

	WebDriver driver;

	public POM_shopping(WebDriver driver) {
		this.driver = driver;
	}

	public void navigate(String category) throws InterruptedException {

		System.out.println("Navigation started");
		driver.findElement(By.xpath("//div[@class='list-group']//a[text()='" + category + "']")).click();
		Thread.sleep(1000);
		Utility.Screenshot(driver, category);

	}

	public void Phones() {

		driver.findElement(By.linkText("Phones")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"tbodyid\"]")));
		List<WebElement> itemscount = driver.findElements(By.xpath("//*[@id=\"tbodyid\"]"));
		// List<WebElement> itemscount =
		// driver.findElements(By.xpath("//h4[@class='card-title']/a[@class=\"hrefch\"]"));

		// List<WebElement> items = driver.findElements(By.xpath("div[@class=\"col-lg-4
		// col-md-6 mb-4\"]"));

		String Phones = null;
		Utility.Screenshot(driver, Phones);
		for (WebElement item : itemscount) {
			System.out.println("Item: " + item.getText());
		}
	}

	public void Laptops() {

		driver.findElement(By.linkText("Laptops")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@id=\"tbodyid\"]/div[@class=\"col-lg-4 col-md-6 mb-4\"]")));
		List<WebElement> itemscount = driver
				.findElements(By.xpath("//div[@id=\"tbodyid\"]/div[@class=\"col-lg-4 col-md-6 mb-4\"]"));
		// List<WebElement> itemscount =
		// driver.findElements(By.xpath("//h4[@class='card-title']/a[@class=\"hrefch\"]"));

		// List<WebElement> items = driver.findElements(By.xpath("div[@class=\"col-lg-4
		// col-md-6 mb-4\"]"));
		// String Laptops = null;
		// Utility.Screenshot(driver, Laptops);
		for (WebElement item : itemscount) {
			System.out.println("Item: " + item.getText());
		}
	}

	public void select_phones(String name) throws InterruptedException {

		Thread.sleep(3000);
		driver.findElement(By.partialLinkText(name)).click();

		Thread.sleep(1000);

		WebElement price = driver.findElement(By.tagName("h3"));
		WebElement prod = driver.findElement(By.tagName("strong"));

		WebElement description = driver.findElement(By.xpath("//*[@id=\"more-information\"]/p"));

		Utility.Screenshot(driver, name);

		Thread.sleep(3000);

		System.out.println("The details of the product " + name + " you have selected is: " + price.getText() + " "
				+ prod.getText() + " " + description.getText());
		Thread.sleep(4000);
	}

	public void add_cart() {

		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(50));

		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"more-information\"]/p")));

		driver.findElement(By.partialLinkText("cart")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		// Try checking for alert (invalid login case)
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();

		String status = alert.getText();
		alert.accept();

		System.out.println(status);

	}

	public void signout() throws InterruptedException {

		driver.findElement(By.linkText("Cart")).click();

		Thread.sleep(2000);

		System.out.println("The final product details in the cart are as below:" + "\n");

		System.out.println("Title\t\tPrice");

		List<WebElement> rows = driver.findElements(By.xpath("//*[@id='tbodyid']/tr"));
		for (WebElement r : rows) {
			List<WebElement> cols = r.findElements(By.tagName("td"));
			if (cols.size() >= 3) {
				String title = cols.get(1).getText();
				String price = cols.get(2).getText();
				System.out.println(title + "\t\t" + price);

				WebElement total_price = driver.findElement(By.cssSelector("h3[id=\"totalp\"]"));

				String signout = null;
				Utility.Screenshot(driver, signout);

				System.out.println("The total amount to be paid is: " + total_price.getText());

				Thread.sleep(3000);

				driver.findElement(By.cssSelector("button[class=\"btn btn-success\"]")).click();
			}

		}

		List<WebElement> details = driver.findElements(By.xpath("//*[@id=\"tbodyid\"]/tr/td/td[1]"));
		for (WebElement d : details) {
			System.out.println("\n" + d.getText());

		}
	}

	public void check_out(String name, String cntry, String cty, String card, String mnth, String year)
			throws InterruptedException {

		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input[id=\"name\"]")).sendKeys(name);
		driver.findElement(By.cssSelector("input[id=\"country\"]")).sendKeys(cntry);
		driver.findElement(By.cssSelector("input[id=\"city\"]")).sendKeys(cty);
		driver.findElement(By.cssSelector("input[id=\"card\"]")).sendKeys(card);
		driver.findElement(By.cssSelector("input[id=\"month\"]")).sendKeys(mnth);
		driver.findElement(By.cssSelector("input[id=\"year\"]")).sendKeys(year);

		String checkout = null;
		Utility.Screenshot(driver, checkout);

		driver.findElement(By.cssSelector("button[onclick=\"purchaseOrder()\"]")).click();

	}

	public void order_confirmed() throws InterruptedException {

		WebElement confirm = driver.findElement(By.xpath("/html/body/div[10]/h2"));
		String message = confirm.getText();
		WebElement order = driver.findElement(By.xpath("/html/body/div[10]/p"));
		String ord_conf = order.getText();

		System.out.println("Your order has been confirmed" + message + "/n" + ord_conf);

		Thread.sleep(2000);

		Utility.Screenshot(driver, message);
		driver.findElement(By.cssSelector("button[class=\"confirm btn btn-lg btn-primary\"]")).click();

	}

	public void logout() throws InterruptedException {

		Thread.sleep(2000);
		driver.findElement(By.linkText("Log out")).click();

		System.out.println("Logged out Successfully");

		String logout = null;
		Utility.Screenshot(driver, logout);
	}

}

//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[@class='card-title']/a"))) - This is for Phone list down
