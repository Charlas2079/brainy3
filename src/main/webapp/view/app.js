/**
 * 
 */

var app = angular.module('app',[]);

//app.value("idSelClient", 0);
/*
app.factory("myFactory", function(){
	var idSelCliente;
	function set(data){
		
	}
	function get(){
		return idSelCliente;
	}
	return{
		set: set,
		get: get
	}
	
});*/

//var injector = angular.injector(['ng', 'myModule'])

app.controller('UserCRUDCtrl', ['$scope','UserCRUDService', function ($scope,UserCRUDService) {

	$scope.updateUser = function () {
		UserCRUDService.updateUser($scope.user.idPersona, $scope.user.nombre, $scope.user.cargo, $scope.user.edad, $scope.user.sector, $scope.user.experiencia, $scope.user.area, $scope.user.email)
		.then(function success(response){
			$scope.message = 'User data updated!';
			$scope.errorMessage = '';
		},
		function error(response){
			$scope.errorMessage = 'Error updating user!';
			$scope.message = '';
		});
	}

	$scope.getUser = function () {
		var id = $scope.user.id;
		UserCRUDService.getUser($scope.user.idPersona)
		.then(function success(response){
			$scope.user = response.data;
			$scope.user.id = id;
			$scope.message='';
			$scope.errorMessage = '';
		},
		function error (response ){
			$scope.message = '';
			if (response.status === 404){
				$scope.errorMessage = 'User not found!';
			}
			else {
				$scope.errorMessage = "Error getting user!";
			}
		});
	}

	$scope.addUser = function () {
		if ($scope.user != null && $scope.user.nombre) {
			UserCRUDService.addUser($scope.user.idPersona, $scope.user.nombre, $scope.user.cargo, $scope.user.edad, $scope.user.sector, $scope.user.experiencia, $scope.user.area, $scope.user.email)
			.then (function success(response){
				$scope.message = 'User added!';
				$scope.errorMessage = '';
			},
			function error(response){
				$scope.errorMessage = 'Error adding user!';
				$scope.message = '';
			});
		}
		else {
			$scope.errorMessage = 'Please enter a name!';
			$scope.message = '';
		}
	}

	$scope.deleteUser = function () {
		UserCRUDService.deleteUser($scope.user.idPersona)
		.then (function success(response){
			$scope.message = 'User deleted!';
			$scope.user = null;
			$scope.errorMessage='';
		},
		function error(response){
			$scope.errorMessage = 'Error deleting user!';
			$scope.message='';
		})
	}

	$scope.getAllUsers = function () {
		UserCRUDService.getAllUsers()
		.then(function success(response){
			$scope.users = response.data._embedded.users;
			$scope.message='';
			$scope.errorMessage = '';
		},
		function error (response ){
			$scope.message='';
			$scope.errorMessage = 'Error getting users!';
		});
	}

}]);

app.service('UserCRUDService',['$http', function ($http) {

	this.getUser = function getUser(userId){
		return $http({
			method: 'GET',
			url: 'api/users/'+userId
		});
	}

	this.addUser = function addUser(idPersona, nombre, cargo, edad, sector, experiencia, area, email){
		return $http({
			method: 'POST',
			url: 'api/users',
			data: {idPersona:idPersona, nombre:nombre, cargo:cargo, edad:edad, experiencia:experiencia, area:area, sector:sector, email:email}
		});
	}

	this.deleteUser = function deleteUser(id){
		return $http({
			method: 'DELETE',
			url: 'api/users/'+id
		})
	}

	this.updateUser = function updateUser(idPersona, nombre, cargo, edad, sector, experiencia, area, email){
		return $http({
			method: 'PATCH',
			url: 'api/users/'+idPersona,
			data: {nombre:nombre, cargo:cargo, edad:edad, experiencia:experiencia, area:area, sector:sector, email:email}
		})
	}

	this.getAllUsers = function getAllUsers(){
		return $http({
			method: 'GET',
			url: 'api/users'
		});
	}

}]);


//clientes

//app.controller('MainCtrl', MainCtrl);

