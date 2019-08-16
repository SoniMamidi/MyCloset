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
<script src="js/itemActions.js" language="javascript"></script>
</head>
<body>
<jsp:include page="adminHeader.jsp" />
<div class="body-content">
<div class="col-md-12 col-xs-12 pd0">
<div class="col-md-6 col-xs-12 pl0">
<div class="OrdersTitle">Orders</div>
<div class="orders">
<c:forEach items="${Orders}" var="order">
<c:set var="orderitem" value="${order.getItem(order.item_id)}"></c:set>
<c:set var="orderUser" value="${order.getUser(order.customer_id)}"></c:set>
<div class="order class="col-md-12 col-xs-12 pd0">
<div class="Order-Bundle-ID">${order.bundle_id}</div>
<div class="col-md-2 imageUrl">
<img src="${orderitem.imageurl}">
</div>
<div class="col-md-6">
<div class="orderName">${orderitem.name}</div>
<div class="orderBy">Ordered by ${orderUser.name}</div>
<div></div>
</div>
<div class="clear_fix"></div>
</div>
</c:forEach>
</div>
</div>
<div class="col-md-6 col-xs-12 pr0 ">

<div class="OrdersTitle">Yet to be Approved Items</div>
<div class="items">
<c:forEach items="${UnapprovedList}" var="item">

<c:set var="user" value="${item.getUser(item.customer_id)}"></c:set>
<div class="itemBlock">
<input type="hidden" value="${item.itemid}" class="itemid"/>
<div class="itemHeader">
<div class="col-md-6">
<div class="orderName">${item.name}</div>
<div class="orderBy">Donated by ${user.name}</div>
</div>
<div style=''>

</div>
<div class="col-md-6">
<div class="adminactions">
<span class="glyphicon glyphicon-remove itemRemove"></span>
<span class="glyphicon glyphicon-ok itemApprove"></span>
</div>
</div>
<div class="clear_fix"></div>

</div>
<div class="itemDetails">
<div class="col-md-4 itemIMG">
<img src="${item.imageurl}">
</div>
<div class='col-md-4 pd0'>
<div class="itemSpec">Color:<span>${item.color}</span></div>
<div class="itemSpec">Category:<span>${item.category}</span></div>
<div class="itemSpec">Size:<span>${item.size}</span></div>
<div class="itemSpec">Age:<span>${item.itemAge}</span></div>
<div class="itemSpec">Brand:<span>${item.imagebrand}</span></div>
</div>
<div class="col-md-4">
<div class="AskPrice">${item.itemprice}</div>
</div>
<div class="clear_fix"></div>
</div>
</div>
</c:forEach>
</div>
</div>
</div>
</div>
</body>
</html>