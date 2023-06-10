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
    <title>Panier</title>

        <c:choose>
  <c:when test="${listallLigneCommande_ProdVente_Total.size() >=2 }">

<%@ include file="/homeParts/HeaderClient.jsp" %>	
    <!-- Breadcrumb Begin -->
    <div class="breadcrumb-option">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="breadcrumb__links">
                        <a href="./index.html"><i class="fa fa-home"></i> Home</a>
                        <span>Panier</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Breadcrumb End -->

    <!-- Shop Cart Section Begin -->
 
    <section class="shop-cart spad">
        <div class="container">
            <div class="row">
       
                <div class="col-lg-12">
                    <div class="shop__cart__table">

           
                        <table>
                            <thead>
                                <tr>
                                    <th>Produit</th>
                                    <th>Prix</th>
                                    <th>Taille</th> 
                                    <th>Couleur</th>
                                    <th>Quantite</th>
                                  <!--   <th></th> -->
                                </tr>
                            </thead>
                            <tbody>

<c:forEach var="i" begin="0" end="${listallLigneCommande_ProdVente_Total.size() -2}" step="2">
                           
                                <tr>
                                    <td class="cart__product__item">
                                        <img src="<%= request.getContextPath() %>/ressources/images/${listallLigneCommande_ProdVente_Total.get(i+1).getImage()}"  
                                        width="100" height="110" alt="">
                                        <div class="cart__product__item__title">
                                            <h6>${listallLigneCommande_ProdVente_Total.get(i+1).getLib_Prod()}</h6>
                                            <div class="rating">
                                                <i class="fa fa-star"></i>
                                                <i class="fa fa-star"></i>
                                                <i class="fa fa-star"></i>
                                                <i class="fa fa-star"></i>
                                                <i class="fa fa-star"></i>
                                            </div>
                                        </div>
                                    </td>
                                    <td class="cart__price">${listallLigneCommande_ProdVente_Total.get(i+1).getPrix()} DH</td>
                                    <td class="cart__total">${listallLigneCommande_ProdVente_Total.get(i+1).getTaille()}</td>
                                    <td class="cart__total">${listallLigneCommande_ProdVente_Total.get(i+1).getCouleur()}</td>
                                    <td class="cart__quantity">
                                        <div class="pro-qty">
                                          <input type="text" style="color:#CA1616; font-weight: bold;" value="${listallLigneCommande_ProdVente_Total.get(i).getQuantite()}" >
                                        </div>
                                    </td>
                                  <td class="cart__close"><span class="icon_close"></span></td> 
                                </tr>
  </c:forEach>                         
                              
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-lg-6">
                 
                </div>
                 <div class="col-lg-6">
                   <div class="cart__total__procced">
                        <h6>Cart total</h6>
                        <ul>
                           <!--  <li>Subtotal <span>$ 750.0</span></li> -->
                            <li>Total Panier <span>${listallLigneCommande_ProdVente_Total.get(listallLigneCommande_ProdVente_Total.size()-1)} </span></li>
                        </ul>
                   <%--      <a href="/AssociationMarket/Panier/validerComModePaiem.jsp?montantCommande=${listallLigneCommande_ProdVente_Total.get(listallLigneCommande_ProdVente_Total.size()-1)} " class="primary-btn">Valider Commande</a>
                    --%>    <a href="/AssociationMarket/acheterValiderCommander " class="primary-btn">Valider Commande</a>
                   
                    </div>
                </div>
            </div>
       
  </c:when> 
  <c:otherwise>
  <%@ include file="/Client/sidebarClient.jsp" %>	
 <h1 style="margin-left: auto; margin-right: auto; margin-top: 30%}"> ${listallLigneCommande_ProdVente_Total.get(0) }</h1>
  </c:otherwise>
</c:choose>
      
        </div>
    </section>
    <!-- Shop Cart Section End -->

    

    <!-- Footer Section Begin -->
    <footer class="footer">
        <div class="container">
            <div class="row">
                <div class="col-lg-4 col-md-6 col-sm-7">
                    <div class="footer__about">
                        <div class="footer__logo">
                            <a href="./index.html"><img src="img/logo.png" alt=""></a>
                        </div>
                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt
                        cilisis.</p>
                        <div class="footer__payment">
                            <a href="#"><img src="img/payment/payment-1.png" alt=""></a>
                            <a href="#"><img src="img/payment/payment-2.png" alt=""></a>
                            <a href="#"><img src="img/payment/payment-3.png" alt=""></a>
                            <a href="#"><img src="img/payment/payment-4.png" alt=""></a>
                            <a href="#"><img src="img/payment/payment-5.png" alt=""></a>
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
    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.magnific-popup.min.js"></script>
    <script src="js/jquery-ui.min.js"></script>
    <script src="js/mixitup.min.js"></script>
    <script src="js/jquery.countdown.min.js"></script>
    <script src="js/jquery.slicknav.js"></script>
    <script src="js/owl.carousel.min.js"></script>
    <script src="js/jquery.nicescroll.min.js"></script>
    <script src="js/main.js"></script>
</body>

</html>