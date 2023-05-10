package smoke.tc.taskman;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import static org.testng.Assert.assertTrue;
import smoke.basic.tools.User;
import smoke.data.config.Task;
import com.universal.tool.oper;
import com.universal.tool.Table;
import smoke.platform.ui.TaskTip;
import smoke.platform.ui.TaskHome;
import smoke.platform.action.EnterPage;



public class TC_08_delTask {
	public static ChromeDriver driver;
	
	@BeforeMethod
	 public void beforeMethod() {
		User.configExplore();
		driver= new ChromeDriver();
		EnterPage.login(driver);
		EnterPage.taskManage(driver);
	 }
	
	@Test
	public void testDelTask() {
		 boolean isDel = false;
		 Table tab = new Table(User.getElement(driver, TaskHome.tab));
		 int row = tab.getRowCount();
		 int result = tab.getRowNo("Test", 2, row, tab);
		 if(result!=-1) {
			 tab.tapOPText(Task.del, result, 8, tab, driver);
			 oper.waitTime(3);
			 WebElement deltit = User.getElement(driver, TaskTip.deline);
			 if(deltit.getText().equals("ȷ��ɾ��")) {
				 WebElement div = driver.findElementByXPath(TaskTip.delDiv);
				 oper.tapButton(div, "ȷ��");
				 oper.waitTime(2);
				 WebElement prompDiv = User.getElement(driver, TaskTip.prompDiv);
				 oper.tapButton(prompDiv, "֪����");
				 oper.waitTime(2);
				 //User.tapButton(driver, TaskTip.confirmBut);
				 oper.waitTime(3);
				 Table tab2 = new Table(User.getElement(driver, TaskHome.tab));
				 int row2 = tab2.getRowCount();
				 int result2 = tab2.getRowNo("Test", 2, row2, tab);
				 if(result2==-1) {
					 isDel = true;
				 }	 
			 }
		}
		 oper.waitTime(5);
		 assertTrue(isDel);
	}
	
	 @AfterMethod
	  public void afterMethod() {
		  driver.quit();
	  }
}