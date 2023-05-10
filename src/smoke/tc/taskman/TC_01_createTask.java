package smoke.tc.taskman;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import static org.testng.Assert.assertTrue;
import com.universal.tool.oper;
import com.universal.tool.Table;
import com.universal.tool.Exploer;
import smoke.basic.tools.User;
import smoke.data.config.Task;
import smoke.platform.ui.TaskHome;
import smoke.platform.ui.TaskBasic;
import smoke.platform.ui.PreProceed;
import smoke.platform.ui.SourceData;
import smoke.platform.ui.TargetData;
import smoke.platform.ui.FieldConfig;
import smoke.platform.ui.TaskDataLink;
import smoke.platform.action.EnterPage;

public class TC_01_createTask {
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
		User.tapButton(driver, TaskHome.createTask);
		User.inputText(driver, TaskBasic.nameInput, Task.name);
		User.selectOP(driver, TaskBasic.typeSel, Task.type);
		User.inputText(driver, TaskBasic.descript, Task.descript);
		User.tapButton(driver, TaskBasic.next);
		User.tapButton(driver, TaskDataLink.addSourBut);
		User.selectOP(driver, SourceData.SelDB, Task.sourDB);
		User.selectOP(driver, SourceData.SelTab, Task.sourTab);
		User.tapButton(driver, SourceData.addTabBut);
		oper.waitTime(10);
		Exploer.scollToBottomofPag(driver);
		User.tapButton(driver, SourceData.confirmBut);
		User.tapButton(driver, TaskDataLink.addObjectBut);
		User.selectOP(driver, TargetData.SelDB, Task.lastDB);
		oper.waitTime(5);
		User.selectOP(driver, TargetData.SelTab, Task.lastTab);
		User.tapButton(driver, TargetData.confirmBut);
		User.tapButton(driver, TaskDataLink.configBut);
		User.selectOP(driver, FieldConfig.idSelect, "disit_id");
		User.tapButton(driver, FieldConfig.know);
		User.selectOP(driver, FieldConfig.nameSelect, "disit_name");
		User.selectOP(driver, FieldConfig.timeSelect, "create_time");
		User.tapButton(driver, FieldConfig.confirmBut);
		WebElement button = driver.findElementByXPath(TaskDataLink.nextBut);
		if (button.isDisplayed()) {
			button.click();
		} else {
			Exploer.scollToBottomofPag(driver);
			button.click();
		}
		User.tapButton(driver, PreProceed.confirmBut);
		Table tab = new Table(User.getElement(driver, TaskHome.tab));
		int row = tab.getRowCount();
		int rowNo = tab.getRowNo(Task.name, 2, row, tab);
		if (rowNo != -1) {
			isFind = true;
		}
		oper.waitTime(5);
		assertTrue(isFind);
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
}