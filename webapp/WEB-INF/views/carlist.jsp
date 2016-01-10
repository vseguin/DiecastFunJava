<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="false"%>
<html>
<head>
<meta name="description" content="Collection of 1/64 diecasts.">
<meta name="keywords" content="diecast,car,cars,diecasts,models">
<meta name="author" content="Vincent Séguin">
<meta charset="utf-8">
<title>${title} - 1/64 Diecast Fun</title>
<link href="<c:url value="/resources/css/bootstrap.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/montage.css" />"
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
			<c:if test="${previousview != null}">
				<li><a href="<c:url value="/${previousview}" />">${previousviewtitle}</a>
					<span class="divider">/</span></li>
			</c:if>
			<li class="active">${title}</li>
		</ul>
		<div class="row-fluid">
			<h1 class="whitetext span6 well centered title">${title}</h1>
			<span class="span6 centered">Filter by Country : &nbsp;<select
				class="input-xlarge" id="countries" name="countries"
				style="margin-top: 10px;"><c:forEach items="${countries}"
						var="country">
						<option value="${country}">${country}</option>
					</c:forEach></select><br> Results per page : &nbsp;<select class="input-xlarge"
				id="carcount" name="carcount" style="margin-top: 10px;">
						<option value="12">12</option>
						<option value="16" selected="selected">16</option>
						<option value="20">20</option>
						<option value="36">36</option>
						<option value="72">72</option>
						<option value="400">400</option>
						</select></span>
      <c:if test="${searchresults != null}">
        <span class="span12"> ${searchresults} result<c:if
            test="${searchresults > 1}">s</c:if> found. 
      </c:if>
			<c:import url="carlisttemplate.jsp"></c:import>
		</div>
		<div id='loadingmessage' class="centered" style='display: none'>
			<img
				src='<c:url value="/resources/images/templates/ajax-loader.gif" />' />
		</div>
	</div>
	<script
		src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/js/bootstrap.js" />" /></script>
	<script type="text/javascript"
		src="<c:url value="/resources/js/jquery.montage.js" />" /></script>
	<script type="text/javascript"
		src="<c:url value="/resources/js/filterby.js" />" /></script>
  <script type="text/javascript"
    src="<c:url value="/resources/js/app.js" />" /></script>
	<script type="text/javascript">
		$('#loadingmessage').show();
		animateLayout();
		$('#loadingmessage').hide();
	</script>
	<c:import url="footer.jsp" />
</body>
</html>
