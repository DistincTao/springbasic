package com.springbasic.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;

public class ConnectionTest {
	private static final String DRIVER ="com.mysql.cj.jdbc.Driver";
	private static final String URL ="jdbc:mysql://localhost:3306/distinctao?useSSL=false&serverTimezone=Asia/Seoul&characterEncoding=UTF-8";
	private static final String USERNAME ="root";
	private static final String PASSWORD ="1234";
	
	@Test // JUnit 4 버전 라이브러리로 동작되는 Test 메소드임을 의미
	public void testConnection () throws ClassNotFoundException {
		Class.forName(DRIVER);
		
		try(Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD)){
			if (con != null) { // 연결이 잘 되면 
				System.out.println(con.toString());
			}
		} catch (SQLException e){ // 예외 발생시 
			e.printStackTrace();
		}
	}
}
