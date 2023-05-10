//package com.smoke.test;
//
//import java.util.List;
//import org.openqa.selenium.*;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.Select;
//import org.testng.annotations.Test;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.AfterMethod;
//import static org.testng.Assert.assertTrue;
//import com.auto.tools.oper;
//
//public class MY11 {
//  public static WebDriver driver;
//  String portUrl="https://ssosit.cnsuning.com/ids/login?service=http%3A%2F%2Fdatacloudsit.cnsuning.com%2Fbigdata-portal-web%2Fauth%3FtargetUrl%3Dhttp%253A%252F%252Fdatacloudsit.cnsuning.com%252Fbigdata-portal-web%252Fconsole.html&loginTheme=datacloudsit#/portal";
//  String dataIntegrateUrl="http://disit.cnsuning.com/di-web/?authoritySystemId=12558#/taskManagementMain";
// 
//  //任务页面元素检查
//  String create="新建任务";//span
//  boolean isCreate=false;
//
// @BeforeMethod
// public void beforeMethod() {
//  System.setProperty("webdriver.chrome.driver", "F:\\chromedriver.exe");  
//  driver= new ChromeDriver();
//  driver.get(portUrl);//login the port web
//  WebElement userNameInput = driver.findElement(By.id("username"));
//  WebElement passwordInput=driver.findElement(By.id("password"));
//  WebElement loginButton = driver.findElement(By.className("login_button"));
//  oper.inputText(userNameInput, "14082455");
//  oper.inputText(passwordInput, "14082455");
//  loginButton.click();
//  driver.get(dataIntegrateUrl);//login the data integration web
//  oper.waitTime(5);
// }
// 
// @Test
//  public void testCreateTaskSpan()throws StaleElementReferenceException {
//   //1.check the create task span and tap it
//   List<WebElement>divs1 = driver.findElements(By.className("pull-right"));
//   for(WebElement div:divs1) {
//	   List<WebElement> spans = div.findElements(By.tagName("span")); 
//	     for(WebElement span:spans) {
//	    	 String text = span.getText();
//	    	 //System.out.println("span "+text);
//	    	 if(text.equals(create)) {
//	    		 isCreate=true;
//	    		 span.click();
//	    		 break;
//	    	 } 	
//	     } 
//	     if(isCreate) {break;}
//   }
//   
//   //2.wait
//   oper.waitTime(5);
//   //oper.configBasicInfo((ChromeDriver) driver,"AAA","Mysql(binlog) → Hive","aaaa","下一步");
//   oper.waitTime(5); 
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
//   }
//   
//   oper.waitTime(5);
//  }
// 
//
//
// 
// 
// 
// 
// public static void operTable(ChromeDriver driver,String tabName) {
//	 boolean isSuc = false;
//	 boolean isFind = false;
//	 List<WebElement> tabs = driver.findElementsByTagName("table");
//	 if(tabs!=null) {
//		 for(int i = 0; i <tabs.size();i++) {
//			 WebElement tab = tabs.get(i);
//			 if(tab!=null) {
//				WebElement th =  tab.findElement(By.tagName("thead"));
//				WebElement tr = th.findElement(By.tagName("tr"));
//				List<WebElement> tds = tr.findElements(By.tagName("td"));
//				for(int j = 0; j <tds.size();j++) {
//					WebElement td = tds.get(j);
//					if(td!=null) {
//						if(td.getText().equals(tabName)) {
//							isFind = true;
//							oper.LogOut("it found table");
//							break;
//						}
//					}else {
//						oper.LogOut("td is not found or null");
//						//return false;
//					}	
//				}
//				if(isFind) {
//					WebElement tbody = tab.findElement(By.tagName("tbody"));
//					List<WebElement> bodyTr = tbody.findElements(By.tagName("tr"));
//					for(int k= 0;k <bodyTr.size(); k++) {
//						WebElement tr1 = bodyTr.get(k);
//						WebElement td01 = tr1.findElement(By.xpath("td[1]"));
//						String text = td01.getText();
//						WebElement td03 = tr1.findElement(By.xpath("td[3]"));
//						Select select = (Select) td03.findElement(By.tagName("select"));
//						List<WebElement>options = select.getOptions();
//						boolean isFindoption = false;
//						for(int opt = 0;opt<options.size();opt++) {
//							WebElement option = options.get(opt);
//							if(option.getText().equals(text)) {
//								isFindoption = true;
//								select.selectByVisibleText(text);
//								//return isFindoption;
//							}
//						}
//						//return isFindoption;
//					}	
//				} 
//			 }else {
//				 oper.LogOut("table can not found! or table is null");
//				 //return false;
//			 }
//		 } 
//	 }else {
//		 oper.LogOut("table not find");
//		// return false;
//	 } 
// }
// 
// 
//  @AfterMethod
//  public void afterMethod() {
//	  driver.quit();
//  }
//}
