<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<title>Produit Vente</title>


<%@ include file="../Association/associationSidebar.jsp" %>

<div class="col-lg-9 col-md-9">
 <button type="button" style=" margin-left:70%" class="btn btn-outline-info">
          	<a href="./ProdADonner/addProdADonner.jsp" >Ajouter Produit</a>
          </button> <br/>
                    <div class="row justify-content-center ">
                    
<c:forEach items="${ listProduitVente }" var="ProduitVente" varStatus="boucle">
                        <div class="col-lg-4 col-md-6">
                            <div class="product__item">
                                <div class="product__item__pic set-bg" ><img src="<%= request.getContextPath() %>/ressources/images/${ProduitVente.getImage()}">
                                    <div class="label new">New</div>
                                    <ul class="product__hover">
                                        <li><a href="img/shop/shop-1.jpg" class="image-popup"><span class="arrow_expand"></span></a></li>
                                        <li><a href="#"><span class="icon_heart_alt"></span></a></li>
                                        <li><a href="#"><span class="icon_bag_alt"></span></a></li>
                                    </ul>
                                </div>
                                <div class="product__item__text">
                                    <h6><a href="#">${ ProduitVente.getLib_Prod() }</a></h6>
                                    <div class="rating">
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                    </div>
                                    <div class="product__price">${ ProduitVente.getPrix() } DH</div>
                                </div>
                            </div>
                        </div>
</c:forEach>   


</body>
</html>