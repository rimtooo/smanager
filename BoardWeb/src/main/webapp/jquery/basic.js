/**
 * basic.js(0821(1))
 */
 	//jquery.com => 다운 후 js 폴더에 넣기
	//#id .class, jquery 기본문법 : $(선택자).동작함수();




	//document.addEventListener('DOMContentLoaded', function(){
		
		
	$(document).ready(function(){
	// jquery객체 vs. dom 객체.
	let obj = $('.show');
	obj[0].innerHTML = 'Hello'; //js DOM 객체
	obj.eq(0).html('Hello'); //innerHTML과 같음. eq:index값으로 n번째 값을 가져오겠다는 의미.
	obj.eq(1).html('world'); //innerHTML과 같음. eq:index값으로 n번째 값을 가져오겠다는 의미.
	//obj = document.getElementById('show');
	console.log(obj);
	
	// jquery 객체 생성.
	//$('#show').append($('<button />').html('삭제')); // <button>삭제</button>
	$('#show').append($('<button>삭제</button>')); // <button>삭제</button>
	})	
		
		
	//}) //end of document.addEventListener
	
	
	
	
	
	
	//API documentation(예제확인가능)
	//https://www.tcpschool.com/(기초/예제확인가능)