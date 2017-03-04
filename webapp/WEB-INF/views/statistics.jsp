<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.1.4/Chart.bundle.min.js"></script>

 	<div class="row row-bg">
 		<div class="headliner">
 			<h4>Statistics</h4>
 			
 			<div class="col l12 m12 s12" id="stats">
 				<div class="col l8 m12 s12 main-title">
 					<h1>${carcount}</h1><h5>cars</h5>
 					<p>across <b>${brandcount}</b> car brands and <b>${makercount}</b> diecast brands.</p>
 				</div>
	 			<div class="col l4 m12 s12 graph">
	 				<h4>Votes</h4>
	 				<canvas id="votes" width="200" height="200"></canvas>
	 			</div>
	 			<div class="col l4 m12 s12 graph">
	 				<h4>Car brands</h4>
	 				<canvas id="brands" width="100" height="100"></canvas>
	 			</div>
	 			<div class="col l4 m12 s12 graph">
	 				<h4>Diecast brands</h4>
	 				<canvas id="makers" width="200" height="200"></canvas>
	 			</div>
	 			<div class="col l4 m12 s12 graph">
	 				<h4>Eras</h4>
	 				<canvas id="eras" width="200" height="200"></canvas>
	 			</div>
	 			<div class="col l4 m12 s12 graph">
	 				<h4>Categories</h4>
	 				<canvas id="categories" width="100" height="100"></canvas>
	 			</div>
	 			<div class="col l4 m12 s12 graph">
	 				<h4>Colors</h4>
	 				<canvas id="colors" width="200" height="200"></canvas>
	 			</div>
	 			<div class="col l4 m12 s12 graph">
	 				<h4>Countries</h4>
	 				<canvas id="countries" width="200" height="200"></canvas>
	 			</div>
 			</div>
		</div>
 	</div>
 	
<script>
	// Generate data
	var numberOfElements = 10;
	
	var counts = new Array();
	var labels = new Array();
	
	<c:forEach items="${brands}" var="element">
		counts.push(${element.count});
		labels.push("${element.value}");
	</c:forEach>
	
	generateChart(counts, labels, 'brands', 'doughnut');
	
	counts = new Array();
	labels = new Array();
	
	<c:forEach items="${makers}" var="element">
		counts.push(${element.count});
		labels.push("${element.value}");
	</c:forEach>
	
	generateChart(counts, labels, 'makers', 'doughnut');

	counts = new Array();
	labels = new Array();
	
	<c:forEach items="${eras}" var="element">
		counts.push(${element.count});
		labels.push("${element.value}");
	</c:forEach>
	
	generateChart(counts, labels, 'eras', 'doughnut');
	
	counts = new Array();
	labels = new Array();
	
	<c:forEach items="${categories}" var="element">
		counts.push(${element.count});
		labels.push("${element.value}");
	</c:forEach>
	
	generateChart(counts, labels, 'categories', 'doughnut');
	
	counts = new Array();
	labels = new Array();
	
	<c:forEach items="${colors}" var="element">
		counts.push(${element.count});
		labels.push("${element.value}");
	</c:forEach>
	
	generateChart(counts, labels, 'colors', 'doughnut');
	
	counts = new Array();
	labels = new Array();
	
	<c:forEach items="${countries}" var="element">
		counts.push(${element.count});
		labels.push("${element.value}");
	</c:forEach>
	
	generateChart(counts, labels, 'countries', 'doughnut');
	
	counts = new Array();
	labels = new Array();
	
	<c:forEach items="${votes}" var="element">
		counts.push(${element.count});
		labels.push("${element.value}");
	</c:forEach>
	
	generateChart(counts, labels, 'votes', 'doughnut');
	
	function generateChart(counts, labels, id, type) {
		counts = counts.slice(0, numberOfElements);
		labels = labels.slice(0, numberOfElements);
		
		var myChart = new Chart(document.getElementById(id), {
		    type: type,
		    data: {
		        labels: labels,
		        datasets: [{
		        	backgroundColor: poolColors(counts.length),
		        	borderColor: '#616161',
		            data: counts
		        }]
		    },
		    options: {
		    	legend: {
		    		position: 'bottom',
		    		labels: {
		    			fontColor: '#616161',
		    			fontSize: 15
		    		}
		    	}
		    }
		});
		
		function poolColors(size) {
	        var pool = [];
	        pool.push('#00897b');
	        pool.push('#e0f2f1');
	        pool.push('#01579b');
	        pool.push('#ef5350');
	        pool.push('#f0f4c3');
	        pool.push('#c8e6c9');
	        pool.push('#795548');
	        pool.push('#616161');
	        pool.push('#9575cd');
	        pool.push('#f8bbd0');
	        
	        return pool;
	    }
	}
</script>