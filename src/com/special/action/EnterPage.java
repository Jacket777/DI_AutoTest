package com.special.action;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.element.location.AlarmPage;
import com.element.location.homePage;
import com.universal.tool.oper;

public class EnterPage {

      //==============�����������ҳ��=======================
	   public static void taskManage(ChromeDriver driver) {
		   //����������
		   WebElement  sysMan = driver.findElementByXPath(homePage.taskManage);
		   sysMan.click();
		   oper.waitTime(2);
	   }
	
	
	
	
	
	
	
	
	
	//=================================�澯����===============================================
	//����澯��Խҳ��
    public static void alarmConfig(ChromeDriver driver) {
    	  //����澯����
    	  WebElement  alarmManager = driver.findElementByXPath(homePage.alarmManage);
    	  alarmManager.click();
    	  oper.waitTime(2);
    	  //����澯��Խ
    	  WebElement alarmPolicy = driver.findElementByXPath(AlarmPage.alarmConfig);
    	  alarmPolicy.click();
    }
    
    
   //����澯����ҳ��
   public static void alarmTask(ChromeDriver driver) {
	  //����澯����
 	  WebElement  alarmManager = driver.findElementByXPath(homePage.alarmManage);
 	  alarmManager.click();
 	  oper.waitTime(2);
 	  //����澯����
	  WebElement alarmPolicy = driver.findElementByXPath(AlarmPage.alarmTask);
	  alarmPolicy.click();
 	  
 	  
 	  
	   
   }
    
    
    
    
    
    

}
