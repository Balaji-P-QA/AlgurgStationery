package org.ags;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UserPersonalFunctionalities {

	WebDriver driver;

	@BeforeClass
	private void start() {

		// browser configuration

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		// url launch

		driver.get("https://upg-dev.algurgstationery.com/");

		// widow maximize

		driver.manage().window().maximize();

		// apply implicitlywait

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@Test(priority = 1, enabled = true)
	private void prework() {
		// 1.place the cursor of sign logo
		WebElement signLogo = driver.findElement(By.xpath("//span[@class='icon icon-user']"));

		// signLogo.click();
		Actions a = new Actions(driver);
		a.moveToElement(signLogo).perform();

		// click the login button
		WebElement loginOption = driver.findElement(By.xpath("//a[text()='Login']"));
		loginOption.click();

	}

	@Test(priority = 2, enabled = true)
	private void loginCredentials() throws InterruptedException {

		// enter the user name
		WebElement userName = driver.findElement(By.xpath("//input[@name='login[username]']"));
		userName.sendKeys("balaji.p@sysfore.com");

		// enter the password
		WebElement password = driver.findElement(By.xpath("//input[@name='login[password]']"));
		password.sendKeys("Balaji@123");

		// click the submit
		WebElement submit = driver.findElement(By.xpath("//span[text()='Login']"));
		submit.click();
		
		 WebElement signLogo = driver.findElement(By.xpath("//span[@class='icon icon-user']"));

		// signLogo.click();
		Actions a = new Actions(driver);
		a.moveToElement(signLogo).perform();
		

	}

	@Test(priority = 3, enabled =false)
	private void wishList() {

		// 1.place the cursor of sign logo
		WebElement signLogo = driver.findElement(By.xpath("//span[@class='icon icon-user']"));

		// signLogo.click();
		Actions a = new Actions(driver);
		a.moveToElement(signLogo).perform();
		
		//click the wishlist field
		WebElement wishListField = driver.findElement(By.xpath("//a[text()='My Wishlist']"));
		wishListField.click();
		
		//wish list is empty try block will execute
		try {
			
			WebElement wishListMsg = driver.findElement(By.xpath("//span[text()='You have no items in your wish list.']"));
			
			if (wishListMsg.isDisplayed()) {
				System.out.println("user wish list is empty");
			}
			
			//wish list is not empty catch block will execute
		} catch (Exception e) {
			
			System.out.println("user have some wishlist items");
		}
		
	}
	
	
	@Test(priority=4,enabled=false)
	private void compareProducts() {

        //click the Comparison field
		WebElement comparisonField = driver.findElement(By.xpath("//a[text()='My Compare Products']"));
		comparisonField.click();
		
		//camparrison has no product if block will execute
		try {
			
			WebElement compareMsg = driver.findElement(By.xpath("//div[text()='You have no items to compare.']"));
			
			if (compareMsg.isDisplayed()) {
				
				System.out.println("user comparison field is empty");		
			} 
			
			//product has compare catch block will execute
		} catch (Exception e) {
			
			System.out.println("user have some product to compare");
			
		}
	
	}
	
	
	@Test(priority=5,enabled=false)
	private void myOrders() {
    
		//click the Myorders field
		WebElement myOrderField = driver.findElement(By.xpath("//a[text()='My Orders']"));
		myOrderField.click();
		
		//user ordered list is shown try block will execute
		try {
			
			WebElement orderMsg = driver.findElement(By.xpath("//span[text()='You have placed no orders.']"));
			
			if (orderMsg.isDisplayed()) {
				
				System.out.println("user have placed no orders");
				
			}
			
			//still not ordered any product catch block will execute
		} catch (Exception e) {
			
			System.out.println("user have placed some orders");
			
		}	
		
	}
	
	
	@Test(priority=6,enabled=true)
	private void myAddress() {
    
		//click the MyAddress field
		WebElement myAddressField = driver.findElement(By.xpath("(//a[text()='My Addresses'])[1]"));
		myAddressField.click();
		
		String actualTitle = driver.getTitle();
		
		String Expecttitle="Address Book";
		
		Assert.assertEquals(actualTitle, Expecttitle,"user not entered the Account page,may be user not logged in our Account");
		
	}
	
	
	@Test(priority=7,enabled=true)
	private void signout() throws InterruptedException {
    
		
		WebElement signLogo = driver.findElement(By.xpath("//span[@class='icon icon-user']"));

		// signLogo.click();
		Actions a = new Actions(driver);
		a.moveToElement(signLogo).perform();
		
		
		WebElement signOutField = driver.findElement(By.xpath("//a[text()='Sign Out ']"));
		signOutField.click();
		
		
		Thread.sleep(8000);
		
		//user is signout Try block will execute
		try {
			
		WebElement signoutConfirming = driver.findElement(By.xpath("//span[@id='cust-name']"));
		
		String confirm = signoutConfirming.getText();
		
		if (!confirm.isEmpty()) {
			
			System.out.println("user not signout");
		}
		
		//user not signout catch block will execute
		}catch (Exception e) {
			
			System.out.println("user signout successfully");
			
		}
	
	}
	
	@Test(priority=8,enabled=true)
	private void cart() throws InterruptedException {
		
		//click the cart icon
		WebElement cartIcon = driver.findElement(By.xpath("//div[@class='minicart-wrapper']"));
		cartIcon.click();
		
		Thread.sleep(4000);
		
		//no products in cart Try block will execute
		try {
			WebElement cartWrngMsg = driver.findElement(By.xpath("//strong[text()='You have no items in your shopping cart.']"));
		       
			if (cartWrngMsg.isDisplayed()) {
				System.out.println("user didn't have a product in our cart ,so errmg showing"+cartWrngMsg);
			} 
			
			//Any products in cart catch block will execute
		} catch (Exception e) {
			
			System.out.println("user have a product in cart");
		}	
	}
	
	
	@AfterClass
	private void end() {
    
		//close the browser
		driver.quit();
		
	}
	

}
