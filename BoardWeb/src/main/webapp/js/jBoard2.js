/**
 * jBoard.js
 */
console.log('jBoard.js START')

$(function() {
    let page = 1;

    // 댓글 목록
    function showPage() {
        $.ajax({
            url: 'replyList.do',
            data: { bno: bno, page: page },
            dataType: 'json',
            success: function(result) {
                $('#replyList li:not(:first)').remove();  // 기존 목록 제거

                // 새로운 댓글 목록 추가
                $.each(result, function(idx, reply) {
                    $('#replyList').append(makeRow(reply));
                });

                // 페이징 처리 호출
                pagingCount();
            },
            error: function(error) {
                console.error("댓글 목록을 불러오는 중 오류 발생", error);
            }
        });
    }

    // 댓글 표시
    function makeRow(reply) {
        let cloned = $('#replyList li:first').clone();  
        cloned.show();  
        cloned.attr('data-rno', reply.replyNo);
        cloned.find('span:nth-child(1)').text(reply.replyNo);
        cloned.find('span:nth-child(2)').text(reply.replyContent);
        cloned.find('span:nth-child(3)').text(reply.replyer);
        cloned.find('button').on('click', deleteReplyFnc); 
        return cloned;
    }
		// 댓글 등록
		$('#addReply').on('click', function() {
    let content = $('#content').val();

    if (!replyer || !content) {
        alert('필수입력항목을 입력하세요.');
        return;
    }

    $.ajax({
        url: 'addReply.do',
        type: 'POST',
        data: { bno: bno, content: content, replyer: replyer },
        dataType: 'json',
        success: function(result) {
            if (result.retCode === 'Success') {
                showPage();  // 댓글 목록 갱신
                $('#content').val('');  // 입력 창 초기화
            } else {
                alert('댓글 등록에 실패했습니다.');
            }
        },
        error: function(error) {
            console.error("댓글 등록 중 오류 발생", error);
        }
    });
});

    // 댓글 삭제
    function deleteReplyFnc(e) {
        let rno = $(e.target).closest('li').data('rno');  // 클릭한 댓글의 rno 가져오기

        $.ajax({
            url: 'removeReply.do',
            type: 'POST',
            data: { rno: rno },
            dataType: 'json',
            success: function(result) {
                if (result.retCode === 'Success') {
                    alert('댓글이 삭제되었습니다.');
                    showPage();  // 댓글 목록 갱신
                } else {
                    alert('댓글 삭제에 실패했습니다.');
                }
            },
            error: function(error) {
                console.error("댓글 삭제 중 오류 발생", error);
            }
        });
    }

    // 페이징 처리 함수
    function pagingCount() {
        $.ajax({
            url: 'pagingCount.do',  // 페이징 처리 URL
            data: { bno: bno },
            dataType: 'json',
            success: function(result) {
                let totalCnt = result.totalCount;
                let realEnd = Math.ceil(totalCnt / 5);
                let startPage = Math.floor((page - 1) / 10) * 10 + 1;
                let endPage = startPage + 9 > realEnd ? realEnd : startPage + 9;

                let pagination = $('.pagination');
                pagination.empty();

                if (startPage > 1) {
                    pagination.append('<li class="page-item"><a class="page-link" href="#" data-page="' + (startPage - 1) + '">Previous</a></li>');
                }

                for (let p = startPage; p <= endPage; p++) {
                    let activeClass = page == p ? 'active' : '';
                    pagination.append('<li class="page-item ' + activeClass + '"><a class="page-link" href="#" data-page="' + p + '">' + p + '</a></li>');
                }

                if (endPage < realEnd) {
                    pagination.append('<li class="page-item"><a class="page-link" href="#" data-page="' + (endPage + 1) + '">Next</a></li>');
                }

                // 페이지 이동 이벤트 연결
                $('.pagination a').on('click', function(e) {
                    e.preventDefault();
                    page = $(this).data('page');
                    showPage();
                });
            },
            error: function(error) {
                console.error("페이징 처리 중 오류 발생", error);
            }
        });
    }

    // 페이지 로드 시 댓글 목록 및 페이징 처리 호출
    showPage();
});