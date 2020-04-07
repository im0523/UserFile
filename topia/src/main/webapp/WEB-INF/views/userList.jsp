<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<input type="hidden" id="totalCnt" value="${totalCnt }"/>
<table class="pop-register-list">
	<thead>
		<tr>
			<td>등록번호</td>
			<td>성명</td>
			<td>소속회사</td>
			<td>부서</td>
			<td>성별</td>
			<td>경력</td>
			<td>등록날짜</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="vo" items="${ list }">
			<tr onclick="go_detail('${ vo.userIdx }')">
				<td>${ vo.userIdx }</td>
				<td>${ vo.userName }</td>
				<td>${ vo.userComp }</td>
				<td>${ vo.userDept }</td>
				<td>${ vo.userSex }</td>
				<td>${ vo.careerDate }</td>
				<td>${ vo.userRegisterDate }</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<div class="pop-paging-pannel">
	<p id="page-list">

	<c:if test="${page.curBlock gt 1 }">
		<a onclick="go_page(1)">처음</a>
		<a onclick="go_page(${page.startPage-page.blockPage})">이전</a>
	</c:if>

	<c:forEach var="no" begin="${page.startPage }" end="${page.endPage }">
		<c:if test="${no eq page.curPage}">	<!-- 현재 페이지일 때 -->
			<span class="page-on">${no }</span>
		</c:if>
		<c:if test="${no ne page.curPage}">
			<a onclick="go_page(${no})">${no }</a>
		</c:if>
	</c:forEach>
	
	<c:if test="${page.curBlock < page.totalBlock }">
		<a onclick="go_page(${page.endPage+1})">다음</a>
		<a onclick="go_page(${page.totalPage})">마지막</a>
	</c:if>

	</p>
</div>
<script>
function go_page(no){
	$('[name=curPage]').val(no);
	$('#userListSearchBtn').click();
}
</script>
