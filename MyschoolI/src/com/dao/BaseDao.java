package com.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;


public class BaseDao {
	 private static String url = "jdbc:mysql://localhost:3306/world";
	 private static String user="root";
	 private static String password="root";
	 
//	 static{init();}
//		
//		public static void init(){
//			Properties params = new Properties();
//			String configFile = "db.properties";
//			
//			InputStream is = BaseDao.class.getClassLoader().getResourceAsStream(configFile);
//			
//			try {
//				params.load(is);
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//			url=params.getProperty("url");
//			user=params.getProperty("user");
//			password=params.getProperty("password");
//			
//			
//		}
	
	public Connection conn = null;
	public PreparedStatement pstmt = null;
	public ResultSet rs = null;
	public void getConnection(){
		 try {
			Class.forName("com.mysql.jdbc.Driver");
			 conn = DriverManager.getConnection(url,user,password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}		 
	}
	
	
	public void closeAll(){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(pstmt!=null){
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public int exceuteUpdate(String sql,Object[] param){
		int num = 0;
		getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			if(param!=null){
				for (int i = 0; i < param.length; i++) {
					pstmt.setObject(i+1, param[i]);
				}
			}
			num=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeAll();
		}
		
		return num;
	}
	
}