app.controller('ClientCRUDCtrl', ['$scope','ClientCRUDService', function ($scope,ClientCRUDService) {
	
	$scope.IsVisible = false;

    $scope.ShowHide = function(){
        $scope.IsVisible = !$scope.IsVisible;
    }
    
    
    $scope.checkoptions = function (choice) {
    	var details = [];
    	if ($scope.selCliente!=undefined){    		
    		sessionStorage.clientSeleccionado = JSON.stringify($scope.selCliente);
    	}  		
    	else{
    		$scope.msg = 'Por favor escoge un cliente';
    	}
    		
    }
 

	$scope.updateClient = function () {
		ClientCRUDService.updateClient($scope.client.idCliente,$scope.client.nombre,$scope.client.tipoCliente)
		.then(function success(response){
			$scope.message = 'Client data updated!';
			$scope.errorMessage = '';
		},
		function error(response){
			$scope.errorMessage = 'Error updating client!';
			$scope.message = '';
		});
	}

	$scope.getClient = function () {
		var id = $scope.client.idCliente;
		ClientCRUDService.getClient($scope.client.idCliente)
		.then(function success(response){
			$scope.client = response.data;
			$scope.client.idCliente = id;
			$scope.message='';
			$scope.errorMessage = '';
		},
		function error (response ){
			$scope.message = '';
			if (response.status === 404){
				$scope.errorMessage = 'Client not found!';
			}
			else {
				$scope.errorMessage = "Error getting Client!";
			}
		});
	}

	$scope.addClient = function () {
		if ($scope.client != null && $scope.client.nombre) {
			ClientCRUDService.addClient($scope.client.nombre, $scope.client.tipoCliente)
			.then (function success(response){
				$scope.message = 'Client added!';
				$scope.errorMessage = '';
			},
			function error(response){
				$scope.errorMessage = 'Error adding client!';
				$scope.message = '';
			});
		}
		else {
			$scope.errorMessage = 'Please enter a name!';
			$scope.message = '';
		}
	}

	$scope.deleteClient = function () {
		ClientCRUDService.deleteClient($scope.client.idCliente)
		.then (function success(response){
			$scope.message = 'Client deleted!';
			$scope.client = null;
			$scope.errorMessage='';
		},
		function error(response){
			$scope.errorMessage = 'Error deleting client!';
			$scope.message='';
		})
	}

	/*$scope.gridClients = {
    	    enableRowSelection: true,
    	    enableSelectAll: false,
    	    selectionRowHeaderWidth: 35,
    	    rowHeight: 35,
    	    showGridFooter:true
    	  };

    $scope.gridClients.columnDefs = [
        { name: 'Nombre' },
        { name: 'Tipo Cliente'}        
      ];*/
	
	
	var getAllClients = function () {
		ClientCRUDService.getAllClients()
		.then(function success(response){      
			//$scope.gridClients.data = response.data._embedded.clients;
			$scope.clientes = response.data._embedded.clients;
			$scope.message='';
			$scope.errorMessage = '';    
		},
		function error (response ){
			$scope.message='';
			$scope.errorMessage = 'Error getting clients!';
		});
	}
	
	getAllClients();
}]);

app.service('ClientCRUDService',['$http', function ($http) {

	this.getClient = function getClient(clientId){
		return $http({
			method: 'GET',
			url: 'api/clients/'+clientId
		});
	}

	this.addClient = function addClient (nombre, tipoCliente){
		return $http({
			method: 'POST',
			url: 'api/clients',
			data: {nombre:nombre, tipoCliente:tipoCliente}
		});
	}

	this.deleteClient = function deleteClient(id){
		return $http({
			method: 'DELETE',
			url: 'api/clients/'+id
		})
	}

	this.updateClient = function updateClient(idCliente, nombre, tipoCliente){
		return $http({
			method: 'PATCH',
			url: 'api/clients/'+idCliente,
			data: {nombre:nombre, tipoCliente:tipoCliente}
		})
	}

	this.getAllClients = function getAllClients(){
		return $http({
			method: 'GET',
			url: 'api/clients'
		});
	}

}]);




