<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../main/IncludeTop.jsp"%>

<div align="center" style="margin-left: 100px; margin-right: 100px;">
	<table>
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
					<c:when test="${item.deal_status eq 0}">판매 중</c:when>
					<c:when test="${item.deal_status eq 1}">거래 중</c:when>
					<c:when test="${item.deal_status eq 2}">판매 완료</c:when>
				</c:choose>
			</td>
		</tr>
	</table><br><br>
	<form name="form">
		<table class="publisher" align="right">
			<tr>
				<td style="padding: 10px; text-align:center;">
					<input class="btn_slist" style="width: 150px;" type="button" value="거래 상태 수정" onclick="location.href='<c:url value='/sell/statusUpdate.do'>
								<c:param name='sell_itemId' value='${item.sell_itemId}' /></c:url>'">
				</td>
				<td style="padding: 5px;">
				</td>
				<td style="padding:10px;">
					<input class="btn_slist" type="button" value="게시글 삭제" onclick="location.href='<c:url value='/sell/delete.do'><c:param name='sell_itemId' value='${item.sell_itemId}' /></c:url>'">	
				</td>
				<td style="padding: 5px;">
				</td>
				<td style="padding:10px; margin-right:100px;">
					<input class="btn_slist" type="button" value="게시글  수정" onclick="location.href='<c:url value='/sell/update.do'>
								<c:param name='sell_itemId' value='${item.sell_itemId}' />
								<c:param name='sell_image' value='${item.sell_image}' /></c:url>'">	
				</td>
		</table>
	</form>
	<br><br><br><br><br>
	<table>
		<tr>
			<td style="color:#787372; padding:30px;">상품 정보</td>
		</tr>
		<tr>
			<td style="margin: 20px; line-height: 160%; font-size:14px; font-family: 'Nanum Gothic', sans-serif;">
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