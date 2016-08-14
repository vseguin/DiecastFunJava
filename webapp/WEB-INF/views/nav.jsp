<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<nav>
  <div class="navbar-fixed">
     <i class="left large material-icons white-bg grey-text text-darken-3" id="menuButton">list</i>
     <form class="right" id="searchForm">
       <div class="input-field grey-text text-darken-3">
         <input class="white-bg" id="search" type="search" required placeholder="Search...">
         <label for="search"><i class="material-icons">search</i></label>
       </div>
     </form>
  </div>
</nav>

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