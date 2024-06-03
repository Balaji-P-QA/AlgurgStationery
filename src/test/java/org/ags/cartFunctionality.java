package org.ags;

import java.time.Duration;

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

public class cartFunctionality {

	static WebDriver driver;
	JavascriptExecutor js;
	String name;

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

		// place the cursor on stationery link
		WebElement stationery = driver.findElement(By.xpath("//span[text()='Stationery']"));
		Actions a = new Actions(driver);
		a.moveToElement(stationery).perform();

		Thread.sleep(3000);

		// place the cursor on paper products link
		WebElement paperProducts = driver.findElement(By.xpath("(//span[text()='Paper Products'])[1]"));
		a.moveToElement(paperProducts).perform();

		Thread.sleep(3000);

		// click the Note books and Writing pads option
		WebElement noteBooksAndWritingPads = driver
				.findElement(By.xpath("(//span[text()='Notebooks & Writing pads'])[1]"));
		noteBooksAndWritingPads.click();

		Thread.sleep(3000);

		// scroll down
		WebElement scrDown = driver.findElement(By.xpath("(//span[text()='Notebooks & Writing pads'])[2]"));
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", scrDown);

		Thread.sleep(3000);

		// entering in to product details page
		WebElement productDetails = driver.findElement(By.xpath("//img[@loading='lazy']"));
		productDetails.click();

		Thread.sleep(5000);

		// click the add to cart button
		WebElement addToCartIcon = driver.findElement(By.xpath("//button[@title='Add to Cart']"));
		addToCartIcon.click();

		Thread.sleep(5000);

		//
		driver.findElement(By.xpath("//div[@class='minicart-wrapper']")).click();

