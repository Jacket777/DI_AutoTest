package com.special.tool;

import java.util.List;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import com.universal.tool.oper;

public class User {
	public static String portUrl = "https://ssosit.cnsuning.com/ids/login?service=http%3A%2F%2Fdatacloudsit.cnsuning.com%2Fbigdata-portal-web%2Fauth%3FtargetUrl%3Dhttp%253A%252F%252Fdatacloudsit.cnsuning.com%252Fbigdata-portal-web%252Fconsole.html&loginTheme=datacloudsit#/portal";
	public static String dataIntegrateUrl = "http://disit.cnsuning.com/di-web/?authoritySystemId=12558#/taskManagementMain";


	public static void configExplore() {
		System.setProperty("webdriver.chrome.driver", "F:\\chromedriver.exe");
	}

	public static WebElement getElement(ChromeDriver driver, String location) {
		WebElement element = driver.findElementByXPath(location);
		return element;
	}

	public static void login(ChromeDriver driver) {
		driver.manage().window().maximize();
		driver.get(portUrl);// login the port web
		WebElement userNameInput = driver.findElement(By.id("username"));
		WebElement passwordInput = driver.findElement(By.id("password"));
		WebElement loginButton = driver.findElement(By.className("login_button"));
		oper.inputText(userNameInput, "14082455");
		oper.inputText(passwordInput, "14082455");
		loginButton.click();
		driver.get(dataIntegrateUrl);// login the data integration web
		oper.waitTime(5);
	}

	public static void selectOption(WebElement element, String option) {
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		for (int j = 0; j < options.size(); j++) {
			WebElement optionA = options.get(j);
			System.out.println(optionA.getText());
		}
		select.selectByVisibleText(option);
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

	public static void tapButton(ChromeDriver driver, String location) {
		WebElement element = getElement(driver, location);
		element.click();
		oper.waitTime(2);
	}
}
