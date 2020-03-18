"use strict"; // 엄격한 문법 검사

$(document).ready(function(){
	$('.dateInput').datepicker({
        yearSuffix: "년",			//달력의 년도 부분 뒤에 붙는 텍스트
        monthNamesShort: ['1','2','3','4','5','6','7','8','9','10','11','12'],	//달력의 월 부분 텍스트
        showMonthAfterYear:true, 	//년도 먼저 나오고, 뒤에 월 표시
        changeYear: true,			//콤보박스에서 년 선택 가능
        changeMonth: true,			//콤보박스에서 월 선택 가능                              
		monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
		dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
		dateFormat: 'yy-mm-dd'
	});
	
	//짝 지어진 날짜 정보와 비교
	$('.dateInput').change(function(){
		var $self = $(this);
		var val = $self.val();
		
		if( !isEmpty(val) && ($self.hasClass('prevDate') || $self.hasClass('laterDate'))){
			var $parentTr = $self.parents('tr');
			var prevDate = $parentTr.find('.prevDate').val();
			var laterDate = $parentTr.find('.laterDate').val();
			
			var diff = dateDiff(prevDate, laterDate);
		}
	});
		
	
// 저장버튼 클릭시 이벤트 발생
	$(".saveBtn").click(function(){
		var socialNumCheck = /^(?:[0-9]{2}(?:0[1-9]|1[0-2])(?:0[1-9]|[1,2][0-9]|3[0,1]))[1-4][0-9]{6}$/;
		var socialNum = $('[name=userSocialSecunum]').val();
		
		if( !socialNumCheck.test(socialNum) ){
			alert('주민번호를 확인해주세요');
			 $('[name=userSocialSecunum]').focus();
			 return;
		}
		var $frm = $('.userInsert :input');
		var param = $frm.serialize();

		$.ajax({
			url : "/topia/userInsert.do",
			dataType: "json",
			type: "POST",
			data : param,
			success: function(data, textStatus, jqXHR)
			{
				alert("등록완료");
				
				location.href = "/topia.do";
			},
			error: function (jqXHR, textStatus, errorThrown)
			{
				alert("실패");
			}
		});
	});
	
	
});