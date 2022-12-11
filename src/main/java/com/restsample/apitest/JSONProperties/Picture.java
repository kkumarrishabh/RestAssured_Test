package com.restsample.apitest.JSONProperties;

public class Picture{
	  private String large; 
	  private String medium; 
	  private String thumbnail; 

	  public String getLarge(){
	  	return large; 
	  }
	  public void setLarge(String input){
	  	 this.large = input;
	  }
	  public String getMedium(){
	  	return medium; 
	  }
	  public void setMedium(String input){
	  	 this.medium = input;
	  }
	  public String getThumbnail(){
	  	return thumbnail; 
	  }
	  public void setThumbnail(String input){
	  	 this.thumbnail = input;
	  }
}
