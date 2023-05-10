//package com.smoke.test;
//
//import java.util.List;
//import org.openqa.selenium.*;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.Test;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.AfterMethod;
//import static org.testng.Assert.assertTrue;
//import com.auto.tools.oper;
//import com.data.function.function;
//
///*
// * 创建任务中同步与确认检查创建成功
// */
//public class MY11C {
//  public static WebDriver driver;
//
//  @BeforeMethod
//  public void beforeMethod() {
//  System.setProperty("webdriver.chrome.driver", "F:\\chromedriver.exe");  
//  driver= new ChromeDriver();
//  function.login((ChromeDriver)driver);
//  }
// 
// @Test
//  public void testTask()throws StaleElementReferenceException {
//	 boolean isSuccess =  false;
//	 boolean isDataLink = function.checkDataLink((ChromeDriver) driver);
//	 oper.waitTime(5);
//	 if(isDataLink) {
//		 //在同步页面中点击确定按钮
//		List<WebElement>buttons = driver.findElements(By.className("btn-primary"));
//		((JavascriptExecutor)driver).executeScript("window.scrollTo(0,document.body.scrollHeight)");
//		oper.waitTime(5);
//		oper.tapSimpleButton(buttons, "确定");
//		oper.waitTime(5);
//		
//		//1.check the table head
//		WebElement table = driver.findElement(By.tagName("table"));
//		WebElement tbody = table.findElement(By.tagName("tbody"));
//		List<WebElement> trs = tbody.findElements(By.tagName("tr"));
//		for(int i = 0;i<trs.size();i++) {
//			WebElement tr = trs.get(i);
//			List<WebElement>tds = tr.findElements(By.tagName("td"));
//		    String text = tds.get(1).getText();
//		    System.out.println(text);
//		    if(text.equals("AAA")) {
//		    	isSuccess = true;
//		    	break;
//		    }
//		}
//		if(!isSuccess) {
//			 oper.LogOut("任务名称没找到！");	
//		}
//	 }else {
//		 oper.LogOut("数据链路配置失败");	
//	 }
//	 
//	 
//	 
//	 
//	 
//	 
//	 
//	 
//	 
//	 assertTrue(isSuccess);
////   //2.wait
////    oper.waitTime(5);
////    oper.configBasicInfo((ChromeDriver) driver,"AAA","Mysql(binlog) → Hive","aaaa","下一步");
////    oper.waitTime(5); 
////   //3-2. data link configure
////   //tap the add the data source button
////   boolean isTapSource = oper.tapAddDataButton((ChromeDriver) driver,"数据源");
////   oper.waitTime(5);
////   //------------------------------------------------------------------------
////   boolean addSourceData = oper.addData((ChromeDriver) driver,"T-MySql","test_data1","selectDataSourceMysql",true);
////   oper.waitTime(5);
////   boolean isTapObject = oper.tapAddDataButton((ChromeDriver) driver,"数据目标");
////   oper.waitTime(5);
////   boolean addObjectData = oper.addData((ChromeDriver) driver,"bigdata","spark_test","selectDataTargetHive",false);
////   oper.waitTime(5);
////   
////   List<WebElement> buttons = driver.findElements(By.tagName("button"));
////   oper.tapSimpleButton(buttons, "配置同步字段");
////   oper.waitTime(5);
////   List<WebElement> selects = driver.findElements(By.tagName("select"));
////   
////   WebElement table = driver.findElement(By.tagName("table"));
////   WebElement tbody = table.findElement(By.tagName("tbody"));
////   List<WebElement> trs = tbody.findElements(By.tagName("tr"));
////   for(WebElement tr:trs) {
////	   WebElement td = tr.findElement(By.xpath("td[1]"));
////	   System.out.println("object field "+td.getText());
//////	   if(td.getText().equals("a")) {
//////		   boolean result = false;
//////		   WebElement td2 = tr.findElement(By.xpath("td[3]"));
//////		   WebElement select = td2.findElement(By.tagName("select"));
//////		   if(select!=null) {
//////			   Select select01 = new Select(select);
//////			   select01.selectByVisibleText(td.getText());
//////		   }
//////		   
//////		   break;
//////	   }
//   }
//   
//  
//
//
// 
// 
//
//  @AfterMethod
//  public void afterMethod() {
//	  driver.quit();
//  }
//}
