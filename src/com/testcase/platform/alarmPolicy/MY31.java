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


public class MY31 {
 public static ChromeDriver driver;
 
 @BeforeMethod
 public void beforeMethod() {
  User.configExplore();
  driver= new ChromeDriver();
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
	 int resultRow = configTable.getRowNo("Test", 1,rowNo, configTable);
	 System.out.println("-----"+resultRow);
	 if(resultRow!=-1) {
		configTable.tapText("��������", resultRow, 6, configTable,driver);
		oper.waitTime(5);
	    WebElement addButton = driver.findElementByXPath(relativeTask.addTask);
	    addButton.click();
	    oper.waitTime(5);
	    WebElement task = driver.findElementByXPath(relativeTask.taskTable);
	    Table taskTable = new Table(task);
	    int rowCount = taskTable.getRowCount();
	    int resultRow1 = taskTable.getRowNo("cc", 2, rowCount, taskTable);
	    taskTable.clickCheckBox(driver, relativeTask.taskTable, resultRow1, 1);
        WebElement button = driver.findElementByXPath(relativeTask.cancelBut);
	    button.click();
	    WebElement alarmTask = driver.findElementByXPath(relativeTask.addTaskTable);
	    Table addTasktab = new Table(alarmTask);
	    int rowNo1 = addTasktab.getRowCount();
	    int res = addTasktab.getRowNo("cc", 2, rowNo1, addTasktab);
	    if(res==-1) {
	    	result = true;
	    }
	    oper.waitTime(10);    	 
	 }
	 assertTrue(result);
}
	 
   
  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }
}
