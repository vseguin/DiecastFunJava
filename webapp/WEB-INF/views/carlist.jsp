<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
    	<div class="row row-bg">
    		<div class="headliner">
	   			<h4>${title}</h4>
   			</div>
   			
			<c:forEach var="car" items="${cars.collection}">
	   			<div class="col l4 m12 s12">
	   					<div class="list-item">
	   						<h4>${car.id}</h4>
	   					</div>
				</div>
			</c:forEach>
    	</div>