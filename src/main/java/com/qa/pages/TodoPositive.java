package com.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class TodoPositive extends TestBase{
	@FindBy(xpath="//input[@placeholder='What needs to be done?']")
	WebElement textbox;
	@FindBy(xpath="//label[text()='Selenim Webdriver']//preceding-sibling::input[@type='checkbox']")
	WebElement checkboxValueOne;
	@FindBy(xpath="//label[text()='Selenium Webdriver']")
	WebElement checkBoxVale;
	@FindBy(xpath="//a[text()='All']")
	WebElement allButton;
	@FindBy(xpath="//a[text()='Active']")
	WebElement activeButton;
	@FindBy(xpath="//a[text()='Completed']")
	WebElement completedButton;
	@FindBy(xpath="//button[@class='clear-completed']")
	WebElement clearCompletedButton;
	@FindBy(xpath="//a[text()='Documentation']")
	WebElement documnetation;
	@FindBy(xpath="//a[text()='let us know']")
	WebElement letUsKnowLink;
	public TodoPositive(){
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateTextfiled(){
	return textbox.isEnabled();
	}
	public void Entertext(String text) throws InterruptedException{
		textbox.sendKeys(text);
		textbox.sendKeys(Keys.ENTER);
		
		}
	
	public IntroductionPage documentation(){
		documnetation.click();
		return new IntroductionPage();
	}

	public void clickOnCheckBox() {
		checkboxValueOne.click();
		
	}
	public void clickOnclearComplete(){
		clearCompletedButton.click();
	}
	public String clickOnHelp(){
		letUsKnowLink.click();
		return driver.getCurrentUrl();
	}
}