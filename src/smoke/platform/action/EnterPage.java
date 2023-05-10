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
	
	

	//=====1.�������ҳ��======
	public static void overview(ChromeDriver driver) {
		}

    //==============2.�����������ҳ��=======================
	 public static void taskManage(ChromeDriver driver) {
		   User.tapButton(driver, homePage.taskManage);}
	
	
//================3.�澯����===============================================
	//����澯��Խҳ��
 public static void alarmConfig(ChromeDriver driver) {
    	//����澯����
    	User.tapButton(driver, homePage.alarmManage);
    	//����澯��Խ
    	User.tapButton(driver, AlarmPage.alarmConfig); }
    
    
   //����澯����ҳ��
 public static void alarmTask(ChromeDriver driver) {
	 //����澯����
   	   User.tapButton(driver, homePage.alarmManage);
 	  //����澯����
   	  User.tapButton(driver, AlarmPage.alarmTask); }



//========================4.ϵͳ����========================================
public static void systemManager(ChromeDriver driver) {
	//���ϵͳ����˵�
	User.tapButton(driver, homePage.sysManage);
	
}
}

