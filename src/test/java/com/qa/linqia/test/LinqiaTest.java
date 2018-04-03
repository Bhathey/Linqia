package com.qa.linqia.test;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.util.TestUtil;

public class LinqiaTest {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\user\\Downloads\\chromedriver_win32 (3)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://todomvc.com/examples/vue/");

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test()
	public void enterTest() throws IOException {
		WebElement text = driver.findElement(By.xpath("//input[@placeholder='What needs to be done?']"));
		text.sendKeys("Selenium");
		text.sendKeys(Keys.ENTER);
		text.sendKeys("Test");
		text.sendKeys(Keys.ENTER);
		text.sendKeys("Java");
		text.sendKeys(Keys.ENTER);

		driver.findElement(By.xpath("//label[text()='Selenium']//preceding-sibling::input[@type='checkbox']")).click();
		driver.findElement(By.xpath("//button[@class='clear-completed']")).click();
		driver.findElement(By.xpath("//a[text()='All']")).click();
		List<WebElement> elements = driver.findElements(By.xpath("//div/label"));
		int size = elements.size();
		System.out.println(size);
		String validate = null;
		for (WebElement ele : elements) {
			validate = ele.getText();
			System.out.println(validate);
			//Assert.assertEquals(validate, "Test");

			if (validate.equals("Test") || validate.equals("Java"))
				System.out.println("Validated");
		}
		driver.close();
	}
}
