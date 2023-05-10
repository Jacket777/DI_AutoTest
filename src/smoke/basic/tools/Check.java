package smoke.basic.tools;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import com.universal.tool.Table;


public class Check {
 	public static boolean checkInTab(ChromeDriver driver,String location,String expected,int col) {
 		boolean result = false;
 		WebElement element = User.getElement(driver, location);
 	    Table tab = new Table(element);
 	    int rowNo = tab.getRowCount();
 	    int res = tab.getRowNo(expected, 2, rowNo, tab);
 	    if(res!=-1) {
 	    	result = true;
 	    }
        return result;
      }	
}