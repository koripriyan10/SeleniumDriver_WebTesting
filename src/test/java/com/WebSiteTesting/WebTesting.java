package com.WebSiteTesting;

import org.testng.annotations.Test;

import com.Utility.Library;
import com.google.common.io.Files;

import org.testng.annotations.BeforeTest;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.List;
import java.util.Set;
import org.apache.commons.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import com.Pages.WebElementLocators;

public class WebTesting extends Library {

//	Test the login screen with username and password
//	● Test online widgets like date pickers, tabs, sliders
//	● Test interactive actions like draggable, resizable, selectable etc.
//	● Test the filling up of registration form and submission
//	● Test frames and windows
//	● Test drop-down menus, alert boxes
	
	public static WebDriver driver;

	@BeforeSuite
	public void beforeSuite() throws IOException {
		
	}
	
	@Test(priority = 0, enabled = false)
	public void LauchBrowser() throws InterruptedException, IOException {
		
		ReadPropertiesFile();
		System.setProperty("webdriver.chrome.driver", "D:\\JavaWorkSpace\\WebTesting_Project\\src\\test\\resources\\chromedriver-v121\\chromedriver.exe");
		//driver = new FirefoxDriver();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test(priority = 1, enabled = false)
	public void RegisterScreenTest() throws InterruptedException {

		driver.navigate().to(objProperties.getProperty("RegisterScreenLink"));
		Thread.sleep(3000);
		driver.navigate().refresh();
		Thread.sleep(3000);
		driver.findElement(WebElementLocators.Registerlink).click();
		driver.findElement(WebElementLocators.firstName).sendKeys(objProperties.getProperty("firstname"));
		driver.findElement(WebElementLocators.lastName).sendKeys(objProperties.getProperty("lastName"));
		driver.findElement(WebElementLocators.phone).sendKeys(objProperties.getProperty("phone"));
		driver.findElement(WebElementLocators.userName).sendKeys(objProperties.getProperty("userName"));
		driver.findElement(WebElementLocators.address1).sendKeys(objProperties.getProperty("address1"));
		driver.findElement(WebElementLocators.city).sendKeys(objProperties.getProperty("city"));
		driver.findElement(WebElementLocators.state).sendKeys(objProperties.getProperty("state"));
		driver.findElement(WebElementLocators.postalCode).sendKeys(objProperties.getProperty("postalCode"));
		WebElement Country = driver.findElement(WebElementLocators.country);
		Select SelCountry = new Select(Country);
		SelCountry.selectByValue(objProperties.getProperty("country"));
		Thread.sleep(2000);
		driver.findElement(WebElementLocators.email).sendKeys(objProperties.getProperty("email"));
		driver.findElement(WebElementLocators.password).sendKeys(objProperties.getProperty("password"));
		driver.findElement(WebElementLocators.confirmPassword).sendKeys(objProperties.getProperty("confirmPassword"));
		driver.findElement(WebElementLocators.Submit).click();
		Thread.sleep(2000);
		driver.findElement(WebElementLocators.SignIn).click();
		Thread.sleep(3000);
	}

	@Test(priority = 2, enabled = false)
	public void LoginTest() throws InterruptedException {
		WebDriverWait wbContinue = new WebDriverWait(driver, 50);
		WebElement ContinueElem = wbContinue
				.until(ExpectedConditions.visibilityOfElementLocated(WebElementLocators.LoginuserName));
		driver.findElement(WebElementLocators.LoginuserName).sendKeys(objProperties.getProperty("loginUsername"));
		driver.findElement(WebElementLocators.LoginPassword).sendKeys(objProperties.getProperty("loginPassword"));
		driver.findElement(WebElementLocators.Submit).click();
	}

	@Test(priority = 3, enabled = false)
	public void DragAndDrop() throws InterruptedException {

		driver.navigate().to(objProperties.getProperty("DragAndDropLink"));
		Thread.sleep(5000);

		WebElement DraggableDebitBank = driver.findElement(WebElementLocators.DraggableDebitBank);
		WebElement DroppableAccountBank = driver.findElement(WebElementLocators.DroppableAccountBank);
		WebElement DraggableDebitAmount = driver.findElement(WebElementLocators.DraggableDebitAmount);
		WebElement DroppableDebitAmount = driver.findElement(WebElementLocators.DroppableDebitAmount);
		WebElement DraggableCreditSales = driver.findElement(WebElementLocators.DraggableCreditSales);
		WebElement DroppableCreditSales = driver.findElement(WebElementLocators.DroppableCreditSales);
		WebElement DroppableCreditAmount = driver.findElement(WebElementLocators.DroppableCreditAmount);

		Actions objActions = new Actions(driver);

		objActions.dragAndDrop(DraggableDebitBank, DroppableAccountBank).build().perform();
		objActions.dragAndDrop(DraggableDebitAmount, DroppableDebitAmount).build().perform();

		objActions.dragAndDrop(DraggableCreditSales, DroppableCreditSales).build().perform();
		objActions.dragAndDrop(DraggableDebitAmount, DroppableCreditAmount).build().perform();

	}

	@Test(priority = 4, enabled = false)
	public void DatePicker() throws InterruptedException {
		try {
			driver.navigate().to(objProperties.getProperty("DatePickerLink"));
			WebDriverWait wbContinue = new WebDriverWait(driver, 50);
			WebElement ContinueElem = wbContinue
					.until(ExpectedConditions.visibilityOfElementLocated(WebElementLocators.DatePicker));
			driver.findElement(WebElementLocators.DatePicker).click();
			driver.findElement(WebElementLocators.DateSel).click();
		}

		catch (StaleElementReferenceException e) {
			WebElement SelMonthYear = driver.findElement(WebElementLocators.MonthYearSel);

			Actions objAction = new Actions(driver);
			int clicks = 5;

			for (int i = 0; i < clicks; i++) {
				objAction.click(SelMonthYear).build().perform();
			}

		}
	}

	@Test(priority = 5, enabled = false)
	public void RadioAndCheckBoxValidate() throws InterruptedException {

		driver.navigate().to(objProperties.getProperty("NewToursLink"));
		driver.findElement(WebElementLocators.SeleniumLink).click();
		Thread.sleep(5000);
//        WebDriverWait wbContinue = new WebDriverWait(driver, 50);
//		WebElement ContinueElem = wbContinue
//				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Radio & Checkbox Demo')]")));
		driver.findElement(WebElementLocators.RadioAndCheckBoxLink).click();

		WebDriverWait wbContinue2 = new WebDriverWait(driver, 50);
		WebElement ContinueElem2 = wbContinue2
				.until(ExpectedConditions.visibilityOfElementLocated(WebElementLocators.RadioOption2));

		Thread.sleep(5000);

		driver.findElement(WebElementLocators.RadioOption2).click();
		driver.findElement(WebElementLocators.CheckBoxOption3).click();

		WebElement OptionValue = driver.findElement(WebElementLocators.RadioOption2);
		WebElement CheckboxValue = driver.findElement(WebElementLocators.CheckBoxOption3);
		String OptVal = OptionValue.getAttribute("value");
		String CheckBoxVal = CheckboxValue.getAttribute("value");

		System.out.println("OptionValue-" + OptVal);
		System.out.println("CheckboxValue-" + CheckBoxVal);

		WebElement Radiobutton1 = driver.findElement(WebElementLocators.RadioOption1);
		WebElement Radiobutton2 = driver.findElement(WebElementLocators.RadioOption2);
		WebElement Radiobutton3 = driver.findElement(WebElementLocators.RadioOption3);

		WebElement CheckBox1 = driver.findElement(WebElementLocators.CheckBoxOption1);
		WebElement CheckBox2 = driver.findElement(WebElementLocators.CheckBoxOption2);
		WebElement CheckBox3 = driver.findElement(WebElementLocators.CheckBoxOption3);

		if (Radiobutton1.isSelected()) {
			System.out.println("Option 1 Selected");
		}
		if (Radiobutton2.isSelected()) {
			System.out.println("Option 2 Selected");
		}
		if (Radiobutton3.isSelected()) {
			System.out.println("Option 3 Selected");
		}
		if (CheckBox1.isSelected()) {
			System.out.println("checkbox 1 Selected");
		}
		if (CheckBox2.isSelected()) {
			System.out.println("checkbox 2 Selected");
		}
		if (CheckBox3.isSelected()) {
			System.out.println("checkbox 3 Selected");
		}

	}

	@Test(priority = 6, enabled = false)
	public void Slider() {
		driver.navigate().to(objProperties.getProperty("SliderLink"));
		WebElement slider = driver.findElement(WebElementLocators.Slider); // Replace "slider-id" with the actual ID of
																			// your slider element
		int sliderWidth = 80;
		Actions actions = new Actions(driver);
		actions.clickAndHold(slider).moveByOffset(sliderWidth, 0).release().perform();

	}

	@Test(priority = 7, enabled = false)
	public void Resizable() {
		driver.navigate().to(objProperties.getProperty("ResizeableLink"));

		WebElement divElement = driver.findElement(WebElementLocators.ResizeElement); // Replace "slider-id" with the
																						// actual ID of your slider
																						// element
		resizeDivWithActions(driver, divElement, 50, 30);
	}

	// Alert Popup, Prompt Window
	@Test(priority = 8, enabled = false)
	public void AlertWindow() throws InterruptedException {
		driver.navigate().to(objProperties.getProperty("AutomationLink"));
		driver.findElement(WebElementLocators.SwitchToLink).click();
//			Thread.sleep(5000);
		WebDriverWait wbContinue = new WebDriverWait(driver, 50);
		WebElement ContinueElem = wbContinue
				.until(ExpectedConditions.visibilityOfElementLocated(WebElementLocators.AlertsLink));
		driver.findElement(WebElementLocators.AlertsLink).click();
		WebDriverWait wbContinue2 = new WebDriverWait(driver, 50);
		WebElement ContinueElem2 = wbContinue
				.until(ExpectedConditions.visibilityOfElementLocated(WebElementLocators.AlertsButtonlnk));
		driver.findElement(WebElementLocators.AlertsButtonlnk).click();
		Alert alert = driver.switchTo().alert();
		Thread.sleep(3000);
		alert.accept();
		driver.findElement(WebElementLocators.AlertWithOkAndCancel).click();
		driver.findElement(WebElementLocators.AlertsWithConfirmButtonlnk).click();
		alert.accept();
		driver.findElement(WebElementLocators.AlertWithTextBox).click();
		driver.findElement(WebElementLocators.AlertsWithPromptlnk).click();
		alert.sendKeys("");
		Thread.sleep(5000);
		alert.sendKeys("This is test");
		alert.accept();
		driver.findElement(WebElementLocators.AlertsWithPromptlnk).click();
		Thread.sleep(5000);
		alert.dismiss();
	}

	// Switching to Frame
	@Test(priority = 9, enabled = false)
	public void SwitchingToFrame() throws InterruptedException {

		driver.navigate().to(objProperties.getProperty("AutomationLink"));
		driver.findElement(WebElementLocators.SwitchToLink).click();
		driver.findElement(WebElementLocators.Frameslnk).click();
		WebDriverWait wbContinue = new WebDriverWait(driver, 50);
		WebElement ContinueElem = wbContinue
				.until(ExpectedConditions.visibilityOfElementLocated(WebElementLocators.SingleIframelnk));
		driver.findElement(WebElementLocators.IframeIframelnk).click();
		WebElement Multiframeelem = driver.findElement(WebElementLocators.MultiFrame);

		driver.switchTo().frame(Multiframeelem);
		WebElement Singleeelem = driver.findElement(WebElementLocators.SingleFrame);
		driver.switchTo().frame(Singleeelem);
		Thread.sleep(2000);
		driver.findElement(WebElementLocators.TextBoxInsideFrame).sendKeys("Test");
		driver.switchTo().defaultContent();
	}

	// Switching to Single Modal Window
	@Test(priority = 9, enabled = false)
	public void SwitchingToModal() throws InterruptedException {

		driver.navigate().to(objProperties.getProperty("AutomationLink"));
		driver.findElement(WebElementLocators.Morelnk).click();
		driver.findElement(WebElementLocators.Modallnk).click();
		WebDriverWait wbContinue = new WebDriverWait(driver, 50);
		WebElement ContinueElem = wbContinue
				.until(ExpectedConditions.visibilityOfElementLocated(WebElementLocators.ModalButtonlnk));
		driver.findElement(WebElementLocators.ModalButtonlnk).click();
		// Get current window
		String mainWindowHandle = driver.getWindowHandle();

		// Get All window handles
		Set<String> allWindowHandles = driver.getWindowHandles();

		for (String Handle : allWindowHandles) {
			// Handle.hashCode();
			driver.switchTo().window(Handle);
			// String Title =
			// driver.findElement(WebElementLocators.ModalWindowTitle).getText();
			String Title = driver.findElement(By.xpath("//h4[@class='modal-title' and contains(text(),'Modal title')]"))
					.getText();
			System.out.println("Title-" + Title);
			// driver.findElement(WebElementLocators.ModalCloseBtn).click();

		}

	}

	// Switching to Multiple Modal Window

	@Test(priority = 10, enabled = false)
	public void SwitchingToMultipleModal() throws InterruptedException {

		driver.navigate().to(objProperties.getProperty("AutomationLink"));
		driver.findElement(WebElementLocators.Morelnk).click();
		driver.findElement(WebElementLocators.Modallnk).click();
		WebDriverWait wbContinue = new WebDriverWait(driver, 50);
		WebElement ContinueElem = wbContinue
				.until(ExpectedConditions.visibilityOfElementLocated(WebElementLocators.MultiModalButtonlnk));
		driver.findElement(WebElementLocators.MultiModalButtonlnk).click();

		WebDriverWait wbContinue2 = new WebDriverWait(driver, 50);
		WebElement ContinueElem2 = wbContinue2
				.until(ExpectedConditions.visibilityOfElementLocated(WebElementLocators.FirstModal));
		// driver.findElement(By.xpath("//a[@data-dismiss='modal' and
		// contains(text(),'Close')]")).click();

		WebDriverWait wbContinue3 = new WebDriverWait(driver, 50);
		WebElement ContinueElem3 = wbContinue3
				.until(ExpectedConditions.visibilityOfElementLocated(WebElementLocators.SecondModal));

		String Title1 = driver.findElement(By.xpath("//h4[@class='modal-title' and contains(text(),'Modal 2')]"))
				.getText();
		System.out.println(Title1);

		Actions objAction = new Actions(driver);
		WebElement Close = driver.findElement(By.xpath("//a[@data-dismiss='modal' and contains(text(),'Close')]"));
		objAction.click(Close).build().perform();

		WebDriverWait wbContinue4 = new WebDriverWait(driver, 50);
		WebElement ContinueElem4 = wbContinue4
				.until(ExpectedConditions.visibilityOfElementLocated(WebElementLocators.MyModalMultiClose));

		String Title2 = driver.findElement(By.xpath("//h4[@class='modal-title' and contains(text(),'First Modal')]"))
				.getText();
		System.out.println(Title2);

		WebDriverWait wbContinue5 = new WebDriverWait(driver, 50);
		WebElement ContinueElem5 = wbContinue5
				.until(ExpectedConditions.visibilityOfElementLocated(WebElementLocators.MyModalMultiClose));

		// For handling Click Intercept Exception use move to element
		objAction.moveToElement(driver.findElement(WebElementLocators.MyModalMultiClose)).click().perform();

	}

	// Switching to Multiple Window

	@Test(priority = 10, enabled = false)
	public void SwitchingToMultipleWindow() throws InterruptedException {

//					//Get current window					
//					String mainWindowHandle = driver.getWindowHandle();				
//					//Get All window handles
//					Set<String> allWindowHandles = driver.getWindowHandles();
//					
//					for(String Handle:allWindowHandles)
//					{
//						   
//						    System.out.println(Handle);
//							driver.switchTo().window(Handle);
//							//String Title = driver.findElement(WebElementLocators.ModalWindowTitle).getText();
//							String Title1 = driver.findElement(By.xpath("//h4[@class='modal-title' and contains(text(),'First Modal')]")).getText();	
//							System.out.println(Title1);
//							System.out.println(Handle.hashCode());
//							Thread.sleep(5000);
//							//driver.findElement(By.xpath("//a[@data-dismiss='modal' and contains(text(),'Close')]")).click();													
//							driver.findElement(WebElementLocators.ModalButtonlnk2).click();	
//							driver.switchTo().window(Handle);
//							//driver.findElement(By.xpath("//a[@data-dismiss='modal' and contains(text(),'Close')]"));
//							Thread.sleep(5000);							
//							driver.switchTo().defaultContent();
//					}
	}

    // Taking screenshot

	@Test(priority = 11, enabled = false)
 	public void TakingScreenShot() throws InterruptedException, IOException {
        driver.navigate().to(objProperties.getProperty("AutomationLink"));
        driver.findElement(By.xpath("//a[contains(text(),'Practice Site')]")).click();
        
    
 		File objname = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
 		FileUtils.copyFile(objname, new File("E:\\Software Testing\\From Accord Info Matrix\\demoqa.png"));
	}
	
    // Java Robot class

	@Test(priority = 12, enabled = false)
 	public void Robot_Automate() throws InterruptedException, IOException, AWTException {
		
		driver.navigate().to(objProperties.getProperty("AmazonLink"));
		driver.manage().window().maximize();		
        Robot rbt = new Robot();
        rbt.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(2000);
        rbt.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(2000);
        rbt.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(2000);
        rbt.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(2000);
        rbt.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(2000);
        rbt.keyPress(KeyEvent.VK_L);
        rbt.keyPress(KeyEvent.VK_E);
        rbt.keyPress(KeyEvent.VK_D);
        rbt.keyPress(KeyEvent.VK_L);
        rbt.keyPress(KeyEvent.VK_A);
        rbt.keyPress(KeyEvent.VK_M);
        rbt.keyPress(KeyEvent.VK_P);
        rbt.keyPress(KeyEvent.VK_TAB);
        rbt.keyPress(KeyEvent.VK_ENTER);
	}

	// Window Handling
	
	@Test(priority = 13, enabled = false)
 	public void WindowHandle() throws InterruptedException, IOException, AWTException {
		
		driver.navigate().to("https://demoqa.com/browser-windows");
		driver.findElement(By.id("tabButton")).click();
		String MainId = driver.getWindowHandle();
		System.out.println("MainId:"+MainId);
		Set<String> AllWindow = driver.getWindowHandles();
		
		for(String a:AllWindow)
		{
			if(!a.equals(MainId))
			{
				System.out.println("ChildWindow");
				driver.switchTo().window(a);
				Thread.sleep(5000);
				//driver.findElement(By.xpath("//h1[contains(text(),'This is a')]")).getText();
				WebElement h1Element = driver.findElement(By.tagName("h1"));
				String h1text = h1Element.getText();
				System.out.println("HeadingElement:"+h1text);
				
			}
			
		}		
	}
	
	// File  Upload
	
	@Test(priority = 14, enabled = true)
 	public void FileUpload() throws InterruptedException, IOException, AWTException {
		System.setProperty("webdriver.gecko.driver", "D:\\JavaWorkSpace\\WebTesting_Project\\src\\test\\resources\\firefoxdriver-v33\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.navigate().to("https://demo.automationtesting.in/FileUpload.html");
		
		WebElement elm = driver.findElement(By.xpath("//input[@type='file']"));
		  
		  JavascriptExecutor j = (JavascriptExecutor) driver;
		  j.executeScript("arguments[0].click();", elm);
		  
		  File objFile = new File(System.getProperty("user.dir") + "//src//test//resources//Sample.jpg");
		  StringSelection ObjStringSelection = new StringSelection(objFile.toString()); 
		  Clipboard objClipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		  objClipboard.setContents(ObjStringSelection, null);
		    
		  try
		  {
			  Thread.sleep(5000);
			  Robot objRoot = new Robot();
			  objRoot.keyPress(KeyEvent.VK_ENTER);
			  objRoot.keyRelease(KeyEvent.VK_ENTER);
			  objRoot.keyPress(KeyEvent.VK_CONTROL);
			  objRoot.keyPress(KeyEvent.VK_V);
			  
			  objRoot.keyRelease(KeyEvent.VK_V);
			  objRoot.keyRelease(KeyEvent.VK_CONTROL);

			  
			  objRoot.keyPress(KeyEvent.VK_ENTER);
			  objRoot.keyRelease(KeyEvent.VK_ENTER);
		  }
		  
		  catch(AWTException e)
		  {
			  e.printStackTrace();
		  }		
	}


	private static void resizeDivWithActions(WebDriver driver, WebElement element, int xOffset, int yOffset) {
		Actions builder = new Actions(driver);
		builder.clickAndHold(element).moveByOffset(xOffset, yOffset).release().perform();
		System.out.println("resize");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("Beginning Test");
	}

}