//encuestas
app.controller('PollCRUDCtrl', ['$scope','PollCRUDService', function ($scope, PollCRUDService) {
	
	$scope.IsVisible = false;

    $scope.ShowHide = function(){
        $scope.IsVisible = !$scope.IsVisible;        
    }
    $scope.clienteSeleccionado = JSON.parse(sessionStorage.clientSeleccionado);
    
    $scope.checkoptions = function (choice) {
    	var details = [];
    	if ($scope.selEncuesta!=undefined){    		
    		sessionStorage.pollSeleccionado = JSON.stringify($scope.selEncuesta);
    	}  		
    	else{
    		$scope.msg = 'Por favor escoge un cliente';
    	}
    		
    }
    
    //$scope.message = ClienteSeleccionado;
    
	/*$scope.getPoll = function () {
      var id = $scope.client.idCliente;
      ClientCRUDService.getClient($scope.client.idCliente)
        .then(function success(response){
            $scope.client = response.data;
            $scope.client.idCliente = id;
            $scope.message='';
            $scope.errorMessage = '';
        },
        function error (response ){
            $scope.message = '';
            if (response.status === 404){
                $scope.errorMessage = 'Client not found!';
            }
            else {
                $scope.errorMessage = "Error getting Client!";
            }
        });
  }*/

	$scope.addPoll = function () {
		if ($scope.poll != null ) {
			PollCRUDService.addPoll($scope.poll.numeroPersonas, $scope.poll.fecha_encuesta, $scope.poll.numeroPreguntas, $scope.clienteSeleccionado, $scope.poll.nombreEncuesta, $scope.poll.fecha_cierre)
			.then (function success(response){
				$scope.message = 'Poll added!';
				$scope.errorMessage = '';
			},
			function error(response){
				$scope.errorMessage = 'Error adding poll!';
				$scope.message = '';
			});
		}
		else {
			$scope.errorMessage = 'Please enter a name!';
			$scope.message = '';
		}
	}


	var getAllPolls = function () {
		PollCRUDService.getAllPolls()
		.then(function success(response){      
			$scope.encuestas = response.data._embedded.encuestas;
			$scope.message='';
			$scope.errorMessage = '';    
		},
		function error (response ){
			$scope.message='';
			$scope.errorMessage = 'Error getting polls!';
		});
	}  
	getAllPolls();
}]);

app.service('PollCRUDService',['$http', function ($http) {

	this.getPoll = function getClient(pollId){
		return $http({
			method: 'GET',
			url: 'api/encuestas/'+pollId
		});
	}

	this.addPoll = function addPoll (numeroPersonas, fechaEncuesta, numeroPreguntas, idCliente, nombreEncuesta, fechaCierre){
		return $http({
			method: 'POST',
			url: 'api/encuestas',
			data: {numero_personas: numeroPersonas, fecha_encuesta: fechaEncuesta, numero_preguntas: numeroPreguntas, idCliente: idCliente, nombre_encuesta: nombreEncuesta, fecha_cierre: fechaCierre}
		});
	}

	this.getAllPolls = function getAllPolls(){
		return $http({
			method: 'GET',
			url: 'api/encuestas'
		});
	}

}]);


//Configure

