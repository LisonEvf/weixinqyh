<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>


<!DOCTYPE html>
<html>
 <head>    
    <title>Login</title>

	<meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
	<link rel="stylesheet" type="text/css" href="jsp/css/styles.css">

</head>
  
<body>
	<div class="wrapper">
	<div class="container">
		<h1>后台管理</h1>
		<form class="form" action="index" method="post">
			<input type="text" name="username" placeholder="Username">
			<input type="password" name="password" placeholder="Password"><br>
			<button type="submit" id="login-button" ><strong>登陆</strong></button><br>
			<font color="red">${error}</font>
		</form>
	</div>
	
	<ul class="bg-bubbles">
		<li></li>
		<li></li>
		
	</ul>

	</div>
</body>
</html>
