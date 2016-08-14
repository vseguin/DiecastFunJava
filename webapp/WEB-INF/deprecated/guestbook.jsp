<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="false"%>
<html>
<head>
<meta name="description" content="Collection of 1/64 diecasts.">
<meta name="keywords" content="diecast,car,cars,diecasts,models">
<meta name="author" content="Vincent Séguin">
<meta charset="utf-8">
<title>1/64 Diecast Fun</title>
<link href="<c:url value="/resources/css/bootstrap.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/jquery.gridster.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/app.css" />" rel="stylesheet">
<link rel="icon"
	href="<c:url value="/resources/images/templates/favicon.ico" />"
	type="image/x-icon" />
</head>
<body>
	<c:import url="navbar.jsp" />
	<div class="container">
		<c:import url="header.jsp" />
		<br>
		<ul class="breadcrumb">
			<li><a href="/">Home</a> <span class="divider">/</span></li>
			<li class="active">Guestbook</li>
		</ul>
		<div class="row-fluid">
			<h1 class="whitetext span6 well centered">Guestbook</h1>
			<br> <br> <br> <br> <br> <br> <div>Want
				to leave comments on cars or suggestions for the site? Take time to
				write a little message!</div><br>
			<c:url
				value="/guestbook"
				var="url" />
			<form action="${url}" method=POST scope="request"
				commandName="comment">
			<div><b>Your name : &nbsp;</b><input style="margin-top:8px;" type="text" name="username" value="${comment.username}" required></div>
			<div><b>Your message : </b></div>
			<div><textarea style="margin-top:8px; width:500px;" cols="50" rows="10" name="message" value="${comment.message}" required></textarea></div>
		<input type="submit" class="btn btn-success pull-right"
			value="Submit">
		</form>
		<c:import url="guestbooklist.jsp" />
	</div>
	</div>
	<script
		src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/js/bootstrap.js" />" /></script>
	<script type="text/javascript"
		src="<c:url value="/resources/js/jquery.gridster.js" />" /></script>
	<script type="text/javascript"
		src="<c:url value="/resources/js/app.js" />" /></script>
	<script type="text/javascript">
		animateGridster();
	</script>
	<c:import url="footer.jsp" />
</body>
</html>
