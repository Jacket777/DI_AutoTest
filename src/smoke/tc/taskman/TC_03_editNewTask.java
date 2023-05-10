package smoke.tc.taskman;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.StaleElementReferenceException;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import static org.testng.Assert.assertTrue;
import com.universal.tool.Table;
import com.universal.tool.oper;
import smoke.basic.tools.User;
import smoke.data.config.Task;
import smoke.platform.ui.TaskEdit;
import smoke.platform.ui.TaskHome;

public class TC_03_editNewTask {
	public static ChromeDriver driver;

	@BeforeMethod
	public void beforeMethod() {
		User.configExplore();
		driver = new ChromeDriver();
		User.login(driver);
	}

	@Test
	public void testEditNewTask() throws StaleElementReferenceException {
		Table tab = new Table(User.getElement(driver, TaskHome.tab));
		int row = tab.getRowCount();
		int result = tab.getRowNo("Test", 2, row, tab);
		tab.tapOPText(TaskHome.edit, result, 8, tab, driver);
		oper.waitTime(5);
		WebElement input = driver.findElementByXPath(TaskEdit.name);
		String getTaskName = input.getAttribute("value");
		oper.LogOut(getTaskName);
		boolean isFind = User.checkString(Task.name, getTaskName);
		oper.waitTime(5);
		assertTrue(isFind);
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
}