<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zxx">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="Ashion Template">
    <meta name="keywords" content="Ashion, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Details Produit</title>

   

  	 <%@ include file="../homeParts/HeaderClient.jsp" %>

    <!-- Breadcrumb Begin -->
    <div class="breadcrumb-option">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="breadcrumb__links">
                        <a href="./index.html"><i class="fa fa-home"></i> Home</a>
                        <a href="#">Women’s </a>
                        <span>${ProduitVente.getLib_Prod()}</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Breadcrumb End -->
    
    
  
    <!-- Product Details Section Begin -->
    <section class="product-details spad">
        <div class="container">
            <div class="row">
             
                <div class="col-lg-6">
                    <div class="product__details__pic">
                        <div class="product__details__pic__left product__thumb nice-scroll">
                       
                            <a class="pt " href="#product-1"> 
                            	<img src="<%= request.getContextPath() %>/ressources/images/${ProduitVente.getImage()}" alt="">                               
                            </a>
                     
                            <%-- <a class="pt" href="#product-2">
                                <img src="<%= request.getContextPath() %>/ressources/images/${ProduitVenteByRef.getImage()}" alt="">  
                            </a>
                            <a class="pt" href="#product-3">
                                <img src="<%= request.getContextPath() %>/ressources/images/${ProduitVente.getImage()}" alt="">
                            </a>
                            <a class="pt" href="#product-4">
                                <img src="<%= request.getContextPath() %>/ressources/images/${ProduitVente.getImage()}" alt="">
                            </a> --%>
                        </div>
                        <div class="product__details__slider__content">
                            <div class="product__details__pic__slider owl-carousel">
                                <img data-hash="product-1" class="product__big__img" src="<%= request.getContextPath() %>/ressources/images/${ProduitVenteByRef.getImage()}" alt="">
                               <%--  <img data-hash="product-2" class="product__big__img" src="<%= request.getContextPath() %>/ressources/images/${ProduitVente.getImage()}" alt="">
                                <img data-hash="product-3" class="product__big__img" src="<%= request.getContextPath() %>/ressources/images/${ProduitVente.getImage()}" alt="">
                                <img data-hash="product-4" class="product__big__img" src="<%= request.getContextPath() %>/ressources/images/${ProduitVente.getImage()}" alt=""> --%>
                         
                            </div>
                        </div>
                    </div>
                </div>
                 
                <div class="col-lg-6">
                    <div class="product__details__text">
                        <h3>${ProduitVente.getLib_Prod()} <span>Association:  ${ProduitVente.getIdAsso_ProdVente()}</span></h3>
                        <div class="rating">
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                            <span>( 138 reviews )</span>
                        </div>
                        <div class="product__details__price">${ProduitVente.getPrix()} <span>400</span></div>
                        <p>${ProduitVente.getDescProd()}</p>
                        <div class="product__details__button">
                            <div class="quantity">
                                <span>Quantité:</span>
                                <div class="pro-qty">
                                    <input type="text" name="quantite" value="1">
                                </div>
                            </div>
                            <a href="#" class="cart-btn"><span class="icon_bag_alt"></span> Ajouter au panier</a>
                            <ul>
                                <li><a href="#"><span class="icon_heart_alt"></span></a></li>
                                <li><a href="#"><span class="icon_adjust-horiz"></span></a></li>
                            </ul>
                        </div>
                        <div class="product__details__widget">
                            <ul>
                                <li>
                                    <span>Disponibilité:</span>
                                    <div class="stock__checkbox">
                                        <label for="stockin">
                                            In Stock
                                            <input type="checkbox" name="dispo"id="stockin">
                                            <span class="checkmark"></span>
                                        </label>
                                    </div>
                                </li>
                                <li>
                                    <span>Couleurs disponible:</span>
                                    <div class="color__checkbox">
                                    	<c:forEach items="${ listProduitVenteByRef }" var="ProduitVenteByRef" varStatus="boucle">
                                        ${ProduitVenteByRef.getCouleur()}
                                        </c:forEach>
                                        <!-- <label for="red">
                                            <input type="radio" name="color__radio" id="red" checked>
                                            <span class="checkmark"></span>
                                        </label>
                                        <label for="black">
                                            <input type="radio" name="color__radio" id="black">
                                            <span class="checkmark black-bg"></span>
                                        </label>
                                        <label for="grey">
                                            <input type="radio" name="color__radio" id="grey">
                                            <span class="checkmark grey-bg"></span>
                                        </label> -->
                                    </div>
                                </li>
                                <li>
                                    <span>Tailles disponible:</span>
                                    <div class="size__btn">
                                    	<c:forEach items="${listProduitVenteByRef }" var="ProduitVenteByRef" varStatus="boucle">
                                        ${ProduitVenteByRef.getTaille()}
                                        </c:forEach>
                                        <!-- <label for="xs-btn" class="active">
                                            <input type="radio" id="xs-btn">
                                            xs
                                        </label>
                                        <label for="s-btn">
                                            <input type="radio" id="s-btn">
                                            s
                                        </label>
                                        <label for="m-btn">
                                            <input type="radio" id="m-btn">
                                            m
                                        </label>
                                        <label for="l-btn">
                                            <input type="radio" id="l-btn">
                                            l
                                        </label> -->
                                    </div>
                                </li>
                                <li>
                                    <span>Promotions:</span>
                                    <p>Free shipping</p>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
                </div>
                </div>
                </section>
    <!-- Instagram End -->

    <!-- Footer Section Begin -->
    <footer class="footer">
        <div class="container">
            <div class="row">
                <div class="col-lg-4 col-md-6 col-sm-7">
                    <div class="footer__about">
                        <div class="footer__logo">
                         
                            <a href="<%= request.getContextPath() %>/Client/index.jsp"> <h2>  AssoMarket</h2>  </a>
                        </div>
                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt
                        cilisis.</p>
                        <div class="footer__payment">
                            <a href="#"><img src="<%= request.getContextPath() %>/frontend/img/payment/payment-1.png" alt=""></a>
                            <a href="#"><img src="<%= request.getContextPath() %>/frontend/img/payment/payment-2.png" alt=""></a>
                            <a href="#"><img src="<%= request.getContextPath() %>/frontend/img/payment/payment-3.png" alt=""></a>
                            <a href="#"><img src="<%= request.getContextPath() %>/frontend/img/payment/payment-4.png" alt=""></a>
                            <a href="#"><img src="<%= request.getContextPath() %>/frontend/img/payment/payment-5.png" alt=""></a>
                        </div>
                    </div>
                </div>
                <div class="col-lg-2 col-md-3 col-sm-5">
                    <div class="footer__widget">
                        <h6>Quick links</h6>
                        <ul>
                            <li><a href="#">About</a></li>
                            <li><a href="#">Blogs</a></li>
                            <li><a href="#">Contact</a></li>
                            <li><a href="#">FAQ</a></li>
                        </ul>
                    </div>
                </div>
                <div class="col-lg-2 col-md-3 col-sm-4">
                    <div class="footer__widget">
                        <h6>Account</h6>
                        <ul>
                            <li><a href="#">My Account</a></li>
                            <li><a href="#">Orders Tracking</a></li>
                            <li><a href="#">Checkout</a></li>
                            <li><a href="#">Wishlist</a></li>
                        </ul>
                    </div>
                </div>
                <div class="col-lg-4 col-md-8 col-sm-8">
                    <div class="footer__newslatter">
                        <h6>NEWSLETTER</h6>
                        <form action="#">
                            <input type="text" placeholder="Email">
                            <button type="submit" class="site-btn">Subscribe</button>
                        </form>
                        <div class="footer__social">
                            <a href="#"><i class="fa fa-facebook"></i></a>
                            <a href="#"><i class="fa fa-twitter"></i></a>
                            <a href="#"><i class="fa fa-youtube-play"></i></a>
                            <a href="#"><i class="fa fa-instagram"></i></a>
                            <a href="#"><i class="fa fa-pinterest"></i></a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                    <div class="footer__copyright__text">
                        <p>Copyright &copy; <script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a></p>
                    </div>
                    <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                </div>
            </div>
        </div>
    </footer>
    <!-- Footer Section End -->

    <!-- Search Begin -->
    <div class="search-model">
        <div class="h-100 d-flex align-items-center justify-content-center">
            <div class="search-close-switch">+</div>
            <form class="search-model-form">
                <input type="text" id="search-input" placeholder="Search here.....">
            </form>
        </div>
    </div>
    <!-- Search End -->

    <!-- Js Plugins -->
    <script src="<%= request.getContextPath() %>/frontend/js/jquery-3.3.1.min.js"></script>
    <script src="<%= request.getContextPath() %>/frontend/js/bootstrap.min.js"></script>
    <script src="<%= request.getContextPath() %>/frontend/js/jquery.magnific-popup.min.js"></script>
    <script src="<%= request.getContextPath() %>/frontend/js/jquery-ui.min.js"></script>
    <script src="<%= request.getContextPath() %>/frontend/js/mixitup.min.js"></script>
    <script src="<%= request.getContextPath() %>/frontend/js/jquery.countdown.min.js"></script>
    <script src="<%= request.getContextPath() %>/frontend/js/jquery.slicknav.js"></script>
    <script src="<%= request.getContextPath() %>/frontend/js/owl.carousel.min.js"></script>
    <script src="<%= request.getContextPath() %>/frontend/js/jquery.nicescroll.min.js"></script>
    <script src="<%= request.getContextPath() %>/frontend/js/main.js"></script>
</body>

</html>