<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<header>
	<div class="navbar navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
				<a class="logo" href="<c:url value="/"/>"> <img
					src="<c:url value="/resources/images/templates/diecastfunlogo.png" />" />
				</a>
				<c:url value="/search" var="searchurl" />
				<span class="whitetext centered pull-right" style="margin-top: 12px;"><b>Total Car Count : ${carcount}</b></span> 
				<span class="pull-right ui-widget"style="margin-right: 10px;"> 
					<input id="searchinput" type="text" name="keywords" scope="request" style="margin-top: 8px; height: 27px;">
					<button id="searchbutton" class="btn btn-inverse" style="margin-top: -1px;">Search</button>
				</span>
			</div>
		</div>
	</div>
</header>
<script>
	(function(i, s, o, g, r, a, m) {
		i['GoogleAnalyticsObject'] = r;
		i[r] = i[r] || function() {
			(i[r].q = i[r].q || []).push(arguments)
		}, i[r].l = 1 * new Date();
		a = s.createElement(o), m = s.getElementsByTagName(o)[0];
		a.async = 1;
		a.src = g;
		m.parentNode.insertBefore(a, m)
	})(window, document, 'script', '//www.google-analytics.com/analytics.js',
			'ga');

	ga('create', 'UA-72525953-1', 'auto');
	ga('send', 'pageview');
</script>