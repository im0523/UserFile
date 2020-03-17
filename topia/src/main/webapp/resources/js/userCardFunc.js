"use strict"; // 엄격한 문법 검사

$(document).ready(function(){
// 저장버튼 클릭시 이벤트 발생
	$(".saveBtn").click(function(){
		var $frm = $('.userInsert :input');
		var param = $frm.serialize();
		alert(param);
		$.ajax({
		    url : "/userInsert.do",
		    dataType: "json",
		    type: "POST",
		    data : param,
		    success: function(data, textStatus, jqXHR)
		    {
				alert("등록완료");
				
				location.href = "/";
		    },
		    error: function (jqXHR, textStatus, errorThrown)
		    {
		    	alert("실패");
		    	alert(jqXHR + "와 " + textStatus, +"와 " + errorThrown);
		    }
		});
//		var userIdxVal = $("#userIdx").val();
//		var userName = $("#userName").val(); 
//		// ajax로 파일업로드를 하기위해 FormData생성
//		var formData = new FormData();
//		var inputFile = $("input[name='file']");
//		var file = inputFile[0].files
//		// formData에 데이터를 넣어 전송한다
//		formData.append("file",file[0]);
//		formData.append("userName",userName);
//		formData.append("userIdx",userIdxVal);
//			
//		var userIdxObj = {"userIdx":userIdxVal}; // 치환된 배열 데이터를 key를 줌
//		var submitDataObj = $.extend( submitDataObj, userIdxObj); // 전송하기 위해 고정데이터와 유동데이터 합침
//		
//		var url = "";
//		if(isEmpty(userIdxVal)){ // 새 작성을 저장하는 경우
//			
//			url = "/userInsert.do";
//			
//		}else{ // 기존 작성된 이력을 수정저장하려는 경우
//			
//			url = "./personalHistory/registerUserUpdate";
//			
//			
//		}
//		
//		$.ajax({
//			url: url,
//			type: "POST",
//			data: submitDataObj,
//			async: false,
//			dataType: "json",
//			success: function(data){
//				var userIdx = data.userIdx;
//				$("#userIdx").val(userIdx);
//				var errorCode = data.errorCode;
//				var errorMsg = data.errorMsg;
//				console.log(submitDataObj);
//				
//				if(url == "/userInsert.do"){
//					if(file[0]==null){						// 이미지를 선택하지 않았다면 이미지 수정은 건너뛴다
//						alert("작성한 내용이 저장되었습니다.");
//						userListPagingView();
//						modeChange("UPDATE");
//						return true;
//					}
////					$.ajax({
////						url:"./personalHistory/imgUpdate",
////						type:"post",
////						data:formData,
////						processData: false,
////						contentType: false,
////						success:function(){
////							$("input[name='file']").val("");
////						}
////					});
//				}
//				
//				if(isEmpty(errorCode)){
//					
//					if(url == "/userInsert.do"){
//						if(file[0]==null){						// 이미지를 선택하지 않았다면 이미지 삽입은 건너뛴다
//							alert("작성한 내용이 저장되었습니다.");
//							userListPagingView();
//							modeChange("UPDATE");
//							return true;
//						}
////						$.ajax({
////							url:"./personalHistory/imgInsert",
////							data:formData,
////							type:"post",
////							processData: false,
////							contentType: false,
////							success:function(){
////								$("input[name='file']").val("");
////							}
////						})
//					}
//					
//					alert("작성한 내용이 저장되었습니다.");
//					userListPagingView(); // 리스트 새로 로드 
//					modeChange("UPDATE"); // 저장 후 상단 상태 변경
//					
//				}else{
//					alert(errorMsg);
//					return false;
//				}
//			},
//			error: function(){
//				alert("error");
//			},
//			complete: function(){
//				loading("OFF");
//			}
//		});
		
	});
});

