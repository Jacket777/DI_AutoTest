package com.smoke.test01;

import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.auto.tools.oper;
import com.auto.tools.Table;
import com.data.function.function;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import static org.testng.Assert.assertTrue;


/*
 * 用例说明：通过数据源类型选择任务，检查该功能是否正常
 */


public class MY009 {
  public static ChromeDriver driver;

 @BeforeMethod
 public void beforeMethod() {
   driver= oper.getChromeDriver();
   function.login(driver);
   oper.waitTime(8);
 }
 
 @Test
  public void testTaskPage() {
	 boolean result = true;
	 //1.define source selector
	 List<WebElement> selects = driver.findElements(By.tagName("select"));
	 Select select01 = new Select((selects.get(0)));
	 Select select02 = new Select((selects.get(1)));
	 Select selectSource = null;
	 boolean isSelectSource = oper.confirmSelect(select01,"mysql");
	 if(isSelectSource) {
		 selectSource =  select01;
	 }else {
		 selectSource = select02;
	 }
	 
	 //下拉框选择mysql
	 selectSource.selectByVisibleText("mysql");
	 //点击搜索按钮
	 List<WebElement> buttons=  driver.findElements(By.tagName("button"));
	 boolean isTap = oper.tapSimpleButton(buttons, "搜索");
	 if(isTap) {
		//检查表格中是否含有未选择的文本
		 WebElement table = driver.findElement(By.tagName("table"));
		 Table newTable = new Table(table);
		 List<WebElement> trs = newTable.getDataRows();
		   for(WebElement tr:trs) {
			   WebElement td = tr.findElement(By.xpath("td[3]"));
			   System.out.println("源类型： "+td.getText());
			   if(td.getText().equals("kafka")) {
				   result = false;
				   break;
			   }
		   } 
	 }
	 System.out.println("the result is "+result);
	 assertTrue(result);
  }
 
  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }
}
