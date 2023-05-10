package com.smoke.test;

import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import static org.testng.Assert.assertTrue;

public class MY02A {
  public static WebDriver driver;
  String portUrl="https://ssosit.cnsuning.com/ids/login?service=http%3A%2F%2Fdatacloudsit.cnsuning.com%2Fbigdata-portal-web%2Fauth%3FtargetUrl%3Dhttp%253A%252F%252Fdatacloudsit.cnsuning.com%252Fbigdata-portal-web%252Fconsole.html&loginTheme=datacloudsit#/portal";
  String dataIntegrateUrl="http://disit.cnsuning.com/di-web/?authoritySystemId=12558#/taskManagementMain";
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
  System.setProperty("webdriver.chrome.driver", "F:\\chromedriver.exe");  
  driver= new ChromeDriver();
  //login the port web
  driver.get(portUrl);
  WebElement userNameInput = driver.findElement(By.id("username"));
  userNameInput.sendKeys("14082455");
  WebElement passwordInput=driver.findElement(By.id("password"));
  passwordInput.sendKeys("14082455");
  WebElement loginButton = driver.findElement(By.className("login_button"));
  loginButton.click();
  //login the data integration web
  driver.get(dataIntegrateUrl);
  //网页加载时间
  try {
	Thread.sleep(5000);
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	 }
 
@Test
 public void testEnterOverView() {
	//查找概览文本，并点击   
    WebElement overview = driver.findElement(By.xpath("//span[contains(text(),'概览')]"));
	overview.click();
	try {
		 Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();}
	List<WebElement> divs = driver.findElements(By.className("bottom"));
	for(WebElement div:divs) {
		List<WebElement> spans = div.findElements(By.tagName("span"));
		for(WebElement span:spans) {
			System.out.println(span.getText());
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
	System.out.println("isProjectName "+isProjectName);
	System.out.println("isCycle "+isCycle);
	System.out.println("isTaskState "+isTaskState);
	System.out.println("isTaskRange "+isTaskRange);
	System.out.println("isRange "+isRange);
	System.out.println("isAlarm "+isAlarm);
    assertTrue(Result);	
 }
 
  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }
}