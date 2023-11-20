<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%
String menu = (String) request.getAttribute("menu");
int amount = (Integer) request.getAttribute("amount");
int sum = (Integer) request.getAttribute("sum");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스타벅스</title>
</head>
<body>
	<div>
		<ul>
			<li><a href="http://localhost/">첫화면으로</a></li>
		</ul>
	</div>
	<div>
		<h2>고객님 주문하신 음식이 나왔습니다.</h2>
	</div>
	<div>
		<h3>
			<c:out value="${menu }"></c:out>
			총
			<c:out value="${amount }"></c:out>
			개 주문 <br> 결제하실 금액은
			<fmt:formatNumber value="${sum}" pattern="#,###" />
			원 입니다.
		</h3>
	</div>

	<div>

		<c:forEach var="index" begin="1" end="${amount}">
			<c:set var="Tenimg" value="${index % 10 == 0}" />

			<span> <img style="width: 70px; ${Tenimg ? 'border: 4px solid red;' : ''}" src="http://localhost/images/${menu}.jpg">
			</span>
			<c:if test="${Tenimg == true}">
				<c:out value="${index }"></c:out>
			</c:if>
		</c:forEach>

	</div>
</body>
</html>