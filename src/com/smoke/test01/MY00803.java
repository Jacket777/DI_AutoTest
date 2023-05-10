package com.smoke.test01;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.auto.tools.Table;
import com.auto.tools.oper;
import com.data.function.function;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import static org.testng.Assert.assertTrue;

/*
 * 用例说明：任务管理界面检查-3
 */

public class MY00803 {
  public static ChromeDriver driver;

  //任务页面元素检查
  String orderHead = "序名";//th
  String taskHead="任务名称";//th
  String sourHead="源类型";//th
  String objHead="目标类型";//th
  String speedHead = "当前速度";//th
  String numberHead="当前处理数/错误数";//th
  String stateHead="任务状态";//th
  String operHead="操作";//th
  

  boolean tableHead=false;
  boolean isOrederHead = false;
  boolean isTaskHead = false;
  boolean isSourHead = false;
  boolean isObjHead = false;
  boolean isSpeedHead = false;
  boolean isNumberHead = false;
  boolean isStateHead = false;
  boolean isOperHead = false;
  
 @BeforeMethod
 public void beforeMethod() {
   driver= oper.getChromeDriver();
   function.login(driver);
   oper.waitTime(8);
 }
 
 @Test
  public void testTaskPage() {
   //1.check the table head
   WebElement table = driver.findElement(By.tagName("table"));
   Table newTable = new Table(table);
   isOrederHead = newTable.checkTableName(orderHead);
   isTaskHead = newTable.checkTableName(taskHead);
   isSourHead = newTable.checkTableName(sourHead);
   isObjHead = newTable.checkTableName(objHead);  
   isSpeedHead = newTable.checkTableName(speedHead);
   isNumberHead = newTable.checkTableName(numberHead);
   isStateHead = newTable.checkTableName(stateHead);
   isOperHead = newTable.checkTableName(operHead);
   
  
   tableHead=(isOrederHead&&isTaskHead&&isSourHead)&&(isObjHead&&isSpeedHead&&isNumberHead)&&(isStateHead&&isOperHead);

   //check the result
   boolean result = tableHead;
   assertTrue(result);
  }
 
  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }
}
