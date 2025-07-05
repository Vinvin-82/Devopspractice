package com.browser;


import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class RemoteTest {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {

        // 1. Set Chrome Options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
       // options.addArguments("--headless"); // Optional: headless mode

        // 2. Create RemoteWebDriver instance using Selenium Grid URL
        URL gridUrl = new URL("http://localhost:4444/wd/hub");
        WebDriver driver = new RemoteWebDriver(gridUrl, options);

        // 3. Start your test
        driver.get("https://www.google.com");

        // 4. Print title
        System.out.println("Title is: " + driver.getTitle());

        // 5. Close browser
        driver.quit();
    }
}


