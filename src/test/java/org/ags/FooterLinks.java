package org.ags;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FooterLinks {

	WebDriver driver;
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
	
	@Test(priority=1,enabled=false)
	private void officeSupplies() throws InterruptedException {
     
		WebElement boardEagles = driver.findElement(By.xpath("//a[text()='Boards & Easels']"));
		//Thread.sleep(1000);
		boardEagles.click();
		
		Thread.sleep(4000);
		
		String actual = driver.findElement(By.xpath("//span[@class='base']")).getText();
		
		
		String expect="Boards & Easels";
		
		
	
		
		if (actual.equals(expect)) {
			
			System.out.println("user clicked the Boards & Easels link its properly redirected to Boards & Easels page");
			Assert.assertTrue(true);
			
		}else {
			System.out.println("user clicked the Boards & Easels link its not redirected to Boards & Easels page");
			Assert.assertTrue(false);
		}
		
		Thread.sleep(2000);
	
	}
	
	
	@Test(priority=2,enabled=false)
	private void deskSupplies() throws InterruptedException {
    
		
		WebElement scr1 = driver.findElement(By.xpath("//div[@class='sidebar sidebar-main']"));
		js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)",scr1);
		
		WebElement deskSupply = driver.findElement(By.xpath("//a[text()='Desk Supplies']"));
		Thread.sleep(1000);	
		deskSupply.click();
		
		Thread.sleep(4000);
		
		String actual = driver.findElement(By.xpath("//span[@class='base']")).getText();
		
		
		String expect="Desk Supplies";
		
		
	
		
		if (actual.equals(expect)) {
			
			System.out.println("user clicked the Desk Supplies link its properly redirected to Desk Supplies page");
			Assert.assertTrue(true);
			
		}else {
			System.out.println("user clicked the Desk Supplies link its not redirected to Desk Supplies page");
			Assert.assertTrue(false);
		}
		
		Thread.sleep(2000);
	}
	
	@Test(priority=3,enabled=false)
	private void generalSupplies() throws InterruptedException {
    
		WebElement scr1 = driver.findElement(By.xpath("//div[@class='sidebar sidebar-main']"));
		js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)",scr1);
		
		WebElement generalSupply = driver.findElement(By.xpath("//a[text()='General Supplies']"));
		Thread.sleep(1000);	
		generalSupply.click();
		
		Thread.sleep(4000);
		
		String actual = driver.findElement(By.xpath("//span[@class='base']")).getText();
		
		
		String expect="General Supplies";
		
		
	
		
		if (actual.equals(expect)) {
			
			System.out.println("user clicked the General Supplies link its properly redirected to General Supplies page");
			Assert.assertTrue(true);
			
		}else {
			System.out.println("user clicked the General Supplies link its not redirected to General Supplies page");
			Assert.assertTrue(false);
		}
		
		Thread.sleep(2000);
	
	}
	
	
	@Test(priority=4,enabled=false)
	private void labelMakers() throws InterruptedException {
       
		WebElement scr1 = driver.findElement(By.xpath("//div[@class='sidebar sidebar-main']"));
		js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)",scr1);
		
		WebElement labelMakers = driver.findElement(By.xpath("//a[text()='Labels & Label makers']"));
		Thread.sleep(1000);
		labelMakers.click();
		
		Thread.sleep(4000);
		
		String actual = driver.findElement(By.xpath("//span[@class='base']")).getText();
		
		
		String expect="Labels & Label makers";
		
		
	
		
		if (actual.equals(expect)) {
			
			System.out.println("user clicked the Labels & Label makers link its properly redirected to Labels & Label makers page");
			Assert.assertTrue(true);
			
		}else {
			System.out.println("user clicked the Labels & Label makers link its not redirected to Labels & Label makers page");
			Assert.assertTrue(false);
		}
		
		Thread.sleep(2000);
	}
	
	
	
	@Test(priority=5,enabled=false)
	private void tapesAdhesives() throws InterruptedException {
    
		WebElement labelMakers = driver.findElement(By.xpath("//a[text()='Tapes & Adhesives']"));
		//Thread.sleep(1000);
		labelMakers.click();
		
		Thread.sleep(4000);
		
		String actual = driver.findElement(By.xpath("//span[@class='base']")).getText();
		
		
		String expect="Tapes & Adhesives";
		
		
	
		
		if (actual.equals(expect)) {
			
			System.out.println("user clicked the Tapes & Adhesives link its properly redirected to Tapes & Adhesives page");
			Assert.assertTrue(true);
			
		}else {
			System.out.println("user clicked the Tapes & Adhesives link its not redirected to Tapes & Adhesives page");
			Assert.assertTrue(false);
		}
		
		Thread.sleep(2000);
	
	}
	
	
	@Test(priority=6,enabled=false)
	private void writingInstruments() throws InterruptedException {
    
		WebElement labelMakers = driver.findElement(By.xpath("//a[text()='Writing Instruments']"));
		//Thread.sleep(1000);
		labelMakers.click();
		
		Thread.sleep(4000);
		
		String actual = driver.findElement(By.xpath("//span[@class='base']")).getText();
		
		
		String expect="Writing Instruments";
		
		
	
		
		if (actual.equals(expect)) {
			
			System.out.println("user clicked the Writing Instruments link its properly redirected to Writing Instruments page");
			Assert.assertTrue(true);
			
		}else {
			System.out.println("user clicked the Writing Instruments link its not redirected to Writing Instruments page");
			Assert.assertTrue(false);
		}
	
		Thread.sleep(2000);
		
	}
	
	
	
	@Test(priority=7,enabled=false)
	private void punctureStaplerScissors() throws InterruptedException {

		WebElement labelMakers = driver.findElement(By.xpath("//a[text()='Staplers & Punchers & Scissors']"));
		//Thread.sleep(1000);
		labelMakers.click();
		
		Thread.sleep(4000);
		
		String actual = driver.findElement(By.xpath("//span[@class='base']")).getText();
		
		
		String expect="Staplers & Punchers & Scissors";
		
		
	
		
		if (actual.equals(expect)) {
			
			System.out.println("user clicked the Staplers & Punchers & Scissors link its properly redirected to Staplers & Punchers & Scissors page");
			Assert.assertTrue(true);
			
		}else {
			System.out.println("user clicked the Staplers & Punchers & Scissors link its not redirected to Staplers & Punchers & Scissors page");
			Assert.assertTrue(false);
		}
	
		
		Thread.sleep(2000);
		
	}
	
	
	@Test(priority=8,enabled=false)
	private void notebookAndWritingpads() throws InterruptedException {
		
		WebElement scr1 = driver.findElement(By.xpath("//div[@class='sidebar sidebar-main']"));
		js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)",scr1);
    
		WebElement labelMakers = driver.findElement(By.xpath("//a[text()='Notebooks & Writing pads']"));
		//Thread.sleep(1000);
		js.executeScript("arguments[0].click();", labelMakers);
		//labelMakers.click();
		
		Thread.sleep(4000);
		
		String actual = driver.findElement(By.xpath("//span[@class='base']")).getText();
		
		
		String expect="Notebooks & Writing pads";
		
		
	
		
		if (actual.equals(expect)) {
			
			System.out.println("user clicked the Notebooks & Writing pads link its properly redirected to Notebooks & Writing pads page");
			Assert.assertTrue(true);
			
		}else {
			System.out.println("user clicked the Notebooks & Writing pads link its not redirected to Notebooks & Writing pads page");
			Assert.assertTrue(false);
		}
	
		
		Thread.sleep(2000);
		
		
	}
	
	@Test(priority=50,enabled=false)
	private void printingPapers() throws InterruptedException {
     
		/*WebElement scr1 = driver.findElement(By.xpath("//div[@class='sidebar sidebar-main']"));
		js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)",scr1);*/
		
		WebElement labelMakers = driver.findElement(By.xpath("//a[text()='Printing Papers']"));
		//Thread.sleep(1000);
		labelMakers.click();
		
		Thread.sleep(4000);
		
		String actual = driver.findElement(By.xpath("//span[@class='base']")).getText();
		
		
		String expect="Printing Papers";
		
		
	
		
		if (actual.equals(expect)) {
			
			System.out.println("user clicked the Printing Papers link its properly redirected to Printing Papers page");
			Assert.assertTrue(true);
			
		}else {
			System.out.println("user clicked the Printing Papers link its not redirected to Printing Papers page");
			Assert.assertTrue(false);
		}
	
		
		Thread.sleep(2000);
	
	}
	
	
	
	@Test(priority=10,enabled=false)
	private void contactUs() throws InterruptedException {
    
		
		
		WebElement contactUs = driver.findElement(By.xpath("//a[text()='Contact us']"));
		//Thread.sleep(1000);
		js.executeScript("arguments[0].click();", contactUs);
	//	contactUs.click();
		
		Thread.sleep(4000);
		
		String actual = driver.getTitle();
		
		
		String expect="Contact Us";
		
		
	
		
		if (actual.equals(expect)) {
			
			System.out.println("user clicked the Contact us link its properly redirected to Contact us page");
			Assert.assertTrue(true);
			
		}else {
			System.out.println("user clicked the Contact us link its not redirected to Contact us page");
			Assert.assertTrue(false);
		}
	
		
		Thread.sleep(2000);
	
	}
	
		
	
	@Test(priority=11,enabled=false)
	private void deliveryPolicy() throws InterruptedException {
    
	
		
		WebElement contactUs = driver.findElement(By.xpath("//a[text()='Delivery Policy']"));
		Thread.sleep(2000);
		contactUs.click();
		
		Thread.sleep(4000);
		
		String actual = driver.getTitle();
		
		
		String expect="Delivery Returns Refunds";
		
		
	
		
		if (actual.equals(expect)) {
			
			System.out.println("user clicked the Delivery Policy link its properly redirected to Delivery Policy page");
			Assert.assertTrue(true);
			
		}else {
			System.out.println("user clicked the Delivery Policy link its not redirected to Delivery Policy page");
			Assert.assertTrue(false);
		}
	
		
		Thread.sleep(2000);
			
	}
	
	
	@Test(priority=12,enabled=false)
	private void returnsRefunds() throws InterruptedException {
    
		
		
		WebElement returnRefunds = driver.findElement(By.xpath("//a[text()='Returns & Refunds']"));
		Thread.sleep(1000);
		returnRefunds.click();
		
		Thread.sleep(10000);
		
		String actual = driver.getTitle();
		
		
		String expect="Delivery Returns Refunds";
		
		
	
		
		if (actual.equals(expect)) {
			
			System.out.println("user clicked the Returns & Refunds link its properly redirected to Returns & Refunds page");
			Assert.assertTrue(true);
			
		}else {
			System.out.println("user clicked the Returns & Refunds link its not redirected to Returns & Refunds page");
			Assert.assertTrue(false);
		}
	
		
		Thread.sleep(5000);	
	
	}
	
	
		
	
	@Test(priority=13,enabled=false)
	private void faqs() throws InterruptedException {
    
		//WebElement scr1 = driver.findElement(By.xpath("//img[@class='lazyload footer-logo loaded']"));
		//js = (JavascriptExecutor)driver;
		//js.executeScript("arguments[0].scrollIntoView(true)",scr1);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
		WebElement faqs = driver.findElement(By.xpath("//a[text()='FAQs']"));
	
		//Thread.sleep(1000);
		js.executeScript("arguments[0].click();", faqs);
		//faqs.click();
		
		Thread.sleep(4000);
		
		String actual = driver.getTitle();
		
		
		String expect="FAQs";
		
		
	
		
		if (actual.equals(expect)) {
			
			System.out.println("user clicked the FAQs link its properly redirected to FAQs page");
			Assert.assertTrue(true);
			
		}else {
			System.out.println("user clicked the FAQs link its not redirected to FAQs page");
			Assert.assertTrue(false);
		}
	
		
		Thread.sleep(2000);
		
	}
	
	
	@Test(priority=14,enabled=false)
	private void termsAndCondition() throws InterruptedException {
     
		
		
		WebElement termCondition = driver.findElement(By.xpath("//a[text()='Terms & Conditions']"));
		//Thread.sleep(1000);
		//termCondition.click();
		js.executeScript("arguments[0].click();",termCondition);
		Thread.sleep(4000);
		
		String actual = driver.getTitle();
		
		
		String expect="Terms & Conditions";
		
		
	
		
		if (actual.equals(expect)) {
			
			System.out.println("user clicked the Terms & Conditions link its properly redirected to Terms & Conditions page");
			Assert.assertTrue(true);
			
		}else {
			System.out.println("user clicked theTerms & Conditions link its not redirected to Terms & Conditions page");
			Assert.assertTrue(false);
		}
	
		
		Thread.sleep(2000);
		
	}
	
	@Test(priority=15,enabled=false)
	private void privacyPolicy() throws InterruptedException {
    
		
		
		WebElement priPolicy = driver.findElement(By.xpath("//a[text()='Privacy Policy']"));
		//Thread.sleep(1000);
		//priPolicy.click();
		js.executeScript("arguments[0].click();", priPolicy);
		Thread.sleep(4000);
		
		String actual = driver.getTitle();
		
		
		String expect="Privacy Policy";
		
		
	
		
		if (actual.equals(expect)) {
			
			System.out.println("user clicked the Privacy Policy link its properly redirected to Privacy Policy page");
			Assert.assertTrue(true);
			
		}else {
			System.out.println("user clicked the Privacy Policy link its not redirected to Privacy Policy page");
			Assert.assertTrue(false);
		}
	
		
		Thread.sleep(2000);	
	
	}
	
	
	@Test(priority=16,enabled=false)
	private void uAE() throws InterruptedException {
    
		
		
		WebElement uae = driver.findElement(By.xpath("//a[text()='UAE Consumer Rights']"));
		//Thread.sleep(1000);
		//uae.click();
		js.executeScript("arguments[0].click();", uae);
		Thread.sleep(4000);
		
		String actual = driver.getTitle();
		
		
		String expect="UAE Consumer Rights";
		

		
		if (actual.equals(expect)) {
			
			System.out.println("user clicked the UAE Consumer Rights link its properly redirected to UAE Consumer Rights page");
			Assert.assertTrue(true);
			
		}else {
			System.out.println("user clicked the UAE Consumer Rights its not redirected to UAE Consumer Rights page");
			Assert.assertTrue(false);
		}
	
		
		Thread.sleep(2000);		
			
	}
	
		
	@Test(priority=17,enabled=false)
	private void boxFileRingBinders() throws InterruptedException {
    
		
		WebElement uae = driver.findElement(By.xpath("//a[text()='Box Files & Ring Binders']"));
		js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", uae);
	   //	uae.click();
		
		Thread.sleep(4000);
		
		String actual = driver.getTitle();
		
		
		
		String expect="Box Files & Ring Binders: Buy Box Files & Ring Binders online in Dubai - Algurg Stationery";
		

		
		if (actual.equals(expect)) {
			
			System.out.println("user clicked the Box Files & Ring Binders link its properly redirected to Box Files & Ring Binders page");
			Assert.assertTrue(true);
			
		}else {
			System.out.println("user clicked the Box Files & Ring Binders its not redirected to Box Files & Ring Binders page");
			Assert.assertTrue(false);
		}
	
		
		Thread.sleep(2000);		
	
	}
	
	
	@Test(priority=18,enabled=false)
	private void dividersAndSpineBars() throws InterruptedException {
    

		WebElement driverSpine = driver.findElement(By.xpath("//a[text()='Dividers & Spine Bars']"));
		
		js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", driverSpine);
		//uae.click();
		
		Thread.sleep(4000);
		
		String actual = driver.getTitle();
		
		
		String expect="Shop File Dividers & Spine Bars Online | Al Gurg Stationery";
		

		
		if (actual.equals(expect)) {
			
			System.out.println("user clicked the Dividers & Spine Bars link its properly redirected to Dividers & Spine Bars page");
			Assert.assertTrue(true);
			
		}else {
			System.out.println("user clicked the Dividers & Spine Bars its not redirected to Dividers & Spine Bars page");
			Assert.assertTrue(false);
		}
	
		
		Thread.sleep(2000);		
	
	}
	
	@Test(priority=19,enabled=false)
	private void documentBagsAndDisplayBooks() throws InterruptedException {
    

		WebElement dbdb = driver.findElement(By.xpath("//a[text()='Document Bags & Display Books']"));
		js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",dbdb);
		//dbdb.click();
		
		Thread.sleep(4000);
		
		String actual = driver.getTitle();
		
	
		
		String expect="Buy Document Folders & Display Books UAE | Al Gurg Stationery";
		

		
		if (actual.equals(expect)) {
			
			System.out.println("user clicked the Document Bags & Display Books link its properly redirected to Document Bags & Display Books page");
			Assert.assertTrue(true);
			
		}else {
			System.out.println("user clicked the Document Bags & Display Books its not redirected to Document Bags & Display Books page");
			Assert.assertTrue(false);
		}
	
		
		Thread.sleep(2000);			
	
	}
	
	
	@Test(priority=20,enabled=false)
	private void otherFilesAndFolders() throws InterruptedException {

		
		WebElement ofaf = driver.findElement(By.xpath("//a[text()='Other Files & Folders']"));
		js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", ofaf);
		//ofaf.click();
		
		Thread.sleep(4000);
		
		String actual = driver.getTitle();
		
		
		
		String expect="Shop Files & Folder Accessories Online | Al Gurg Stationery";
		

		
		if (actual.equals(expect)) {
			
			System.out.println("user clicked the Other Files & Folders link its properly redirected to Other Files & Folders page");
			Assert.assertTrue(true);
			
		}else {
			System.out.println("user clicked the Other Files & Folders its not redirected to Other Files & Folders page");
			Assert.assertTrue(false);
		}
	
		
		Thread.sleep(2000);	
		
		
	}
	
	@Test(priority=21,enabled=false)
	private void airPurifiers() throws InterruptedException {

		
		WebElement air = driver.findElement(By.xpath("//a[text()='Air Purifiers']"));
		air.click();
		
		Thread.sleep(4000);
		
		String actual = driver.getTitle();
		
		System.out.println(actual);
		
		String expect="Buy Air Purifiers & Filters Online Dubai | Al Gurg Stationery";
		

		
		if (actual.equals(expect)) {
			
			System.out.println("user clicked the Air Purifiers link its properly redirected to Air Purifiers page");
			Assert.assertTrue(true);
			
		}else {
			System.out.println("user clicked the Air Purifiers its not redirected to Air Purifiers page");
			Assert.assertTrue(false);
		}
	
		
		Thread.sleep(2000);	
		
	}
	
	
	@Test(priority=22,enabled=false)
	private void calculators() throws InterruptedException {

		
		WebElement cal = driver.findElement(By.xpath("//a[text()='Calculators']"));
		cal.click();
		
		Thread.sleep(4000);
		
		String actual = driver.getTitle();
		
		System.out.println(actual);
		
		String expect="Buy Digital & Scientific Calculators Online |Al Gurg Stationery";
		

		
		if (actual.equals(expect)) {
			
			System.out.println("user clicked the Calculators link its properly redirected to Calculators page");
			Assert.assertTrue(true);
			
		}else {
			System.out.println("user clicked the Calculators its not redirected to Calculators page");
			Assert.assertTrue(false);
		}
	
		
		Thread.sleep(2000);	
		
	}
	
	
	@Test(priority=23,enabled=false)
	private void laminators() throws InterruptedException {

		
		WebElement laminators = driver.findElement(By.xpath("//a[text()='Laminators']"));
		laminators.click();
		
		Thread.sleep(4000);
		
		String actual = driver.getTitle();
		
		System.out.println(actual);
		
		String expect="Shop Laminating Machines Online in Dubai | Al Gurg Stationery";
		

		
		if (actual.equals(expect)) {
			
			System.out.println("user clicked the Laminators link its properly redirected to Laminators page");
			Assert.assertTrue(true);
			
		}else {
			System.out.println("user clicked the Laminators its not redirected to Laminators page");
			Assert.assertTrue(false);
		}
	
		
		Thread.sleep(2000);	
		
	}
	
	
	
	@Test(priority=24,enabled=false)
	private void shredders() throws InterruptedException {

		
		WebElement shredders = driver.findElement(By.xpath("//a[text()='Shredders']"));
		shredders.click();
		
		Thread.sleep(4000);
		
		String actual = driver.getTitle();
		
		System.out.println(actual);
		
		String expect="Buy Paper Shredders Online in Dubai & UAE | Al Gurg Stationery";
		

		
		if (actual.equals(expect)) {
			
			System.out.println("user clicked the Shredders link its properly redirected to Shredders page");
			Assert.assertTrue(true);
			
		}else {
			System.out.println("user clicked the Shredders its not redirected to Shredders page");
			Assert.assertTrue(false);
		}
	
		
		Thread.sleep(2000);	
		
	}
	
	@Test(priority=25,enabled=false)
	private void supplyAccessories() throws InterruptedException {

		
		WebElement supAcc = driver.findElement(By.xpath("//a[text()='Supplies & Accessories']"));
		supAcc.click();
		
		Thread.sleep(4000);
		
		String actual = driver.getTitle();
		
		System.out.println(actual);
		
		String expect="Buy Office Accessories, Toners Online | Al Gurg Stationery";
		

		
		if (actual.equals(expect)) {
			
			System.out.println("user clicked the Supplies & Accessories link its properly redirected to Supplies & Accessories page");
			Assert.assertTrue(true);
			
		}else {
			System.out.println("user clicked the Supplies & Accessories its not redirected to Supplies & Accessories page");
			Assert.assertTrue(false);
		}
	
		
		Thread.sleep(2000);	
		
	}
	
	
	@Test(priority=26,enabled=false)
	private void login() throws InterruptedException {

		
		WebElement login = driver.findElement(By.xpath("//a[text()='Log In']"));
		login.click();
		
		Thread.sleep(4000);
		
		String actual = driver.getTitle();
		
		System.out.println(actual);
		
		String expect="Customer Login";
		

		
		if (actual.equals(expect)) {
			
			System.out.println("user clicked the Log In link its properly redirected to Log In page");
			Assert.assertTrue(true);
			
		}else {
			System.out.println("user clicked the Log In its not redirected to Log In page");
			Assert.assertTrue(false);
		}
	
		
		Thread.sleep(4000);	
		
	}
	
	@Test(priority=27,enabled=false)
	private void register() throws InterruptedException {

		
		WebElement login = driver.findElement(By.xpath("//a[text()='Register']"));
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",login);
		
		//login.click();
		
		Thread.sleep(4000);
		
		String actual = driver.getTitle();
		
		System.out.println(actual);
		
		String expect="Create New Customer Account";
		

		
		if (actual.equals(expect)) {
			
			System.out.println("user clicked the Register link its properly redirected to Register page");
			Assert.assertTrue(true);
			
		}else {
			System.out.println("user clicked the Register its not redirected to Register page");
			Assert.assertTrue(false);
		}
	
		
		Thread.sleep(2000);	
		
	}
	
	
	@Test(priority=27,enabled=false)
	private void accountSetting() throws InterruptedException {

		
		WebElement accSetting = driver.findElement(By.xpath("//a[text()='Account Settings']"));
		accSetting.click();
		
		Thread.sleep(4000);
		
		String actual = driver.getTitle();
		
		System.out.println(actual);
		
		String expect="Create New Customer Account";
		

		
		if (actual.equals(expect)) {
			
			System.out.println("user clicked the Account Settings link its properly redirected to Account Settings page");
			Assert.assertTrue(true);
			
		}else {
			System.out.println("user clicked the Account Settings its not redirected to Account Settings page, because user as not logged in");
			//Assert.assertTrue(false);
		}
	
		
		Thread.sleep(2000);	
		
	}
	
	
	@Test(priority=28,enabled=false)
	private void businessServices() throws InterruptedException {

		
		WebElement businesService = driver.findElement(By.xpath("//a[text()='Business Services']"));
		businesService.click();
		
		Thread.sleep(4000);
		
		String actual = driver.getTitle();
		
		System.out.println(actual);
		
		String expect="Business Services";
		

		
		if (actual.equals(expect)) {
			
			System.out.println("user clicked the Business Services link its properly redirected to Business Services page");
			Assert.assertTrue(true);
			
		}else {
			System.out.println("user clicked the Business Services its not redirected to Business Services page");
			Assert.assertTrue(false);
		}
	
		
		Thread.sleep(2000);	
		
	}
	
	

	@Test(priority=29,enabled=false)
	private void businesLogReg() throws InterruptedException {

		
		WebElement businesLogReg = driver.findElement(By.xpath("//a[text()='Business Login / Register']"));
		businesLogReg.click();
		
		Thread.sleep(4000);
		
		String actual = driver.getTitle();
		
		System.out.println(actual);
		
		String expect="My Account";
		

		
		if (actual.equals(expect)) {
			
			System.out.println("user clicked the Business Login / Register  link its properly redirected to MyAccount page");
			Assert.assertTrue(true);
			
		}else {
			System.out.println("user clicked the Business Login / Register its not redirected to MyAccount page,because user not logged in so it redirect to login page");
		//	Assert.assertTrue(false);
		}
	
		
		Thread.sleep(2000);	
		
	}
	
	
	@Test(priority=30,enabled=false)
	private void whoWeAre() throws InterruptedException {

		
		WebElement whoWeAre = driver.findElement(By.xpath("//a[text()='Who we are?']"));
		whoWeAre.click();
		
		Thread.sleep(4000);
		
		String actual = driver.getTitle();
		
		System.out.println(actual);
		
		String expect="About us – Stationery Supplier in the UAE | Al Gurg Stationery";
		

		
		if (actual.equals(expect)) {
			
			System.out.println("user clicked the Who we are?  link its properly redirected About Us page");
			Assert.assertTrue(true);
			
		}else {
			System.out.println("user clicked the Who we are? its not redirected to About Us page");
			Assert.assertTrue(false);
		}
	
		
		Thread.sleep(2000);	
		
	}
	
	
	@Test(priority=31,enabled=false)
	private void ourLocations() throws InterruptedException {

		
		WebElement locations = driver.findElement(By.xpath("//a[text()='Our Locations']"));
		locations.click();
		
		Thread.sleep(4000);
		
		String actual = driver.getTitle();
		
		System.out.println(actual);
		
		String expect="Contact Us";
		

		
		if (actual.equals(expect)) {
			
			System.out.println("user clicked the Our Locations link its properly redirected Contact Us page");
			Assert.assertTrue(true);
			
		}else {
			System.out.println("user clicked the Our Locations its not redirected to Contact Us page");
			Assert.assertTrue(false);
		}
	
		
		Thread.sleep(2000);	
		
	}
	
	
	@Test(priority=32,enabled=false)
	private void careers() throws InterruptedException {

		
		WebElement careers = driver.findElement(By.xpath("//a[text()='Careers']"));
		careers.click();
		
		Thread.sleep(4000);
		
		String parentWindow = driver.getWindowHandle();
		
		Set<String> childWindow = driver.getWindowHandles();
		
		List<String> li = new ArrayList<String>(childWindow);
		
		driver.switchTo().window(li.get(1));
		
		
		String actual = driver.getTitle();
		
		System.out.println(actual);
		
		String expect="Human Capital - Easa Saleh Al Gurg Group";
		

		
		if (actual.equals(expect)) {
			
			System.out.println("user clicked the Careers link its properly redirected Human Capital - Easa Saleh Al Gurg Group page");
			Assert.assertTrue(true);
			
		}else {
			System.out.println("user clicked the Careers its not redirected to Human Capital - Easa Saleh Al Gurg Group page");
			Assert.assertTrue(false);
		}
	
		
		driver.switchTo().window(li.get(0));
		
		Thread.sleep(2000);	
		
	}
	
	
	@Test(priority=33,enabled=false)
	private void siteMap() throws InterruptedException {

		
		WebElement sitMap = driver.findElement(By.xpath("//a[text()='Sitemap']"));
		sitMap.click();
		
		Thread.sleep(4000);
		
		String actual = driver.getTitle();
		
		System.out.println(actual);
		
		String expect="Sitemap";
		

		
		if (actual.equals(expect)) {
			
			System.out.println("user clicked the  Sitemap link its properly redirected Sitemap page");
			Assert.assertTrue(true);
			
		}else {
			System.out.println("user clicked the Sitemap its not redirected to Sitemap  page");
			Assert.assertTrue(false);
		}
	
		
		Thread.sleep(2000);	
		
	}
	
	
	@Test(priority=34,enabled=false)
	private void M3() throws InterruptedException {

		
		WebElement M3 = driver.findElement(By.xpath("//a[text()='3M']"));
		M3.click();
		
		Thread.sleep(4000);
		
		String actual = driver.getTitle();
		
		System.out.println(actual);
		
		String expect="Shop 3M Stationery Supplies Online Dubai | Al Gurg Stationery";
		

		
		if (actual.equals(expect)) {
			
			System.out.println("user clicked the  3M link its properly redirected 3M page");
			Assert.assertTrue(true);
			
		}else {
			System.out.println("user clicked the 3M its not redirected to 3M  page");
			Assert.assertTrue(false);
		}
	
		
		Thread.sleep(2000);	
		
	}
	
	
	@Test(priority=35,enabled=false)
	private void bic() throws InterruptedException {

		
		WebElement bic = driver.findElement(By.xpath("//a[text()='Bic']"));
		bic.click();
		
		Thread.sleep(4000);
		
		String actual = driver.getTitle();
		
		System.out.println(actual);
		
		String expect="Shop Bic Writing Instruments Online UAE | Al Gurg Stationery";
		

		
		if (actual.equals(expect)) {
			
			System.out.println("user clicked the  Bic link its properly redirected Bic page");
			Assert.assertTrue(true);
			
		}else {
			System.out.println("user clicked the Bic its not redirected to Bic  page");
			Assert.assertTrue(false);
		}
	
		
		Thread.sleep(2000);	
		
	}
	
	
	@Test(priority=36,enabled=false)
	private void deli() throws InterruptedException {

		
		WebElement deli = driver.findElement(By.xpath("//a[text()='Deli']"));
		deli.click();
		
		Thread.sleep(4000);
		
		String actual = driver.getTitle();
		
		System.out.println(actual);
		
		String expect="Deli: Office & School Stationery Supplies | Al Gurg Stationery";
		

		
		if (actual.equals(expect)) {
			
			System.out.println("user clicked the  Deli link its properly redirected Deli page");
			Assert.assertTrue(true);
			
		}else {
			System.out.println("user clicked the Deli its not redirected to Deli  page");
			Assert.assertTrue(false);
		}
	
		
		Thread.sleep(2000);	
		
	}
	
	
	@Test(priority=37,enabled=false)
	private void durable() throws InterruptedException {

		
		WebElement durable = driver.findElement(By.xpath("//a[text()='Durable']"));
		durable.click();
		
		Thread.sleep(4000);
		
		String actual = driver.getTitle();
		
		System.out.println(actual);
		
		String expect="Shop Durable Files, Folders & Accessories | Al Gurg Stationery";
		

		
		if (actual.equals(expect)) {
			
			System.out.println("user clicked the  Durable link its properly redirected Durable page");
			Assert.assertTrue(true);
			
		}else {
			System.out.println("user clicked the Durable its not redirected to Durable  page");
			Assert.assertTrue(false);
		}
	
		
		Thread.sleep(2000);	
		
	}
	
	
	@Test(priority=38,enabled=false)
	private void edding() throws InterruptedException {

		
		WebElement edding = driver.findElement(By.xpath("//a[text()='Edding']"));
		edding.click();
		
		Thread.sleep(4000);
		
		String actual = driver.getTitle();
		
		System.out.println(actual);
		
		String expect="Buy Edding Pens & Markers Online in UAE | Al Gurg Stationery";
		

		
		if (actual.equals(expect)) {
			
			System.out.println("user clicked the  Edding link its properly redirected Edding page");
			Assert.assertTrue(true);
			
		}else {
			System.out.println("user clicked the Edding its not redirected to Edding  page");
			Assert.assertTrue(false);
		}
	
		
		Thread.sleep(2000);	
		
	}
	
	
	@Test(priority=39,enabled=false)
	private void elba() throws InterruptedException {

		
		WebElement elba = driver.findElement(By.xpath("//a[text()='Elba']"));
	    js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", elba);
		//elba.click();
		
		Thread.sleep(4000);
		
		String actual = driver.getTitle();
		
		System.out.println(actual);
		
		String expect="Elba";
		

		
		if (actual.equals(expect)) {
			
			System.out.println("user clicked the  Elba link its properly redirected Elba page");
			Assert.assertTrue(true);
			
		}else {
			System.out.println("user clicked the Elba its not redirected to Elba  page");
			Assert.assertTrue(false);
		}
	
		
		Thread.sleep(2000);	
		
	}
	
	
	@Test(priority=40,enabled=false)
	private void elfen() throws InterruptedException {

		
		WebElement elfen = driver.findElement(By.xpath("//a[text()='Elfen']"));
		js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",elfen);
		//elfen.click();

		
		Thread.sleep(4000);
		
		String actual = driver.getTitle();
		
		System.out.println(actual);
		
		String expect="Buy Elfen Box Files, Folders Online UAE | Al Gurg Stationery";
		

		
		if (actual.equals(expect)) {
			
			System.out.println("user clicked the  Elfen link its properly redirected Elfen page");
			Assert.assertTrue(true);
			
		}else {
			System.out.println("user clicked the Elfen its not redirected to Elfen  page");
			Assert.assertTrue(false);
		}
	
		
		Thread.sleep(2000);	
		
	}
	
	
	@Test(priority=41,enabled=false)
	private void falken() throws InterruptedException {

		
		WebElement falken = driver.findElement(By.xpath("//a[text()='Falken']"));
		js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",falken);
		//falken.click();
		
		Thread.sleep(4000);
		
		String actual = driver.getTitle();
		
		System.out.println(actual);
		
		String expect="Falken: Buy Office Filing Products Online | Al Gurg Stationery";
		

		
		if (actual.equals(expect)) {
			
			System.out.println("user clicked the  Falken link its properly redirected Falken page");
			Assert.assertTrue(true);
			
		}else {
			System.out.println("user clicked the Falken its not redirected to Falken  page");
			Assert.assertTrue(false);
		}
	
		
		Thread.sleep(2000);	
		
	}
	
	//dependsOnMethods = {"printingPapers"}
	@Test(priority=42,enabled=true)
	private void fellowes() throws InterruptedException {

		
	
		
		WebElement fellowes = driver.findElement(By.xpath("//a[text()='Fellowes']"));
		//WebDriverWait wait = new WebDriverWait(driver, 10);
		//WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Fellowes']")));
		js = (JavascriptExecutor)driver;
		
		driver.navigate().refresh();
		js.executeAsyncScript("arguments[0].click();", fellowes);
		//fellowes.click();
		
		
		Thread.sleep(2000);
		
		String actual = driver.getTitle();
		
		System.out.println(actual);
		
		String expect="Sitemap";
		

		
		if (actual.equals(expect)) {
			
			System.out.println("user clicked the  Fellowes link its properly redirected Fellowes page");
			Assert.assertTrue(true);
			
		}else {
			System.out.println("user clicked the Fellowes its not redirected to Fellowes  page");
			Assert.assertTrue(false);
		}
	
		
		Thread.sleep(2000);	
		
	}
	
	
	@Test(priority=43,enabled=false)
	private void hsm() throws InterruptedException {

		
		WebElement hsm = driver.findElement(By.xpath("//a[text()='Hsm']"));
		js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",hsm);
		
		//hsm.click();
		
		Thread.sleep(4000);
		
		String actual = driver.getTitle();
		
		System.out.println(actual);
		
		String expect="HSM: Buy Document Shredders Online UAE | Al Gurg Stationery";
		

		
		if (actual.equals(expect)) {
			
			System.out.println("user clicked the  Hsm link its properly redirected Hsm page");
			Assert.assertTrue(true);
			
		}else {
			System.out.println("user clicked the Hsm its not redirected to Hsm  page");
			Assert.assertTrue(false);
		}
	
		
		Thread.sleep(2000);	
		
	}
	
	
	@Test(priority=44,enabled=false)
	private void omega() throws InterruptedException {

		
		WebElement omega = driver.findElement(By.xpath("//a[text()='Omega']"));
		js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", omega);
		
		//omega.click();
		
		Thread.sleep(4000);
		
		String actual = driver.getTitle();
		
		System.out.println(actual);
		
		String expect="Omega";
		

		
		if (actual.equals(expect)) {
			
			System.out.println("user clicked the  Omega link its properly redirected Omega page");
			Assert.assertTrue(true);
			
		}else {
			System.out.println("user clicked the Omega its not redirected to Omega  page");
			Assert.assertTrue(false);
		}
	
		
		Thread.sleep(2000);	
		
	}
	
	
	@Test(priority=45,enabled=false)
	private void paperOne() throws InterruptedException {

		
		WebElement paper = driver.findElement(By.xpath("//a[text()='Paper One']"));
		paper.click();
		
		Thread.sleep(4000);
		
		String actual = driver.getTitle();
		
		System.out.println(actual);
		
		String expect="PaperOne: Shop Paper Supplies Online UAE | Al Gurg Stationery";
		

		
		if (actual.equals(expect)) {
			
			System.out.println("user clicked the  Paper One link its properly redirected Paper One page");
			Assert.assertTrue(true);
			
		}else {
			System.out.println("user clicked the Paper One its not redirected to Paper One  page");
			Assert.assertTrue(false);
		}
	
		
		Thread.sleep(2000);	
		
	}
	
	
	@Test(priority=46,enabled=false)
	private void perfekt() throws InterruptedException {

		
		WebElement perfekt = driver.findElement(By.xpath("//a[text()='Perfekt']"));
		perfekt.click();
		
		Thread.sleep(4000);
		
		String actual = driver.getTitle();
		
		System.out.println(actual);
		
		String expect="Perfekt";
		

		
		if (actual.equals(expect)) {
			
			System.out.println("user clicked the Perfekt link its properly redirected Perfekt page");
			Assert.assertTrue(true);
			
		}else {
			System.out.println("user clicked the Perfekt its not redirected to Perfekt page");
			Assert.assertTrue(false);
		}
	
		
		Thread.sleep(2000);	
		
	}
	
	
	
	
	@Test(priority=47,enabled=false)
	private void rexel() throws InterruptedException {

		
		WebElement rexel = driver.findElement(By.xpath("//a[text()='Rexel']"));
		rexel.click();
		
		Thread.sleep(4000);
		
		String actual = driver.getTitle();
		
		System.out.println(actual);
		
		String expect="Rexel";
		

		
		if (actual.equals(expect)) {
			
			System.out.println("user clicked the Rexel link its properly redirected Rexel page");
			Assert.assertTrue(true);
			
		}else {
			System.out.println("user clicked the Rexel its not redirected to Rexel page");
			Assert.assertTrue(false);
		}
	
		
		Thread.sleep(2000);	
		
	}
	
	
	@Test(priority=48,enabled=false)
	private void avery() throws InterruptedException {

		
		WebElement avery = driver.findElement(By.xpath("//a[text()='Avery']"));
		avery.click();
		
		Thread.sleep(4000);
		
		String actual = driver.getTitle();
		
		System.out.println(actual);
		
		String expect="AVERY";
		

		
		if (actual.equals(expect)) {
			
			System.out.println("user clicked the Avery link its properly redirected Avery page");
			Assert.assertTrue(true);
			
		}else {
			System.out.println("user clicked the Avery its not redirected to Avery page");
			Assert.assertTrue(false);
		}
	
		
		Thread.sleep(2000);	
		
	}
	
	
	
	@AfterClass
	private void end() {
    
	//	driver.quit();
		
	}
	
	
		
	}
	
	
	

