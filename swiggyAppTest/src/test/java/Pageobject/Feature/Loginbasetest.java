package Pageobject.Feature;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Loginbasetest {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		
		
		
		//launch browser
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Drivers\\chromedriver\\Chromdriver 113\\chromedriver_win32 (1)\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();

        
   
   //create a object of elementtest
   
        elementtest loginpg= new elementtest(driver);
   
   //open url
        driver.get("https://www.swiggy.com");
   
   loginpg.addmore();
   loginpg.selectcity();
   loginpg.selectHotel();
  loginpg.selectproduct();
   

  
  System.out.println("test sussesfull");
  System.out.println("Page title is : " + driver.getTitle());
  
  
  Thread.sleep(7000);
  driver.quit();

	}

}
