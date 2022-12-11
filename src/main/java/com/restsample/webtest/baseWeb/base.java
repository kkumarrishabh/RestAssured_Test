package com.restsample.webtest.baseWeb;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.restsample.webtest.PageObjects.ShopMenu;

import io.github.bonigarcia.wdm.WebDriverManager;

public class base {

	public static WebDriver driver;
	public Properties prop;

	public WebDriver initializeDriver() throws IOException {
		
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--ignore-certifcate-errors");
		chromeOptions.addArguments("--disable-popup-blocking");
		chromeOptions.addArguments("--disable-gpu");
		chromeOptions.addArguments("--start-maximized");
		chromeOptions.addArguments("--disable-plugins");
		chromeOptions.addArguments("--disable-plugins-discovery");
		chromeOptions.addArguments("--disable-preconnect"); 
		chromeOptions.addArguments("--disable-notifications");
		chromeOptions.addArguments("'--dns-prefetch-disable'");
		chromeOptions.setAcceptInsecureCerts(true);

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(chromeOptions);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);

		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "//src//main//resources//data.properties");
		prop.load(fis);

		String browserName = prop.getProperty("url");
		driver.get(browserName);

		System.out.println(prop.getProperty("url"));

		if (browserName.equals("chrome")) {

			WebDriverManager.chromedriver().setup();
			// System.setProperty("webdriver.chrome.driver",
			// "C:\\Users\\user_name\\chromedriver.exe");

			driver = new ChromeDriver();
		} else if (browserName.equals("firefox")) {
			driver = new FirefoxDriver();
			// firefox code Placeholder 
		} else if (browserName.equals("IE")) {
			// IE code Placeholder
		}

		return driver;
	}

	public static void teardown() {
		driver.quit();
	}
}
