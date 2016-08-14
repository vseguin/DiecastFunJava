<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
    <div class="flow-text">
    	<div class="row row-bg">
    		<div class="headliner">
	   			<h4>About</h4>
   			</div>
   			<p>1/64 Diecast Fun displays my entire diecast collection that started when i was only 3 years old. The collection is mainly focused
   			on road cars and trucks, coming from various makers and eras. I currently own <b>${carcount}</b> models, and this just keep
   			on growing. Enjoy browsing them, take a look at my <a href="https://www.instagram.com/164diecastfun">Instagram feed</a> and my <a href="<c:url value="/wantedlist"/>">wanted list</a> as well!</p>
    	</div>
    	<div class="row row-reversed grey-bg-fade">
    		<div class="headliner">
	   			<h4>Featured car</h4>
   			</div>
   			<div>
   			<c:forEach var="picture" items="${featuredcar.pictures}" varStatus="loop">
	   			<div class="col l4 m12 s12">
					<div class="card">
						<div class="card-image">
							<a href="<c:url value="/cars/${featuredcar.id}"/>">
							<div class="img" style="background-image:url('<c:url value="https://s3-us-west-2.amazonaws.com/elasticbeanstalk-us-west-2-013875902762/resources/images/cars-small/${picture}"/>')">
								<c:if test="${loop.index == 1}">
									<div class="blank-state blue-bg-fade"><h5>${featuredcar.maker}&nbsp;<c:if test="${featuredcar.brand != 'Generic'}">${featuredcar.brand}&nbsp;</c:if>${featuredcar.model}</h5></div>
								</c:if>
							</div>
							</a>
						</div>
					</div>
				</div>
			</c:forEach>
			</div>
    	</div>
    	<div class="row row-bg">
    		<div class="headliner">
	   			<h4>New additions</h4>
   			</div>
			<c:choose>
				<c:when test="${fn:length(newadditions) == 0}">
					<span>No recent additions.</span>
				</c:when>
				<c:otherwise>
					<c:forEach var="car" items="${newadditions}">
				  		<div class="col l3 m6 s12">
							<a href="<c:url value="/cars/${car.id}"/>">
								<div class="card small">
									<div class="card-image">
											<img class="car-thumbnail" src="<c:url value="https://s3-us-west-2.amazonaws.com/elasticbeanstalk-us-west-2-013875902762/resources/images/cars-small/${car.thumbnail}"/>">
									</div>
									<div class="card-content"><h5>${car.brand} ${car.model}</h5></div>
								</div>
							</a>
						</div>
					</c:forEach>
				</c:otherwise>
			</c:choose>
    	</div>
    	<div class="row row-reversed grey-bg-fade">
			<jsp:include page="homecard.jsp">
			    <jsp:param name="title" value="Restorations"/>
			    <jsp:param name="url" value="/restorations"/>
			    <jsp:param name="car" value="${restoration.thumbnail}"/>
			    <jsp:param name="headerclass" value="blue-bg-fade"/>
			</jsp:include>
			<jsp:include page="homecard.jsp">
			    <jsp:param name="title" value="Customs"/>
			    <jsp:param name="url" value="/customs"/>
			    <jsp:param name="car" value="${custom.thumbnail}"/>
			    <jsp:param name="headercontainerclass" value="grey-border"/>
			    <jsp:param name="headerclass" value="grey-bg-fade"/>
			</jsp:include>
			<jsp:include page="homecard.jsp">
			    <jsp:param name="title" value="Most popular"/>
			    <jsp:param name="url" value="/mostpopular"/>
			    <jsp:param name="car" value="${mostpopular.thumbnail}"/>
			    <jsp:param name="headerclass" value="blue-bg-fade"/>
			</jsp:include>
    	</div>
    </div>