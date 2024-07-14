package com.qa.testcases;

import org.testng.annotations.Test;
import com.qa.base.BaseTest;
import com.qa.pages.LoginPage;
import com.qa.pages.ProductPage;
import com.qa.pages.ValidationPage;

public class LoginPageTest extends BaseTest {
	LoginPage loginpage;
	ProductPage productpage;
	ValidationPage validationpage;
	@Test
	public void loginAction() throws Exception {
		loginpage=new LoginPage();
		Thread.sleep(2000);
		loginpage.clickOnNew();
		loginpage.enterEmail(prop.getProperty("username"));		
		loginpage.enterPassword(prop.getProperty("password"));
	}
//	@Test
	public void selectProductAction() throws Exception {
		productpage=new ProductPage();
		validationpage=new ValidationPage();
		productpage.selectOnProduct();
		productpage.clickOnFilter();
		productpage.clickOnProduct();
		validationpage.validatetitles();
		productpage.clickOnAddtoCart();		
		productpage.viewCartcheckout();
		validationpage.addedcartvalidatetitles();
		validationpage.addedcartvalidations();
		productpage.finalCheckoutbtn();
	}
	
}









