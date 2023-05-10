package smoke.platform.action;



import org.openqa.selenium.chrome.ChromeDriver;

import com.universal.tool.oper;
import smoke.basic.tools.User;
import smoke.data.config.Account;
import smoke.platform.ui.AlarmPage;
import smoke.platform.ui.homePage;
import smoke.platform.ui.loginPage;


public class EnterPage {
	//0.
	public static void login(ChromeDriver driver) {
 		driver.manage().window().maximize();
 		driver.get(Account.portURL);//login the port web
 		User.inputText(driver, loginPage.username, Account.username);
 		User.inputText(driver, loginPage.password, Account.password);
 		User.tapButton(driver, loginPage.loginBut);
 		driver.get(Account.userURL);//login the data integration web
 		oper.waitTime(5);
 	}
	
	

	//=====1.进入概览页面======
	public static void overview(ChromeDriver driver) {
		}

    //==============2.进入任务管理页面=======================
	 public static void taskManage(ChromeDriver driver) {
		   User.tapButton(driver, homePage.taskManage);}
	
	
//================3.告警管理===============================================
	//进入告警策越页面
 public static void alarmConfig(ChromeDriver driver) {
    	//点击告警管理
    	User.tapButton(driver, homePage.alarmManage);
    	//点击告警策越
    	User.tapButton(driver, AlarmPage.alarmConfig); }
    
    
   //进入告警任务页面
 public static void alarmTask(ChromeDriver driver) {
	 //点击告警管理
   	   User.tapButton(driver, homePage.alarmManage);
 	  //点击告警任务
   	  User.tapButton(driver, AlarmPage.alarmTask); }



//========================4.系统管理========================================
public static void systemManager(ChromeDriver driver) {
	//点击系统管理菜单
	User.tapButton(driver, homePage.sysManage);
	
}
}

