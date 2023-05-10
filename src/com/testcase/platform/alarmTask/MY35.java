package com.testcase.platform.alarmTask;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import static org.testng.Assert.assertTrue;

import com.special.tool.User;
import com.universal.tool.oper;
import com.universal.tool.Exploer;
import com.universal.tool.Table;

import com.element.location.alarmTask;
import com.special.action.EnterPage;

public class MY35 {
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
	public void testEditTask() {
		boolean result = false;
		WebElement task = driver.findElementByXPath(alarmTask.taskTab);
		Table taskTab = new Table(task);
		int rowNo = taskTab.getRowCount();
		int resultRow = taskTab.getRowNo("aaa", 2, rowNo, taskTab);
		if (resultRow != -1) {
			Exploer.scollToBottomofPag(driver);
			taskTab.tapText("ɾ��", resultRow, 5, taskTab, driver);
			oper.waitTime(5);
			WebElement confirmBut2 = driver.findElementByXPath(alarmTask.delConfirmBut);
			confirmBut2.click();
			oper.waitTime(5);
			WebElement task1 = driver.findElementByXPath(alarmTask.taskTab);
			Table newTab = new Table(task1);
			int row = newTab.getRowCount();
			int resultlast = newTab.getRowNo("aaa", 2, row, newTab);
			if (resultlast == -1) {
				result = true;
			}

		}
		oper.waitTime(5);

		assertTrue(result);
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
}
