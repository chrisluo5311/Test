<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
        import="java.util.*,com.chrisproject.Bean.CancerBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="com.chrisproject.CSS/update.css" rel="stylesheet">
<title>UpdateCancerData</title>
</head>
<body style="background-color: #fdf5e6">

<jsp:useBean id = "can" scope="request" class="com.chrisproject.Bean.CancerBean"/>
<div class="udpatediv1">
	<form method="post" action="UpdateCancerData">
	<table class="table2" >
		<tr><td>資料編號
			<td><input type="text" name="cno" value="<%= can.getCanno() %>">
		<tr><td>年別<td><input type="text" name="cyear" value="<%= can.getYear() %>">
		<tr><td>死因<td><input type="text" name="ccause" value="<%= can.getCauseOfDeath() %>">
		<tr><td>順位<td><input type="text" name="crank" value="<%= can.getRank() %>">
		<tr><td>死亡人數合計<td><input type="text" name="cdeatotal" value="<%= can.getDeathTotal() %>">
		<tr><td>死亡人數男<td><input type="text" name="cdeathman" value="<%= can.getDeathMan() %>">
		<tr><td>死亡人數女<td><input type="text" name="cdeathwoman" value="<%=can.getDeathWoman() %>">
		<tr><td>死亡率合計<td><input type="text" name="cdeathrate" value="<%=can.getDeathRate() %>">
		<tr><td>死亡率/男<td><input type="text" name="cdeathrateman" value="<%=can.getDeathRateMan() %>">
		<tr><td>死亡率/女<td><input type="text" name="cdeathratewoman" value="<%=can.getDeathRateWoman() %>">
		<tr><td><td><input type="submit" value="確定" />
		</table>
	</form>	
	
	<form method="post" action="GellAllCancerData">
	<table class="tablesubmit">
		<tr><td><td><input type="submit" value="返回" />
	</table>	
	</form>
</div>


	


</body>
</html>