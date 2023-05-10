package com.debug.test;

import java.util.List;
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

public class MY28XXX {
 public static ChromeDriver driver;
 
 
 @BeforeMethod
 public void beforeMethod() {
  User.configExplore();
  driver= new ChromeDriver();
  driver.manage().window().maximize();
  User.login(driver);
  //点击告警管理
  WebElement  alarmManager = driver.findElementByXPath(homePage.alarmManage);
  alarmManager.click();
  oper.waitTime(2);
  //点击告警策越
  WebElement alarmPolicy = driver.findElementByXPath(AlarmPage.alarmConfig);
  alarmPolicy.click();
 }
 
 @Test
  public void testTaskPage() {
	
	 oper.waitTime(3);
	 //检查是否添加成功
	 boolean isFind = false;
	
	 WebElement table = driver.findElementByXPath(AlarmConfig.Table);
	 Table newTable = new Table(table);
	 int rowNo = newTable.getRowCount();
	 
	 
	 int colNo = newTable.getColumnCount();
	 System.out.println(colNo + "xxxxx");
	 System.out.println(rowNo +" yyyyy");
	 
//	 for(int i = 1; i < rowNo; i++) {
//		 WebElement element = newTable.getCell(i, 0);
//		 if(element.getText().equals(alarmConfig.configName)) {
//			 isFind = true;
//			 return;
//		 }
//	 }
	 
	 
	 
	 
   }
  

  
 
  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }
}