app.controller('ConfigureCtrl', ['$scope','ConfigureService', function ($scope,ConfigureService) {
	
	
	$scope.gruposFront = [];
	$scope.criteriosFront = [];
	$scope.gruposNameArray = [];
	$scope.criteriosNameArray = [];
	$scope.answersNameArray = [];
	
	$scope.addGrupo = function(index, groups) {				
		$scope.gruposFront.push({"indice":index,"groups":groups});
	}

	$scope.removeGrupo = function(grupo,index) {
		var index = $scope.gruposFront[index].indexOf(grupo);
		$scope.gruposFront[index].splice(index,1);
	}
	
	

	$scope.addCriterio = function(index, proofs) {	
		$scope.criteriosFront.push({"indice":index,"proofs":proofs});
	}

	$scope.removeCriterio = function(criterio,index) {
		var index = $scope.criteriosFront[index].indexOf(criterio);
		$scope.criteriosFront[index].splice(index,1);
	}
	
	
    
	$scope.clienteSeleccionado = JSON.parse(sessionStorage.clientSeleccionado);
	$scope.pollSeleccionado = JSON.parse(sessionStorage.pollSeleccionado);
	
	
	$scope.update=function (idPregunta,selectedGrupo) {		
		$scope.gruposNameArray.push({"idpregunta": idPregunta,"idGrupo": selectedGrupo[idPregunta]});
	}
	
		$scope.updateCriterio=function (idPregunta,selectedCriterio,peso,pesoEncuesta) {		
			$scope.criteriosNameArray.push({"idpregunta":idPregunta,"idCriterio": selectedCriterio[idPregunta], "peso": peso[idPregunta], "pesoEncuesta":pesoEncuesta[idPregunta]});
		}
		
		$scope.updateAnswers=function (idPregunta,selectedGrupoAnswer) {	
			$scope.answersNameArray=[];
			ConfigureService.getAllAnswersByGrupo(selectedGrupoAnswer[idPregunta])
				.then(function success(response){
					$scope.respuestas = response.data._embedded.respuestas;
					$scope.message='';
					$scope.errorMessage = '';
				},
				function error (response ){
					$scope.message='';
					$scope.errorMessage = 'Error getting answers!';
				});	
			angular.forEach($scope.respuestas, function(respuesta){
				$scope.answersNameArray.push({"idpregunta": idPregunta,"idRespuesta":respuesta.idRespuesta} );
			});
			
		}	
		
		
	$scope.savePoll= function () {		
		$scope.albumNameArray = [];
	    angular.forEach($scope.preguntas, function(pregunta){
	      if (pregunta.selidPregunta) {
	    	  $scope.albumNameArray.push(pregunta.idPregunta);
	      }
	    });
	    
	    $scope.personasNameArray = [];
	    angular.forEach($scope.users, function(usr){
	      if (usr.selidPersona) {
	    	  $scope.personasNameArray.push(usr.idPersona);
	      }
	    });
	    
	    
		if ($scope.pollSeleccionado != null ) {
			angular.forEach($scope.albumNameArray, function(value,key){				
				ConfigureService.addPreguntaEncuesta( $scope.pollSeleccionado, value)				
				.then (function success(response){
					$scope.message = 'Poll configured!';
					$scope.errorMessage = '';
				},
				function error(response){
					$scope.errorMessage = 'Error configuring poll!';
					$scope.message = '';
				});
			});
		}else {
				$scope.errorMessage = 'Please choose poll!';
				$scope.message = '';
		}
		
		
		if ($scope.pollSeleccionado != null ) {
			angular.forEach($scope.personasNameArray, function(value,key){				
				ConfigureService.addPersonaEncuesta(value, $scope.pollSeleccionado)				
				.then (function success(response){
					$scope.message = 'Poll configured!';
					$scope.errorMessage = '';
				},
				function error(response){
					$scope.errorMessage = 'Error configuring poll!';
					$scope.message = '';
				});
			});
		}else {
				$scope.errorMessage = 'Please choose poll!';
				$scope.message = '';
		}
		
		if ($scope.pollSeleccionado != null ) {
			angular.forEach($scope.gruposNameArray, function(value,key){				
				ConfigureService.addPreguntaGrupo($scope.pollSeleccionado,value.idpregunta,value.idGrupo)				
				.then (function success(response){
					$scope.message = 'Poll configured!';
					$scope.errorMessage = '';
				},
				function error(response){
					$scope.errorMessage = 'Error configuring poll!';
					$scope.message = '';
				});
			});
		}else {
				$scope.errorMessage = 'Please choose poll!';
				$scope.message = '';
		}
		
		if ($scope.pollSeleccionado != null ) {
			angular.forEach($scope.answersNameArray, function(value,key){				
				ConfigureService.addPreguntaRespuesta($scope.pollSeleccionado,value.idpregunta,value.idRespuesta)				
				.then (function success(response){
					$scope.message = 'Poll configured!';
					$scope.errorMessage = '';
				},
				function error(response){
					$scope.errorMessage = 'Error configuring poll!';
					$scope.message = '';
				});
			});
		}else {
				$scope.errorMessage = 'Please choose poll!';
				$scope.message = '';
		}
		
		if ($scope.pollSeleccionado != null ) {
			angular.forEach($scope.criteriosNameArray, function(value,key){				
				ConfigureService.addPreguntaCriterio($scope.pollSeleccionado,value.idpregunta,value.idCriterio,value.peso,value.pesoEncuesta)				
				.then (function success(response){
					$scope.message = 'Poll configured!';
					$scope.errorMessage = '';
				},
				function error(response){
					$scope.errorMessage = 'Error configuring poll!';
					$scope.message = '';
				});
			});
		}else {
				$scope.errorMessage = 'Please choose poll!';
				$scope.message = '';
		}
		
		
		
	}
	   
	
	var getAllUsers = function () {
		ConfigureService.getAllUsers()
		.then(function success(response){
			$scope.users = response.data._embedded.users;
			$scope.message='';
			$scope.errorMessage = '';
		},
		function error (response ){
			$scope.message='';
			$scope.errorMessage = 'Error getting users!';
		});
	}
	
	 var getAllQuestions = function () {
		 ConfigureService.getAllQuestions()
		.then(function success(response){
			$scope.preguntas = response.data._embedded.preguntas;
			$scope.message='';
			$scope.errorMessage = '';
		},
		function error (response ){
			$scope.message='';
			$scope.errorMessage = 'Error getting questions!';
		});
	}
	 var getAllGrupos = function () {
		 ConfigureService.getAllGrupos()
			.then(function success(response){
				$scope.grupos = response.data._embedded.groupCoherences;
				$scope.message='';
				$scope.errorMessage = '';
			},
			function error (response ){
				$scope.message='';
				$scope.errorMessage = 'Error getting grupos!';
			});
		}
		var getAllCriterios = function () {
			ConfigureService.getAllCriterios()
			.then(function success(response){
				$scope.criterios = response.data._embedded.criterios;
				$scope.message='';
				$scope.errorMessage = '';
			},
			function error (response ){
				$scope.message='';
				$scope.errorMessage = 'Error getting criterios!';
			});
		}
		var getAllAnswers = function () {
			 ConfigureService.getAllAnswers()
				.then(function success(response){
					$scope.respuestas = response.data._embedded.respuestas;
					$scope.message='';
					$scope.errorMessage = '';
				},
				function error (response ){
					$scope.message='';
					$scope.errorMessage = 'Error getting answers!';
				});
			}
		var getAllAnswersByGrupo = function () {
			 ConfigureService.getAllAnswersByGrupo()
				.then(function success(response){
					$scope.respuestas = response.data._embedded.respuestas;
					$scope.message='';
					$scope.errorMessage = '';
				},
				function error (response ){
					$scope.message='';
					$scope.errorMessage = 'Error getting answers!';
				});
			}
		var getAllGrupoAnswers = function () {
			 ConfigureService.getAllGrupoAnswers()
				.then(function success(response){
					$scope.grupoRespuestas = response.data._embedded.grupoRespuestas;
					$scope.message='';
					$scope.errorMessage = '';
				},
				function error (response ){
					$scope.message='';
					$scope.errorMessage = 'Error getting answers!';
				});
			}
	getAllUsers();
	getAllQuestions();
	getAllGrupos();
	getAllCriterios();
	getAllAnswers();
	getAllGrupoAnswers();
	
	
}]);

