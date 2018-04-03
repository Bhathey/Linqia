package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class IntroductionPage extends TestBase {
	@FindBy(xpath="//a[text()='Documentation']")
	WebElement documnetation;
	@FindBy(xpath="//a[text()='Learn']")
	WebElement learn;
	@FindBy(xpath="//a[text()='API']")
	WebElement api;
	public IntroductionPage(){
		PageFactory.initElements(driver, this);

	}
	public String validateTitle(){
		return driver.getTitle();
		}
	
	public void clickOnLearn(){
		Actions action = new Actions(driver);
		action.moveToElement(learn).build().perform();;
		action.moveToElement(api).click().perform();
	}
	
}
