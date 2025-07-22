package com.humanresourcedomain;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.generic.Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@Listeners(com.listenerclass.ExtentReportListener.class)
public class Login_OHRM {

	String fpath = System.getProperty("user.dir") + "\\ExcelFiles\\Logincredentials.xlsx";

	File file;
	FileInputStream fis;
	// FileOutputStream fos;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
	int index = 1;

	WebDriver driver;

	@Test(dataProvider = "LoginData")
	public void login(String un, String ps) throws InterruptedException {
		driver.findElement(By.name("username")).sendKeys(un);
		driver.findElement(By.name("password")).sendKeys(ps);

		Utility.Screenshot(driver, un);

		driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();

		Thread.sleep(500);
		Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));

	}

	@AfterMethod
	public void output() {
		row = sheet.getRow(index);
		cell = row.getCell(2);

		if (driver.getCurrentUrl().contains("dashboard")) {
			Utility.Screenshot(driver,"Login Page");
			
			driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[3]/ul/li/span/p")).click();
			driver.findElement(By.linkText("Logout")).click();
			System.out.println("Logged in Successfully");
		} else {
			System.out.println("Invalid Credentials");
		}
	}

	@DataProvider
	public Object[][] LoginData() {
		int rows = sheet.getPhysicalNumberOfRows();
		String[][] data = new String[rows - 1][2];
		for (int i = 0; i < rows - 1; i++) // reading rows
		{
			row = sheet.getRow(i + 1);

			for (int j = 0; j < 2; j++) {
				cell = row.getCell(j);
				data[i][j] = cell.getStringCellValue();
			}
		}
		return data;

	}


	@BeforeTest
	public void File_read() throws IOException {
		file = new File(fpath);
				fis = new FileInputStream(file); 
				wb = new XSSFWorkbook(fis);
		sheet = wb.getSheet("Login");
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

	}

	@AfterTest
	public void File_close() throws IOException {
		wb.close();
		fis.close();

	}
}
