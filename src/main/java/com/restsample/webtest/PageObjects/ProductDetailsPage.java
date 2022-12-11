package com.restsample.webtest.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.restsample.apitest.JSONProperties.MyData;
import com.restsample.webtest.Waits.WebDriverExtensions;

public class ProductDetailsPage {

public WebDriver driver;	
	
public ProductDetailsPage (WebDriver driver) {
	this.driver=driver;
}
	By ProductSize = By.id("option-label-size-143-item-168");
	By ProductColor = By.id("option-label-color-93-item-49");
	By AddToCartButton = By.id("product-addtocart-button");
	By OpenCart = By.xpath("//a[@class='action showcart']//span[@class='counter qty']");
	By CheckoutButton = By.id("top-cart-btn-checkout");
	
	public void doSelectProductAndAddToCart()
	{
		WebDriverExtensions.waitAndClick(driver, ProductSize, 90);
		WebDriverExtensions.waitAndClick(driver, ProductColor, 90);
		WebDriverExtensions.waitAndClick(driver, AddToCartButton, 90);
		WebDriverExtensions.WaitHoverAndClick(driver, OpenCart ,OpenCart, 90);
		WebDriverExtensions.waitAndClick(driver, CheckoutButton, 90);
	}
}
