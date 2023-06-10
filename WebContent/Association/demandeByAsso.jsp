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
<c:choose>
  <c:when test="${listallDemandeByAsso_Prod_Benef.size() >=1 }">
      <h3 class="mb-5">Liste des demandes du produit: <br>
      <img  src="<%= request.getContextPath() %>/ressources/images/${ listallDemandeByAsso_Prod_Benef.get(0).getImage() } "  width="100" height="110">
         ${ listallDemandeByAsso_Prod_Benef.get(0).getLib_Prod() }
      </h3>

      <div class="table-responsive custom-table-responsive">

        <table class="table custom-table">
          <thead>
          <tr>

          </tr>
            <tr>  
            	<th scope="col">NomBenef</th>
              	<th scope="col">Prenom</th>
	       	    <th scope="col">Adresse</th>
               	<th scope="col">NumTele</th>
               	<th scope="col">DateDemande</th>
               	<th scope="col">Contacter</th>
               	<th scope="col">Donner</th>
            </tr>
          </thead>
          <tbody>

<c:forEach var="i" begin="1" end="${listallDemandeByAsso_Prod_Benef.size() -1}" step="2">

            <tr >                             
             
              <td>${ listallDemandeByAsso_Prod_Benef.get(i+1).getNomBenefi() }</td>  
               <td>${ listallDemandeByAsso_Prod_Benef.get(i+1).getPrenomBenefi() }</td>       
               <td>${ listallDemandeByAsso_Prod_Benef.get(i+1).getAdresse() }</td>  
                <td>${ listallDemandeByAsso_Prod_Benef.get(i+1).getNumTel() }</td>  
                <td>${ listallDemandeByAsso_Prod_Benef.get(i).getDateDemande() }</td>  
              <td><a href="#">Contacter</a></td>
   			  <td><a href="/AssociationMarket/accepterDemanderByAsso?idDemande=${listallDemandeByAsso_Prod_Benef.get(i).getIdDemande()}">Donner</a></td>
            </tr>
</c:forEach> 
            
          </tbody>
        </table>
      </div>
       
  </c:when> 
  <c:otherwise>
 
 <h1 style="margin-left: auto; margin-right: auto; margin-top: 30%}"> prod non demande</h1>
  </c:otherwise>
</c:choose>
      

    </div>

  </div>
    
    

    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/main.js"></script>
    
</body>
</html>