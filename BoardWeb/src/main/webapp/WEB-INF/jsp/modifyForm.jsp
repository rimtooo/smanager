<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file = "../includes/header.jsp" %>

	<h3>수정화면(modifyForm.jsp)</h3>
	<% BoardVO board = (BoardVO) request.getAttribute("board"); %>
	<form action="updateBoard.do">
	<input type="hidden" name="bno" value="<%=board.getBoardNo() %>">
    <table class="table">
        <tr>
            <th class="col-sm-3">글번호</th>
            <td><%=board.getBoardNo() %></td>
            <th class="col-sm-3">조회수</th>
            <td><%=board.getViewCnt() %></td>
            <td></td>
        </tr>
        <tr>
            <th>제목</th>
            <td><input class="form-control" type="text" name="title" value="<%=board.getTitle() %>"></td>
        </tr>
        <tr>
            <th>내용</th>
            <td><textarea class="form-control" name="content"><%=board.getContent() %></textarea></td>
        </tr>
        <tr>
            <th>작성자</th>
            <td colspan="3"><%=board.getWriter() %></td>
        </tr>
        <tr>
            <td colspan="4" align="center">
						<button class="btn btn-danger" type="button">삭제</button>
            <input class="btn btn-warning" type="submit" value="수정">
						</td>
        </tr>
    </table>
	</form>
<%@ include file="../includes/footer.jsp" %>