app.service('ConfigureService',['$http', function ($http) {
	
	this.getAllGrupoAnswers = function getAllGrupoAnswers(){
		return $http({
			method: 'GET',
			url: '/api/grupoRespuestas/search/findAllGrupoRespuesta'
		});
	}
	this.getAllAnswersByGrupo = function getAllAnswersByGrupo(grupoRespuesta){
		return $http({
			method: 'GET',
			url: '/api/respuestas/search/findRespuestaByGrupo?grupo='+grupoRespuesta
		});
	}
	this.getAllAnswersByTipo = function getAnswerByTipo(idTipo){
		return $http({
			method: 'GET',
			url: '/api/respuestas/search/findRespuestaByIdTipo?idtipo='+idTipo
		});
	}
	this.getAllAnswers = function getAllAnswers(){
		return $http({
			method: 'GET',
			url: 'api/respuestas'
		});
	}
	this.getAllUsers = function getAllUsers(){
		return $http({
			method: 'GET',
			url: 'api/users'
		});
	}
	this.getAllQuestions = function getAllQuestions(){
		return $http({
			method: 'GET',
			url: 'api/preguntas'
		});
	}
	this.getAllGrupos = function getAllGrupos(){
		return $http({
			method: 'GET',
			url: 'api/groupCoherences'
		});
	}
	this.getAllCriterios = function getAllCriterios(){
		return $http({
			method: 'GET',
			url: 'api/criterios'
		});
	}
	this.addPreguntaRespuesta = function addPreguntaGrupo(idEncuesta,idPregunta,idRespuesta){
		return $http({
			method: 'POST',
			url: 'api/preguntaRespuestas',
			data: {idPregunta: idPregunta, idEncuesta: idEncuesta, idRespuesta: idRespuesta }
		});
	}
	this.addPreguntaGrupo = function addPreguntaGrupo(idEncuesta,idPregunta,idGrupo){
		return $http({
			method: 'POST',
			url: 'api/preguntaGrupoes',
			data: {idPregunta: idPregunta, idEncuesta: idEncuesta, idGrupo: idGrupo }
		});
	}
	this.addPreguntaCriterio = function addPreguntaCriterio(idEncuesta,idPregunta,idCriterio,peso,pesoEncuesta){
		return $http({
			method: 'POST',
			url: 'api/preguntaCriterios',
			data: {idPregunta: idPregunta, idEncuesta: idEncuesta, idCriterio: idCriterio, peso: peso,pesoEncuesta: pesoEncuesta }
		});
	}
	this.addPreguntaEncuesta = function addPreguntaEncuesta(idEncuesta,idPregunta){
		return $http({
			method: 'POST',
			url: 'api/encuestaPreguntas',
			data: {idPregunta: idPregunta, idEncuesta: idEncuesta }
		});
	}
	this.addPersonaEncuesta = function addPersonaEncuesta(idEncuesta,idPersona){
		return $http({
			method: 'POST',
			url: 'api/encuestaPersonae',
			data: {idPersona: idPersona, idEncuesta: idEncuesta }
		});
	}
}]);



