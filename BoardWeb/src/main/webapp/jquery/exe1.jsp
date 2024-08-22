<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>exe1.jsp</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

<script>

$(document).ready(function() {
	// 이벤트 등록.
	$('#addBtn').on('click', function() {
		// 요소추가.
		let btn = $('<button>삭제</button>').on('click', function(){
			console.log(this);
			$(this).parent().hide(1000);//hide(타이밍) : 화면에서 사라지게 하는 함수 //parent : 상위요소
		}); //btn.
		
		
		let newElem = $('<li />').html($('#userVal').val() + " ")
														.append(btn);
	$('#list').append( newElem );
	
	})
	
	
	// 홀수.list li:first/even
	// 짝수.list li:last/odd
	
	 //3번째 이후
	$('#oddBtn').on('click', function(){
		$('#list li:gt(2)').css('background', 'red');		
	});
	
	//4번째 이전
	$('#evenBtn').on('click', function(){
		$('#list li:lt(3)').css('color', 'blue');		
	});
	
	 //사과4
	$('#containsBtn').on('click', function(){
		$('#list li:contains(사과)').css('background', 'blue');		
	}); 
	
	//span not(:)
	$('#spanBtn').on('click', function(){
		$('#list li:not(:has(span))').css('background', 'blue');		
	});
});

</script>

</head>
<body>
	입력 : <input id="userVal"> <!-- val() -->
	<button id="addBtn">추가</button>
	<!-- <button id="oddBtn">홀수</button>
	<button id="evenBtn">짝수</button> -->
	 <button id="oddBtn">3번째 이후</button>
	<button id="evenBtn">4번째 이전</button>
	<button id="containsBtn">사과4</button>
	<button id="spanBtn">span</button>
	
	<div id="show">
		<ul id="list">
			<li>사과1 <span>span</span><button>삭제</button></li>
			<li>사과2 <button>삭제</button></li>
			<li>사과3 <button>삭제</button></li>
			<li>사과4 <button>삭제</button></li>
			<li>사과5 <button>삭제</button></li>
			<li>사과6 <button>삭제</button></li>
		</ul>
	</div>
	
</body>
</html>