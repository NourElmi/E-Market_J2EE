<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
    <meta name="description" content="Ashion Template">
    <meta name="keywords" content="Ashion, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
<meta charset="UTF-8">
<title>Insert title here</title>



<%@ include file="../Client/sidebarClient.jsp" %>
       <div class="col-lg-9 col-md-9">       
          <h4>Tous mes Commandes </h4><br> <br>
	<c:forEach items="${ listCommandeValidee }" var="commandeValidee" varStatus="boucle">    
				<div class="checkout__order">
                                <h5>Commande </h5>
                                <div class="checkout__order__total">
                                    <ul>
                                         <li>Total Commande <span>
                                         ${commandeValidee.getMontantCommande()}							
                                          </span></li>
                                    </ul>
                                </div>
                                 <div class="checkout__order__total">
                                    <ul>
                                         <li>mode de Paiement<span> 
  											${commandeValidee.getModePaiement()}
 										 </span>
 										</li>
                                    </ul>
                                </div>
                                 <div class="checkout__order__total">
                                    <ul>
                                         <li>infos de plus<span> 
  											${commandeValidee.getCommantaire()}
 										 </span>
 										</li>
                                    </ul>
                                </div>
                                

                                 <div class="checkout__order__total">
                                    <ul>
                                        <li>Date de commande <span> 
  											${ commandeValidee.getDateCommande()}
  											</span></li>
                                    </ul>
                                </div>
                       </div><br>
                       
    </c:forEach>
                   
</div>
  
             
</body>
</html>