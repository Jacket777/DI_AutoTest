package com.testcase.platform.alarmTask;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import static org.testng.Assert.assertTrue;

import java.util.List;

import com.special.tool.User;
import com.universal.tool.oper;
import com.universal.tool.Exploer;
import com.universal.tool.Table;

import com.element.location.alarmTask;
import com.special.action.EnterPage;

public class MY34 {
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
			taskTab.tapText("�༭", resultRow, 5, taskTab, driver);
			oper.waitTime(5);
			WebElement conSel = driver.findElementByXPath(alarmTask.addConfigSel);
			User.selectOption(conSel, "111");
			oper.waitTime(5);
			WebElement confirmBut = driver.findElementByXPath(alarmTask.addConfirmBut);
			confirmBut.click();
			oper.waitTime(5);
			WebElement confirmBut2 = driver.findElementByXPath(alarmTask.promptConfirmBut);
			confirmBut2.click();
			oper.waitTime(5);
			WebElement task1 = driver.findElementByXPath(alarmTask.taskTab);
			Table taskTab1 = new Table(task1);
			WebElement tabcell = taskTab1.getCell(resultRow, 3);
			List<WebElement> spans = tabcell.findElements(By.tagName("span"));
			for (int i = 0; i < spans.size(); i++) {
				String text = spans.get(i).getText();
				System.out.println(text);
				if (text.equals("111")) {
					result = true;
				}
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
