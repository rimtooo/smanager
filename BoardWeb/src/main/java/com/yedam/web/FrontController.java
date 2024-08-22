package com.yedam.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.control.ActionControl;
import com.yedam.control.AddReplyControl;
import com.yedam.control.AddScheduleControl;
import com.yedam.control.BoardControl;
import com.yedam.control.BoardForm;
import com.yedam.control.BoardListControl;
import com.yedam.control.CntByMember;
import com.yedam.control.DeleteBoard;
import com.yedam.control.DeleteScheduleControl;
import com.yedam.control.FullCalendar;
import com.yedam.control.GoogleChart;
import com.yedam.control.ImageDownLoad;
import com.yedam.control.LoginControl;
import com.yedam.control.LoginForm;
import com.yedam.control.LogoutControl;
import com.yedam.control.MemberListControl;
import com.yedam.control.ModifyBoard;
import com.yedam.control.PagingCount;
import com.yedam.control.RemoveBoard;
import com.yedam.control.RemoveReplyControl;
import com.yedam.control.RemoveStudent;
import com.yedam.control.ReplyListControl;
import com.yedam.control.ScriptControl;
import com.yedam.control.StudentJson;
import com.yedam.control.StudentListControl;
import com.yedam.control.UpdateBoard;
import com.yedam.control.addStudent;

/*
 * FrontController 역할은 사용자의 모든 요청을 처리.
 * 서블릿. a.do, sample.do
 * 객체생성 -> init -> service -> destroy.
 */
public class FrontController extends HttpServlet {

	Map<String, Control> map;

	public FrontController() {
		map = new HashMap<>();
//		System.out.println("FrontController() 호출.");
//		super();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
//		System.out.println("init() 호출");
		map.put("/boardList.do", new BoardListControl());
		// 글 등록 구현 : 등록화면(BoardFrom.do) + DB등록(addBoard.do) -> 글목록페이지이동.
		map.put("/boardForm.do", new BoardForm());
		//map.put("/addBoard.do", new AddBoardControl());
		// 학생목록
		map.put("/stdList.do", new StudentListControl());

		//
		map.put("/board.do", new BoardControl());
		// 삭제
		map.put("/removeBoard.do", new RemoveBoard());
		map.put("/deleteBoard.do", new DeleteBoard());
		// 수정
		map.put("/modifyBoard.do", new ModifyBoard());
		map.put("/updateBoard.do", new UpdateBoard());
		// 태그연습
		map.put("/action.do", new ActionControl());
		// 로그인
		map.put("/loginForm.do", new LoginForm()); // 로그인화면 open.
		map.put("/login.do", new LoginControl());
		map.put("/logout.do", new LogoutControl());
		map.put("/memberList.do", new MemberListControl());

		// 자바스크립트 연습하는 페이지 호출.
		map.put("/javascript.do", new ScriptControl());
		// 학생정보를 반환해주는 페이지(json).
		map.put("/studentJson.do", new StudentJson());
		// 학생정보(학번기준) 삭제.
		map.put("/removeStudent.do", new RemoveStudent());
		map.put("/addStudent.do", new addStudent());
		
		// 목록.
		map.put("/replyList.do", new ReplyListControl());
		// 등록.
		map.put("/addReply.do", new AddReplyControl());
		// 삭제.
		map.put("/removeReply.do", new RemoveReplyControl());
		// 페이징을 위한 전체건수.
		map.put("/pagingCount.do", new PagingCount());
		map.put("/imageDownload.do", new ImageDownLoad());
		// 작성자별 게시건수.
		map.put("/countByMember.do", new CntByMember());
		// 차트페이지.
		map.put("/googleChart.do", new GoogleChart());
		
		
		
		
		// fullcalendar 연습.
		map.put("/fullcalendar.do", new FullCalendar());
		// 일정을 등록하는..
		map.put("/addschedule.do", new AddScheduleControl());
		// 일정을 삭제하는..
		map.put("/deleteschedule.do", new DeleteScheduleControl());
		
		
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) //
			throws ServletException, IOException {
//		System.out.println("service() 호출");
		// boardList.do -목록. addBoard.do -등록.
		String uri = req.getRequestURI(); // URL(http://localhost/BoardWeb/boardList.do) vs. URI
		String context = req.getContextPath(); // 프로젝트 명.
		String path = uri.substring(context.length()); // "/boardList.do"

		System.out.println(path); // board.do
		Control sub = map.get(path);
		sub.exec(req, resp);
	}
}
