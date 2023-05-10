package com.testcase.platform.alarmPolicy;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import static org.testng.Assert.assertTrue;
import com.special.tool.User;
import com.universal.tool.oper;
import com.universal.tool.Table;
import com.element.location.AlarmConfig;
import com.element.location.relativeTask;
import com.special.action.EnterPage;

public class MY28 {
	public static ChromeDriver driver;

	@BeforeMethod
	public void beforeMethod() {
		User.configExplore();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		User.login(driver);
		EnterPage.alarmConfig(driver);
		oper.waitTime(3);
	}

	@Test
	public void testRelativeAlarmTask() {
		boolean result = false;
		WebElement table = driver.findElementByXPath(AlarmConfig.Table);
		Table newTable = new Table(table);
		int rowNo = newTable.getRowCount();
		int resultRow = newTable.getRowNo("Test", 1, rowNo, newTable);
		System.out.println("-----" + resultRow);
		if (resultRow != -1) {
			WebElement td = newTable.getCell(rowNo, 6);
			WebElement task = td.findElement(By.xpath("//a[text()='��������']"));
			if (task != null) {
				task.click();
				oper.waitTime(3);
				WebElement addButton = driver.findElementByXPath(relativeTask.addTask);
				if (addButton != null) {
					result = true;
				}
			}
		}
		assertTrue(result);
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
}
