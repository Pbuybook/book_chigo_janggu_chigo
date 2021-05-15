<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../main/IncludeTop.jsp"%>

<div align = "center">
	<h2>판매글 조회</h2><br><br>
	<table class="shistory">
		<tr style="background-color: #DDDDDD; height:30px;">
			<th>번호</th>
			<th>사진</th>
			<th>제목</th>
			<th>가격</th>
			<th>거래 상태</th>
		</tr>
		<c:forEach var="sellItem" items="${list}" varStatus="vs">	
			<tr>
				<td><c:out value="${vs.count}" /></td>
				<td><a href='<c:url value="/sell/seller.do"> <c:param name="sell_itemId" value="${sellItem.sell_itemId}"/></c:url>'>
						<img border="0" src="${sellItem.sell_image}" /></a></td>
				<td>${sellItem.sell_itemName}</td>
				<td>${sellItem.sell_price}</td>
				<td><c:choose>
					<c:when test="${sellItem.deal_status eq 0}">판매 중</c:when>
					<c:when test="${sellItem.deal_status eq 1}">거래 중</c:when>
					<c:when test="${sellItem.deal_status eq 2}">판매 완료</c:when>
				</c:choose>
				</td>
			</tr>
		</c:forEach>
	</table>
</div>

<%@ include file="../main/IncludeBottom.jsp"%>