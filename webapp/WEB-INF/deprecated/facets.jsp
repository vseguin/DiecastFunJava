<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page session="false"%>
<html>
<head>
<meta name="description" content="Collection of 1/64 diecasts.">
<meta name="keywords" content="diecast,car,cars,diecasts,models">
<meta name="author" content="Vincent Séguin">
<meta charset="utf-8">
<title>1/64 Diecast Fun</title>
<link href="<c:url value="/resources/css/bootstrap.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/app.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/facets.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/montage.css" />"
  rel="stylesheet">
<link rel="icon"
	href="<c:url value="/resources/images/templates/favicon.ico" />"
	type="image/x-icon" />
<link rel="stylesheet" type="text/css"
	href="http://fonts.googleapis.com/css?family=Crafty Girls">
</head>
<body>
	<c:import url="navbar.jsp" />
	<div class="container">
		<c:import url="header.jsp" />
		<br>
		<ul class="breadcrumb">
			<li><a href="/diecastfun">Home</a> <span class="divider">/</span></li>
			<li class="active">Facets</li>
		</ul>
		<div class="row-fluid">
			<div class="span3">
				<div class="well centered accordion">
					<button type="button" class="whitebackground centered facetbutton"
						data-toggle="collapse" data-target="#brandcontent">
						Brands <strong>&#x25BC;</strong>
					</button>
          <button type="button" class="btn btn-inverse pull-right btn-clear" id="btn-clear-brands" style="display:none;" title="Clear elements">X</button>
					<div class="collapse facetcontent" id="brandcontent">
						<c:forEach var="brand" items="${brands}">
							<div class="facetelement btn brandelement" data-toggle="button">
								<div class="pull-left">${brand.name}</div>
								<div class="right">
									<strong>${brand.carCount}</strong>
								</div>
							</div>
						</c:forEach>
						<br />
					</div>
				</div>
        <div class="well centered accordion">
          <button type="button" class="whitebackground centered facetbutton"
            data-toggle="collapse" data-target="#categoriescontent">
            Categories <strong>&#x25BC;</strong>
          </button>
          <button type="button" class="btn btn-inverse pull-right btn-clear" id="btn-clear-categories" style="display:none;" title="Clear elements">X</button>
          <div class="collapse facetcontent" id="categoriescontent">
            <c:forEach var="category" items="${categories}">
              <div class="facetelement btn categoryelement" data-toggle="button">
                <div class="pull-left">${category.tag}</div>
                <div class="right">
                  <strong>${category.carCount}</strong>
                </div>
              </div>
            </c:forEach>
            <br />
          </div>
        </div>
        <div class="well centered accordion">
          <button type="button" class="whitebackground centered facetbutton"
            data-toggle="collapse" data-target="#colorscontent">
            Colors <strong>&#x25BC;</strong>
          </button>
          <button type="button" class="btn btn-inverse pull-right btn-clear" id="btn-clear-colors" style="display:none;" title="Clear elements">X</button>
          <div class="collapse facetcontent" id="colorscontent">
            <c:forEach var="color" items="${colors}">
              <div class="facetelement btn colorelement" data-toggle="button">
                <div class="pull-left">${color.color}</div>
                <div class="right">
                  <strong>${color.carCount}</strong>
                </div>
              </div>
            </c:forEach>
            <br />
          </div>
        </div>
        <div class="well centered accordion">
          <button type="button" class="whitebackground centered facetbutton"
            data-toggle="collapse" data-target="#countrycontent">
            Countries <strong>&#x25BC;</strong>
          </button>
          <button type="button" class="btn btn-inverse pull-right btn-clear" id="btn-clear-countries" style="display:none;" title="Clear elements">X</button>
          <div class="collapse facetcontent" id="countrycontent">
            <c:forEach var="country" items="${countries}">
              <div class="facetelement btn countryelement" data-toggle="button">
                <div class="pull-left">${country.country}</div>
                <div class="right">
                  <strong>${country.carCount}</strong>
                </div>
              </div>
            </c:forEach>
            <br />
          </div>
        </div>
        <div class="well centered accordion">
          <button type="button" class="whitebackground centered facetbutton"
            data-toggle="collapse" data-target="#eracontent">
            Eras <strong>&#x25BC;</strong>
          </button>
          <button type="button" class="btn btn-inverse pull-right btn-clear" id="btn-clear-eras" style="display:none;" title="Clear elements">X</button>
          <div class="collapse facetcontent" id="eracontent">
            <c:forEach var="era" items="${eras}">
              <div class="facetelement btn eraelement" data-toggle="button">
                <div class="pull-left">${era.era}</div>
                <div class="right">
                  <strong>${era.carCount}</strong>
                </div>
              </div>
            </c:forEach>
            <br />
          </div>
        </div>
        <div class="well centered accordion">
          <button type="button" class="whitebackground centered facetbutton"
            data-toggle="collapse" data-target="#makercontent">
            Makers <strong>&#x25BC;</strong>
          </button>
          <button type="button" class="btn btn-inverse pull-right btn-clear" id="btn-clear-makers" style="display:none;" title="Clear elements">X</button>
          <div class="collapse facetcontent" id="makercontent">
            <c:forEach var="maker" items="${makers}">
              <div class="facetelement btn makerelement" data-toggle="button">
                <div class="pull-left">${maker.name}</div>
                <div class="right">
                  <strong>${maker.carCount}</strong>
                </div>
              </div>
            </c:forEach>
            <br />
          </div>
        </div>
			</div>
			<div class="span9">
				<div>
					<div class="span12 right" style="padding-right: 45px;">
						Results per page : &nbsp;<select class="input-xlarge"
							id="carcount" name="carcount" style="margin-top: 10px;">
							<option value="12">12</option>
							<option value="16" selected="selected">16</option>
							<option value="20">20</option>
							<option value="36">36</option>
							<option value="72">72</option>
							<option value="400">400</option>
						</select>
					</div>
				</div>
				<c:import url="facetsresults.jsp" />
        <span class="pull-left" style="margin-top:-35px;"><button class="btn btn-inverse" id="btn-clear-all" style="display:none;"><strong>Clear All</strong></button></span>
			</div>
		</div>
		<br>
	</div>
	<script
		src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/js/bootstrap.js" />" /></script>
	<script type="text/javascript"
		src="<c:url value="/resources/js/app.js" />" /></script>
	<script type="text/javascript"
		src="<c:url value="/resources/js/filterby.js" />" /></script>
	<script type="text/javascript"
		src="<c:url value="/resources/js/facets.js" />" /></script>
	<c:import url="footer.jsp" />
</body>
</html>
