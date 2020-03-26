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
		
		if( $self.val() != '' && ($self.hasClass('prevDate') || $self.hasClass('laterDate'))){
			var $parentTr = $self.parents('tr');
			var prevDate = new Date( $parentTr.find('.prevDate').val() );
			var laterDate = new Date( $parentTr.find('.laterDate').val() );
			var diff = laterDate - prevDate;
			
			if(diff < 0){
				alert("이전 날짜가 이후 날짜보다 클 수 없습니다.");
				$self.val("").focus();
			}
			if( laterDate){
				
			}
		}
	});

	// 저장버튼 클릭시 이벤트 발생
	$(".saveBtn").click(function(){
		var check = validate();
		
		if(check == false){
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
	
	//불러오기 버튼 클릭시 이벤트 발생
	$('.personalHistoryListBtn').click(function(){
		var $listPannel = $('.pop-user-register-pannel');
		var listPannelVisible = $listPannel.is(':visible');
	
		if(listPannelVisible){
			$listPannel.css("display","none");
			
		}else{
			$listPannel.css("display","block");
			
//			userListPagingView(1);
		}
		
		var param = $('#selectList').serialize();
		$.ajax({
			url : '/topia/userList.do',
			dataType: 'html',
			type: 'POST',
			data: param,
			success: function(data){
//				console.log(data);
				$('#result_div').html(data);
			},error: function(jqXHR, textStatus, errorThrown){
				alert('실패');
			}
		})
		
		
	})
	
});

function validate(){
	var socialNumCheck = /^(?:[0-9]{2}(?:0[1-9]|1[0-2])(?:0[1-9]|[1,2][0-9]|3[0,1]))[1-4][0-9]{6}$/;
	var socialNum = $('#userSocialSecunum').val();
	
//	if(  $('#userName').val().trim()=='' ){
//		alert('이름을 입력해주세요');
//		$('#userName').focus();
//		return false;
//	}
//	if( !socialNumCheck.test(socialNum) ){
//		alert('주민번호를 확인해주세요');
//		 $('#userSocialSecunum').focus();
//		 return false;
//	}
	
	//email과 emailDomain의 합친 값을 userEmail 컬럼에 합쳐서 저장
	if( $('#emailDomain').val() != '1'){
		var userEmail = $('#userEmail').val() + $('#emailDomain').val();
		$('#userEmail').val(userEmail);
	}
	
	return true;
}

function execPostCode(){
	daum.postcode.load(function(){
        new daum.Postcode({
            oncomplete: function(data) {
            	// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('userZipcode').value = data.zonecode;
                document.getElementById("userAddress").value = addr;
//                document.getElementById("userAddress").value += ", ";
                
//                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("userAddress").focus();
//                alert("상세 주소를 입력해 주세요.")
            }
        }).open();
    });
}

//학교 추가버튼 클릭시
var s=1;
function schoolAddBtn(){
	$('#schoolTb').append(
			'<tbody>'
			+ '<tr>'
				+ '<td><input type="text" name="eduList['+ s +'].eduSchoolName" class="eduSchoolName"></td>'
				+ '<td>'
					+ '<select name="eduList['+ s +'].eduStatus" class="eduStatus">'
						+ '<option value="">선택없음</option>'
						+ '<option value="입학">입학</option>'
						+ '<option value="재학">재학</option>'
						+ '<option value="졸업">졸업</option>'
						+ '<option value="졸업예정">졸업예정</option>'
					+ '</select>'
				+ '</td>'
				+ '<td><input type="text" name="eduList['+ s +'].eduYear" placeholder="" class="eduYear"></td>'
				+ '<td>년</td>'
				+ '<td><input type="text" name="eduList['+ s +'].eduMonth" placeholder="" class="eduMonth"></td>'
				+ '<td>월</td>'
				+ '<td><button type="button" class="removeTrBtn" onclick="deleteBtn(this)">-</button></td>'
			+ '</tr>'
		+ '</tbody>'		
	)
	s++;
	flexibleTableTrEve();
	
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
}

//자격증 추가버튼 클릭시 
var q=1;
function qualifiAddBtn(){
	$('#qualifiTb').append(
			'<tbody>'
			+ '<tr>'
				+ '<td><input type="text" name="qualifiList['+ q +'].qualifiName" class="qualifiName"></td>'
				+ '<td><input type="text" name="qualifiList['+ q +'].qualifiGetdate" class="qualifiGetdate dateInput" readonly="readonly"></td>'
				+ '<td><button type="button" class="removeTrBtn" onclick="deleteBtn(this)">-</button></td>'
			+ '</tr>'
		+ '</tbody>'
	)
	q++;
	flexibleTableTrEve();
	
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
}

//회사 추가버튼 클릭시
var c=1;
function careerAddBtn(){
	$('#careerTb').append(
			'<tbody>'
			+ '<tr>'
				+ '<td><input type="text" name="careerList['+ c +'].careerCompName" class="careerCompName"></td>'
				+ '<td><input type="text" name="careerList['+ c +'].careerEnterdate" class="careerEnterdate dateInput prevDate" readonly="readonly"></td>'
				+ '<td><input type="text" name="careerList['+ c +'].careerLeavedate" class="careerLeavedate dateInput laterDate" readonly="readonly"></td>'
				+ '<td><input type="text" name="careerList['+ c +'].careerSpot" class="careerSpot"></td>'
				+ '<td><input type="text" name="careerList['+ c +'].careerResponsib" class="careerResponsib"></td>'
				+ '<td><button type="button" class="removeTrBtn" onclick="deleteBtn(this)">-</button></td>'
			+ '</tr>'
		+ '</tbody>'
	)
	c++;
	flexibleTableTrEve();
	
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
}

//학력,자격증 추가버튼 클릭시
var t=1;
function trainingAddBtn(){
	$('#trainingTb').append(
		+ '<tbody>'
			+ '<tr>'
				+ '<td><input type="text" name="trainList['+ t +'].trainingName" class="trainingName"></td>'
				+ '<td><input type="text" name="trainList['+ t +'].trainingStartdate" class="trainingStartdate dateInput prevDate" readonly="readonly"></td>'
				+ '<td><input type="text" name="trainList['+ t +'].trainingEnddate" class="trainingEnddate dateInput laterDate" readonly="readonly"></td>'
				+ '<td><input type="text" name="trainList['+ t +'].trainingAgency" class="trainingAgency"></td>'
				+ '<td><button type="button" class="removeTrBtn" onclick="deleteBtn(this)">-</button></td>'
			+ '</tr>'
		+ '</tbody>'
	)
	t++;
	flexibleTableTrEve();
	
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
}

//보유기술 추가버튼 클릭시
var l=1;
function licenAddBtn(){
	$('#licenTb').append(
			'<tbody>'
			+ '<tr>'
				+ '<td><input type="text" name="licenList['+ l +'].licenName" class="licenName"></td>'
				+ '<td><input type="text" name="licenList['+ l +'].licenSkillLevel" class="licenSkillLevel"></td>'
				+ '<td><button type="button" class="removeTrBtn" onclick="deleteBtn(this)">-</button></td>'
			+ '</tr>'
		+ '</tbody>'
	)
	l++;
	flexibleTableTrEve();
	
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
}

//스킬 추가버튼 클릭시
var k=1;
function skillAddBtn(){
	$('#skillTb').append(
			'<tbody>'
			+ '<tr>'
				+ '<td><textarea name="skillList['+ k +'].skillProjectName" class="skillProjectName"></textarea></td>'
				+ '<td><input type="text" name="skillList['+ k +'].skillStartdate" class="skillStartdate dateInput prevDate" readonly="readonly"></td>'
				+ '<td><input type="text" name="skillList['+ k +'].skillEnddate" class="skillEnddate dateInput laterDate" readonly="readonly"></td>'
				+ '<td><textarea name="skillList['+ k +'].skillCustomerComp" class="skillCustomerComp"></textarea></td>'
				+ '<td><textarea name="skillList['+ k +'].skillWorkComp" class="skillWorkComp"></textarea></td>'
				+ '<td><textarea name="skillList['+ k +'].skillIndustry" class="skillIndustry"></textarea></td>'
				+ '<td><textarea name="skillList['+ k +'].skillApplied" class="skillApplied"></textarea></td>'
				+ '<td><textarea name="skillList['+ k +'].skillRole" class="skillRole"></textarea></td>'
				+ '<td><textarea name="skillList['+ k +'].skillModel" class="skillModel"></textarea></td>'
				+ '<td><textarea name="skillList['+ k +'].skillOs" class="skillOs"></textarea></td>'
				+ '<td><textarea name="skillList['+ k +'].skillLang" class="skillLang"></textarea></td>'
				+ '<td><textarea name="skillList['+ k +'].skillDbms" class="skillDbms"></textarea></td>'
				+ '<td><textarea name="skillList['+ k +'].skillTool" class="skillTool"></textarea></td>'
				+ '<td><textarea name="skillList['+ k +'].skillComm" class="skillComm"></textarea></td>'
				+ '<td><textarea name="skillList['+ k +'].skillEtc" class="skillEtc"></textarea></td>'
				+ '<td><button type="button" class="removeTrBtn" onclick="deleteBtn(this)">-</button></td>'
			+ '</tr>'
		+ '</tbody>'
	)
	k++;
	flexibleTableTrEve();
	
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
}

// 추가항목 삭제 처리
function deleteBtn(o){
	$(o).parent().parent().remove();
}

var flexibleTableTrEve = function(){
	
	$(".flexibleTable").find("tbody").find("tr").unbind().hover(function(){
		var $trSelf = $(this);
		var $childRemoveBtn = $trSelf.find(".removeTrBtn");
		
		$childRemoveBtn.css("display","block");
	},function(){
		var $trSelf = $(this);
		var $childRemoveBtn = $trSelf.find(".removeTrBtn");
		
		$childRemoveBtn.css("display","none");
	});
	
}
