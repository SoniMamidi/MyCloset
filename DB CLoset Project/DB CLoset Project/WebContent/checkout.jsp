<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="css/common.css" rel="stylesheet" type="text/css" />
<script src="js/jquery-3.1.1.min.js" language="javascript"></script>

<script src="https://www.gstatic.com/firebasejs/3.6.3/firebase.js"></script>
<script src="js/actions.js"></script>
</head>
<body>
<jsp:include page="header.jsp" />
<div class="clear_fix"></div>
<div class="body-content cartPage">
<div class="titlePage">Checkout</div>
<c:if test="${fn:length(cartItems) gt 0}">
<div class="col-md-7 col-xs-12 pd0 cartContainer">
<c:forEach items="${cartItems}" var="current">
<div class="col-md-12 col-xs-12 pl0 CartItemBlock">
<div class="col-md-2 CartIMG">
<img src="${current.getImgURl()}"/>
</div>
<div class="col-md-7 col-xs-12">
<div class="cName">${current.itemName}</div>
<form class="removeCartItemForm" method="get" action="CartItemActions">
<input type="hidden" value="${current.cartItemID}" name="itemid"/>
<button class="removeFromCart"><span class="glyphicon glyphicon-remove removeItem"></span>Remove</button>
</form>
</div>
<div class="col-md-3 col-xs-12"><span class="cPrice">${current.itemPrice}</span></div>
<div class="clear_fix"></div>
</div>
<div class="clear_fix"></div>
 </c:forEach>
 </div>
<c:set var="total" value="${0}"/>
 <div class="col-md-3 col-xs-12 pr0 checkoutTable">
 <c:forEach items="${cartItems}" var="current" varStatus="loop">
 <div class="row-cart"><span class="orderNO">order-${loop.index+1}</span><span class="orderPrice">${current.itemPrice}</span><div class="clear_fix"></div></div>
 <c:set var="total" value="${total + current.itemPrice}" />
 <div class="clear_fix"></div>
 </c:forEach>
 <c:set var="productTotal" value="${total}"/>
<c:set var="tax" value="${total*0.05}"/>

  <div class="row-cart"><span class="orderNO">Tax(5%)</span><span class="orderPrice"><fmt:formatNumber type="number" maxFractionDigits="2" value="${tax}"/></span><div class="clear_fix"></div></div>
 <div class="clear_fix"></div>
 <c:set var="total" value="${total+tax}"/>
 <c:if test="${total gt 50}">
 <c:set var="Shipping" value="${0}"/>
 </c:if>
 <c:if test="${total lt 50}">
 <c:set var="Shipping" value="${10}"/>
  <c:set var="total" value="${total+Shipping}"></c:set>
 </c:if>
 <div class="row-cart"><span class="orderNO">Shipping:</span><span class="orderPrice">${Shipping}</span><div class="clear_fix"></div></div>
 <div class="clear_fix"></div>

 <div class="totalingDiv"><span class="orderNO">Total:</span><span class="orderPrice">${total}</span><div class="clear_fix"></div></div>
 </div>
 
 <div class="PlaceOrder">
 <form class="placeOrderForm" method="post" action="OrderServlet">
 <input type="hidden" value="${tax}" name="tax"/>
  <input type="hidden" value="${Shipping}" name="shipping"/>
  <input type="hidden" value="${productTotal}" name="product_total"/>
  <input type="hidden" value="${fn:length(cartItems)}" name="cart_count"/>

 <input type="submit" value="Purchase Products" class="purchase"/>
 </form>
 </div>
 <%-- <div class="address-block">
 <div class="">Shipping Address:</div>
 <div class="">${user.getAddress().getAddressLine()}</div>
 </div> --%>
 </c:if>
 <div class="clear_fix"></div>
 <c:if test="${fn:length(cartItems) eq 0}">
 <div class="no-items">
 <div>No items in Cart</div>
 <form method="get" action="ItemsRetrievalServlet" class="ItemsRetrievalServlet">
 <input type="submit" value="Continue Shopping" class="continue_Shopping">
 </form>
 </div>
 
 </c:if>
 </div>
</body>
</html>