//Preguntas
app.controller('QuestionCtrl', ['$scope','QuestionService', function ($scope,QuestionService) {


	$scope.addQuestion = function () {
		if ($scope.pregunta != null && $scope.pregunta.descripcion) {
			QuestionService.addQuestion($scope.pregunta.descripcion, $scope.pregunta.tipoPregunta, $scope.pregunta.obligatoriedad, $scope.pregunta.valor)
			.then (function success(response){
				$scope.message = 'Question added!';
				$scope.errorMessage = '';
			},
			function error(response){
				$scope.errorMessage = 'Error adding question!';
				$scope.message = '';
			});
		}
		else {
			$scope.errorMessage = 'Please enter a name!';
			$scope.message = '';
		}
	}


	$scope.getAllQuestions = function () {
		QuestionService.getAllQuestions()
		.then(function success(response){
			$scope.preguntas = response.data.content;
			$scope.message='';
			$scope.errorMessage = '';
		},
		function error (response ){
			$scope.message='';
			$scope.errorMessage = 'Error getting questions!';
		});
	}

	
	var getAllTipoPreguntas = function () {
		QuestionService.getAllTipoPreguntas()
		.then(function success(response){
			$scope.tipoPreguntas = response.data._embedded.tipoPreguntas;
			$scope.message='';
			$scope.errorMessage = '';
		},
		function error (response ){
			$scope.message='';
			$scope.errorMessage = 'Error getting Tipos Preguntas!';
		});
	}
	getAllTipoPreguntas();
}]);

app.service('QuestionService',['$http', function ($http) {


	this.addQuestion = function addQuestion(descripcion, tipo, obligatoriedad, valor){
		return $http({
			method: 'POST',
			url: 'api/preguntas',
			data: {descripcion:descripcion, idTipoPregunta:tipo, obligatoriedad:obligatoriedad, valor:valor }
		});
	}
	
	this.getAllQuestions = function getAllQuestions(){
		return $http({
			method: 'GET',
			url: 'api/preguntas'
		});
	}
	
	this.getAllTipoPreguntas = function getAllTipoPreguntas(){
		return $http({
			method: 'GET',
			url: 'api/tipoPreguntas'
		});
	}


}]);

