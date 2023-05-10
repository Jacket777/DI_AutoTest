package com.data.function;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import com.auto.tools.oper;


public class function {

	
	/*
	 * 登录方法
	 */
	public static void login(ChromeDriver driver) {
		String  portUrl="https://ssosit.cnsuning.com/ids/login?service=http%3A%2F%2Fdatacloudsit.cnsuning.com%2Fbigdata-portal-web%2Fauth%3FtargetUrl%3Dhttp%253A%252F%252Fdatacloudsit.cnsuning.com%252Fbigdata-portal-web%252Fconsole.html&loginTheme=datacloudsit#/portal";
	    String dataIntegrateUrl="http://disit.cnsuning.com/di-web/?authoritySystemId=12558#/taskManagementMain";
		
		
		 driver.get(portUrl);//login the port web
		 WebElement userNameInput = driver.findElement(By.id("username"));
		 WebElement passwordInput=driver.findElement(By.id("password"));
		 WebElement loginButton = driver.findElement(By.className("login_button"));
		 oper.inputText(userNameInput, "14082455");
		 oper.inputText(passwordInput, "14082455");
		 loginButton.click();
		 driver.get(dataIntegrateUrl);//login the data integration web
		 oper.waitTime(5);
	}
	
	
	
	
	
	
	/*
	 * 功能：在任务管理界面上，搜索与店家新建任务span
	 * 参数说明：driver
	 */
	
	public static boolean  checkCreatTask(ChromeDriver driver) {
		  String create="新建任务";
		  boolean isCreate=false;
		 //1.check the create task span and tap it
		   List<WebElement>divs1 = driver.findElements(By.className("pull-right"));
		   for(WebElement div:divs1) {
			   List<WebElement> spans = div.findElements(By.tagName("span")); 
			     for(WebElement span:spans) {
			    	 String text = span.getText();
			    	 //System.out.println("span "+text);
			    	 if(text.equals(create)) {
			    		 isCreate=true;
			    		 span.click();
			    		 break;
			    	 } 	
			     } 
			     if(isCreate) {break;}  
	          }
		   return isCreate;		   
       }
	
	
	/*
	 * 功能：创建任务时，配置基本信息
	 * 参数说明：
	 * 1.taskName：任务名称
	 * 2.taskType：任务类型
	 * 3.taskContent:任务内容 
	 * 4.buttonName:按钮，下一步
	 */
	 public static boolean configBasicInfo(ChromeDriver driver,String taskName,String taskType,String taskContent,String buttonName) {
		  WebElement input = driver.findElement(By.tagName("input")); 
		  WebElement select = driver.findElement(By.tagName("select"));
		  WebElement textarea = driver.findElement(By.tagName("textarea"));
		  List<WebElement> buttons = driver.findElements(By.tagName("button"));
		  //1.input taskName
		  boolean inputName = oper.inputText(input, taskName);
		  if(inputName) {
			  if(select!=null) {
				  //2.select option
				  	 Select select01 = new Select(select);
				  	 select01.selectByVisibleText(taskType);
				  //3.input task description
				  	 boolean inputArea = oper.inputText(textarea, taskContent);
				  	 if(inputArea) {
				  	//4.tap the button
				  	  //oper.waitTime(5);
				  	  boolean tapButton = oper.tapSimpleButton(buttons, buttonName);
				  	  if(tapButton) {
				  		  return true;
				  	  }else {
				  		oper.LogOut("tap button failed"); 
				  	  }	 
				  	 }else {
				  		oper.LogOut("input area failed");
				  		return false;
				  	 } 	 
				   }else {
					   oper.LogOut("select task type failed");
					   return false;
				   }  
		  }else {
			  oper.LogOut("input task name failed");
			  return false;
		  }
		  return false;  
	  }
	 
	 
	 /*
	  * 功能说明:基本信息配置检查
	  * 如果基本配置信息成功，则返回True,否则返回False
	  */
	 
