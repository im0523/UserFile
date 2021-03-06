"use strict"; // 엄격한 문법 검사

$(document).ready(function(){
	// ThumbNail 사진 upload시 image 보이게
	$('.attach-file').on('change', handleImgFileSelect);

	//delete-file 버튼 눌렀을 시 thumbNail 삭제
	$('#delete-file').click(function(){
		$('#userFilepathReal').val('');
		$('#img').attr('src', null);
		$('#img').css('display', 'none');
		$('#thumbNail').css('display', 'block');
		$('#thumbNail').css('padding-left', '20px');
		$('#delete-file').css('display', 'none');
		$('#deleteImg').val('0');
	});
	
	
	//datepicker 설정
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
		
//		var $frm = $('.userInsert :input');
//		var param = $frm.serialize();
		var form = new FormData(document.getElementById('userInsertForm'));

		if( $('#status').val()=='select'){
			$.ajax({
				url : "/topia/userInsert.do",
				enctype : 'multipart/form-data',
				dataType: "json",
				processData: false, 
				contentType: false,
				type: "POST",
				data : form,
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
		}else{
			$.ajax({
				url: '/topia/userUpdate.do',
				enctype: 'multipart/form-data',
				dataType: 'json',
				processData: false,
				contentType: false,
				type: 'post',
				data : form,
				success: function(data, textStatus, jqXHR){
					alert('수정 완료');
					location.href = "/topia.do";
				},error: function (data){
					alert("실패");
				}
			});
		}
	});
	
	//불러오기 버튼 클릭시 이벤트 발생
	$('.personalHistoryListBtn, #userListSearchBtn').click(function(){
		var $listPannel = $('.pop-user-register-pannel');
		var listPannelVisible = $listPannel.is(':visible');
		
		$listPannel.css("display","block");
		
//		$('[name=searchKeyword').val( $('.keyword-text').html() );
//		alert( $('[name=searchKeyword').val() );

		// 개발환경 검색조건
		var list = new Array();
		
		$('.keyword-text').each(function(index, item){
			list.push($(item).html());	//각각의 span 태그에 들어있는 값을 list라는 배열에 담고
		})

		$("#searchKeyword").val(list);	//hidden으로 들어있는 input 태그에 배열 형식으로 list 값을 담는다		ex) {java, oracle, linux}
		
		
		
		var param = $('#selectList').serialize();
		$.ajax({
			url : '/topia/userList.do',
			dataType: 'html',
			type: 'POST',
			data: param,
			success: function(data){
				console.log(data);
				$('#result_div').html(data);
				$('[name=curPage]').val('1');	//검색 버튼 눌렀을 시, 1페이지로 초기화
				$('#userInfoCnt').text($('#totalCnt').val());
				$("#groupListDate").val("");
				
			},error: function(jqXHR, textStatus, errorThrown){
				alert('실패');
			}
		})
	})
	
	// 불러오기 창에서 연차별 인원보기 버튼 이벤트
	$('#getUserCountByCareerDate').click(function(){
		$.ajax({
			url: '/topia/groupList.do',
			dataType: 'html',
			type: 'post',
			data: {},
			success: function(data){
				$('#result_div').html(data);
			},error: function(jqXHR, textStatus, errorThrown){
				alert('실패');
			}
		})
	})
	
	// 키워드 추가 버튼 클릭 이벤트
	$('.keywordAddBtn').click(function(){
		var $keywordInputPannel = $('.keywordInputPannel');
		if(!$keywordInputPannel.is(':visible')){
			$keywordInputPannel.removeClass('keyword-input-pannel-invisible');
			$keywordInputPannel.addClass('keyword-input-pannel-visible');
			$('.keywordInputPannel').find('input').val('');
			$('.keywordInputPannel').find('input').focus();
		}
	});

	// 키워드 추가 버튼에서 엔터시 blur
	$('.keywordInputPannel').find('input').keydown(function(key) {
		if (key.keyCode == 13) {
			$(this).blur();
		}
	});
	
	// 키워드 추가 input에 blur 이벤트 발생 시 
	// 입력한 내용을 검색 키워드로 추가
	$('.keywordInputPannel').find('input').blur(function(){
		var $keywordInputPannel = $('.keywordInputPannel');
		var $inputSelf = $(this);
		
		var val = $inputSelf.val();
		
		$keywordInputPannel.removeClass('keyword-input-pannel-visible');
		$keywordInputPannel.addClass('keyword-input-pannel-invisible');

		if( val.trim() != '' ){
			var beforeText = '';
			
			beforeText += '<div class="keyword-body">#';
			beforeText += '<span class="keyword-text">';
			beforeText += val;
			beforeText += '</span><button type="button" class="keyword-remove-btn keywordRemoveBtn"><span>X</span></button></div>';
			
			$keywordInputPannel.before(beforeText);
			$inputSelf.val('');
		}
	})
	
	// 키워드 삭제 버튼
	$(document).on('click','.keywordRemoveBtn',function(){
		$(this).parent().remove();
	});
	
	// 불러오기 창이 띄워진 상태에서 ㅡ 버튼 눌렀을때 불러오기 창 닫는 이벤트
	$('.minimizeUserPannelBtn').click(function(){
		var $listPannel = $('.pop-user-register-pannel');
		var listPannelVisible = $listPannel.is(':visible');
			
		$listPannel.css("display","none");
	})
	
});

