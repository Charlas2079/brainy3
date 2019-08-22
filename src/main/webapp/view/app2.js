angular.module('app2', ['ngTouch', 'ui.grid'])
  .controller('MainCtrl', MainCtrl);

 
function MainCtrl() {
	  this.myData = [
	    {
	        firstName: "Cox",
	        lastName: "Carney",
	        company: "Enormo",
	        employed: true
	    },
	    {
	        firstName: "Lorraine",
	        lastName: "Wise",
	        company: "Comveyer",
	        employed: false
	    },
	    {
	        firstName: "Nancy",
	        lastName: "Waters",
	        company: "Fuelton",
	        employed: false
	    }
	  ];
	}

angular.module('app2',[]).controller('ClientCRUDCtrl', ['$scope','ClientCRUDService', function ($scope,ClientCRUDService) {
	  
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
    }*/
    
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
    }
    /*
    $scope.addUser = function () {
        if ($scope.user != null && $scope.user.name) {
            UserCRUDService.addUser($scope.user.name, $scope.user.email)
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
    
    $scope.getAllClients = function () {
    	ClientCRUDService.getAllClients()
          .then(function success(response){     	 
              $scope.clients = response.data._embedded.clients;
              $scope.message='';
              $scope.errorMessage = '';    
          },
          function error (response ){
              $scope.message='';
              $scope.errorMessage = 'Error getting clients!';
          });
    }
   
}]);

angular.module('app2',[]).service('ClientCRUDService',['$http', function ($http) {
	
    this.getClient = function getClient(clientId){
        return $http({
          method: 'GET',
          url: 'api/clients/'+clientId
        });
	}
	
    /*this.addUser = function addUser(name, email){
        return $http({
          method: 'POST',
          url: 'users',
          data: {name:name, email:email}
        });
    }
	
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
	
    this.getAllClients = function getAllClients(){
        return $http({
          method: 'GET',
          url: 'api/clients'
        });
    }

}]);