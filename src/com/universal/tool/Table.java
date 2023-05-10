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

	//��ȡ����ж�����
	public int getRowCount() {
		 WebElement tbody = table.findElement(By.tagName("tbody"));
		List<WebElement> trs = tbody.findElements(By.tagName("tr"));
		return trs.size();
	}

   //��ȡ����ж�����,ͨ����ȡ��ͷ����ȡ
	public int getColumnCount() {
		WebElement thead = table.findElement(By.tagName("thead"));
		List<WebElement>ths = thead.findElements(By.tagName("th"));
//		for(int i = 0; i < ths.size(); i++) {
//			WebElement th = ths.get(i);
//			System.out.println(th.getText()+"========1==========");
//		}
		return ths.size();
	}
	
	
	//��ȡ�����ĳ��ĳ�еĵ�Ԫ�����
	public WebElement getCell(int rowNo,int colNo)throws NoSuchElementException{
		try {
			WebElement tbody = table.findElement(By.tagName("tbody"));
			List<WebElement>tableRow = tbody.findElements(By.tagName("tr"));
			//System.out.println("������ "+tableRow.size());
			//System.out.println("�к� "+rowNo);
			WebElement currentRow = tableRow.get(rowNo-1);
			List<WebElement>tablecols = currentRow.findElements(By.tagName("td"));
			//System.out.println("������ "+tablecols.size());
			WebElement cell = tablecols.get(colNo-1);
			//System.out.println("�к� "+colNo);
			return cell;
		} catch (NoSuchElementException e) {
			throw new NoSuchElementException("û���ҵ����Ԫ��");	
		}	
	}
	
	
	//��ȡ��Ԫ���е�Ԫ��  byΪ��λ��ʽ
	public WebElement getWebElementInCell(int rowNo,int colNo,By by)throws NoSuchElementException{
		try {
			List<WebElement>tableRow = table.findElements(By.tagName("tr"));
			//System.out.println("������ "+tableRow.size());
			//System.out.println("�к� "+rowNo);
			WebElement currentRow = tableRow.get(rowNo-1);
			List<WebElement>tablecols = currentRow.findElements(By.tagName("td"));
			//System.out.println("������ "+tablecols.size());
			WebElement cell = tablecols.get(colNo-1);
			//System.out.println("�к� "+colNo);
			return cell.findElement(by);
		} catch (NoSuchElementException e) {
			throw new NoSuchElementException("û���ҵ����Ԫ��");	
		}	
	}
	
	
	
   //���ݱ����ֶν��м�飬�������ڵ��У��Ҳ����򷵻�-1
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
	

  //�������еĸ�ѡ��
	public  void clickCheckBox(ChromeDriver driver,String tableId, int row, int col) {
	 String xpath = tableId+"/tbody/tr["+row+"]"+"/td["+col+"]"+"/input[@type='checkbox']";
      WebElement web =  driver.findElementByXPath(xpath);
      web.click();
	}
	
   //�������е��ı����ı���a ���
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
	
	
	//��������б��в����ı�
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

