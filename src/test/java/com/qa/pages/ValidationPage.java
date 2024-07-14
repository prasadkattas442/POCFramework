package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.base.BaseTest;

public class ValidationPage extends BaseTest {
	String producttitle;
	String productprice;
	String productcode;
	String productquantity;

	String addedproducttitle;
	String addedproductprice;
	String addedproductquantity;
	String addedproductcode;

	@FindBy(xpath = "//h1[@data-test-id='product-title']")
	WebElement Ohomsioproducttitle;

	@FindBy(xpath = "(//span[@data-test-id='product-pricing-list-sale-range-amount'])[1]")
	WebElement Ohomsioproductprice;

	@FindBy(xpath = "(//input[@data-style='qty-input'])[1]")
	WebElement Ohomsioproductquantity;

	@FindBy(xpath = "(//p[@data-test-id='sku-display'])[1]")
	WebElement Ohomsioproductcode;

	@FindBy(xpath = "//div[@class='cart-table-row-title']/a")
	WebElement addedCartproducttitle;

	@FindBy(xpath = "(//span[@class='price-amount'])[1]")
	WebElement addedCartproductprice;

	@FindBy(xpath = "(//div[@class='cart-table-row-sku'])[1]")
	WebElement addedCartproductcode;
	
	@FindBy(xpath = "//input[@id='updates[0].quantity']")
	WebElement addedCartproductquantity;

	@FindBy(xpath = "//span[text()='Order Summary']")
	WebElement orderSummarylbl;

	public ValidationPage() throws Exception {
		PageFactory.initElements(driver, this);
	}

	public void validatetitles() {
		producttitle = Ohomsioproducttitle.getText();
		System.out.println(producttitle);
		productprice = Ohomsioproductprice.getText();
		System.out.println(productprice);
        productcode = Ohomsioproductcode.getText().substring(5).trim();
		System.out.println(productcode);
	}

	public void addedcartvalidatetitles() {
		addedproducttitle = addedCartproducttitle.getText();
		System.out.println(addedproducttitle);
		addedproductprice = addedCartproductprice.getText();
		System.out.println(addedproductprice);
		addedproductcode = addedCartproductcode.getText().substring(4).trim();
		System.out.println(addedproductcode);
	}

	public void addedcartvalidations() {
		if (orderSummarylbl.isDisplayed()) {
			Assert.assertEquals(producttitle, addedproducttitle);
			Assert.assertEquals(productprice, addedproductprice);
			Assert.assertEquals(productcode, addedproductcode);
		} else {
			Assert.assertTrue(false);
		}
	}

}
