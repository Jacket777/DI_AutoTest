package com.smoke.test01;

import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import com.auto.tools.oper;
import com.data.function.function;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import static org.testng.Assert.assertTrue;

/*
 * 用例说明：检查概览页面中一部分元素
 */

public class MY00202 {
  public static ChromeDriver driver;

  String allTask = "任务总数"; 
  String mySQLTask = "MySQL任务数"; 
  String kafkaTask = "Kafka任务数";
  
  boolean isAllTask = false;
  boolean isMySQLTask = false;
  boolean iskafakaTask = false;
  boolean result = false;
		
  @BeforeMethod
  public void beforeMethod() {
	driver= oper.getChromeDriver();
	function.login(driver);
	oper.waitTime(8);
	}
 
 @Test
 public void testTask() {
	//查找概览文本，并点击   
	WebElement overview = driver.findElement(By.xpath("//span[contains(text(),'概览')]"));
	overview.click();
	oper.waitTime(8);
	List<WebElement> divs = driver.findElements(By.className("box-title"));
	for(WebElement div:divs) {
		//System.out.println(div.getText());
		String text = div.getText();
		if(text.equals(allTask)) {
		   isAllTask = true;
			}else if(text.equals(mySQLTask)) {
			isMySQLTask = true;	
			}else if(text.equals(kafkaTask)) {
			iskafakaTask = true;
			}
		result = isAllTask&&isMySQLTask&&iskafakaTask;
		if(result) {break;}	
			}
	    assertTrue(result);	
	 }
 
  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }
}