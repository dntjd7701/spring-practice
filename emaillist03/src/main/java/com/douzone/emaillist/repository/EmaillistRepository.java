package com.douzone.emaillist.repository;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.douzone.emaillist.vo.EmaillistVo;

public class EmaillistRepository {
	
	private Connection getConnection() throws SQLException {
		Connection conn = null;

		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1:3306/webdb?charset=utf8";
			String id = "webdb";
			String pw = "webdb";

			conn = DriverManager.getConnection(url, id, pw);

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패, 드라이버 확인 요망");
		}

		return conn;
	}

	
	
	// insert
	public Boolean insert(EmaillistVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean result = false;
		
		
		
		try {
			conn = getConnection();
			
			String sql = "insert"
					+ "	into emaillist01"
					+ " values(null, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);

			
			pstmt.setString(1, vo.getFirstName());
			pstmt.setString(2, vo.getLastName());
			pstmt.setString(3, vo.getEmail());
			
			// 실행 
			int count = pstmt.executeUpdate();
			result = count == 1;
			
			
		} catch (SQLException e) {
			System.out.println("error: " + e);
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
				
			} catch (SQLException e){
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	
	
	// 정보 출력하기 
	public List<EmaillistVo> findAll() {
		List<EmaillistVo> result =  new ArrayList<>();
		
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		
		try {
			conn = getConnection();
			
			
			String sql = "select no, first_name, last_name, email "
					+ " from emaillist01"
					+ " order by no desc";
			
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			
			while(rs.next()) {
				Long no = rs.getLong(1);
				String firstName = rs.getString(2);
				String lastName = rs.getString(3);
				String email = rs.getString(4);
				
				EmaillistVo vo = new EmaillistVo();
				
				vo.setNo(no);
				vo.setFirstName(firstName);
				vo.setLastName(lastName);
				vo.setEmail(email);
				
				result.add(vo);
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	
}
