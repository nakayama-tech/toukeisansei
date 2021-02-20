
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>トウケイ☆サンセイ</title>
</head>
<body>
トウケイ☆サンセイのページ
<form action="doAction" method="post">
  <table>
    <tr>
      <td>ログインID</td>
      <td><input type="text" name="loginId"></td>
    </tr>
     <tr>
      <td>パスワード</td>
      <td><input type="password" name="passwd"></td>
    </tr>
    <tr>
      <td colspan="2"><input type="submit" name="login" value="ログイン"/></td>
    </tr>
  </table><br><br>
  <input type="submit" name="regist" value="新規登録"/>
</form>
</body>
</html>