package com.testcase.platform.taskMan;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import static org.testng.Assert.assertTrue;
import com.special.action.EnterPage;
import com.special.tool.User;
import com.test.dataConfig.Task;
import com.universal.tool.Table;
import com.universal.tool.oper;
import com.element.location.TaskHome;
import com.element.location.TaskTip;

//  ɾ������
public class DelTask {
 public static ChromeDriver driver;
 
 @BeforeMethod
 public void beforeMethod() {
  User.configExplore();
  driver= new ChromeDriver();
  User.login(driver);
  EnterPage.taskManage(driver);
 }
 
 @Test
  public void testDelTask() {
	 boolean isDel = false;
	 System.out.println("===============1.�ҵ�����=======================");
	 Table tab = new Table(User.getElement(driver, TaskHome.tab));
	 int row = tab.getRowCount();
	 int result = tab.getRowNo("Test", 2, row, tab);
	 if(result!=-1) {
		 System.out.println("===============2.ɾ������=======================");
		 tab.tapOPText(Task.del, result, 8, tab, driver);
		 oper.waitTime(3);
		 System.out.println("===============3.�������Ƿ�Ϊɾ����ʾ��=======================");
		 WebElement deltit = User.getElement(driver, TaskTip.deline);
		 if(deltit.getText().equals("ȷ��ɾ��")) {
			 System.out.println("===============4.���ȷ�ϰ�ť=======================");
			 WebElement div = driver.findElementByXPath("/html/body/div[3]/div/div/div[3]");
			 oper.tapButton(div, "ȷ��");
			 oper.waitTime(2);
			 System.out.println("===================5.���ɾ���ɹ���ʾ��============================");
			 WebElement prompDiv = User.getElement(driver, TaskTip.prompDiv);
			 oper.tapButton(prompDiv, "֪����");
			 oper.waitTime(2);
			 
			 //User.tapButton(driver, TaskTip.confirmBut);
			 System.out.println("===============5.�ڱ���м���Ƿ�ɾ��=======================");
			 oper.waitTime(3);
			 Table tab2 = new Table(User.getElement(driver, TaskHome.tab));
			 int row2 = tab2.getRowCount();
			 int result2 = tab2.getRowNo("Test", 2, row2, tab);
			 if(result2==-1) {
				 isDel = true;
			 }	 
		 }
	}
	 
	 assertTrue(isDel);
} 
	 
	 
  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }
}
