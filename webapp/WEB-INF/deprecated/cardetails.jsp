<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page session="false"%>
<%@page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<meta name="description" content="Collection of 1/64 diecasts.">
<meta name="keywords"
	content="diecast,car,cars,diecasts,models,<c:if test="${car.brand != 'Generic'}">${fn:toLowerCase(car.brand)},</c:if>${fn:toLowerCase(car.model)},${fn:toLowerCase(car.maker)}">
<meta name="author" content="Vincent Séguin">
<meta charset="utf-8">
<title>${car.maker} <c:choose>
		<c:when test="${car.brand == 'Generic'}">${car.model}</c:when>
		<c:otherwise>${car.brand} ${car.model}</c:otherwise>
	</c:choose> - 1/64 Diecast Fun
</title>
<link href="<c:url value="/resources/css/bootstrap.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/shadowbox.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/app.css" />" rel="stylesheet">
<link rel="icon"
	href="<c:url value="/resources/images/templates/favicon.ico" />"
	type="image/x-icon" />
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
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
<script type="text/javascript"
	src="<c:url value="/resources/js/shadowbox.js" />" /></script>
<script type="text/javascript">
	Shadowbox.init();
</script>
</head>
<body>
	<div id="fb-root"></div>
	<script>
		(function(d, s, id) {
			var js, fjs = d.getElementsByTagName(s)[0];
			if (d.getElementById(id))
				return;
			js = d.createElement(s);
			js.id = id;
			js.src = "//connect.facebook.net/fr_FR/all.js#xfbml=1";
			fjs.parentNode.insertBefore(js, fjs);
		}(document, 'script', 'facebook-jssdk'));
	</script>
	<c:import url="navbar.jsp" />
	<div class="container">
		<c:import url="header.jsp" />
		<br>
		<ul class="breadcrumb">
			<li><a href="/diecastfun">Home</a> <span class="divider">/</span></li>
			<li class="active">${car.brand}&nbsp;${car.model}</li>
		</ul>
		<div class="row-fluid">
			<div class="span12">
				<h1 class="whitetext span6 well centered">
					<c:choose>
						<c:when test="${car.brand == 'Generic'}">
							<span class="whitetext">${car.model}</span>
						</c:when>
						<c:otherwise>
							<a class="whitetext"
								href="<c:url value="/carbrands/${car.brand}"></c:url>">${car.brand}</a>&nbsp;<span
								style="font-size: 60%;"><i>${car.model}</i></span>
						</c:otherwise>
					</c:choose>
					<c:if test="${car.isNew}">
						<span class="badge badge-important pull-right"
							style="font-size: 12px;">New!</span>
					</c:if>
				</h1>
				<div class="span6">
					<c:if test="${car.isRestaured}">
						<span class="badge badge-success cardetailstop">Restored</span>
					</c:if>
					<c:if test="${car.isCustomized}">
						<span class="badge badge-warning cardetailstop">Customized</span>
					</c:if>
				</div>
			</div>
			<ul class="thumbnails">
				<c:forEach var="picture" items="${car.pictures}">
					<li class="span4"><a
						href="<c:url value="${picturesUrl}/cars/${picture}"/>"
						rel="shadowbox[CarPictures]" class="thumbnail"> <img
							src="<c:url value="${picturesUrl}/cars/${picture}"/>"
							style="width: 300px;"
							title="<c:choose><c:when test="${car.brand == 'Generic'}">${car.model}</c:when><c:otherwise>${car.brand} ${car.model}</c:otherwise></c:choose>">
					</a></li>
				</c:forEach>
			</ul>
		</div>
		<div class="row-fluid">
			<div class="span4 well centered whitetext" style="font-size: 60px;">
				<h2>Scale</h2>
				<br>${car.scale}<br> <br>
			</div>
			<div class="span4 well centered whitetext">
				<h2>Maker</h2>
				<ul class="thumbnails">
					<li><a href="<c:url value="/makers/${car.maker}"></c:url>"
						class="thumbnail"> <img
							src="<c:url value="${picturesUrl}/makers/${fn:replace(fn:toLowerCase(car.maker),' ','')}.png" />"
							style="width: 300px;" title="${car.maker}">
					</a></li>
				</ul>
			</div>
			<div class="span4 well centered whitetext">
				<h2>Color</h2>
				<div style="background-color:${car.color}; border-style: solid;"
					title="${car.colorName}">
					<br> <br> <br>
				</div>
				<br>
			</div>
		</div>
		<div class="row-fluid">
			<span class="span6 well">
				<h1 class="pull-left whitetext">Categories</h1> <span class="span12">
					<c:forEach var="tag" items="${car.tags}">
						<span class="label categorielabel"><a class="whitetext"
							href="<c:url value="/categories/${tag}" />">${tag}</a></span>
					</c:forEach>
			</span>
			</span> <span class="span6 well">
				<h1 class="pull-left whitetext">Votes</h1> <span
				class="centered span12 spanvotes"> <c:import
						url="carvotes.jsp" /></span>
			</span> </span>
		</div>
		<div class="row-fluid">
			<span class="span12 well">
				<h1 class="pull-left whitetext span12">See Also</h1>
				<ul class="thumbnails">
					<c:forEach var="car" items="${seealso}">
						<c:set var="carpicture" value="${car.thumbnail}" />
						<li style="margin: 5px 10px;"><a
							href="<c:url value="/cars/${car.id}" />" class="thumbnail"> <img
								src="<c:url value="${picturesUrl}/cars-small/${car.thumbnail}"/>"
								style="width: 130px;"></a> <br>
							<p class="centered whitetext" style="margin-bottom: 0px;">
								<b>${car.brand}</b>
							</p>
							<p class="centered whitetext" style="margin-bottom: 0px;">
								<b>${car.model}</b>
							</p></li>
					</c:forEach>
				</ul>
			</span> <br>
		</div>
		<p class="pull-right" style="margin-left: 0px;">
			Views : <input class="centered"
				style="width: 3em; height: 2.8em; margin: 5px;" type="text"
				value="${views}" disabled>
		</p>
		<div class="fb-like" data-send="false" data-width="450"
			data-show-faces="false" data-font="arial"></div>
	</div>
	<c:import url="footer.jsp" />
</body>
</html>
