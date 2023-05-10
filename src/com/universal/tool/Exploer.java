package com.universal.tool;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.*;
public class Exploer {
	public static void scollToBottomofPag(ChromeDriver driver) {
	      ((JavascriptExecutor)driver).executeScript(
	    		  "window.scrollTo(0,document.body.scrollHeight)");
	}
}
