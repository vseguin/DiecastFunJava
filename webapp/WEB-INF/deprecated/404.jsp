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
    <div class="row-fluid centered">
      <h1 class="whitetext span6 well">Oops!</h1>
      <span class="span12" style="margin-bottom:15px;"><img width="250px" src="<c:url value="/resources/images/templates/warning.png" />"></span>
      <span class="span12">An unexpected error occured while processing the request, or you tried to reach an unexisting page.</span>
      <span class="span12">Please go back to the home page.</span>
    </div>
  </div>
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
  <c:import url="footer.jsp" />
</body>
</html>
