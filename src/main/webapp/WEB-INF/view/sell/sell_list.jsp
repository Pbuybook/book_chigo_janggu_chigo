<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../main/IncludeTop.jsp"%>

<div>
	<form action="<c:url value='/sell/search.do' />" align="right">
		<input class="btn_slist" style="width: 120px;" type="button"
			value="즐겨찾기 조회"
			onclick="location.href='<c:url value='/sell/wish.do'/>'" /> <input
			class="btn_slist" style="width: 120px;" type="button"
			value="주문 완료 조회"
			onclick="location.href='<c:url value='/sell/finish.do'/>'" /> <input
			class="btn_slist" type="button" value="판매글 조회"
			onclick="location.href='<c:url value='/sell/history.do'/>'" /> <input
			class="btn_slist" style="margin-right: 100px;" type="button"
			value="판매 등록"
			onclick="location.href='<c:url value='/sell/uploadForm.do'/>'" /> <br>
		<br> 
		<input id="sell_search_box" name="sell_itemName" type="text"> <input class="btn_slist" style="margin-right: 100px;" type="submit" value="검색" /> <br>
		<br>
		<br>
		<br>
		<br>
		<table class="slist" align="center">
			<c:forEach var="sellItem" items="${list}" varStatus="vs">			
				<tr bgcolor="ffffff">
					<td style="border-left: 1px solid #E6E6E6; border-top: 1px solid #E6E6E6; border-bottom: 1px solid #E6E6E6; border-collapse: collapse;">
						<a href='<c:url value="/sell/item.do"> <c:param name="sell_itemId" value="${sellItem.sell_itemId}"/></c:url>'>
						<img border="0" src="${sellItem.sell_image}" /></a></td>
					<td	style="border-top: 1px solid #E6E6E6; border-bottom: 1px solid #E6E6E6; border-collapse: collapse;">${sellItem.sell_itemName}</td>
					<td	style="color: #E02020; border-top: 1px solid #E6E6E6; border-right: 1px solid #E6E6E6; border-bottom: 1px solid #E6E6E6; border-collapse: collapse;">${sellItem.sell_price}원</td>
				</tr>
			</c:forEach>
		</table>
	</form>
</div>

<%@ include file="../main/IncludeBottom.jsp"%>
