# ControlVehiclesAPI
API para o controle de veículos de usuários.


### Acessos da API

Endpoint para "Cadastrar os Usuários": 

`{servidor}/api/usuarios/adiciona` 

Endpoint para "Cadastrar os Veículos": 

`{servidor}/api/veiculos/adiciona`
 
Endpoint para "Listar Veículos de Usuários": 

`{servidor}/api/veiculos/todos/usuario/{idUsuario}`

Endpoint para "Obter os Usuários": 

`{servidor}/api/usuarios/todos`

### Acessos da API da FIPE para obter um Veículo para Cadastro

Endpoint para Obter as "Marcas" de um Tipo de Veículo: 

`{servidor}/fipe/api/veiculos/{tipoVeículo}/marcas`

Endpoint para Obter os "Modelos": 

`{servidor}/fipe/api/veiculos/{tipoVeiculo}/marcas/{codMarca}/modelos` 

Endpoint para Obter os "Anos":
 
`{servidor}/fipe/api/veiculos/{tipoVeiculo}/marcas/{codMarca}/modelos/{codModelo}/anos`

Endpoint para Obter o "Veículo Completo":
 
`{servidor}/fipe/api/veiculos/{tipoVeiculo}/marcas/{codMarca}/modelos/{codModelo}/anos/{codAno}`
 
### Exemplos de envios para o Servidor (API) 

- "Cadastro de Usuário"

~~~php
{
	"nome":"Teste da Silva",
	"email":"teste@email.com",
	"cpf":"000000000",
	"dataNascimento":"0000-00-00"
}
~~~
 
 - "Cadastro de Veículos"
 
~~~php
{
	"tipo":"carros", // Pode ser 'carros', 'motos' ou 'caminhoes'
	"marca":"1",
	"modelo":"1",
	"ano":"1992-1",
	"usuarioId": 0 //Você pode obter o ID Usuário através da "Lista de Usuários"
}
~~~
 