package com.smoke.test;

import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import static org.testng.Assert.assertTrue;

public class MY08A {
  public static WebDriver driver;
  String portUrl="https://ssosit.cnsuning.com/ids/login?service=http%3A%2F%2Fdatacloudsit.cnsuning.com%2Fbigdata-portal-web%2Fauth%3FtargetUrl%3Dhttp%253A%252F%252Fdatacloudsit.cnsuning.com%252Fbigdata-portal-web%252Fconsole.html&loginTheme=datacloudsit#/portal";
  String dataIntegrateUrl="http://disit.cnsuning.com/di-web/?authoritySystemId=12558#/taskManagementMain";
 
  //任务页面元素检查
  String sourType = "源类型：";//label
  String objType = "目标类型：";//label
  String search="搜索";//button

  boolean pageHead=false;
  boolean isSourType = false;
  boolean isObjType=false;
  boolean isSearch=false;

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
