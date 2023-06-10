<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Cookie&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;500;600;700;800;900&display=swap"
    rel="stylesheet">

    <!-- Css Styles -->
    <link rel="stylesheet" href="<%= request.getContextPath() %>/frontend/css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/frontend/css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/frontend/css/elegant-icons.css" type="text/css">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/frontend/css/jquery-ui.min.css" type="text/css">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/frontend/css/magnific-popup.css" type="text/css">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/frontend/css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/frontend/css/slicknav.min.css" type="text/css">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/frontend/css/style.css" type="text/css">

</head>
<body>
    <!-- Offcanvas Menu Begin -->
    <div class="offcanvas-menu-overlay"></div>
    <div class="offcanvas-menu-wrapper">
        <div class="offcanvas__close">+</div>
        <ul class="offcanvas__widget">
            <li><span class="icon_search search-switch"></span></li>
            <li><a href="#"><span class="icon_heart_alt"></span>
                <div class="tip">2</div>
            </a></li>
            <li><a href="#"><span class="icon_bag_alt"></span>
                <div class="tip">2</div>
            </a></li>
        </ul>
        <div class="offcanvas__logo">
            <a href="<%= request.getContextPath() %>/Client/index.jsp">   AssoMarket
           <!--   <img src="img/logo.png" alt=""> -->
            </a>
        </div>
        <div id="mobile-menu-wrap"></div>
        <div class="offcanvas__auth">
            <a href="./Client/profileClient.jsp">${ sessionScope.NomClient}</a>
            <a href="#">LogOut</a>
        </div>
    </div>
    <!-- Offcanvas Menu End -->

    <!-- Header Section Begin -->
    <header class="header">
        <div class="container-fluid">
            <div class="row">
                <div class="col-xl-3 col-lg-2">
                    <div class="header__logo">
                        <a href="<%= request.getContextPath() %>/Client/index.jsp"> <h3> AssoMarket </h3>
                    <!--   <img src="img/logo.png" alt=""> -->  
                        </a>
                    </div>
                </div>
                <div class="col-xl-6 col-lg-7"> 
                
                    <nav class="header__menu">
                        <ul>
                            <li class="active"><a href="<%= request.getContextPath() %>/Client/index.jsp">Home</a></li>                      
                            <li>
                            <!--  ajouter ce lien il faut ajouter select * from ProdVente-->
                           <a> <!-- <a href="<%= request.getContextPath() %>/Client/shopClient.jsp" target="_blank">   -->
                            Shop/Categories
                      </a>
                            <ul class="dropdown">
                                    <li><a href="<%= request.getContextPath() %>/produitVenteByCat?idCategorie_ProdVen=${1}">Alimentation</a></li>                                  
                                    <li><a href="<%= request.getContextPath() %>/produitVenteByCat?idCategorie_ProdVen=${2}">Cosmetiques</a></li>
                                    <li><a href="<%= request.getContextPath() %>/produitVenteByCat?idCategorie_ProdVen=${3}">Vetement & Fashion</a></li>
                                    <li><a href="<%= request.getContextPath() %>/produitVenteByCat?idCategorie_ProdVen=${4}">Maison & Deco</a></li>
                                    <li><a href="<%= request.getContextPath() %>/produitVenteByCat?idCategorie_ProdVen=${5}">Accessoires</a></li>
                                </ul>
                            </li>
                            <li><a >
                            		<c:choose>
										 <c:when test="${not empty sessionScope.IdClient}">
											  <a href="<%= request.getContextPath() %>/Client/ajouterDon.jsp" > 
										  			Faire un Don
										  	  </a>
									     </c:when> 
									     <c:otherwise>
										      <a href="<%= request.getContextPath() %>/Client/clientLogin.jsp" > 
										     	Faire un Don
										      </a>
										 </c:otherwise>
									</c:choose>										    
								</a></li>
                            <!-- <li><a href="#">Pages</a>
                                <ul class="dropdown">
                                    <li><a href="./product-details.html" target="_blank">Product Details</a></li>
                                    <li><a href="./shop-cart.html">Shop Cart</a></li>
                                    <li><a href="./checkout.html">Checkout</a></li>
                                    <li><a href="./blog-details.html">Blog Details</a></li>
                                </ul>
                            </li> -->
                           <!--  <li><a href="./blog.html">Blog</a></li> -->
                            <li><a href="<%= request.getContextPath() %>/homeParts/contact.jsp">Contact</a></li>
                        </ul>
                    </nav>
                </div>
                <div class="col-lg-3">
                    <div class="header__right">
                        <div class="header__right__auth">
                           
		                            <c:choose>
										<c:when test="${not empty sessionScope.NomClient || sessionScope.NomBeneficiaire }">
											<c:choose>
											    <c:when test="${not empty sessionScope.NomClient}">
											       <a href="<%= request.getContextPath() %>/Client/profilClient.jsp" > 
										  			<c:out value ="${ sessionScope.NomClient }"/>
										  		   </a>
											    </c:when>    
											    <c:when test="${not empty sessionScope.NomClient}">
											       <a href="<%= request.getContextPath() %>/Beneficiaire/profilBeneficiaire.jsp" > 
										  			<c:out value ="${ sessionScope.NomBeneficiaire }"/>
										  		   </a>
											    </c:when> 
											  </c:choose>												
										  </c:when>
										  <c:otherwise>
										   <a href="<%= request.getContextPath() %>/Client/clientLogin.jsp" > 
										     Login 
										     </a>
										  </c:otherwise>
									</c:choose>
                          
            				<a href="/AssociationMarket/logout">LogOut</a>
                        </div>
                        <ul class="header__right__widget">
                            <li><span class="icon_search search-switch"></span></li>
                            <li><a href="#"><span class="icon_heart_alt"></span>
                               <!--  <div class="tip">2</div> -->
                            </a></li>
                            <li><a href="/AssociationMarket/afficherPanier_AllLigneCom"><span class="icon_bag_alt"></span>
                               <!--  <div class="tip">2</div> -->
                            </a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="canvas__open">
                <i class="fa fa-bars"></i>
            </div>
        </div>
    </header>
    <!-- Header Section End -->
