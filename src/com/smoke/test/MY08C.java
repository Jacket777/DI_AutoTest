package com.smoke.test;

import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import static org.testng.Assert.assertTrue;

public class MY08C {
  public static WebDriver driver;
  String portUrl="https://ssosit.cnsuning.com/ids/login?service=http%3A%2F%2Fdatacloudsit.cnsuning.com%2Fbigdata-portal-web%2Fauth%3FtargetUrl%3Dhttp%253A%252F%252Fdatacloudsit.cnsuning.com%252Fbigdata-portal-web%252Fconsole.html&loginTheme=datacloudsit#/portal";
  String dataIntegrateUrl="http://disit.cnsuning.com/di-web/?authoritySystemId=12558#/taskManagementMain";
 
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
   //1.check the table head
   WebElement table = driver.findElement(By.tagName("table"));
   WebElement thead = table.findElement(By.tagName("thead"));
   WebElement tr = thead.findElement(By.tagName("tr"));
   List<WebElement> ths =tr.findElements(By.tagName("th"));
   for(WebElement th:ths) {
	   String text = th.getText();
	   //System.out.println("th "+text);
	   if(text.equals(orderHead)) {
		   isOrederHead = true; 
	   }else if(text.equals(taskHead)){
		   isTaskHead = true;
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
   }
   tableHead=isOrederHead&&isTaskHead&&isSourHead&&isObjHead&&isSpeedHead&&isNumberHead&&isStateHead&&isOperHead;

  
   
   //debug issue
   if(!isOrederHead) { System.out.println("序名 not found");}
   if(!isTaskHead) { System.out.println("任务名称  not found");}
   if(!isSourHead) { System.out.println("源类型  not found"); }
   if(!isObjHead) { System.out.println("目标类型  not found");}
   if(!isNumberHead) { System.out.println("当前处理数/错误数  not found");}
   if(!isStateHead) { System.out.println("任务状态 not found");}
   if(!isOperHead) { System.out.println("操作 not found");}
	   
   
   //check the result
   boolean result = tableHead;
   assertTrue(result);
  }
 
  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }
}
