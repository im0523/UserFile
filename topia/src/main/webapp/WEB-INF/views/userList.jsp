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

</div>
