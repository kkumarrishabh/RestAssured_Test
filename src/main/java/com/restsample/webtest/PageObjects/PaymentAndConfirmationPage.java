package com.restsample.webtest.PageObjects;

import static org.testng.Assert.assertTrue;

import java.lang.reflect.Method;

import org.json.JSONException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.restsample.apitest.actions.Waits;
import com.restsample.apitest.utilities.Helper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.relevantcodes.extentreports.ExtentTest;
import com.restsample.apitest.JSONProperties.*;
import com.restsample.webtest.Waits.WebDriverExtensions;

public class PaymentAndConfirmationPage {
	
public WebDriver driver;
	
	
	By PlaceOrderButton = By.xpath("//button[@class='action primary checkout']/span");
	By OrderConfirmation = By.className("base");
	By Loader = By.className("loading-mask");

	
	
	public PaymentAndConfirmationPage (WebDriver driver, ExtentTest test){
		this.driver=driver;
	}
	
	
	public void doclickPlaceOrder(){
		WebDriverExtensions.WaitForPageLoad(driver, 60);
		WebDriverExtensions.WaitTillLoader(driver, Loader, 60);
		WebDriverExtensions.WaitHoverAndClick(driver,PlaceOrderButton, PlaceOrderButton, 90);	
	}
	
	public void AssertConfirmation(){
		
		  String expected = "Thank you for your purchase!";
		  WebDriverExtensions.WaitTillLoader(driver, Loader, 60); try { String actual =
		  WebDriverExtensions.GetText(driver, OrderConfirmation, 90);
		  assertTrue(actual.equals(expected)); } catch(Exception e){ assertTrue(false);
		  }
	}
}
