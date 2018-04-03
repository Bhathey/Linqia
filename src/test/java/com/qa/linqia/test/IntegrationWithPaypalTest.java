package com.qa.linqia.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.IntegratinWithPaypal;
import com.qa.pages.IntroductionPage;
import com.qa.pages.TodoPositive;
import com.qa.util.TestUtil;

public class IntegrationWithPaypalTest extends TestBase{
	IntroductionPage introPage;
	TodoPositive todo;
	IntegratinWithPaypal integrate;
	public IntegrationWithPaypalTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		introPage = new IntroductionPage();
		todo = new TodoPositive();
		integrate = new IntegratinWithPaypal();
		introPage = todo.documentation();

	}
	
	@Test(priority=1)
	public void clickOnSupportTest() throws IOException{
	integrate.clickOnSupport();
	TestUtil.takeScreenshotAtEndOfTest();
	}
	@Test
	public void verifyPageTextTest(){
		integrate.clickOnSupport();
		String verify = integrate.verifyPageText();
		Assert.assertEquals(verify, "Sponsor Vue.js Development");
	}
	@Test(enabled= false)
	public void paypalLogoTest(){
		integrate.clickOnSupport();
		integrate.clickOnPaypal();
		boolean flag = integrate.verifyLogo();
		Assert.assertTrue(flag);
		
	}
	@Test
	public void clickOnPaypalTest() throws InterruptedException, IOException{
		integrate.clickOnSupport();
		integrate.clickOnPaypal();
		integrate.enterMoney();
		integrate.clickOnNext();
		TestUtil.takeScreenshotAtEndOfTest();
		String title = integrate.verifyPaymentPageTitle();	
		Assert.assertEquals(title, "Log in to your PayPal account");
	}

	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
