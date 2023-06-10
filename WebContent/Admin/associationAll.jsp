<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Beneficiaire de l'association</title>

    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400&display=swap" rel="stylesheet">

    

<%@ include file="../Association/associationSidebar.jsp" %>	


  <div class="content">
    
    <div class="container">
      <h2 class="mb-5">Les associations engage </h2>
      
		<button type="button" class="btn btn-outline-info" style="margin-left:70%">
          	<a href="<%= request.getContextPath() %>/Association/beneficiaireAdd.jsp" target="_blank">Ajouter un beneficiaire</a>
         </button> 
      <div class="table-responsive custom-table-responsive"><br/>

        <table class="table custom-table">
          <thead>
         <tr>
          
          </tr>
         
            <tr>  
            	<th scope="col">nomAsso</th>
            	<th scope="col">nomRespo</th>
	       		<th scope="col">numTel</th>
              	<th scope="col">secteur</th>
              	
               	<th scope="col">Modifier</th>
                <th scope="col">Supprimer</th>
            </tr>
          </thead>
          <tbody>
<c:forEach items="${ listAllAssociation }" var="Association" varStatus="boucle">
            <tr >                             
             
              <td>${ Association.getNomAsso() }</td>  
               <td>${ Association.getNomRespo() }</td>       
              <td>${ Association.getTelephoneAsso() }</td>
              
              <td>${ Association.getSecteur() }</td>
              <td><a href="beneficiaireFind?idBeneficiaire=${Association.getIdBeneficiaire()}">Modifier</a></td>
   			  <td><a href="beneficiaireSupp?idBeneficiaire=${Association.getIdBeneficiaire()}">Supprimer</a></td>
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