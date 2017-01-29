<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
    	<div class="row row-bg">
    		<div class="headliner">
	   			<h4>Categories</h4>
   			</div>
   			
			<c:forEach var="tag" items="${tags.collection}">
	   			<div class="col l4 m12 s12">
	   				<a href="<c:url value="/categories/${tag.tag}"/>">
	   					<div class="list-item">
	   						<div class="list-item-picture" style="background-image:url('<c:url value="${picturesUrl}/tags/${fn:toLowerCase(tag.tag)}.png"/>')"></div>
	   						<div>
	   							<h4>${tag.displayName}</h4>
	   							<div>${tag.carCount} car<c:if test="${tag.carCount != 1}">s</c:if></div>
	   						</div>
	   					</div>
	   				</a>
				</div>
			</c:forEach>
    	</div>