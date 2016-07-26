<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="col l4 m12 s12">
	<div class="card">
		<a href="<c:url value="${param.url}"/>">
			<div class="card-image">
				<div class="header-container ${param.headercontainerclass}"></div>
				<div class="header ${param.headerclass}">
				    <div class="headliner">
		  				<h4>${param.title}</h4>
		 			</div>
				</div>
				<img src="<c:url value="https://s3-us-west-2.amazonaws.com/elasticbeanstalk-us-west-2-013875902762/resources/images/cars-small/${param.car}"/>">
			</div>
		</a>
	</div>
</div>