package com.restsample.apitest.JSONProperties;

public class Login{
	  private String uuid; 
	  private String username; 
	  private String password; 
	  private String salt; 
	  private String md5; 
	  private String sha1; 
	  private String sha256; 

	  public String getUuid(){
	  	return uuid; 
	  }
	  public void setUuid(String input){
	  	 this.uuid = input;
	  }
	  public String getUsername(){
	  	return username; 
	  }
	  public void setUsername(String input){
	  	 this.username = input;
	  }
	  public String getPassword(){
	  	return password; 
	  }
	  public void setPassword(String input){
	  	 this.password = input;
	  }
	  public String getSalt(){
	  	return salt; 
	  }
	  public void setSalt(String input){
	  	 this.salt = input;
	  }
	  public String getMd5(){
	  	return md5; 
	  }
	  public void setMd5(String input){
	  	 this.md5 = input;
	  }
	  public String getSha1(){
	  	return sha1; 
	  }
	  public void setSha1(String input){
	  	 this.sha1 = input;
	  }
	  public String getSha256(){
	  	return sha256; 
	  }
	  public void setSha256(String input){
	  	 this.sha256 = input;
	  }
}