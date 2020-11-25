package PageObejct;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
public LandingPage(WebDriver driver) {
		
		this.driver = driver;
	}
public WebDriver driver;

private By loginlink = By.cssSelector("a[href*='sign_in']");
private By title = By.xpath("//h2[text()='Featured Courses']");
private By navigationBar =By.xpath("//a[text()='Courses']");
public WebElement getlogin()

{
return driver.findElement(loginlink);	
}
public WebElement gettitle()

{
return driver.findElement(title);	
}
public WebElement getNavigationBar()

{
return driver.findElement(navigationBar);	
}
}
