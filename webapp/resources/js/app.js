$(document).ready(function() {	
	$("#searchForm").submit(function(e) {
		window.location.href = window.location.origin + '/search?q=' + $(this).find('input').val();
		return false;
	});
});