	 public static boolean checkBasicInfo(ChromeDriver driver, TaskInfo taskInfo) {
		 boolean isSuccessful =  false;
		 boolean isTapCreatTask =  function.checkCreatTask(driver);
		 oper.waitTime(3);
		 if(isTapCreatTask) {
			 String taskName = taskInfo.getTaskName();
			 String taskType = taskInfo.getTaskType();
			 String taskContent = taskInfo.getTaskContent();
			 function.configBasicInfo((ChromeDriver) driver,taskName,taskType,taskContent,"下一步");
			 oper.waitTime(5);
			 List<WebElement>divs =  driver.findElements(By.className("panel-heading"));
			 for(int  i = 0; i < divs.size();i++) {
				 WebElement div  = divs.get(i);
				 if(div.getText().equals("数据源&数据目标")) {
					 isSuccessful = true;
					 return isSuccessful;
				 }
			 } 
				 return isSuccessful;
			 	 
		 }else {
			 oper.LogOut("点击创建任务失败，请检查");
			 return isSuccessful;
		  
	 }
	 }
	 
	 
	 
	 /*  功能说明：添加数据源：---添加数据源 i，添加数据目标
	  *  isSource:1. 表示添加数据源  ;2.表示添加目标数据
	  *  dataName: 选择的数据源名称
	  *  table:选择的表名
	  *  id：弹出框的id
	  */
	 public static boolean addData(ChromeDriver driver, Data data,boolean isSource) {
		 String id = data.getDivId();
		 String dataName = data.getDatabaseName();
		 String table = data.getTableName();
		 boolean isAddSuccess = false;
		 //操作弹出框 
		 List<WebElement>selects= driver.findElements(By.tagName("select"));
	//   //1.选择数据源名称
	     boolean selectDataName = oper.selectOperation(selects,dataName,"number:9");
	     if(selectDataName) {
	       oper.LogOut("it select dataname"+dataName);
		   //2.选择数据源表
		   boolean selectTable = oper.selectOperation(selects,table,"number:90");
		   if(selectTable) {
			   oper.LogOut("it select tablename "+table);
			   oper.waitTime(5);
			   WebElement div = driver.findElement(By.id(id));
			   //3.判断是否是添加源数据
			   if(isSource) {
				   boolean isTapButton =oper.tapButton(div, "›");
				   if(isTapButton) {
					   oper.waitTime(5);
					   //4.选择确定按钮
					   oper.drawToBottom(driver);
					   boolean isTapConfirm = oper.tapButton(div, "确定");
					   if(isTapConfirm) {
						   isAddSuccess = true;
						   return isAddSuccess;
					   }else {
						   oper.LogOut("confirme button is not found");
						   return isAddSuccess;
					   }
				   } else {
					   oper.LogOut("add button is not found");
					   return isAddSuccess;
				   }
				   
			   }else if(!isSource) {
				   //4.选择确定按钮
				   boolean isTapConfirm = oper.tapButton(div, "确定");
				   if(isTapConfirm) {
					   isAddSuccess = true;
					   return isAddSuccess;
				   }else {
					   oper.LogOut("confirme button is not found");
					   return isAddSuccess;
				   }  
			   }else {
				   oper.LogOut("it have no isSource parameter,please check it");
				   return isAddSuccess;
			   }
		   }else {
			   oper.LogOut("table name  is not found");
			   return isAddSuccess;
		   }
	   }else {
		   oper.LogOut("data name is not found");
		   return isAddSuccess;
	   }
	 }
	 
	 
	/*
	 * 功能：检查数据链路配置是否成功
	 * 
	 */
	 
