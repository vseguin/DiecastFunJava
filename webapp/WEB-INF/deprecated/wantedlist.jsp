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
			<li class="active">Wanted List</li>
		</ul>
		<div class="row-fluid">
			<h1 class="whitetext span6 well centered title">Wanted List</h1>
		</div>
		If you ever have one of them or find one, please contact me as soon as
		possible!<br> <br>
		<c:forEach var="listItem" items="${wantedList}">
			<h2>${listItem.key}</h2>
			<table class="table table-striped">
				<thead>
					<tr>
						<th>Makers</th>
						<th>Models</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="wantedCar" items="${listItem.value}">
						<tr data-id="${wantedCar.id}">
							<td>${wantedCar.brand}</td>
							<td>${wantedCar.model}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:forEach>
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
