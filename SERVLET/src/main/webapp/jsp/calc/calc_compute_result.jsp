<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String opResult = (String) request.getAttribute("opResult");
String numOne = (String) request.getAttribute("numOne");
String numTwo = (String) request.getAttribute("numTwo");
String op = (String) request.getAttribute("op");
%>

<!DOCTYPE html>

<html>


<head>

<meta charset="UTF-8">

<title>JSP TEST</title>

</head>


<body>
	<h1><%=numOne%>
		<%=op%>
		<%=numTwo%>
		=
		<%=opResult%></h1>

	<input type="button" id="backBTN" value="돌아가기">

	<script type="text/javascript">
		document.getElementById("backBTN").addEventListener("click",
				function() {
					location.href = "http://localhost/calc.html";
				});
	</script>
</body>

</html>