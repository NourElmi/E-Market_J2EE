<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Client</title>

    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400&display=swap" rel="stylesheet">

    

<%@ include file="../Admin/adminSidebar.jsp" %>	


  <div class="content">
    
    <div class="container">
      <h2 class="mb-5">Liste de tous les clients </h2>
      

      <div class="table-responsive custom-table-responsive">

        <table class="table custom-table">
          <thead>
         <tr>
          <button type="button" class="btn btn-outline-info">
          	<a href="<%= request.getContextPath() %>/Admin/clientAdd.jsp" target="_blank">Ajouter Client</a>
          </button>
          </tr>
            <tr>  
            	<th scope="col">Nom</th>
            	<th scope="col">Prenom</th>
            	<th scope="col">login</th>
            	<th scope="col">numTel</th>
            	<th scope="col">adresse</th>
            	<th scope="col">genre</th>
            	<th scope="col">dateNaiss</th>
              	
               	<th scope="col">Modif</th>
                <th scope="col">Supp</th>
            </tr>
          </thead>
          <tbody>
<c:forEach items="${ listallClient }" var="client" varStatus="boucle">
            <tr >                             
             
              <td>${ client.getNomClient() }</td>  
              <td>${ client.getPrenomClient() }</td> 
              <td>${ client.getLogin() }</td> 
              <td>${ client.getNumTel() }</td> 
              <td>${ client.getAdresse() }</td> 
              <td>${ client.getGenre() }</td> 
              <td>${ client.getDateNaissance() }</td> 
          
              <td><a href="clientFind?idClient=${client.getIdClient()}">Modif</a></td>
   			  <td><a href="clientSupp?idclient=${client.getIdClient()}">Supp</a></td>
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