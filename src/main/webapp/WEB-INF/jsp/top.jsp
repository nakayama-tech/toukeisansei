<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<head>
<meta charset="UTF-8">
<title>トウケイサンセイ</title>
</head>
<body>
トウケイサンセイのページへようこそ！
<h3 class="t_red">${errMsg}</h3>
<form:form modelAttribute="loginForm" action="${pageContext.request.contextPath}/doAction" method="post">
  <h3 class="t_red"><form:errors path="loginId" /></h3>
  <h3 class="t_red"><form:errors path="passwd" /></h3>
  <table>
    <tr>
      <td>ログインID</td>
      <td><form:input path="loginId" /></td>
    </tr>
     <tr>
      <td>パスワード</td>
      <td><form:password path="passwd" /></td>
    </tr>
    <tr>
      <td colspan="2"><form:button name="login">ログインッ！</form:button></td>
    </tr>
  </table><br><br>
  <form:button name="regist">新規登録ゥ！</form:button>
</form:form>
</body>
</html>