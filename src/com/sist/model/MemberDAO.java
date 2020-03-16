package com.sist.model;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = null;

	// 싱글톤 객체 만들기
	// 1. 싱글톤 객체를 만들때는 우선적으로 접근지정자는 private으로 선언한다.
	// 2. 정적 멤버로 선언한다. -static으로 선언

	private static MemberDAO instance = new MemberDAO();// static:메서드 영역에 만들어진다아

	// 3. 기본생성자는 외부에서 접근이 되지 않도록 해야한다. -private으로 생성자 생성
	// 외부에서 new를 사용하지 못하게 하는 접근 기법.
	private MemberDAO() {}

	// 4. 생성자 대신에 싱글톤 객체를 return 해주는 getInstance() 메서드를 만들어 주자.
	public static MemberDAO getInstance() {// static에 있는 instance를 받아줘야하기때문에 static
		if (instance == null) {// 객체생성했기때문에 null일리가 없지만 혹시나모르니까아...
			instance = new MemberDAO();
		}
		return instance; // 참조변수 리턴!
	}

	public Connection openConn() {// 드라이버 로~오~딩 하는 메서드
		// 오라클드라이버를 가져와서 사용할수있께해야해...... ... ㅜㅜ
		String driver = "oracle.jdbc.driver.OracleDriver";

		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "genie";
		String password = "1234";

		// 1.드라이버 로오ㅗ오오딩~
		try {
			// 애ㅗ냐면 오라클드라이버가 없을수있기떄문에에..

			Class.forName(driver);

			// 2. DB와 연결
			con = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}//openConn() end
	
	//member1 테이블에서 전체 리스트를 가져오는 메서드
	public List<MemberVO> getMemberList(){
		List<MemberVO> list =new ArrayList<MemberVO>();
		
		
		try {
			openConn();
			sql = "select * from member1 order by reg_date desc";
			
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setId(rs.getString("id"));
				vo.setName(rs.getString("name"));
				vo.setPwd(rs.getString("pwd"));
				vo.setTel(rs.getString("tel"));
				vo.setAddr(rs.getString("addr"));
				vo.setEmail(rs.getString("email"));
				vo.setAge(rs.getInt("age"));
				vo.setReg_date(rs.getString("reg_date"));
				list.add(vo);//주소값저장
			}
			
			
			//open객체 닫기
			rs.close(); pstmt.close(); con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}//getMemberList() 메서드 end
	
	//member1 테이블에 회원을 가입하는 메서드
	public int insertMember(MemberVO vo) {
		int result=0;
		
		try {
			openConn();
			sql="insert into member1(id,name,pwd,reg_date) values(?,?,?,sysdate)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getPwd());
			result = pstmt.executeUpdate();
			
			//open 객체 닫기
			pstmt.close();con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}//insertMember() 메서드 end
	
	//member1 테이블에서 회원 아이디에 해당하는 회원의 상세내역을 조회하는 메서드
	public MemberVO contMember(String id) {
		MemberVO vo = new MemberVO();
		
		
		try {
			openConn();
			sql="select * from member1 where id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo.setId(rs.getString("id"));
				vo.setName(rs.getString("name"));
				vo.setPwd(rs.getString("pwd"));
				vo.setTel(rs.getString("tel"));
				vo.setAddr(rs.getString("addr"));
				vo.setEmail(rs.getString("email"));
				vo.setAge(rs.getInt("age"));
				vo.setReg_date(rs.getString("reg_date"));
			}
			
			//open객체 닫기
			rs.close();pstmt.close();con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return vo;
	}//contMember() 메서드 end

	//member1테이블의 아이디에 해당하는 컬럼들을 수정하는 메서드
	public int updateMember(MemberVO vo) {
		int result = 0;
		
		try {
			openConn();
			sql = "update member1 set tel=?, addr=?, email=?, age=? where id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getTel());
			pstmt.setString(2, vo.getAddr());
			pstmt.setString(3, vo.getEmail());
			pstmt.setInt(4, vo.getAge());
			pstmt.setString(5, vo.getId());
			result = pstmt.executeUpdate();
			
			//open 객체닫기
			pstmt.close(); con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
				
	}//updateMember() 메서드 end
}
