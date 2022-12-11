package com.restsample.apitest.utilities;


import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

import org.json.JSONException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.relevantcodes.extentreports.LogStatus;
import com.restsample.apitest.JSONProperties.MyData;
import com.restsample.apitest.actions.HttpOperation;
import com.restsample.apitest.baseAPI.Auth;
import com.restsample.apitest.listeners.ExtentTestManager;

import io.restassured.RestAssured;



public class Helper {
	String  path;

	public String loadProperties(String property) {
		Properties prop = new Properties();
		InputStream input;
		try {
			input = new FileInputStream(path);
			
			// load a properties file
			
			prop.load(input);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return prop.getProperty(property);
	}

	public  Helper set_path(String path2) {
		path = path2;
		return this;
	}
	
	public MyData ApiRequestTest(Method method) throws JSONException, JsonMappingException, JsonProcessingException {
		  ExtentTestManager.startTest("Test1", "This is a test");
		  Auth response = new Auth();
		  MyData data = null;
		  try {
			  response.getLoginToken();
			  response.init(RestAssured.baseURI + "api/", HttpOperation.GET);
			  ExtentTestManager.getTest().log(LogStatus.INFO, RestAssured.baseURI + "/api/users?page=2");
			  response.callIt();
			  response.assertIt(200);
			  ExtentTestManager.getTest().log(LogStatus.INFO, "Asserting response code");
			  ObjectMapper mapper = new ObjectMapper();
			  mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			  String str = response.getResponseString();
			  data = mapper.readerFor(MyData.class).readValue(str);
			  }
			  catch(AssertionError e){
			  ExtentTestManager.getTest().log(LogStatus.FAIL,"Assertion Failure: "
			  +e.getMessage()); }
				  
		  	  return data;
	  }
}