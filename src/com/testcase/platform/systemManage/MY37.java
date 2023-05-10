package com.testcase.platform.systemManage;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import static org.testng.Assert.assertTrue;
import com.special.tool.User;
import com.universal.tool.oper;
import com.universal.tool.Table;
import com.element.location.homePage;
import com.element.location.sysMan;



// ϵͳ����--����ʱ����в��ң��������ѡʱ������
public class MY37 {
 public static ChromeDriver driver;
 
 @BeforeMethod
 public void beforeMethod() {
  User.configExplore();
  driver= new ChromeDriver();
  driver.manage().window().maximize();
  User.login(driver);
  //���ϵͳ����
  WebElement  sysMan = driver.findElementByXPath(homePage.sysManage);
  sysMan.click();
  oper.waitTime(2);
 }
 
 @Test
  public void testAddAlarm() {
     boolean result = true;
	 boolean isFind = false;
	 System.out.println("===============1.���ʱ�������=======================");
	 WebElement time = driver.findElementByXPath(sysMan.timeInput);
	 time.click();
	 oper.waitTime(2);
	 System.out.println("===============2.�����ʼʱ������򣬲�����ʱ��=======================");
	 WebElement begin = driver.findElement(By.name(sysMan.beginName));
	 begin.clear();
	 begin.sendKeys("2017-11-01");
	 oper.waitTime(2);
	 WebElement but1 = driver.findElementByXPath(sysMan.confirm);
	 but1.click();
	 oper.waitTime(2);
	 ////
	 time.click();
	 oper.waitTime(6);
	 System.out.println("===============3.�������ʱ������򣬲�����ʱ��=======================");
	 WebElement end = driver.findElement(By.name(sysMan.endName));
	 end.clear();
	 end.sendKeys("2017-11-08");
	 oper.waitTime(2);
	 WebElement but2 = driver.findElementByXPath(sysMan.confirm);
	 but2.click();
	 oper.waitTime(2);
	 System.out.println("===============4.ѡ���½�����=======================");
	 WebElement typeSel = driver.findElementByXPath(sysMan.typeSel);
	 User.selectOption(typeSel, "�½�����");
	 oper.waitTime(2);
	 System.out.println("===============5.�����ѯ��ť=======================");
	 WebElement queryBut = driver.findElementByXPath(sysMan.qusBut);
	 queryBut.click();
	 oper.waitTime(5);
	 System.out.println("===============6.����½������е�ʱ��=======================");
	 Table tab = new Table(User.getElement(driver, sysMan.tab));
	 int row = tab.getRowCount();
	 for(int i = 1; i <=row;i++) {
		 WebElement td = tab.getCell(i, 2);
		 WebElement span = td.findElement(By.tagName("span"));
		 String text = span.getText();
		 System.out.println(text);
		 String num1 = "2017-11-01 00:00:00";
		 String num2 = "2017-11-09 00:00:00";
		 boolean testResult =  User.checkDate(num1, num2, text);
		 if(!testResult) {
			 System.out.println("============================="+text);
			 isFind = true;
			 break;
		 } 
	 }
   
	 if(isFind) {
		 result = false;
	 }
	 
	 assertTrue(result);

	
   }
  

  
 
  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }
}
