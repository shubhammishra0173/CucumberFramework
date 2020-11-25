package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public class Base {
	public static WebDriver driver;
 public Properties prop;
	public WebDriver initalizeDriver()
	{ try {
		 prop = new Properties();
		 //System.getProperty("user.dir")
		//FileInputStream fis = new FileInputStream("D:\\oxygenworkspace\\E2EProject\\src\\main\\java\\resources\\data.properties");
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		String browserName = System.getProperty("browser");// This is for mavnen when we call browser from Maven cmd
	//	String browserName =prop.getProperty("browser");
       System.out.println(prop.getProperty("browser"));
       /*if(browserName.equalsIgnoreCase("chrome"))
       {
    	   
    	   System.setProperty("webdriver.chrome.driver", "D:\\oxygenworkspace\\E2EProject\\drivers\\chromedriver.exe");
    	   ChromeOptions ch = new ChromeOptions();
    	   ch.addArguments("headless");// Headless run of Chrome
    	   
    	   driver = new ChromeDriver(ch);
       }*/
       // Thus mehtod is for headless mode
       if(browserName.contains("chrome"))
       {
    	   System.setProperty("webdriver.chrome.driver", "D:\\oxygenworkspace\\E2EProject\\drivers\\chromedriver.exe");
       	 ChromeOptions options =new ChromeOptions();
       	 if(browserName.contains("headless"))
       	 {
       	  options.addArguments("headless");
       	 }
       driver= new ChromeDriver(options);
       		//execute in chrome driver
       	
       }
       else if(browserName.equalsIgnoreCase("firefox"))
       {
    	   System.setProperty("webdriver.gecko.driver", "D:\\oxygenworkspace\\E2EProject\\drivers\\geckodriver.exe");
    	   driver = new FirefoxDriver();
       }
       else if(browserName.equalsIgnoreCase("IE"))
       {
    	   System.setProperty("webdriver.internetexplorer.driver", "D:\\oxygenworkspace\\E2EProject\\drivers\\IEDriverServer.exe");
    	  driver = new InternetExplorerDriver();   
       }
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      
       
	}
	
	catch(Exception e)
	{
		
	}
	 return driver;
	}
	public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(source,new File(destinationFile));
		return destinationFile;


	}
}
