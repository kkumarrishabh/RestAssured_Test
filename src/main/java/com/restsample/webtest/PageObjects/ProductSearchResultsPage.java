package com.restsample.webtest.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.restsample.apitest.JSONProperties.MyData;
import com.restsample.webtest.Waits.WebDriverExtensions;

public class ProductSearchResultsPage {

public WebDriver driver;	
	
public ProductSearchResultsPage (WebDriver driver) {
	this.driver=driver;
}
	By JacketImage = By.xpath("//img[@alt='Proteus Fitness Jackshirt']");
	
	public void doClickImage()
	{
		WebDriverExtensions.waitAndClick(driver, JacketImage, 90);
	}
}
