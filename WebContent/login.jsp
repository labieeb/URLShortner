<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="login.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
   <div class="box">
        <h2>Sign In</h2>
        <form method="get" action="Login">
            <div>
                <div class="inputBox">
                    <input class="email" name="username" required onkeyup="this.setAttribute('value',this.value);"value="">

                    <label>Username</label>
                </div>
                <div class="inputBox">
                    <input class="Password" name="password" required onkeyup="this.setAttribute('value',this.value);"value="">
                    <label>Password</label>
                </div>
                <input type="Submit" name="sign-In" value="sign-In">
        </form>
		<a style="padding-left: 150px" href="./signup.jsp">Register</a>
    </div>
</body>
</html>