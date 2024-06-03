package org.ags;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CartFunctionalities {

	static WebDriver driver;
	JavascriptExecutor js;
	
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
	private void targetForCategory() throws InterruptedException {
    
		WebElement stationery = driver.findElement(By.xpath("//span[text()='Stationery']"));
		Actions a = new Actions(driver);
		a.moveToElement(stationery).perform();
		
		Thread.sleep(3000);
		
		WebElement paperProducts = driver.findElement(By.xpath("(//span[text()='Paper Products'])[1]"));
		a.moveToElement(paperProducts).perform();
		
		Thread.sleep(3000);
		
		WebElement noteBooksAndWritingPads = driver.findElement(By.xpath("(//span[text()='Notebooks & Writing pads'])[1]"));
		noteBooksAndWritingPads.click();
		
		Thread.sleep(3000);
		
		
		WebElement scrDown = driver.findElement(By.xpath("(//span[text()='Notebooks & Writing pads'])[2]"));
		js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)",scrDown);
		
		Thread.sleep(3000);
		
		/*WebElement addToCartIcon = driver.findElement(By.xpath("//i[@class='icon icon-add-to-cart']"));
		Thread.sleep(1500);
		addToCartIcon.click();*/
		

		WebElement productDetails = driver.findElement(By.xpath("//img[@loading='lazy']"));
		productDetails.click();
		
		
		Thread.sleep(5000);
		
		WebElement addToCartIcon = driver.findElement(By.xpath("//button[@title='Add to Cart']"));
		addToCartIcon.click();
		
		
		Thread.sleep(5000);
	
		
		driver.findElement(By.xpath("//div[@class='minicart-wrapper']")).click();
		
		driver.findElement(By.xpath("//span[text()='View and Edit Cart']")).click();
		
	}
	
	
	@Test(priority=4,enabled=true)
	private void shareCart() throws InterruptedException {
		
		WebElement shareCart = driver.findElement(By.xpath("//button[text()='Share Cart']"));
		shareCart.click();
		
		Thread.sleep(9000);
		
		WebElement sharePopup = driver.findElement(By.xpath("//div[@class='tab']"));
     
		
		try {
			
			if (sharePopup.isDisplayed()) {
				
				System.out.println("user clicked the share cart so share cart options are showing");
				Assert.assertTrue(true);
				
				WebElement popupClose = driver.findElement(By.xpath("(//span[text()='Cancel'])[2]"));
				popupClose.click();
				
			}
			
			
		} catch (Exception e) {

			 
			System.out.println("user clicked the share cart but share cart options is not showing");
			Assert.assertTrue(false);
			 
		}
		
		
		
		
	
	}
	
	
	@Test(priority=5,enabled=true)
	private void saveCart() throws InterruptedException {
    
		
		String name="demo";
		
		WebElement saveCartName = driver.findElement(By.xpath("//input[@name='cartname']"));
		
		saveCartName.sendKeys(name);
		
		WebElement saveCartBtn = driver.findElement(By.xpath("//input[@value='Save Cart']"));
		saveCartBtn.click();
		
		Thread.sleep(4000);
		
		
		WebElement signLogo = driver.findElement(By.xpath("//span[@class='icon icon-user']"));

		
		Actions a = new Actions(driver);
		a.moveToElement(signLogo).perform();
		
		Thread.sleep(2000);

		WebElement myAccount = driver.findElement(By.xpath("(//a[text()='My Account'])[1]"));
		myAccount.click();
		
		Thread.sleep(2000);
		
		WebElement myCartLink = driver.findElement(By.xpath("//a[text()='My Cart']"));
		myCartLink.click();
		
		Thread.sleep(2000);
		
		
		
		String cartTable = driver.findElement(By.xpath("//td[text()='demo']")).getText();
		                                                      /***********/
		
		if (cartTable.equals(name)) {
			
			System.out.println("user saved cart product is properly saved in the MyCart");
			
			WebElement editIcon = driver.findElement(By.xpath("(//img[@class='lazyload loaded'])[16]"));
			                                                                                    /**/
			editIcon.click();
			
			Thread.sleep(2000);
			
			WebElement enterEdit = driver.findElement(By.xpath("//div[@class='alocolumns clearfix product-modal']"));
			
			boolean editIdentify = enterEdit.isDisplayed();
			Assert.assertTrue(editIdentify);
			
			Thread.sleep(5000);
			
			driver.navigate().back();
			
			Thread.sleep(5000);
			
			
			
			//delete icon validation
			
			WebElement deleteOption = driver.findElement(By.xpath("(//img[@class='lazyload loaded'])[18]"));
			                                                                                        /**/
			
			if (deleteOption.isDisplayed()) {
				
				System.out.println("delete option is showing in mycart");
				
				String choice="Null";
				               /**/
				if (choice.equals("delete")) {
					
					deleteOption.click();
					
				} else {

					System.out.println("user is not like to delete the cart so product is not delete in MyCart page");
				}
						
				
			} else {
				
				System.out.println("delete option is not displayed in My cart page");

			}
			
			
			
			WebElement cartDetail = driver.findElement(By.xpath("//img[@id='detail5']"));
                                                                                  /**/			
			cartDetail.click();
			
			Thread.sleep(5000);
			
			WebElement cartDetailPopup = driver.findElement(By.xpath("(//div[@class='modal-inner-wrap'])[2]"));
			
		    if (cartDetailPopup.isDisplayed()) {
				
		    	System.out.println("user clicked the cart detail icon ,cart detail popup is showing properly");
		    	
		        WebElement cartPopupCancel = driver.findElement(By.xpath("(//span[text()='Cancel'])[2]"));
		        cartPopupCancel.click();
		    	
		    	
			} else {
				System.out.println("user clicked the cart detail icon ,cart detail popup is not showing ");
				
			}
		    
		    Thread.sleep(6000);
			
		    
		  //Share icon Validate
		    
		    WebElement shareIcon = driver.findElement(By.xpath("(//img[@alt='Share Image'])[6]"));
		                                                                                   /**/
		    
		    if (shareIcon.isDisplayed()) {
		    	
		    	System.out.println("share icon is displayed");
		    	
		    	shareIcon.click();
		    	
		    	WebElement sharePop = driver.findElement(By.xpath("//div[@class='tab']"));
		    	
		    	Thread.sleep(5000);
		    	
		    	if (sharePop.isDisplayed()) {
					
		    		System.out.println("user clicked the share cart icon the share cart popup is showing");
		    		
		    		WebElement cancelbtn = driver.findElement(By.xpath("(//span[text()='Cancel'])[3]"));
		    		cancelbtn.click();
		    		
				} else {
					System.out.println("user clicked the share cart icon the share cart popup is not showing");
				}
		    	
		    	
		    }
		
		    
			
			
		} else {

			System.out.println("user saved  product is not saved in the MyCart");
			
		}
		
		
	}
	
	
	@AfterClass
	private void end() {
    
		
		driver.quit();
		
	}
	
}
