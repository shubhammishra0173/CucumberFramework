package Academy;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObejct.LandingPage;
import PageObejct.LoginPage;
import resources.Base;

public class ValidateNavigationBar extends Base{
	public WebDriver driver;
	@BeforeTest
	public void initializebrowser() {
		driver= initalizeDriver();
		driver.get(prop.getProperty("url"));
	}
@Test
public void BasePageNavigation() throws IOException
{
	try {
		
		/*driver= initalizeDriver();
		driver.get(prop.getProperty("url"));*/
		// one is inheritence
		// using object of class
		LandingPage lp = new LandingPage(driver);
	//	lp.getlogin().click();
		/*LoginPage li = new LoginPage(driver);
		li.getusername().sendKeys(username);
		Thread.sleep(6000);
		li.getpasword().sendKeys(password);
		li.getloginbtn().click();*/
	//System.out.println(text);
		Assert.assertEquals(lp.gettitle().getText(), "FEATURED COURSES");
		//lp.getNavigationBar().isDisplayed();
		
		Assert.assertTrue(lp.getNavigationBar().isDisplayed());
	}
	catch(Exception e)
	{
	e.getMessage();	
	}
	driver.quit();
	}
@DataProvider
public Object[][] getData()
{
	Object [][] data = new Object[2][2];
	//0th row
	data[0][0] ="nonrestriceteduser@qv.com";
	data[0][1] = "123456";
	//data[0][2]="restricted user";
	//1st row
	data[1][0] ="restriceteduser@qv.com";
	data[1][1] = "123456";
	//data[1][2]="non restricted user";
	return data;
	}
@AfterTest
public void teardown()
{
driver.close();	
}
}
