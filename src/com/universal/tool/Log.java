package com.universal.tool;

public class Log {
	//��ӡ������Ϣ
	public static void info(String info) {
		if(info==null||info.equals("")) {
			System.out.println("log��־û�в���");
		}else {
			System.out.println("====="+info+"===");	
		}	
	}
	
	//��ӡ�����Ϣ
	public static void value(String value) {
		if(value==null||value.equals("")) {
			System.out.println("ֵΪ�ջ��߲�����");
		}else {
			System.out.println("====="+value+"===");	
		}
	}
}