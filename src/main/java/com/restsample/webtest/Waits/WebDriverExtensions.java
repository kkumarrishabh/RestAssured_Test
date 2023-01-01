package com.restsample.webtest.Waits;

import java.net.http.HttpRequest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverExtensions {

	public static void WaitForElementToBeClickable(WebDriver driver, By element, int timeOut) {
		try {
			new WebDriverWait(driver, timeOut).until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception ex) {
			throw ex;
		}
	}

	public static void waitAndClick(WebDriver driver, By locator, int timeOut) {

		WaitForElementToBeClickable(driver, locator, timeOut);
		try {
			driver.findElement(locator).click();
		} catch (Exception ex) {
			throw ex;
		}

	}
	
	public static void EnterText(WebDriver driver, By locator, String value, int timeOut)
    {
        try
        {
        	
            WaitForElementPresent(driver, locator, timeOut);
            
            driver.findElement(locator).clear();
            driver.findElement(locator).sendKeys(value);

        }
        catch (Exception ex)
        {
            
            throw ex;
        }
    }

	public static void WaitForElementPresent(WebDriver driver, By locator, int timeOut) {
		try
        {
            new WebDriverWait(driver, timeOut)
               .until(ExpectedConditions.presenceOfElementLocated(locator));
        }
        catch (Exception ex)
        {
            throw ex;
        }	
	}

	public static void WaitHoverAndClick(WebDriver driver, By locatorToHover, By locatorToClick, int timeOut) {
		try
        {
			WaitForElementPresent(driver, locatorToHover, timeOut);
			WebElement elementToHover = driver.findElement(locatorToHover);
			WebElement elementToClick = driver.findElement(locatorToClick);
            Actions action = new Actions(driver);
            action.moveToElement(elementToHover).build().perform();
            WaitForElementToBeClickable(driver, locatorToClick, timeOut);
            action.moveToElement(elementToClick).click().build().perform();
        }
        catch (Exception ex)
        {
            throw ex;
        }

	}

	public static void Hover(WebDriver driver, By locator, int timeOut)
    {
		try
        {
			WaitForElementPresent(driver, locator, timeOut);
			WebElement elementToHover = driver.findElement(locator);
            Actions action = new Actions(driver);
            action.moveToElement(elementToHover).build().perform();
        }
        catch (Exception ex)
        {
            throw ex;
        }
    }
	
	public static void SelectDropDown(WebDriver driver, By locator, String value)
    {
        try
        {
        	WebElement element = driver.findElement(locator);
            Select ddl = new Select(element);
            ddl.selectByValue(value);
        }
        catch (Exception ex)
        {
            
            throw ex;
        }
    }
	
	public static void SelectRadioButton(WebDriver driver, By locator, int timeout)
    {
        try
        {
            WaitForElementPresent(driver, locator, timeout);
            WebElement element = driver.findElement(locator);
            if (!element.isSelected())
            {
                element.click();
            }
        }
        catch (Exception ex)
        {

            throw ex;
        }
    }
	
	public static String GetText(WebDriver driver, By locator, int timeOut)
    {
        try
        {
            WaitForElementPresent(driver, locator, timeOut);
            return driver.findElement(locator).getText();
        }
        catch (Exception ex)
        {

            throw ex;
        }
    }
	public static void WaitForPageLoad(WebDriver driver, int timeOut)
	{
	
    for (int i=0; i<timeOut; i++){
       try {
          Thread.sleep(1000);
          JavascriptExecutor j = (JavascriptExecutor)driver;
          if (!j.executeScript("return document.readyState").toString().equals("complete")) continue;
          else break;
          }
    catch (InterruptedException ex) {
       }
    }
	}
	
	public static void WaitTillLoader(WebDriver driver, By locator, int timeOut)
	{
	
		try
        {
            new WebDriverWait(driver, timeOut)
               .until(ExpectedConditions.invisibilityOf(driver.findElement(locator)));
        }
        
        catch (Exception ex)
        {
            throw ex;
        }	
    }



}
