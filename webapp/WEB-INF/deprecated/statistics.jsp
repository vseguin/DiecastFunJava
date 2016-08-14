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
<link href="<c:url value="/resources/css/jquery.jqplot.css" />"
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
			<li class="active">Statistics</li>
		</ul>
		<div class="row-fluid">
			<h1 class="whitetext span6 well centered title">Statistics</h1>
			<span class="span12">
				<div class="centered plotContainer" id="brandschart"
					style="height: 1600px; width: 1000px; margin:auto;"></div>
        <div class="centered plotContainer" id="makerschart"
          style="height: 700px; width: 700px; margin:auto;"></div>
        <div class="centered plotContainer" id="eraschart"
          style="height: 500px; width: 700px; margin:auto;"></div>
        <div class="centered plotContainer" id="colorschart"
          style="height: 1000px; width: 700px; margin:auto;"></div>
        <div class="centered plotContainer" id="tagschart"
          style="height: 700px; width: 700px; margin:auto;"></div>
        <div class="centered plotContainer" id="countrieschart"
          style="height: 500px; width: 400px; margin:auto; float:left;"></div>
        <div class="centered plotContainer" id="voteschart"
          style="height: 500px; width: 400px; margin:auto; float:right;"></div>
			</span>
		</div>
	</div>
	<script
		src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/js/bootstrap.js" />" /></script>
	<script type="text/javascript"
		src="<c:url value="/resources/js/jquery.jqplot.js" />" /></script>
	<script type="text/javascript"
		src="<c:url value="/resources/js/jqplot.pieRenderer.js" />" /></script>
  <script type="text/javascript"
    src="<c:url value="/resources/js/jqplot.highlighter.js" />" /></script>
	<script type="text/javascript"
		src="<c:url value="/resources/js/app.js" />" /></script>
	<script type="text/javascript"
		src="<c:url value="/resources/js/stats.js" />" /></script>
	<c:import url="footer.jsp" />
</body>
</html>
