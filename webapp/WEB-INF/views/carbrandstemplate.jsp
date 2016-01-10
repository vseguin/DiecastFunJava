<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="rowIncrement" value="1" scope="page" />
<c:set var="rowCount" value="1" scope="page" />
<div class="gridster">
	<ul style="height: 3080px; position: relative;">
		<c:forEach var="brand" items="${sortedbrands.collection}">
			<li data-row="${rowCount}" data-col="1" data-sizex="1" data-sizey="1"
				class="gridelement centered gs_w"
				style="background-repeat: no-repeat; background-size:200px; background-image:url(<c:url value="${picturesUrl}/brands/${brand.pictureName}" />);">
				<div class="brandpic-background">
					<h2 class="well whitetext" style="font-size: 16px;">${brand.name}</h2>
					<span class="whitetext">Car Count : &nbsp;${brand.carCount}</span><br>
					<span class="whitetext">Country :<c:choose>
							<c:when test="${brand.country == 'Unknown'}">
                &nbsp;&nbsp;- 
							</c:when>
							<c:otherwise>
								<img class="smallicon"
									src="<c:url value="${picturesUrl}/countries/${fn:toLowerCase(brand.country)}.png" />">
							</c:otherwise>
						</c:choose></span>
					<button class="btn btn-large btn-hover brandbutton">
						<a href="carbrands/${brand.name}"><b>Details
								&raquo;&raquo;</b></a>
					</button>
				</div>
			</li>
			<c:set var="rowIncrement" value="${rowIncrement + 1}" scope="page" />
			<c:if test="${rowIncrement > 4}">
				<c:set var="rowCount" value="${rowCount + 1}" scope="page" />
				<c:set var="rowIncrement" value="0" scope="page" />
			</c:if>
		</c:forEach>
	</ul>
</div>