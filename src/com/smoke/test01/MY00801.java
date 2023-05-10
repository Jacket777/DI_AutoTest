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
 * 用例说明：任务管理页面元素检查-1
 */

public class MY00801 {
  public static ChromeDriver driver;
  
  //任务页面元素检查
  String sourType = "源类型：";//label
  String objType = "目标类型：";//label
  String search="搜索";//button
  String create="新建任务";//span

  boolean pageHead=false;
  boolean isSourType = false;
  boolean isObjType=false;
  boolean isSearch=false;

 @BeforeMethod
 public void beforeMethod() {
   driver= oper.getChromeDriver();
   function.login(driver);
   oper.waitTime(8);
 }
 
 @Test
  public void testTaskPage() {
	//1.检查源类型，目标类型
   List<WebElement> divs  =  driver.findElements(By.className("form-group"));
   for(WebElement div:divs ) {
	   List<WebElement> labels = div.findElements(By.tagName("label"));
	   for(WebElement label:labels) {
		   String text = label.getText();
		   System.out.println("label "+text);
		   if(text.equals(sourType)) {
			   isSourType = true;
		   }else if(text.equals(objType)){
			   isObjType = true;   
		   }
		   if(isSourType&&isObjType) {
			   pageHead=true;
			   break;}
	   }  
//	   System.out.println("isSoucType "+isSourType);
//	   System.out.println("isObjType "+isObjType);
//	   System.out.println("=====================");
	   if(pageHead) {
		   break;}  
   }
   
   //2.检查搜索按钮
   List<WebElement> div2=  driver.findElements(By.className("form-group"));
   for(WebElement div:div2){
   List<WebElement> buts = div.findElements(By.tagName("button")); 
	   for(WebElement but:buts) {
		   String text = but.getText();
		   System.out.println("button "+text);
		   if(text.equals(search)) {
			   isSearch=true;
			   break;
		   }
	   } 
	   if(isSearch) {break;} 
   }
   System.out.println("isSearch "+isSearch);
  
   //check the result
   boolean result = pageHead&&isSearch;
   assertTrue(result);	 
  }
 
  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }
}
