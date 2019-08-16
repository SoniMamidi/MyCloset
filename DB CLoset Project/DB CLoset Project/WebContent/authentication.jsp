<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/common.css" rel="stylesheet" type="text/css" />
<script src="js/jquery-3.1.1.min.js" language="javascript"></script>
<script src="js/actions.js" language="javascript"></script>
<script src="https://www.gstatic.com/firebasejs/3.6.3/firebase.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="title">MyCloset.com</div>
<div class="background"></div>
<div class="authentication">

<div class="login">
<form action="LoginServlet" onsubmit="return validateForm(this)" method="post">
<input type="text" placeholder="User Name" name="username">
<input type="password" placeholder="Password" name="ePassword">
<a href="#" class="signup">New to this site? Create new account</a>
<input type="submit" value="Login" class="loginBtn">
</form>
</div>
<div class="signup-block">
<form action="SignupServlet" onsubmit="return validateForm(this)" method="post">
<input type="text" placeholder="FullName" name="fullName" >
<input type="text" placeholder="UserName" name="userName">
<input type="text" placeholder="Email" name="email">
<input type="text" placeholder="Phone No" class="phoneno" name="phoneNo">
<div>
<input type="text" placeholder="Apt Number,Street Name" name="addressLine">
<input type="text" placeholder="City" name="city">
<input type="text" placeholder="State" name="state">
<input type="text" placeholder="Postal Code" name="postalCode">
</div>
<input type="password" placeholder="Password" name="password">
<input type="password" placeholder="Repeat Password">
<a href="#" class="goLogin">Already have a account? Login</a>
<input type="submit" value="Create Account" class="signUpBtn">
</form>
</div>
</div>
</body>
</html>