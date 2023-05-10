package com.database.tools;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class DBO {
	private DB db;
	private Account ac;
	
	public DBO(DB db,Account ac) {
		this.db = db;
		this.ac = ac;
	}
	
	public static Connection con;
	public static Statement stmt;
	public static ResultSet rs;
	
	public DB getDb() { return db; }
    public void setDb(DB db) { this.db = db;}
	public Account getAc() { return ac;}
	public void setAc(Account ac) { this.ac = ac;}


	//1.建立连接
	public  void Connect(DB db, Account account) {
		  try{
	            Class.forName("com.mysql.jdbc.Driver");
	            System.out.println("加载驱动成功!"); 
	        } catch (ClassNotFoundException e) {
	            System.out.println("加载驱动失败!");
	            e.printStackTrace();
	        }
	        // 建立连接
	        try {
	        	String url="jdbc:mysql://"+db.getIp()+":3306/"+db.getName();
	            con = (Connection) DriverManager.getConnection(url, account.getUsername(), account.getPassword());
	            stmt= (Statement) con.createStatement();
	            System.out.println("数据库连接成功!"); 
	        } catch(SQLException e) {
	            System.out.println("数据库连接失败!"); 
	        }
	}
	
	
   //2.	查询
	public void queryData(String sql) {
        try {
            rs = stmt.executeQuery(sql);
            ResultSetMetaData meta_data = rs.getMetaData();//列名
            for (int i_col = 1; i_col <= meta_data.getColumnCount(); i_col++) {
                System.out.print(meta_data.getColumnLabel(i_col) + "   ");
            }
            System.out.println();
            while (rs.next()) {
                for (int i_col = 1; i_col <= meta_data.getColumnCount(); i_col++) {
                    System.out.print(rs.getString(i_col) + "  ");
                }
                System.out.println();
            }
            rs.close();
        }catch (Exception e) {
            System.out.println("数据查询失败!");
        }
	}
	
	//3.插入数据
	public void insertData(String sql) {
	      try {
	            stmt.clearBatch();
	            stmt.addBatch(sql);
	            stmt.executeBatch();
	            System.out.println("数据插入成功!");
	        }catch (Exception e) {
	            System.out.println("数据插入失败!");
	        }
	  }
	
	//4.更新数据
	public void updateData(String sql) {
		 try {
	            stmt.executeUpdate(sql);
	            System.out.println("数据更新成功!");
	        }catch (Exception e) {
	            System.out.println("数据更新失败!");
	        }
	}
		
}