package com.data.function;

public class TaskInfo {
	private String taskName;
	private String taskType;
	private String taskContent;
	
	
	public TaskInfo(String taskName,String taskType,String taskContent) {
		this.taskName = taskName;
		this.taskType = taskType;
		this.taskContent = taskContent;	
	}
	

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getTaskType() {
		return taskType;
	}

	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}


	public String getTaskContent() {
		return taskContent;
	}


	public void setTaskContent(String taskContent) {
		this.taskContent = taskContent;
	}
	
	
}
