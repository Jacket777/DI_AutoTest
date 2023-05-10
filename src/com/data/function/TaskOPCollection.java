package com.data.function;

import java.util.List;

import org.apache.commons.logging.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.auto.tools.oper;

public class TaskOPCollection {

	public TaskOPCollection() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	//1.对任务进行操作
	public static boolean operTask(WebElement tableCell,String oper) {
		 boolean isSuccess = false;
		 if(tableCell!=null) {
			 List<WebElement> as = tableCell.findElements(By.tagName("a"));
			 for(int i = 0; i <as.size();i++) {
				 WebElement a = as.get(i);
				 if(a.getText().equals(oper)) {
					 a.click();
					 isSuccess = true;
				 } 
	        } 
		 }
		 return isSuccess;	 
     }
	
	
	//2.数据预处理页面处理,初始化操作
	public static void initTask(ChromeDriver driver) {
		WebElement div = driver.findElementById("startModal");
		//是按钮
		List<WebElement> buttons = div.findElements(By.className("btn-primary"));
		for(int i =0; i < buttons.size();i++) {
			oper.LogOut(buttons.get(i).getText());
		}
        buttons.get(0).click();
	}
	
	
	//操作后对操作项进行检查
	public static boolean checkOperations(WebElement tableCell,String operation) {
		boolean isRight = false;
		boolean stop = false;
    	boolean star = false;
    	boolean edit = false;
    	boolean del = false;
    	boolean detail = false;
  
	    if(tableCell!=null) {
	    	List<WebElement> as = tableCell.findElements(By.tagName("a"));
	    	 for(int i = 0; i <as.size();i++) {
	    		 String text = as.get(i).getText();
	    		 if(operation.equals("启动")) {
	    			 if(text.equals("停止")) {
						 stop = true;
					 }else if(text.equals("详情")) {
							 detail = false;
						 }
				    if(stop&&detail) {
				    	isRight = true;
				    	return isRight;
				    }	 
	    		 }
	    		 
	    		 if(operation.equals("停止")) {
	    			 if(text.equals("启动")) {
	    				 star = true;
	    			 }else if(text.equals("编辑")) {
	    				 edit = true;
	    			 }else if(text.equals("删除")) {
	    				 del = true;
	    			 }else if(text.equals("详情")) {
	    				 detail = true;
	    			 }
	    			 
	    			 if(star&&edit&&del&&detail) {
	    				 isRight =true;
	    			 }	 
	    		 }	 
	    	 }
		}
	   return isRight;
	}
}
