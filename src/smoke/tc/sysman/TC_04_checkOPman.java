package smoke.tc.sysman;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import static org.testng.Assert.assertFalse;
import smoke.basic.tools.User;
import com.universal.tool.oper;
import com.universal.tool.Log;
import com.universal.tool.Table;
import smoke.platform.action.EnterPage;
import smoke.platform.ui.SysMan;

// 系统管理--input框筛选操作日志--操作人信息--姓名
public class TC_04_checkOPman {
	public static ChromeDriver driver;
	
	@BeforeMethod
	public void beforeMethod() {
		User.configExplore();
		driver= new ChromeDriver();
		EnterPage.login(driver);
		EnterPage.systemManager(driver);	
	}
	
	@Test
	public void testCheckInMan() {
		 boolean isFind = false;
		 Log.info("Step 1.点击时间输入框");
		 WebElement time = driver.findElementByXPath(SysMan.timeInput);
		 time.click();
		 oper.waitTime(2);
		 Log.info("Step 2.点击开始时间输入框，并输入时间");
		 User.inputByName(driver, SysMan.beginName, "2017-11-01");
		 Log.info("Step 3.点击结束时间输入框，并输入时间");
		 User.inputByName(driver, SysMan.endName, "2017-11-08");
		 oper.waitTime(2);
		 Log.info("Step 4.点击确认按钮");
		 User.tapButton(driver, SysMan.confirm);
		 oper.waitTime(2);
		 Log.info("Step 5.删除任务");
		 WebElement typeSel = driver.findElementByXPath(SysMan.typeSel);
		 User.selectOption(typeSel, "删除任务");
		 oper.waitTime(2);
		 Log.info("Step 6.输入操作人");
		 User.inputText(driver, SysMan.keyInput, "徐伟");
		 oper.waitTime(2);
		 Log.info("Step 7.点击查询按钮");
		 User.tapButton(driver, SysMan.qusBut);
		 oper.waitTime(5);
		 Log.info("Step 8.检查操作人");
		 Table tab = new Table(User.getElement(driver, SysMan.tab));
		 int row = tab.getRowCount();
		 if(row==0) {
			 oper.LogOut("无任何操作数据");
		 }else {
		 for(int i = 1; i <=row;i++) {
			 WebElement td = tab.getCell(i, 6);
			 String text = td.getText();
			 System.out.println(text);
			 if(!text.equals("徐伟")) {
				 System.out.println("============================="+text);
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