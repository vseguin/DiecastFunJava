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
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.2/themes/smoothness/jquery-ui.css" />
<link href="<c:url value="/resources/css/smoothDivScroll.css" />"
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
			<li class="active">Home</li>
		</ul>
		<div class="row-fluid">
			<div class="span8 well">
				<h1>New additions</h1>
				<c:choose>
					<c:when test="${fn:length(newadditions) == 0}">
						<span class="whitetext bold">0 new additions for the
							moment.</span>
					</c:when>
					<c:otherwise>
						<ul class="thumbnails">
							<c:forEach var="car" items="${newadditions}">
								<c:set var="carpicture" value="${car.thumbnail}" />
								<li class="span3" style="margin-left: 0px; height: 150px;"><a
									href="<c:url value="/cars/${car.id}"/>" class="thumbnail"
									title="${car.brand} ${car.model}"> <img
										src="<c:url value="${picturesUrl}/cars-small/${car.thumbnail}"/>"
										style="width: 250px;"></a>
									<p class="centered whitetext" style="font-size: 12px;">
										<b>${car.brand} ${car.model}</b>
									</p></li>
							</c:forEach>
						</ul>
					</c:otherwise>
				</c:choose>
			</div>
			<div class="span4 well">
				<h3>Restorations</h3>
				<c:choose>
					<c:when test="${fn:length(restorations) != 0}">
						<a href="<c:url value="/restorations" />">
							<div id="restorations">
								<c:forEach var="car" items="${restorations}">
									<c:set var="carpicture" value="${car.thumbnail}" />
									<img
										src="<c:url value="${picturesUrl}/cars-small/${car.thumbnail}"/>" />
								</c:forEach>
							</div>
						</a>
					</c:when>
					<c:otherwise>No restorations at this time.</c:otherwise>
				</c:choose>
				<h3>Customs</h3>
				<c:choose>
					<c:when test="${fn:length(customs) != 0}">
						<a href="<c:url value="/customs" />">
							<div id="customs">
								<c:forEach var="car" items="${customs}">
									<c:set var="carpicture" value="${car.thumbnail}" />
									<img
										src="<c:url value="${picturesUrl}/cars-small/${car.thumbnail}"/>" />
								</c:forEach>
							</div>
						</a>
					</c:when>
					<c:otherwise>No customs at this time.</c:otherwise>
				</c:choose>
				<h3>Most popular</h3>
				<c:choose>
					<c:when test="${fn:length(mostpopular) != 0}">
						<a href="<c:url value="/mostpopular" />">
							<div id="mostpopular">
								<c:forEach var="car" items="${mostpopular}">
									<c:set var="carpicture" value="${car.thumbnail}" />
									<img
										src="<c:url value="${picturesUrl}/cars-small/${car.thumbnail}"/>" />
								</c:forEach>
							</div>
						</a>
					</c:when>
					<c:otherwise>No votes at this time.</c:otherwise>
				</c:choose>
				<h3>
					<a class="whitetext" href="https://www.instagram.com/164diecastfun">See on Instagram</a>
				</h3>
			</div>
		</div>
		<div class="row-fluid">
			<div class="span12 well">
				<h2 style="font-size: 22px;">
					Featured Car : <a class="whitetext"
						href="<c:url value="/cars/${featuredcar.id}"/>">${featuredcar.maker}&nbsp;<c:if
							test="${featuredcar.brand != 'Generic'}">${featuredcar.brand}&nbsp;</c:if>${featuredcar.model}</a>
				</h2>
				<ul class="thumbnails">
					<c:forEach var="picture" items="${featuredcar.pictures}">
						<li class="span4"><img
							src="<c:url value="${picturesUrl}/cars-small/${picture}"/>"
							style="width: 300px;"
							title="<c:choose><c:when test="${featuredcar.brand == 'Generic'}">${featuredcar.model}</c:when><c:otherwise>${featuredcar.brand} ${featuredcar.model}</c:otherwise></c:choose>">
						</li>
					</c:forEach>
				</ul>
			</div>
		</div>
		<div class="row-fluid">
			<div class="span8 well">
				<h1>About</h1>
				<span class="span7" style="margin-left: -4px;"><img
					class="midlogo"
					src="<c:url value="/resources/images/templates/diecastfunlogomid.png" />" />
				</span> <span class="whitetext bold">is a website displaying my
					entire collection, that began 17 years ago. Since I received my
					first little car, when I was 3 years old, I always enjoyed
					collecting those little colorful diecasts. The collection has grown
					to more than 1500 cars actually, so it was the time to display them
					properly. I hope you'll enjoy browsing these pages as much as I
					love browsing them.</span>
			</div>
			<div class="span4 well">
				<h3>
					<a class="goldtext" href="<c:url value="facets" />">Advanced
						Search</a>
				</h3>
			</div>
			<div class="span4 well">
				<h3>
					<a class="whitetext" href="<c:url value="guestbook" />">Guestbook</a>
				</h3>
			</div>
		</div>
	</div>
	<c:import url="footer.jsp" />
	<script
		src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
	<script
		src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.2/jquery-ui.min.js"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/js/bootstrap.js" />" /></script>
	<script type="text/javascript"
		src="<c:url value="/resources/js/jquery.mousewheel.min.js" />" /></script>
	<script type="text/javascript"
		src="<c:url value="/resources/js/jquery.kinetic.js" />" /></script>
	<script type="text/javascript"
		src="<c:url value="/resources/js/jquery.smoothDivScroll-1.3.js" />" /></script>
	<script type="text/javascript"
		src="<c:url value="/resources/js/app.js" />" /></script>
	<script type="text/javascript">
		$(document).ready(function() {

			$("#mostpopular").smoothDivScroll({
				mousewheelScrolling : "allDirections",
				manualContinuousScrolling : true,
				autoScrollingMode : "always",
				autoScrollingInterval : 30
			});

			$("#restorations").smoothDivScroll({
				mousewheelScrolling : "allDirections",
				manualContinuousScrolling : true,
				autoScrollingMode : "always",
				autoScrollingInterval : 30
			});

			$("#customs").smoothDivScroll({
				mousewheelScrolling : "allDirections",
				manualContinuousScrolling : true,
				autoScrollingMode : "always",
				autoScrollingInterval : 30
			});
		});
	</script>
</body>
</html>
