package smoke.tc.taskman;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import static org.testng.Assert.assertTrue;
import smoke.basic.tools.User;
import smoke.platform.ui.TaskHome;
import smoke.platform.ui.TaskStarProcess;
import smoke.platform.action.EnterPage;
import smoke.data.config.StarType;

import com.universal.tool.Table;
import com.universal.tool.oper;

public class TC_04_starTask {
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
		boolean isFindinit = false;
		boolean isFindback = false;
		boolean isFindtime = false;
		Table tab = new Table(User.getElement(driver, TaskHome.tab));
		int row = tab.getRowCount();
		int result = tab.getRowNo("Test", 2, row, tab);
		if (result != -1) {
			tab.tapOPText(TaskHome.star, result, 8, tab, driver);
			oper.waitTime(3);
			WebElement initTxt = User.getElement(driver, TaskStarProcess.initTxt);
			String txt1 = initTxt.getText();
			oper.LogOut(txt1);
			isFindinit = User.checkString(StarType.initTxt, txt1);
			WebElement backTxt = User.getElement(driver, TaskStarProcess.rollbackTxt);
			String txt2 = backTxt.getText();
			oper.LogOut(txt2);
			isFindback = User.checkString(StarType.rollback, txt2);
			WebElement time = User.getElement(driver, TaskStarProcess.rollbackTime);
			String txt3 = time.getText();
			oper.LogOut(txt3);
			isFindtime = User.checkString(StarType.backTime, txt3);
			oper.waitTime(5);
		}
		assertTrue(isFindinit && isFindback && isFindtime);
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
}