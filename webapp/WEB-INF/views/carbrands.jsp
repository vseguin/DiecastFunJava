<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
    	<div class="row row-bg">
    		<div class="headliner">
	   			<h4>Car Brands 					
	   				<c:if test="${filter != null}">
	   					from ${filter.country}<c:if test="${filter.country != 'Unknown'}">  <span class="flag-icon flag-icon-${filter.code}"></span></c:if>
					</c:if>
				</h4>
   			</div>
   			
   			<div>
	   			<a class='dropdown-button btn btn-filter' href='#' data-activates='countries'>Filter by country</a>
				<ul id='countries' class='dropdown-content'>
				<li><a href="<c:url value="/carbrands"/>">All</a></li>
				<c:forEach var="country" items="${countries}">
					<li class="divider"></li>
					<li><a href="<c:url value="/carbrands?country=${country.code}"/>">${country.country}<c:if test="${brand.country != 'Unknown'}"><span class="filter-list-icon flag-icon flag-icon-${country.code}"></span></c:if></a></li>
				</c:forEach>
				</ul>
			</div>
   			
			<c:forEach var="brand" items="${sortedbrands.collection}">
	   			<div class="col l4 m12 s12">
	   				<a href="<c:url value="/cars?brand=${brand.name}"/>">
	   					<div class="list-item">
	   						<div class="list-item-picture" style="background-image:url('<c:url value="${picturesUrl}/brands/${brand.pictureName}"/>')"></div>
	   						<h4>${brand.name}</h4>
	   						<div>${brand.carCount} car<c:if test="${brand.carCount != 1}">s</c:if><c:if test="${brand.country != 'Unknown'}"> - <span class="flag-icon flag-icon-${brand.countryCode}"></span></c:if></div>
	   					</div>
	   				</a>
				</div>
			</c:forEach>
    	</div>