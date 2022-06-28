<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SignUp</title>
</head>
<body>
<h2>Sign-up page</h2>

<form method="post" action="/p01-springweb/app/user/registration">
	<input name="username" value="demo" placeholder="Username" />
	<input name="pwd" value="demo@123" placeholder="Password" />
	<input value="Create account" type="submit" />
</form>

</body>
</html>