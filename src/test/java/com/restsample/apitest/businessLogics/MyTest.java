package com.restsample.apitest.businessLogics;

import org.testng.annotations.Test;
import org.json.*;

import com.restsample.apitest.JSONProperties.MyData;
import com.restsample.apitest.actions.HttpOperation;
import com.restsample.apitest.actions.ValidatorOperation;
import com.restsample.apitest.baseAPI.Auth;
import com.restsample.apitest.listeners.ExtentTestManager;

import io.restassured.RestAssured;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.relevantcodes.extentreports.LogStatus;
import java.lang.reflect.Method;



public class MyTest {
	
  //String response;

  @Test
  public void ApiRequestTest(Method method) throws JSONException, JsonMappingException, JsonProcessingException {
	  ExtentTestManager.startTest(method.getName(), "This is a test");
	  Auth response = new Auth();
	  
	  try {
		  response.getLoginToken();
		  response.init(RestAssured.baseURI + "/api/users?page=2", HttpOperation.GET);
		  ExtentTestManager.getTest().log(LogStatus.INFO, RestAssured.baseURI + "/api/users?page=2");
		  response.callIt();
		  response.assertIt(200);
		  ExtentTestManager.getTest().log(LogStatus.INFO, "Asserting response code");
		  response.printResp();
		  MyData data = null;
		  ObjectMapper mapper = new ObjectMapper();
		  mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		  String str = response.getResponseString();
		  data = mapper.readerFor(MyData.class).readValue(str);
		  System.out.println("Answer   #### " + data.getData().get(3).getId());
		  System.out.println(data.getData().get(4).getEmail());
		  System.out.println(data.getSupport().getUrl());
		  }
		  catch(AssertionError e){
		  ExtentTestManager.getTest().log(LogStatus.FAIL,"Assertion Failure: "
		  +e.getMessage()); }
  }

}
