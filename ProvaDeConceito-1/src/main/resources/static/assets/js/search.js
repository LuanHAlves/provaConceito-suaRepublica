
function pesquisaClientes(){
   var string=document.getElementById('pesquisaClientes').value;
   console.log('teste')
   if(string=='')
	   string=' ';
   
   jQuery.ajax({
   	type: "GET",        
   	//async: false,
     url: '/clientes/pesquisar/'+string,
     
     cache:false,
      
     dataType:"json",
      
     success: function(data) {
    	 jQuery('#tabelaClientes').html(" ");
    	 
    	 jQuery.each(data,function(index,cliente){    	 
    		 jQuery('#tabelaClientes').append('<tr>'+
				'<th>'+cliente.id+'</th>'+															
				'<td>'+cliente.nome+'</td>'+																		
				'<td>'+cliente.idade+'</td>'+	
				'<td>'+cliente.email+'</td>'+	
				'<td>'+cliente.estado+'</td></tr>');
    	  });
    	 
    	 if(jQuery('#tabelaClientes').html()==" "){
    		 jQuery('#tabelaClientes').append('<tr><td colspan="5">Nenhum cliente encontrado</td></tr>');
    	 }
    	
    	 
     }
   }); 
  }

function pesquisaFornecedores(){
	   var string=document.getElementById('pesquisaFornecedores').value;
	   console.log('teste')
	   if(string=='')
		   string=' ';
	   
	   jQuery.ajax({
	   	type: "GET",        
	   	//async: false,
	     url: '/fornecedores/pesquisar/'+string,
	     
	     cache:false,
	      
	     dataType:"json",
	      
	     success: function(data) {
	    	 jQuery('#tabelaFornecedores').html(" ");
	    	 
	    	 jQuery.each(data,function(index,cliente){    	 
	    		 jQuery('#tabelaFornecedores').append('<tr>'+
					'<th>'+cliente.id+'</th>'+															
					'<td>'+cliente.nome+'</td>'+																		
					'<td>'+cliente.produtoFornecido+'</td>'+	
					'<td>'+cliente.estado+'</td>'+	
					'<td>'+cliente.telefone+'</td>'+	
					'<td>'+cliente.email+'</td></tr>');
	    	  });
	    	 
	    	 if(jQuery('#tabelaFornecedores').html()==" "){
	    		 jQuery('#tabelaFornecedores').append('<tr><td colspan="5">Nenhum fornecedor encontrado</td></tr>');
	    	 }
	    	
	    	 
	     }
	   }); 
	  }

  
jQuery('#btnPesquisaClientes').click(function(){
	pesquisaClientes()
});

jQuery('#btnPesquisaFornecedores').click(function(){
	pesquisaFornecedores()
});










