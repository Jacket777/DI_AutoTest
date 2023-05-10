package smoke.tc.taskman;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import static org.testng.Assert.assertTrue;
import smoke.basic.tools.User;
import com.universal.tool.oper;
import com.universal.tool.Table;
import smoke.platform.ui.TaskTip;
import smoke.platform.ui.TaskHome;
import smoke.platform.action.EnterPage;

public class TC_07_stopTask {
	public static ChromeDriver driver;

	@BeforeMethod
	public void beforeMethod() {
		User.configExplore();
		driver = new ChromeDriver();
		EnterPage.login(driver);
		EnterPage.taskManage(driver);
	}

	@Test
	public void testStopTask() {
		boolean isStop = false;
		Table tab = new Table(User.getElement(driver, TaskHome.tab));
		int row = tab.getRowCount();
		int result = tab.getRowNo("Test", 2, row, tab);
		if (result != -1) {
			WebElement status = tab.getCell(result, 7);
			String taskStat = status.getText();
			if (taskStat.equals(TaskHome.online)) {
				tab.tapOPText(TaskHome.stop, result, 8, tab, driver);
				oper.waitTime(3);
				WebElement tip = User.getElement(driver, TaskTip.offline);
				oper.LogOut("��ʾ������======" + tip.getText());
				if (tip.getText().equals("�������߳ɹ�")) {
					User.tapButton(driver, TaskTip.offknow);
					oper.waitTime(2);
					WebElement table = driver.findElementByTagName("table");
					Table tab2 = new Table(table);
					WebElement st = tab2.getCell(result, 7);
					String taskst = st.getText();
					oper.LogOut("===============" + taskst);
					if (taskst.equals(TaskHome.offline) || taskst.equals("ʧ��")) {
						isStop = true;
					}
				}
			}
		}
		oper.waitTime(5);
		assertTrue(isStop);
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
}