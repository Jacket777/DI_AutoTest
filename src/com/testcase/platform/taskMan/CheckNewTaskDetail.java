package com.testcase.platform.taskMan;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import static org.testng.Assert.assertTrue;


import com.special.tool.User;
import com.test.dataConfig.Task;
import com.universal.tool.Table;
import com.universal.tool.oper;
import com.element.location.TaskDetail;
import com.element.location.TaskHome;




//C--�ҵ�����󣬵���������飬ҳ����ת����������ҳ��

public class CheckNewTaskDetail {
 public static ChromeDriver driver;
 
 @BeforeMethod
 public void beforeMethod() {
  User.configExplore();
  driver= new ChromeDriver();
  User.login(driver);
  
 }
 
 @Test
  public void testNewTaskDetail() throws StaleElementReferenceException{
	 boolean isFind = false;
	 System.out.println("===============1.�ҵ���Ҫ����������=======================");
	 Table tab = new Table(User.getElement(driver, TaskHome.tab));
	 int row = tab.getRowCount();
	 int result = tab.getRowNo(Task.name, 2, row, tab);
	 System.out.println("===============2.������鰴ť=======================");
	 tab.tapOPText(TaskHome.detail, result, 8, tab, driver);
	 System.out.println("===============3.�����������ҳ��=======================");
	 oper.waitTime(5);
	 WebElement title = driver.findElementByXPath(TaskDetail.title);
	 String getTaskName = title.getText();
     System.out.println(getTaskName);
     if(getTaskName.equals("�������飺"+Task.name)) {
    	 isFind = true;
     }
	 assertTrue(isFind);
	}
	
  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }
}
