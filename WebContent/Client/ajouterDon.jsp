<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Faire Don</title>




<%@ include file="../Client/sidebarClient.jsp" %>	


      
      <div class="col-lg-9 col-md-9">

                <form action="/AssociationMarket/donAdd" method="POST"  class="checkout__form">
				<div class="col-lg-8">
                        <h5>Faire Don</h5>
                        <div class="row">
                        	<div class="col-lg-12">
                       		   <div class="checkout__form__input">
                                    <p>Association  <span>*</span> </p>
                                    
                                    <select style=" height: 90%" name="idAsso_don" class="form-control" >                                   	
										<c:forEach items="${ listAllAssociation }" var="Association" varStatus="boucle">
										<option value="${ Association.getIdAsso()}">${ Association.getNomAsso()}</option>   
										</c:forEach>                          
                                    </select>                                                                 
                               </div>
                            </div><br/>
                            <div class="col-lg-6 col-md-6 col-sm-6">
                                <div class="checkout__form__input">
                                    <p>typeDon <span>*</span></p>
                                    <input type="text" name="typeDon" class="form-control">
                                </div>
                            </div>
                            <div class="col-lg-6 col-md-6 col-sm-6">
                                <div class="checkout__form__input">
                                    <p>Categories don <!-- <span>*</span> --></p>
                                    <input type="text" name="categories"class="form-control">
                                </div>
                            </div>
                            <div class="col-lg-12">
                                <div class="checkout__form__input">
                                    <p>Nombre du pièce de votre don <span>*</span></p>
                                    <input type="text" name="nbrProd"class="form-control">
                                </div>
                                
                                <div class="checkout__form__input">
                                    <p>Description don <!-- <span>*</span> --></p>
                                    <input type="text" name="description"class="form-control">
                                </div>
                                <div class="checkout__form__input">
                                    <p>Date d'Ajout de votre don <!-- <span>*</span> --></p>
                                      <fmt:formatDate var="fmtDate" value="<%=new java.util.Date()%>" pattern="yyyy/MM/dd HH:mm:ss"/> 
						              <input type="text" name="dateDon" value="${fmtDate}" placeholder="${fmtDate}" readonly class="form-control">
                            
                            
                          
                                
                                <button type="submit" class="site-btn">Ajouter</button> 
                               </div> <!--  //row -->
                            
                           </div> 
                       </div> 
               </div> 
                           
                    
                   
            </form>
            </div>
      

  
             
</body>
</html>