<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../main/IncludeTop.jsp"%>

<div align = "center">
	<h2>주문 완료 조회</h2><br><br>
	<table class="shistory">
		<tr style="background-color: #DDDDDD; height:30px;">
			<th>번호</th>
			<th>사진</th>
			<th>제목</th>
			<th>가격</th>
		</tr>	
		<c:forEach var="item" items="${list}" varStatus="vs">	
			<tr>
				<td><c:out value="${vs.count}" /></td>
				<td><a href='<c:url value="/sell/seller.do"> <c:param name="sell_itemId" value="${item.sell_itemId}"/></c:url>'>
						<img border="0" src="${item.sell_image}" /></a></td>
				<td>${item.sell_itemName}</td>
				<td>${item.sell_price}</td>
			</tr>
		</c:forEach>
	</table>
</div>

<%@ include file="../main/IncludeBottom.jsp"%>