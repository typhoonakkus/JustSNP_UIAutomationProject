package Utility;


import Base.DriverManager;
import Utility.Util.TimeOut;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.ByteArrayInputStream;
import java.time.Duration;
import java.util.List;

public class Find extends DriverManager {
	
	public enum Locator {

		ID,
		CLASS_NAME,
		NAME,
		XPATH,
		CSS_SELECTOR,
		LINK_TEXT
	}
	


	public static WebElement Element(Locator type, String locator, TimeOut timeOut) {

			try {

				WebDriverWait wait = new WebDriverWait(webDriver.get(), Duration.ofSeconds(timeOut.getValue()));

				WebElement element = null;

				switch (type) {

					case CLASS_NAME:
						System.out.println("Start find element by className ! ********* " + type);
						element = wait.until(ExpectedConditions.presenceOfElementLocated(By.className(locator)));
						System.out.println(element);
						Allure.addAttachment("classNameElement",new ByteArrayInputStream(Util.takeScreenShot()));
						break;

					case ID:
						System.out.println("Start find element by id ! ********* " + type);
						element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(locator)));
						Allure.addAttachment("IdElement",new ByteArrayInputStream(Util.takeScreenShot()));
						System.out.println(element);
						break;

					case NAME:
						System.out.println("Start find element by name ! ********* " + type);
						element = wait.until(ExpectedConditions.presenceOfElementLocated(By.name(locator)));
						Allure.addAttachment("NameElement",new ByteArrayInputStream(Util.takeScreenShot()));
						System.out.println(element);
						break;

					case XPATH:
						System.out.println("Start find element by xPath ! ********* " + type);
						element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
						Allure.addAttachment("XPathElement",new ByteArrayInputStream(Util.takeScreenShot()));
						System.out.println(element);
						break;

					case CSS_SELECTOR:
						System.out.println("Start find element by cssSelector ! ********* " + type);
						element = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(locator)));
						Allure.addAttachment("CssElement",new ByteArrayInputStream(Util.takeScreenShot()));
						System.out.println(element);
						break;

					case LINK_TEXT:
						System.out.println("Start find element by LinkText ! ********* " + type);
						element = wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(locator)));
						Allure.addAttachment("LinkTextElement",new ByteArrayInputStream(Util.takeScreenShot()));
						System.out.println(element);
						break;

					default:

						throw new NotFoundException("The Locator Type you specified was not recognized: !!!!!!!" + type);
				}
				System.out.println("FOUND Element!!!! ******* ");
				return element;
			}

			catch (Exception e)
			{
				System.out.println("Element Not FOUND !!!!******* " + e);
				Allure.addAttachment("ElementNotFoundScrn",new ByteArrayInputStream(Util.takeScreenShot()));
				Allure.addAttachment("Error","Element Not FOUND !!!!*******");
				return null;
			}

	}

	public static List<WebElement> Elements(Locator type, String locator, TimeOut timeOut) {
		try {
			WebDriverWait wait = new WebDriverWait(webDriver.get(), Duration.ofSeconds(timeOut.getValue()));

			List<WebElement> elements = null;

			switch (type) {
				case CLASS_NAME:
					System.out.println("Start find elements by className ! ********* " + type);
					elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className(locator)));
					Allure.addAttachment("ClassNameElements", new ByteArrayInputStream(Util.takeScreenShot()));
					break;

				case ID:
					System.out.println("Start find elements by id ! ********* " + type);
					elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id(locator)));
					Allure.addAttachment("IdElements", new ByteArrayInputStream(Util.takeScreenShot()));
					break;

				case NAME:
					System.out.println("Start find elements by name ! ********* " + type);
					elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.name(locator)));
					Allure.addAttachment("NameElements", new ByteArrayInputStream(Util.takeScreenShot()));
					break;

				case XPATH:
					System.out.println("Start find elements by xPath ! ********* " + type);
					elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(locator)));
					Allure.addAttachment("XPathElements", new ByteArrayInputStream(Util.takeScreenShot()));
					break;

				case CSS_SELECTOR:
					System.out.println("Start find elements by cssSelector ! ********* " + type);
					elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(locator)));
					Allure.addAttachment("CssElements", new ByteArrayInputStream(Util.takeScreenShot()));
					break;

				case LINK_TEXT:
					System.out.println("Start find elements by LinkText ! ********* " + type);
					elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.linkText(locator)));
					Allure.addAttachment("LinkTextElements", new ByteArrayInputStream(Util.takeScreenShot()));
					break;

				default:
					throw new NotFoundException("The Locator Type you specified was not recognized: !!!!!!!" + type);
			}

			System.out.println("FOUND Elements!!!! ******* Count: " + (elements != null ? elements.size() : 0));
			return elements;

		}
		catch (Exception e)
		{
			System.out.println("Elements Not FOUND !!!!******* " + e);
			Allure.addAttachment("ElementsNotFoundScrn", new ByteArrayInputStream(Util.takeScreenShot()));
			return null;
		}
	}
	
	/*public static WebElement Element (WebDriver driver , By locator ) {
		
		
	       try {
					            
	            WebDriverWait wait = new WebDriverWait((WebDriver) webDriver.get(),10);
	            List<WebElement> visibleElements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));	 
	            if(visibleElements.size() != 0){
	                element = visibleElements.get(0);
	                
	                System.out.println("OBJECT IS LOCATED: ");
	            }
	            
			} catch (Exception e) {
		        System.out.println("LOCATE OBJECT EXCEPTION: " + e + locator);
		       
			}
	      
		
		return element;
		
	}*/
	
	
	

  /*  public static WebElement FindWebElement(WebDriver driver, By locator)
    {
    	
    	System.out.println(Thread.currentThread().getStackTrace()[1].getClassName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + " function started..." );
        try {
        	
        	
		
		        // Return it if you find.
		        if(locateTheObject(driver, locator)) {
		        	System.out.println("OBJECT FOUNDDDD" + foundObject);
		        }       
		
	        	
	        // Throw an exception if you still can't find it.
	        if (foundObject == null) {
		        System.out.println("fail: " + locator + " is not found: " + foundObject);
			}
	        return foundObject;
		} catch (Exception e) {
            System.out.println("An error occured while finding webelement : " + e.getMessage());
            return null;
		}
    }

    private static Boolean locateTheObject (WebDriver driver, By locator){
        System.out.println(Thread.currentThread().getStackTrace()[1].getClassName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + " function started..." );
        try {
			foundObject = null;
            Boolean result = false;
            WebDriverWait wait = new WebDriverWait(driver, 10);
            List<WebElement> visibleElements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
            System.out.println("visibleElements SIZE: " + visibleElements.size());
            if(visibleElements.size() != 0){
                foundObject = visibleElements.get(0);
                result = true;
                System.out.println("OBJECT IS LOCATED: " + result);
            }
            return result;
		} catch (Exception e) {
	        System.out.println("LOCATE OBJECT EXCEPTION: " + e);
	        return false;
		}
    }*/
	
	
	
	
	/*
	public static WebElement FindElement(String locator, String locatorValue)
    {
        WebElement element = null;
        switch (locator)
        {
            case "Id":
                By idSelector = By.id(locatorValue);
                element = Element(idSelector);
                break;

            case "Name":
            	By nameSelector = By.name(locatorValue);
                element = utils.FindHelpers.FindWebElement(driver, nameSelector, waitTimeout);
                break;

            case "XPath":
                By xpathSelector = By.xpath(locatorValue);
                element = utils.FindHelpers.FindWebElement(driver, xpathSelector, waitTimeout);
                break;

            case "Css":
                By cssSelector = By.cssSelector(locatorValue);
                element = utils.FindHelpers.FindWebElement(driver, cssSelector, waitTimeout);
                break;

            case "ClassName":
                By classNameselector = By.className(locatorValue);
                element = utils.FindHelpers.FindWebElement(driver, classNameselector, waitTimeout);
                break;

            case "LinkText":
                By linkTextSelector = By.linkText(locatorValue);
                element = utils.FindHelpers.FindWebElement(driver, linkTextSelector, waitTimeout);
                break;

            default:
                break;
        }
        return element;
    }*/

}