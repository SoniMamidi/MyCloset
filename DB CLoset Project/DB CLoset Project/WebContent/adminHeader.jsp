<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="js/jquery-3.1.1.min.js" language="javascript"></script>
<script src="https://www.gstatic.com/firebasejs/3.6.3/firebase.js"></script>
<script src="js/cart.js"></script>
<script src="js/actions.js"></script>
</head>
<body>
<form class="logoutForm" method="get" action="LogoutServlet">

</form>
<div class="header">

<div class="header-block">

<div class="user-popup">

<ul class="user-actions">

<li class="logout"><span class="glyphicon glyphicon-off"></span><span>Logout</span></li>
</ul>


</div>
<div class="project-name">MyCloset.com</div>

<div class="user"><span class="glyphicon glyphicon-user user-icon"></span><span class="user-name">${user.getUsername()}</span></div>
<div class="clear_fix">
</div>
</div>
</div>
</body>
</html>