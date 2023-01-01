package com.restsample.apitest.businessLogics;

import static org.testng.Assert.assertTrue;
import java.lang.reflect.Method;

import java.io.IOException;

import org.json.JSONException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.restsample.apitest.JSONProperties.MyData;
import com.restsample.apitest.listeners.ExtentTestManager;
import com.restsample.webtest.PageObjects.PaymentAndConfirmationPage;
import com.restsample.webtest.PageObjects.ProductDetailsPage;
import com.restsample.webtest.PageObjects.ProductSearchResultsPage;
import com.restsample.webtest.PageObjects.ShippingdetailsPage;
import com.restsample.webtest.PageObjects.ShopMenu;
import com.restsample.webtest.PageObjects.SignupPage;
import com.restsample.webtest.PageObjects.home;
import com.restsample.webtest.baseWeb.base;

@Listeners(com.restsample.apitest.listeners.TestStatusListener.class)  
public class WebTest extends base{
	
	public MyData json;

	public WebDriver driver;
	
	@BeforeTest
	public void initialize() throws IOException   {
		
		driver =initializeDriver();
	}
	
	@Test
	public void TestRegistration(Method method) throws InterruptedException, JsonMappingException, JsonProcessingException, JSONException {
		
		ExtentTest test = ExtentTestManager.startTest(method.getName(), "Description: Valid Login Scenario with username and password.");
		
		home h = new home(driver);
		SignupPage signup = new SignupPage(driver);
		ShopMenu shopmenu = new ShopMenu(driver);
		ProductSearchResultsPage prodsearch = new ProductSearchResultsPage(driver);
		ProductDetailsPage proddetails = new ProductDetailsPage(driver);
		PaymentAndConfirmationPage payment = new PaymentAndConfirmationPage(driver);
		
		h.ClickSignUp();
		ExtentTestManager.getTest().log(LogStatus.INFO, "Signup is success");
		signup.fillCustomerDetails();
		ExtentTestManager.getTest().log(LogStatus.INFO, "Fill details is success");
		signup.clickCreateAccount(); 
		ExtentTestManager.getTest().log(LogStatus.INFO, "Create Account");
		shopmenu.doChooseMenTopsJacket();
		prodsearch.doClickImage();
		proddetails.doSelectProductAndAddToCart();
		ExtentTestManager.getTest().log(LogStatus.INFO, "Product added to cart");
		signup.fillshippingDetails(); 
		payment.doclickPlaceOrder();
		ExtentTestManager.getTest().log(LogStatus.INFO, "Placing Order now");
		payment.AssertConfirmation();
	}
	
	
	@AfterTest
	public void closeDriver() throws IOException {
		
		teardown();
	
	}
}
