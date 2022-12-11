package com.restsample.apitest.JSONProperties;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;




public class MyData{
	  private List<Results> results; 
	  private Info info; 

	  public List<Results> getResults(){
	  	return results; 
	  }
	  public void setResults(List<Results> input){
	  	 this.results = input;
	  }
	  public Info getInfo(){
	  	return info; 
	  }
	  public void setInfo(Info input){
	  	 this.info = input;
	  }
}