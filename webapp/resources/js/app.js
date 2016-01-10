var paginationViewNameDefault = 'carlisttemplate';
var paginationViewName = paginationViewNameDefault;

$(document).ready(function() {
	$('.carousel').carousel({
		interval : 5000
	});

	animateBackground();

	$("[rel=tooltip]").tooltip();

	$(".flagbutton").click(function(e) {
		var country = $(this).attr('data-original-title').replace(" ", "");
		var url = '/carbrands/' + country;
		
		e.preventDefault();
		$.ajax({
			type : "POST",
			url : url,
			data : country,
			success : function(data) {
				$('.gridster').html(data);
				animateBackground();
				animateGridster();
			}
		});
	});

	nextButton();
	previousButton();
});

function nextButton() {
	$(".nextButton").click(function(event) {
		var page = $('.currentpage').first().text();
		var url = '/paginate/next/' + page;
		event.preventDefault();
		pagination(url, page, paginationViewName);
	});
}

function previousButton() {
	$(".previousButton").click(function(event) {
		var page = $('.currentpage').first().text();
		var url = '/paginate/previous/' + page;
		event.preventDefault();
		pagination(url, page, paginationViewName);
	});
}

function upvote() {
	var id = $('.upvote').first().attr('id');
	var url = '/vote/add/' + id;
	
	$.ajax({
		type : "POST",
		url : url,
		data : id,
		success : function(data) {
			$('.spanvotes').html(data);
		}
	});
}

function downvote() {
	var id = $('.downvote').first().attr('id');
	var url = '/vote/minus/' + id;

	$.ajax({
		type : "POST",
		url : url,
		data : id,
		success : function(data) {
			$('.spanvotes').html(data);
		}
	});
}

function pagination(url, page, view) {
	var title = $('.title').text();

	$.ajax({
		type : "POST",
		url : url,
		data : {
			page : page,
			cars : $('#completeresults').text().replace('[', '').replace(']',
					''),
			title : title,
			view : view
		},
		success : function(data) {
			onPaginationResult(data);
		}
	});
}

function onPaginationResult(data) {
	$('.carlist').html(data);
	nextButton();
	previousButton();
	filterByCount();
	if ($("#am-container").length > 0){
		animateLayout();
	}
}

function animateBackground() {
	$('.brandpic-background').hover(function() {
		$(this).animate({
			opacity : '1'
		});
	}, function() {
		$(this).animate({
			opacity : '0'
		});
	});
}

function animateGridster() {
	$(".gridster ul").gridster({
		widget_margins : [ 10, 10 ],
		widget_base_dimensions : [ 200, 200 ]
	});
}

function animateLayout() {
	$(function() {
		var $container = $('#am-container'), $imgs = $container.find('img')
				.hide(), totalImgs = $imgs.length, cnt = 0;

		$imgs.each(function(i) {
			var $img = $(this);
			$('<img/>').load(function() {
				++cnt;
				if (cnt === totalImgs) {
					$imgs.show();
					$container.montage({
						alternateHeight : true,
						alternateHeightRange : {
							min : 150,
							max : 150
						},
						margin : 7,
						minw : 200
					});
				}
			}).attr('src', $img.attr('src'));
		});
	});
}