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


	//1.��������
	public  void Connect(DB db, Account account) {
		  try{
	            Class.forName("com.mysql.jdbc.Driver");
	            System.out.println("���������ɹ�!"); 
	        } catch (ClassNotFoundException e) {
	            System.out.println("��������ʧ��!");
	            e.printStackTrace();
	        }
	        // ��������
	        try {
	        	String url="jdbc:mysql://"+db.getIp()+":3306/"+db.getName();
	            con = (Connection) DriverManager.getConnection(url, account.getUsername(), account.getPassword());
	            stmt= (Statement) con.createStatement();
	            System.out.println("���ݿ����ӳɹ�!"); 
	        } catch(SQLException e) {
	            System.out.println("���ݿ�����ʧ��!"); 
	        }
	}
	
	
   //2.	��ѯ
	public void queryData(String sql) {
        try {
            rs = stmt.executeQuery(sql);
            ResultSetMetaData meta_data = rs.getMetaData();//����
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
            System.out.println("���ݲ�ѯʧ��!");
        }
	}
	
	//3.��������
	public void insertData(String sql) {
	      try {
	            stmt.clearBatch();
	            stmt.addBatch(sql);
	            stmt.executeBatch();
	            System.out.println("���ݲ���ɹ�!");
	        }catch (Exception e) {
	            System.out.println("���ݲ���ʧ��!");
	        }
	  }
	
	//4.��������
	public void updateData(String sql) {
		 try {
	            stmt.executeUpdate(sql);
	            System.out.println("���ݸ��³ɹ�!");
	        }catch (Exception e) {
	            System.out.println("���ݸ���ʧ��!");
	        }
	}
		
}