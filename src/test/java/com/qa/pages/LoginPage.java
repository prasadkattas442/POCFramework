package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.base.BaseTest;

public class LoginPage extends BaseTest  {
	// Page elements using @FindBy annotation     
    @FindBy(xpath = "//li[@id=\"my-account\"]")
    WebElement accountmouseover;
    
    @FindBy(xpath = "//ul[@id=\"myaccount-submenu\"]//li/a[text()='Sign In']")
    WebElement SignInbtn;
    
    @FindBy(xpath = "//input[@id=\"email\"]")
    WebElement emailtxt;
  
    @FindBy(xpath = "//button[@id=\"accountLoginButton\"]")
    WebElement  continuebtn ;
  
    @FindBy(xpath = "//input[@id=\"password\"]")
    WebElement  passwordtxt ;
    
    @FindBy(xpath = "//button[@id=\"accountLoginButton\"]")
    WebElement  accountLoginbtn ;     

    public LoginPage() throws Exception {     	
        PageFactory.initElements(driver, this);
    }
    
    public void enterEmail(String un) 
    {
    	emailtxt.sendKeys(un);    	
    	continuebtn.click();
    }
    public void enterPassword(String pwd) 
    {    	
    	passwordtxt.sendKeys(pwd);
    	accountLoginbtn.click();
    }	
    public void clickOnNew() {
    //	waitForVisibility(SignInbtn);    	
        Actions act = new Actions(driver);
        act.moveToElement(accountmouseover).build().perform();        
        SignInbtn.click();
    }
}













