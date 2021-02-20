<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>新規会員登録</title>
</head>
<body>
新規会員登録
<form action="newRegist" method="POST">
<table>
  <tr>
    <td>メールアドレス></td>
    <td><input type="text" /></td>
  </tr>
  <tr>
    <td>パスワード</td>
    <td><input type="password" /></td>
  </tr>
  <tr>
    <td colspan="2"><input type="submit" name="regist" value="登録" /></td>
  </tr>
</table>
</form>
</body>
</html>
