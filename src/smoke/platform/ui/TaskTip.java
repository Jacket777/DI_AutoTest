package smoke.platform.ui;
//操作任务时各类弹出框定位
public class TaskTip {
    //1.任务下线
	public static String offline ="/html/body/div[3]/div/div/div[1]/div/h5";
	//2.任务下线弹出框中知道了按钮
	public static String offknow="/html/body/div[3]/div/div/div[2]/button";
	
	//3.任务初始化成功
	public static String initline="/html/body/div[4]/div/div/div[1]/div/h5";
	//4.任务初始化成功知道了按钮
	public static String initknow = "/html/body/div[4]/div/div/div[2]/button";
	//7.确认任务删除弹出框
	public static String delDiv = "/html/body/div[3]/div/div/div[3]";
	//5.任务删除弹出框标题
	public static String deline=" /html/body/div[3]/div/div/div[1]/h4[text()='确认删除']";
	//6.任务删除弹出框确定按钮 定位失败
	public static String confirmBut="/html/body/div[4]/div/div/div[3]/button[1][text()='确定']";
	//任务删除成功后的提示框中知道了按钮
	public static String delknow ="/html/body/div[3]/div/div/div[2]/button";
	
	
	//
	public static String prompDiv = "/html/body/div[3]/div/div";


}
