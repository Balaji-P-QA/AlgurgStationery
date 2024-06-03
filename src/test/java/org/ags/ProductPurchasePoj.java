package org.ags;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPurchasePoj {

	WebDriver driver;
	
	public ProductPurchasePoj(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy (css = "a[class='product-item-link']")
	List<WebElement> productsName;

	public WebDriver getDriver() {
		return driver;
	}


	public List<WebElement> getProductsName() {
		return productsName;
	}
	
	
}
