package org.ags;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ProductPurchase {

	static WebDriver driver;
	JavascriptExecutor js;
	Actions a;

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

	}

	@Test(priority=3,enabled=true)
	private void productSelecting() throws InterruptedException, AWTException {
    
		String categoryWise="";
		String categoryPagewise="";
		String generalSearch="yes";
		
		int i =0;
		
		int j =4;
		
		if (categoryWise.equals("yes")) {
		
			//place the cursor on stationery
			WebElement stationery = driver.findElement(By.xpath("//span[text()='Stationery']"));
			a = new Actions(driver);
			a.moveToElement(stationery).perform();
			
			Thread.sleep(3000);
			
			//place the cursor on paper products
			WebElement paperProducts = driver.findElement(By.xpath("(//span[text()='Paper Products'])[1]"));
			a.moveToElement(paperProducts).perform();
			
			Thread.sleep(3000);
			
			//click the option of note book & writing pads
			WebElement noteBooksAndWritingPads = driver.findElement(By.xpath("(//span[text()='Notebooks & Writing pads'])[1]"));
			noteBooksAndWritingPads.click();
			
			Thread.sleep(3000);
			
			//click the product name entered into product details page
			List<WebElement> productDetails = driver.findElements(By.xpath("//img[@loading='lazy']"));
			js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", productDetails.get(j));
			
			
			Thread.sleep(5000);
			
			//click the add to cart icon
			WebElement addToCartIcon = driver.findElement(By.xpath("//button[@title='Add to Cart']"));
			js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", addToCartIcon);
						
			Thread.sleep(1000);
			
		    
		} else if (categoryPagewise.equals("yes")) {

			
			WebElement stationery = driver.findElement(By.xpath("(//span[text()='Stationery'])[1]"));
			a = new Actions(driver);
			a.moveToElement(stationery).perform();
			
			Thread.sleep(1000);
			
			WebElement fillingAccessories = driver.findElement(By.xpath("(//span[text()='Filing Accessories'])[1]"));
			a = new Actions(driver);
			a.moveToElement(fillingAccessories).perform();
			
			Thread.sleep(1000);
			
			WebElement DocBokDisplyBooks = driver.findElement(By.xpath("(//span[text()='Document Bags & Display Books'])[1]"));
			DocBokDisplyBooks.click();
			
			Thread.sleep(2000);
			
			String ExpectProductName="ELFEN 927 DELUXE SUSPENSION FOLDER FULLSCAPE SIZE PACK OF 50 PIECES COLOUR DARK GREEN";
			
			ProductPurchasePoj p = new ProductPurchasePoj(driver);
			
			for (int k = 0; k < p.productsName.size(); k++) {
				
				String actualProductName = p.productsName.get(k).getText();
				
				
				if (actualProductName.equals(ExpectProductName)) {
					
					WebElement addToCart = driver.findElement(By.cssSelector("i[class='icon icon-add-to-cart']"));
					a.moveToElement(addToCart).perform();
					Thread.sleep(1000);
					addToCart.click();
					break;
								
				}
				
				if (k==p.productsName.size()-1) {
					
					try {
						
						WebElement nextBtn = driver.findElement(By.xpath("(//a[@title='Next'])[2]"));
						nextBtn.click();
						k=-1;
						
					} catch (Exception e) {
						
						System.out.println("User Expected Product is not available");
						i=-1;
						break;
					}
					
				}
				
				
			}
			
			
		}else if (generalSearch.equals("yes")) {
			
			//enter the product name here
			WebElement searchBar = driver.findElement(By.xpath("//input[@id='search']"));
			searchBar.sendKeys("Perfekt Green Premium Paper A4 80gsm Wht");
			String ExpectProductName = searchBar.getAttribute("value");
			
			//submit that product name
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_ENTER);
			

		    Thread.sleep(3000);
		    
           	ProductPurchasePoj p = new ProductPurchasePoj(driver);
			
			for (int k = 0; k < p.productsName.size(); k++) {
				
				String actualProductName = p.productsName.get(k).getText();
							
				if (actualProductName.equals(ExpectProductName)) {
					
					List<WebElement> addToCart = driver.findElements(By.cssSelector("button[type='submit']"));
					Actions a = new Actions(driver);
					a.moveToElement(addToCart.get(j)).perform();
					Thread.sleep(2000);
					js = (JavascriptExecutor)driver;
					js.executeScript("arguments[0].click();",addToCart.get(j) );
				    i=k;
				    break;
				}
				
                  if (k==p.productsName.size()-1) {
					
					try {
						
						WebElement nextBtn = driver.findElement(By.xpath("(//a[@title='Next'])[2]"));
						nextBtn.click();
						k=-1;
						
					} catch (Exception e) {
						
						System.out.println("User Expected Product is not available");
						i=-1;
						break;
					}
					
				}
		 
			
			}
			
		}
			
						
		Thread.sleep(5000);
		
		if (i!=-1) {
			
			WebElement cartBasket = driver.findElement(By.xpath("//div[@class='minicart-wrapper']"));
			cartBasket.click();
			
			Thread.sleep(5000);
			
			//click the proceed to checkout
			WebElement proceedToCheckOut = driver.findElement(By.xpath("//button[text()='Proceed to Checkout']"));
		    proceedToCheckOut.click();
			
		}
		
			
	}

	@Test(priority = 4, enabled = true)
	private void checkoutPage() throws InterruptedException {

		// scroll down
		WebElement scrproceed = driver.findElement(By.xpath("//span[text()='Review & Payments']"));
		js.executeScript("arguments[0].scrollIntoView(true)", scrproceed);

		Thread.sleep(5000);

		// click the Proceed To Payment
		WebElement proceedToPayment = driver.findElement(By.xpath("//span[text()='Proceed to Payment']"));
		proceedToPayment.click();

		Thread.sleep(3000);

		// click the credit card option
		WebElement creditCart = driver.findElement(By.xpath("//input[@id='ccavenue']"));
		creditCart.click();

		Thread.sleep(3000);

		// click the place order button
		WebElement placeOrder = driver.findElement(By.xpath("(//span[text()='Place Order'])[2]"));
		placeOrder.click();

		Thread.sleep(3000);

		// click the OK option from popup
		WebElement popup = driver.findElement(By.xpath("//span[text()='Ok']"));
		popup.click();
	}

	@Test(priority = 5, enabled = true)
	private void Payment() throws InterruptedException {

		// scroll Down
		WebElement scrollDown = driver.findElement(By.xpath("(//div[@id='sectionheading'])[2]"));
		js.executeScript("arguments[0].scrollIntoView(true)", scrollDown);

		// enter the Credit Card Number
		WebElement cardNumber = driver.findElement(By.xpath("//input[@id='creditCardNumber']"));
		cardNumber.sendKeys("5123450000000008");

		// select the month here
		WebElement month = driver.findElement(By.xpath("//select[@name='expiryMonthCreditCard']"));
		Select s = new Select(month);
		s.selectByIndex(1);

		// select the Year here
		WebElement year = driver.findElement(By.xpath("//select[@name='expiryYearCreditCard']"));
		Select s1 = new Select(year);
		s1.selectByVisibleText("2039");

		// enter the card CCv Number
		WebElement ccvNum = driver.findElement(By.xpath("//input[@name='CVVNumberCreditCard']"));
		ccvNum.sendKeys("100");

		// click the Make payment
		WebElement makePayment = driver.findElement(By.xpath("(//span[text()='Make Payment'])[1]"));
		makePayment.click();

		Thread.sleep(4000);

		// print the statement to Report
		Reporter.log("Payment proceed successful");
	}

	@Test(priority = 6, enabled = true)
	private void acsEmulator() throws InterruptedException {

		// click the submit button
		WebElement submit = driver.findElement(By.xpath("//input[@type='submit']"));
		submit.click();

	}

	@AfterClass
	private void end() {

		// close the Browser
		 driver.quit();

	}

}
