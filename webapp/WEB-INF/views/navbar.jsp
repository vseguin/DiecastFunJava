<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<header>
	<div class="navbar navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
				<a class="logo" href="<c:url value="/"/>"> <img
					src="<c:url value="/resources/images/templates/diecastfunlogo.png" />" />
				</a>
				<c:url value="/search" var="searchurl" />
					<span class="whitetext centered pull-right"
						style="margin-top: 12px;"><b>Total
							Car Count : ${carcount}</b></span>
          <span class="pull-right ui-widget" style="margin-right: 10px;">
          <form action="${searchurl}" method=POST scope="request" style="margin-bottom:5px;">
            <input id="searchinput" type="text" name="keywords" scope="request" style="margin-top:8px;height:27px;"> <input
              type="submit" class="btn btn-inverse" value="Search" style="margin-top:-1px;">
          </form>
          </span>
				</div>
			</div>
		</div>
</header>