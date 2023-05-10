package smoke.tc.taskman;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import static org.testng.Assert.assertTrue;
import smoke.platform.action.EnterPage;
import smoke.basic.tools.User;
import smoke.platform.ui.TaskHome;
import smoke.platform.ui.TaskStarProcess;
import com.universal.tool.Table;
import com.universal.tool.oper;

public class TC_05_cancelStarTask {
	public static ChromeDriver driver;

	@BeforeMethod
	public void beforeMethod() {
		User.configExplore();
		driver = new ChromeDriver();
		EnterPage.login(driver);
		EnterPage.taskManage(driver);
	}

	@Test
	public void testStarTask() {
		boolean isFind = false;
		boolean star = false;
		boolean edit = false;
		boolean del = false;
		boolean detail = false;
		Table tab = new Table(User.getElement(driver, TaskHome.tab));
		int row = tab.getRowCount();
		int result = tab.getRowNo("Test", 2, row, tab);
		if (result != -1) {
			tab.tapOPText(TaskHome.star, result, 8, tab, driver);
			oper.waitTime(3);
			User.tapButton(driver, TaskStarProcess.cancelBut);
			oper.waitTime(3);
			Table tab2 = new Table(User.getElement(driver, TaskHome.tab));
			int lastresult = tab2.getRowNo("Test", 2, row, tab2);
			if (lastresult != -1) {
				WebElement lastTd = tab2.getCell(lastresult, 8);
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
				oper.waitTime(5);
				isFind = star && edit && del && detail;
			}
		}
		assertTrue(isFind);
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
}