package com.data.function;

public class Data {
	private String divId;
	private String databaseName;
	private String tableName;
	
	public String getDivId() {
		return divId;
	}

    public void setDivId(String divId) {
		this.divId = divId;
	}

	public String getDatabaseName() {
		return databaseName;
	}



	public void setDatabaseName(String databaseName) {
		this.databaseName = databaseName;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	
	public Data(String divId,String databaseName,String tableName) {
		this.divId = divId;
		this.databaseName = databaseName;
		this.tableName = tableName;
	}

}
