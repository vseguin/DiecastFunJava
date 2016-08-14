<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="carlist">
	<div class="pagination span12">
		<span id="completeresults" style="display: none;">${completeresults}</span>
    <c:import url="pagination.jsp" />
		<span class="pull-right" style="margin: 5px"> Page : </span>
	</div>
	<div class="am-container span12" id="am-container">
		<c:forEach var="car" items="${cars}">
			<c:set var="carpicture" value="${car.thumbnail}" />
			<a href="<c:url value="/cars/${car.id}" />"
				title="<c:choose><c:when test="${car.brand == 'Generic'}">${car.model}</c:when><c:otherwise>${car.brand}&nbsp;${car.model}</c:otherwise></c:choose>"><img
				src="<c:url value="${picturesUrl}/cars-small/${car.thumbnail}"/>"></img></a>
		</c:forEach>
	</div>
	<div class="pagination">
    <c:import url="pagination.jsp" />
		<span class="pull-right" style="margin: 5px"> Page : </span>
	</div>
</div>