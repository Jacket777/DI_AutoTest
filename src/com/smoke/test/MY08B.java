package com.smoke.test;

import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import static org.testng.Assert.assertTrue;

public class MY08B {
  public static WebDriver driver;
  String portUrl="https://ssosit.cnsuning.com/ids/login?service=http%3A%2F%2Fdatacloudsit.cnsuning.com%2Fbigdata-portal-web%2Fauth%3FtargetUrl%3Dhttp%253A%252F%252Fdatacloudsit.cnsuning.com%252Fbigdata-portal-web%252Fconsole.html&loginTheme=datacloudsit#/portal";
  String dataIntegrateUrl="http://disit.cnsuning.com/di-web/?authoritySystemId=12558#/taskManagementMain";
 
  //任务页面元素检查
  String create="新建任务";//span
  boolean isCreate=false;

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
  public void testCreateTaskSpan() {
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
  
   //check the result
   assertTrue(isCreate);	 
  }
 
  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }
}
