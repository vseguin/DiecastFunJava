<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h3>Comments :</h3>
<c:forEach var="comment" items="${comments}">
<blockquote>
  <p>${comment.message}</p>
  <small>${comment.username}</small>
</blockquote>
</c:forEach>