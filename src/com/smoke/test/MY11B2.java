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
//public class MY11B2 {
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
//		 boolean isAddSource = false;
//		 boolean isAddObject = false;
//		 boolean isAuto = false;
//		 
//		 //1.基本信息配置成功，则点击添加数据源按钮
//		 boolean isTapSource = oper.tapAddDataButton((ChromeDriver) driver,"数据源");
//		 oper.waitTime(5);
//		 if(isTapSource) {
//			 isAddSource = function.addData((ChromeDriver) driver,"disit_test","test_data1","selectDataSourceMysql",true);
//		 }else {
//			 oper.LogOut("点击数据源添加按钮失败"); 
//		 }
//		 oper.waitTime(3);
//		 //2.基本信息配置成功，则点击添加数据目标按钮，添加数据目标
//		 boolean isTapObject = oper.tapAddDataButton((ChromeDriver) driver,"数据目标");
//		 oper.waitTime(5);
//		 if(isTapObject) {
//			 isAddObject = function.addData((ChromeDriver) driver,"test","disit_test","selectDataTargetHive",false);
//			 oper.waitTime(3);
//		 }else {
//			 oper.LogOut("点击数据目标添加按钮失败"); 
//		 }
//		 
//		 
//		 //3.配置同步字段
//		 if(isAddSource&&isAddObject) {
//			   //3.1.点击配置同步字段按钮
//			   List<WebElement>buttons = driver.findElements(By.tagName("button"));
//			   boolean isTap  =oper.tapSimpleButton(buttons, "配置同步字段");
//			   oper.waitTime(3);
//			   //3.2.点击自动关联
//			   if(isTap) {
//				   WebElement confDiv =  driver.findElement(By.id("configureField"));
//				   boolean isTapAuto = oper.tapButton(confDiv, "自动关联" );
//				   oper.waitTime(3);
//				   if(isTapAuto) {
//					   List<WebElement> buttons1 = driver.findElements(By.tagName("button"));
//					   boolean isConfirm =oper.tapSimpleButton(buttons1, "确定");
//					   if(isConfirm) {
//						   oper.waitTime(5);
//						   isAuto = true;
//						   oper.LogOut("tap it confirm button");
//					   }	    
//				   }   
//			   }
//		 }
//		 
//		 //4.点击下一步按钮，检查页面是否为同步页面
//		//判断同步字段是否点击成功，
//		 if(isAuto) {
//			 List<WebElement>buttons = driver.findElements(By.className("btn-primary"));
//           // ((JavascriptExecutor)driver).executeScript("window.scrollTo(0,document.body.scrollHeight)");
//             oper.waitTime(5);
//             boolean isTap = oper.tapSimpleButton(buttons, "下一步");
//             oper.waitTime(5);
//             if(isTap) {
//            		List<WebElement>divs = driver.findElements(By.className("panel-heading"));
//    				for(int i = 0; i < divs.size();i++) {
//    					WebElement div = divs.get(i);
//    					if(div.getText().equals("数据预处理")) {
//    						isSuccess = true;
//    						break;
//    					}
//    				} 
//             }
//		 }
//		 
//		 
//	assertTrue(isSuccess);
//
//
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
// }
//  @AfterMethod
//  public void afterMethod() {
//	  driver.quit();
//  }
//}