function validate(){
	var socialNumCheck = /^(?:[0-9]{2}(?:0[1-9]|1[0-2])(?:0[1-9]|[1,2][0-9]|3[0,1]))[1-4][0-9]{6}$/;
	var socialNum = $('#userSocialSecunum').val();
	
	if(  $('#userName').val().trim()=='' ){
		alert('이름을 입력해주세요');
		$('#userName').focus();
		return false;
	}
//	if( !socialNumCheck.test(socialNum) ){
//		alert('주민번호를 확인해주세요');
//		 $('#userSocialSecunum').focus();
//		 return false;
//	}
	
	//email과 emailDomain의 합친 값을 userEmail 컬럼에 합쳐서 저장
	if( $('#emailDomain').val() != '1' && $('#emailDomain').val() != '' ){
		var userEmail = $('#userEmail').val() + $('#emailDomain').val();
		$('[name=userEmail]').val(userEmail);
	}else{
		$('[name=userEmail]').val( $('#userEmail').val() );
	}
	
	// 전화번호 정규식 체크 후, false면 저장되지 않게
//	var phoneCheck = phoneValidate();
//	if( phoneCheck == false ){
//		return;
//	}
	
	return true;
}

//전화번호 정규식
function phoneValidate(obj){
	var number = obj.value.replace(/[^0-9]/g, '');
	var phone = '';
	
	if(number.length < 4) {
        return number;
    } else if(number.length < 7) {
        phone += number.substr(0, 3);
        phone += "-";
        phone += number.substr(3);
    } else if(number.length < 11) {
        phone += number.substr(0, 3);
        phone += "-";
        phone += number.substr(3, 3);
        phone += "-";
        phone += number.substr(6);
    } else {
        phone += number.substr(0, 3);
        phone += "-";
        phone += number.substr(3, 4);
        phone += "-";
        phone += number.substr(7);
    }
    obj.value = phone;
    
    return true;
}

