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

public class MY00201 {
  public static ChromeDriver driver;
  
  String projectName = "项目名称"; 
  String cycle = "统计周期："; 
  String taskState = "任务状态";
  String taskRange="任务排名Top5";
  String range="排序方式：";
  String alarm="告警统计Top5";
	
  boolean isProjectName = false;
  boolean isCycle = false;
  boolean isTaskState = false;
  boolean isTaskRange = false;
  boolean isRange = false;
  boolean isAlarm = false;
  boolean Result = false;

 @BeforeMethod
 public void beforeMethod() {
	 driver= oper.getChromeDriver();
	 function.login(driver);
	 oper.waitTime(8);
	 }
 
@Test
 public void testEnterOverView() {
	//查找概览文本，并点击   
    WebElement overview = driver.findElement(By.xpath("//span[contains(text(),'概览')]"));
	overview.click();
	oper.waitTime(5);
	List<WebElement> divs = driver.findElements(By.className("bottom"));
	for(WebElement div:divs) {
		List<WebElement> spans = div.findElements(By.tagName("span"));
		for(WebElement span:spans) {
			String text = span.getText();
			if(text.equals(projectName)) {
				isProjectName = true;	
			}else if(text.equals(cycle)) {
				isCycle =true;	
			}else if(text.equals(taskState)) {
				isTaskState = true;
			}else if(text.equals(taskRange)) {
				isTaskRange = true;
			}else if(text.equals(range)) {
				isRange = true;
			}else if(text.equals(alarm)) {
				isAlarm = true;
			}		
	Result = isProjectName&&isCycle&&isTaskState&&isTaskRange&&isRange&&isAlarm;
	if(Result) {break;}
		}
	if(Result) {break;}
	}
    assertTrue(Result);	
 }
 
  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }
}