package com.yedam.service;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.mapper.StudentMapper;

public class MemberServiceImpl implements MemberService {
	SqlSession sqlSession = //
			DataSource.getInstance().openSession(true); //true 넣으면 자동 커밋됨.
	StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
	
	@Override
	public boolean loginCheck(String id, String pw) {
		return mapper.selectMember(id, pw) == 1;
	}

}
 