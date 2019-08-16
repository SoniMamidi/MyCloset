<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="css/common.css" rel="stylesheet" type="text/css" />
<script src="js/jquery-3.1.1.min.js" language="javascript"></script>

<script src="https://www.gstatic.com/firebasejs/3.6.3/firebase.js"></script>
<script src="js/actions.js"></script>
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp" />
<input type="hidden" class="activePage" value="shop"/>
<div class="col-md-12 col-xs-12 pd0 container-start">

<div class="items-container">
<c:forEach items="${Items}" var="current">
<div class="col-md-3 item-block col-xs-6">
        <div class="col-md-12 col-xs-12 item">
<div class="col-md-12 item-name">${current.name}</div>
<div class="item-price">${current.itemprice}</div>
<div class="col-md-12 col-xs-12 item-img pd0">
<img src="${current.imageurl}" />
</div>
<div class="btn block">
<form class="getProduct" action="ItemDetailServlet" method="post">
<input type="hidden" value="${current.itemid}" class="item_id" name="item_id">
<input type="submit" class="getProductData" value="I'm interested">
</form>
</div>
</div>
</div>
 </c:forEach>


</div>
</div>

</body>
</html>