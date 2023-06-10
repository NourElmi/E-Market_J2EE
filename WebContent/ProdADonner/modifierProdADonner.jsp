
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

<title>Modifier Produit a Donner</title>


<%@ include file="../Association/associationSidebar.jsp" %>


 <div class="col-lg-9 col-md-9">
               <form action="/AssociationMarket/modifierProdADonner" method="POST" enctype= multipart/form-data class="checkout__form">
				<div class="col-lg-8">
                        <h5>Modifier produit a donner</h5>
                        <div class="row">
                        						
                        
                             <div class="col-lg-12">
                                <div class="checkout__form__input">
                                <input type="hidden" name="idProduit" value="${ProdADonner.getIdProduit()}" class="form-control">
                                    <p>lib_Prod<span>*</span></p>
                                    <input type="text" name="lib_Prod" value=" ${ProdADonner.getLib_Prod() }" class="form-control">
                                </div>
                            </div>
                            <div class="col-lg-6 col-md-6 col-sm-6">
                                <div class="checkout__form__input">
                                    <p>descProd <span>*</span></p>
                                    <input type="text" name="descProd" value=" ${ProdADonner.getDescProd() }"  class="form-control">
                                </div>
                            </div>
                            <div class="col-lg-6 col-md-6 col-sm-6">
                                <div class="checkout__form__input">
                                    <p>Image <span>*</span></p>
                                  <input type="file" name="image" value=" ${ProdADonner.getImage() }" class="form-control">
                                </div>
                            </div>
                            <div class="col-lg-12">
                               <!--  <div class="checkout__form__input">
                                    <p>idAsso_Prod <span>*</span></p>
                                     <input type="text" name="idAsso_Prod" class="form-control"> 
                                </div>
                                -->
                                <div class="checkout__form__input">
                                
                                    <p>dateAjout <span>*</span></p>
                                    <fmt:formatDate var="fmtDate" value="<%=new java.util.Date()%>" pattern="yyyy/MM/dd HH:mm:ss"/> 
						<input type="text" name="dateAjout" value="${fmtDate}" placeholder="${fmtDate}" readonly class="form-control">
					</div>
                                    
                              </div>
                            </div>
                 
                                
                                <button type="submit" class="site-btn">Modifier Produit</button> 
                            </div> <!--  //row -->
                            
                     
                    
                   
            </form>
            </div>
      

		
	</body>
</html>

		<%-- <div class="wrapper" style="background-image: url('addFormTemplate/images/bg-registration-form-2.jpg');">
			<div class="inner">
				<form action="modifierProdADonner" method="POST">
				
					<h3>Modifier Produit</h3>
					<input type="hidden" name="idProduit" value="${ProdADonner.getIdProduit()}" class="form-control">					
					<div class="form-group">
						<div class="form-wrapper">
							<label for="">lib_Prod</label>
							<input type="text" name="lib_Prod" value=" ${ProdADonner.getLib_Prod() }" class="form-control">
						</div>
						<div class="form-wrapper">
							<label for="">description Produit </label>
							<input type="text" name="descProd" value=" ${ProdADonner.getDescProd() }" class="form-control">
						</div>
					</div>
					<div class="form-wrapper">
						<label for="">image</label>
						<input type="text" name="image" value=" ${ProdADonner.getImage() }" class="form-control">
					</div>
					<div class="form-wrapper">
						<label for="">Date d'Ajout</label>
						<fmt:formatDate var="fmtDate" value="<%=new java.util.Date()%>" pattern="yyyy/MM/dd HH:mm:ss"/> 
						<input type="text" name="dateAjout" value="${fmtDate}" placeholder="${fmtDate}" readonly class="form-control">
					</div>
					<div>
					<input type="submit" value="Confirmer">
					<input type="reset" value="Annuler">
					</div>
				</form>
			</div>
		</div>
		
	</body>
</html> --%>