		// click the view and edit cart option
		driver.findElement(By.xpath("//span[text()='View and Edit Cart']")).click();

	}

	@Test(priority = 4, enabled = true)
	private void shareCart() throws InterruptedException {

		// click the share cart option
		WebElement shareCart = driver.findElement(By.xpath("//button[text()='Share Cart']"));
		shareCart.click();

		Thread.sleep(9000);

		// here validate the share cart popup, popup is showing try block will
		// execute,popup is not showing catch block will execute
		WebElement sharePopup = driver.findElement(By.xpath("//div[@class='tab']"));
		try {

			if (sharePopup.isDisplayed()) {

				// popup is showing Assert condition is true
				System.out.println("user clicked the share cart so share cart options are showing");
				Assert.assertTrue(true);

				// Close the popup
				WebElement popupClose = driver.findElement(By.xpath("(//span[text()='Cancel'])[2]"));
				popupClose.click();
			}

		} catch (Exception e) {

			// popup is not showing Assert condition is False
			System.out.println("user clicked the share cart but share cart options is not showing");
			Assert.assertTrue(false);

		}

	}

	@Test(priority = 5, enabled = true)
	private void saveCart() throws InterruptedException {

		String name = "Test";

		// give the name for cart save
		WebElement saveCartName = driver.findElement(By.xpath("//input[@name='cartname']"));
		saveCartName.sendKeys(name);

		// click the save btn
		WebElement saveCartBtn = driver.findElement(By.xpath("//input[@value='Save Cart']"));
		saveCartBtn.click();

		Thread.sleep(4000);

	}

	@Test(priority = 6, enabled = true)
	private void myCartLink() throws InterruptedException {

		// place the cursor on sign logo
		WebElement signLogo = driver.findElement(By.xpath("//span[@class='icon icon-user']"));
		Actions a = new Actions(driver);
		a.moveToElement(signLogo).perform();

		Thread.sleep(3000);

		// click the My Account option
		WebElement myAccount = driver.findElement(By.xpath("(//a[text()='My Account'])[1]"));
		myAccount.click();

		Thread.sleep(3000);

		// click the option of MyCart
		WebElement myCartLink = driver.findElement(By.xpath("//a[text()='My Cart']"));
		myCartLink.click();

		Thread.sleep(2000);

	}

	@Test(priority = 7, enabled = true)
	private void editValidation() throws InterruptedException {

		// get the saved cart name
		String cartTable = driver.findElement(By.xpath("//td[text()='Test']")).getText();
		/***********/

		// saved cart name is expected if block will execute,name is not expected else
		// block will execute
		if (cartTable.equals("Test")) {

			System.out.println("user saved cart product is properly saved in the MyCart");

			// click the edit option
			WebElement editIcon = driver.findElement(By.xpath("(//img[@class='lazyload loaded'])[16]"));
			/**/
			editIcon.click();

			Thread.sleep(2000);

			// validate the edit table
			WebElement enterEdit = driver.findElement(By.xpath("//div[@class='alocolumns clearfix product-modal']"));
			boolean editIdentify = enterEdit.isDisplayed();
			Assert.assertTrue(editIdentify);

			Thread.sleep(5000);

			// click the back button
			WebElement back = driver.findElement(By.xpath("//a[text()='Back']"));
			back.click();

			Thread.sleep(5000);

		} else {

			// product saved name is different this statement is printing
			System.out.println("user saved  product is not saved in the MyCart");

		}
	}

	@Test(priority = 11, enabled = true, dependsOnMethods = { "shareIconValidation" })
	private void deleteValidation() {

		// validate the delete option is showing or not
		WebElement deleteOption = driver.findElement(By.xpath("(//img[@class='lazyload loaded'])[18]"));
		/**/

		if (deleteOption.isDisplayed()) {

			System.out.println("delete option is showing in mycart");

			// choice is delete that product will be delete
			String choice = "delete";
			/**/
			if (choice.equals("delete")) {

				deleteOption.click();
				System.out.println("save cart is deleted sccessfully");

			} else {
				// choice is not equal to delete this statement will printing
				System.out.println("user is not like to delete the cart so product is not delete in MyCart page");
			}

		} else {
			// delete option is not showing this statement is printing
			System.out.println("delete option is not displayed in My cart page");
		}

	}

	@Test(priority = 9, enabled = true)
	private void cartIconValidation() throws InterruptedException {
		
       //click the cart detail
		WebElement cartDetail = driver.findElement(By.xpath("//img[@id='detail5']"));
		/**/
		cartDetail.click();

		Thread.sleep(5000);

	    //validate the cart detail popup
		WebElement cartDetailPopup = driver.findElement(By.xpath("(//div[@class='modal-inner-wrap'])[2]"));
        //After clicked cartdetail popup,popup is shown if block will execute,popup is not shown else block will execute
		if (cartDetailPopup.isDisplayed()) {
            //print the statement
			System.out.println("user clicked the cart detail icon ,cart detail popup is showing properly");
            //close the popup
			WebElement cartPopupCancel = driver.findElement(By.xpath("(//span[text()='Cancel'])[2]"));
			cartPopupCancel.click();

		} else {
			//After click cart icon popup is not shown else block will execute
			System.out.println("user clicked the cart detail icon ,cart detail popup is not showing ");

		}
	}

	@Test(priority = 10, enabled = true)
	private void shareIconValidation() throws InterruptedException {

		// Share icon Validate
		WebElement shareIcon = driver.findElement(By.xpath("(//img[@alt='Share Image'])[6]"));
		/**/
        
		//validate the share icon
		if (shareIcon.isDisplayed()) {

			System.out.println("share icon is displayed");

			//click the share icon
			shareIcon.click();

			//validate the share popup
			WebElement sharePop = driver.findElement(By.xpath("//div[@class='tab']"));

			Thread.sleep(5000);
             
			//share popup is displayed if block will execute
			if (sharePop.isDisplayed()) {

				System.out.println("user clicked the share cart icon the share cart popup is showing");

				/**/ String want = "share";

				/**/ String emailId = "test123@mailinator.com";
				/**/ String senderName = "Balaji";
				/**/ String msg = "Its my favourite";

				//want is equals to share if block will execute
				if (want.equals("share")) {
                   
					//click the email share option
					WebElement emailToShare = driver.findElement(By.xpath("(//button[@class='tablinks'])[1]"));
					emailToShare.click();

					Thread.sleep(3000);

					//enter the email address
					WebElement recipientEmail = driver.findElement(By.xpath("(//input[@name='repemailaddress'])[1]"));
					recipientEmail.sendKeys(emailId);

					Thread.sleep(1000);

					//enter the name
					WebElement fromName = driver.findElement(By.xpath("(//input[@name='name'])[1]"));
					fromName.sendKeys(senderName);

					Thread.sleep(1000);

					//enter the message
					WebElement message = driver.findElement(By.xpath("(//textarea[@name='msg'])[1]"));
					message.sendKeys(msg);

					Thread.sleep(1000);

					//click the submit button
					WebElement shareSubmit = driver
							.findElement(By.xpath("//button[text()='Share Your Cart through Email']"));
					shareSubmit.click();

					Thread.sleep(7000);

					//after clicked submit then validate the success message
					WebElement successMsg = driver.findElement(By.xpath("//label[@id='lblName2']"));
					boolean suc = successMsg.isDisplayed();
					Assert.assertTrue(suc);

					Thread.sleep(2000);

					//close the share popup
					WebElement closePopup = driver.findElement(By.xpath("(//span[text()='Cancel'])[3]"));
					closePopup.click();

				} else {

					//we dont like to share click the cancel button
					WebElement cancelbtn = driver.findElement(By.xpath("(//span[text()='Cancel'])[3]"));
					cancelbtn.click();

				}

			} else {
				//after clicked share cart option popup is not showing this statement will printing
				System.out.println("user clicked the share cart icon the share cart popup is not showing");
			}

		}
	}

	@AfterClass
	private void end() {

		//close the browser
		driver.quit();

	}

}
