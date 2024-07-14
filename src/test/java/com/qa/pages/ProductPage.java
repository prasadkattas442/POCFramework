package com.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.base.BaseTest;

public class ProductPage extends BaseTest {

	@FindBy(xpath = "(//li/a[text()='Electrics'])[3]")
	WebElement electricsMouseOver;

	@FindBy(xpath = "//li/a[text()='Coffee Makers']")
	WebElement coffeemakersProduct;

	@FindBy(xpath = "//button[@data-test-id=\"more-filters-button\"]")
	WebElement filtersBtn;

	@FindBy(xpath = "//label[@data-test-id=\"Price, low to high\"]")
	WebElement pricelowtohighRadiobtn;

	@FindBy(xpath = "(//label[@data-test-id='Cold Brew Coffee Makers'])[2]")
	WebElement dripcoffeemakersCheckBox;

	@FindBy(xpath = "//button[@id=\"applyFilter\"]")
	WebElement applyFilterbtn;

	@FindBy(xpath = "(//a//span[text()='OXO Brew Cold Brew Coffee Maker'])[1]")
	WebElement OXObrewproduct;

	@FindBy(xpath = " (//a//span[text()='Ohom Sio Cold Brew Pitcher'])[1]")
	WebElement Ohomsioproduct;

	@FindBy(xpath = "(//button[@id='add-to-cart-button'])[1]")
	WebElement addToCart;

	@FindBy(xpath = "//a[@data-test-id='checkout-link']")
	WebElement viewCartcheckoutbtn;

	@FindBy(xpath = "//button[@data-test-id='topCheckout']")
	WebElement topCheckoutbtn;

	public ProductPage() throws Exception {
		PageFactory.initElements(driver, this);
	}

	public void selectOnProduct() {

		Actions act = new Actions(driver);
		act.moveToElement(electricsMouseOver).build().perform();
		coffeemakersProduct.click();
	}

	public void clickOnFilter() {
		filtersBtn.click();
		pricelowtohighRadiobtn.click();
		dripcoffeemakersCheckBox.click();
		applyFilterbtn.click();
	}

	public void clickOnProduct() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// js.executeScript("arguments[0].scrollIntoView(true);", OXObrewproduct);
		waitForVisibility(Ohomsioproduct);
		js.executeScript("arguments[0].click()", Ohomsioproduct);
	}

	public void clickOnAddtoCart() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", addToCart);
		addToCart.click();
	}

	public void viewCartcheckout() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		waitForVisibility(viewCartcheckoutbtn);
		js.executeScript("arguments[0].click()", viewCartcheckoutbtn);
	}
	public void finalCheckoutbtn() {
		topCheckoutbtn.click();
	}

}
