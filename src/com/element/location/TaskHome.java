package com.element.location;

public class TaskHome {
   //1.新增任务标签
	public static String  createTask = "/html/body/div[1]/div/div[2]/div/section/div[1]/div[2]/div[1]/div[4]/a/span[2]";
	//2.任务列表
	public static String tab = "/html/body/div[1]/div/div[2]/div/section/div[1]/div[2]/div[2]/table";
	//3.源类型下拉框
	public static String souDB ="/html/body/div[1]/div/div[2]/div/section/div[1]/div[2]/div[1]/div[1]/span/select";
	//4.目标类型下拉框
	public static String objDB="/html/body/div[1]/div/div[2]/div/section/div[1]/div[2]/div[1]/div[2]/span/select";
	//5.任务名输入框
	public static String taskInput="/html/body/div[1]/div/div[2]/div/section/div[1]/div[2]/div[1]/div[3]/input";
	//6.搜索按钮
	public static String searchBut = "/html/body/div[1]/div/div[2]/div/section/div[1]/div[2]/div[1]/div[3]/button";
	
	//7.任务状态--就绪
	public static String ready ="就绪";
	//8.任务状态--下线
	public static String offline ="下线";
	// 任务状态--运行
	public static String online="运行";
	
	//9.任务操作--启动
	public static String star = "启动";
	//10.任务操作--编辑
	public static String edit ="编辑";
	//11.任务操作--删除
	public static String del="删除";
	//12.任务操作--详情
	public static String detail ="详情";
	//13.任务操作--停止
	public static String stop="停止";
}
