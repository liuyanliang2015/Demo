/**
 * 
 */
package com.test.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author LiuYanliang
 * 
 */
public class JdbcDemo {
	private static final String userName = "root";
	private static final String passWord = "root";
	private static final String sql = "select count(*) from pisp_user";
	private static final String sql2 = "select count(*) from pisp_user where USER_TYPE = ?";
	private  Connection conn = null;
	private  PreparedStatement pstmt = null;
	private  Statement stmt = null;
	private  ResultSet rs = null;
	
	
	/**
	 * ׼����������ȡ���ݿ����������ݿ�����
	 */
	@Before
	public void testBefore() {
		StringBuffer sb = new StringBuffer();
		sb.append("jdbc:mysql://localhost:3306/pisp?");
		sb.append("useUnicode=true&characterEncoding=UTF8");
		
		try {
			//�������ݿ�����
			Class.forName("com.mysql.jdbc.Driver");
			//��ȡ���ݿ�����
			conn = DriverManager.getConnection(sb.toString(), userName, passWord);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * Statementִ��sql���
	 */
	@Test
	public void testJdbc1() {
		try {
			//��ȡsqlִ����
			stmt = conn.createStatement();
			//ִ��sql���
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				// ע�⣺�±��1��ʼ
				System.out.println(rs.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	
	/**
	 * PreparedStatementִ��sql���
	 */
	
	@Test
	public void testJdbc2() {
		try {
			pstmt = conn.prepareStatement(sql2);
			//parameterIndex�����±꣬��1��ʼ��x����ֵ
			pstmt.setInt(1, 5);
			// ִ��sql���
			rs = pstmt.executeQuery();
			while (rs.next()) {
				// ע�⣺�±��1��ʼ
				System.out.println(rs.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	

	/**
	 * �ͷ���Դ���ȵõ��ĺ�ر�
	 */
	@After
	public void testAfter() {
		try {
			if(rs != null){
				rs.close();
			}
			
			if(stmt != null){
				stmt.close();
			}
			
			if(pstmt != null){
				pstmt.close();
			}
			
			if(conn != null){
				conn.close();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
