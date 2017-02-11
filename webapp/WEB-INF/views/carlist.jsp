<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
   	<div class="row row-bg">
   		<div class="headliner">
   			<h4>${title}</h4>
   			<h6>${totalCount} result<c:if test="${totalCount != 1}">s</c:if></h6>
  		</div>
  			
		<c:forEach var="car" items="${cars.collection}">
   			<div class="col l6 m12 s12">
   				<a href="<c:url value="/cars/${car.id}"/>">
   					<div class="list-item car">
   						<div class="list-item-text">
   					   		<h4>${car.brand}</h4>
   							<h5>${car.model}</h5>	
   						</div>
   						<div class="list-item-picture" style="background-image:url('<c:url value="${picturesUrl}/cars-small/${car.thumbnail}"/>')"></div>
   					</div>
   				</a>
			</div>
		</c:forEach>

		<jsp:include page="pagination.jsp">
			<jsp:param name="page" value="${page}"/>
			<jsp:param name="perPage" value="${perPage}"/>
		    <jsp:param name="totalCount" value="${totalCount}"/>
		</jsp:include>
   	</div>