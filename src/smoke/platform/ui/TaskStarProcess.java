package smoke.platform.ui;

public class TaskStarProcess {
	 //1.任务初始化
	 public static String init = "//*[@id=\"startModal\"]/div/div/div[2]/div/div[1]/label/input";
	 //2.任务回放
	 public static String rollback = "//*[@id=\"startModal\"]/div/div/div[2]/div/div[2]/label/input";
	 //1.任务初始化文本
	 public static String initTxt= " //*[@id=\"startModal\"]/div/div/div[2]/div/div[1]/label";
	 //2.任务回放
	 public static String rollbackTxt= "//*[@id=\"startModal\"]/div/div/div[2]/div/div[2]/label";
	 //3.回放开始时间文本
	 public static String rollbackTime=" //*[@id=\"startModal\"]/div/div/div[2]/div/div[3]/label[1]";
	 
	 
	 //3.确定按钮
	 public static String confirmBut="//*[@id=\"startModal\"]/div/div/div[3]/button[2]";
	 //4.取消按钮
	 public static String cancelBut= "//*[@id=\"startModal\"]/div/div/div[3]/button[1]";
	 //5.初始化成功弹出框知道了按钮
	 public static String know = "/html/body/div[4]/div/div/div[2]/button";
	
	 //6.初始化成功信息
	 public static String succMessage="/html/body/div[4]/div/div/div[1]/div/h5";
	 
	 
	 
	
	

	

}
