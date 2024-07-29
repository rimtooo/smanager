/**
 * board.js 
 */

console.log('board.js : ' + bno);
let page = 1; // 아래쪽에서 댓글의 페이지를 지정.

// 댓글 등록 버튼에 클릭 이벤트 등록.
document.querySelector('#addReply').addEventListener('click', function() {
	let content = document.querySelector('#content').value;

	if (!replyer || !content) {
		alert('필수 입력 항목을 확인하세요.!');
		return;
	}
	let param = { bno, replyer, content };

	svc.addReply(param, function() {
		// 등록완료 => 화면에 등록된 글 추가.
		let result = JSON.parse(this.responseText);
		console.log(result);

		if (result.retCode == 'Success') {
			//replyList.appendChild(makeRow(result.retVal));
			page = 1;
			showPage();
		}
	});

});

// 댓글 목록 출력.
showPage();
function showPage(){
	
svc.replyList({ bno, page }, function() {
	// 기존 목록을 지우기.
	replyList.querySelectorAll('li').forEach((item, idx)=>{
		if(idx != 0){
			item.remove();
		}
	})
	// 페이지 로드하면서 목록을 출력. //댓글
	let result = JSON.parse(this.response);
	result.forEach(reply => {
		replyList.appendChild(makeRow(reply));
	});
	// 실제 데이터... 출력. //페이징
	svc.pagingCount(bno, createPageList);
});
	
}



// reply => row 생성.
function makeRow(reply = {}) { // 객체 타입임을 표시함.
	let cloned = document.querySelector('div.reply>div.content li').cloneNode(true); //
	cloned.setAttribute('data-rno', reply.replyNo);
	cloned.style.display = 'block'; // <li style={}></li>
	cloned.querySelector('span:nth-of-type(1)').innerText = reply.replyNo;
	cloned.querySelector('span:nth-of-type(2)').innerText = reply.replyContent;
	cloned.querySelector('span:nth-of-type(3)').innerText = reply.replyer;
	cloned.querySelector('button').addEventListener('click', deleteReplyFnc);
	return cloned;
}

// 댓글삭제 이벤트 헨들러.
function deleteReplyFnc(e) {
	let rno = e.target.parentElement.parentElement.dataset.rno; // dataset.rno : data-rno
	svc.removeReply(rno, function(e) {
		let result = JSON.parse(this.response); //
		if (result.retCode == 'Success') {
			alert('삭제 성공');
			//document.querySelector('li[data-rno="' + rno + '"]').remove();
			showPage();
		} else {
			alert('삭제 실패');
		}
	})
}


// 페이지 a태그 생성.
function createPageList(event) {
	let result = JSON.parse(this.responseText);
	let totalCnt = result.totalCount;
	//page = 11;
	let startPage, endPage; // 현재 페이지를 기준으로 계산한 첫 페이지 번호 ~ 마지막 페이지 번호.
	let next, prev; // 이전, 이후 체크하는 변수.
	let realEnd = Math.ceil(totalCnt / 5);

	endPage = Math.ceil(page / 10) * 10;
	startPage = endPage - 9;
	endPage = endPage > realEnd ? realEnd : endPage;

	prev = startPage > 1; // 이전 10개의 페이지를 구분.
	next = endPage < realEnd ? true : false;

	document.querySelector('ul.pagination').innerHTML = ''; // 기존 html 지우기

	// 이전 10페이지 여부.
	let li = document.createElement('li');
	li.className = 'page-item'; // class='page-item active'
	// 이전 페이지의 존재 여부.
	if (prev) {
		let aTag = document.createElement('a');
		aTag.setAttribute('data-page', startPage-1);
		aTag.className = 'page-link';
		aTag.href = '#';
		aTag.innerHTML = 'Previous';
		li.appendChild(aTag);
	} else {
		li.classList.add('disabled'); // li요소의 클래스 추가.
		let span = document.createElement('span');
		span.className = 'page-link';
		span.innerHTML = 'Previous';
		li.appendChild(span);
	}
	document.querySelector('ul.pagination').appendChild(li);


	// 10개 출력.			    
	for (let p = startPage; p <= endPage; p++) {
		let li = document.createElement('li');
		li.className = 'page-item'; // class='page-item active'
		if (page == p) {
			li.classList.add('active');
			let span = document.createElement('span');
			span.className = 'page-link';
			span.innerHTML = p;
			li.appendChild(span);

		} else {
			let aTag = document.createElement('a');
					aTag.setAttribute('data-page', p);
			aTag.className = 'page-link';
			aTag.href = '#';
			aTag.innerHTML = p;
			li.appendChild(aTag);
		}
		document.querySelector('ul.pagination').appendChild(li);
	}


	// 이후 페이지의 존재 여부.
	li = document.createElement('li');
	li.className = 'page-item'; // class='page-item active'
	// 이후 페이지의 존재 여부.
	if (next) {
		//let li = document.createElement('li');
		let aTag = document.createElement('a');
				aTag.setAttribute('data-page', endPage+1);
		aTag.className = 'page-link';
		aTag.href = '#';
		aTag.innerHTML = 'Next';
		li.appendChild(aTag);
	} else {
		li.classList.add('disabled'); // li태그의 스타일을 비활성화.
		let span = document.createElement('span');
		span.className = 'page-link';
		span.innerHTML = 'Next';
		li.appendChild(span);
	}
	document.querySelector('ul.pagination').appendChild(li);

	// a태그의 이벤트 등록.
	pageMove();
} //end of createPageList.


// paging영역의 a 태그를 클릭하면....
function pageMove() {

	document.querySelectorAll('div.reply ul.pagination a')//
		.forEach(item => {
			item.addEventListener('click', function(e) {
				page = item.dataset.page; // Previous, Next
				// service에서 목록을 출력하는 메소드 호출.
					showPage();
					});
					});
		
}//end of pageMove.