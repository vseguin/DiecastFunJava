<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
    	<div class="row row-bg">
    		<div class="headliner">
	   			<h4>Diecast Brands</h4>
   			</div>
   			
			<c:forEach var="maker" items="${sortedmakers.collection}">
	   			<div class="col l4 m12 s12">
	   				<a href="<c:url value="/makers/${maker.name}"/>">
	   					<div class="list-item">
	   						<div class="list-item-picture" style="background-image:url('<c:url value="${picturesUrl}/makers/${maker.pictureName}"/>')"></div>
	   						<h4>${maker.name}</h4>
	   						<div>${maker.carCount} car<c:if test="${maker.carCount != 1}">s</c:if></div>
	   					</div>
	   				</a>
				</div>
			</c:forEach>
    	</div>