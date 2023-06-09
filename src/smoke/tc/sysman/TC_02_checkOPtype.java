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

// 系统管理--根据任务类型进行查询--查询新建任务
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
		 Log.info("Step 5.选择新建任务");
		 WebElement typeSel = driver.findElementByXPath(SysMan.typeSel);
		 User.selectOption(typeSel, "新建任务");
		 oper.waitTime(2);
		 Log.info("Step 6.点击查询按钮");
		 User.tapButton(driver, SysMan.qusBut);
		 oper.waitTime(5);
		 Log.info("Step 7.检查是否存在");
		 Table tab = User.getTab(driver, SysMan.tab);
		 int row = tab.getRowCount();
		 if(row==0) {
			 oper.LogOut("无任何操作数据");
		 }else {
		 for(int i = 1; i <=row;i++) {
			 WebElement td = tab.getCell(i, 3);
			 String text = td.getText();
			 System.out.println(text);
			 if(!text.equals("新建任务")) {
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