<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
    <meta name="description" content="Ashion Template">
    <meta name="keywords" content="Ashion, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
<meta charset="UTF-8">
<title>Insert title here</title>



<%@ include file="../Association/associationSidebar.jsp" %>

 <div class="col-lg-9 col-md-9">

                <form action="../beneficiaireModif" method="POST"  class="checkout__form">
				<div class="col-lg-8">
                        <h5>formulaire de modification  des infos d' un beneficiaire</h5>
                       <input type="hidden" name="idBeneficiaire" value="${beneficiaire.getIdBeneficiaire()}" class="form-control">					
                        
                        <div class="row">
                            <div class="col-lg-6 col-md-6 col-sm-6">
                                <div class="checkout__form__input">
                                    <p>nomBenefi<span>*</span></p>
                                    <input type="text" name="nomBenefi" value=" ${beneficiaire.getNomBenefi() }" class="form-control">
                                </div>
                            </div>
                            <div class="col-lg-6 col-md-6 col-sm-6">
                                <div class="checkout__form__input">
                                    <p>prenomBenefi <span>*</span></p>
                                    <input type="text" name="prenomBenefi" value=" ${beneficiaire.getPrenomBenefi() }" class="form-control">
                                </div>
                            </div>
                            <div class="col-lg-12">
                                <div class="checkout__form__input">
                                    <p> login <span>*</span></p>
                                    <input type="text" name="login" value=" ${beneficiaire.getLogin() }"  class="form-control">
                                </div>
                                
                                <div class="checkout__form__input">
                                    <p>password <span>*</span></p>
                                    <input type="text" name="password" value=" ${beneficiaire.getPassword() }" class="form-control">
                                </div>
                                
                                <div class="checkout__form__input">
                                    <p>numTel <span>*</span></p>
                                    <input type="number" name="numTel" value=" ${beneficiaire.getNumTel() }" class="form-control">
                                </div>
                                
                               
                                <div class="checkout__form__input">
                                    <p>adresse <span>*</span></p>
                                    <input type="text" name="adresse" value=" ${beneficiaire.getAdresse() }" class="form-control">
                                </div>
                                
                                <div class="checkout__form__input">
                                    <p>genre <span>*</span></p>
                                    <input type="radio" name="genre" value="male"  value=" ${beneficiaire.getGenre() }" class="form-control"> Male
                                    <input type="radio" name="genre" value="female" value=" ${beneficiaire.getGenre() }"  class="form-control"> Female
							
                                </div>
                                
                                <div class="checkout__form__input">
                                    <p>dateNaissance <span>*</span></p>
                                    
                                    <input type="date" name="dateNaissance"  value=" ${beneficiaire.getDateNaissance() }"class="form-control">
                                </div>
                                
                                <div class="checkout__form__input">
                                   
                            
                          
                                
                                <button type="submit" class="site-btn">Ajouter</button> 
                               </div> <!--  //row -->
                            
                           </div> 
                       </div> 
               </div> 
                           
                    
                   
            </form>
            </div>
      
</body>
</html>