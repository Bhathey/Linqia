package com.qa.pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class IntegratinWithPaypal extends TestBase {
	@FindBy(xpath="//a[text()='Support Vue']")
	WebElement support;
	@FindBy(xpath="//a[text()='One-time Donations']")
	WebElement oneTimeDonation;
	@FindBy(xpath="//h1[text()='Sponsor Vue.js Development']")
	WebElement verifypage;
	@FindBy(xpath="//img[@src='/images/paypal.png']")
	WebElement payPal;
	@FindBy(xpath="//div[@class='paypal-logo']")
	WebElement payPalLogo;
	@FindBy(xpath="//input[@class='amount-number']")
	WebElement enterAmount;
	@FindBy(xpath="//input[@class='profile-amount-submit-button paypal-button']")
	WebElement nextbutton;
	
	public IntegratinWithPaypal(){
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnSupport(){
		Actions action = new Actions(driver);
		action.moveToElement(support).build().perform();;
		action.moveToElement(oneTimeDonation).click().perform();
	}
	public String verifyPageText(){
		return verifypage.getText();
	}
	
	public void clickOnPaypal(){
		payPal.click();
	}
	public boolean verifyLogo(){
		return payPalLogo.isDisplayed();
	}
	public void enterMoney(){
		Set<String> handler = driver.getWindowHandles();
		Iterator<String> it = handler.iterator();
		String parentWindow  = it.next();
		String childWindowId = it.next();
		driver.switchTo().window(childWindowId);
		
		enterAmount.click();
		enterAmount.sendKeys("1");
	}
	public void clickOnNext(){
		nextbutton.submit();
	}
	public String verifyPaymentPageTitle(){
		return driver.getTitle();
	}

}
