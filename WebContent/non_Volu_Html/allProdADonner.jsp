<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="allClientTable/fonts/icomoon/style.css">

    <link rel="stylesheet" href="allClientTable/css/owl.carousel.min.css">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="allClientTable/css/bootstrap.min.css">
    
    <!-- Style -->
    <link rel="stylesheet" href="allClientTable/css/style.css">

    <title>Abonnes </title>
  </head>
  <body>
  

  <div class="content">
    
    <div class="container">
      <h2 class="mb-5">Liste de tous les Produits a Donner</h2>
      

      <div class="table-responsive custom-table-responsive">

        <table class="table custom-table">
          <thead>
          <tr>
          <button type="button" class="btn btn-outline-info">
            <a href="addProdADonner.jsp" >Ajouter Produit a Donner</a>          
        <!--  	<a href="/AssociationMarket/addProdADonner.jsp" target="_blank">Ajouter Produit a Donner</a>  --> 
          </button>
          </tr>
            <tr>  
            	<th scope="col">image</th>
              	<th scope="col">img</th>
	       		<th scope="col">lib_Prod</th>
              	<th scope="col">descProd</th>
               	<th scope="col">Modifier</th>
                <th scope="col">Supprimer</th>
            </tr>
          </thead>
          <tbody>
<c:forEach items="${ listProdADonner }" var="ProdADonner" varStatus="boucle">
            <tr >                             
              <td><img src="ressources/images/${ProdADonner.getImage()}" height="70" width="90"/></td> 
              <td>${ ProdADonner.getImage() }</td>         
              <td>${ ProdADonner.getLib_Prod() }</td>
              <td>${ ProdADonner.getDescProd() }</td>
              <td>${ ProdADonner.getDateAjout() }</td>
              <td><a href="findProdADonner?idProduit=${ProdADonner.getIdProduit()}">Modifier</a></td>
   			  <td><a href="suppProdADonner?idProduit=${ProdADonner.getIdProduit()}">Supprimer</a></td>
            </tr>
</c:forEach>   
            
          </tbody>
        </table>
      </div>


    </div>

  </div>
    
    

    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/main.js"></script>
  </body>
</html>