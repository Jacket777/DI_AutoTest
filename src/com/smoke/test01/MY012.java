package com.smoke.test01;

import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import static org.testng.Assert.assertTrue;

import com.auto.tools.Table;
import com.auto.tools.oper;
import com.data.function.TaskOPCollection;
import com.data.function.function;

/*
 * 用例说明 ：启动任务功能检查
 */
public class MY012 {
  public static ChromeDriver driver;

  @BeforeMethod
  public void beforeMethod() {
		driver= oper.getChromeDriver();
	    function.login(driver);
	    oper.waitTime(8);
  }
 
 @Test
  public void testStarTask()throws StaleElementReferenceException {
	 boolean isSuccess =  false;
	 WebElement table = driver.findElement(By.tagName("table"));
	 Table table1 = new Table(table);
	 boolean isfindTable = table1.checkTableName("目标类型");
	 oper.waitTime(5);
	 if(isfindTable) {
		 WebElement tableCell =table1.searchTableCell("Test1");
		 boolean star = TaskOPCollection.operTask(tableCell, "启动");
	     if(star) {
		    TaskOPCollection.initTask(driver);
		    oper.waitTime(5);
		    try {
		      oper.AlertOP(driver, 0);
		    }catch(UnhandledAlertException e) {
		    	e.printStackTrace();
		    }
		    
		    
		    driver.navigate().refresh();
	       }
      oper.waitTime(5);
      isSuccess = TaskOPCollection.checkOperations(tableCell,"启动");
		 }
	 assertTrue(isSuccess);
	 }
		
  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }
}
