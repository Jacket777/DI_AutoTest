package com.smoke.test;

import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import static org.testng.Assert.assertTrue;

public class MY01 {
  public static WebDriver driver;
  String portUrl="https://ssosit.cnsuning.com/ids/login?service=http%3A%2F%2Fdatacloudsit.cnsuning.com%2Fbigdata-portal-web%2Fauth%3FtargetUrl%3Dhttp%253A%252F%252Fdatacloudsit.cnsuning.com%252Fbigdata-portal-web%252Fconsole.html&loginTheme=datacloudsit#/portal";
  String dataIntegrateUrl="http://disit.cnsuning.com/di-web/?authoritySystemId=12558#/taskManagementMain";

 @BeforeMethod
 public void beforeMethod() {
  System.setProperty("webdriver.chrome.driver", "F:\\chromedriver.exe");  
  driver= new ChromeDriver();
	  }
 
 @Test
  public void testOverview() {
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
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   
	//检查左侧导航栏
	 String overview = "概览";
	 boolean isOverview = false;
	 String taskman = "任务管理";
	 boolean isTaskman=false;
	 String  alarman="告警管理";
	 boolean isAlarm=false;
	 String sysman="系统管理";
	 boolean isSys=false;
	
	 //check
	 List<WebElement> elements  =  driver.findElements(By.className("ng-binding"));
	 	for(WebElement element:elements ) {
	 		String text = element.getText();
	 		if(text.equals(overview)) {
	 		    isOverview = true;
	 		}else if(text.equals(taskman)) {
	 			isTaskman=true;
	 		}else if(text.equals(alarman)) {
	 			isAlarm = true;
	 		}else if(text.equals(sysman)) {
	 			isSys = true;
	 		}
	 	}
	 	
	 	boolean result = isOverview&&isTaskman&&isAlarm&&isSys;
	 	assertTrue(result);
  }
 

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }
}
