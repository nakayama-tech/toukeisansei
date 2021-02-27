<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<head>
<meta charset="UTF-8">
<title>トウケイサンセイ検索画面</title>
</head>
<body>
<form:form modelAttribute="searchForm" action="${pageContext.request.contextPath}/search" method="POST">
<table>
	<tr>
		<td>競馬場</td>
		<td>
			<form:select path="keibajou">
				<form:option value="001" label="東京競馬場" />
				<form:option value="002" label="京都競馬場" />
				<form:option value="003" label="阪神競馬場" />
				<form:option value="004" label="中山競馬場" />
				<form:option value="005" label="中京競馬場" />
				<form:option value="006" label="札幌競馬場" />
				<form:option value="007" label="函館競馬場" />
				<form:option value="008" label="福島競馬場" />
				<form:option value="009" label="新潟競馬場" />
				<form:option value="010" label="小倉競馬場" />
			</form:select>
		</td>
		<td>芝・ダート</td>
		<td>
			<form:select path="shibaDirt">
				<form:option value="001" label="芝" />
				<form:option value="002" label="ダート" />
			</form:select>
		</td>
		<td>距離</td>
		<td>
			<form:select path="kyori">
				<form:option value="1" label="1000" />
				<form:option value="2" label="1100" />
				<form:option value="3" label="1200" />
				<form:option value="4" label="1300" />
				<form:option value="5" label="1400" />
				<form:option value="6" label="1500" />
				<form:option value="7" label="1600" />
				<form:option value="8" label="1700" />
				<form:option value="9" label="1800" />
				<form:option value="10" label="2000" />
				<form:option value="11" label="2200" />
				<form:option value="12" label="2400" />
				<form:option value="13" label="2600" />
				<form:option value="14" label="3000" />
				<form:option value="15" label="3200" />
				<form:option value="16" label="3400" />
				<form:option value="17" label="3600" />
				<form:option value="18" label="1000" />
				<form:option value="19" label="1150" />
				<form:option value="20" label="1200" />
				<form:option value="21" label="1300" />
				<form:option value="22" label="1400" />
				<form:option value="23" label="1600" />
				<form:option value="24" label="1700" />
				<form:option value="25" label="1800" />
				<form:option value="26" label="1900" />
				<form:option value="27" label="2000" />
				<form:option value="28" label="2100" />
				<form:option value="29" label="2300" />
				<form:option value="30" label="2400" />
				<form:option value="31" label="2500" />
				<form:option value="32" label="2600" />
			</form:select>
		</td>
	</tr>
	<tr>
		<td>
			<form:button name="search">検索ゥ！</form:button>
		</td>
	</tr>
</table>
</form:form>
</body>
</html>