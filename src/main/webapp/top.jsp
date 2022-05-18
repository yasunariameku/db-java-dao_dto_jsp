<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>検索条件を入力してください</h1>
	<c:if test="${not empty msg}">
		<p>${msg}</p>
	</c:if>
	<form action="login" method="post">
		product_id: <input type="text" name="id"><br>
		<button type="submit">クエリ送信</button>
	</form>

</body>
</html>