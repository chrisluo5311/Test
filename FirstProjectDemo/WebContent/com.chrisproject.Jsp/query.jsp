<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.*,com.chrisproject.Bean.CancerBean"%>
<%!@SuppressWarnings("unchecked")%>
<!DOCTYPE html>
<html>
<head>
<link href="com.chrisproject.CSS/query.css" rel="stylesheet">
<meta charset="UTF-8">
<title>癌症死因分析</title>
</head>

<body style="background-color: #fdf5e6">

<form method ="post" action="DeleteAll">
	<div>
		<input type="submit" value="刪除" name="deletefile"/>
	</div>
	<br>
</form>

<form method="post" action="UploadFile">
	<div>
		<input type="submit" value="上傳" name="uploadfile"/>
	</div>
	<br>
</form>

<form method="post" action="DownloadFile">
<jsp:useBean id = "downloadcount" scope="request" class="com.chrisproject.Bean.CancerBean"/>
	<input type="submit" value="下載" name="downfile"/>
	<p>已成功下載<%=downloadcount.getCount() %>份文件</p>
	<br>
</form>


	<div class="alldata">
		<h2 align="center">顯示癌症資料</h2>
		<table class="table1" border="1">
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
				<th>修改
				<th>刪除
				<%List<CancerBean> canr = (ArrayList<CancerBean>) request.getAttribute("queryResult");
				for (CancerBean can : canr) {
				%>
			<tr>
				<td><%=can.getCanno()%>
				<td><%=can.getYear()%>
				<td><%=can.getCauseOfDeath()%>
				<td><%=can.getRank()%>
				<td><%=can.getDeathTotal()%>
				<td><%=can.getDeathMan()%>
				<td><%=can.getDeathWoman()%>
				<td><%=can.getDeathRate()%>
				<td><%=can.getDeathRateMan()%>
				<td><%=can.getDeathRateWoman()%>
				<td><a href="GetOneCancerData?updateData=<%=can.getCanno() %>" target="_blank">修改</a>
				<td><form method="post" action="DeleteCancerData">
					<input type="hidden"  value="<%=can.getCanno() %>" name="id"/>				
					<input type="submit" value="刪除" name="id"/></form>
				
					
 	<% }%>
		</table>
		</div>
		
		<h3 align="center">
			共<%=canr.size()%>筆資料
		</h3>	
	
	<br><br>

	<div class="delete" align="left">
		<h2 align="center">請輸入欲<q>刪除</q>的資料</h2>
		<form method="post" action="DeleteCancerData">
			輸入刪除的資料編號 : <input type="text" name="id" /> <input type="submit" value="確定" /><p>
		</form>
	</div>
	
	
	<div class="insert">
	<form method="post" action="InsertCancerData">
	<h2 align="center">請輸入欲<q>新增</q>的資料</h2>
	<table>
	<tr><td>輸入編號:<td><input type="text" name="cno"  />
	<tr><td>輸入年別:<td><input type="text" name="cyear" />			
	<tr><td>輸入死因:<td><input    type="text" name="ccause" />
	<tr><td>輸入順位:<td><input type="text" name="crank" />
	<tr><td>輸入死亡人數合計:<td><input type="text" name="cdeatotal" />
	<tr><td>輸入死亡人數男:<td><input type="text" name="cdeathman" />
	<tr><td>輸入死亡人數女:<td><input type="text" name="cdeathwoman" />
	<tr><td>輸入死亡率合計:<td><input type="text" name="cdeathrate" />
	<tr><td>輸入死亡率/男:<td><input type="text" name="cdeathrateman" />
	<tr><td>輸入死亡率/女:<td><input type="text" name="cdeathratewoman" />
	<tr><td><td><input type="submit" value="確定" />
	</table>	
	</form>
	</div>
	
	<div class="update">
	<form method="post" action="UpdateCancerData">
	<h2 align="center">請輸入欲<q>修改</q>的資料</h2>
		<table>
			<tr><td>輸入編號:<td><input type="text" name="cno" />
			<tr><td>輸入年別:<td><input type="text" name="cyear" />
			<tr><td>輸入死因:<td><input type="text" name="ccause" />
			<tr><td>輸入順位:<td><input type="text" name="crank" />
			<tr><td>輸入死亡人數合計:<td><input type="text" name="cdeatotal" />
			<tr><td>輸入死亡人數男:<td><input type="text" name="cdeathman" />
			<tr><td>輸入死亡人數女:<td><input type="text" name="cdeathwoman" />
			<tr><td>輸入死亡率合計:<td><input type="text" name="cdeathrate" />
			<tr><td>輸入死亡率/男:<td><input type="text" name="cdeathrateman" />
			<tr><td>輸入死亡率/女:<td><input type="text" name="cdeathratewoman" />
			<tr><td><td><input type="submit" value="確定" />
		</table>
	</form>
	</div>
	
	<div class="delete" >
		<h2 align="center">請輸入欲<q>查詢</q>的資料</h2>
		<form method="post" action="KeywordFindCancer">
			請輸入死因 : <input type="text" name="name1" /> <input type="submit" value="確定" /><p>
		</form>
	</div>
	
	
</body>
</html>