<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
    	<div class="row row-bg">
    		<div class="headliner">
	   			<h4>Categories</h4>
   			</div>
   			
			<c:forEach var="era" items="${eras.collection}">
	   			<div class="col l4 m12 s12">
	   				<a href="<c:url value="/eras/${era.era}"/>">
	   					<div class="list-item">
	   						<div class="list-item-picture" style="background-image:url('<c:url value="${picturesUrl}/eras/${fn:toLowerCase(era.era)}.png"/>')"></div>
	   						<h4>${era.era}</h4>
	   						<div>${era.carCount} car<c:if test="${era.carCount != 1}">s</c:if></div>
	   					</div>
	   				</a>
				</div>
			</c:forEach>
    	</div>