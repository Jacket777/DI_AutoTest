package com.testcase.platform.taskMan;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import static org.testng.Assert.assertTrue;
import com.special.tool.User;
import com.universal.tool.oper;
import com.universal.tool.Exploer;
import com.universal.tool.Table;
import com.element.location.FieldConfig;
import com.element.location.PreProceed;
import com.element.location.SourceData;
import com.element.location.TargetData;
import com.element.location.TaskBasic;
import com.element.location.TaskDataLink;
import com.element.location.TaskHome;
import com.element.location.homePage;


//�½�����--�ɹ������������м���Ƿ����

public class CreateTask {
 public static ChromeDriver driver;
 
 @BeforeMethod
 public void beforeMethod() {
  User.configExplore();
  driver= new ChromeDriver();
  driver.manage().window().maximize();
  User.login(driver);
  //����������
  WebElement  sysMan = driver.findElementByXPath(homePage.taskManage);
  sysMan.click();
  oper.waitTime(2);
 }
 
 @Test
  public void testCreateTask() {

	 boolean isFind = false;
	 System.out.println("===============1.�����������ť=======================");
	 WebElement create = driver.findElementByXPath(TaskHome.createTask);
	 create.click();
	 oper.waitTime(2);
	 System.out.println("===============2.����������=======================");
	 WebElement nameInput = driver.findElementByXPath(TaskBasic.nameInput);
	 nameInput.clear();
	 nameInput.sendKeys("Test");
	 oper.waitTime(2);
	 System.out.println("===============3.ѡ����������=======================");
	 User.selectOP(driver, TaskBasic.typeSel, "Mysql(binlog) �� Hive");
	 System.out.println("===============4.������������=======================");
	 User.inputText(driver, TaskBasic.descript, "xxxxxx");
	 System.out.println("===============5.�����һ��=======================");
	 User.tapButton(driver, TaskBasic.next);
	 System.out.println(">>>>>>>>>>>>>>>>>>>�������ý���<<<<<<<<<<<<<<<<<<<<");
	 System.out.println("===============6.����������Դ��ť=======================");
	 User.tapButton(driver, TaskDataLink.addSourBut);
	 System.out.println("===============7.ѡ������Դ����=======================");
	 User.selectOP(driver, SourceData.SelDB, "disit_test");
	 System.out.println("===============8.ѡ������Դ��=======================");
	 User.selectOP(driver, SourceData.SelTab, "disit_test");
	 System.out.println("===============9.�����Ӱ�ť=======================");
	 User.tapButton(driver, SourceData.addTabBut);
	 oper.waitTime(10);
	 
	 System.out.println("===============10.���ȷ�ϰ�ť=======================");
	 Exploer.scollToBottomofPag(driver);
	 User.tapButton(driver, SourceData.confirmBut);
	 
	 System.out.println(">>>>>>>>>>>>>>>>>>>����Դ���ý���<<<<<<<<<<<<<<<<<<<<");
	 
	 System.out.println("===============11.����������Ŀ�갴ť=======================");
	 User.tapButton(driver, TaskDataLink.addObjectBut);
	 System.out.println("===============12.ѡ������Դ����=======================");
	 User.selectOP(driver, TargetData.SelDB, "test");
	 System.out.println("===============13.ѡ���=======================");
	 User.selectOP(driver, TargetData.SelTab, "disit_test");
	 System.out.println("===============14.���ȷ�ϰ�ť=======================");
	 User.tapButton(driver, TargetData.confirmBut);
	 System.out.println(">>>>>>>>>>>>>>>>>>>����Ŀ�����ý���<<<<<<<<<<<<<<<<<<<<");
	 User.tapButton(driver, TaskDataLink.configBut);
	 User.selectOP(driver, FieldConfig.idSelect, "disit_id");
	 User.tapButton(driver, FieldConfig.know);
	 User.selectOP(driver, FieldConfig.nameSelect, "disit_name");
	 User.selectOP(driver, FieldConfig.timeSelect, "create_time");
	 User.tapButton(driver, FieldConfig.confirmBut);
	 Exploer.scollToBottomofPag(driver);
	 User.tapButton(driver, TaskDataLink.nextBut);
	 User.tapButton(driver, PreProceed.confirmBut);
	 	
	 System.out.println("===============End.����������=======================");
	 Table tab = new Table(User.getElement(driver, TaskHome.tab));
	 int row = tab.getRowCount();
	 for(int i = 1; i <=row;i++) {
		 WebElement td = tab.getCell(i, 2);
		 String text = td.getText();
		 System.out.println(text);
		 if(text.equals("Test")) {
			 System.out.println("============================="+text);
			 isFind = true;
			 break;
		 } 
	 }
  
	 assertTrue(isFind);
   }
  

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }
}
