package com.smoke.test;

import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import static org.testng.Assert.assertTrue;

public class MY02B {
  public static WebDriver driver;
  String portUrl="https://ssosit.cnsuning.com/ids/login?service=http%3A%2F%2Fdatacloudsit.cnsuning.com%2Fbigdata-portal-web%2Fauth%3FtargetUrl%3Dhttp%253A%252F%252Fdatacloudsit.cnsuning.com%252Fbigdata-portal-web%252Fconsole.html&loginTheme=datacloudsit#/portal";
  String dataIntegrateUrl="http://disit.cnsuning.com/di-web/?authoritySystemId=12558#/taskManagementMain";
  

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
  //WebDriverWait wait = new WebDriverWait(driver, 20000);
  try {
	Thread.sleep(5000);
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	  }
 
 @Test (priority =1)
 public void testTask() {
	String allTask = "任务总数"; 
	String mySQLTask = "MySQL任务数"; 
	String kafkaTask = "Kafka任务数";

	boolean isAllTask = false;
	boolean isMySQLTask = false;
	boolean iskafakaTask = false;
	boolean result = false;	
	
	//查找概览文本，并点击   
	WebElement overview = driver.findElement(By.xpath("//span[contains(text(),'概览')]"));
	overview.click();
    try {
		Thread.sleep(5000);
		} catch (InterruptedException e) {
		e.printStackTrace();		
		}
		  
	List<WebElement> divs = driver.findElements(By.className("box-title"));
	for(WebElement div:divs) {
		System.out.println(div.getText());
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