//Grupos
app.controller('GrupoCRUDCtrl', ['$scope','GrupoCRUDService', function ($scope,GrupoCRUDService) {

	/*$scope.updateClient = function () {
    	ClientCRUDService.updateUser($scope.user.id,$scope.user.name,$scope.user.email)
          .then(function success(response){
              $scope.message = 'User data updated!';
              $scope.errorMessage = '';
          },
          function error(response){
              $scope.errorMessage = 'Error updating user!';
              $scope.message = '';
          });
    }

    $scope.getClient = function () {
        var id = $scope.client.idCliente;
        ClientCRUDService.getClient($scope.client.idCliente)
          .then(function success(response){
              $scope.client = response.data;
              $scope.client.idCliente = id;
              $scope.message='';
              $scope.errorMessage = '';
          },
          function error (response ){
              $scope.message = '';
              if (response.status === 404){
                  $scope.errorMessage = 'Client not found!';
              }
              else {
                  $scope.errorMessage = "Error getting user!";
              }
          });
    }*/

	$scope.addGrupo = function () {
		if ($scope.grupo != null && $scope.grupo.descripcion) {
			GrupoCRUDService.addGrupo($scope.grupo.descripcion)
			.then (function success(response){
				$scope.message = 'Grupo added!';
				$scope.errorMessage = '';
			},
			function error(response){
				$scope.errorMessage = 'Error adding grupo!';
				$scope.message = '';
			});
		}
		else {
			$scope.errorMessage = 'Please enter a description!';
			$scope.message = '';
		}
	}
	/*
    $scope.deleteUser = function () {
        UserCRUDService.deleteUser($scope.user.id)
          .then (function success(response){
              $scope.message = 'User deleted!';
              $scope.user = null;
              $scope.errorMessage='';
          },
          function error(response){
              $scope.errorMessage = 'Error deleting user!';
              $scope.message='';
          })
    }*/

	$scope.getAllGrupos = function () {
		GrupoCRUDService.getAllGrupos()
		.then(function success(response){
			$scope.grupos = response.data._embedded.groupCoherences;
			$scope.message='';
			$scope.errorMessage = '';
		},
		function error (response ){
			$scope.message='';
			$scope.errorMessage = 'Error getting grupos!';
		});
	}

}]);

app.service('GrupoCRUDService',['$http', function ($http) {

	/*this.getClient = function getClient(clientId){
        return $http({
          method: 'GET',
          url: 'api/clients/'+clientId
        });
	}
	 */
	this.addGrupo = function addGrupo(descripcion){
		return $http({
			method: 'POST',
			url: 'api/groupCoherences',
			data: {descripcion:descripcion}
		});
	}
	/*
    this.deleteUser = function deleteUser(id){
        return $http({
          method: 'DELETE',
          url: 'users/'+id
        })
    }

    this.updateUser = function updateUser(id,name,email){
        return $http({
          method: 'PATCH',
          url: 'users/'+id,
          data: {name:name, email:email}
        })
    }*/

	this.getAllGrupos = function getAllGrupos(){
		return $http({
			method: 'GET',
			url: 'api/groupCoherences'
		});
	}

}]);

//Criterios
app.controller('CriterioCRUDCtrl', ['$scope','CriterioCRUDService', function ($scope,CriterioCRUDService) {

	/*$scope.updateClient = function () {
    	ClientCRUDService.updateUser($scope.user.id,$scope.user.name,$scope.user.email)
          .then(function success(response){
              $scope.message = 'User data updated!';
              $scope.errorMessage = '';
          },
          function error(response){
              $scope.errorMessage = 'Error updating user!';
              $scope.message = '';
          });
    }

    $scope.getClient = function () {
        var id = $scope.client.idCliente;
        ClientCRUDService.getClient($scope.client.idCliente)
          .then(function success(response){
              $scope.client = response.data;
              $scope.client.idCliente = id;
              $scope.message='';
              $scope.errorMessage = '';
          },
          function error (response ){
              $scope.message = '';
              if (response.status === 404){
                  $scope.errorMessage = 'Client not found!';
              }
              else {
                  $scope.errorMessage = "Error getting user!";
              }
          });
    }*/

	$scope.addCriterio = function () {
		if ($scope.criterio != null && $scope.criterio.nombreCriterio) {
			CriterioCRUDService.addCriterio($scope.criterio.nombreCriterio)
			.then (function success(response){
				$scope.message = 'Criterio added!';
				$scope.errorMessage = '';
			},
			function error(response){
				$scope.errorMessage = 'Error adding criterio!';
				$scope.message = '';
			});
		}
		else {
			$scope.errorMessage = 'Please enter a nombre!';
			$scope.message = '';
		}
	}
	/*
    $scope.deleteUser = function () {
        UserCRUDService.deleteUser($scope.user.id)
          .then (function success(response){
              $scope.message = 'User deleted!';
              $scope.user = null;
              $scope.errorMessage='';
          },
          function error(response){
              $scope.errorMessage = 'Error deleting user!';
              $scope.message='';
          })
    }*/



	$scope.getAllCriterios = function () {
		CriterioCRUDService.getAllCriterios()
		.then(function success(response){
			$scope.criterios = response.data._embedded.criterios;
			$scope.message='';
			$scope.errorMessage = '';
		},
		function error (response ){
			$scope.message='';
			$scope.errorMessage = 'Error getting criterios!';
		});
	}

}]);

