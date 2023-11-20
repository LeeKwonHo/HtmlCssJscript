<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스타벅스</title>
<link href="<c:url value='/css/starbucks.css'/>" rel="stylesheet">
</head>
<body>
	<div>
		<ul>
			<li><a href='<c:url value="http://localhost/"/>'>첫화면으로</a></li>
		</ul>
	</div>
	<div>
		<span> <img class="menuImg" data-menu="cake" src="http://localhost/images/cake.jpg">
		</span> <span> <img class="menuImg" data-menu="coffee" src="http://localhost/images/coffee.jpg">
		</span> <span> <img class="menuImg" data-menu="sandwich" src="http://localhost/images/sandwich.jpg">
		</span>
	</div>
	<div>
		<span> <input type="number" id="count" value="1">개
		</span>
	</div>
	<div>
		<span> <input type="button" id="btnOrder" value="주문하기">
		</span>
	</div>
	<form id="orderForm" method="post" action="http://localhost/starbucks/order.star">
		<input type="hidden" id="menu" name="menu"> <input type="hidden" id="amount" name="amount">
	</form>
	<script src="http://localhost/js/starbucks_menu.js"></script>
</body>
</html>