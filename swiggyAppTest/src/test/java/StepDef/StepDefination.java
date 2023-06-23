package StepDef;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.cucumber.java.Scenario;
import io.cucumber.java.AfterStep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class StepDefination {
	 WebDriver driver;
	
	@Given("User launch Chrome browser")
	public void user_launch_chrome_browser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Drivers\\chromedriver\\Chromdriver 113\\chromedriver_win32 (1)\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        
	    System.out.println("User launch Chrome browser");
	}
	

	@When("User opens URL")
	public void user_opens_url() {
//		String currentURL  = driver.getCurrentUrl();
//        System.out.println(currentURL);
        driver.get("https://www.swiggy.com");
		System.out.println("User opens URL");
	}
	
   @When("User click on more")
	public void user_click_on_more() {
	   WebElement clickmore = driver.findElement(By.xpath("//a[normalize-space()='& more.']"));
       clickmore.click();
		 System.out.println("User click on more");
	}
	@When("Select a City")
	public void select_a_city()throws InterruptedException  {
        WebElement citybtn = driver.findElement(By.xpath("//a[normalize-space()='ahmednagar']"));
        citybtn.click(); 
        Thread.sleep(2000);
		 System.out.println("Select a City");
	}
	@When("I scroll down to view more options")
	public void i_scroll_down_to_view_more_options() throws InterruptedException {
		driver.get("https://www.swiggy.com/city/ahmednagar");
    	JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,650)");
        System.out.println("scrolldown");
        Thread.sleep(2000);
		 System.out.println("I scroll down to view more options");
	}
	@When("I select the hotel")
	public void i_select_the_hotel() {
		 WebElement hotelbtn = driver.findElement(By.cssSelector("img[alt=\"McDonald's\"]"));
	        hotelbtn.click();
		System.out.println("I select the hotel");
	}
	@Then("User select Food")
	public void user_select_food()throws InterruptedException  {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,650)");
        System.out.println("scrolldown");
        Thread.sleep(2000);
       WebElement productbtn = driver.findElement(By.cssSelector("body > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(7) > div:nth-child(1) > div:nth-child(2) > div:nth-child(4) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > button:nth-child(1)"));
       productbtn.click();
       Thread.sleep(2000);
		 System.out.println("User select Food");
	}
	

	@Then("close the browser")
	public void close_the_browser() {
		driver.quit() ;
		System.out.println("close the browser");
	}

	@AfterStep
	public void addScreenshot(Scenario scenario){

		if(scenario.isFailed())
		{
		final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		//attach image file report(data, media type, name of the attachment)
		scenario.attach(screenshot, "image/png", scenario.getName());
		}
	}





}
