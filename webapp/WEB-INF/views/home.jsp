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

<link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.6/css/materialize.min.css"
    rel="stylesheet">
<link href="<c:url value="/resources/css/app.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/header.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/nav.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/sidepanel.css" />" rel="stylesheet">
<link rel="icon"
	href="<c:url value="/resources/img/favicon.ico" />"
	type="image/x-icon" />
<meta name="viewport" content="width=device-width, initial-scale=1.0"/>

<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="https://code.jquery.com/ui/1.11.1/jquery-ui.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.6/js/materialize.min.js"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/app.js" />" /></script>
</head>
<body>
    <c:import url="nav.jsp" />
    <c:import url="header.jsp" />
    <div class="container">
    	<div class="row">
   			<h4>About</h4>
   			<p>1/64 Diecast Fun displays my entire diecast collection that started when i was only 3 years old. The collection is mainly focused
   			on road cars and trucks, coming from various makers and eras. I currently own <strong>${carcount}</strong> models, and this just keep
   			on growing. Enjoy browsing them, take a look at my <a href="https://www.instagram.com/164diecastfun">Instagram feed</a> and my <a href="<c:url value="/wantedlist"/>">wanted list</a> as well!</p>
    	</div>
    	<div class="row row-reversed blue-bg-fade">
   			<h4>Featured car</h4>
   			<div>
   			<c:forEach var="picture" items="${featuredcar.pictures}">
	   			<div class="col l4 m12 s12">
					<div class="card">
						<div class="card-image">
							<img src="<c:url value="https://s3-us-west-2.amazonaws.com/elasticbeanstalk-us-west-2-013875902762/resources/images/cars-small/${picture}"/>">
						</div>
					</div>
				</div>
			</c:forEach>
			<div class="col s12">
				<div class="card">
					<div class="card-action">
						<!--  vseguin: todo this -->
						<a href="<c:url value="/cars/${featuredcar.id}"/>">${featuredcar.maker}&nbsp;<c:if test="${featuredcar.brand != 'Generic'}">${featuredcar.brand}&nbsp;</c:if>${featuredcar.model}</a>
					</div>
				</div>
			</div>
			</div>
    	</div>
    	<div class="row">
   			<h4>New additions</h4>
			<c:choose>
				<c:when test="${fn:length(newadditions) == 0}">
					<span>No recent additions.</span>
				</c:when>
				<c:otherwise>
					<!--  vseguin: todo this -->
					<ul class="thumbnails">
						<c:forEach var="car" items="${newadditions}">
							<c:set var="carpicture" value="${car.thumbnail}" />
							<li class="span3" style="margin-left: 0px; height: 150px;"><a
								href="<c:url value="/cars/${car.id}"/>" class="thumbnail"
								title="${car.brand} ${car.model}"> <img
									src="<c:url value="https://s3-us-west-2.amazonaws.com/elasticbeanstalk-us-west-2-013875902762/resources/images/cars-small/${car.thumbnail}"/>" style="width: 250px;"></a>
								<p class="centered whitetext" style="font-size: 12px;">
									<b>${car.brand} ${car.model}</b>
								</p></li>
						</c:forEach>
					</ul>
				</c:otherwise>
			</c:choose>
    	</div>
    	<div class="row row-reversed blue-bg-fade">
   			<h4>Test</h4>
    	</div>
    </div>
</body>
</html>
