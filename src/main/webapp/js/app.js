// module
var app = angular.module('cepApp', ['ngResource']);

// controller
app.controller('enderecoControl', function($scope, $resource) {
	
	/**
	 * Limpar variáveis.
	 */
	$scope.clear = function() {
		 this.mensagemError = null;
		 this.mensagemSuccess = null;
		 this.endereco = null;			
	};
	
	/**
	 * Método para buscar o endereço do CEP.
	 */
	$scope.buscarEnderecoPorCEP	= function(_cep) {

		 $scope.clear();

		 if (_cep == undefined || _cep == '') {
			 $scope.mensagem = 'CEP é obrigatório!';
			 return;
		 }
		 
		console.log('Buscando o endereço do CEP: ' + _cep);

		// Criando resource REST para o CEP
		var cepResource = $resource('services/cep/:cep', {
			cep: _cep,
			isArray: false
		});
	
		// Efetuando a requisição GET no servidor
		cepResource.get().$promise.then(
    			function(endereco) {
    				$scope.endereco = endereco;
    			}, function(error) {
		    		console.log('Ocorreu um erro ao buscar o CEP: ' + error.data);
		    		$scope.mensagemError = error.data;
		    	});
		
	};
	
	/**
	 * Método para salvar o endereço do usuário.
	 */
	$scope.salvarEndereco = function(_endereco) {

		console.log('Salvando endereço.');
		
		// Criando resource REST para o CEP
		var cepResource = $resource('services/endereco');
	
		// Efetuando a requisição GET no servidor
		cepResource.save(_endereco).$promise.then(
    			function(_endereco) {
					$scope.clear();
    				$scope.mensagemSuccess = 'Endereço salvo com sucesso!';
    				$scope.listarEnderecos();
    			}, function(error) {
		    		console.log('Ocorreu um erro ao salvar o endereço: ' + error.data);
		    		$scope.mensagemError = error.data;
		    	});
		
	};
	
	/**
	 * Método para salvar o endereço do usuário.
	 */
	$scope.listarEnderecos = function() {
		 
		console.log('Listar endereços já cadastrados.');
		 
		// Criando resource REST para o CEP
		var cepResource = $resource('services/endereco');
	
		// Efetuando a requisição GET no servidor
		cepResource.query().$promise.then(
    			function(_enderecos) {
    				$scope.enderecos = _enderecos;
    			}, function(error) {
		    		console.log('Ocorreu um erro ao listar endereços: ' + error.data);
		    		$scope.mensagemError = error.data;
		    	});
		
	};
	
	/**
	 * Selecionar endereço da lista.
	 */
	 $scope.selecionarEndereco = function(_endereco) {
		
		$scope.clear();
		 
		// Selecionar endereço da lista no form.
		$scope.endereco = _endereco;
		
	};
	
	/**
	 * Selecionar endereço da lista.
	 */
	 $scope.removerEndereco = function(_endereco) {
	 
		console.log('Remover endereço cadastrado ' + _endereco.id);
		 $scope.clear();
		 
		// Criando resource REST para o CEP
		var cepResource = $resource('services/endereco/:id', {
			id: _endereco.id,
		});
	
		// Efetuando a requisição GET no servidor
		cepResource.delete().$promise.then(
    			function(_enderecos) {
    				$scope.mensagemSuccess = 'Endereço excluído com sucesso!';
    				$scope.listarEnderecos();
    			}, function(error) {
		    		console.log('Ocorreu um erro ao excluir endereço: ' + error.data);
		    		$scope.mensagemError = error.data;
		    	});
		
	};

	// Listar os endereços cadastrados ao entrar na página
	$scope.listarEnderecos();
	
});