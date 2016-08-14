<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
<link href="<c:url value="/resources/css/app.css" />" rel="stylesheet">
<link rel="icon"
	href="<c:url value="/resources/images/templates/favicon.ico" />"
	type="image/x-icon" />
<link rel="stylesheet" type="text/css"
	href="http://fonts.googleapis.com/css?family=Crafty Girls">
</head>
<body>
	<c:import url="navbar.jsp" />
	<div class="container">
		<c:import url="header.jsp" />
		<br>
		<ul class="breadcrumb">
			<li><a href="/">Home</a> <span class="divider">/</span></li>
			<li class="active">Eras</li>
		</ul>
		<div class="row-fluid">
			<h1 class="whitetext span6 well centered">Search by Eras</h1>
		</div>
		<br>
		<div class="row-fluid">
			<c:forEach var="era" items="${eras}">
				<span class="span4 centered"
					style="margin: 50px 0px; font-size: 40px; font-family: 'Crafty Girls'; text-shadow: black 0.1em 0.1em 0.7em;"><a
					class="whitetext" href="<c:url value="eras/${era}" />"><b>${era}</b></a></span>
			</c:forEach>
		</div>
		<br>
	</div>
	<script
		src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/js/bootstrap.js" />" /></script>
	<script type="text/javascript"
		src="<c:url value="/resources/js/app.js" />" /></script>
	<c:import url="footer.jsp" />
</body>
</html>
