//var data = [
//    ['br-sp', 0],
//    ['br-ma', 1],
//    ['br-pa', 2],
//    ['br-sc', 3],
//    ['br-ba', 4],
//    ['br-ap', 5],
//    ['br-ms', 6],
//    ['br-mg', 7],
//    ['br-go', 8],
//    ['br-rs', 9],
//    ['br-to', 10],
//    ['br-pi', 11],
//    ['br-al', 12],
//    ['br-pb', 13],
//    ['br-ce', 14],
//    ['br-se', 15],
//    ['br-rr', 16],
//    ['br-pe', 17],
//    ['br-pr', 18],
//    ['br-es', 19],
//    ['br-rj', 20],
//    ['br-rn', 21],
//    ['br-am', 22],
//    ['br-mt', 23],
//    ['br-df', 24],
//    ['br-ac', 25],
//    ['br-ro', 26]
//];

function recuperaDados(){
		var dataFormatado;
		console.log("entoru");
	   
	   jQuery.ajax({
	   	type: "GET",        
	   	//async: false,
	     url: '/clientes/dados',
	     
	     cache:false,
	      
	     dataType:"text",
	      
	     success: function(data) {
	    	 console.log("teste");
	    	 
	    	 var jsonDados = JSON.parse(data); 
	 		
	    	 Highcharts.mapChart('containerMap', {
	 		    chart: {
	 		        map: 'countries/br/br-all'
	 		    },

	 		    title: {
	 		        text: 'Highmaps basic demo'
	 		    },

	 		    subtitle: {
	 		        text: 'Source map: <a href="http://code.highcharts.com/mapdata/countries/br/br-all.js">Brazil</a>'
	 		    },

	 		    mapNavigation: {
	 		        enabled: true,
	 		        buttonOptions: {
	 		            verticalAlign: 'bottom'
	 		        }
	 		    },

	 		    colorAxis: {
	 		        min: 0
	 		    },

	 		    series: [{
	 		        data: jsonDados,
	 		        name: 'Random data',
	 		        states: {
	 		            hover: {
	 		                color: '#BADA55'
	 		            }
	 		        },
	 		        dataLabels: {
	 		            enabled: true,
	 		            format: '{point.name}'
	 		        }
	 		    }]
	 		}); 	 
	    	
	    	 
	     },
	     error: function() { alert('Ocorreu um erro ao logar'); }
	   });
		
		
		
		
}
$(document).ready(function(){
	
	 recuperaDados();
	 

	console.log("entoru");
	});




// Create the chart

