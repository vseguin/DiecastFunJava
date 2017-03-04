<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 	<div class="row row-bg">
 		<div class="headliner">
 			<h4>Wanted list</h4>
		</div>
		
		<div id="wanted-list">
		<c:forEach var="listItem" items="${wantedList}">
			<c:forEach var="wantedCar" items="${listItem.value}">
			<div class="wanted col l2 m4 s12" data-id="${wantedCar.id}">
				<h5>${listItem.key}</h5>
				<h6>${wantedCar.brand}</h6>
				<h6>${wantedCar.model}</h6>
			</div>
			</c:forEach>
		</c:forEach>
		</div>
 	</div>