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
// * 创建任务时检查数据链路配置测试用例
// */
//public class MY11B {
//  public static WebDriver driver;
//
//  @BeforeMethod
//  public void beforeMethod() {
//  System.setProperty("webdriver.chrome.driver", "F:\\chromedriver.exe");  
//  driver= new ChromeDriver();
//  driver.manage().window().maximize(); 
//  function.login((ChromeDriver)driver);
//  }
// 
// @Test
//  public void testDataLink()throws StaleElementReferenceException {
//	 boolean isSuccess =  false;
//	 boolean isBasicInfo = function.checkBasicInfo((ChromeDriver) driver);
//	 oper.waitTime(5);
//	 if(isBasicInfo) {
//		 boolean isTapSource = oper.tapAddDataButton((ChromeDriver) driver,"数据源");
//		 oper.waitTime(5);
//		 if(isTapSource) {
//		   //添加数据源
//		   boolean addSourceData = function.addData((ChromeDriver) driver,"disit_test","test_data1","selectDataSourceMysql",true);
//		   oper.waitTime(5);
//		   if(addSourceData) {
//		   //添加数据源成功，则进行添加数据目标
//		   boolean isTapObject = oper.tapAddDataButton((ChromeDriver) driver,"数据目标");
//		   oper.waitTime(5);
//		   if(isTapObject) {
//			   //添加数据目标
//			   boolean addObjectData = function.addData((ChromeDriver) driver,"test","disit_test","selectDataTargetHive",false);
//			   if(addObjectData) {
//				   WebElement div = driver.findElement(By.id("selectDataTargetHive"));
//				   oper.tapButton(div, "确定" );
//				   
//			   }
//			   oper.waitTime(3);
//			   
//			   //配置同步字段
//			   List<WebElement>buttons = driver.findElements(By.tagName("button"));
//			   oper.tapSimpleButton(buttons, "配置同步字段");
//			   oper.waitTime(3);
//			   //点击自动关联
//			   WebElement confDiv =  driver.findElement(By.id("configureField"));
//			   oper.LogOut("tap before");
//			   boolean isTap = oper.tapButton(confDiv, "自动关联" );
//			   if(isTap) {
//				   oper.LogOut("XXXXXXXXXXXXXXXX");
//			   }
//			   
////			   List<WebElement>buttons2 = driver.findElements(By.tagName("button"));
////			   oper.LogOut("tap the button ");
////			   oper.tapSimpleButton(buttons2, "自动关联");
//			   oper.LogOut("tap after");
//			   oper.waitTime(3);
//			   ((JavascriptExecutor)driver).executeScript("window.scrollTo(0,document.body.scrollHeight)");
//			   
//			   //点击确定
//			   oper.tapButton(confDiv,"确定");
//			   
//			   
//			   oper.waitTime(5);
//			   if(addObjectData) {
//				   //添加数据目标成功，点击下一步
//				List<WebElement>buttons1 = driver.findElements(By.className("btn-primary"));
//				((JavascriptExecutor)driver).executeScript("window.scrollTo(0,document.body.scrollHeight)");
//				oper.waitTime(5);
//				oper.tapSimpleButton(buttons1, "下一步");
//				oper.LogOut("tap it");
//				oper.waitTime(5);
//				List<WebElement>divs = driver.findElements(By.className("panel-heading"));
//				for(int i = 0; i < divs.size();i++) {
//					WebElement div = divs.get(i);
//					if(div.getText().equals("数据预处理")) {
//						isSuccess = true;
//						break;
//					}
//				}   
//			  } 
//		   }else {
//			   oper.LogOut("点击添加数据目标按钮失败");
//		   }    
//		   }else {
//			   oper.LogOut("添加数据源添加按钮失败");
//		   }	 
//		 }else {
//			 oper.LogOut("点击数据源添加按钮失败");
//		 } 
//	 }else {
//		 oper.LogOut("基本信息配置失败");	
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
