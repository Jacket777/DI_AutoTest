package com.smoke.test01;

import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import static org.testng.Assert.assertTrue;
import com.auto.tools.oper;
import com.data.function.Data;
import com.data.function.TaskInfo;
import com.data.function.function;

/*
 * 用例说明：创建任务时检查数据链路配置测试用例
 */
public class MY01102 {
  public static ChromeDriver driver;

  @BeforeMethod
  public void beforeMethod() {
		driver= oper.getChromeDriver();
	    function.login(driver);
	    oper.waitTime(8);
  }
 
 @Test
  public void testDataLink()throws StaleElementReferenceException {
	 boolean isSuccess =  false;
	 TaskInfo taskInfo = new TaskInfo("AAA","Mysql(binlog) → Hive","aaaa");
	 boolean isBasicInfo = function.checkBasicInfo( driver,taskInfo);
	 oper.waitTime(5);
	 if(isBasicInfo) {
		 boolean isAddSource = false;
		 boolean isAddObject = false;
		 boolean isConfig = false;
		 //1.添加数据源
		 boolean isTapSource = oper.tapAddDataButton( driver,"数据源");
		 Data sourceData = new Data("selectDataSourceMysql","disit_test","test_data1");
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
			   //添加数据目
			   Data objectData = new Data("selectDataTargetHive","test","disit_test");
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
	 assertTrue(isSuccess);
   }
   
  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }
}
