package smoke.tc.taskman;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import static org.testng.Assert.assertTrue;
import smoke.basic.tools.User;
import smoke.platform.ui.TaskHome;
import smoke.platform.action.EnterPage;
import smoke.platform.ui.TaskStarProcess;

import com.universal.tool.Table;
import com.universal.tool.oper;

public class TC_06_starTask {
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
		Table tab = new Table(User.getElement(driver, TaskHome.tab));
		int row = tab.getRowCount();
		int result = tab.getRowNo("Test", 2, row, tab);
		if (result != -1) {
			tab.tapOPText(TaskHome.star, result, 8, tab, driver);
			oper.waitTime(5);

			WebElement init = driver.findElementByXPath(TaskStarProcess.init);
			if (!init.isSelected()) {
				init.click();
			}
			User.tapButton(driver, TaskStarProcess.confirmBut);
			WebElement message = User.getElement(driver, TaskStarProcess.succMessage);
			String infor = message.getText();
			oper.LogOut(infor);
			boolean lastResult = User.checkString("�����ʼ���ɹ�!", infor);
			User.tapButton(driver, TaskStarProcess.know);
			oper.waitTime(5);
			assertTrue(lastResult);
		}
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
}