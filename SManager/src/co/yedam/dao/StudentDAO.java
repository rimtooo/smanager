package co.yedam.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.yedam.vo.StudentVO;

// 목록(R), 등록(C), 수정(U), 삭제(D)

public class StudentDAO extends DAO {
	
	// 등록기능.
	public boolean insertStudent(StudentVO svo) {
		String sql = "insert into student (std_no, std_name, std_phone, address, birth_date) ";
		sql += "values(?, ?, ?, ?, ?) ";
		conn = getConn();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, svo.getStdNo());
			psmt.setString(2, svo.getStdName());
			psmt.setString(3, svo.getStdPhone());
			psmt.setString(4, svo.getAddress());
			psmt.setString(5, svo.getBirthdate());
			
			int r = psmt.executeUpdate(); // 쿼리실행.
			if(r == 1) {
				return true; // 정상처리.
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false; // 비정상처리.
	}
	
	// 목록반환기능.
	public List<StudentVO> selectList(){
		String sql = "Select * from student order by std_no";
		List<StudentVO> list = new ArrayList<>();
		
		conn = getConn();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				StudentVO svo = new StudentVO();
				svo.setAddress(rs.getString("address"));
				svo.setBirthdate(rs.getString("birth_date"));
				svo.setCreationDate(rs.getDate("creation_date"));
				svo.setStdName(rs.getString("std_name"));
				svo.setStdName(rs.getString("std_no"));
				svo.setStdPhone(rs.getString("std_phone"));
				
				list.add(svo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
		
	}//end of selectList().
}
