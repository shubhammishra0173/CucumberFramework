package PageObejct;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
public LoginPage(WebDriver driver) {
		
		this.driver = driver;
	}
public WebDriver driver;

By loginlink = By.cssSelector("a[href*='sign_in']");
By username = By.cssSelector("input[id*='user_email']");
By password = By.cssSelector("input[id*='user_password']");
By loginbtn = By.cssSelector("input[value*='Log In']");
public WebElement getlogin()
{
return driver.findElement(loginlink);	
}
public WebElement getusername()
{
return driver.findElement(username);	
}
public WebElement getpasword()
{
return driver.findElement(password);	
}
public WebElement getloginbtn()
{
return driver.findElement(loginbtn);	
}
}
