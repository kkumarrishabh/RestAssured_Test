package com.restsample.webtest.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.restsample.apitest.JSONProperties.MyData;
import com.restsample.webtest.Waits.WebDriverExtensions;

public class ShopMenu {

public WebDriver driver;	
	
public ShopMenu (WebDriver driver) {
	this.driver=driver;
}
	By MenSection = By.id("ui-id-5");
	By MenTopsSubSection = By.id("ui-id-17");
	By MensTopsJacket = By.id("ui-id-19");
	
	public void doChooseMenTopsJacket()
	{
		WebDriverExtensions.Hover(driver, MenSection , 90);
		WebDriverExtensions.WaitHoverAndClick(driver, MenTopsSubSection , MensTopsJacket, 90);
	}
}
