<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="sidePanelContainer" style="display:none;">
	<div id="sidePanelInnerContainer">
		<div class="blue-bg" id="sidePanelLogo">
			<a href="<c:url value="/"/>"><div class="logo-text white-text">1/64 Diecast Fun</div></a>
		</div>
		<ul id="sidePanelLinks">	
			<li><a href="<c:url value="/carbrands"/>">Car brands</a></li>
			<li><a href="<c:url value="/makers"/>">Diecast brands</a></li>
			<li><a href="<c:url value="/eras"/>">Eras</a></li>
			<li><a href="<c:url value="/categories"/>">Categories</a></li>
			<li><a href="<c:url value="/statistics"/>">Statistics</a></li>
			<li><a href="<c:url value="/wantedlist"/>">Wanted list</a></li>
		</ul>
	</div>
</div>