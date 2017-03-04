<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="col l4 m12 s12">
	<div class="card home-card">
		<a href="<c:url value="${param.url}"/>">
			<div class="card-image" style="background-image:url('<c:url value="${picturesUrl}/cars-small/${param.car}"/>')">
				<div class="header-container ${param.headercontainerclass}"></div>
				<div class="header ${param.headerclass}">
				    <div class="headliner">
		  				<h4>${param.title}</h4>
		 			</div>
				</div>
			</div>
		</a>
	</div>
</div>