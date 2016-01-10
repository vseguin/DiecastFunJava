$(document).ready(
		function() {
			ajaxPost('brands', 'brandschart', 'Brands Statistics', '/carbrands/');
			ajaxPost('tags', 'tagschart', 'Categories Statistics', '/categories/');
			ajaxPost('colors', 'colorschart', 'Colors Statistics');
			ajaxPost('countries', 'countrieschart', 'Countries Statistics');
			ajaxPost('eras', 'eraschart', 'Eras Statistics', '/eras/');
			ajaxPost('makers', 'makerschart', 'Makers Statistics', '/makers/');
			ajaxPost('votes', 'voteschart', 'Votes Statistics');

			$(".plotContainer").bind('jqplotDataHighlight',
					function(ev, seriesIndex, pointIndex, data) {
						var $this = $(this);

						$this.attr('title', data[0] + " : " + data[1]);
					});

			$(".plotContainer").bind('jqplotDataUnhighlight',
					function(ev, seriesIndex, pointIndex, data) {
						var $this = $(this);

						$this.attr('title', "");
					});
			
	        $('.plotContainer').bind('jqplotDataClick', 
	                function (ev, seriesIndex, pointIndex, data) {
	        			if (data[2] != undefined) {
	        				window.location.href=data[2];
	        			}
	                }
	            );
		});

function ajaxPost(urlEnd, chartName, chartTitle, chartUrl) {
	var url = '/statistics/';
	
	$.ajax({
		type : "POST",
		url : url + urlEnd,
		success : function(data) {
			plotData(data, chartName, chartTitle, chartUrl);
		}
	});
}

function plotData(data, divName, givenTitle, link) {
	var results = JSON.parse(data);
	ds = [];
	var others = 0;
	for ( var key in results) {
		var parsedInt = parseInt(results[key]);
		if (parsedInt > 2) {
			if (link != null) {
				ds.push([ key, parsedInt , link + key]);
			} else {
				ds.push([ key, parsedInt]);
			}
		} else {
			others += parsedInt;
		}
	}
	ds.push([ 'Others', others ]);
	$.jqplot(divName, [ ds ], {
		title: givenTitle,
		seriesDefaults : {
			renderer : jQuery.jqplot.PieRenderer,
			rendererOptions : {
				showDataLabels : true,
			}
		},
		legend : {
			show : true,
			location : 'e'
		}
	});
}