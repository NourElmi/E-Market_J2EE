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
                <form action="#" class="checkout__form">
				<div class="col-lg-8">
                        <h5>Profil detail</h5>
                        <div class="row">
                             <div class="col-lg-12">
                                <div class="checkout__form__input">
                                    <p>Nom Association <span>*</span></p>
                                    <input type="text" name="nomBenefi" value=" ${beneficiaire.getNomBenefi() }" readonly class="form-control">
                                </div>
                            </div>
                            <div class="col-lg-6 col-md-6 col-sm-6">
                                <div class="checkout__form__input">
                                    <p>Nom du responsable <span>*</span></p>
                                    <input type="text" name="nomRespo" value=" ${association.getNomRespo() }" readonly class="form-control">
                                </div>
                            </div>
                            <div class="col-lg-6 col-md-6 col-sm-6">
                                <div class="checkout__form__input">
                                    <p>Prenom du responsable <span>*</span></p>
                                    <input type="text" name="prenomRespo" value=" ${association.getPrenomRespo() }" readonly class="form-control">
                                </div>
                            </div>
                            <div class="col-lg-12">
                                <div class="checkout__form__input">
                                    <p>email <span>*</span></p>
                                    <input type="text" name="email" value=" ${association.getEmail() }" readonly class="form-control">
                                </div>
                               
                                <div class="checkout__form__input">
                                    <p>telephone de l'association <span>*</span></p>
                                    <input type="text" name="telephoneAsso" value=" ${association.getTelephoneAsso() }" readonly class="form-control">
                                </div>
                                <div class="checkout__form__input">
                                    <p>localisation <span>*</span></p>
                                    <input type="text" name="localisation" value=" ${association.getLocalisation() }" readonly class="form-control">
                                </div>
                                <div class="checkout__form__input">
                                    <p>ville <span>*</span></p>
                                    <input type="text" name="ville" value=" ${association.getVille() }" readonly class="form-control">
                                </div>
                                  <div class="checkout__form__input">
                                      <p>secteur <span>*</span></p>
                                    <input type="text" name="secteur" value=" ${association.getSecteur() }" readonly class="form-control">
                                </div>
                                  <div class="checkout__form__input">
                                    <p>nbrJourRecuProd <span>*</span></p>
                                    <input type="text" name="nbrJourRecuProd" value=" ${association.getNbrJourRecuProd() }" readonly class="form-control">
                                </div>
                                
                              </div>
                            </div>
                            
                            
                            
                                
                                
                                <button type="submit" class="site-btn">Modifier</button> 
                            </div> <!--  //row -->
                            
                       </div>     
                    
                   
            </form>
            </div>
      

  
             
</body>
</html>