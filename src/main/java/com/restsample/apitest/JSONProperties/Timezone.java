package com.restsample.apitest.JSONProperties;


public class Timezone{
	  private String offset; 
	  private String description; 

	  public String getOffset(){
	  	return offset; 
	  }
	  public void setOffset(String input){
	  	 this.offset = input;
	  }
	  public String getDescription(){
	  	return description; 
	  }
	  public void setDescription(String input){
	  	 this.description = input;
	  }
}
