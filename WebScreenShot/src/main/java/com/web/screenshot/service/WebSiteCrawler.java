package com.web.screenshot.service;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import javax.imageio.ImageIO;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import java.io.ByteArrayOutputStream;


@Service
public class WebSiteCrawler {
	
	 private WebDriver driver;
	 
		@Autowired
		private Environment env;

	    public WebSiteCrawler() {
	    	
	        // Define the location of the chromedriver

	    	//System.setProperty("webdriver.chrome.driver","C://driver/chromedriver.exe"); 
	    	
	       System.setProperty("webdriver.chrome.driver",System.getenv("webdriver.chrome.driver")); 
	       
	        // Use headless mode for the ChromeDriver
	        ChromeOptions chromeOptions = new ChromeOptions();
	        chromeOptions.addArguments("--headless");
	        chromeOptions.addArguments("--no-sandbox");
	        this.driver = new ChromeDriver(chromeOptions);
	        
	        
	    }

	    public byte[] crawl(String url) {
	    	 byte[]  out=null;
	        try {
	        	System.out.println("crawling the site,pls wait!!");
	            // Navigate to the specified directory
               driver.navigate().to(url);
            
	            driver.manage().window().maximize(); 
	            
	         // Sleep for 5 seconds in case the website has not fully loaded   
	           Thread.sleep(5000);
	          
	            //take screenshot of the entire page             
	            Screenshot screenshot=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);             
	            ByteArrayOutputStream bos = new ByteArrayOutputStream();           
	            ImageIO.write(screenshot.getImage(),"PNG",bos);   
	            
	            //convert to byte array
	            out = bos.toByteArray();
          
	  	    	 
	          return out;
	          } catch (Exception e) {                                
	            e.printStackTrace();        
	            } 
	            
	        return out;
	        
	    }
	    
	    public void close() {
	        // Close after completion
	        driver.close();
	    }
	    
	    


}
