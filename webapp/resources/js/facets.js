var activeClass = 'active';
var btnClear = '.btn-clear';
var accordion = '.accordion';

$(document).ready(function() {
	paginationViewName = 'facetsresults';
	
	$("#btn-clear-all").click(function() {
		var data = {carCount : $('#carcount').val()};
		$('.facetelement').removeClass(activeClass);
		postCondition('clearall', data);
		$(this).hide();
	});
	
	$('#btn-clear-brands').click(function() {
		var data = {carCount : $('#carcount').val()};
		$('.brandelement').removeClass(activeClass);
		postCondition('removebrands', data);
		$(this).hide();
	});
	
	$('#btn-clear-makers').click(function() {
		var data = {carCount : $('#carcount').val()};
		$('.makerelement').removeClass(activeClass);
		postCondition('removemakers', data);
		$(this).hide();
	});
	
	$('#btn-clear-eras').click(function() {
		var data = {carCount : $('#carcount').val()};
		$('.eraelement').removeClass(activeClass);
		postCondition('removeeras', data);
		$(this).hide();
	});
	
	$('#btn-clear-categories').click(function() {
		var data = {carCount : $('#carcount').val()};
		$('.categoryelement').removeClass(activeClass);
		postCondition('removecategories', data);
		$(this).hide();
	});
	
	$('#btn-clear-colors').click(function() {
		var data = {carCount : $('#carcount').val()};
		$('.colorelement').removeClass(activeClass);
		postCondition('removecolors', data);
		$(this).hide();
	});
	
	$('#btn-clear-countries').click(function() {
		var data = {carCount : $('#carcount').val()};
		$('.countryelement').removeClass(activeClass);
		postCondition('removecountries', data);
		$(this).hide();
	});
	
	$(".brandelement").toggle(function(event) {
		var data = { brand : $(this).children('.pull-left').text(), carCount : $('#carcount').val()};
		event.preventDefault();
		postCondition('addbrand', data);
		showElements($(this));
	}, function(event) {
		var data = { brand : $(this).children('.pull-left').text(), carCount : $('#carcount').val()};
		event.preventDefault();
		postCondition('removebrand', data);
		hideElements($(this));
	});
	
	$(".makerelement").toggle(function(event) {
		var data = { maker : $(this).children('.pull-left').text(), carCount : $('#carcount').val()};
		event.preventDefault();
		postCondition('addmaker', data);
		showElements($(this));
	}, function(event) {
		var data = { maker : $(this).children('.pull-left').text(), carCount : $('#carcount').val()};
		event.preventDefault();
		postCondition('removemaker', data);
		hideElements($(this));
	});
	
	$(".eraelement").toggle(function(event) {
		var data = { era : $(this).children('.pull-left').text(), carCount : $('#carcount').val()};
		event.preventDefault();
		postCondition('addera', data);
		showElements($(this));
	}, function(event) {
		var data = { era : $(this).children('.pull-left').text(), carCount : $('#carcount').val()};
		event.preventDefault();
		postCondition('removeera', data);
		hideElements($(this));
	});
	
	$(".categoryelement").toggle(function(event) {
		var data = { category : $(this).children('.pull-left').text(), carCount : $('#carcount').val()};
		event.preventDefault();
		postCondition('addcategory', data);
		showElements($(this));
	}, function(event) {
		var data = { category : $(this).children('.pull-left').text(), carCount : $('#carcount').val()};
		event.preventDefault();
		postCondition('removecategory', data);
		hideElements($(this));
	});
	
	$(".colorelement").toggle(function(event) {
		var data = { color : $(this).children('.pull-left').text(), carCount : $('#carcount').val()};
		event.preventDefault();
		postCondition('addcolor', data);
		showElements($(this));
	}, function(event) {
		var data = { color : $(this).children('.pull-left').text(), carCount : $('#carcount').val()};
		event.preventDefault();
		postCondition('removecolor', data);
		hideElements($(this));
	});
	
	$(".countryelement").toggle(function(event) {
		var data = { country : $(this).children('.pull-left').text(), carCount : $('#carcount').val()};
		event.preventDefault();
		postCondition('addcountry', data);
		showElements($(this));
	}, function(event) {
		var data = { country : $(this).children('.pull-left').text(), carCount : $('#carcount').val()};
		event.preventDefault();
		postCondition('removecountry', data);
		hideElements($(this));
	});
});

function showElements(object) {
	object.addClass(activeClass);
	object.closest(accordion).find(btnClear).show();
}

function hideElements(object) {
	object.removeClass(activeClass);
	var accordionElement = object.closest(accordion);
	if (!(accordionElement.find('.' + activeClass).length)) {
		accordionElement.find(btnClear).hide();
	}
}

function postCondition(target, data) {
	$.ajax({
		type : "POST",
		url : '/facets/' + target,
		data : data,
		success : function(data) {
			$('.carlist').html(data);
			nextButton();
			previousButton();
			filterByCount();
			// Carousel has 2 actives.
			if ($('.' + activeClass).length > 2) {
				$("#btn-clear-all").show();
			} else {
				$("#btn-clear-all").hide();
				$(".btn-clear").hide();
			}
		}
	});
}