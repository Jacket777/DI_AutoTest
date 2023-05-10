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
 * 用例说明：任务管理页面元素检查-2
 */

public class MY00802 {
  public static ChromeDriver driver;
  
 @BeforeMethod
 public void beforeMethod() {
   driver= oper.getChromeDriver();
   function.login(driver);
   oper.waitTime(8);
 }
 
 @Test
  public void testCreateTaskSpan() {
	//任务页面元素检查
	String create="新建任务";//span
	boolean isCreate=false;
	
   //1.check the create task span
   List<WebElement>divs2 = driver.findElements(By.className("pull-right"));
   for(WebElement div:divs2) {
	   List<WebElement> spans = div.findElements(By.tagName("span")); 
	     for(WebElement span:spans) {
	    	 String text = span.getText();
	    	 System.out.println("span "+text);
	    	 if(text.equals(create)) {
	    		 isCreate=true;
	    		 break;
	    	 } 	
	     } 
	     if(isCreate) {break;}
   }
  
   //2.check the result
   assertTrue(isCreate);	 
  }
 
  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }
}
