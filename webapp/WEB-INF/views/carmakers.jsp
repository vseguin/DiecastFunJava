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
			<li><a href="/diecastfun">Home</a> <span class="divider">/</span></li>
			<li class="active">Maker Brands</li>
		</ul>
		<div class="row-fluid">
			<h1 class="whitetext span6 well centered" style="font-size:30px;">Search by Maker Brand</h1>
			<br> <br> <br> <br> <br>
			<h4>Mouse hover on the maker pictures to see more details.</h4>
			<c:import url="carmakerstemplate.jsp" />
			<h1 class="whitetext span4 well pull-right">
				<img class="mediumicon"
					src="<c:url value="${picturesUrl}/templates/zoom.png" />"><a
					class="whitetext underline" href="cars/allcars">See All</a>
			</h1>
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