//유선전화 정규식
function telValidate(obj){
	var number = obj.value.replace(/[^0-9]/g, '');
	var tel = '';

	    // 서울 지역번호(02)가 들어오는 경우
	    if(number.substring(0, 2).indexOf('02') == 0) {
	        if(number.length < 3) {
	            return number;
	        } else if(number.length < 6) {
	            tel += number.substr(0, 2);
	            tel += "-";
	            tel += number.substr(2);
	        } else if(number.length < 10) {
	            tel += number.substr(0, 2);
	            tel += "-";
	            tel += number.substr(2, 3);
	            tel += "-";
	            tel += number.substr(5);
	        } else {
	            tel += number.substr(0, 2);
	            tel += "-";
	            tel += number.substr(2, 4);
	            tel += "-";
	            tel += number.substr(6);
	        }
	    
	    // 서울 지역번호(02)가 아닌경우 / 휴대폰 전화번호일 경우
	    } else {
	        if(number.length < 4) {
	            return number;
	        } else if(number.length < 7) {
	            tel += number.substr(0, 3);
	            tel += "-";
	            tel += number.substr(3);
	        } else if(number.length < 11) {
	            tel += number.substr(0, 3);
	            tel += "-";
	            tel += number.substr(3, 3);
	            tel += "-";
	            tel += number.substr(6);
	        } else {
	            tel += number.substr(0, 3);
	            tel += "-";
	            tel += number.substr(3, 4);
	            tel += "-";
	            tel += number.substr(7);
	        }
	    }

	    obj.value = tel;
    
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
function schoolAddBtn(){
	$('#schoolTb').find('.removeTrBtn:first-child').parent().css('display', 'block');	//첫번째 remove 버튼이 다시 보이게
	var s = $('#eduIdx').val();
	
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
	$('#eduIdx').val(s);
//	if( s != 1 ){	// 만약 행이 1줄이 아닐 경우
		
//	}
	
	flexibleTableTrEve();
	datepicker();
}

//자격증 추가버튼 클릭시 
function qualifiAddBtn(){
	var q = $('#qualifiIdx').val();
	
	$('#qualifiTb').append(
			'<tbody>'
			+ '<tr>'
				+ '<td>'
					+ '<select name="qualifiList['+ q +'].qualifiName" class="qualifiName">'
						+ '<option value="" selected="selected">선택없음</option>'
						+ '<option value="정보처리기능사">정보처리기능사</option>'
						+ '<option value="정보처리산업기사">정보처리산업기사</option>'
						+ '<option value="정보처리기사">정보처리기사</option>'
					+ '</select>'
				+ '</td>'
				+ '<td><input type="text" name="qualifiList['+ q +'].qualifiGetdate" class="qualifiGetdate dateInput" readonly="readonly"></td>'
				+ '<td><button type="button" class="removeTrBtn" onclick="deleteBtn(this)">-</button></td>'
			+ '</tr>'
		+ '</tbody>'
	)
	q++;
	$('#qualifiIdx').val(q);
	if( q != 1 ){	// 만약 행이 1줄이 아닐 경우
		$('#qualifiTb').find('.removeTrBtn:first-child').parent().css('display', 'block');	//첫번째 remove 버튼이 다시 보이게
	}
	
	flexibleTableTrEve();
	datepicker();
}

//회사 추가버튼 클릭시
function careerAddBtn(){
	var c = $('#careerIdx').val();
	
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
	$('#careerIdx').val(c);
	if( c != 1 ){	// 만약 행이 1줄이 아닐 경우
		$('#careerTb').find('.removeTrBtn:first-child').parent().css('display', 'block');	//첫번째 remove 버튼이 다시 보이게
	}
	
	flexibleTableTrEve();
	datepicker();
}

//학력,자격증 추가버튼 클릭시
function trainingAddBtn(){
	var t = $('#trainingIdx').val();
	
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
	$('#trainingIdx').val(t);
	if( t != 1 ){	// 만약 행이 1줄이 아닐 경우
		$('#trainingTb').find('.removeTrBtn:first-child').parent().css('display', 'block');	//첫번째 remove 버튼이 다시 보이게
	}
	
	flexibleTableTrEve();
	datepicker();
}

//보유기술 추가버튼 클릭시
function licenAddBtn(){
	var l = $('#licenIdx').val();
	
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
	$('#licenIdx').val(l);
	if( l != 1 ){	// 만약 행이 1줄이 아닐 경우
		$('#licenTb').find('.removeTrBtn:first-child').parent().css('display', 'block');	//첫번째 remove 버튼이 다시 보이게
	}

	flexibleTableTrEve();
	datepicker();
}

//스킬 추가버튼 클릭시
function skillAddBtn(){
	var k = $('#skillIdx').val();
	
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
	$('#skillIdx').val(k);
	if( k != 1 ){	// 만약 행이 1줄이 아닐 경우
		$('#skillTb').find('.removeTrBtn:first-child').parent().css('display', 'block');	//첫번째 remove 버튼이 다시 보이게
	}
	
	flexibleTableTrEve();
	datepicker();
}

// 추가항목 삭제 처리
function deleteBtn(o){
	var tableName = $(o).closest('table').attr('tb')+'Idx';
	var idx = $('#'+tableName).val()-1;
	
	$('#'+tableName).val(idx);
	
	if( $('#'+tableName).val() == 1 ){	// 만약 행이 1줄일 경우에는
		$(o).closest('table').find('.removeTrBtn:first-child').parent().css('display', 'none');	//첫번째 - 버튼은 나타나지 않게
	}
	
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

// 불러오기 한 사람의 profile detail 뿌리기
function go_detail(userIdx){
	//기존에 불러왔던 데이터를 초기화
	resetInput();
	
	var $listPannel = $('.pop-user-register-pannel');
	var listPannelVisible = $listPannel.is(':visible');
	
	$.ajax({
		url: '/topia/userDetail.do',
		dataType: 'json',
		type: 'POST',
		data: {userIdx : userIdx},
		success: function(data){
// 			console.log(data.userInfo.userName);
			fnUserInfo(data.userInfo);		//userInfo → Controller에서 지정한 map의 Key명
			fnUserEdu(data.userEduList);		//userEduList → Controller에서 지정한 map의 Key명
			fnUserQualifi(data.userQualifiList);
			fnUserCareer(data.userCareerList);
			fnUserTraining(data.userTrainingList);
			fnUserLicen(data.userLicenList);
			fnUserSkill(data.userSkillList);
			
			$('#status').val('update');
			$('.status-display-pannel').find('h5').text('등록번호 : '+data.userInfo.userIdx);
			$listPannel.css("display","none");

		},error: function(req, status){
			alert('실패');
		}
	})
}

//불러오기 후 userInfo 상세정보 뿌리기
function fnUserInfo(userInfo){
	var fullEmail = userInfo.userEmail;
	
	$('[name=curPage]').val('1');	//상세정보 뿌렸을 때, 1페이지로 초기화
	
	if( userInfo.userFilepath != null ){
		$('#thumbNail').css('display', 'none');
		$('#img').css('display', 'block');
		$('#img').attr('src', 'resources/'+userInfo.userFilepath);
		$('#delete-file').css('display', 'block');
		$('#deleteImg').val('1');
	}else{
		$('#thumbNail').css('display', 'block');
		$('#thumbNail').css('padding-left', '20px');
		$('#img').css('display', 'none');
		$('#deleteImg').val('0');
	}
	
	$('#userIdx').val(userInfo.userIdx); 
	$('#userName').val(userInfo.userName);
	$('#userSocialSecunum').val(userInfo.userSocialSecunum);
	$('#userSex').val(userInfo.userSex);
	$('#userComp').val(userInfo.userComp);
	$('#userCompEnterdate').val(userInfo.userCompEnterdate);
	$('#userDept').val(userInfo.userDept);
	$('#userSpot').val(userInfo.userSpot);
	$('#userArmyServ').val(userInfo.userArmyServ);
	$('#userMaritalStatus').val(userInfo.userMaritalStatus);
	$('#userArmyServEnter').val(userInfo.userArmyServEnter);
	$('#userArmyServLeave').val(userInfo.userArmyServLeave);
	$('#userArmyServPeriod').val(userInfo.userArmyServPeriod);
	$('#userTelnumWireless').val(userInfo.userTelnumWireless);
	$('#userArmyServPeriod').val(userInfo.userArmyServPeriod);
	
	//email이 null이 아닐때 @를 기준으로 나누고
	if( fullEmail != null ){
		var email = fullEmail.split('@');
		
		$('#userEmail').val(email[0]);
		$('#emailDomain').val('@'+email[1]);
	//null일 경우에는 공백으로 출력
	}else {
		$('#userEmail').val('');
	}
	$('#userZipcode').val(userInfo.userZipcode);
	$('#userAddress').val(userInfo.userAddress);
	
	//이메일을 직접입력 했을 경우
	if( $('#emailDomain').val() == null ){
		$('#emailDomain').val('');		//emailDomain값을 '직접입력'으로 만들고
		$('#userEmail').val(fullEmail);	//userEmail 값에 fullEmail 값을 담는다
	}
}

//불러오기 후 userEdu 상세정보 뿌리기
function fnUserEdu(userEduList){
	var eduTable = $('#schoolTb');
	var html = '';

	for(var i=0; i<userEduList.length; i++){
		html += '<tr>'
						+ '<td><input type="text" name="eduList['+ i +'].eduSchoolName" class="eduSchoolName" value="'+ userEduList[i].eduSchoolName +'"></td>'
						+ '<td>'
							+ '<select name="eduList['+ i +'].eduStatus" class="eduStatus">'
								+ '<option value="">선택없음</option>'
								+ '<option value="입학">입학</option>'
								+ '<option value="재학">재학</option>'
								+ '<option value="졸업">졸업</option>'
								+ '<option value="졸업예정">졸업예정</option>'
							+ '</select>'
						+ '</td>'
						+ '<td><input type="text" name="eduList['+ i +'].eduYear" placeholder="" class="eduYear" value="'+ userEduList[i].eduYear +'"></td>'
						+ '<td>년</td>'
						+ '<td><input type="text" name="eduList['+ i +'].eduMonth" placeholder="" class="eduMonth" value="'+ userEduList[i].eduMonth +'"></td>'
						+ '<td>월</td>'
						+ '<td><button type="button" class="removeTrBtn" id="removeTrBtn-e'+ i +'" onclick="deleteBtn(this)">-</button></td>'
						+ '</tr>';
		eduTable.find('tbody').html(html);
		eduTable.find('input').each(function(){
			if( $(this).val()== 'null' ){
				$(this).val('');
			}
		});
	}
	
	if( userEduList.length <= 1 ){
		$('#eduIdx').val('1');	// 행추가 할 때를 위해 input value를 바꿔 놓는 처리
		eduTable.find('.removeTrBtn:first-child').parent().css('display', 'none');	//첫번째 - 버튼은 나타나지 않게
		
	}else{
		$('#eduIdx').val(i);	// 행추가 할 때를 위해 input value를 바꿔 놓는 처리
	}
	
	//userEduList의 졸업상태를 DB에서 가져와 selected 설정하는 처리
	for(var e=0; e<userEduList.length; e++){
		$('select[name="eduList['+ e +'].eduStatus"]').val(userEduList[e].eduStatus).prop('selected', true);
	}
	flexibleTableTrEve();		// 추가된 remove 버튼에 이벤트 할당
	
}

//불러오기 후 userQualifi 상세정보 뿌리기
function fnUserQualifi(userQualifiList){
	var quTable = $('#qualifiTb');
	var html = '';
	
	for(var i=0; i<userQualifiList.length; i++){
		html += '<tr>'
				+ '<td>'
				+ '<select name="qualifiList['+ i +'].qualifiName" class="qualifiName">'
					+ '<option value="">선택없음</option>'
					+ '<option value="정보처리기능사">정보처리기능사</option>'
					+ '<option value="정보처리산업기사">정보처리산업기사</option>'
					+ '<option value="정보처리기사">정보처리기사</option>'
				+ '</select>'
				+ '</td>'

				+ '<td><input type="text" name="qualifiList['+ i +'].qualifiGetdate" class="qualifiGetdate dateInput" readonly="readonly" value="'+ userQualifiList[i].qualifiGetdate +'"></td>'
				+ '<td><button type="button" class="removeTrBtn" id="removeTrBtn-q'+ i +'" onclick="deleteBtn(this)">-</button></td>'
			+ '</tr>';
		quTable.find('tbody').html(html);
	}
	
	if( userQualifiList.length <= 1 ){
		$('#qualifiIdx').val('1');	// 행추가 할 때를 위해 input value를 바꿔 놓는 처리
		quTable.find('.removeTrBtn:first-child').parent().css('display', 'none');	//첫번째 - 버튼은 나타나지 않게
	}else{
		$('#qualifiIdx').val(i);	// 행추가 할 때를 위해 input value를 바꿔 놓는 처리
	}
	
	quTable.find('input').each(function(){
		if( $(this).val()== 'null' ){
			$(this).val('');
		}
	});
	//userQualifiList의 자격증 명을 DB에서 가져와 selected 설정하는 처리
	for(var q=0; q<userQualifiList.length; q++){
		$('select[name="qualifiList['+ q +'].qualifiName"]').val(userQualifiList[q].qualifiName).prop('selected', true);
	}
	datepicker();
	flexibleTableTrEve();		// 추가된 remove 버튼에 이벤트 할당
}

//불러오기 후 userCareer 상세정보 뿌리기
function fnUserCareer(userCareerList){
	var caTable = $('#careerTb');
	var html = '';

	for(var i=0; i<userCareerList.length; i++){
		html += '<tr>'
				+ '<td><input type="text" name="careerList['+ i +'].careerCompName" class="careerCompName" value="'+ userCareerList[i].careerCompName +'"></td>'
				+ '<td><input type="text" name="careerList['+ i +'].careerEnterdate" class="careerEnterdate dateInput prevDate" readonly="readonly" value="'+ userCareerList[i].careerEnterdate +'"></td>'
				+ '<td><input type="text" name="careerList['+ i +'].careerLeavedate" class="careerLeavedate dateInput laterDate" readonly="readonly" value="'+ userCareerList[i].careerLeavedate +'"></td>'
				+ '<td><input type="text" name="careerList['+ i +'].careerSpot" class="careerSpot" value="'+ userCareerList[i].careerSpot +'"></td>'
				+ '<td><input type="text" name="careerList['+ i +'].careerResponsib" class="careerResponsib" value="'+ userCareerList[i].careerResponsib +'"></td>'
				+ '<td><button type="button" class="removeTrBtn" id="removeTrBtn-c'+ i +'" onclick="deleteBtn(this)">-</button></td>'
			+ '</tr>';
		caTable.find('tbody').html(html);
	}
	
	if( userCareerList.length <= 1 ){
		$('#careerIdx').val('1');	// 행추가 할 때를 위해 input value를 바꿔 놓는 처리
		caTable.find('.removeTrBtn:first-child').parent().css('display', 'none');	//첫번째 - 버튼은 나타나지 않게
	}else{
		$('#careerIdx').val(i);	// 행추가 할 때를 위해 input value를 바꿔 놓는 처리
	}
	
	caTable.find('input').each(function(){
		if( $(this).val()== 'null' ){
			$(this).val('');
		}
	});
	datepicker();
	flexibleTableTrEve();		// 추가된 remove 버튼에 이벤트 할당
}

//불러오기 후 userLicen 상세정보 뿌리기
function fnUserLicen(userLicenList){
	var licenTable = $('#licenTb');
	var html = '';
	
	for(var i=0; i<userLicenList.length; i++){
		html += '<tr>'
					+ '<td><input type="text" name="licenList['+ i +'].licenName" class="licenName" value="'+ userLicenList[i].licenName +'"></td>'
					+ '<td><input type="text" name="licenList['+ i +'].licenSkillLevel" class="licenSkillLevel" value="'+ userLicenList[i].licenSkillLevel +'"></td>'
					+ '<td><button type="button" class="removeTrBtn" id="removeTrBtn-l'+ i +'" onclick="deleteBtn(this)">-</button></td>'
				+ '</tr>';
		licenTable.find('tbody').html(html);
	}
	
	if( userLicenList.length <= 1 ){
		$('#licenIdx').val('1');	// 행추가 할 때를 위해 input value를 바꿔 놓는 처리
		licenTable.find('.removeTrBtn:first-child').parent().css('display', 'none');	//첫번째 - 버튼은 나타나지 않게
	}else{
		$('#licenIdx').val(i);	// 행추가 할 때를 위해 input value를 바꿔 놓는 처리
	}
	
	licenTable.find('input').each(function(){
		if( $(this).val()== 'null' ){
			$(this).val('');
		}
	});
	flexibleTableTrEve();		// 추가된 remove 버튼에 이벤트 할당
}

//불러오기 후 userTraining 상세정보 뿌리기
function fnUserTraining(userTrainingList){
	var trTable = $('#trainingTb');
	var html = '';
	
	for(var i=0; i<userTrainingList.length; i++){
		html += '<tr>'
				+ '<td><input type="text" name="trainList['+ i +'].trainingName" class="trainingName" value="'+ userTrainingList[i].trainingName +'"></td>'
				+ '<td><input type="text" name="trainList['+ i +'].trainingStartdate" class="trainingStartdate dateInput prevDate" readonly="readonly" value="'+ userTrainingList[i].trainingStartdate +'"></td>'
				+ '<td><input type="text" name="trainList['+ i +'].trainingEnddate" class="trainingEnddate dateInput laterDate" readonly="readonly" value="'+ userTrainingList[i].trainingEnddate +'"></td>'
				+ '<td><input type="text" name="trainList['+ i +'].trainingAgency" class="trainingAgency" value="'+ userTrainingList[i].trainingAgency +'"></td>'
				+ '<td><button type="button" class="removeTrBtn" id="removeTrBtn-t'+ i +'" onclick="deleteBtn(this)">-</button></td>'
			+ '</tr>';
		trTable.find('tbody').html(html);
	}
	if( userTrainingList.length <= 1 ){
		$('#trainingIdx').val('1');	// 행추가 할 때를 위해 input value를 바꿔 놓는 처리
		trTable.find('.removeTrBtn:first-child').parent().css('display', 'none');	//첫번째 - 버튼은 나타나지 않게
	}else{
		$('#trainingIdx').val(i);	// 행추가 할 때를 위해 input value를 바꿔 놓는 처리
	}
	
	trTable.find('input').each(function(){
		if( $(this).val()== 'null' ){
			$(this).val('');
		}
	});
	datepicker();
	flexibleTableTrEve();		// 추가된 remove 버튼에 이벤트 할당
}

//불러오기 후 userSkill 상세정보 뿌리기
function fnUserSkill(userSkillList){
	var skillTable = $('#skillTb');
	var html = '';
		
	for(var i=0; i<userSkillList.length; i++){
		html += '<tr>'
				+ '<td><textarea name="skillList['+ i +'].skillProjectName" class="skillProjectName">'+ userSkillList[i].skillProjectName +'</textarea></td>'
				+ '<td><input type="text" name="skillList['+ i +'].skillStartdate" class="skillStartdate dateInput prevDate" readonly="readonly" value="'+ userSkillList[i].skillStartdate +'"></td>'
				+ '<td><input type="text" name="skillList['+ i +'].skillEnddate" class="skillEnddate dateInput laterDate" readonly="readonly" value="'+ userSkillList[i].skillEnddate +'"></td>'
				+ '<td><textarea name="skillList['+ i +'].skillCustomerComp" class="skillCustomerComp">'+ userSkillList[i].skillCustomerComp +'</textarea></td>'
				+ '<td><textarea name="skillList['+ i +'].skillWorkComp" class="skillWorkComp">'+ userSkillList[i].skillCustomerComp +'</textarea></td>'
				+ '<td><textarea name="skillList['+ i +'].skillIndustry" class="skillIndustry">'+ userSkillList[i].skillIndustry +'</textarea></td>'
				+ '<td><textarea name="skillList['+ i +'].skillApplied" class="skillApplied">'+ userSkillList[i].skillApplied +'</textarea></td>'
				+ '<td><textarea name="skillList['+ i +'].skillRole" class="skillRole">'+ userSkillList[i].skillRole +'</textarea></td>'
				+ '<td><textarea name="skillList['+ i +'].skillModel" class="skillModel">'+ userSkillList[i].skillModel +'</textarea></td>'
				+ '<td><textarea name="skillList['+ i +'].skillOs" class="skillOs">'+ userSkillList[i].skillOs +'</textarea></td>'
				+ '<td><textarea name="skillList['+ i +'].skillLang" class="skillLang">'+ userSkillList[i].skillLang +'</textarea></td>'
				+ '<td><textarea name="skillList['+ i +'].skillDbms" class="skillDbms">'+ userSkillList[i].skillDbms +'</textarea></td>'
				+ '<td><textarea name="skillList['+ i +'].skillTool" class="skillTool">'+ userSkillList[i].skillTool +'</textarea></td>'
				+ '<td><textarea name="skillList['+ i +'].skillComm" class="skillComm">'+ userSkillList[i].skillComm +'</textarea></td>'
				+ '<td><textarea name="skillList['+ i +'].skillEtc" class="skillEtc">'+ userSkillList[i].skillEtc +'</textarea></td>'
				+ '<td><button type="button" class="removeTrBtn" id="removeTrBtn-s'+ i +'" onclick="deleteBtn(this)">-</button></td>'
			+ '</tr>';
		skillTable.find('tbody').html(html);
	}
	
	if( userSkillList.length <= 1 ){
		$('#skillIdx').val('1');	// 행추가 할 때를 위해 input value를 바꿔 놓는 처리
		skillTable.find('.removeTrBtn:first-child').parent().css('display', 'none');	//첫번째 - 버튼은 나타나지 않게
	}else{
		$('#skillIdx').val(i);	// 행추가 할 때를 위해 input value를 바꿔 놓는 처리
	}
	
	datepicker();
	skillTable.find('textarea, input').each(function(){
		if( $(this).val()== 'null' ){
			$(this).val('');
		}
	});
	flexibleTableTrEve();		// 추가된 remove 버튼에 이벤트 할당
}

function datepicker(){
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
}

//remove 버튼 이벤트 할당
var flexibleTableTrEve = function(){
	$('.removeTrBtn').css('display', 'none');
	
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

//작성창 초기화
function resetInput(){
//	alert('d');
	var $flexibleTable = $(".flexibleTable");
	
	$flexibleTable.find("tbody").find("tr:not(:first-child)").remove();
	
	$('.status-display-pannel').find('h5').text('※ 새 이력 작성');
	$('.userInsert').find('input').val('');
	$('.userInsert').find('textarea').val('');
	$('.userInsert').find('select').val('');
	$('#img').css('display', 'none');
	$('#thumbNail').css('display', 'block');
	$('#thumbNail').css('padding-left', '20px');
	$('#delete-file').css('display', 'none');
}

//검색조건 초기화
function searchReset(){
	$('.pop-user-search-pannel').find('input').val('');
	$('.pop-user-search-pannel').find('select').val('');
	$('#userInfoDataSize').val('10');
}

//연차별 인원보기에서 각 연차별로 클릭 했을 때
function go_userList(groupListDate){
//	alert(groupListDate);
	$("#groupListDate").val(groupListDate);	//input 태그에 클릭 한 groupListDate 값을 넘겨줌 
	$('#userListSearchBtn').click();
	
}


// thumbNail upload시 image 보이게
function handleImgFileSelect(e){
	
	var sel_file;
	
	var files = e.target.files;
	var filesArr = Array.prototype.slice.call(files);
	
	filesArr.forEach(function(f){
		if( !f.type.match('image.*')) {
			alert("확장자는 이미지 확장자만 가능합니다.");
	        return;
		}
		
		sel_file = f;
		
		var reader = new FileReader();
		reader.onload = function (e){
			$('#thumbNail').css('display', 'none');
			$('#img').css('display', 'block');
			$('#img').attr('src', e.target.result);
			$('#delete-file').css('display', 'block');
		}
		reader.readAsDataURL(f);
	});
}