app.service('CriterioCRUDService',['$http', function ($http) {

	/*this.getClient = function getClient(clientId){
        return $http({
          method: 'GET',
          url: 'api/clients/'+clientId
        });
	}
	 */
	this.addCriterio = function addCriterio(nombreCriterio){
		return $http({
			method: 'POST',
			url: 'api/criterios',
			data: {nombreCriterio:nombreCriterio}
		});
	}
	/*
    this.deleteUser = function deleteUser(id){
        return $http({
          method: 'DELETE',
          url: 'users/'+id
        })
    }

    this.updateUser = function updateUser(id,name,email){
        return $http({
          method: 'PATCH',
          url: 'users/'+id,
          data: {name:name, email:email}
        })
    }*/

	this.getAllCriterios = function getAllCriterios(){
		return $http({
			method: 'GET',
			url: 'api/criterios'
		});
	}


}]);


//Respuestas
app.controller('AnswerCRUDCtrl', ['$scope','AnswerCRUDService', function ($scope,AnswerCRUDService) {


		$scope.respuestas = [
			{}
			];

		$scope.addRespuesta = function() {
			var newRespuesta = {};
			$scope.respuestas.push(newRespuesta);
		}

		$scope.removeRespuesta = function(respuesta) {
			var index = $scope.respuestas.indexOf(respuesta);
			$scope.respuestas.splice(index,1);
		}

		$scope.columnas = [
			{}
			];

		$scope.addColumns = function() {
			var newColumna = {};
			$scope.columnas.push(newColumna);
		}

		$scope.removeColumns = function(columna) {
			var index = $scope.columnas.indexOf(columna);
			$scope.columnas.splice(index,1);
		}
		
		$scope.addAnswer = function () {
			if ($scope.respuestas != null) {			
				angular.forEach($scope.respuestas, function(value,key){				
					AnswerCRUDService.addAnswer(value.respuesta, value.valor, $scope.respuesta.grupoRespuesta, $scope.respuesta.idTipoRespuesta)
					.then (function success(response){
						$scope.message = 'Answer added!';
						$scope.errorMessage = '';
					},
					function error(response){
						$scope.errorMessage = 'Error adding answer!';
						$scope.message = '';
					});
					
				});
				
			}
			else {
				$scope.errorMessage = 'Please enter an answer!';
				$scope.message = '';
			}
		}
		
		var getAllTipoPreguntas = function () {
			AnswerCRUDService.getAllTipoPreguntas()
			.then(function success(response){
				$scope.tipoPreguntas = response.data._embedded.tipoPreguntas;
				$scope.message='';
				$scope.errorMessage = '';
			},
			function error (response ){
				$scope.message='';
				$scope.errorMessage = 'Error getting Tipos Respuesta!';
			});
		}
		getAllTipoPreguntas();
	}]);

	

app.service('AnswerCRUDService',['$http', function ($http) {

		
		this.addAnswer = function addAnswer(respuesta, valor, grupoRespuesta,idTipoRespuesta){
			return $http({
				method: 'POST',
				url: 'api/respuestas',
				data: {respuesta:respuesta, valor:valor, grupoRespuesta:grupoRespuesta, idTipoRespuesta:idTipoRespuesta}
			});
		}
		this.getLastAnswer = function getLastAnswer(){
			return $http({
				method: 'GET',
				url: '/api/respuestas/search/findLastId'
			});
		}
		
		this.getAllTipoPreguntas = function getAllTipoPreguntas(){
			return $http({
				method: 'GET',
				url: 'api/tipoPreguntas'
			});
		}


	}]);

