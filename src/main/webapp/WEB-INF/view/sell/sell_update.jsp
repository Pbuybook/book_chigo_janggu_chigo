<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../main/IncludeTop.jsp"%>

<div align = "center">
<br>
<!-- write Form  -->
	<form name="form" modelAttribute="UpdateForm" method="POST" action="<c:url value='/sell/update.do' />">
		<h3>판매 게시글 수정</h3> 
		  <table>
		  	  <tr >
				<td width="100" align="center">상품 이름</td>
				<td bgcolor="ffffff" style="padding-left: 10; padding-right : 10;">
					<input type="text" style="font-family: 'Nanum Gothic', sans-serif; width: 250;" value="${UpdateForm.sell_itemName}" name="sell_itemName" required="required">
				</td>
			  </tr>
		  	  <tr>
				<td width="100" align="center">가격</td>
				<td  bgcolor="ffffff" style="padding-left: 10; padding-right : 10;">
					<input type="text" style="font-family: 'Nanum Gothic', sans-serif; width: 250" value="${UpdateForm.sell_price}" name="sell_price" required="required">
				</td>
			  </tr>
		  	  <tr>
				<td width="100" align="center">저자</td>
				<td bgcolor="ffffff" style="padding-left: 10; padding-right : 10;">
					<input type="text" style="font-family: 'Nanum Gothic', sans-serif; width: 250" value="${UpdateForm.sell_author}" name="sell_author" required="required">
				</td>
			  </tr>
			  <tr>
				<td width="100" align="center">출판사</td>
				<td bgcolor="ffffff" style="padding-left: 10; padding-right : 10;">
					<input type="text" style="font-family: 'Nanum Gothic', sans-serif; width: 250" value="${UpdateForm.sell_publisher}" name="sell_publisher" required="required">
				</td>
			  </tr>
			  <tr>
				<td width="100" align="center">상품 정보</td>
				<td bgcolor="ffffff" style="padding-left: 10; padding-right : 10;">
					<textarea style="font-family: 'Nanum Gothic', sans-serif;" cols="50" rows="10" name="sell_info" required="required">${UpdateForm.sell_info}</textarea>
				</td>
			  </tr>
			  <tr>
				<td width="100" align="center">사진 등록</td>
				<td bgcolor="ffffff" style="padding-left: 10; padding-right : 10;">
					<input type="file" style="font-family: 'Nanum Gothic', sans-serif; width: 250" name="sell_image">
				</td>
			  </tr>
			  <tr>
				<td width="100" align="center">거래 방식</td>
				<td bgcolor="ffffff" style="padding-left: 10; padding-right : 10;">
					<input type="text" style="font-family: 'Nanum Gothic', sans-serif; width: 250" value="${UpdateForm.deal_method}" name="deal_method" required="required">
				</td>
			  </tr>
			  </table>
			  <br>
	 		<input class="btn_slist" type="submit" value = "수정"> &nbsp;
	 		<input class="btn_slist" type="button" value = "취소" onclick="location.href='<c:url value='/sell/item.do'><c:param name='sell_itemId' value='${UpdateForm.sell_itemId}' /></c:url>'">	
	 	
	</form>
</div>

<%@ include file="../main/IncludeBottom.jsp"%>