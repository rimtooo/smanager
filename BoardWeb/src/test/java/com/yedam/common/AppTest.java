package com.yedam.common;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;


public class AppTest {
	public static void main(String[] args) {
		MemberService svc = new MemberServiceImpl();
		List<Map<String, Object>> list = svc.getCountByMember();
		for(Map<String, Object> map : list) {
			System.out.println("----------------------");
			Set<String> keyset = map.keySet();
			for(String key : keyset) {
				System.out.println(key + ", " + map.get(key));
			}
		}
		
		System.out.println(" --End-- ");
		
//		ReplyService svc = new ReplyServiceImpl();
//		
//		SearchVO search = new SearchVO();
//		
//		search.setBno(260);
//		search.setPage(1);
//		
//		svc.replyList(search).forEach(System.out::println);
		
//		ReplyVO rvo = new ReplyVO();
//		rvo.setReplyContent("등록연습");
//		rvo.setReplyer("user03");
//		rvo.setBoardNo(260);
//		
//		if(svc.removeReply(1)) {
//			System.out.println("삭제완료!");
//		}
//		
//		svc.addReply(rvo);
		
		
		
		
		//		BoardService svc = new BoardServiceImpl();
//		SearchVTO search = new SearchVTO();
//		search.setSearchCondition("TW");
//		search.setKeyword("웹은");
//		search.setPage(1);
//		
//		svc.boardList(search).forEach(System.out::println);
//		System.out.println("- End -");
		
		
		
		
		
		
//		SqlSession sqlSession = //
//				DataSource.getInstance().openSession(true); //true 넣으면 자동 커밋됨.
//		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
////		StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
//	
//		BoardVO brd = new BoardVO();
////		brd.setTitle("매퍼테스트2222");
////		brd.setContent("조건이 제대로 되는지2222");
////		brd.setWriter("newbie");
//		brd.setBoardNo(5);
//		
//		
//		
//		
////		if(mapper.insertBoard(brd) == 1) {
////			System.out.println("OK");
////		}
////		if(mapper.updateBoard(brd) == 1) {
////			System.out.println("OK");
////		}
////		if(mapper.deleteBoard(5) == 1) {
////			System.out.println("OK");
////		}
//		
//		System.out.println(mapper.selectBoard(1));
//		
////		mapper.selectList().forEach(board -> System.out.println(board.toString()));
//		
//		System.out.println("- End -");
//	
//		
//		
//		
//		
////		mapper.studentList()//
////			.forEach(student -> {
////			System.out.println(student)
////			;});
	}
}
