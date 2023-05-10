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
import com.special.action.EnterPage;

public class MY32 {
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
		WebElement configAlarm = driver.findElementByXPath(AlarmConfig.Table);
		Table configTable = new Table(configAlarm);
		int rowNo = configTable.getRowCount();
		int resultRow = configTable.getRowNo("Test", 1, rowNo, configTable);

		System.out.println("-----" + resultRow);
		if (resultRow != -1) {
			configTable.tapText("ɾ��", resultRow, 6, configTable, driver);
			oper.waitTime(5);
			oper.waitTime(5);
			WebElement but = driver.findElementByXPath(AlarmConfig.confirmDel);
			but.click();
			oper.waitTime(5);
			WebElement check = driver.findElementByXPath(AlarmConfig.Table);
			Table checktab = new Table(check);
			int rowNo1 = checktab.getRowCount();
			int res = checktab.getRowNo("Test", 2, rowNo1, checktab);
			if (res == -1) {
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
