package com.restsample.apitest.businessLogics;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.json.JSONException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.restsample.apitest.JSONProperties.MyData;
import com.restsample.webtest.PageObjects.PaymentAndConfirmationPage;
import com.restsample.webtest.PageObjects.ProductDetailsPage;
import com.restsample.webtest.PageObjects.ProductSearchResultsPage;
import com.restsample.webtest.PageObjects.ShippingdetailsPage;
import com.restsample.webtest.PageObjects.ShopMenu;
import com.restsample.webtest.PageObjects.SignupPage;
import com.restsample.webtest.PageObjects.home;
import com.restsample.webtest.baseWeb.base;

public class WebTest extends base{
	
	public MyData json;

	public WebDriver driver;
	
	@BeforeTest
	public void initialize() throws IOException   {
		
		driver =initializeDriver();
	}
	
	@Test (priority=1)
	public void TestRegistration() throws InterruptedException, JsonMappingException, JsonProcessingException, JSONException {
		
		home h = new home(driver);
		SignupPage signup = new SignupPage(driver);
		ShopMenu shopmenu = new ShopMenu(driver);
		ProductSearchResultsPage prodsearch = new ProductSearchResultsPage(driver);
		ProductDetailsPage proddetails = new ProductDetailsPage(driver);
		PaymentAndConfirmationPage payment = new PaymentAndConfirmationPage(driver);
		
		
		
		h.ClickSignUp();
		signup.fillCustomerDetails();
		signup.clickCreateAccount();
		shopmenu.doChooseMenTopsJacket();
		prodsearch.doClickImage();
		proddetails.doSelectProductAndAddToCart();
		signup.fillshippingDetails();
		payment.doclickPlaceOrder();
		payment.AssertConfirmation();
	}
	
	
	@AfterTest
	public void closeDriver() throws IOException {
		
		teardown();
	
	}
}
