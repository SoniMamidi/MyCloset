<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Set Up Account</title>
<link href="css/common.css" rel="stylesheet" type="text/css" />
<script src="js/jquery-3.1.1.min.js" language="javascript"></script>
<script src="js/actions.js" language="javascript"></script>
</head>
<body>
<div class="setup_account"></div>
<div class="tile_account">
<div class="tilename">Welcome <span class="boldMe">${user.getName()}</span> </div>
<div class="acc_first-details">
<form action="SignupServlet" method="get" name="SetUp">
<div class="mt10 boldMe">What are you?</div>
<div class="mt10">
<span><input type="radio" value="Student" name="connection" id="Student"><label for="Student">Student</label></span>
<span><input type="radio" value="Alumni" name="connection" id="Alumni"><label for="Alumni">Alumni</label></span>
<span><input type="radio" value="Other" name="connection" id="Other"><label for="Other">Other</label></span>
</div>
<div class="mt10">News Letter Subscription</div>
<div class="mt10"><input type="radio" name="newsSubscription" id="newsyes" value="true"><label for="newsyes">Yes</label></div>
<div class="mt10"><input type="radio" name="newsSubscription" id="newsNo" value="false"><label for="newsNo">No</label></div>

<input type="submit" value="Set Up" id="setup">
</form>
</div>
</div>
</body>
</html>