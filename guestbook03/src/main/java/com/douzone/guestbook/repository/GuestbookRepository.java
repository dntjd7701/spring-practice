package com.douzone.guestbook.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.douzone.guestbook.vo.GuestbookVo;

@Repository
public class GuestbookRepository {
	
	// connection
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
		public Boolean insert(GuestbookVo vo) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			boolean result = false;
			
			
			
			try {
				conn = getConnection();
				
				String sql = "insert into guestbook values(null, ?, ?, ?, NOW())";
				pstmt = conn.prepareStatement(sql);

				
				pstmt.setString(1, vo.getName());
				pstmt.setString(2, vo.getPassword());
				pstmt.setString(3, vo.getMessage());
//				pstmt.setString(4, vo.getRegDate());
				
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
		public List<GuestbookVo> findAll() {
			List<GuestbookVo> result =  new ArrayList<>();
			
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			
			
			try {
				conn = getConnection();
				
				
				String sql = "select no, name, "
						+ "password, message, date_format(reg_date, '%Y/%m/%d, %r'), no "
						+ " from guestbook";
				
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
				
				while(rs.next()) {
					Long no = rs.getLong(1);
					String name = rs.getString(2);
					String password = rs.getString(3);
					String message = rs.getString(4);
					String date = rs.getString(5);
					
					GuestbookVo vo = new GuestbookVo();
					vo.setNo(no);
					vo.setName(name);
					vo.setPassword(password);
					vo.setMessage(message);
					vo.setRegDate(date);
					
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
		
		
		
		// delete
			public Boolean delete(GuestbookVo vo) {
				Connection conn = null;
				PreparedStatement pstmt = null;
				boolean result = false;
				
				
				try {
					conn = getConnection();
					
					String sql = "delete from guestbook"
							+ " where no=? "
							+ "and password=?";
					pstmt = conn.prepareStatement(sql);
					
					pstmt.setLong(1, vo.getNo());
					pstmt.setString(2, vo.getPassword());
					
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
		
		
		// find, insert, delete 구현.
		

}
