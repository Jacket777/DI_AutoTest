package com.smoke.test;

import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import static org.testng.Assert.assertTrue;
import com.auto.tools.oper;
import com.data.function.function;

/*
 * 启动任务功能检查
 */
public class MY12 {
  public static WebDriver driver;

  @BeforeMethod
  public void beforeMethod() {
  System.setProperty("webdriver.chrome.driver", "F:\\chromedriver.exe");  
  driver= new ChromeDriver();
  function.login((ChromeDriver)driver);
  }
 
 @Test
  public void testStarTask()throws StaleElementReferenceException {
	 boolean isSuccess =  false;
	 boolean isFindTask = function.checkTask((ChromeDriver) driver,"AAA");
	 oper.waitTime(5);
	 if(isFindTask) {
		 //在同步页面中点击确定按钮
		 WebElement tableCell =oper.searchTableCell((ChromeDriver) driver, "AAA");
		 if(tableCell!=null) {
			 List<WebElement> as = tableCell.findElements(By.tagName("a"));
			 for(int i = 0; i <as.size();i++) {
				 WebElement a = as.get(i);
				 if(a.getText().equals("启动")) {
					 a.click();
					 oper.waitTime(5);
				 }
			 }
			 
		 }else {
			 oper.LogOut("返回表格单元值为空");
		 }
	 }else {
		 oper.LogOut("没有找到该行"); 
	 }
		 

	 
	 
	 
	 
	 
	 
	 
	 
	 
	 assertTrue(isSuccess);
//   //2.wait
//    oper.waitTime(5);
//    oper.configBasicInfo((ChromeDriver) driver,"AAA","Mysql(binlog) → Hive","aaaa","下一步");
//    oper.waitTime(5); 
//   //3-2. data link configure
//   //tap the add the data source button
//   boolean isTapSource = oper.tapAddDataButton((ChromeDriver) driver,"数据源");
//   oper.waitTime(5);
//   //------------------------------------------------------------------------
//   boolean addSourceData = oper.addData((ChromeDriver) driver,"T-MySql","test_data1","selectDataSourceMysql",true);
//   oper.waitTime(5);
//   boolean isTapObject = oper.tapAddDataButton((ChromeDriver) driver,"数据目标");
//   oper.waitTime(5);
//   boolean addObjectData = oper.addData((ChromeDriver) driver,"bigdata","spark_test","selectDataTargetHive",false);
//   oper.waitTime(5);
//   
//   List<WebElement> buttons = driver.findElements(By.tagName("button"));
//   oper.tapSimpleButton(buttons, "配置同步字段");
//   oper.waitTime(5);
//   List<WebElement> selects = driver.findElements(By.tagName("select"));
//   
//   WebElement table = driver.findElement(By.tagName("table"));
//   WebElement tbody = table.findElement(By.tagName("tbody"));
//   List<WebElement> trs = tbody.findElements(By.tagName("tr"));
//   for(WebElement tr:trs) {
//	   WebElement td = tr.findElement(By.xpath("td[1]"));
//	   System.out.println("object field "+td.getText());
////	   if(td.getText().equals("a")) {
////		   boolean result = false;
////		   WebElement td2 = tr.findElement(By.xpath("td[3]"));
////		   WebElement select = td2.findElement(By.tagName("select"));
////		   if(select!=null) {
////			   Select select01 = new Select(select);
////			   select01.selectByVisibleText(td.getText());
////		   }
////		   
////		   break;
////	   }
   }
   
  


 
 

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }
}
