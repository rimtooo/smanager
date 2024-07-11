package co.yedam.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import co.yedam.vo.StudentVO;

public class AppTests {
	//기능
	public static Connection getConn() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		String user = "jsp";
		String pass = "jsp";
		Connection conn = null;

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, pass);
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("오라클 드라이버 없음.");
			e.printStackTrace();
//			return null;
		}
		return conn;
		
	}//end of getConn.

	
	
	public static void main(String[] args) {
		// 1) Oracle JDBC Driver 자바라이브러리.
		// 2) Connection 객체.
		Scanner scn = new Scanner(System.in);
		System.out.println(">학생번호 입력.");
		String sno = scn.nextLine();
		System.out.println(">학생이름 입력.");
		String sname = scn.nextLine();
		System.out.println(">연락처 입력.");
		String phone = scn.nextLine();
		System.out.println(">주소 입력.");
		String addr = scn.nextLine();
		System.out.println(">생일 입력.");
		String birth = scn.nextLine();
		
		StudentVO std = new StudentVO();
		std.setStdNo(sno);
		std.setStdName(sname);
		std.setStdPhone(phone);
		std.setAddress(addr);
		std.setBirthdate(birth);
		
		modStu(std);
//		modStu(sno, sname, phone, addr, birth);
//		removeStudent(sno); //입력.
		search(); // 목록조회.
	}

	// 삭제기능.
	public static void removeStudent(String stdNo) {
		Connection conn = getConn();
		String sql = "delete from student where std_no = '" + stdNo + "'";
		try {
			Statement stmt = conn.createStatement();
			int r = stmt.executeUpdate(sql); // insert, update, delete => 처리된 건수.
			System.out.println("처리된 건수는 " + r + "건.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 수정기능.
	// update tbl_student
	// set std_name = '변경값'
	// ,std_phone = '변경값'
	// where std_no = '조회값'
	public static void modStudent(String stdNo, String stdName, String phone) {
		Connection conn = getConn();
		String sql = "update student set std_name = '" + stdName + "', std_phone = '" + phone + "' where std_no ='"
				+ stdNo + "'";
		try {
			Statement stmt = conn.createStatement();
			int r = stmt.executeUpdate(sql); // insert, update, delete => 처리된 건수.
			System.out.println("처리된 건수는 " + r + "건.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 수정기능2
	public static void modStu(StudentVO svo) {

		Connection conn = getConn();
		String sql = "update student ";
		sql += "set      std_name = nvl('" + svo.getStdName() + "', std_name)";
		sql += "        ,std_phone = nvl('" + svo.getStdPhone() + "', std_phone)";
		sql += "        ,address = nvl('" + svo.getAddress() + "', address)";
		sql += "        ,birth_date = nvl('" + svo.getBirthdate() + "', birth_date)";
		sql += "  where std_no = '" + svo.getStdNo() + "'";

		try {
			Statement stmt = conn.createStatement();
			int r = stmt.executeUpdate(sql); // insert, update, delete => 처리된 건수.
			System.out.println("처리된 건수는 " + r + "건.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	// 입력기능.
	// insert into student (std_no, std_name, std_phone, address)
	// values('S2024-02', '김길동', '010-3333-4444', '서울 100번지');
	public static void addStudent(String stdNo, String stdName, String phone) {
		Connection conn = getConn();
		String sql = "insert into student (std_no, std_name, std_phone)";
//		sql += "values('S2024-05', '박성태', '010-6789-7826')";
		sql += "values('" + stdNo + "', '" + stdName + "', '" + phone + "')";
		try {
			Statement stmt = conn.createStatement();
			int r = stmt.executeUpdate(sql); // insert, update, delete => 처리된 건수.
			System.out.println("처리된 건수는 " + r + "건.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	
	// 조회기능
	public static void search() {
		// 조회기능.

		try {
			Connection conn = getConn();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from student");
			// [객체1, 객체2, 객체3]
			while (rs.next()) {
				String birth = rs.getString("birth_date");
				birth = birth != null ? birth : "";
				System.out.println(
						rs.getString("std_no") + ", "//
						+ rs.getString("std_name") + ", "//
						+ rs.getString("std_phone") + ", "//
						+ birth.substring(0, 10)//
						);
			}
			System.out.println("end of data.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// 조회기능 끝
	}
}
