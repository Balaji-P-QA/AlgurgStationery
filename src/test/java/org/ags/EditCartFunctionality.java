package org.ags;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditCartFunctionality {

	static WebDriver driver;
	JavascriptExecutor js;
	String name;
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

	@Test(priority = 3, enabled = true)
	private void targetForCategory() throws InterruptedException {

		//place the cursor on stationery link
		WebElement stationery = driver.findElement(By.xpath("//span[text()='Stationery']"));
		a = new Actions(driver);
		a.moveToElement(stationery).perform();

		Thread.sleep(3000);

		//place the cursor on paper products
		WebElement paperProducts = driver.findElement(By.xpath("(//span[text()='Office Supplies'])[1]"));
		a.moveToElement(paperProducts).perform();

		Thread.sleep(3000);

		//click the Labels and Labels markers option
		WebElement noteBooksAndWritingPads = driver
				.findElement(By.xpath("(//span[text()='Labels & Label makers'])[1]"));
		noteBooksAndWritingPads.click();

		Thread.sleep(3000);
		
        //scroll Down
		WebElement scrDown = driver.findElement(By.xpath("(//span[text()='Filing Accessories'])[2]"));
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", scrDown);

		Thread.sleep(3000);

		//place the cursor on Add to cart icon
		WebElement addToPlaceCursor = driver.findElement(By.xpath("(//i[@class='icon icon-add-to-cart'])[1]"));
		a.moveToElement(addToPlaceCursor).build().perform();
		Thread.sleep(1000);
		//click the cart icon
		addToPlaceCursor.click();

		Thread.sleep(5000);
 
		//place the cursor on Add to Cart icon
		WebElement addToPlaceCursor1 = driver.findElement(By.xpath("(//i[@class='icon icon-add-to-cart'])[2]"));
		a.moveToElement(addToPlaceCursor1).build().perform();
		Thread.sleep(1000);
		//click the cart icon
		addToPlaceCursor1.click();

		driver.findElement(By.xpath("//div[@class='minicart-wrapper']")).click();

		//click the view and Edit cart option
		driver.findElement(By.xpath("//span[text()='View and Edit Cart']")).click();

	}

	@Test(priority = 5, enabled = true)
	private void saveCart() throws InterruptedException {

		String name = "check";

		//save cart name give here
		WebElement saveCartName = driver.findElement(By.xpath("//input[@name='cartname']"));
		saveCartName.sendKeys(name);

		Thread.sleep(3000);

		//click the save cart btn
		WebElement saveCartBtn = driver.findElement(By.xpath("//input[@value='Save Cart']"));
		saveCartBtn.click();

		Thread.sleep(4000);

	}

	@Test(priority = 6, enabled = true)
	private void myCartLink() throws InterruptedException {

		//place the cursor on sign logo
		WebElement signLogo = driver.findElement(By.xpath("//span[@class='icon icon-user']"));
		Actions a = new Actions(driver);
		a.moveToElement(signLogo).perform();

		Thread.sleep(3000);

		//click the MyAccount option
		WebElement myAccount = driver.findElement(By.xpath("(//a[text()='My Account'])[1]"));
		myAccount.click();

		Thread.sleep(3000);

		//click the MyCart link
		WebElement myCartLink = driver.findElement(By.xpath("//a[text()='My Cart']"));
		myCartLink.click();

		Thread.sleep(5000);

	}

	@Test(priority = 7, enabled = true)
	private void editValidation() throws InterruptedException {

		Thread.sleep(5000);

		//get the cart table name here
		String cartTable = driver.findElement(By.xpath("(//td[@style='text-align: left;'])[6]")).getText();
		/***********/

		Thread.sleep(2000);

		WebElement editIcon = driver.findElement(By.xpath("(//img[@class='lazyload loaded'])[16]"));
		/**/
		editIcon.click();

		Thread.sleep(2000);

		//we have given the my cart that product table located
		WebElement enterEdit = driver.findElement(By.xpath("//div[@class='alocolumns clearfix product-modal']"));

		//validate the myCart product table is displayed or not
		boolean editIdentify = enterEdit.isDisplayed();
		Assert.assertTrue(editIdentify);

		//to check the how much product in our myCart table
		List<WebElement> befCartqtyChecking = driver.findElements(By.xpath("//a[text()='delete']"));
        int s = befCartqtyChecking.size();
		System.out.println("in our cart has a " + s+ "product");
        
		Thread.sleep(5000);
		
		//to delete the single product in Mycart 
		List<WebElement> deleteCart = driver.findElements(By.xpath("//a[text()='delete']"));
		deleteCart.get(1).click();
		
		//After delete the single product then check the product is delete or not	
		List<WebElement> aftCartqtyChecking = driver.findElements(By.xpath("//a[text()='delete']"));
        int s1 = aftCartqtyChecking.size();
		System.out.println("after delete one product our cart has a " + s1+ "product");
        
		Thread.sleep(5000);
		
		//go to back for mycart page
		WebElement back = driver.findElement(By.xpath("//a[text()='Back']"));
		back.click();

	}

	@AfterClass
	private void end() {
      
		//close the browser
		driver.quit();
		
	}
	
	
}
