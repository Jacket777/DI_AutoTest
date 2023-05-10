package com.testcase.platform.taskMan;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import static org.testng.Assert.assertTrue;

import java.util.List;

import com.special.action.EnterPage;
import com.special.tool.User;
import com.universal.tool.Table;
import com.element.location.TaskHome;




//B--�½�����󣬼�������״̬��������ز���   B

public class CheckNewTask {
 public static ChromeDriver driver;
 
 @BeforeMethod
 public void beforeMethod() {
  User.configExplore();
  driver= new ChromeDriver();
  User.login(driver);
  EnterPage.taskManage(driver);
 }
 
 @Test
  public void testCreateTask() {

	 boolean isFind = false;
	 boolean status = false;
	 boolean star = false;
	 boolean edit = false;
	 boolean del = false;
	 boolean detail = false;
	 	
	 System.out.println("===============End.����������=======================");
	 Table tab = new Table(User.getElement(driver, TaskHome.tab));
	 int row = tab.getRowCount();
	 int result = tab.getRowNo("Test", 2, row, tab);
	 if(result!=-1) {
		 //�ҵ�������
		 //1.�ҵ�����״̬
		 WebElement td = tab.getCell(result, 7);
		 String taskStatue = td.getText();
		 System.out.println(taskStatue);
		 if(taskStatue.equals(TaskHome.ready)) {
			 status=true;
		 }
		 
		 //2.�ҵ���صĲ���
		 WebElement lastTd = tab.getCell(result, 8);
		 List<WebElement> as = lastTd.findElements(By.tagName("a"));
		 for(int i = 0; i <as.size();i++) {
			 String operation = as.get(i).getText();
			 System.out.println(operation);
			 if(operation.equals(TaskHome.star)) {
				 star = true;
			 }
			 if(operation.equals(TaskHome.edit)) {
				 edit = true;
			 }
			 if(operation.equals(TaskHome.del)) {
				 del = true;
			 }
			 if(operation.equals(TaskHome.detail)) {
				 detail = true;
			 }
		 } 
	 }
	 
    isFind = status&&star&&edit&&del&&detail;
	 assertTrue(isFind);
   }
  

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }
}