	 public static boolean checkDataLink(ChromeDriver driver,TaskInfo taskInfo,Data sourceData, Data objectData) {
		 boolean isSuccess =  false;
		 boolean isBasicInfo = function.checkBasicInfo(driver,taskInfo);
		 oper.waitTime(5);
		 if(isBasicInfo) {
			 boolean isAddSource = false;
			 boolean isAddObject = false;
			 boolean isConfig = false;
			 //1.添加数据源
			 boolean isTapSource = oper.tapAddDataButton( driver,"数据源");
			 oper.waitTime(5);
			 if(isTapSource) {
			   //1.添加数据源
			   isAddSource = function.addData( driver,sourceData,true);
			   oper.waitTime(5);
			 }
			 
			 //2.添加数据目标
			 boolean isTapObject = oper.tapAddDataButton(driver,"数据目标");
			 oper.waitTime(5);
			 if(isTapObject) {
				  isAddObject = function.addData(driver,objectData,false);
				  oper.waitTime(3);
				  }
			
		   //3.数据源与数据目标添加成功后，则配置同步字段
		   if(isAddSource&&isAddObject) {
			   List<WebElement>buttons = driver.findElements(By.tagName("button"));
			   oper.tapSimpleButton(buttons, "配置同步字段");
			   oper.waitTime(3);
			   //点击自动关联
			   WebElement confDiv =  driver.findElement(By.id("configureField"));
			   boolean isTap = oper.tapButton(confDiv, "自动关联" );
			   if(isTap) {
				   oper.LogOut("XXXXXXXXXXXXXXXX");
			   }
			   oper.waitTime(3);
			   oper.drawToBottom(driver);
			   //点击确定
			   isConfig = oper.tapButton(confDiv,"确定");
		   }
			
		  //4.配置完成后，点击下 一步，检查页面是否正确
		   oper.waitTime(5);
		   if(isConfig) {
			   //添加数据目标成功，点击下一步
			List<WebElement>buttons1 = driver.findElements(By.className("btn-primary"));
			oper.drawToBottom(driver);
			oper.waitTime(5);
			oper.tapSimpleButton(buttons1, "下一步");
			oper.LogOut("tap it");
			oper.waitTime(5);
			List<WebElement>divs = driver.findElements(By.className("panel-heading"));
			for(int i = 0; i < divs.size();i++) {
				WebElement div = divs.get(i);
				if(div.getText().equals("数据预处理")) {
					isSuccess = true;
					break;
				}
			}   
		  } 
		   
		  
		  //5.debug
		   if(!isAddSource) {
			   oper.LogOut("添加数据源失败");
			   }else if(!isAddObject) {
				   oper.LogOut("添加数据目标失败");
				   }else if(!isConfig) {
					   oper.LogOut("配置同步字段失败");
					   }
			}else{
					oper.LogOut("基本信息配置失败");
				}
	
		return isSuccess; 	 
	 }
	
	 
	 
	 /*
	  * 功能：检查任务名称是否存在，任务状态是否为就绪
	  * 参数说明：
	  * 1.driver：对象
	  * 2.taskName :任务名称
	  */
	 
	 public static boolean checkTask(ChromeDriver driver,String taskName) {
		 boolean isfind = false;
		 WebElement table = driver.findElement(By.tagName("table"));
			WebElement tbody = table.findElement(By.tagName("tbody"));
			List<WebElement> trs = tbody.findElements(By.tagName("tr"));
			for(int i = 0;i<trs.size();i++) {
				WebElement tr = trs.get(i);
				List<WebElement>tds = tr.findElements(By.tagName("td"));
			    String findTask = tds.get(1).getText();
			    String findStat = tds.get(6).getText();
			    System.out.println(findTask);
			    System.out.println(findStat);
			    if(findTask.equals(taskName)&&findStat.equals("就绪")) {
			    	isfind = true; 	
			    	return isfind;
			    }
			}
			if(!isfind) {
				 oper.LogOut("任务名称没找到 或任务不处于就绪状态");	
			}
		 return isfind;
	 }
	 
	 
	 
	

	 
}	
	

