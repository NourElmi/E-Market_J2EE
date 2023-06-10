<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

    

<title>ProdADonner</title>


<%@ include file="../Beneficiaire/beneficiaireSidebar.jsp" %>

<div class="col-lg-9 col-md-9">
                    <div class="row justify-content-center ">
                    
<c:forEach items="${ listProdADonner }" var="ProdADonner" varStatus="boucle">
                        <div class="col-lg-4 col-md-6">
                            <div class="product__item">
                                <div class="product__item__pic set-bg" ><img src="<%= request.getContextPath() %>/ressources/images/${ProdADonner.getImage()}">
                                    <div class="label new">Bon Etat</div>
                                    <ul class="product__hover">
                                        <li><a href="img/shop/shop-1.jpg" class="image-popup"><span class="arrow_expand"></span></a></li>
                                        <li><a href="#"><span class="icon_heart_alt"></span></a></li>
                                         <form action="demandeAdd" method="POST"> 
                            <!--             <li><a href="/AssociationMarket/demandeAdd?idProd_Demande=${ProdADonner.getIdProduit()}"><span class="icon_bag_alt"></span></a></li> -->
                                         <fmt:formatDate var="fmtDate" value="<%=new java.util.Date()%>" pattern="yyyy/MM/dd HH:mm:ss"/> 
						              <input type="text" name="dateDemande" value="${fmtDate}"  hidden class="form-control">
						              <input type="text" name="idProd_Demande" value="${ProdADonner.getIdProduit()}"  hidden class="form-control">
						              
                                        <li>  <a> <button type="submit" class="cart-btn"><span class="icon_bag_alt"></span> </button></a></li>
                                        
<!-- <a href="/AssociationMarket/demandeAdd?idProd_Demande=${ProdADonner.getIdProduit()}"> -->
                                         </form>
                                    </ul>
                                </div>
                                <div class="product__item__text">
                                    <h6><a href="#">${ ProdADonner.getLib_Prod() }</a></h6>
                                    <div class="rating">
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                    </div>
                                    <div class="product__price">${ ProdADonner.getDescProd() }</div>
                                </div>
                            </div>
                        </div>
</c:forEach>   



</body>
</html>