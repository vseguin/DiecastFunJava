<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<footer class="footer">
	<div class="container">
		<h3>Developed by :</h3>
		<p>
			Vincent S&eacute;guin - Copyright <span class="whitetext">2012 - 2013</span>
			- Twitter Boostrap, BootTheme
		</p>
		<p>This website has been designed for Firefox and Chrome.</p>
		<p>
			<a href="mailto:vincent.seguin.2@gmail.com">Contact me for any
				informations or suggestions</a> - Credits to Bart Kowalski for Matchbox Icons.
		</p>
		<p>
			<a href="https://twitter.com/VincentSeguin"
				class="twitter-follow-button" data-show-count="false">Follow
				@VincentSeguin</a>
			<script>
				!function(d, s, id) {
					var js, fjs = d.getElementsByTagName(s)[0];
					if (!d.getElementById(id)) {
						js = d.createElement(s);
						js.id = id;
						js.src = "//platform.twitter.com/widgets.js";
						fjs.parentNode.insertBefore(js, fjs);
					}
				}(document, "script", "twitter-wjs");
			</script>
		</p>
    <p>
      <a class="whitetext" href="<c:url value="/cars/random" />"><button
          class="btn btn-large centered btn-block btn-info"
          style="font-size: 20px;" type="button">Shuffle!</button></a>
    </p>
	</div>
</footer>