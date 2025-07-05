package com.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.net.URL;

public class Parallel_Execution {
    WebDriver driver;

    @Parameters("browser")
    @BeforeMethod
    public void setup(String browser) throws Exception {
        DesiredCapabilities cap = new DesiredCapabilities();

        if (browser.equalsIgnoreCase("chrome")) {
            cap.setBrowserName("chrome");
        } else if (browser.equalsIgnoreCase("firefox")) {
            cap.setBrowserName("firefox");
        } else if (browser.equalsIgnoreCase("edge")) {
            cap.setBrowserName("MicrosoftEdge");
        }

        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
    }

    @Test
    public void amazonTest() {
        driver.get("https://www.amazon.in");
        System.out.println("Title is: " + driver.getTitle());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}