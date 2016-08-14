<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="false"%>
<html>
<head>
<meta name="description" content="Collection of 1/64 diecasts.">
<meta name="keywords" content="diecast,car,cars,diecasts,models">
<meta name="author" content="Vincent S�guin">
<meta charset="utf-8">
<title>1/64 Diecast Fun</title>

<link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.6/css/materialize.min.css"
    rel="stylesheet">
<link href="<c:url value="/resources/target/css/app.min.css" />" rel="stylesheet">
<link rel="icon"
	href="<c:url value="/resources/img/favicon.ico" />"
	type="image/x-icon" />
<meta name="viewport" content="width=device-width, initial-scale=1.0"/>

<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="https://code.jquery.com/ui/1.11.1/jquery-ui.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.6/js/materialize.min.js"></script>

<script type="text/javascript"
	src="<c:url value="/resources/target/js/app.min.js" />" /></script>
</head>
<body>
    <c:import url="nav.jsp" />
    <c:import url="sidepanel.jsp" />
    <c:import url="header.jsp" />
    <c:import url="${view}.jsp" />
    <c:import url="footer.jsp" />
</body>
</html>
