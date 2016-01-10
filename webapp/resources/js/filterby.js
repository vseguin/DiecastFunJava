$(document).ready(function() {
	$('#countries').change(function(e) {
		e.preventDefault();
		filterByCountry($(this).val());
	});
	
	filterByCount();
});

function filterByCount() {
	$('#carcount').change(function(e) {
		e.preventDefault();
		$.ajax({
			type : "POST",
			url : '/search/filterByCount',
			data : {
				cars: $('#completeresults').text().replace('[', '').replace(']', ''),
				carCount: $(this).val(),
				view : paginationViewName
			},
			success : function(data) {
				onPaginationResult(data);
			}
		});
	});
}

function filterByCountry(country) {
	$.ajax({
		type : "POST",
		url : '/countries/' + country,
		data : {
			cars: $('#completeresults').text().replace('[', '').replace(']', '')
		},
		success : function(data) {
			onPaginationResult(data);
			$('#carcount').val('16');
		}
	});
}