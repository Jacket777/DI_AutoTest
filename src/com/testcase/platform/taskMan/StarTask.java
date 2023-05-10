package com.testcase.platform.taskMan;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import java.util.List;

import com.special.action.EnterPage;
import com.special.tool.User;
import com.universal.tool.Table;
import com.universal.tool.oper;
import com.element.location.TaskHome;
import com.element.location.TaskStarProcess;




//C--��������

public class StarTask {
 public static ChromeDriver driver;
 
 @BeforeMethod
 public void beforeMethod() {
  User.configExplore();
  driver= new ChromeDriver();
  User.login(driver);
  EnterPage.taskManage(driver);
 }
 
 @Test
  public void testStarTask() {
	
	 System.out.println("===============1.�ҵ�����=======================");
	 Table tab = new Table(User.getElement(driver, TaskHome.tab));
	 int row = tab.getRowCount();
	 int result = tab.getRowNo("Test", 2, row, tab);
	 if(result!=-1) {
		 System.out.println("===============2.�ҵ�������ť=======================");
		 WebElement lastTd = tab.getCell(result, 8);
		 List<WebElement> as = lastTd.findElements(By.tagName("a"));
		 for(int i = 0; i <as.size();i++) {
			 WebElement element = as.get(i);
			 String operation = element.getText();
			 System.out.println(operation);
			 if(operation.equals(TaskHome.star)) {
				 System.out.println("===========3.���������ť=============");
				 element.click();
				 oper.waitTime(5);
				 System.out.println("===========4.�ڵ�������ѡ���ʼ��=============");
				 WebElement  init = driver.findElementByXPath(TaskStarProcess.init);
				 if(!init.isSelected()) {
					 init.click();
				 }
				 System.out.println("===========5.�ڵ�����ѡ��ȷ��=============");
				 User.tapButton(driver, TaskStarProcess.confirmBut);
				 System.out.println("===========6.ȷ�ϵ��������Ϣ=============");
				 User.tapButton(driver, TaskStarProcess.know);
				 oper.waitTime(5);
//				 WebElement message = driver.findElementByXPath(TaskStarProcess.succMessage);
//				 String infor = message.getText();
//				 System.out.println(infor);
//				 if(infor.equals("�����ʼ���ɹ�!")) {
//					 lastResult = false; 
//				 }
			 }
		 } 
	 }
	
   }








  

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }
}
