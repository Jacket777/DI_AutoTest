package com.universal.tool;

public class Log {
	//打印步骤信息
	public static void info(String info) {
		if(info==null||info.equals("")) {
			System.out.println("log日志没有参数");
		}else {
			System.out.println("====="+info+"===");	
		}	
	}
	
	//打印检测信息
	public static void value(String value) {
		if(value==null||value.equals("")) {
			System.out.println("值为空或者不存在");
		}else {
			System.out.println("====="+value+"===");	
		}
	}
}