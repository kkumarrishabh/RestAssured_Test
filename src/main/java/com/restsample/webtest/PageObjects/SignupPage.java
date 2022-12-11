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

public class SignupPage {
	
public WebDriver driver;
	
	
	public MyData json;
	
	
	By createAccountButton = By.xpath("//button[@title='Create an Account']");
	By firstName = By.id("firstname");
	By lastName = By.id("lastname");
	By email = By.id("email_address");
	By password = By.id("password");
	By confirmPassword = By.id("password-confirmation");
	
	
	//Shipping
	
	By shippingstreet = By.xpath("//input[@name='street[0]']");
	By shippingcity = By.xpath("//input[@name='city']");
	By shippingpostcode = By.xpath("//input[@name='postcode']");
	By shippingtelephone = By.xpath("//input[@name='telephone']");
	By shippingregionid = By.xpath("//select[@name='region_id']");
	By shippingradio = By.xpath("//input[@value='flatrate_flatrate']");
	By nextButton = By.xpath("//*[@id='shipping-method-buttons-container']//button");
	
	
	public SignupPage (WebDriver driver){
		this.driver=driver;
	}
	
	public void getJsonData() throws JsonMappingException, JsonProcessingException, JSONException {
		json = new Helper().ApiRequestTest(null);
	}

	public void fillCustomerDetails() throws JsonMappingException, JsonProcessingException, JSONException{
		getJsonData();
		WebDriverExtensions.EnterText(driver, firstName, json.getResults().get(0).getName().getFirst(), 90);
		WebDriverExtensions.EnterText(driver, lastName, json.getResults().get(0).getName().getLast(), 90);
		WebDriverExtensions.EnterText(driver, email, json.getResults().get(0).getEmail(), 90);
		WebDriverExtensions.EnterText(driver, password, json.getResults().get(0).getLogin().getUuid(), 90);
		WebDriverExtensions.EnterText(driver, confirmPassword, json.getResults().get(0).getLogin().getUuid(), 90);
	}
	
	public void clickCreateAccount(){
		WebDriverExtensions.waitAndClick(driver, createAccountButton , 90);
	}
	
	public void fillshippingDetails(){
		WebDriverExtensions.EnterText(driver, shippingstreet, json.getResults().get(0).getLocation().getStreet().getName(), 90);
		WebDriverExtensions.EnterText(driver, shippingcity, json.getResults().get(0).getLocation().getCity(), 90);
		WebDriverExtensions.EnterText(driver, shippingpostcode, "" + json.getResults().get(0).getLocation().getPostcode(), 90);
		WebDriverExtensions.EnterText(driver, shippingtelephone, "" + json.getResults().get(0).getPhone(), 90);
		WebDriverExtensions.SelectDropDown(driver, shippingregionid, "1");
		WebDriverExtensions.SelectRadioButton(driver, shippingradio, 90);
		WebDriverExtensions.waitAndClick(driver, nextButton , 30);
	}

}
