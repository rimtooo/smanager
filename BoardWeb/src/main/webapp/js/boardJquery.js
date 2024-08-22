/**
 * boardJquery.js
 * jquery 용 Ajax 사용.
 */
/*console.log('jquery start');


$(document).ready(function(){
	console.log('test')
	
	// 등록버튼에 이벤트.
		$('#addReply').on('click', function() {
			console.log('test')
			$.ajax({
				url: 'addReply.do',
				data: {bno : bno, replyer: replyer, content: $('#content').val()},
				dataType: 'json',
				success: function(result){
					
				}
			})
	})
})


function makeRow(elem = {}){
	let temp = $('#replyList li:eq(0)').clone();
			temp.attr('data-rno', elem.replyNo);
			temp.css('display', 'block')
			temp.find('span:eq(0)').html(elem.replyNo);
			temp.find('span').eq(1).html(elem.replyContent);
			temp.find('span').eq(2).html(elem.replyer);

			// 버튼생성을 새로...
			let btn = $('<button>삭제1</button>').on('click', deleteRow)
			temp.find('span').eq(3).html(btn);
			
			return temp;
}

let page = 1;

$.ajax({
	url: 'replyList.do', // 서버url 호출
	data: { bno: bno, page: page },// 서버에 전달한 parameter.(앞:속성/뒤:값)
	dataType: 'json', // 서버로 전달받은 content 타입.
	success: function(result) {
		console.log(result);
		$.each(result, function(i, elem) {
			console.log("여기=>", i, elem);
			
			$('#replyList').append(makeRow(elem));
		})
	},
	error: function(err) {
		console.error(err);
	}
});//$.ajax




function deleteRow() {
	// 삭제 ajax.
	let li = $(this).parent().parent();
	let rno = li.data('rno');
	$.ajax({
		url: 'removeReply.do',
		data: { rno: rno },
		dataType: 'json',
		success: function(result) {
			console.log(result)
			if (result.retCode == 'Success') {
				li.remove();
			} else {
				alert('처리중 예외 발생.')
			}
		},
		error: function() {
			console.log(err)
		}
	});
	$(this).parent().parent().remove(); //fadeOut이나 hide는 안보이게, remove()는 지움.
}*/// end of deleteRow.


/**
 
boardJquery.js
*/
console.log('jquery start');


let page = 1;

$.ajax({
	url: 'replyList.do', //서버url 호출
	data: { bno: bno, page: page }, //서버에 전달한 parameter.
	dataType: 'json', //서버러 전달받은 content 타입. 
	success: function(result) {
		console.log(result);
		$.each(result, function(i, elem) {
			console.log("요기=>", i, elem);
			let temp = $('#replyList li:eq(0)').clone();
			temp.attr('data-rno', elem.replyNo);
			temp.css('display', 'block'); //속성(attribute) 변경.
			temp.find('span:eq(0)').html(elem.replyNo);
			temp.find('span').eq(1).html(elem.replyContent);
			temp.find('span').eq(2).html(elem.replyer);

			let btn = $('<button>삭제</button>').on('click', deleteRow)

			temp.find('span').eq(3).html(btn);
			$('#replyList').append(temp);
		})
	},
	error: function(err) {
		console.error(err);
	}
}); // $.ajax

function deleteRow() {
	//삭제 ajax
	let li = $(this).parent().parent();
	let rno = li.data('rno');
	$.ajax({
		url: 'removeReply.do',
		data: { rno: rno },
		dataType: 'json',
		success: function(result) {
			console.log(result);
			if (result.retCode == 'Success') {
				li.remove();
			} else {
				alert('처리중 예외발생.');
			}
		},
		error: function(err) {
			console.error(err);
		}
	});
} // end of deleteRow

$('#addReply').on('click', function() {

	$.ajax({

		url: 'addReply.do',
		data: { replyer: replyer, content: $('#content').val(), bno: bno },
		dataType: 'json',
		success: function(result) {
			console.log(result);
			console.log(result.retVal);
			makerow(result.retVal)
			$('#replyList').prepend(makerow(result.retVal));

		},
		error: function(err) {
			console.error(err);
		}
	})

});


function makerow(elem) {

	let temp = $('#replyList li:eq(0)').clone();
	temp.attr('data-rno', elem.replyNo);
	temp.css('display', 'block'); //속성(attribute) 변경.
	temp.find('span:eq(0)').html(elem.replyNo);
	temp.find('span').eq(1).html(elem.replyContent);
	temp.find('span').eq(2).html(elem.replyer);

	let btn = $('<button>삭제</button>').on('click', deleteRow)

	temp.find('span').eq(3).html(btn);

	return temp;
}

//W3schools todolist 검색(과제)