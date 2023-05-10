package com.smoke.test;

import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import static org.testng.Assert.assertTrue;

public class MY008 {
  public static WebDriver driver;
  String portUrl="https://ssosit.cnsuning.com/ids/login?service=http%3A%2F%2Fdatacloudsit.cnsuning.com%2Fbigdata-portal-web%2Fauth%3FtargetUrl%3Dhttp%253A%252F%252Fdatacloudsit.cnsuning.com%252Fbigdata-portal-web%252Fconsole.html&loginTheme=datacloudsit#/portal";
  String dataIntegrateUrl="http://disit.cnsuning.com/di-web/?authoritySystemId=12558#/taskManagementMain";
 
  //任务页面元素检查
  String sourType = "源类型:";//label
  String objType = "目标类型:";//label
  String search="搜索";//button
  String create="新建任务";//span
  String orderHead = "序名";//th
  String taskHead="任务名称";//th
  String sourHead="源类型";//th
  String objHead="目标类型";//th
  String speedHead = "当前速度";//th
  String numberHead="当前处理数/错误数";//th
  String stateHead="任务状态";//th
  String operHead="操作";//th
  
  boolean pageHead=false;
  boolean isSourType = false;
  boolean isObjType=false;
  boolean isSearch=false;
  boolean isCreate=false;
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
  System.setProperty("webdriver.chrome.driver", "F:\\chromedriver.exe");  
  driver= new ChromeDriver();
  driver.get(portUrl);//login the port web
  WebElement userNameInput = driver.findElement(By.id("username"));
  WebElement passwordInput=driver.findElement(By.id("password"));
  WebElement loginButton = driver.findElement(By.className("login_button"));
  userNameInput.sendKeys("14082455");
  passwordInput.sendKeys("14082455");
  loginButton.click();
  driver.get(dataIntegrateUrl);//login the data integration web
	try {
	 Thread.sleep(30000);} 
	catch (InterruptedException e) {
		e.printStackTrace();
	}
 }
 
 @Test
  public void testTaskPage() {
	//1.check sourType, objType, search
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
			   break;  
		   }
	   }  
	   List<WebElement> buts = div.findElements(By.tagName("button")); 
	   for(WebElement but:buts) {
		   String text = but.getText();
		   System.out.println("button "+text);
		   if(text.equals(search)) {
			   isSearch=true;
			   break;
		   }
	   }
	   if(isSourType&&isObjType&&isSearch) {
		   pageHead=true;
		   break;
	   }
   }
   
   //2.check the create task span
   List<WebElement>divs2 = driver.findElements(By.className("pull-right"));
   for(WebElement div:divs2) {
	   List<WebElement> spans = div.findElements(By.tagName("span")); 
	     for(WebElement span:spans) {
	    	 String text = span.getText();
	    	 System.out.println("span "+text);
	    	 if(text.equals(create)) {
	    		 isCreate=true;
	    	 } 	
	    	 if(isCreate) {break;}
	     } 
	     if(isCreate) {break;}
   }
   
   
   //3.check the table head
   WebElement table = driver.findElement(By.tagName("table"));
   WebElement thead = table.findElement(By.tagName("thead"));
   WebElement tr = thead.findElement(By.tagName("tr"));
   List<WebElement> ths =tr.findElements(By.tagName("th"));
   for(WebElement th:ths) {
	   String text = th.getText();
	   System.out.println("th "+text);
	   if(text.equals(orderHead)) {
		   isOrederHead = true; 
	   }else if(text.equals(sourHead)) {
		   isSourHead = true;
	   }else if(text.equals(objHead)) {
		   isObjHead = true;
	   }else if(text.equals(speedHead)) {
		   isSpeedHead = true;
	   }else if(text.equals(numberHead)) {
		   isNumberHead = true;
	   }else if(text.equals(stateHead)) {
		   isStateHead = true;
	   }else if(text.equals(operHead)) {
		   isOperHead = true;
	   }
	   tableHead=isOrederHead&&isTaskHead&&isObjHead&&isSpeedHead&&isNumberHead&&isStateHead&&isOperHead;
	   if(tableHead) {
		   break;
	   }
   }
  
   //check the result
   boolean result = tableHead&&isCreate&&pageHead;
   assertTrue(result);	 
  }
 
  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }
}
