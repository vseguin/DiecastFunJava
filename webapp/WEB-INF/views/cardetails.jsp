<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<div class="row row-bg">
	<script src="https://cdnjs.cloudflare.com/ajax/libs/galleria/1.4.5/galleria.min.js"></script>
	
	<div id="cardetails">
		<c:if test="${car.isNew}">
			<div class="corner-ribbon new">NEW</div>
		</c:if>
		<c:if test="${car.restored}">
			<div class="corner-ribbon restored">RESTORED</div>
		</c:if>
		<c:if test="${car.customized}">
			<div class="corner-ribbon customized">CUSTOMIZED</div>
		</c:if>
	
		<div class="description col l4 m12 s12">
			<div class="categories">
				<c:forEach var="tag" items="${car.tags}">
					<a href="<c:url value="/cars?category=${tag}"/>">
					<div class="chip">
					  <img src="${picturesUrl}/tags/${fn:toLowerCase(tag)}.png">
					  ${tag}
					</div>
					</a>
				</c:forEach>
			</div>
			
			<c:if test="${car.brand != 'Generic'}"><h5><a href="<c:url value="/cars?brand=${car.brand}"/>">${car.brand}</a></h5></c:if>
			<h4>${car.model}</h4>
						
			<div class="collection">
			    <a href="<c:url value="/cars?maker=${car.maker}"/>" class="collection-item"><span class="badge">${car.maker}</span>Diecast brand</a>
			    <div class="collection-item"><span class="badge">${car.scale}</span>Scale</div>
			    <div class="collection-item"><span class="badge">${views}</span>Views</div>
			</div>
			
			<div class="votes">
				<h5>Votes</h5>
				<button class="waves-effect waves-light btn" id="btn-upvote"><i class="small material-icons">thumb_up</i></button>
				<input disabled value="${votes}" />
				<button class="waves-effect waves-light btn" id="btn-downvote"><i class="small material-icons">thumb_down</i></button>
			</div>
		</div>
		<div class="galleria col l8 m12 s12">
			<c:forEach var="picture" items="${car.pictures}">
				<img src="${picturesUrl}/cars/${picture}">
			</c:forEach>
	   	</div>
	   	
	   	<div class="see-also col l12 m12 s12">
	   		 <h5>See also</h5>
	   		 <div id="see-also-container">
				 <div class="progress">
				      <div class="indeterminate"></div>
				  </div>
			 </div>
   		</div>
   	</div>
   	
    <script>
    $(document).ready(function () {
        Galleria.loadTheme('https://cdnjs.cloudflare.com/ajax/libs/galleria/1.4.5/themes/classic/galleria.classic.min.js');        
        Galleria.run('.galleria');
    	
        var carId = "${car.id}";
    	
    	$.ajax({
    		type : 'GET',
    		url : '${pageContext.request.contextPath}/cars/' + carId + '/seealso',
    		success : function(data) {
    			$("#see-also-container").html(data);
    		}
    	});
    	
        $('#btn-upvote').click(function() {
			vote('add');
        });
        
        $('#btn-downvote').click(function() {
        	vote('minus');
        });
        
        function vote(operation) {
        	var baseUrl = '${pageContext.request.contextPath}/cars/' + carId + '/votes/';
        	
        	$.ajax({
        		type : 'POST',
        		url : baseUrl + operation,
        		success : function(data) {
        			$('.votes input').val(data.value);
        		}
        	});
        }
    });
    </script>
</div>