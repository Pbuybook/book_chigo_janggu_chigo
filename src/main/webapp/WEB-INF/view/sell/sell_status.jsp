<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../main/IncludeTop.jsp"%>

<div align="center">
	<br>
	<!-- write Form  -->
	<form name="form" method="POST" modelAttribute="StatusForm"	action="<c:url value='/sell/statusUpdate.do' />">
		<h3>거래 상태 수정</h3>
		거래 완료 옆 입력 창에 구매자 아이디 입력
		<br><br><br><br>
		<table>
			<tr>
				<td style="padding-left: 10; padding-right: 10;">
					<label style="font-family: 'Nanum Gothic', sans-serif;"><input type="radio" name="deal_status" value="0">판매 중</label><br><br>
					<label style="font-family: 'Nanum Gothic', sans-serif;"><input type="radio" name="deal_status" value="1">거래 중</label><br><br>
					<label style="font-family: 'Nanum Gothic', sans-serif;"><input type="radio" name="deal_status" value="2">거래 완료</label>
					&nbsp;<input name="id" type="text">
				</td>
			</tr>
		</table>
		<br>
		<br>
		<br> <input class="btn_slist" type="submit" value="수정"> &nbsp;
		<input class="btn_slist" type="button" value="취소"
			onclick="location.href='<c:url value='/sell/item.do'><c:param name='sell_itemId' value='${StatusForm.sell_itemId}' /></c:url>'">
	</form>
</div>

<%@ include file="../main/IncludeBottom.jsp"%>