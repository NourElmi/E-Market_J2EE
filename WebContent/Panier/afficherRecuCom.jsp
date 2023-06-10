<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
    <meta name="description" content="Ashion Template">
    <meta name="keywords" content="Ashion, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
<meta charset="UTF-8">
<title>recu</title>



<%@ include file="../Client/sidebarClient.jsp" %> 

       <div class="col-lg-9 col-md-9">    
      <h3> Voici Votre Recu, Merci pour votre commande</h3><br><br>
				<div class="checkout__order">
                                <h5> Recu </h5>
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
                                           <li>information de plus<span> 
  												${commandeValidee.getCommantaire()}
 											</span></li>
                                    </ul>
                                </div> 
                                 <div class="checkout__order__total">
                                    <ul>
                                        <li>Date de commande <span> 
  											${ commandeValidee.getDateCommande()}
  											</span></li>
                                    </ul>
                 				</div>
                 </div>
            </div>
    
</body>
</html>