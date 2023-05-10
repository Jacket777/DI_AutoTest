package smoke.tc.sysman;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import static org.testng.Assert.assertFalse;
import com.universal.tool.Log;
import com.universal.tool.oper;
import com.universal.tool.Table;
import smoke.basic.tools.User;
import smoke.platform.ui.SysMan;
import smoke.platform.action.EnterPage;

// ϵͳ����--�����������ͽ��в�ѯ--��ѯ�½�����
public class TC_02_checkOPtype {
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
		 Log.info("Step 4.���ȷ�ϰ�ť");
		 User.tapButton(driver, SysMan.confirm);
		 oper.waitTime(2);
		 Log.info("Step 5.ѡ���½�����");
		 WebElement typeSel = driver.findElementByXPath(SysMan.typeSel);
		 User.selectOption(typeSel, "�½�����");
		 oper.waitTime(2);
		 Log.info("Step 6.�����ѯ��ť");
		 User.tapButton(driver, SysMan.qusBut);
		 oper.waitTime(5);
		 Log.info("Step 7.����Ƿ����");
		 Table tab = User.getTab(driver, SysMan.tab);
		 int row = tab.getRowCount();
		 if(row==0) {
			 oper.LogOut("���κβ�������");
		 }else {
		 for(int i = 1; i <=row;i++) {
			 WebElement td = tab.getCell(i, 3);
			 String text = td.getText();
			 System.out.println(text);
			 if(!text.equals("�½�����")) {
				 Log.value(text);
				 isFind = true;
				 break;
			 } 
		   }
		 }
		 assertFalse(isFind);
	   }
	  
	  @AfterMethod
	  public void afterMethod() {
		  driver.quit();
	  } 
}