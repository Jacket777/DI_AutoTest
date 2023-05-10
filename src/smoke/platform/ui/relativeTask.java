package smoke.platform.ui;
//关联任务页面元素

public class relativeTask {
	 //1.新增关联任务按钮
     public static String addTask = "/html/body/div[1]/div/div[2]/div/section/div[1]/div[3]/div/div/div[1]/div/button";
     //2.关联任务弹出框中任务列表                     
     public static String taskTable = "//*[@id=\"popSelectTasks\"]/div/div/div[2]/table";
     //3.关联任务弹出框中确认按钮
     public static String confirmButton = "//*[@id=\"popSelectTasks\"]/div/div/div[3]/button";
     //4.关联任务弹出框中取消按钮
     public static String cancelBut ="//*[@id=\"popSelectTasks\"]/div/div/div[1]/button/span" ;
     //5.告警策越的关联任务表
     public static String addTaskTable ="/html/body/div[1]/div/div[2]/div/section/div[1]/div[3]/div/div/div[2]/table";
}
