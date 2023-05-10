package com.auto.tools;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Table {
	private WebElement table;
	
	public Table(WebElement table) {
		setTable(table);
	}
	
	public WebElement getTable() {
		return table;
	}

	public void setTable(WebElement table) {
		this.table = table;
	}


	public int getRowCount() {
		List<WebElement> tableRows = table.findElements(By.tagName("tr"));
		return tableRows.size();
	}
	
	public int getColumnCount() {
		List<WebElement> tableRows = table.findElements(By.tagName("tr"));
		int a = tableRows.get(0).findElements(By.tagName("td")).size();
		return a;
	}
	
	
	public List <WebElement> getDataRows(){
		WebElement tbody = table.findElement(By.tagName("tbody"));
		List<WebElement> trs = tbody.findElements(By.tagName("tr"));
		return trs;
	}
	
	
	
	/*
	 * 查询任务列表中的任务名称的方法
	 */
	public boolean findTaskName(String taskName) {
		boolean isFind = false;
		WebElement tbody = table.findElement(By.tagName("tbody"));
		List<WebElement> trs = tbody.findElements(By.tagName("tr"));
		for(int i = 0;i<trs.size();i++) {
			WebElement tr = trs.get(i);
			List<WebElement>tds = tr.findElements(By.tagName("td"));
		    String text = tds.get(1).getText();
		    //System.out.println(text);
		    if(text.equals(taskName)) {
		    	isFind = true;
		    	break;
		    }
		}
		return isFind;
	}
	
	
	public boolean checkTableName(String tableName) {
		boolean isTable = false;
	    WebElement thead = table.findElement(By.tagName("thead"));
		WebElement tr = thead.findElement(By.tagName("tr"));
		 List<WebElement> ths =tr.findElements(By.tagName("th"));
		   for(WebElement th:ths) {
			   String text = th.getText();
			   //System.out.println("th "+text);
			   if(text.equals(tableName)) {
				   isTable = true; 
				   break;
			   }
		   }
	   return isTable;
	}
	

	 /*
	  *功能：操作表
	  *寻找符合目标的表格，并返回表格单元
	  */
	 
	 public  WebElement searchTableCell(String taskName) {
		 WebElement tableCell = null;
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
			    	break;
			    }
			}
			
		return tableCell;
		 }	 

}
