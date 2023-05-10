package com.smoke.test01;

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
 * 用例说明：创建任务时检查基本信息配置测试用例
 */
public class MY01101 {
  public static ChromeDriver driver;

  @BeforeMethod
  public void beforeMethod() {
	driver= oper.getChromeDriver();
    function.login(driver);
    oper.waitTime(8);
  }
 
 @Test
  public void testBasicConfigure()throws StaleElementReferenceException {
	 boolean isSuccess =  false;
	 String taskName = "AAA";
	 String taskType = "Mysql(binlog) → Hive";
	 String taskContent = "aaaa";
	 boolean isTapCreatTask =  function.checkCreatTask(driver);
	 oper.waitTime(3);
	 if(isTapCreatTask) {
		 function.configBasicInfo(driver,taskName,taskType,taskContent,"下一步");
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
