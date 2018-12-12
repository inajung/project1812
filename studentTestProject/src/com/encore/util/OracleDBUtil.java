package com.encore.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OracleDBUtil {
	
	//DB연결
	public static Connection dbConnect(){
		Connection conn  = null; 
		String url = "jdbc:oracle:thin:@localhost:1521:XE"; //Data Source Explorer에서 가져옴 
		String user = "hr", password = "hr";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn; //잘되면 conn이가고, 잘못되면 초기값인 null이 간다 
	}
	
	//DB연결해제
	public static void dbDisconnect(ResultSet rs, Statement st, Connection conn) {
		try {
			if(rs!=null)rs.close();  //닫는 순서 지킬 것, 자동 conn try&catch에 추가 
			if(st!=null)st.close();  //닫는 순서 지킬 것, 자동conn try&catch에 추가 
			if(conn!=null)conn.close();  //닫는 순서 지킬 것, 자동 try&catch에 if절 추가 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
