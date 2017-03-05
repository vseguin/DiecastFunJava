<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:forEach var="car" items="${cars}">
  		<div class="col l3 m6 s12">
			<a href="<c:url value="/cars/${car.id}"/>">
				<div class="card small">
					<div class="card-image">
							<img class="car-thumbnail" src="<c:url value="${picturesUrl}/cars-small/${car.thumbnail}"/>">
					</div>
					<div class="card-content"><h5>${car.brand} ${car.model}</h5></div>
				</div>
			</a>
		</div>
</c:forEach>