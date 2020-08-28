$(document).ready(function(){
	var ctx = $("#myChart");
	
	var label=[];
	var dataset=[];
	data.forEach(function(entry) {
		label.push(entry._date.substring(0,12))
	    dataset.push(entry._numerosms);
	});
	data[0]._date.substring(0,12)

	var options = {
			title :{
				display:true,
				position:top,
				text:'ciao'
			},responsive:true,
			scales: {
				yAxes: [{
					ticks: {
						beginAtZero:true
					}
				}]
			}
	}

	var myChart = new Chart(ctx, {
		type: 'line',
		data:{
			labels: label,
			datasets: [{
				label: 'SMS inviati',
				data: dataset,
				borderWidth: 1
			}]},
			options: options
	});
})

function convertDate(inputFormat) {
  function pad(s) { return (s < 10) ? '0' + s : s; }
  var d = new Date(inputFormat);
  return [pad(d.getDate()), pad(d.getMonth()+1), d.getFullYear()].join('/');
}