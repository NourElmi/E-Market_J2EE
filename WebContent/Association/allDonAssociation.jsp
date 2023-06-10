<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Faire Don</title>

    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400&display=swap" rel="stylesheet">

    

<%@ include file="../Association/associationSidebar.jsp" %>	


  <div class="content">
    
    <div class="container">
      <h2 class="mb-5">Liste de tous les Produits reçus</h2>
      

      <div class="table-responsive custom-table-responsive">

        <table class="table custom-table">
          <thead>
          <tr>
          
          </tr>
            <tr>  
            	<th scope="col">typeDon</th>
              	<th scope="col">nbrProd</th>
	       		<th scope="col">categories</th>
              	<th scope="col">description</th>
              	<th scope="col">dateDon</th>
               	<!-- <th scope="col">Modifier</th>
                <th scope="col">Supprimer</th> -->
            </tr>
          </thead>
          <tbody>
<c:forEach items="${ listallDonAssociation }" var="don" varStatus="boucle">
            <tr >                             
             
              <td>${ don.getTypeDon() }</td>  
               <td>${ don.getNbrProd() }</td>       
              <td>${ don.getCategories() }</td>
              
              <td>${ don.getDescription() }</td>
              <td>${ don.getDateDon() }</td>
              <%-- <td><a href="donFind?idDon=${don.getIdDon()}">Modifier</a></td>
   			  <td><a href="donSupp?idDon=${don.getIdDon()}">Supprimer</a></td> --%>
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