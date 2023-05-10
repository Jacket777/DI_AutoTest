package com.testcase.platform.taskMan;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import static org.testng.Assert.assertTrue;
import com.special.action.EnterPage;
import com.special.tool.User;
import com.universal.tool.Table;
import com.element.location.TaskHome;
import com.element.location.TaskTip;

//  �½�����������ֹͣ
public class StopTask {
 public static ChromeDriver driver;
 
 @BeforeMethod
 public void beforeMethod() {
  User.configExplore();
  driver= new ChromeDriver();
  User.login(driver);
  EnterPage.taskManage(driver);
 }
 
 @Test
  public void testStopTask() {
	 boolean isStop = false;
	 System.out.println("===============1.�ҵ�����=======================");
	 Table tab = new Table(User.getElement(driver, TaskHome.tab));
	 int row = tab.getRowCount();
	 int result = tab.getRowNo("Test", 2, row, tab);
	 if(result!=-1) {
		 System.out.println("===============2.ȷ������״̬=======================");
		 WebElement status = tab.getCell(result, 7);
		 String taskStat = status.getText();
		 if(taskStat.equals(TaskHome.online)) {
			 System.out.println("===============3.����״̬Ϊ����=======================");
			 System.out.println("===============4.���ֹͣ=======================");
			 tab.tapOPText(TaskHome.stop, result, 8, tab, driver);
			 System.out.println("===============5.ȷ��������ʾ��������=======================");
			 WebElement tip = User.getElement(driver,TaskTip.offline);
			 if(tip.getText().equals("�������߳ɹ�")) {
				 User.tapButton(driver, TaskTip.offknow);
				 Table tab2 = new Table(User.getElement(driver, TaskHome.tab));
				 WebElement st = tab2.getCell(result, 7);
				 String taskst = st.getText();
				 if(taskst.equals(TaskHome.offline)) {
					  isStop = true;
				 }
			 }
		 }
	}
	 
	 assertTrue(isStop);
} 
	 
	
   








  

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }
}
