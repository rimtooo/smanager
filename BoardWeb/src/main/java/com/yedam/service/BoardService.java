package com.yedam.service;

import java.util.List;

import com.yedam.common.SearchVTO;
import com.yedam.vo.BoardVO;

/*
 * MVC 패턴의 대자인에 따라서 Model영역(service, dao:mapper).
 * 책 : 4강 MVC기반 웹프로젝트 참고.
 * 숙제 : 536페이지 MVC에 자세히 읽고 오세요.
 */
public interface BoardService {
//	List<BoardVO> boardList();
	List<BoardVO> boardList(SearchVTO search);
	int totalCount(SearchVTO search); // 페이징 계산용 건수.
	boolean addBoard(BoardVO board);
	boolean modifyBoard(BoardVO board);
	boolean removeBoard(int boardNo);
	BoardVO getBoard(int boardNo);
}
 