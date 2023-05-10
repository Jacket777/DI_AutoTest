package com.testcase.platform.alarmPolicy;

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
import com.element.location.AlarmConfig;
import com.element.location.AlarmPage;
import com.element.location.homePage;
import com.test.dataConfig.alarmConfig;

public class MY27 {
	public static ChromeDriver driver;

	@BeforeMethod
	public void beforeMethod() {
		User.configExplore();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		User.login(driver);
		WebElement alarmManager = driver.findElementByXPath(homePage.alarmManage);
		alarmManager.click();
		oper.waitTime(2);
		WebElement alarmPolicy = driver.findElementByXPath(AlarmPage.alarmConfig);
		alarmPolicy.click();
	}

	@Test
	public void testAddAlarm() {
		oper.waitTime(3);
		WebElement addButton = User.getElement(driver, AlarmConfig.addButton);
		addButton.click();
		oper.waitTime(3);
		WebElement configName = User.getElement(driver, AlarmConfig.configName);
		oper.inputText(configName, alarmConfig.configName);
		oper.waitTime(3);
		WebElement alarmType = User.getElement(driver, AlarmConfig.alarmType);
		User.selectOption(alarmType, alarmConfig.alarmType);
		oper.waitTime(3);
		WebElement alarmMan = User.getElement(driver, AlarmConfig.alarmMan);
		User.selectOption(alarmMan, alarmConfig.alarmMan);
		Exploer.scollToBottomofPag(driver);
		oper.waitTime(3);
		WebElement alarmFrequ = User.getElement(driver, AlarmConfig.alarmFrequ);
		User.selectOption(alarmFrequ, alarmConfig.alarmFrequ);
		oper.waitTime(3);
		WebElement endHour = User.getElement(driver, AlarmConfig.endHour);
		User.selectOption(endHour, alarmConfig.endHour);
		oper.waitTime(2);
		WebElement confirButton = User.getElement(driver, AlarmConfig.confirButton);
		confirButton.click();
		oper.waitTime(3);
		WebElement button = User.getElement(driver, AlarmConfig.alertButton);
		button.click();
		boolean isFind = false;
		WebElement table = driver.findElementByXPath(AlarmConfig.Table);
		Table newTable = new Table(table);
		int rowNo = newTable.getRowCount();

		for (int i = 1; i <= rowNo; i++) {
			WebElement element = newTable.getCell(i, 1);
			if (element.getText().equals(alarmConfig.configName)) {
				isFind = true;
				break;
			}
		}
		assertTrue(isFind);
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
}
