<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    
<!DOCTYPE html>
<html>
<head>
    <meta name="description" content="Ashion Template">
    <meta name="keywords" content="Ashion, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
<meta charset="UTF-8">
<title>validerCommande</title>
<%@ include file="../Client/sidebarClient.jsp" %>

       <div class="col-lg-9 col-md-9">       
             <form  action="/AssociationMarket/acheterValiderCommander" method="POST" class="checkout__form">
				<div class="checkout__order">
                                <h5>Valider votre commande</h5>
                                <div class="checkout__order__total">
                                    <ul>
                                         <li>Total Commande <span>
                                         <input type="text " name="montantCommande" value="${montantCommande}" placeholder="ajouter plus de details"
  												style="left: 100%;height:50%;text-align: center">
                                          </span></li>
                                    </ul>
                                </div>
                                 <div class="checkout__order__total">
                                    <ul>
                                         <li>mode de Paiement<span> 
  											<select name="modePaiement" class="size__btn" >                                   	
										  		<option value="a la livraison">a la livraison</option>
										  		<option value="en ligne">en ligne</option>                                     
                                     		</select>
 										 </span>
 										</li>
                                    </ul>
                                </div>
                                 <div class="checkout__order__total">
                                    <ul>                                      
                                           <li>information de plus<span> 
  												<input type="text " name="commantaire" placeholder="ajouter plus de details"
  												style="height: 50%; float:center">
 											</span></li>
                                    </ul>
                                </div>
                                 <div class="checkout__order__total">
                                    <ul>
                                        <li>Date de commande <span> 
  												<fmt:formatDate var="fmtDate" value="<%=new java.util.Date()%>" pattern="yyyy/MM/dd HH:mm:ss"/> 
						<input type="text" name="dateCommande" value="${fmtDate}" placeholder="${fmtDate}" readonly class="form-control">
 											</span></li>
                                    </ul>
                                </div>
                                <button type="submit" class="site-btn">Valider Commande</button>
                         </div>
                      </form>
                    </div>
            </body>
	</html>