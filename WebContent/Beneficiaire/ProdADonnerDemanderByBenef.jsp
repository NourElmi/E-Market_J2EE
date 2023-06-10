<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

    

<title>ProdADonner</title>


<%@ include file="../Beneficiaire/beneficiaireSidebar.jsp" %>



<div class="col-lg-9 col-md-9">

        
                    <div class="row justify-content-center ">

<c:forEach var="i" begin="0" end="${listallProdADonner_EtatDemande.size() -1}" step="2">
                    

                        <div class="col-lg-4 col-md-6">
                            <div class="product__item">
                                <div class="product__item__pic set-bg" ><img src="<%= request.getContextPath() %>/ressources/images/${listallProdADonner_EtatDemande.get(i).getImage()}">
                                    <c:choose>
                                    
										 <c:when test="${ listallProdADonner_EtatDemande.get(i+1).getEtatDemande() == 1}">
											 <div class="label new" style=" background-color: orange">  Demande En Attente </div>
									     </c:when> 
									     <c:when test="${ listallProdADonner_EtatDemande.get(i+1).getEtatDemande() == 2}">
											 <div class="label new" style=" background-color: vert">  Vient recuperer </div>
									     </c:when> 
									     <c:when test="${ listallProdADonner_EtatDemande.get(i+1).getEtatDemande() == 3}">
											 <div class="label new" style=" background-color: red">  deja donner </div>
									     </c:when> 
									     <c:otherwise>
										    <div class="label new" style=" background-color: gris">
										     	ouups
										   </div>
										 </c:otherwise>
									    
									</c:choose>		
                                    <ul class="product__hover">
                                        <li><a href="img/shop/shop-1.jpg" class="image-popup"><span class="arrow_expand"></span></a></li>
                                        <%-- <li><a href="/AssociationMarket/findProdADonner?idProduit=${listallProdADonner_EtatDemande.get(i).getIdProduit()}"><span class="icon_heart_alt"></span></a></li>
                                        <li><a href="/AssociationMarket/demandeByAsso?idProd_Demande=${listallProdADonner_EtatDemande.get(i).getIdProduit()}"><span class="icon_list_alt" style=" color: black"></span></a></li>
                                    --%> </ul>
                                </div>
                                <div class="product__item__text">
                                    <h6><a href="#">${ listallProdADonner_EtatDemande.get(i).getLib_Prod() }</a></h6>
                                    <div class="rating">
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                    </div>
                                    <div class="product__price">${ listallProdADonner_EtatDemande.get(i).getDescProd() }</div>
                                </div>
                            </div>
                        </div>
</c:forEach>   



</body>
</html>