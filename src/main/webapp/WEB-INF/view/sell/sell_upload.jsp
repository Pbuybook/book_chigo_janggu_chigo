<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../main/IncludeTop.jsp"%>

<div align = "center">
<br>
<!-- write Form  -->
	<form name="form" method="POST" action="<c:url value='/sell/upload.do' />">
	        <!--contents-->
		<h3>판매 등록</h3> 
		  <table>
		  	  <tr >
				<td width="100" align="center">상품 이름</td>
				<td bgcolor="ffffff" style="padding-left: 10; padding-right : 10;">
					<input type="text" style="font-family: 'Nanum Gothic', sans-serif; width: 250;" name="sell_itemName" required="required">
				</td>
			  </tr>
		  	  <tr>
				<td width="100" align="center">가격</td>
				<td  bgcolor="ffffff" style="padding-left: 10; padding-right : 10;">
					<input type="text" style="font-family: 'Nanum Gothic', sans-serif; width: 250" name="sell_price" required="required">
				</td>
			  </tr>
		  	  <tr>
				<td width="100" align="center">저자</td>
				<td bgcolor="ffffff" style="padding-left: 10; padding-right : 10;">
					<input type="text" style="font-family: 'Nanum Gothic', sans-serif; width: 250" name="sell_author" required="required">
				</td>
			  </tr>
			  <tr>
				<td width="100" align="center">출판사</td>
				<td bgcolor="ffffff" style="padding-left: 10; padding-right : 10;">
					<input type="text" style="font-family: 'Nanum Gothic', sans-serif; width: 250" name="sell_publisher" required="required">
				</td>
			  </tr>
			  <tr>
				<td width="100" align="center">상품 정보</td>
				<td bgcolor="ffffff" style="padding-left: 10; padding-right : 10;">
					<textarea style="font-family: 'Nanum Gothic', sans-serif;" cols="50" rows="10" name="sell_info" required="required"></textarea>
				</td>
			  </tr>
			  <tr>
				<td width="100" align="center">사진 등록</td>
				<td bgcolor="ffffff" style="padding-left: 10; padding-right : 10;">
					<input type="file" style="font-family: 'Nanum Gothic', sans-serif; width: 250" name="sell_image" required="required">
				</td>
			  </tr>
			  <tr>
				<td width="100" align="center">거래 방식</td>
				<td bgcolor="ffffff" style="padding-left: 10; padding-right : 10;">
					<input type="text" style="font-family: 'Nanum Gothic', sans-serif; width: 250" name="deal_method" required="required">
				</td>
			  </tr>
			  </table>
			  <br>
	 		<input class="btn_slist" type="submit" value = "등록"> &nbsp;
	 		<input class="btn_slist" type="button" value = "취소" onclick="location.href='<c:url value='/sell/list.do'/>'">	
	 	
	</form>
</div>

<%@ include file="../main/IncludeBottom.jsp"%>