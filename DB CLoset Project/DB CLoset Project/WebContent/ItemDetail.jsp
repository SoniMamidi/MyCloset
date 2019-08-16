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
<c:set var="detailItem" value="${DetailItem}"/>
<div class="ItemDetail">
<input type="hidden" class="itemID" value="${detailItem.itemid}"/>
<div class="item-heading">${detailItem.name}</div>
<div class="col-md-12 pd0">
<div class="price-detail">${detailItem.itemprice} $</div>
<div class="col-md-5 pd0 image-detail">
<img src="${detailItem.imageurl}">
</div>
<div class="col-md-7 pd0">
<div class="mt10"><span class="detail_label">Brand :</span><span class="bName">${detailItem.imagebrand}</span></div>
<div class="mt10"><span class="detail_label">Category :</span><span class="bName">${detailItem.category}</span></div>
<div class="mt10"><span class="detail_label">Color :</span><span class="bName">${detailItem.color}</span></div>
<div class="mt10"><span class="detail_label">Size Available  :</span><span class="bName">${detailItem.size}</span></div>
<div class="mt10"><span class="detail_label">Description :</span><span class="bName">${detailItem.description}</span></div>
<div class="mt10"><span class="detail_label">Product Age :</span><span class="bName">${detailItem.itemAge}</span></div>
<div class="addTocart">
<input type="hidden" value="${detailItem.itemid}" class="itemID" />
<button class="addtoCart"><span class="glyphicon glyphicon-shopping-cart"></span> Add to cart</button>
</div>
</div>
<div class="clear_fix"></div>
</div>

<div class="clear_fix"></div>
</div>
</body>
</html>