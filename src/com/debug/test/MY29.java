package com.debug.test;


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
import com.element.location.relativeTask;
import com.special.action.EnterPage;


// 告警策略--新增关联任务
public class MY29 {
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
	 //1.先找到告警配置
	 WebElement table = driver.findElementByXPath(AlarmConfig.Table);
	 Table newTable = new Table(table);
	 int rowNo = newTable.getRowCount();
	 int resultRow = newTable.getRowNo("Test",1, rowNo, newTable);
	 System.out.println("-----"+resultRow);
	 if(resultRow!=-1) {
		 //1.获取单元格的数据
		 WebElement td = newTable.getCell(rowNo, 6);
		 WebElement tname = newTable.getCell(rowNo, 1);
		 System.out.println("xxxxx"+tname.getText());
		 Exploer.scollToBottomofPag(driver);
		 WebElement task = td.findElement(By.xpath("//a[text()='关联任务']"));
		 task.click();	
		 System.out.println("------------tap --check box-------------");
		 //2.点击新增关联任务按钮
		 oper.waitTime(10);
		 WebElement addButton = driver.findElementByXPath(relativeTask.addTask);
		 if(addButton!=null) {
		     addButton.click();
		     oper.waitTime(3);
		     //3.
		     WebElement taskTable = driver.findElementByXPath(relativeTask.taskTable);
		     Table table1 = new Table(taskTable);
		     //4.
		     WebElement tableCell = table1.getCell(2, 1);
		     System.out.println("------------tap --check box-------------");
		    	 WebElement checkBox = tableCell.findElement(By.xpath("//input[@type='checkbox']"));
		     checkBox.click();
		     oper.waitTime(3);
		     System.out.println("------------tap ---------------");
		     WebElement confirmBut = driver.findElementByXPath(relativeTask.confirmButton);
			 confirmBut.click();
			 WebElement addTaskTable = driver.findElementByXPath(relativeTask.addTaskTable);
			 Table table2 = new Table(addTaskTable);
			 int rowNol = table2.getRowCount();
			 if(rowNol>0) {
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
