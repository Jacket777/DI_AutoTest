package com.smoke.test;

import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import static org.testng.Assert.assertTrue;

public class MY10 {
  public static WebDriver driver;
  String portUrl="https://ssosit.cnsuning.com/ids/login?service=http%3A%2F%2Fdatacloudsit.cnsuning.com%2Fbigdata-portal-web%2Fauth%3FtargetUrl%3Dhttp%253A%252F%252Fdatacloudsit.cnsuning.com%252Fbigdata-portal-web%252Fconsole.html&loginTheme=datacloudsit#/portal";
  String dataIntegrateUrl="http://disit.cnsuning.com/di-web/?authoritySystemId=12558#/taskManagementMain";
 
  String search="搜索";//button
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
	 Thread.sleep(8000);} 
	catch (InterruptedException e) {
		e.printStackTrace();
	}
 }
 
 @Test
  public void testTaskPage() {
	 //1.define source selector
	 List<WebElement> selects = driver.findElements(By.tagName("select"));
	 Select select01 = new Select((selects.get(0)));
	 Select select02 = new Select((selects.get(1)));
	 
	 boolean isAll = false;
	 boolean ishive = false;
	 boolean ishdfs = false;
	 
	 List<WebElement> options=select02.getOptions();
	   for(WebElement option:options) {
		   String text = option.getText();
		   System.out.println("option "+text);
		   if(text.equals("all")) {
			   isAll = true;
		   }else if(text.equals("hive")){
			   ishive = true;   
		   }else if(text.equals("hdfs")) {
			   ishdfs = true;
		   }
	   }
	   //find selector and select mysql
	   if(isAll&&ishive&&ishdfs) {
		   select02.selectByVisibleText("hive");
	   }else {
		   select01.selectByVisibleText("mysql");
	   }
	   
	   //wait
	   try {
			 Thread.sleep(8000);} 
			catch (InterruptedException e) {
				e.printStackTrace();
			}
	   
	   //2.检查搜索按钮并点击
	   List<WebElement> divs=  driver.findElements(By.className("form-group"));
	   for(WebElement div:divs){
	   List<WebElement> buts = div.findElements(By.tagName("button")); 
		   for(WebElement but:buts) {
			   String text = but.getText();
			   System.out.println("button "+text);
			   if(text.equals(search)) {
				   isSearch=true;
				   but.click();
				   break;
			   }
		   } 
		   if(isSearch) {break;} 
	   }
	   
	   //3.检查搜索文本
	   //wait
	   try {
			 Thread.sleep(8000);} 
			catch (InterruptedException e) {
				e.printStackTrace();
			}
	   
	   //
	   //1.check the table data and result
	   boolean result = true;
	   WebElement table = driver.findElement(By.tagName("table"));
	   WebElement tbody = table.findElement(By.tagName("tbody"));
	   List<WebElement> trs = tbody.findElements(By.tagName("tr"));
	   for(WebElement tr:trs) {
		   WebElement td = tr.findElement(By.xpath("td[4]"));
		   System.out.println("目标类型： "+td.getText());
		   if(td.getText().equals("hdfs")) {
			   result = false;
			   break;
		   }
	   }
	   
	   System.out.println("the result is"+result);
	   assertTrue(result);
	   
	   
	   
	   
	   
	  
	   
	   
		  
		
	
	 
	 
	 
	 
	 
	 
//	 //2.找到源类型下拉框
//   List<WebElement> divs  =  driver.findElements(By.className("form-group"));
//   for(WebElement div:divs ) {
//	   Select select= new Select(div.findElement(By.tagName("select")));
//	   List<WebElement> options=select.getOptions();
//	   for(WebElement option:options) {
//		   String text = option.getText();
//		   System.out.println("option "+text);
//		   if(text.equals("all")) {
//			   isAll = true;
//		   }else if(text.equals("mysql")){
//			   isMysql = true;   
//		   }else if(text.equals("kafka")) {
//			   iskafka = true;
//		   }
//		   if(isAll&&isMysql&&iskafka) {
//			   sourSelector = select;
//			   sourSelector.selectByVisibleText("mysql");
//			   try
//			   
//			   break;}
//	   } 
//	   if(isAll&&isMysql&&iskafka) {break;}
//   }
//   
  }
 
  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }
}
