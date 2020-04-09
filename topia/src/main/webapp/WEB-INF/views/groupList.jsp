<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%-- <input type="hidden" name="groupListDate" value="${groupListDate }"/> --%>
<table class="pop-register-list">
	<thead>
		<tr style="text-align: center">
			<td>연차</td> 
			<td>인원</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="vo" items="${ groupList }">
			<tr onclick="go_userList('${ vo.groupListDate }')">
				<td>${ vo.groupListDate }년</td>
				<td>${ vo.groupListCnt }</td>
			</tr>
		</c:forEach>
	</tbody>
</table>