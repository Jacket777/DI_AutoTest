package smoke.data.config;
//创建任务时所需的参数

public class Task {
	//1.任务名称
	public static String name="Test";
	//2.任务描述
	public static String type="Mysql(binlog) → Hive";
	//3.任务描述
	public static String descript="AA";
	//4.源数据库名称
	public static String sourDB="disit_test";
	//5.源数据库表
	public static String sourTab="disit_test";
	//6.目标数据库名称
	public static String lastDB="test";
	//7.目标数据库表
	public static String lastTab="disit_test";
	//8.DDL配置
	public static String DLL="";
	//9.时间间隔配置
	public static String interval="";
	//10.启动任务
	public static String star="启动";
	//11.编辑任务
	public static String edit="编辑";
	//12.删除任务
	public static String del="删除";
	//13.任务详情
	public static String detail="详情";
	//14.停止任务
	public static String stop="停止";
}
