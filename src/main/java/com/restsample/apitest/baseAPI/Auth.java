package com.restsample.apitest.baseAPI;

import com.restsample.apitest.actions.HttpOperation;
import com.restsample.apitest.restassuredFuntions.API;

public class Auth extends API{
		
    public Auth(){}

	private void createToken() {
		initBase("Host");
		//This is the place holder for generating login token if any. This Method can be parameterised with username and password
	}
	
	public String getLoginToken() {
		createToken();
		//System.out.println(response);
		return " ";
	}
	
}
