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
import com.restsample.apitest.actions.HttpOperation;
import com.restsample.apitest.listeners.ExtentTestManager;
import com.restsample.webtest.PageObjects.PaymentAndConfirmationPage;
import com.restsample.webtest.PageObjects.ProductDetailsPage;
import com.restsample.webtest.PageObjects.ProductSearchResultsPage;
import com.restsample.webtest.PageObjects.ShippingdetailsPage;
import com.restsample.webtest.PageObjects.ShopMenu;
import com.restsample.webtest.PageObjects.SignupPage;
import com.restsample.webtest.PageObjects.HomePage;
import com.restsample.webtest.baseWeb.base;

import io.restassured.RestAssured;

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
		
		HomePage h = new HomePage(driver, test);
		SignupPage signup = new SignupPage(driver, test);
		ShopMenu shopmenu = new ShopMenu(driver, test);
		ProductSearchResultsPage prodsearch = new ProductSearchResultsPage(driver, test);
		ProductDetailsPage proddetails = new ProductDetailsPage(driver, test);
		PaymentAndConfirmationPage payment = new PaymentAndConfirmationPage(driver, test);
		
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
	
	@Test
	public void Any_APi_Test(Method method) {
		ExtentTest test = ExtentTestManager.startTest(method.getName(), "Description: Valid Login Scenario with username and password.");
		
		  getLoginToken();
		  init(RestAssured.baseURI + "api/", HttpOperation.GET);
		  ExtentTestManager.getTest().log(LogStatus.INFO, RestAssured.baseURI + "/api/users?page=2");
		  callIt();
		  assertIt(200);
		  ExtentTestManager.getTest().log(LogStatus.INFO, "Asserting response code");
	}
	
	@Test
	public void ThisFails(Method method) {
		ExtentTest test = ExtentTestManager.startTest(method.getName(), "Description: Valid Login Scenario with username and password.");
		assertTrue(false);
	}
	@AfterTest
	public void closeDriver() throws IOException {
		
		teardown();
	
	}
}
