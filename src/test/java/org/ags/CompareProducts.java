package org.ags;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CompareProducts {

	WebDriver driver;
	JavascriptExecutor js;
	Actions a;
	int num;

	@BeforeClass
	private void start() throws InterruptedException {

		// browser configuration
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		// url launch
		driver.get("https://upg-dev.algurgstationery.com/");

		// widow maximize
		driver.manage().window().maximize();

		// apply implicitlywait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// 1.place the cursor of sign logo
		WebElement signLogo = driver.findElement(By.xpath("//span[@class='icon icon-user']"));

		// signLogo.click();
		Actions a = new Actions(driver);
		a.moveToElement(signLogo).perform();

		// click the login button
		WebElement loginOption = driver.findElement(By.xpath("//a[text()='Login']"));
		loginOption.click();

		// enter the user name
		WebElement userName = driver.findElement(By.xpath("//input[@name='login[username]']"));
		userName.sendKeys("balaji.p@sysfore.com");

		// enter the password
		WebElement password = driver.findElement(By.xpath("//input[@name='login[password]']"));
		password.sendKeys("Balaji@123");

		// click the submit
		WebElement submit = driver.findElement(By.xpath("//span[text()='Login']"));
		submit.click();

		Thread.sleep(4000);

	}

	@Test(priority = 1, enabled = true)
	private void product() throws InterruptedException {

		// place the cursor for stationery link
		WebElement stationery = driver.findElement(By.xpath("//span[text()='Stationery']"));
		a = new Actions(driver);
		a.moveToElement(stationery).build().perform();

		Thread.sleep(3000);

		// place the cursor for office supplies
		WebElement officeSupply = driver.findElement(By.xpath("(//span[text()='Office Supplies'])[1]"));
		a.moveToElement(officeSupply).build().perform();

		Thread.sleep(3000);

		// click the option of Labels & Labels makers
		WebElement label = driver.findElement(By.xpath("(//span[text()='Labels & Label makers'])[1]"));
		label.click();

	}

	@Test(priority = 2, enabled = false)
	private void removeProduct() throws InterruptedException {

		// scroll down
		WebElement scrDown = driver.findElement(By.xpath("(//span[text()='Filing Accessories'])[2]"));
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", scrDown);

		Thread.sleep(3000);

		num = 0;

		// place the cursor for product price
		a = new Actions(driver);
		WebElement placeCursor = driver.findElement(By.xpath("(//span[@class='price'])[3]"));
		a.moveToElement(placeCursor).build().perform();

		Thread.sleep(3000);

		// click the compare button
		WebElement addToCompare = driver.findElement(By.xpath("(//a[@title='Add to Compare'])[1]"));
		js.executeScript("arguments[0].click();", addToCompare);

		Thread.sleep(3000);

		// scroll Down
		WebElement scrDown2 = driver.findElement(By.xpath("(//span[text()='Filing Accessories'])[2]"));
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", scrDown2);

		Thread.sleep(4000);

		// place the cursor for product price
		WebElement placeCursor2 = driver.findElement(By.xpath("(//span[text()='AED 189.00'])[3]"));
		a.moveToElement(placeCursor2).build().perform();

		Thread.sleep(3000);

		WebElement addToCompare1 = driver.findElement(By.xpath("(//a[@title='Add to Compare'])[2]"));
		js.executeScript("arguments[0].click();", addToCompare1);

		Thread.sleep(4000);

		// place the cursor for sign logo
		WebElement sign = driver.findElement(By.xpath("//span[@class='icon icon-user']"));
		a.moveToElement(sign).perform();

		// click the option of my compare products
		WebElement compare = driver.findElement(By.xpath("//a[text()='My Compare Products']"));
		js.executeScript("arguments[0].click();", compare);

		// get the products count in compared field
		List<WebElement> compareCounts = driver.findElements(By.xpath("//span[text()='Add to Wish List']"));
		// print the products counts in compared field
		System.out.println("we have " + compareCounts.size() + "prodducts in our comparison page");
		// remove products
		List<WebElement> removeProducts = driver.findElements(By.xpath("//span[text()='Remove Product']"));

		js.executeScript("arguments[0].click();", removeProducts.get(2));

		/**/ String weWant = "remove";

		// we want is equal to to remove if block will execute,not equal to remove else
		// block will execute
		if (weWant.equals("remove")) {

			WebElement remove = driver.findElement(By.xpath("//span[text()='OK']"));
			remove.click();
			System.out.println("as expect to user the product is removed");
			System.out.println("product successfully removed");

			// after removed one product then get how much product avilable in compared
			// field
			List<WebElement> compareCountss = driver.findElements(By.xpath("//span[text()='Add to Wish List']"));

			// System.out.println("as expect to user the product is not removed");
			System.out.println("we have " + compareCountss.size() + "prodducts in our comparison page");

		} else {

			WebElement cancel = driver.findElement(By.xpath("(//span[text()='Cancel'])[2]"));
			cancel.click();
			System.out.println("product not removed from comparison page");

		}

	}

	@Test(priority = 3, enabled = true)
	private void wishList() throws InterruptedException {

		// scroll Down
		WebElement scrDown = driver.findElement(By.xpath("(//span[text()='Filing Accessories'])[2]"));
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", scrDown);

		Thread.sleep(3000);

		// place the cursor for product price name
		a = new Actions(driver);
		WebElement placeCursor = driver.findElement(By.xpath("(//span[@class='price'])[4]"));
		a.moveToElement(placeCursor).build().perform();

		Thread.sleep(1000);

		// click the wishlist
		WebElement addTowishList = driver.findElement(By.xpath("(//a[@title='Add to Wish List'])[1]"));
		js.executeScript("arguments[0].click();", addTowishList);

		Thread.sleep(3000);

		// scroll Down
		WebElement scrDown1 = driver.findElement(By.xpath("//a[text()='My Cart']"));
		js.executeScript("arguments[0].scrollIntoView(true)", scrDown1);

		Thread.sleep(3000);

		/**/ String Likes = "Update";

		// Likes is equals to Updated if block will execute
		// Likes is equals to Share else if block will execute
		// Likes is not equals to both else block will execute

		if (Likes.equals("Update")) {
			// clear the product qty /**/
			WebElement qty = driver.findElement(By.xpath("//input[@name='qty[393]']"));
			qty.clear();

			Thread.sleep(2000);
			// enter the product qty
			qty.sendKeys("2");

			Thread.sleep(2000);
			// click the update
			WebElement update = driver.findElement(By.xpath("//span[text()='Update Wish List']"));
			update.click();

		} else if (Likes.equals("Share")) {
			// click the share wish list option
			WebElement share = driver.findElement(By.xpath("//span[text()='Share Wish List']"));
			share.click();
			Thread.sleep(2000);
			// enter the email address
			WebElement email = driver.findElement(By.xpath("//textarea[@name='emails']"));
			email.sendKeys("balaji.p@mailinator.com");
			Thread.sleep(2000);
			// enter the msg
			WebElement msg = driver.findElement(By.xpath("//textarea[@name='message']"));
			msg.sendKeys("My Wish List Items");
			Thread.sleep(2000);
			// click the share btn
			WebElement sharewishListBtn = driver.findElement(By.xpath("//span[text()='Share Wish List']"));
			sharewishListBtn.click();
			Thread.sleep(1000);
			// print the success msg
			WebElement successMsg = driver.findElement(By.xpath("//div[@class='message-success success message']"));
			System.out.println(successMsg.getText());

		} else {

			// click the addall to cart button
			WebElement addAllToCart = driver.findElement(By.xpath("//span[text()='Add All to Cart']"));
			addAllToCart.click();
			// validate the success msg
			WebElement emptyMsg = driver.findElement(By.xpath("//span[text()='You have no items in your wish list.']"));
			if (emptyMsg.isDisplayed()) {
				System.out.println("wishList Product is added to cart then the wish List is empty");

			}
		}

		String Remove = "yes";
		// remove is equals to yes if block will execute, otherwise is not execute
		if (Remove.equals("yes")) {
			// scroll Down
			WebElement scrDown2 = driver.findElement(By.xpath("//a[text()='My Cart']"));
			js.executeScript("arguments[0].scrollIntoView(true)", scrDown2);
			Thread.sleep(3000);
			// click the remove button
			WebElement remove = driver.findElement(By.xpath("//span[text()='Remove item']"));
			remove.click();
			Thread.sleep(3000);
			// validate the wishList qty
			WebElement emptyMsg = driver.findElement(By.xpath("//span[text()='You have no items in your wish list.']"));
			if (emptyMsg.isDisplayed()) {
				System.out.println("wishList Product is added to cart then the wish List is empty");

			}
		}

	}

	@AfterClass
	private void end() {

		 driver.quit();

	}

}
