<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<%@ include file="/homeParts/HeaderAssociation.jsp" %>	
 
 
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
<!-- Shop Section Begin -->
    <section class="shop spad">
        <div class="container " style=" margin-left: 0px">
            <div class="row ">
                <div class="col-lg-3 col-md-3">
	                
                    <div class="shop__sidebar">
                        <div class="sidebar__categories">
                            <div class="section-title">
                                
                                 <h4>Association ${ sessionScope.NomAsso } </h4>
                            </div>
                            <div class="categories__accordion">
                                <div class="accordion" id="accordionExample">
                                      <div class="card">
                                        <div class="card-heading">
                                            <a href="<%= request.getContextPath() %>/ProfileAssociation"> Profile </a>
                                        </div>                                     
                                    </div>
                                
                                    <div class="card">
                                        <div class="card-heading">
                                            <a href="<%= request.getContextPath() %>/donAllAssociation"> Don reçu </a>
                                        </div>                                     
                                    </div>
                                      
                                    
                                    <div class="card">
                                        <div class="card-heading">
                                            <a data-toggle="collapse" data-target="#collapseFive">Showroom des produits</a>
                                        </div>
                                        <div id="collapseFive" class="collapse show" data-parent="#accordionExample">
                                            <div class="card-body">
                                                <ul>
                                                    <li><a href="<%= request.getContextPath() %>/allProdADonner">Produits à donner</a></li>
                                                    <li><a href="<%= request.getContextPath() %>/produitVenteAllByAsso">Produits à vendre</a></li>                                
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>                         
                        </div>     
                </div>
 
            </div>
 
 
    
        	    
    
    