package com.bitacademy.emaillist.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.bitacademy.emaillist.vo.EmaillistVo;


@Repository
public class EmaillistRepository {

	public List<EmaillistVo> findAll() {
		List<EmaillistVo> result = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			
			String sql = "select no, first_name, last_name, email from emaillist order by no asc";
			stmt = conn.prepareStatement(sql);
			
			 rs = stmt.executeQuery();	
			
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
			System.out.println("Error"+e);
		} finally {
			try {
				if(rs!=null)	rs.close();
				if(conn!=null)	conn.close();
				if(stmt!=null)	stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

	public boolean insert(EmaillistVo vo) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			
			String sql = "insert into emaillist values (null,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,vo.getFirstName() );	
			pstmt.setString(2, vo.getLastName());
			pstmt.setString(3, vo.getEmail());
			
			int count = pstmt.executeUpdate();
			
			result = count ==1;
			
		} catch (SQLException e) {
			System.out.println("Error"+e);
		} finally {
			try {
				if(conn!=null)	conn.close();
				if(pstmt!=null)	pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public boolean delete(Long no) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			
			String sql = "delete from emaillist where no = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setLong(1, no);
			
			int count = pstmt.executeUpdate();
			
			result = count ==1;
			
		} catch (SQLException e) {
			System.out.println("Error"+e);
		} finally {
			try {
				if(conn!=null)	conn.close();
				if(pstmt!=null)	pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public Long getCount() {
		Long result = -1l;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			
			String sql = "select count(*) from emaillist";
			stmt = conn.prepareStatement(sql);
			
			 rs = stmt.executeQuery();	
			
			 while(rs.next()) {
				 result = rs.getLong(1);
			 }
		}catch (SQLException e) {
			System.out.println("Error"+e);
		} finally {
			try {
				if(rs!=null)	rs.close();
				if(conn!=null)	conn.close();
				if(stmt!=null)	stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	private Connection getConnection() throws SQLException {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}	

		String url = "jdbc:mariadb://192.168.0.153:3306/webdb?charset=utf8";		//이것도 드라이버마다 정해져 있음.

		return DriverManager.getConnection(url,"webdb","webdb");
	}
	
}
