package com.sjh.model;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.*;
import javax.sql.*;


public class MembersDAO {
	private DataSource ds;
	
	private MembersDAO() {
		try {
			Context ct = new InitialContext();
			ds = (DataSource)ct.lookup("java:comp/env/jdbc/mysql");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private static MembersDAO dao = new MembersDAO();
	
	public static MembersDAO getinstance() {
		if(dao == null) {
			dao = new MembersDAO();
		}
		return dao;
	}
	
	// 회원가입을 처리하는 메서드 선언
	// DB에 들어가는 데, 혹은 DB에서 출력되어 나오는 데이터
	// 모두가 UsersVO 내부 자료형식을 벗어날 수 없으므로
	// 대다수 입출력은 전부VO를 매개로 진행합니다.
	public int joinMember(MembersVO member) {
		// members_join.jsp애서 가져온 코드를 이곳에 붙여넣기를 합니다.
		// DB연동을 위한 Connector 설정
		// Connection 객체 생성
		Connection con = null;
		// 쿼리문 실행을 위한 pstmt 객체 생성
		PreparedStatement pstmt = null;
		
		try {
			// 커넥션 풀
			con = ds.getConnection();
			// 쿼리문
			String sql = "INSERT INTO member VALUES(?, ?, ?, ?, ?, ?, ?)";
			
			// 쿼리문 실행 및 나머지 로직
			pstmt =con.prepareStatement(sql);
			
			
			pstmt.executeUpdate();
			
			
		}catch(Exception e) {
			System.out.println("에러 : " + e);
		}finally {
			try {
				if(con != null && !con.isClosed()) {
					con.close();
				}if(pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return 1;
	}// end joinMember
	public int login(MembersVO member) {
		// Connection, PreparedStatement 객체 선언
		Connection con = null;
		PreparedStatement pstmt = null;
		
		int resultCode = 0;
		
		// 구문 작성
		// bId는 auto_increment가 붙어있으므로 입력 안해도 됨
		// bName, bTitle, bContent는 폼에서 날려준걸 넣음
		// bDate는 자동으로 현재 서버시간을 입력함
		// bHit는 자동으로 0을 입력함
		String sql = "INSERT INTO member (mid, mpw) VALUES(?,?)";
				
		try {
			// 커넥션 생성 및 pstmt에 쿼리문 넣고 완성시켜서 실행까지 하고
			// close()로 메모리회수까지 해주새요.
			con = ds.getConnection();
			
			pstmt = con.prepareStatement(sql);
			
			
			pstmt.executeUpdate();
			return 1;
		}catch(Exception e) {
			e.printStackTrace();
			return 0;
		}finally {
			try {
				if(con!=null && !con.isClosed()) {
					con.close();
				}
				if(pstmt!=null && !pstmt.isClosed()) {
					pstmt.close();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		
	}
}

