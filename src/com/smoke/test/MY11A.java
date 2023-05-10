package com.smoke.test;

import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import static org.testng.Assert.assertTrue;
import com.auto.tools.oper;
import com.data.function.function;

/*
 * 创建任务时检查基本信息配置测试用例
 */
public class MY11A {
  public static WebDriver driver;

  @BeforeMethod
  public void beforeMethod() {
  System.setProperty("webdriver.chrome.driver", "F:\\chromedriver.exe");  
  driver= new ChromeDriver();
  function.login((ChromeDriver)driver);
  }
 
 @Test
  public void testBasicConfigure()throws StaleElementReferenceException {
	 boolean isSuccess =  false;
	 boolean isTapCreatTask =  function.checkCreatTask((ChromeDriver)driver);
	 oper.waitTime(3);
	 if(isTapCreatTask) {
		 function.configBasicInfo((ChromeDriver) driver,"AAA","Mysql(binlog) → Hive","aaaa","下一步");
		 oper.waitTime(5);
		 List<WebElement>divs =  driver.findElements(By.className("panel-heading"));
		 for(int  i = 0; i < divs.size();i++) {
			 WebElement div  = divs.get(i);
			 if(div.getText().equals("数据源&数据目标")) {
				 isSuccess = true;
				 break;
			 }
		 } 
	 }else {
		 oper.LogOut("点击创建任务失败，请检查");
	 }
	
	 oper.waitTime(3);
	 assertTrue(isSuccess);
   }
   

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }
}
