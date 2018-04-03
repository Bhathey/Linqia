package com.qa.linqia.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.IntroductionPage;
import com.qa.pages.TodoPositive;
import com.qa.util.TestUtil;


public class TodoTest extends TestBase {
	TodoPositive todo;
	IntroductionPage introPage;
	String sheetName = "homepage";
	
	public TodoTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		todo = new TodoPositive();
	}
	
	@Test(priority=1)
	public void validateTextFieldTest(){
		boolean flag = todo.validateTextfiled();
		Assert.assertTrue(flag);
	}
	
	@DataProvider
	public Object[][] getTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	
	@Test(priority=2,dataProvider="getTestData")
	public void enterTextTest(String TODO1) throws InterruptedException, IOException{
		todo.Entertext(TODO1);
		todo.Entertext(TODO1);
		todo.Entertext(TODO1);
		todo.clickOnCheckBox();
		todo.clickOnclearComplete();
		TestUtil.takeScreenshotAtEndOfTest();
}

	@Test(priority=3)
	public void documentation() throws IOException{
		 introPage = todo.documentation();
			TestUtil.takeScreenshotAtEndOfTest();

	}

	@Test(priority=4)
	public void helpTest() throws IOException{
		String currentUrl = todo.clickOnHelp();
		Assert.assertEquals(currentUrl, "https://github.com/tastejs/todomvc/issues");
			TestUtil.takeScreenshotAtEndOfTest();

	}
	
	
	
	
	@AfterMethod
	public void tearDown(){
		//driver.quit();
	}

}
