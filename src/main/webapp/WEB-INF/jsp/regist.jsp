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
<h3 class="t_red">${errMsg}</h3>
<form:form modelAttribute="registForm" action="${pageContext.request.contextPath}/newRegist" method="POST">
<table>
  <tr>
    <td>メールアドレス</td>
    <td><form:input path="mailAddress" /></td>
  </tr>
  <tr>
    <td>パスワード</td>
    <td><form:password path="password" /></td>
  </tr>
  <tr>
    <td>名前</td>
    <td><form:input path="name" /></td>
  </tr>
  <tr>
    <td colspan="2"><form:button name="regist">登録ゥ！</form:button></td>
  </tr>
</table>
<form:errors path="mailAddress" />
<form:errors path="password" />
</form:form>
</body>
</html>
