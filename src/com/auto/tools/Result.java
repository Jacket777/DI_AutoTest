package com.auto.tools;

import org.openqa.selenium.WebElement;

public class Result {
	boolean isFind;
	WebElement element;
	
	public Result(boolean isFind,WebElement element) {
		this.isFind = isFind;
		this.element = element;
	}

}
