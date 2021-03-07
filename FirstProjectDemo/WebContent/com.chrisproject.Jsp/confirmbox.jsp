<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Confirm Box</title>
</head>
<body>
	<%int canno = Integer.valueOf(request.getParameter("deletedata")); %>
	<h2>確認刪除<%=canno %>嗎</h2>
</body>
</html>