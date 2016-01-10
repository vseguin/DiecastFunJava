<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="mainCarousel" class="carousel slide">
	<div class="carousel-inner">
		<div class="item active">
			<img
				src="<c:url value="/resources/images/templates/carousel1.jpg" />"
				alt="">
			<div class="carousel-caption">
				<h4>Extensive collection</h4>
				<p>Diecast Fun includes more than 1500 1:64 diecasts spread
					across multiple car brands, diecast brands and countries.
					Collection is mainly focused on having the most different cars
					possible, instead of having many of the same.</p>
			</div>
		</div>
		<div class="item">
			<img
				src="<c:url value="/resources/images/templates/carousel2.jpg" />"
				alt="">
			<div class="carousel-caption">
				<h4>Beautiful pictures</h4>
				<p>Want to discover details or simply admirate a specific
					diecast? Diecast Fun offers tons of pictures of every diecast of
					the collection. From simple white backgrounds to artistic photo
					shootings outside, take time to enjoy all of these.</p>
			</div>
		</div>
		<div class="item">
			<img
				src="<c:url value="/resources/images/templates/carousel3.jpg" />"
				alt="">
			<div class="carousel-caption">
				<h4>Restaurations and Customizations</h4>
				<p>Even more, the collection includes many home-made
					restaurations, as well as a few customizations. It's always a
					pleasure to get an old poor diecast and transform it into something
					that will be proudly shown in your main shelf.</p>
			</div>
		</div>
		<div class="item">
			<img
				src="<c:url value="/resources/images/templates/carousel4.jpg" />"
				alt="">
			<div class="carousel-caption">
				<h4>Facilitated search</h4>
				<p>Diecast Fun offers every possible search option for the
					collection, such as car brands, diecast brands, countries and time
					periods. You'll be able to find the exact casting you're looking
					for, or simply browse the catalog and discover cars you've never
					seen.</p>
			</div>
		</div>
	</div>
	<a class="left carousel-control" href="#mainCarousel" data-slide="prev">&lsaquo;</a>
	<a class="right carousel-control" href="#mainCarousel"
		data-slide="next">&rsaquo;</a>
</div>
<div>
	<div class="btn-group">
		<button class="btn btn-large btn-hover btn-header">
			<a href="<c:url value="/"/>"><b>Home</b></a>
		</button>
		<button class="btn btn-large btn-hover btn-header">
		  <a href="<c:url value="/carbrands"/>"><b>Car Brands</b></a>
		</button>
		<button class="btn btn-large btn-hover btn-header">
			<a href="<c:url value="/makers"/>"><b>Maker Brands</b></a>
		</button>
		<button class="btn btn-large btn-hover btn-header">
			<a href="<c:url value="/eras"/>"><b>Eras</b></a>
		</button>
		<button class="btn btn-large btn-hover btn-header">
			<a href="<c:url value="/categories"/>"><b>Car Categories</b></a>
		</button>
		<button class="btn btn-large btn-hover btn-header">
			<a href="<c:url value="/wantedlist"/>"><b>Wanted List</b></a>
		</button>
    <button class="btn btn-large btn-hover btn-header">
      <a href="<c:url value="/statistics"/>"><b>Statistics</b></a>
    </button>
	</div>
</div>