package com.special.action;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.element.location.AlarmPage;
import com.element.location.homePage;
import com.universal.tool.oper;

public class EnterPage {

      //==============进入任务管理页面=======================
	   public static void taskManage(ChromeDriver driver) {
		   //点击任务管理
		   WebElement  sysMan = driver.findElementByXPath(homePage.taskManage);
		   sysMan.click();
		   oper.waitTime(2);
	   }
	
	
	
	
	
	
	
	
	
	//=================================告警管理===============================================
	//进入告警策越页面
    public static void alarmConfig(ChromeDriver driver) {
    	  //点击告警管理
    	  WebElement  alarmManager = driver.findElementByXPath(homePage.alarmManage);
    	  alarmManager.click();
    	  oper.waitTime(2);
    	  //点击告警策越
    	  WebElement alarmPolicy = driver.findElementByXPath(AlarmPage.alarmConfig);
    	  alarmPolicy.click();
    }
    
    
   //进入告警任务页面
   public static void alarmTask(ChromeDriver driver) {
	  //点击告警管理
 	  WebElement  alarmManager = driver.findElementByXPath(homePage.alarmManage);
 	  alarmManager.click();
 	  oper.waitTime(2);
 	  //点击告警任务
	  WebElement alarmPolicy = driver.findElementByXPath(AlarmPage.alarmTask);
	  alarmPolicy.click();
 	  
 	  
 	  
	   
   }
    
    
    
    
    
    

}
