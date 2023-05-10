package com.universal.tool;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class Table {
	private WebElement table;
	
	public Table(WebElement table) { 
		setTable(table);}
	
	public WebElement getTable() {
		return table;}

	public void setTable(WebElement table) { 
		this.table = table;}

	//获取表格中多少行
	public int getRowCount() {
		 WebElement tbody = table.findElement(By.tagName("tbody"));
		List<WebElement> trs = tbody.findElements(By.tagName("tr"));
		return trs.size();
	}

   //获取表格中多少列,通过获取表头来获取
	public int getColumnCount() {
		WebElement thead = table.findElement(By.tagName("thead"));
		List<WebElement>ths = thead.findElements(By.tagName("th"));
//		for(int i = 0; i < ths.size(); i++) {
//			WebElement th = ths.get(i);
//			System.out.println(th.getText()+"========1==========");
//		}
		return ths.size();
	}
	
	
	//获取表格中某行某列的单元格对象
	public WebElement getCell(int rowNo,int colNo)throws NoSuchElementException{
		try {
			WebElement tbody = table.findElement(By.tagName("tbody"));
			List<WebElement>tableRow = tbody.findElements(By.tagName("tr"));
			//System.out.println("总行数 "+tableRow.size());
			//System.out.println("行号 "+rowNo);
			WebElement currentRow = tableRow.get(rowNo-1);
			List<WebElement>tablecols = currentRow.findElements(By.tagName("td"));
			//System.out.println("总列数 "+tablecols.size());
			WebElement cell = tablecols.get(colNo-1);
			//System.out.println("列号 "+colNo);
			return cell;
		} catch (NoSuchElementException e) {
			throw new NoSuchElementException("没有找到相关元素");	
		}	
	}
	
	
	//获取单元格中的元素  by为定位方式
	public WebElement getWebElementInCell(int rowNo,int colNo,By by)throws NoSuchElementException{
		try {
			List<WebElement>tableRow = table.findElements(By.tagName("tr"));
			//System.out.println("总行数 "+tableRow.size());
			//System.out.println("行号 "+rowNo);
			WebElement currentRow = tableRow.get(rowNo-1);
			List<WebElement>tablecols = currentRow.findElements(By.tagName("td"));
			//System.out.println("总列数 "+tablecols.size());
			WebElement cell = tablecols.get(colNo-1);
			//System.out.println("列号 "+colNo);
			return cell.findElement(by);
		} catch (NoSuchElementException e) {
			throw new NoSuchElementException("没有找到相关元素");	
		}	
	}
	
	
	
   //根据表格的字段进行检查，返回所在的行，找不到则返回-1
	public int getRowNo(String field,int td,int rowCount,Table table) {
		int result = -1;
		 for(int i = 1; i <= rowCount; i++) {
		    WebElement element = table.getCell(i, td);
		    System.out.println(element.getText());
			 if(element.getText().equals(field)) {
				 result = i;
				 System.out.println("find it");
				 break;
			 }
		 }
		 return result;
	}
	

  //点击表格中的复选框
	public  void clickCheckBox(ChromeDriver driver,String tableId, int row, int col) {
	 String xpath = tableId+"/tbody/tr["+row+"]"+"/td["+col+"]"+"/input[@type='checkbox']";
      WebElement web =  driver.findElementByXPath(xpath);
      web.click();
	}
	
   //点击表格中的文本，文本以a 标记
	public  void tapText(String text,int row, int col,Table tab,ChromeDriver driver) {
		WebElement td = tab.getCell(row, col);
		List< WebElement> alist = td.findElements(By.tagName("a"));
		for(int i = 0; i < alist.size();i++) {
			System.out.println(alist.get(i).getText());
			if(alist.get(i).getText().equals(text)) {
				WebElement a = alist.get(i);
				Exploer.scollToBottomofPag(driver);
				a.click();
				break;
			}
		}
	}
	
	
	//点击任务列表中操作文本
	public void tapOPText(String text,int row, int col,Table tab,ChromeDriver driver) {
		WebElement td = tab.getCell(row, col);
		List< WebElement> alist = td.findElements(By.tagName("a"));
		for(int i = 0; i < alist.size();i++) {
			System.out.println(alist.get(i).getText());
			if(alist.get(i).getText().equals(text)) {
				WebElement a = alist.get(i);
				//Exploer.scollToBottomofPag(driver);
				a.click();
				break;
			}
			oper.waitTime(3);
		}
		
		
		
		
		
	}
	
	
	
	
	
	
}

