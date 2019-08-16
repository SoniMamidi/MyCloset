<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="css/common.css" rel="stylesheet" type="text/css" />
<script src="js/jquery-3.1.1.min.js" language="javascript"></script>
<script src="js/actions.js"></script>

<script src="https://www.gstatic.com/firebasejs/3.6.3/firebase.js"></script>
</head>
<body>
<jsp:include page="header.jsp" />

<input type="hidden" class="activePage" value="donate"/>
<div class="body-content">
<div class="donateItem col-md-12 pd0">

<div class="col-md-5 attributes-panel pl0">
<form action="DonateServlet" method="post" >
<input type="text" name="item-name" placeholder="Product Name"/>
<div class="mt10">
<input type="radio" name="gender" value="male" id="male"/><label for="male" checked>Product is for Male</label>
<input type="radio" name="gender" value="female" id="female"/><label for="female">Product is for Female</label>
</div>
<div class="mt10">
<select name="item-size">
<option value="X-Small">X-Small</option><option value="Small">Small</option><option value="Medium">Medium</option><option value="Large">Large</option>
<option value="X-Large">X-Large</option><option value="XX-Large">XX-Large</option><option value="XXX-Large">XXX-Large</option>
</select>
<select name="item-category" class="i-category mt10">

</select>
</div>
<input type="text" name="item-color" placeholder="Color" class="mt10"/>
<input type="text" name="item-brand" placeholder="Brand Name" class="mt10"/>
<input type="text" name="item-quantity" placeholder="Quantity" class="mt10"/>
<input type="text" name="item-price" placeholder="Asking Price" class="mt10"/>
<input type="text" name="item-age" placeholder="How Old is this?" class="mt10"/>
<textarea rows="8" class="mt10" placeholder="Product Description" name="description"></textarea>
<input type="hidden" class="imgURL" name="imgURL">
<input type="checkbox" value="show" name="showDetails" class="showDetails mt10" id="showDetails"><label for="showDetails">Donate as myself</label>
<input type="submit" class="submit_action" value="Donate my item"/>
</form>
</div>
<div class="col-md-7 image_section">
<div class="uploadImageForm">
<input type="file" name="img" class="imgData">
<button class="upload_action" value="uploadImage">Upload Image</button>
</div>
<img alt="uploaded-img" src="Images/index.jpg" class="img-upload">


</div>

</div>
</div>
<div class="clear_fix"></div>
</body>
</html>