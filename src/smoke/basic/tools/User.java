package smoke.basic.tools;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.universal.tool.Table;
import com.universal.tool.oper;
import smoke.platform.ui.loginPage;
import smoke.data.config.Account;

public class User {

	public static void configExplore() {
		System.setProperty("webdriver.chrome.driver", "E:/chromedriver.exe");
	}

	public static WebElement getElement(ChromeDriver driver, String location) {
		WebElement element = driver.findElementByXPath(location);
		return element;
	}

	public static void tapButton(ChromeDriver driver, String location) {
		WebElement element = getElement(driver, location);
		element.click();
		oper.waitTime(2);
	}

	public static void inputText(ChromeDriver driver, String location, String text) {
		WebElement element = getElement(driver, location);
		element.clear();
		element.sendKeys(text);
		oper.waitTime(3);
	}

	public static void selectOP(ChromeDriver driver, String location, String option) {
		WebElement element = getElement(driver, location);
		selectOption(element, option);
		oper.waitTime(3);
	}

	public static WebElement getElementByName(ChromeDriver driver, String name) {
		WebElement element = driver.findElement(By.name(name));
		return element;

	}

	public static void inputByName(ChromeDriver driver, String name, String inpuText) {
		WebElement element = getElementByName(driver, name);
		if (element != null) {
			element.clear();
			element.sendKeys(inpuText);
		} else {
			oper.LogOut("�����ȡʧ�ܣ�����");
		}
		oper.waitTime(2);
	}

	public static void login(ChromeDriver driver) {
		driver.manage().window().maximize();
		driver.get(Account.portURL);// login the port web
		inputText(driver, loginPage.username, Account.username);
		inputText(driver, loginPage.password, Account.password);
		tapButton(driver, loginPage.loginBut);
		driver.get(Account.userURL);// login the data integration web
		oper.waitTime(5);
	}

	public static void selectOption(WebElement element, String option) {
		Select select = new Select(element);
		select.selectByVisibleText(option);

	}

	public static Table getTab(ChromeDriver driver, String location) {
		WebElement element = getElement(driver, location);
		if (element != null) {
			Table table = new Table(element);
			return table;
		} else {
			oper.LogOut("��ȡ������ʧ�ܣ����������λ��");
			return null;
		}
	}

	public static Select getSelect(ChromeDriver driver, String location) {
		WebElement element = getElement(driver, location);
		if (element != null) {
			Select select = new Select(element);
			return select;
		} else {
			return null;
		}

	}

	public static void chooseOption(ChromeDriver driver, String location, String option) {
		WebElement element = getElement(driver, location);
		if (element != null) {
			selectOption(element, option);
		} else {
			oper.LogOut("��ȡ������ʧ�ܣ����������λ��");
		}
		oper.waitTime(5);
	}

	public static boolean checkDate(String begin, String end, String time) {
		boolean result = false;
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		try {
			Date beginTime = df.parse(begin);
			Date endTime = df.parse(end);
			Date realTime = df.parse(time);
			if ((realTime.getTime() > beginTime.getTime()) && (realTime.getTime() < endTime.getTime())) {
				result = true;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static boolean checkString(String expect, String real) {
		boolean result = false;
		if (expect.equals(real)) {
			result = true;
		}
		return result;
	}
}