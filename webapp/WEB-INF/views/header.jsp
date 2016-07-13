<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<header>
	<div id="mainPicture">
	    <div id="mainPictureHover">
	        <div class="blue-bg-fade" id="mainPictureLine" style="display:none;">
	            <div class="white-text logo-text" id="mainPictureLabel" style="display:none;">
	                <h2>1/64 Diecast Fun</h2>
	            </div>
	        </div>
	    </div>
	</div>
</header>
<script>
$(document).ready(function() {
	$("#mainPictureLine").animate({width:'toggle'},350,function() {
	    $("#mainPictureLabel").fadeIn(350);
	});
});

(function(i, s, o, g, r, a, m) {
    i['GoogleAnalyticsObject'] = r;
    i[r] = i[r] || function() {
        (i[r].q = i[r].q || []).push(arguments)
    }, i[r].l = 1 * new Date();
    a = s.createElement(o), m = s.getElementsByTagName(o)[0];
    a.async = 1;
    a.src = g;
    m.parentNode.insertBefore(a, m)
})(window, document, 'script', '//www.google-analytics.com/analytics.js',
        'ga');

ga('create', 'UA-72525953-1', 'auto');
ga('send', 'pageview');
</script>