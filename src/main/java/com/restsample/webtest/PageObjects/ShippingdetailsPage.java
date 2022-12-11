package com.restsample.webtest.PageObjects;

import java.lang.reflect.Method;

import org.json.JSONException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.restsample.apitest.actions.Waits;
import com.restsample.apitest.utilities.Helper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.restsample.apitest.JSONProperties.*;
import com.restsample.webtest.Waits.WebDriverExtensions;

public class ShippingdetailsPage {
	
public WebDriver driver;
	
	
	By email = By.id("customer-email");
	By password = By.id("password");
	By confirmPassword = By.id("password-confirmation");

	

}
