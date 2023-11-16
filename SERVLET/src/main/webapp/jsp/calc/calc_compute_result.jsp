<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String a = (String) request.getAttribute("a");
String b = (String) request.getAttribute("b");
String c = (String) request.getAttribute("c");
String d = (String) request.getAttribute("d");
String e = (String) request.getAttribute("e");
String op = (String) request.getAttribute("op");
%>

<!DOCTYPE html>

<html>


<head>

<meta charset="UTF-8">

<title>JSP TEST</title>

</head>


<body>

	더하기:
	<%=a%><br>
	빼기:
	<%=b%><br>
	곱하기:
	<%=c%><br>
	나누기:
	<%=d%><br>
	나머지:
	<%=e%>

</body>

</html>