<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Categories</title>

    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400&display=swap" rel="stylesheet">

    

<%@ include file="../Admin/adminSidebar.jsp" %>	


  <div class="content">
    
    <div class="container">
      <h2 class="mb-5">Liste de tous les catégories </h2>
      

      <div class="table-responsive custom-table-responsive">

        <table class="table custom-table">
          <thead>
         <tr>
          <button type="button" class="btn btn-outline-info">
          	<a href="<%= request.getContextPath() %>/Admin/categorieAdd.jsp" target="_blank">Ajouter Categorie</a>
          </button>
          </tr>
            <tr>  
            	<th scope="col">Categorie</th>
              	
               	<th scope="col">Modifier</th>
                <th scope="col">Supprimer</th>
            </tr>
          </thead>
          <tbody>
<c:forEach items="${ listallCategorie }" var="categorie" varStatus="boucle">
            <tr >                             
             
              <td>${ categorie.getLib_Categorie() }</td>  
          
              <td><a href="categorieFind?idCategorie=${categorie.getIdCategorie()}">Modifier</a></td>
   			  <td><a href="categorieSupp?idCategorie=${categorie.getIdCategorie()}">Supprimer</a></td>
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