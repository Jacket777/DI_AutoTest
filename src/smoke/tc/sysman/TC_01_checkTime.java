package smoke.tc.sysman;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import static org.testng.Assert.assertTrue;
import com.universal.tool.Log;
import com.universal.tool.oper;
import com.universal.tool.Table;
import smoke.basic.tools.User;
import smoke.platform.ui.SysMan;
import smoke.platform.action.EnterPage;

 
// ϵͳ����--����ʱ����в��ң��������ѡʱ������
public class TC_01_checkTime {
	public static ChromeDriver driver;
	
	@BeforeMethod
	 public void beforeMethod() {
		User.configExplore();
		driver= new ChromeDriver();
		EnterPage.login(driver);
		EnterPage.systemManager(driver); 
	 }
	
	 @Test
	  public void testAddAlarm() {
		 boolean result = true;
		 boolean isFind = false;
		 Log.info("Step 1.���ʱ�������");
		 WebElement time = driver.findElementByXPath(SysMan.timeInput);
		 time.click();
		 oper.waitTime(2);
		 Log.info("Step 2.�����ʼʱ������򣬲�����ʱ��");
		 User.inputByName(driver, SysMan.beginName, "2017-11-01");
		 Log.info("Step 3.�������ʱ������򣬲�����ʱ��");
		 User.inputByName(driver, SysMan.endName, "2017-11-08");
		 oper.waitTime(2);
		 User.tapButton(driver, SysMan.confirm);
		 oper.waitTime(2);
		 Log.info("Step 4.ѡ���½�����");
		 WebElement typeSel = driver.findElementByXPath(SysMan.typeSel);
		 User.selectOption(typeSel, "�½�����");
		 oper.waitTime(2);
		 Log.info("Step 5.�����ѯ��ť");
		 User.tapButton(driver, SysMan.qusBut);
		 oper.waitTime(5);
		 Log.info("Step 6.����½������е�ʱ��");
		 Table tab = new Table(User.getElement(driver, SysMan.tab));
		 int row = tab.getRowCount();
		 if(row==0) {
			 oper.LogOut("���κβ�������");
		 }else {
		 for(int i = 1; i <=row;i++) {
			 WebElement td = tab.getCell(i, 2);
			 WebElement span = td.findElement(By.tagName("span"));
			 String text = span.getText();
			 System.out.println(text);
			 String num1 = "2017-11-01 00:00:00";
			 String num2 = "2017-11-09 00:00:00";
			 boolean testResult =  User.checkDate(num1, num2, text);
			 if(!testResult) {
				 Log.value(text);
				 isFind = true;
				 break;
			  } 
		    }
		 }
		 if(isFind) {result = false;}
		 assertTrue(result);
	    
	   }
	 
	 @AfterMethod
	  public void afterMethod() {
		  driver.quit();
	  }
}
