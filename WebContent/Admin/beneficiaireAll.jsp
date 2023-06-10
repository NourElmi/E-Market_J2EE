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

    

<%@ include file="../Admin/adminSidebar.jsp" %>	


  <div class="content">
    
    <div class="container">
      <h2 class="mb-5">Tous les beneficiaires </h2>
      
		<button type="button" class="btn btn-outline-info" style="margin-left:70%">
          	<a href="<%= request.getContextPath() %>/Association/beneficiaireAdd.jsp" target="_blank">Ajouter un beneficiaire</a>
         </button> 
      <div class="table-responsive custom-table-responsive"><br/>

        <table class="table custom-table">
          <thead>
         <tr>
          
          </tr>
         
            <tr>  
            	<th scope="col">nom</th>
              	<th scope="col">prenom</th>
	       		<th scope="col">numTel</th>
              	<th scope="col">adresse</th>
              	<th scope="col">dateNaise</th>
               	<th scope="col">Modifier</th>
                <th scope="col">Supprimer</th>
            </tr>
          </thead>
          <tbody>
<c:forEach items="${ listallBeneficiaireAsso }" var="beneficiaire" varStatus="boucle">
            <tr >                             
             
              <td>${ beneficiaire.getNomBenefi() }</td>  
               <td>${ beneficiaire.getPrenomBenefi() }</td>       
              <td>${ beneficiaire.getNumTel() }</td>
              
              <td>${ beneficiaire.getAdresse() }</td>
              <td>${ beneficiaire.getDateNaissance() }</td>
              <td><a href="beneficiaireFind?idBeneficiaire=${beneficiaire.getIdBeneficiaire()}">Modifier</a></td>
   			  <td><a href="beneficiaireSupp?idBeneficiaire=${beneficiaire.getIdBeneficiaire()}">Supprimer</a></td>
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