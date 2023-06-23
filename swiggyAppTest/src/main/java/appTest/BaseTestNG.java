package appTest;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.awt.Window;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class BaseTestNG {
    WebDriver driver;
    
    
   

    @BeforeTest
    public void LaunchBrowser() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Drivers\\chromedriver\\Chromdriver 113\\chromedriver_win32 (1)\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        String currentURL  = driver.getCurrentUrl();
        System.out.println(currentURL);
        driver.get("https://www.swiggy.com");
    }

    @Test(priority=1)
    public void addmore() throws InterruptedException   {
        WebElement clickmore = driver.findElement(By.xpath("//a[normalize-space()='& more.']"));
        clickmore.click();
      }
    
    @Test(priority=2)
    public void selectcity() throws InterruptedException    {
        WebElement citybtn = driver.findElement(By.xpath("//a[normalize-space()='ahmednagar']"));
        citybtn.click(); 
        Thread.sleep(2000);
     }
     @Test(priority=3)
    public void selectHotel() throws InterruptedException    {
    	
    	//switch to different url
    	
    	driver.get("https://www.swiggy.com/city/ahmednagar");
    	JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,650)");
        System.out.println("scrolldown");
        Thread.sleep(2000);
       WebElement hotelbtn = driver.findElement(By.cssSelector("img[alt=\"McDonald's\"]"));
        hotelbtn.click();
        System.out.println("hotel selected");
    }
     @Test(priority=4)
     public void selectproduct() throws InterruptedException    {
     	
     	//switch to different url
     	
//     	driver.get("https://www.swiggy.com/restaurants/mcdonalds-kedgaon-kadegaon-ahmednagar-608343");
     	JavascriptExecutor jse = (JavascriptExecutor)driver;
         jse.executeScript("window.scrollBy(0,650)");
         System.out.println("scrolldown");
         Thread.sleep(2000);
        WebElement productbtn = driver.findElement(By.cssSelector("body > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(7) > div:nth-child(1) > div:nth-child(2) > div:nth-child(4) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > button:nth-child(1)"));
        productbtn.click();
        Thread.sleep(2000);
        String Title=driver.getTitle();
        
        System.out.println("Title of product"+Title);
        
         }
    @ AfterTest
     public void closebrowser()
     {
    	driver.quit() ;
     }
     


}