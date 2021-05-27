/**
 * 
 */
$('#usuarios').change(function(){
	var usuarioId = $('#usuarios').val();
	
	console.log(usuarioId);
	
	$('#tabela-veiculos tbody').empty();
	
	if(usuarioId != undefined && usuarioId != 0) {
	
		$.ajax({
            url: '/api/veiculos/todos/usuario/' + usuarioId,
            type: 'get',
         	dataType: 'json',
            success:function(response){
				console.log(response);	
				var len = response.length;

                for( var i = 0; i<len; i++){
                    var tipo = response[i]['tipo'];
                    var marca = response[i]['marca'];
                 	var modelo = response[i]['modelo'];
                 	var ano = response[i]['ano'];
                 	var rodizioDia = response[i]['diaRodizio'] != undefined ? response[i]['diaRodizio'] : ""; 
                 	var rodizioAtivo = response[i]['rodizioAtivo'];    	
                 	
                 	var rodizioDescricao = '';    		             	
	                var htmlClassRodizio = '';
	                
                 	if(rodizioAtivo != undefined){
	                 	rodizioDescricao = rodizioAtivo ? 'ATIVO' : 'NÃO ATIVO';   		               	
   		                htmlClassRodizio = rodizioAtivo ? 'font-weight-bold text-danger' : 'font-weight-bold text-dark';
                 	}
                 	
                    $('#tabela-veiculos tbody').append(
                    		"<tr>"+
	                    		"<td>"+tipo+"</td>"+
	                    		"<td>"+marca+"</td>"+
	                    		"<td>"+modelo+"</td>"+
	                    		"<td>"+ano+"</td>"+
	                    		"<td>"+rodizioDia+"</td>"+
	                    		"<td class='"+htmlClassRodizio+"'>"+rodizioDescricao+"</td>"+
                    		"</tr>"
                    );

                }
            }
        });
	}
});