appClientes.controller("estadoController", function($scope, $http) {
	$scope.Estados = [];//array de caloteiros;
	$scope.estado={};//declando um objeto
	
	// funcao carregarcaloteiros
	$scope.carregarEstados = function() {
		$http({
			method : 'GET',
			url : 'http://localhost:8080/estados'
		}).then(function sucessCallback(response) {

			$scope.Estados = response.data;
			console.log(response.status);
			var Estados = response.data;
			
			// funcao para exibir no console o Json que vem da requisição ajax
			// feita pelo angularjs
			

		}, function erroCallback(response) {
			console.log(response.data);
			console.log(response.status);
		});

	};
	$scope.carregarEstados();
	
	
	
	$scope.salvarEstados = function(){
		$http({method : 'POST',url : 'http://localhost:8080/estados',data:$scope.estado})
		.then(function sucessCallback(response) {		
			//$scope.Clientes.push(response.data);
			
			$scope.carregarEstados();
			$scope.estado={};
		}, function erroCallback(response) {
			
			console.log(response.data);
			console.log(response.status);
		});
	}
	
	$scope.removerEstados = function(estado){
		$http({method : 'DELETE',url : 'http://localhost:8080/estados/'+estado.id})
		.then(function sucessCallback(response) {		
			//buscar posicao do cliente no array
			for(i=0;i<$scope.Estados.length;i++){
				if ($scope.Estados[i].id==estado.id){
					var pos=i;
					break;
				}
			}
			$scope.Estados.splice(pos,1);
			
			
		}, function erroCallback(response) {
			console.log(response.data);
			console.log(response.status);
		});
	}
	
	
	$scope.alterarEstados = function(estado){
	
		$scope.estado=angular.copy(estado);
		
	}
	
	$scope.cancelarEstados = function(){
		$scope.estado={};
	}

});