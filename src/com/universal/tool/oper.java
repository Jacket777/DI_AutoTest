package com.universal.tool;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class oper{

	//1.等待时间
	public static void waitTime(int seconds) {
			  try {Thread.sleep(1000*seconds);} 
					catch (InterruptedException e) {
						e.printStackTrace();}  
		 }
	
	
	//2.打印日志
	public static String LogOut(String log) {
		if(log==null||log.equals("")) {
			System.out.println("log日志没有参数");
			return null;
		}else {
			System.out.println(log);
			return log;
		}
	}
		 
		 
	 //3.操作下拉框
	/*
	 * 
	 * 
	 * 
	 */
	 public static boolean selectOperation( List<WebElement>selects,String check,String value) {
			   boolean isFind = false;
			   //选择数据源名称
			   if(selects!=null) {
				   //System.out.println("find selects");
				   for(int i = 0; i<selects.size();i++) {
					   WebElement element = selects.get(i);
					   if(element!=null) {
						   //System.out.println("find the select");
						   Select select = new Select(element);
						   List<WebElement> options = select.getOptions();
						   for(int j = 0;j<options.size();j++) {
							   WebElement option = options.get(j);
							   //System.out.println(option.getText());
							   if(option.getText().equals(check)) {
								   isFind = true;
								   //System.out.println("检查到了     "+check);
								   select.selectByVisibleText(check);
								   //select.select(value); 
								   //System.out.println("选择了     "+value);
								   break;
							   }   
						   }	   
					   }
					 if(isFind) {break;}
				   }
			   }
			   if(isFind) {
				   return true;
			   }else {
				   System.out.println("it not find the select");
				   return false;
			   } 
		 }
	 
	 
	 //4.简单点击按钮
	 public static boolean tapSimpleButton(List<WebElement>buttons,String buttonName) {
		 boolean isTap = false;
		 if(buttonName==null||buttonName.equals("")) {
			 LogOut("inputName is empty or you forget input buttonName");
			 return false;
		 }
		 if(buttons==null) {
			 LogOut("the buttons is null or your forget input buttons");
			 return false;
		 }
		 if(buttons!=null) {
			 for(int i = 0; i < buttons.size();i++) {
				 WebElement button = buttons.get(i);
				 if(button!=null&&button.getText().equals(buttonName)) {
					 button.click();
					 isTap = true;
					 break; 
				 }
			 } 
			 if(!isTap) {
				 LogOut("button is null or button name is wrong");
			 }
		 }
		return isTap;  
	 }
	 
	 
	 
	 
	 //5.复杂点击按钮
	 //用于复杂页面中，button难以定位与button点击
	 public static boolean tapButton(WebElement div,String buttonName) {
		 boolean isClick = false;
		if(buttonName==null||buttonName.equals("")) {
				LogOut("Please input the button name");
				return false;}
		if(div==null) {
				  LogOut("component can't found");
				  return false;}
		if(div!=null) {
			try {
				  List<WebElement>Buttons = div.findElements(By.tagName("button"));
				  for(int i = 0 ;i <Buttons.size();i++) {
					  WebElement Button = Buttons.get(i);
					  if(Button!=null&&(Button.getText()!=null)&&(!Button.getText().equals(""))){
						  if(Button.getText().equals(buttonName)) {
							  Button.click();
							  isClick = true;
							  break;
						  } 
					  }
					  if(Button!=null&&(Button.getText()==null||Button.getText().equals(""))){
						  //如果按钮中没有文本则往下查找span
						  List <WebElement>  spans = Button.findElements(By.tagName("span"));
						   if(spans!=null&&spans.size()!=0) {
						   for(int j=0;j<spans.size();j++) {
							   WebElement span = spans.get(j);
							   if(span!=null&&span.getText().equals("›")) {
									   //System.out.println("before tap button");
									   isClick=true;
									   Button.click();
									   //System.out.println("after the tap button");
									   break;
								   } 
					          }  
					  }else {
						  LogOut("button's span not found");
					  }
					 }   
	        		  if(isClick) { break; }	 
				  }
					  }catch(StaleElementReferenceException e) {
					  e.printStackTrace();
					  LogOut("element not found!");
				  }finally{
					 LogOut("tap button task finished");
				  }		  
			  }
		return isClick;
		 } 
	 
	 
	 
	 
	//6.特殊按钮点击：添加数据源，数据目标按钮点击
	 public static boolean tapAddDataButton(ChromeDriver driver,String dataName) {
		 boolean isTap = false;
		 //1.find the div
		 List<WebElement> divs = driver.findElements(By.className("col-md-6"));
		 if(divs==null) {
			 LogOut("WebElement is null,Please check the element!");
			 return false;
		 }
		 if(dataName==null||dataName.equals("")) {
			 LogOut("The dataName is null,Please check it");
			 return false;
		 }
		 for(int i = 0; i <divs.size(); i++){
			 WebElement div = divs.get(i);
			  if(div!=null) {  
			   List<WebElement> labels = div.findElements(By.tagName("label"));
			   for(WebElement label:labels) {
			   if(label.getText().contains(dataName)) {
				   //System.out.println("find it ");
				   WebElement div01 = div.findElement(By.className("system-box"));
				   WebElement div02 = div01.findElement(By.tagName("div"));
				   List<WebElement> as = div02.findElements(By.tagName("a")); 
				    for(WebElement a:as) {
				    	//System.out.println("find it");
				    	isTap = true;
				    	a.click();
				    	return isTap;
				    }
			      } 
			   } 
			if(isTap) { return isTap;}	 
	     }
		 }
	 return isTap; 
	}  
	 
	
	 //7.输入框输入，判断，与返回
	 public static boolean inputText(WebElement component,String inputString) {
		 if(component==null) {
			 LogOut("WebElement is null,Please check the element!");
			 return false;
		 }
		 if(inputString==null||inputString.equals("")) {
			 LogOut("The dataName is null,Please check it");
			 return false;
		 }else {
			 component.sendKeys(inputString);
			 return true;
		 }
	 }
	 
	 
	
	 /*
	  *功能：操作表
	  *寻找符合目标的表格，并返回表格单元
	  */
	 
	 public static WebElement searchTableCell(ChromeDriver driver,String taskName) {
		 WebElement tableCell = null;
		 WebElement table = driver.findElement(By.tagName("table"));
			WebElement tbody = table.findElement(By.tagName("tbody"));
			List<WebElement> trs = tbody.findElements(By.tagName("tr"));
			for(int i = 0;i<trs.size();i++) {
				WebElement tr = trs.get(i);
				List<WebElement>tds = tr.findElements(By.tagName("td"));
			    String text = tds.get(1).getText();
			    System.out.println(text);
			    if(text.equals(taskName)) {
			    	WebElement td = tds.get(tds.size()-1);
			    	tableCell = td;
			    	return tableCell;
			    }
			}
			if(tableCell==null) {
				 oper.LogOut("任务名称没找到！");	
				 return tableCell;
			}
			return tableCell;
		 }	 
	 }		