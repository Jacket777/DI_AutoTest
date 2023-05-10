package com.smoke.test01;

import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.auto.tools.oper;
import com.data.function.function;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import static org.testng.Assert.assertTrue;


/*
 * 用例说明：用户登录后，检查左侧导航栏元素
 */

public class MY001 {
  public static ChromeDriver driver;
  
 @BeforeMethod
 public void beforeMethod() { 
  driver= oper.getChromeDriver();
  function.login(driver);
  oper.waitTime(8);
 }
 
 @Test
  public void testOverview() {
	 //检查左侧导航栏
	  String overview = "概览";
	  String taskman = "任务管理";
	  String alarman="告警管理";
	  String sysman="系统管理";
	  boolean isOverview = false;
	  boolean isTaskman=false;
	  boolean isAlarm=false;
	  boolean isSys=false;
  
   //check
   List<WebElement> elements  =  driver.findElements(By.className("ng-binding"));
   for(WebElement element:elements ) {
	 String text = element.getText();
	   if(text.equals(overview)) {
	 	  isOverview = true;
	 		}else if(text.equals(taskman)) {
	 			isTaskman=true;
	 		}else if(text.equals(alarman)) {
	 			isAlarm = true;   
	 		}else if(text.equals(sysman)) {
	 			isSys = true;
	 		}
	 	}
	 boolean result = isOverview&&isTaskman&&isAlarm&&isSys;
	 assertTrue(result);
  }
 
  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }
}
