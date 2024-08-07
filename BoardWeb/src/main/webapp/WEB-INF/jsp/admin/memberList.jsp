<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h3>회원목록...</h3>
<ul class="nav nav-pills">
<c:choose>
<c:when test="${res == 'user'}">
	<li class="nav-item"><a class="nav-link active" aria-current="page" href="memberList.do?res=user">사용자</a></li>
	<li class="nav-item"><a class="nav-link" href="memberList.do?res=admin">관리자</a></li>
		</c:when>
		<c:otherwise>
	<li class="nav-item"><a class="nav-link"  href="memberList.do?res=user">사용자</a></li>
	<li class="nav-item"><a class="nav-link active" aria-current="page" href="memberList.do?res=admin">관리자</a></li>
		</c:otherwise>
</c:choose>
</ul>



<table class="table table-dark table-striped">
	<thead>
		<tr>
			<th><a href="memberList.do?order=member_id">아이디</a></th>
			<th>비밀번호</th>
			<th><a href="memberList.do?order=member_nm">이름</a></th>
			<th>권한</th>
		</tr>
	</thead>
	<tbody>


		<c:forEach var="member" items="${memberList }">


			<tr>
				<td>${member.memberId}</td>
				<td>${member.memberPw}</td>
				<td>${member.memberNm}</td>
				<td>${member.responsibility}</td>
			</tr>
		</c:forEach>

	</tbody>

</table>