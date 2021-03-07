<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*,com.chrisproject.Bean.CancerBean"%>
<%!@SuppressWarnings("unchecked")%>
<!DOCTYPE html>
<html>
<head>
<link href="com.chrisproject.CSS/query.css" rel="stylesheet">
<meta charset="UTF-8">
<title>搜尋結果</title>
</head>
<body style="background-color: #fdf5e6">

	<div class="alldata">
		<h2>顯示癌症資料</h2>
		<%List<CancerBean> canr = (ArrayList<CancerBean>) request.getAttribute("keywordresult"); %>
		<table border="1">
			<tr style="background-color: #a58fefa">
				<th>資料編號
				<th>年別
				<th>死因
				<th>順位
				<th>死亡人數合計
				<th>死亡人數男
				<th>死亡人數女
				<th>死亡率合計[人/十萬人口]
				<th>死亡率/男[人/十萬人口]
				<th>死亡率/女[人/十萬人口] 
				<%
				for (CancerBean can : canr) {
				%>
			<tr>
				<td><%=can.getCanno()%>
				<td><%=(String)can.getYear()%>
				<td><%=(String)can.getCauseOfDeath()%>
				<td><%=(String)can.getRank()%>
				<td><%=Integer.valueOf(can.getDeathTotal())%>
				<td><%=Integer.valueOf(can.getDeathMan())%>
				<td><%=Integer.valueOf(can.getDeathWoman())%>
				<td><%=Float.parseFloat(can.getDeathRate())%>
				<td><%=Float.parseFloat(can.getDeathRateMan())%>
				<td><%=Float.parseFloat(can.getDeathRateWoman())%> 
 	<%}%>
 
		</table>
		</div>
		<h3 align="center">
			共<%=canr.size()%>筆資料
		</h3>
		
		<form method="post" action="GellAllCancerData">
		<input type="submit" value="返回" /></form>
		<br><br>
		<form method="post" action="DownloadSearchFile">
		<jsp:useBean id = "deletname" scope="request" class="com.chrisproject.Bean.CancerBean"/>
		<input type="hidden"  value="<%=deletname.getDeletebyname() %>" name="downloadfile"/>
		<input type="submit" value="一鍵下載" name="downloadfile"/></form>
</body>
</html>