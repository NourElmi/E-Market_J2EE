
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

<title>Ajouter Produit a Donner</title>


<%@ include file="../Association/associationSidebar.jsp" %>


       <div class="col-lg-9 col-md-9">
                <form action="/AssociationMarket/addProdADonnerIMg" method="POST"  enctype= multipart/form-data class="checkout__form">
				<div class="col-lg-8">
                        <h5>Ajouter un produit a donner</h5>
                        <div class="row">
                        
                             <div class="col-lg-12">
                                <div class="checkout__form__input">
                                    <p>lib_Prod<span>*</span></p>
                                    <input type="text" name="lib_Prod" class="form-control">
                                </div>
                            </div>
                            <div class="col-lg-6 col-md-6 col-sm-6">
                                <div class="checkout__form__input">
                                    <p>descProd <span>*</span></p>
                                    <input type="text" name="descProd" class="form-control">
                                </div>
                            </div>
                            <div class="col-lg-6 col-md-6 col-sm-6">
                                <div class="checkout__form__input">
                                    <p>Image <span>*</span></p>
                                  <input type="file" name="image" class="form-control"><c:out value="${fichier}" />
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
                 
                                
                                <button type="submit" class="site-btn">Ajouter Produit</button> 
                            </div> <!--  //row -->
                            
                     
                    
                   
            </form>
            </div>
      

		
	</body>
</html>