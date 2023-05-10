package com.testcase.adminOverview;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import static org.testng.Assert.assertTrue;
import com.special.tool.User;
import com.universal.tool.oper;
import com.universal.tool.Table;
import com.element.location.alarmTask;
import com.special.action.EnterPage;

public class Admin4 {
	public static ChromeDriver driver;

	@BeforeMethod
	public void beforeMethod() {
		User.configExplore();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		User.login(driver);
		EnterPage.alarmTask(driver);
		oper.waitTime(3);
	}

	@Test
	public void testAddTask() {
		boolean result = false;
		WebElement addBut = driver.findElementByXPath(alarmTask.addTask);
		addBut.click();
		oper.waitTime(5);
		WebElement taskSel = driver.findElementByXPath(alarmTask.taskSel);
		User.selectOption(taskSel, "aaa");
		oper.waitTime(5);
		WebElement conSel = driver.findElementByXPath(alarmTask.alarmSel);
		User.selectOption(conSel, "hhh");
		oper.waitTime(5);
		WebElement confirmBut = driver.findElementByXPath(alarmTask.confirmBut);
		confirmBut.click();
		oper.waitTime(5);
		WebElement sucBut = driver.findElementByXPath(alarmTask.succBut);
		sucBut.click();
		oper.waitTime(3);

		WebElement taskTab = driver.findElementByXPath(alarmTask.taskTab);
		Table table = new Table(taskTab);
		int rowNo = table.getRowCount();
		int resultRow = table.getRowNo("aaa", 2, rowNo, table);
		System.out.println("-----" + resultRow);
		if (resultRow != -1) {
			result = true;
		}
		oper.waitTime(10);

		assertTrue(result);
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
}
