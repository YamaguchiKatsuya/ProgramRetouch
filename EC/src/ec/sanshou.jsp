<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="y1.css">
<title>ユーザ情報詳細参照</title>
</head>
<body>
<ul class="nav navbar-nav navbar-right">
            <li class="navbar-text">${userInfo.login_id} さん </li>
  			<li class="dropdown">
  			  <a href="LogoutServlet" class="navbar-link logout-link">ログアウト</a>
            </li>
  		  </ul>
<h1 class="p">ユーザ情報詳細参照</h1>

<div class="p">
<span class="m15" for="id" style="width:150px;display: inline-block;">ログインID</span><span style="width:250px;display:inline-block;">${userDate.login_id}</span><br>

<span class="m15" for="pass" style="width:150px;display: inline-block;">ユーザ名</span><span style="width:250px;display:inline-block;">${userDate.name}</span><br>

<span class="m15" for="passk" style="width:150px;display: inline-block;">生年月日</span><span style="width:250px;display:inline-block;">${userDate.birth_date}</span><br>

<span class="m15" for="name" style="width:150px;display: inline-block;">登録日時</span><span style="width:250px;display:inline-block;">${userDate.create_date}</span><br>

<span class="m15" for="date" style="width:150px;display: inline-block;">更新日時</span><span style="width:250px;display:inline-block;">${userDate.update_date}</span></center><br>


</div>

<a href="ListServlet">戻る</a>
</body>
</html>