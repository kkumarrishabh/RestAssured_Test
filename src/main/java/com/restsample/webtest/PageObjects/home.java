package com.restsample.webtest.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.restsample.apitest.actions.Waits;
import com.restsample.webtest.Waits.WebDriverExtensions;

public class home {
	
public WebDriver driver;
	
	By createAccountLink = By.xpath("//a[text()='Create an Account']");
	
	public home (WebDriver driver) {
		this.driver=driver;
	}
	
	public void ClickSignUp()
	{
		WebDriverExtensions.waitAndClick(driver, createAccountLink , 90);
	}


}
