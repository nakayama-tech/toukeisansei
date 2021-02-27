<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<head>
	<title>新規会員登録</title>
</head>
<body>
新規会員登録
<form:form modelAttribute="registForm" action="${pageContext.request.contextPath}/toTop" method="POST">
<table>
  <tr>
    <td>登録完了！！！！！！</td>
  </tr>
  <tr>
    <td><form:button name="registComplete">トップへェ・・・</form:button></td>
  </tr>
</table>
</form:form>
</body>
</html>
