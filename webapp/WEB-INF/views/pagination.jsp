<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<ul class="pull-right">
	<c:choose>
		<c:when test="${hasprevious == true}">
			<li><a class="previousButton" href="#" title="Previous">&laquo;&laquo;</a></li>
		</c:when>
		<c:otherwise>
			<li class="disabled"><a class="previousButton" href="#"
				title="Previous">&laquo;&laquo;</a></li>
		</c:otherwise>
	</c:choose>
	<li class="disabled currentpage"><a> <c:choose>
				<c:when test="${currentpage == null}">1</c:when>
				<c:otherwise>${currentpage}</c:otherwise>
			</c:choose>
	</a></li>
	<c:choose>
		<c:when test="${hasnext == true}">
			<li><a class="nextButton" href="#" title="Next">&raquo;&raquo;</a></li>
		</c:when>
		<c:otherwise>
			<li class="disabled"><a class="nextButton" href="#" title="Next">&raquo;&raquo;</a></li>
		</c:otherwise>
	</c:choose>
</ul>