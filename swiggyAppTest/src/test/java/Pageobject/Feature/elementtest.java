package Pageobject.Feature;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class elementtest {
	WebDriver driver;
    

	//constructor
	public elementtest (WebDriver d)
	{
		driver = d;	
	}
	  By clickmore=By.xpath("//a[normalize-space()='& more.']");
	  By citybtn=By.xpath("//a[normalize-space()='ahmednagar']");
	  By hotelbtn=By.cssSelector("img[alt=\"McDonald's\"]");
	  By productbtn=By.cssSelector("body > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(7) > div:nth-child(1) > div:nth-child(2) > div:nth-child(4) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > button:nth-child(1)");
	 
	 
	  
	  public void addmore() {
		  driver.findElement(clickmore).click();
			
		}
	  public void selectcity() throws InterruptedException {
		  driver.findElement(citybtn).click();
		  Thread.sleep(2000);
			}
	  public void selectHotel() throws InterruptedException {
		 
	    	//switch to different url
	    	
		  driver.get("https://www.swiggy.com/city/ahmednagar");
	    	JavascriptExecutor jse = (JavascriptExecutor)driver;
	        jse.executeScript("window.scrollBy(0,750)");
	        System.out.println("scrolldown");
	        Thread.sleep(4000);
		  
		  driver.findElement(hotelbtn).click();
			
		}
	  public void selectproduct() throws InterruptedException {
			
	     JavascriptExecutor jse = (JavascriptExecutor)driver;
	         jse.executeScript("window.scrollBy(0,650)");
	         System.out.println("scrolldown");
	         Thread.sleep(2000);
		  driver.findElement(productbtn).click();
		  System.out.println("click on product"); 
		}
	
	  }

