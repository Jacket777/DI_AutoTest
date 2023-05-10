package com.testcase.platform.taskMan;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import com.special.action.EnterPage;
import com.special.tool.User;
import com.test.dataConfig.Task;
import com.universal.tool.Table;
import com.universal.tool.oper;
import com.element.location.TaskEdit;
import com.element.location.TaskHome;




//C--�༭����󣬱༭�����ҳ����ת���༭ҳ��

public class EditNewTask {
 public static ChromeDriver driver;
 
 @BeforeMethod
 public void beforeMethod() {
  User.configExplore();
  driver= new ChromeDriver();
  User.login(driver);
  
 }
 
 @Test
  public void testEditNewTask() throws StaleElementReferenceException{
	 boolean isFind = false;
	 System.out.println("===============1.�ҵ���Ҫ����������=======================");
	 Table tab = new Table(User.getElement(driver, TaskHome.tab));
	 int row = tab.getRowCount();
	 int result = tab.getRowNo("Test", 2, row, tab);
	 System.out.println("===============2.����༭��ť=======================");
	 tab.tapOPText(TaskHome.edit, result, 8, tab, driver);
	 System.out.println("===============3.������������Ƿ���ȷ=======================");
	 oper.waitTime(5);
	 WebElement input = driver.findElementByXPath(TaskEdit.name);
	 String getTaskName = input.getAttribute("value");
     System.out.println(getTaskName);
     if(getTaskName.equals(Task.name)) {
    	 isFind = true;
     }
	 
	 assertTrue(isFind);
	 
	 
//	 if(result!=-1) {
//		 System.out.println("===============�ҵ���Ҫ�����������ˣ�������=======================");
//		 //1.�ҵ���صĲ���
//		 WebElement lastTd = tab.getCell(result, 8);
//		 List<WebElement> as = lastTd.findElements(By.tagName("a"));
//		 for(int i = 0; i <as.size();i++) {
//			 WebElement element = as.get(i);
//			 String operation = element.getText();
//			 System.out.println(operation);
//			 if(operation.equals(TaskHome.edit)) {
//				 System.out.println("=========2.����༭����=============");
//				 element.click();
//				 oper.waitTime(5);
//
//				 //WebElement input = driver.findElementByXPath(TaskEdit.name);
//				 //System.out.println(input.getAttribute("value"));
//				 //oper.waitTime(10);
////				String programe="var inputs = document.getElementsByTagName('input');return inputs";
////				 try {
////		         JavascriptExecutor js = (JavascriptExecutor)driver;
////			     List<WebElement> elements =  (List<WebElement>) js.executeScript(programe);
////			     for(int j = 0 ; j < elements.size();j++) {
////			    	 System.out.println(elements.get(j).getAttribute("value"));
////			     }
////			     
////				 }catch(StaleElementReferenceException e) {
////					e.printStackTrace();
////				 }finally {
////					 
////				 }
//			 }
//		 } 
	 }
	
   


  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }
}
