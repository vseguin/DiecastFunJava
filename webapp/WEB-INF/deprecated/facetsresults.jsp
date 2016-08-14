<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<div class="carlist">
	<div class="pagination span12"
		style="padding-right: 45px; margin-top: 0px;">
		<span id="completeresults" style="display: none;">${completeresults}</span>
		<c:import url="pagination.jsp" />
		<span class="pull-right" style="margin: 5px"> Page : </span>
	</div>
	<div>
		<c:forEach var="car" items="${cars}">
			<li class="span3 facet-result">
				<a href="<c:url value="/cars/${car.id}"/>" class="thumbnail am-wrapper-thumbnail"
				title="${car.brand} ${car.model}"> <img
					src="<c:url value="${picturesUrl}/cars-small/${car.thumbnail}"/>"></a>
			</li>
		</c:forEach>
	</div>
	<div class="span11">
		<div class="right">${fn:length(completeresults)} result<c:if test="${fn:length(completeresults) gt 1}">s</c:if>.</div>
	</div>
</div>