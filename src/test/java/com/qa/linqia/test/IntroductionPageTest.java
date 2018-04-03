package com.qa.linqia.test;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.IntroductionPage;
import com.qa.pages.TodoPositive;
import com.qa.util.TestUtil;


public class IntroductionPageTest extends TestBase{
	IntroductionPage introPage;
	TodoPositive todo;
	public IntroductionPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		introPage = new IntroductionPage();
		todo = new TodoPositive();
	}
	
	@Test(priority=1)
	public void validatePageTitle() throws IOException{
		todo.documentation();
	String title = introPage.validateTitle();
	Assert.assertEquals(title, "Introduction — Vue.js");
	TestUtil.takeScreenshotAtEndOfTest();
	}
	@Test
	public void verifyclickOnLearn() throws IOException{
		todo.documentation();
		introPage.clickOnLearn();
		Assert.assertEquals(driver.getTitle(), "API — Vue.js");
		TestUtil.takeScreenshotAtEndOfTest();
	}
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}

