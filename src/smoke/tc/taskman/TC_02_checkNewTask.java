package smoke.tc.taskman;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import static org.testng.Assert.assertTrue;
import java.util.List;
import smoke.platform.action.EnterPage;
import smoke.basic.tools.User;
import com.universal.tool.Table;
import com.universal.tool.oper;
import smoke.platform.ui.TaskHome;
import smoke.data.config.Task;

public class TC_02_checkNewTask {
	public static ChromeDriver driver;

	@BeforeMethod
	public void beforeMethod() {
		User.configExplore();
		driver = new ChromeDriver();
		EnterPage.login(driver);
		EnterPage.taskManage(driver);
	}

	@Test
	public void testCreateTask() {
		boolean isFind = false;
		boolean status = false;
		boolean star = false;
		boolean edit = false;
		boolean del = false;
		boolean detail = false;

		Table tab = new Table(User.getElement(driver, TaskHome.tab));
		int row = tab.getRowCount();
		int result = tab.getRowNo(Task.name, 2, row, tab);
		if (result != -1) {
			WebElement td = tab.getCell(result, 7);
			String taskStatue = td.getText();
			System.out.println(taskStatue);
			status = User.checkString(TaskHome.ready, taskStatue);

			WebElement lastTd = tab.getCell(result, 8);
			List<WebElement> as = lastTd.findElements(By.tagName("a"));
			for (int i = 0; i < as.size(); i++) {
				String operation = as.get(i).getText();
				System.out.println(operation);
				if (operation.equals(TaskHome.star)) {
					star = true;
				}
				if (operation.equals(TaskHome.edit)) {
					edit = true;
				}
				if (operation.equals(TaskHome.del)) {
					del = true;
				}
				if (operation.equals(TaskHome.detail)) {
					detail = true;
				}
			}
		}
		oper.waitTime(5);
		isFind = status && star && edit && del && detail;
		assertTrue(isFind);
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
}