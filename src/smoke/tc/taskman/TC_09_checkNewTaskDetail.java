package smoke.tc.taskman;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.StaleElementReferenceException;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import static org.testng.Assert.assertTrue;
import smoke.basic.tools.User;
import smoke.data.config.Task;
import com.universal.tool.oper;
import com.universal.tool.Table;
import smoke.platform.ui.TaskHome;
import smoke.platform.ui.TaskDetail;
import smoke.platform.action.EnterPage;

public class TC_09_checkNewTaskDetail {
	public static ChromeDriver driver;
	
	 @BeforeMethod
	 public void beforeMethod() {
		 User.configExplore();
		 driver= new ChromeDriver();
		 EnterPage.login(driver);
		 EnterPage.taskManage(driver); 
	 }
	 
	 @Test
	 public void testNewTaskDetail() throws StaleElementReferenceException{
		 Table tab = new Table(User.getElement(driver, TaskHome.tab));
		 int row = tab.getRowCount();
		 int result = tab.getRowNo(Task.name, 2, row, tab);
		 tab.tapOPText(TaskHome.detail, result, 8, tab, driver);
		 oper.waitTime(5);
		 WebElement title = driver.findElementByXPath(TaskDetail.title);
		 String getTaskName = title.getText();
	     System.out.println(getTaskName);
	     String expect ="�������飺"+Task.name;
	     boolean isFind = User.checkString(expect, getTaskName);
		 assertTrue(isFind);
		}
	 
	 @AfterMethod
	  public void afterMethod() {
		  driver.quit();
	  }
}