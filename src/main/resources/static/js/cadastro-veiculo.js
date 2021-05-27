/**
 * 
 */

$(function(){
	$('#marcas').prop('disabled', true);
	$('#modelos').prop('disabled', true);
	$('#anos').prop('disabled', true);
	$('#usuarios').prop('disabled', true);    		
	$('#valorTotal').text('R$ 00,00');
});

$('#tipos').change(function() {
	var tipoEscolhido = $(this).val();
	console.log(tipoEscolhido);
	
	$('#marcas').prop('disabled', true);
	$('#marcas').empty();
	
	$('#modelos').prop('disabled', true);
	$('#modelos').empty();
	
	$('#anos').prop('disabled', true);
	$('#anos').empty();
	
	$('#usuarios').prop('disabled', true);
	$('#usuarios').empty();
	
	$('#valorTotal').text('R$ 00,00');
	
	if(tipoEscolhido != undefined && tipoEscolhido != ''){
		$.ajax({
            url: '/fipe/api/veiculos/' + tipoEscolhido + '/marcas',
            type: 'get',
         	dataType: 'json',
            success:function(response){
				console.log(response);
				var len = response.length;

				$('#marcas').empty();
				$('#marcas').append("<option></option>");
                for( var i = 0; i<len; i++){
                    var nome = response[i]['nome'];
                    var codigo = response[i]['codigo'];
                    
                    $('#marcas').append("<option value='"+codigo+"'>"+nome+"</option>");

                }
                
                $('#marcas').prop('disabled', false);
            }
        });
	}
});

$('#marcas').change(function() {
	var tipoEscolhido = $('#tipos').val();
	var marcaEscolhida = $('#marcas').val();
	
	console.log(marcaEscolhida);

	$('#modelos').prop('disabled', true);
	$('#modelos').empty();
		
	$('#anos').prop('disabled', true);
	$('#anos').empty();
		
	$('#usuarios').prop('disabled', true);
	$('#usuarios').empty();
		
	$('#valorTotal').text('R$ 00,00');
	
	if(marcaEscolhida != undefined && marcaEscolhida != '') {
	
		$.ajax({
            url: '/fipe/api/veiculos/' + tipoEscolhido + 
            		'/marcas/' + marcaEscolhida + '/modelos',
            type: 'get',
         	dataType: 'json',
            success:function(response){
				console.log(response);
				response = response['modelos'];
				var len = response.length;

				$('#modelos').empty();
				$('#modelos').append("<option></option>");
                for( var i = 0; i<len; i++){
                    var nome = response[i]['nome'];
                    var codigo = response[i]['codigo'];
                    
                    $('#modelos').append("<option value='"+codigo+"'>"+nome+"</option>");

                }
                
                $('#modelos').prop('disabled', false);
            }
        });	
	}
});

$('#modelos').change(function() {
	var tipoEscolhido = $('#tipos').val();
	var marcaEscolhida = $('#marcas').val();
	var modeloEscolhido = $('#modelos').val();
	
	console.log(modeloEscolhido);
	
	$('#anos').prop('disabled', true);
	$('#anos').empty();
	
	$('#usuarios').prop('disabled', true);
	$('#usuarios').empty();
	
	$('#valorTotal').text('R$ 00,00');
		
	if(modeloEscolhido != undefined && modeloEscolhido != '') {
	
		$.ajax({
            url: '/fipe/api/veiculos/' + tipoEscolhido + 
            		'/marcas/' + marcaEscolhida + 
            		'/modelos/' + modeloEscolhido + '/anos',
            type: 'get',
         	dataType: 'json',
            success:function(response){
				console.log(response);
				var len = response.length;

				$('#anos').empty();
				$('#anos').append("<option></option>");
                for( var i = 0; i<len; i++){
                    var nome = response[i]['nome'];
                    var codigo = response[i]['codigo'];
                    
                    $('#anos').append("<option value='"+codigo+"'>"+nome+"</option>");

                }
                
                $('#anos').prop('disabled', false);
            }
        });   			
	}
});

$('#anos').change(function() {
	var tipoEscolhido = $('#tipos').val();
	var marcaEscolhida = $('#marcas').val();
	var modeloEscolhido = $('#modelos').val();
	var anoEscolhido = $('#anos').val();
	
	console.log(anoEscolhido);
	
	$('#usuarios').prop('disabled', true);
	$('#usuarios').empty();
	$('#valorTotal').text('R$ 00,00');
	
	if(anoEscolhido != undefined && anoEscolhido != '') {
	
		$.ajax({
            url: '/fipe/api/veiculos/' + tipoEscolhido + 
            		'/marcas/' + marcaEscolhida + 
            		'/modelos/' + modeloEscolhido + 
            		'/anos/' + anoEscolhido,
            type: 'get',
         	dataType: 'json',
            success:function(response){
				console.log(response);
				
				$('#valorTotal').text(response['Valor']);
                
                $('#usuarios').prop('disabled', false);
            }
        });
		
		$.ajax({
			url: '/api/usuarios/todos',
            type: 'get',
         	dataType: 'json',
            success:function(response){
				console.log(response);
				var len = response.length;
				
				$('#usuarios').empty();
				$('#usuarios').append("<option></option>");
				for( var i = 0; i<len; i++){
                    var id = response[i]['id'];
                    var nome = response[i]['nome'];
                    
                    $('#usuarios').append("<option value='"+id+"'>"+nome+"</option>");
                }
            }
		});
	}
});