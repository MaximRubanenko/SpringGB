angular.module('market-front', []).controller('appController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/market/';

     $scope.loadProducts = function (){
         $http.get(contextPath + 'products')
             .then(function (response) {
                 console.log(response);
                 $scope.products = response.data;
             });
     }

    $scope.delItem= function (id) {
        alert(id);
        $http.get(contextPath + 'products_del/'+id)
        .then(function(response){
         $scope.loadProducts();
        });

   }
    $scope.loadProducts();

});
