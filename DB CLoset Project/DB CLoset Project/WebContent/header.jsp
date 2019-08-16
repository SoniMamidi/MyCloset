<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="js/jquery-3.1.1.min.js" language="javascript"></script>
<script src="js/cart.js"></script>
</head>
<body>
<div class="mask-a"></div>
<div class="mask-b"></div>
<div class="header">

<div class="header-block">
<div class="cart-popup-div">
<div class="cart-popup">
<div class="cartItemsContainer"></div>
<form class="goToCheckout" method="get" action="GoToCheckout">
<input type="submit" value="Checkout" class="checkoutBTN"/>
</form>
<form class="logoutForm" method="get" action="LogoutServlet">

</form>
</div>
</div>
<div class="user-popup">

<ul class="user-actions">

<li class="getOrders"><span class="glyphicon glyphicon-tasks"></span><span>Orders</span><span class="count"></span></li>
<li class="logout"><span class="glyphicon glyphicon-off"></span><span>Logout</span></li>
</ul>

<form method="get" action="DonateServlet" class="donateServlet"></form>
<form method="get" action="ItemsRetrievalServlet" class="ItemsRetrievalServlet"></form>
<form method="get" action="GetCartItems" class="CartItems"></form>
<form method="get" action="OrderServlet" class="getOrdersForm"></form>
</div>
<div class="project-name">MyCloset.com</div>
<div class="header-act shop">Shop</div>
<div class="header-act donate">Donate</div>
<div class="user"><span class="glyphicon glyphicon-user user-icon"></span><span class="user-name">${user.getUsername()}</span></div>
<div class="cart"><span class="glyphicon glyphicon-shopping-cart cart-sym"></span><span>Cart</span><span class="CartCount">0</span></div>
<div class="clear_fix">
</div>
</div>
</div>
</body>
</html>