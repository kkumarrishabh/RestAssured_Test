package com.restsample.apitest.JSONProperties;

public class Info{
	  private String seed; 
	  private int results; 
	  private int page; 
	  private String version; 

	  public String getSeed(){
	  	return seed; 
	  }
	  public void setSeed(String input){
	  	 this.seed = input;
	  }
	  public int getResults(){
	  	return results; 
	  }
	  public void setResults(int input){
	  	 this.results = input;
	  }
	  public int getPage(){
	  	return page; 
	  }
	  public void setPage(int input){
	  	 this.page = input;
	  }
	  public String getVersion(){
	  	return version; 
	  }
	  public void setVersion(String input){
	  	 this.version = input;
	  }
}
