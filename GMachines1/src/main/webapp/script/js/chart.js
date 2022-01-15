$(function() {

	'use strict';

	var options = {
		scales: {
			yAxes: [{
				ticks: {
					beginAtZero: true
				}
			}]
		},
		legend: {
			display: false
		},
		elements: {
			point: {
				radius: 0
			}
		}

	};

	var doughnutPieOptions = {
		responsive: true,
		animation: {
			animateScale: true,
			animateRotate: true
		}
	};
	
	  var areaOptions = {
    plugins: {
      filler: {
        propagate: true
      }
    }
  }
	// Get context with jQuery - using jQuery's .get() method.
	if ($("#barChart").length) {
		var barChartCanvas = $("#barChart").get(0).getContext("2d");
		$.ajax({
			url: "DashboardController",
			datatype: "JSON",
			data: { id: "aa" },
			type: 'POST',
			success: function(data, textStatus, jqXHR) {
				var l = Object.keys(JSON.parse(data));
				var d = Object.values(JSON.parse(data));
				var data1 = {
					labels: l,
					datasets: [{
						label: 'Machine Par Marque',
						data: d,
						backgroundColor: [
							'rgba(255, 99, 132, 0.2)',
							'rgba(54, 162, 235, 0.2)',
							'rgba(255, 206, 86, 0.2)',
							'rgba(75, 192, 192, 0.2)',
							'rgba(153, 102, 255, 0.2)',
							'rgba(255, 159, 64, 0.2)'
						],
						borderColor: [
							'rgba(255,99,132,1)',
							'rgba(54, 162, 235, 1)',
							'rgba(255, 206, 86, 1)',
							'rgba(75, 192, 192, 1)',
							'rgba(153, 102, 255, 1)',
							'rgba(255, 159, 64, 1)'
						],
						borderWidth: 1,
						fill: false
					}]
				};
				var barChart = new Chart(barChartCanvas, {
					type: 'bar',
					data: data1,
					options: options
				});
			}
		});

	}

	if ($("#lineChart").length) {
		var lineChartCanvas = $("#lineChart").get(0).getContext("2d");
		$("#form").on('click', '#add', function() {
			$("#lineChart").attr("hidden",false);
			var marque = ($("#select option:selected").text());
			$.ajax({
				url: "DashboardController",
				datatype: "JSON",
				data: { marque: marque },
				type: 'POST',
				success: function(data, textStatus, jqXHR) {
					console.log(data);
					var l = Object.keys(JSON.parse(data));
					var d = Object.values(JSON.parse(data));
					var data2 = {
						labels: l,
						datasets: [{
							label: 'Nombre d\'achat',
							data: d,
							backgroundColor: [
								'rgba(255, 99, 132, 0.2)',
								'rgba(54, 162, 235, 0.2)',
								'rgba(255, 206, 86, 0.2)',
								'rgba(75, 192, 192, 0.2)',
								'rgba(153, 102, 255, 0.2)',
								'rgba(255, 159, 64, 0.2)'
							],
							borderColor: [
								'rgba(255,99,132,1)',
								'rgba(54, 162, 235, 1)',
								'rgba(255, 206, 86, 1)',
								'rgba(75, 192, 192, 1)',
								'rgba(153, 102, 255, 1)',
								'rgba(255, 159, 64, 1)'
							],
							borderWidth: 1,
							fill: false, // 3: no fill
						}]
					};
					var areaChart = new Chart(lineChartCanvas, {
						type: 'line',
						data: data2,
						options: areaOptions
					});
				}
			});
		});
	};

	if ($("#pieChart").length) {
		var pieChartCanvas = $("#pieChart").get(0).getContext("2d");
		$.ajax({
			url: "DashboardController",
			datatype: "JSON",
			data: {},
			type: 'POST',
			success: function(data, textStatus, jqXHR) {
				var l = Object.keys(JSON.parse(data));
				var d = Object.values(JSON.parse(data));
				var doughnutPieData = {
					datasets: [{
						data: d,
						backgroundColor: [
							'rgba(255, 99, 132, 0.5)',
							'rgba(54, 162, 235, 0.5)',
							'rgba(255, 206, 86, 0.5)',
							'rgba(75, 192, 192, 0.5)',
							'rgba(153, 102, 255, 0.5)',
							'rgba(255, 159, 64, 0.5)'
						],
						borderColor: [
							'rgba(255,99,132,1)',
							'rgba(54, 162, 235, 1)',
							'rgba(255, 206, 86, 1)',
							'rgba(75, 192, 192, 1)',
							'rgba(153, 102, 255, 1)',
							'rgba(255, 159, 64, 1)'
						],
					}],
					// These labels appear in the legend and in the tooltips when hovering different arcs
					labels: l
				};
				var pieChart = new Chart(pieChartCanvas, {
					type: 'pie',
					data: doughnutPieData,
					options: doughnutPieOptions
				});
			},
			error: function(jqXHR, textStatus, errorThrown) {

				console.log(textStatus);
			}
		});

	}
});