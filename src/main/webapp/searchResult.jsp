<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>検索結果</h1>
	<c:if test="${not empty msg}">
		<p>${msg}</p>
	</c:if>
	<p>${result}</p>
	<a href="top.jsp" >戻る</a>
</body>
</html>