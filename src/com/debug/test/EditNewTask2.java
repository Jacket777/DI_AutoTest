package com.debug.test;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
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




//C--编辑任务后，编辑任务后，页面跳转到编辑页面

public class EditNewTask2 {
 public static ChromeDriver driver;
 
 @BeforeMethod
 public void beforeMethod() {
  User.configExplore();
  driver= new ChromeDriver();
  User.login(driver);
  EnterPage.taskManage(driver);
 }
 
 @Test
  public void testCreateTask() throws StaleElementReferenceException{
	 System.out.println("===============End.检查操作内容=======================");
	 Table tab = new Table(User.getElement(driver, TaskHome.tab));
	 int row = tab.getRowCount();
	 int result = tab.getRowNo("Test", 2, row, tab);
	 if(result!=-1) {
		 //1.找到编辑的操作
		 WebElement lastTd = tab.getCell(result, 8);
		 List<WebElement> as = lastTd.findElements(By.tagName("a"));
		 for(int i = 0; i <as.size();i++) {
			 WebElement element = as.get(i);
			 String operation = element.getText();
			 System.out.println(operation);
			 if(operation.equals(TaskHome.edit)) {
				 System.out.println("=========xxxxx=============");
				 element.click();
				 oper.waitTime(30);
				 String programe="var inputs = document.getElementsByTagName('input');return inputs[0]";
				 WebElement input =(WebElement) driver.executeScript(programe);
				 System.out.println(input.getAttribute("value"));	 
			 }
		 } 
	 }
   }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }
}
