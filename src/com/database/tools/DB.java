package com.database.tools;

public class DB {
	private  String type;
	private  String ip;
	private  String name;
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public DB(String type,String ip, String name) {
		this.type = type;
		this.ip = ip;
		this.name = name;
	}
}