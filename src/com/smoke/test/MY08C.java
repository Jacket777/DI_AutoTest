package com.smoke.test;

import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import static org.testng.Assert.assertTrue;

public class MY08C {
  public static WebDriver driver;
  String portUrl="https://ssosit.cnsuning.com/ids/login?service=http%3A%2F%2Fdatacloudsit.cnsuning.com%2Fbigdata-portal-web%2Fauth%3FtargetUrl%3Dhttp%253A%252F%252Fdatacloudsit.cnsuning.com%252Fbigdata-portal-web%252Fconsole.html&loginTheme=datacloudsit#/portal";
  String dataIntegrateUrl="http://disit.cnsuning.com/di-web/?authoritySystemId=12558#/taskManagementMain";
 
  //����ҳ��Ԫ�ؼ��
  String orderHead = "����";//th
  String taskHead="��������";//th
  String sourHead="Դ����";//th
  String objHead="Ŀ������";//th
  String speedHead = "��ǰ�ٶ�";//th
  String numberHead="��ǰ������/������";//th
  String stateHead="����״̬";//th
  String operHead="����";//th
  

  boolean tableHead=false;
  boolean isOrederHead = false;
  boolean isTaskHead = false;
  boolean isSourHead = false;
  boolean isObjHead = false;
  boolean isSpeedHead = false;
  boolean isNumberHead = false;
  boolean isStateHead = false;
  boolean isOperHead = false;
  
 @BeforeMethod
 public void beforeMethod() {
  System.setProperty("webdriver.chrome.driver", "F:\\chromedriver.exe");  
  driver= new ChromeDriver();
  driver.get(portUrl);//login the port web
  WebElement userNameInput = driver.findElement(By.id("username"));
  WebElement passwordInput=driver.findElement(By.id("password"));
  WebElement loginButton = driver.findElement(By.className("login_button"));
  userNameInput.sendKeys("14082455");
  passwordInput.sendKeys("14082455");
  loginButton.click();
  driver.get(dataIntegrateUrl);//login the data integration web
	try {
	 Thread.sleep(30000);} 
	catch (InterruptedException e) {
		e.printStackTrace();
	}
 }
 
 @Test
  public void testTaskPage() {
   //1.check the table head
   WebElement table = driver.findElement(By.tagName("table"));
   WebElement thead = table.findElement(By.tagName("thead"));
   WebElement tr = thead.findElement(By.tagName("tr"));
   List<WebElement> ths =tr.findElements(By.tagName("th"));
   for(WebElement th:ths) {
	   String text = th.getText();
	   //System.out.println("th "+text);
	   if(text.equals(orderHead)) {
		   isOrederHead = true; 
	   }else if(text.equals(taskHead)){
		   isTaskHead = true;
	   }else if(text.equals(sourHead)) {
		   isSourHead = true;
	   }else if(text.equals(objHead)) {
		   isObjHead = true;   
	   }else if(text.equals(speedHead)) {
		   isSpeedHead = true;
	   }else if(text.equals(numberHead)) {
		   isNumberHead = true;
	   }else if(text.equals(stateHead)) {
		   isStateHead = true;
	   }else if(text.equals(operHead)) {
		   isOperHead = true;
	   }
   }
   tableHead=isOrederHead&&isTaskHead&&isSourHead&&isObjHead&&isSpeedHead&&isNumberHead&&isStateHead&&isOperHead;

  
   
   //debug issue
   if(!isOrederHead) { System.out.println("���� not found");}
   if(!isTaskHead) { System.out.println("��������  not found");}
   if(!isSourHead) { System.out.println("Դ����  not found"); }
   if(!isObjHead) { System.out.println("Ŀ������  not found");}
   if(!isNumberHead) { System.out.println("��ǰ������/������  not found");}
   if(!isStateHead) { System.out.println("����״̬ not found");}
   if(!isOperHead) { System.out.println("���� not found");}
	   
   
   //check the result
   boolean result = tableHead;
   assertTrue(result);
  }
 
  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }
}
