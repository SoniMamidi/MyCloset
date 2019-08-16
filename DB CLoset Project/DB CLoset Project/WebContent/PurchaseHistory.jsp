<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
<div class="body-content">
<c:if test="${success}">
<div class="successNotification">
<div class="successTitle">Your order has been placed successfully<span class="glyphicon glyphicon-ok"></span></div>
<div class="helpInfo">
Once you summit your order, it immediately enters our order processing system so it is not possible to change the order in any way once it has been submitted.
If you need to place an additional order, please contact a Dell sales representative at X-XXX-XXXXXXX or visit us.
</div>
</div>
</c:if>
<div class="col-md-12 pl0 orders-container">

<div class="OrdersTitle">Previous Orders</div>
<div class="dup_container">
<c:forEach items="${OrdersList}" var="order">

<c:set var="OrderObj" value="${order.getItem(order.item_id)}"/>
<div class="orderPage col-md-12 col-xs-12 pd0">
<div class="Order-Bundlecode">Order Id: <span class="order-ID">${order.bundle_id}</span></div>
<div class="order-details">
<div class="col-md-2 imgURLORDR">
<img src="${OrderObj.imageurl}">
</div>
<div class="col-md-6">
<div class="orderName">${OrderObj.name}</div>
<div class="orderBy">Ordered on ${order.date_ordered}</div>
<div class="orderStatus">${OrderObj.imagebrand}</div>
<div></div>
</div>
<div class="col-md-2">
<div class="oBrand">${order.order_status}</div>
</div>
<div class="col-md-2">
<div class="order-price">${OrderObj.itemprice}</div>
</div>
<div class="clear_fix"></div>
</div>
<div class="clear_fix"></div>
</div>
</c:forEach>
</div>
</div>
<div class="col-md-6">
<div class="purchaseNotification">

</div>
</div>
<div class="clear_fix"></div>
</div>
</body>
</html>