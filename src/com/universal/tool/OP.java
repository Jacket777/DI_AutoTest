package com.universal.tool;

public class OP {

	//1.�ȴ�ʱ��
	public static void wait(int seconds) {
	    try {Thread.sleep(1000*seconds);} 
			catch (InterruptedException e) {
				e.printStackTrace();}  
		 }
	
	

}
