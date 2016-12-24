//criação do modulo principal da aplicação
var appClientes = angular.module("appClientes", ['ngRoute']);
appClientes.config(function($routeProvider){
	$routeProvider
	.when("/clientes", {templateUrl:"views/cliente.html", controller:"clienteController"})
	.when("/estados", {templateUrl:"views/estado.html", controller:"estadoController"})
	.otherwise({redirectTo:'/'});
	
	
});

