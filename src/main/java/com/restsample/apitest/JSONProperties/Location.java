package com.restsample.apitest.JSONProperties;

public class Location{
	  private Street street; 
	  private String city; 
	  private String state; 
	  private String country; 
	  private int postcode; 
	  private Coordinates coordinates; 
	  private Timezone timezone; 

	  public Street getStreet(){
	  	return street; 
	  }
	  public void setStreet(Street input){
	  	 this.street = input;
	  }
	  public String getCity(){
	  	return city; 
	  }
	  public void setCity(String input){
	  	 this.city = input;
	  }
	  public String getState(){
	  	return state; 
	  }
	  public void setState(String input){
	  	 this.state = input;
	  }
	  public String getCountry(){
	  	return country; 
	  }
	  public void setCountry(String input){
	  	 this.country = input;
	  }
	  public int getPostcode(){
	  	return postcode; 
	  }
	  public void setPostcode(int input){
	  	 this.postcode = input;
	  }
	  public Coordinates getCoordinates(){
	  	return coordinates; 
	  }
	  public void setCoordinates(Coordinates input){
	  	 this.coordinates = input;
	  }
	  public Timezone getTimezone(){
	  	return timezone; 
	  }
	  public void setTimezone(Timezone input){
	  	 this.timezone = input;
	  }
}
