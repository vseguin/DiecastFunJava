<div class="col l12 m12 s12">
	<ul class="pagination">
	  <li id="page-left"><a href="#!"><i class="material-icons">chevron_left</i></a></li>
	  <li id="page-right"><a href="#!"><i class="material-icons">chevron_right</i></a></li>
	</ul>
</div>

<script>
	if (!String.prototype.format) {
	  String.prototype.format = function() {
	    var args = arguments;
	    return this.replace(/{(\d+)}/g, function(match, number) { 
	      return typeof args[number] != 'undefined'
	        ? args[number]
	        : match
	      ;
	    });
	  };
	}

	var currentPage = ${page};
	var perPage = ${perPage};
	var totalCount = ${totalCount};
	var totalOfPages = Math.ceil(totalCount / perPage);
	var maxPage = totalOfPages - 1;
	
	if (totalCount === 0) {
		$('.pagination').hide();
	} else {
		var url = '${query}&page={0}&perPage={1}'
			
		var pageLeftCssClass = currentPage === 0 ? 'disabled' : 'waves-effect';
		var pageRightCssClass = currentPage === maxPage ? 'disabled' : 'waves-effect';

		$('#page-left').addClass(pageLeftCssClass);
		$('#page-right').addClass(pageRightCssClass);
		
		var currentElement = $('#page-left');
		for (var i = 0; i < totalOfPages; i++) {
			var cssClass = currentPage === i ? 'active' : 'waves-effect';
			var elementToInsert = $('<li class="' + cssClass +'"><a href="' + url.format(i, perPage) + '">' + (i+1) + '</a></li>')
			currentElement.after(elementToInsert);
			currentElement = elementToInsert;
		}
		
		var previousPage = currentPage === 0 ? 0 : currentPage - 1;
		var nextPage = currentPage === maxPage ? maxPage : currentPage + 1;

		$('#page-left a').attr("href", url.format(previousPage, perPage));
		$('#page-right a').attr("href", url.format(nextPage, perPage));
	}
</script>