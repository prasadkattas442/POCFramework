package com.qa.base;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import com.qa.util.ConfigReader;
import com.qa.util.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest extends ConfigReader {	

	 public static WebDriver driver;	
	 @BeforeSuite
	public static void driverinitialization() throws Exception
	{	
	configprop();
	String browserName=prop.getProperty("browser");
	if(browserName.equals("Chrome")){
	    WebDriverManager.chromedriver().setup();
	    driver=new ChromeDriver();
	}
	else if(browserName.equals("FireFox")){
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
	}
	else if(browserName.equals("IE")){
		WebDriverManager.iedriver().setup();   
	    driver=new InternetExplorerDriver();
	}
	else {
        throw new IllegalArgumentException("Browser [" + browserName + "] is not supported.");
    }
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
	driver.get(prop.getProperty("url"));
	
//	Robot rb = new Robot();
//	//Enter user name by ctrl-v
//	StringSelection username = new StringSelection("wsqaenv");
//	Toolkit.getDefaultToolkit().getSystemClipboard().setContents(username, null);
//	rb.keyPress(KeyEvent.VK_CONTROL);
//	rb.keyPress(KeyEvent.VK_V);
//	rb.keyRelease(KeyEvent.VK_V);
//	rb.keyRelease(KeyEvent.VK_CONTROL);
//	//tab to password entry field
//	rb.keyPress(KeyEvent.VK_TAB);
//	rb.keyRelease(KeyEvent.VK_TAB);
//	Thread.sleep(2000);
//	//Enter password by ctrl-v
//	StringSelection pwd = new StringSelection("S7nfl#we");
//	Toolkit.getDefaultToolkit().getSystemClipboard().setContents(pwd, null);
//	rb.keyPress(KeyEvent.VK_CONTROL);
//	rb.keyPress(KeyEvent.VK_V);
//	rb.keyRelease(KeyEvent.VK_V);
//	rb.keyRelease(KeyEvent.VK_CONTROL);
//	//press enter
//	rb.keyPress(KeyEvent.VK_ENTER);
//	rb.keyRelease(KeyEvent.VK_ENTER);	
	System.out.println(driver.getTitle());
	}
	 
	public void waitForVisibility(WebElement locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(locator));
//		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(30));
//		wait2.until(ExpectedConditions.alertIsPresent());
//	    Alert alert = driver.switchTo().alert();
//	    alert.sendKeys("username" + Keys.TAB + "password");
//	    alert.accept();
	 
	}
    

}
