package com.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WebElementLocators {

	// Project 1 WebTesting

	public static By DraggableDebitBank = By.xpath("//li[@class='block14 ui-draggable']/a[@class=\"button button-orange\"][1]");
	public static By DroppableAccountBank = By.xpath("//ol[@class='field14 ui-droppable ui-sortable']");
	public static By DraggableDebitAmount = By.xpath("//li[@class='block13 ui-draggable']/preceding-sibling::li[@id='fourth']");
	public static By DroppableDebitAmount = By.xpath("//ol[@class='field13 ui-droppable ui-sortable' and @id='amt7']/li");
	public static By DraggableCreditSales = By.xpath("//li[@class='block15 ui-draggable']/a[@class='button button-orange']");
	public static By DroppableCreditSales = By.xpath("//ol[@class='field15 ui-droppable ui-sortable']");
	public static By DroppableCreditAmount = By.xpath("//ol[@class='field13 ui-droppable ui-sortable' and @id='amt8']");
	public static By DateOfBirthInput = By.id("dateOfBirthInput");
	public static By ElementMonth = By.xpath("//select[@class=\\\"react-datepicker__month-select\\\"]");
	public static By ElementYear = By.xpath("//select[@class=\\\"react-datepicker__year-select\\\"]");
	public static By ElementDay = By.xpath("//div[@class=\\\"react-datepicker__week\\\"]/div[text()='5']");
	public static By SeleniumLink = By.xpath("//a[@class='dropdown-toggle' and contains(text(),'Selenium')]");
	public static By RadioAndCheckBoxLink = By.xpath("//a[contains(text(),'Radio & Checkbox Demo')]");	
	public static By RadioOption1 = By.xpath("//input[@type='radio' and @value='Option 1']");
	public static By RadioOption2 = By.xpath("//input[@type='radio' and @value='Option 2']");
	public static By RadioOption3 = By.xpath("//input[@type='radio' and @value='Option 3']");	
	public static By CheckBoxOption1 = By.xpath("//input[@type='checkbox' and @value='checkbox1']");
	public static By CheckBoxOption2 = By.xpath("//input[@type='checkbox' and @value='checkbox2']");
	public static By CheckBoxOption3 = By.xpath("//input[@type='checkbox' and @value='checkbox3']");	
	public static By SliderElement = By.xpath("//div[contains(text(),'Resizable box, starting at 200x200')]/following-sibling::span");
	public static By Slider = By.xpath("//input[@type='range']");
	public static By ResizeElement = By.xpath("//div[contains(text(),'Resizable box, starting at 200x200')]/following-sibling::span");
	public static By SwitchToLink = By.xpath("//li/a[contains(text(),'SwitchTo')]");
	public static By AlertsLink = By.xpath("//ul[@class='dropdown-menu']/li/a[contains(text(),'Alerts')]");
	public static By Frameslnk = By.xpath("//ul[@class='dropdown-menu']/li/a[contains(text(),'Frames')]");
	public static By AlertWithOk = By.xpath("//li/a[@href='#OKTab' and contains(text(),'Alert with OK ')]");
	public static By AlertWithOkAndCancel = By.xpath("//li/a[@href=\"#CancelTab\" and contains(text(),'Alert with OK & Cancel')]");
	public static By AlertWithTextBox = By.xpath("//li/a[@href='#Textbox' and contains(text(),'Alert with Textbox')]");
	public static By AlertsButtonlnk =  By.xpath("//button[contains(text(),'click the button to display an  alert box:')]");
	public static By AlertsWithConfirmButtonlnk = By.xpath("//button[contains(text(),'click the button to display a confirm box')]");
	public static By AlertsWithTextBoxlnk = By.xpath("//button[contains(text(),'click the button to display a confirm box')]");
	public static By AlertsWithPromptlnk = By.xpath("//button[contains(text(),'click the button to demonstrate the prompt box')]");
	public static By SingleIframelnk = By.xpath("//a[contains(text(),'Single Iframe')]"); 
	public static By IframeIframelnk = By.xpath("//a[contains(text(),'Iframe with in an Iframe')]"); 
	public static By TextBoxInsideFrame = By.xpath("//input[@type='text']"); 
	public static By MultiFrame = By.xpath("//iframe[@src='MultipleFrames.html']"); 
	public static By SingleFrame = By.xpath("//iframe[@style='float: left;height: 250px;width: 400px']");
	public static By DatePicker = By.xpath("//input[@id='datepicker1']");
	public static By DateSel = By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td/a[text()=5]");
	public static By MonthYearSel = By.xpath("//a[@title='Next']");
	public static By Morelnk = By.xpath("//a[@class='dropdown-toggle' and contains(text(),'More')]");
	public static By Modallnk = By.xpath("//li/a[contains(text(),'Modals')]");
	public static By ModalButtonlnk = By.xpath("//a[@data-toggle='modal' and @href='#myModal']");
	public static By ModalButtonlnk2 = By.xpath("//a[@data-toggle='modal' and @href='#myModal2']");
	public static By MultiModalButtonlnk = By.xpath("//a[@data-toggle='modal' and @href='#myModalMulti']");
	public static By ModalWindowTitle = By.xpath("//h4[@class='modal-title' and contains(text(),'Modal title')]");
	public static By ModalCloseBtn = By.xpath("//div[@class='modal-footer']/button[@data-dismiss='modal' and contains(text(),'Close')]");
	public static By CloselnkModal2 = By.xpath("//a[contains(text(),'Close')]");
	
	public static By Registerlink = By.xpath("//a[contains(text(),'REGISTER')]");
	public static By firstName = By.xpath("//input[@name='firstName']");
	public static By lastName = By.xpath("//input[@name='lastName']");
	public static By phone = By.xpath("//input[@name='phone']");
	public static By userName = By.xpath("//input[@name='userName']");
	public static By address1 = By.xpath("//input[@name='address1']");
	public static By city = By.xpath("//input[@name='city']");
	public static By state = By.xpath("//input[@name='state']");
	public static By postalCode = By.xpath("//input[@name='postalCode']");
	public static By country = By.xpath("//select[@name='country']");
	public static By email = By.xpath("//input[@name='email']");
	public static By password = By.xpath("//input[@name='password']");
	public static By confirmPassword = By.xpath("//input[@name='confirmPassword']");
	public static By SignOn = By.xpath("//a[contains(text(),'SIGN-ON')]");
	public static By SignIn = By.xpath("//a[contains(text(),' sign-in ')]");
	public static By LoginuserName = By.xpath("//input[@name='userName']");
	public static By LoginPassword = By.xpath("//input[@name='password']");
	public static By Submit = By.xpath("//input[@type=\"submit\"]");

	public static void SelectValueFromDropdown(List<WebElement> AllElements, WebElement DropDownValue) {
		// TODO Auto-generated method stub
		int TotalElements = AllElements.size();

		for (int i = 1; i <= TotalElements - 1; i++) {
			String DropDownFromScript = AllElements.get(i).getText();

			if (DropDownFromScript.equals(DropDownValue)) {
				AllElements.get(i).click();
				break;
			}
		}

	}

}
