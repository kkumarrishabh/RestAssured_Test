package com.restsample.apitest.JSONProperties;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;




public class MyData{
	  private int page; 
	  private int perPage; 
	  private int total; 
	  private int totalPages; 
	  private List<Data> data; 
	  private Support support; 

	  public int getPage(){
	  	return page; 
	  }
	  public void setPage(int input){
	  	 this.page = input;
	  }
	  public int getPerPage(){
	  	return perPage; 
	  }
	  public void setPerPage(int input){
	  	 this.perPage = input;
	  }
	  public int getTotal(){
	  	return total; 
	  }
	  public void setTotal(int input){
	  	 this.total = input;
	  }
	  public int getTotalPages(){
	  	return totalPages; 
	  }
	  public void setTotalPages(int input){
	  	 this.totalPages = input;
	  }
	  public List<Data> getData(){
	  	return data; 
	  }
	  public void setData(List<Data> input){
	  	 this.data = input;
	  }
	  public Support getSupport(){
	  	return support; 
	  }
	  public void setSupport(Support input){
	  	 this.support = input;
	  }
}