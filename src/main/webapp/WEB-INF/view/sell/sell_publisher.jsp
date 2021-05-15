<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../main/IncludeTop.jsp"%>

<div align="center" style="margin-left: 100px; margin-right: 100px;">
	<table class="pbook">
		<tr>
			<td style="width:400px; padding-right:50px;" rowspan="7">
				<img border="0" src="${item.sell_image}" width="400px" />
			</td>
			<td style="width:100px; font-size:25px; font-weight: bold;" colspan="2">${item.sell_itemName}</td>
			<td></td>
		</tr>
		<tr>
			<td colspan="2" style="color:#E02020; font-size:25px; font-weight: bold;">${item.sell_price}원</td>
			<td></td>
		</tr>
		<tr>
			<td colspan="2" style="color:#9b9b9b;"><hr></td>
			<td></td>
		</tr>
		<tr>
			<td style="width:100px; color:#9b9b9b;">저자</td>
			<td style="width:100px; font-size:14px; font-family:'Nanum Gothic', sans-serif;">${item.sell_author}</td>
		</tr>
		<tr>
			<td style="width:100px; color:#9b9b9b;" >출판사</td>
			<td style="width:100px; font-size:14px; font-family: 'Nanum Gothic', sans-serif;">${item.sell_publisher}</td>
		</tr>
		<tr>
			<td style="width:100px; color:#9b9b9b;" >거래 방식</td>
			<td style="width:200px; font-size:14px; font-family: 'Nanum Gothic', sans-serif;">${item.deal_method}</td>
		</tr>
		<tr>
			<td style="width:100px; color:#9b9b9b;" >거래 상태</td>
			<td style="width:100px; font-size:14px; font-family: 'Nanum Gothic', sans-serif;">
				<c:choose>
					<c:when test="${item.deal_status == 0}">판매 중</c:when>
					<c:when test="${item.deal_status == 1}">거래 중</c:when>
					<c:when test="${item.deal_status == 2}">판매 완료</c:when>
				</c:choose>
			</td>
		</tr>
	</table>
	<table class="publisher" align="right">
		<tr>
			<td style="padding: 10px;">
				<a href='<c:url value='/sell/wish/upload.do'>
					<c:param name='sell_itemId' value='${item.sell_itemId}' /></c:url>'>
					<img border="0" src="../images/heart.PNG" width="35px" />
				</a>
			</td>
			<td style="color:#787372; padding: 21px;">판매자 : </td>
			<td style="padding: 10px; font-size:14px; font-family: 'Nanum Gothic', sans-serif;">${item.name}</td>
			<td style="color:#787372; padding: 10px;">판매자 거래 횟수 : </td>
			<td style="padding: 10px; font-size:14px; font-family: 'Nanum Gothic', sans-serif;">${item.tradeCount}</td>
			<td style="padding:20px;">
				<input class="btn_slist" type="button" value="채팅하기" onclick="location.href='<c:url value='/sell/chat.do'><c:param name='sell_itemId' value='${item.sell_itemId}' /></c:url>'">	
			</td>
		</tr>
	</table>
	<br><br><br><br><br>
	<table>
		<tr>
			<td style="color:#787372; padding:30px;">상품 정보</td>
		</tr>
		<tr>
			<td style="margin: 20px; font-size:14px; line-height: 160%; font-family: 'Nanum Gothic', sans-serif;">
				${item.sell_info}
			</td>
		</tr>
	</table>
</div>
<script>
	var message = '${alert}';
	if (message != 'X') {
		alert(message);
	}
</script>
<%@ include file="../main/IncludeBottom.jsp"%>