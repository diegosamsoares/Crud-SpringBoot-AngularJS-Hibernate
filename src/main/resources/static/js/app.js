//criação do modulo principal da aplicação
var appClientes = angular.module("appClientes", []);

// criação de controllers
// cada tela tem um controller
appClientes.controller("clienteController", function($scope, $http) {
	$scope.Clientes = [];//array de caloteiros;
	$scope.cliente={};//declando um objeto

	// funcao carregarcaloteiros
	$scope.carregarClientes = function() {
		$http({
			method : 'GET',
			url : 'http://localhost:8080/clientes'
		}).then(function sucessCallback(response) {

			$scope.Clientes = response.data;
			console.log(response.status);
			var Clientes = response.data;

			// funcao para exibir no console o Json que vem da requisição ajax
			// feita pelo angularjs
			function nomes() {

				for (i = 0; i < Clientes.length; i++) {
					console.log(Clientes[i]);
				}
			}
			nomes();

		}, function erroCallback(response) {
			console.log(response.data);
			console.log(response.status);
		});

	};
	$scope.carregarClientes();
	
	
	
	$scope.salvarClientes = function(){
		$http({method : 'POST',url : 'http://localhost:8080/clientes',data:$scope.cliente})
		.then(function sucessCallback(response) {		
			//$scope.Clientes.push(response.data);
			
			$scope.carregarClientes();
			$scope.cliente={};
		}, function erroCallback(response) {
			
			console.log(response.data);
			console.log(response.status);
		});
	}
	
	$scope.removerClientes = function(cliente){
		$http({method : 'DELETE',url : 'http://localhost:8080/clientes/'+cliente.id})
		.then(function sucessCallback(response) {		
			//buscar posicao do cliente no array
			for(i=0;i<$scope.Clientes.length;i++){
				if ($scope.Clientes[i].id==cliente.id){
					var pos=i;
					break;
				}
			}
			$scope.Clientes.splice(pos,1);
			
			
		}, function erroCallback(response) {
			console.log(response.data);
			console.log(response.status);
		});
	}
	
	
	$scope.alterarClientes = function(cliente){
	
		$scope.cliente=angular.copy(cliente);
		
	}
	
	$scope.cancelarClientes = function(){
		$scope.cliente={};
	}

});